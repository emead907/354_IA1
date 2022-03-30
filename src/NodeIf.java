import java.util.Scanner;

public class NodeIf extends Node{
    private BoolExpresion ifNode;
    private NodeStmt thenNode;
    private NodeStmt elseNode;

    public NodeIf(BoolExpresion ifNode, NodeStmt thenNode, NodeStmt elseNode){
        this.elseNode = elseNode;
        this.ifNode = ifNode;
        this.thenNode = thenNode;
    }
    public double eval(Environment environment) throws EvalException {
       if(ifNode.eval(environment) == 0){
           if(elseNode == null){
               return 0;
           }
           else{
               elseNode.eval(environment);
           }
       }
       else{
           return thenNode.eval(environment);
       }
       return 0;
    }
}
