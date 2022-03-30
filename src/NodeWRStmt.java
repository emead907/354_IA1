public class NodeWRStmt extends NodeStmt {

    private NodeWr wrNode;

    public NodeWRStmt(NodeWr nodeWr){
        this.wrNode = nodeWr;
    }
    public double eval(Environment env) throws EvalException {
        return wrNode.eval(env);
    }

}
