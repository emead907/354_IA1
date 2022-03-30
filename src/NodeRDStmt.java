public class NodeRDStmt extends NodeStmt {

    private NodeRd rdNode;

    public NodeRDStmt(NodeRd nodeRd){
        this.rdNode = nodeRd;
    }
    public double eval(Environment env) throws EvalException {
        return rdNode.eval(env);
    }

}
