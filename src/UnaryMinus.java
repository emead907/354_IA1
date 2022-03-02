public class UnaryMinus extends NodeFact{
    private NodeFact node;

    public UnaryMinus(NodeFact node){
        this.node = node;
    }

    @Override
    public double eval(Environment env) throws EvalException {
        return -node.eval(env);
    }
}
