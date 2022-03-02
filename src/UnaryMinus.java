/**
 * This class is what deals with muiltiple minus signs.
 * When there is more then one it will make sure to keep
 * track if the number is positive or negitive
 */
public class UnaryMinus extends NodeFact{
    private NodeFact node;

    /**
     * Creates a new NodeFact that will be used to keep track of the
     * current sign standing the of number
     * @param node
     */
    public UnaryMinus(NodeFact node){
        this.node = node;
    }

    /**
     * Switches the sign of the node accordinly
     * @param env the enviorment that is being used
     * @return the node with the current negitive or positive flag
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
        return -node.eval(env);
    }
}
