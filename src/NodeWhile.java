public class NodeWhile extends Node {

    BoolExpresion nodeWhile;
    NodeStmt doNode;

    public NodeWhile(BoolExpresion nodeWhile, NodeStmt doNode) {
        this.nodeWhile = nodeWhile;
        this.doNode = doNode;
    }

    public double eval(Environment environment) {
        return 0;
    }
}
