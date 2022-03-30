public class NodeifStmt extends NodeStmt{

    private NodeIf ifNode;

    public NodeifStmt(NodeIf nodeIf){
        this.ifNode = nodeIf;
    }
    public double eval(Environment env) throws EvalException {
        return ifNode.eval(env);
    }
}
