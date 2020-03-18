public class MyXQueryListener extends XQueryBaseListener {
    private boolean rewritable = true;

    @Override public void enterJoinClause(XQueryParser.JoinClauseContext ctx) {
        this.rewritable = false;
    }

    public boolean isRewritable () {
        return this.rewritable;
    }
}
