// This class, and its subclasses,
// collectively model parse-tree nodes.
// Each kind of node can be eval()-uated.

public abstract class Node {

    protected int pos=0;

    /**
     * this is the method that is used when there is an error evaluating a node
     * @param env the enviorment that is being used
     * @return a double that is the respose to the evaluation
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
	throw new EvalException(pos,"cannot eval() node!");
    }

}
