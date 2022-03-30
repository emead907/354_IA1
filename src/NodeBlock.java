public class NodeBlock extends Node{
    private NodeStmt nodeStmtOne, nodeStmtTwo;


    public NodeBlock(NodeStmt nodeStmtOne, NodeStmt nodeStmtTwo){
       this.nodeStmtOne = nodeStmtOne;
        this.nodeStmtTwo = nodeStmtTwo;
    }


    public double eval(Environment environment) throws EvalException {
        double stmtOne = nodeStmtOne.eval(environment);
        double stmttwo = nodeStmtTwo.eval(environment);
        return stmttwo;
    }

}
