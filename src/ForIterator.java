import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ForIterator {
    private int[] indices;              /* indices to record progress on each list */
    private List<List<Node>> lists;     /* lists that store actual data content */
    private boolean accessed = false;   /* if next() is used? */
    private String[] varNames;          /* variable names (of those lists) */

    public ForIterator(String[] vars, List<List<Node>> lists) {
        this.lists = new ArrayList<List<Node>>();
        indices = new int[lists.size()];
        for (int i = 0; i < lists.size() - 1; i++)
            indices[i] = 0;
        indices[indices.length-1] = -1; // to prevent bug when next() is called the first time.

        for (int i = lists.size() - 1; i >= 0; i--)
            this.lists.add(lists.get(i));
        varNames = vars;
    }

    public String getVarName(int i) {
        return this.varNames[i];
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

    public List<Node> next() {
        accessed = true;
        int carry = 1;
        ArrayList<Node> out = new ArrayList<>();

        /* loop updates the indices until carry=0 */
        for (int i = 0; carry != 0 && i < indices.length; i++) {
            if (lists.get(i).size() == 0) {
                out.add(null);
                continue;
            }
            int old = indices[i];
            indices[i] = (indices[i] + 1) % (this.lists.get(i).size());
            if (indices[i] > old) // if no overflow
                carry = 0;
            out.add(lists.get(i).get(indices[i]));
        }
        return out;
    }
}
