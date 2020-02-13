import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForIterator {
    private int[] indices;              /* indices to record progress on each list */
    private List<List<Node>> lists;     /* lists that store actual data content */
    private boolean accessed = false;   /* if next() is used? */
    private String[] varNames;          /* variable names (of those lists) */
    private MyXQueryVisitor visitor;
    private HashMap<String, List<Node>> context;
    private XQueryParser.ForClauseContext ctx;

    public ForIterator(String[] vars, XQueryParser.ForClauseContext ctx, MyXQueryVisitor v) {
        this.ctx = ctx;
        this.visitor = v; // pass in the visitor object as parameter.
        this.context = this.visitor.mem_stack.get(this.visitor.mem_stack.size()-1);
        this.lists = new ArrayList<List<Node>>();

        /* initialize lists and add initial evaluations of xq's */
        List<List<Node>> wrongorder = new ArrayList<List<Node>>();
        for (int i = 0; i < ctx.xq().size(); i++) {
            List<Node> eval = (List<Node>)this.visitor.visit(ctx.xq(i));
            wrongorder.add(eval); // store the evaluation result

            List<Node> temp = new ArrayList<>();
            temp.add(eval.size() == 0 ? null : eval.get(0));
            context.put(vars[vars.length-1-i], temp); // update context for further evaluation
        }

        /* reverse the order of wrongorder */
        for (int i = wrongorder.size()-1; i >= 0 ; this.lists.add(wrongorder.get(i)),i--);

        /* initialize indices */
        indices = new int[lists.size()];
        for (int i = 0; i < lists.size() - 1; i++)
            indices[i] = 0;
        indices[indices.length-1] = -1; // to prevent bug when next() is called the first time.

        this.varNames = vars;
    }

    private void computeXqs(int start) {
        int i = start;
        while (i > 0) {
            this.lists.set(i,(List<Node>)this.visitor.visit(ctx.xq(ctx.xq().size()-1-i)));
            i--;
        }

        /* update tracking info */
        while (i > 0)
            indices[i--] = 0;
        indices[0] = -1;
    }

    public List<Node> next() {
        accessed = true;
        int carry = 1;
        ArrayList<Node> out = new ArrayList<>();

        int overflowUntil = 0;
        /* loop updates the indices until carry=0 */
        for (int i = 0; carry != 0 && i < indices.length; i++) {
            if (lists.get(i).size() == 0) {
                out.add(null);
                continue;
            }
            int old = indices[i];
            indices[i] = (indices[i] + 1) % (this.lists.get(i).size());
            if (indices[i] > old) // if no overflow
            {
                carry = 0;
                overflowUntil = i;
            }
            out.add(lists.get(i).get(indices[i]));
        }

        /* recompute all lists after the overflow stop point */
        for (int i = overflowUntil - 1; i >= 0 ; i--) {

        }

        return out;
    }

    public boolean hasNext() {
        boolean every_at_last = true;
        boolean all_empty = true;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() == 0)
                continue;

            all_empty = false;
            if (lists.get(i).size() - 1 != indices[i]) {
                every_at_last = false;
                break;
            }
        }
        if (all_empty)
            return false;

        if (!every_at_last)
            return true;
        if (accessed)
            return false;
        else
            return true;
    }

    public String getVarName(int i) {
        return this.varNames[i];
    }
}
