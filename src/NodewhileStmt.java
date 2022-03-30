public class NodewhileStmt extends NodeStmt{
    NodeWhile nodeWhile;

    public NodewhileStmt(NodeWhile nodeWhile){
        this.nodeWhile= nodeWhile;
    }

    public double eval(Environment env) throws EvalException {
        double answer = 0;
        while(nodeWhile.nodeWhile.eval(env) == 1.0){
            answer = nodeWhile.doNode.eval(env);
        }
        return answer;
    }
}
