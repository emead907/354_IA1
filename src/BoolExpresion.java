public class BoolExpresion {
    private NodeRelop relop;
    private NodeExpr exprOne;
    private NodeExpr exprTwo;

    public BoolExpresion(NodeRelop relop, NodeExpr exprOne, NodeExpr exprTwo){
        this.exprOne = exprOne;
        this.exprTwo = exprTwo;
        this.relop = relop;
    }

    public double eval(Environment environment) throws EvalException{
        return this.relop.op(exprOne.eval(environment), exprTwo.eval(environment));
    }
}
