public class NodeAddop extends Node {

    private String addop;

	/**
	 * Creates a new NodeAddop
	 * @param pos the position that the addop is in
	 * @param addop the acual addop itself
	 */
    public NodeAddop(int pos, String addop) {
	this.pos=pos;
	this.addop=addop;
    }

	/**
	 * The method adds or minus. Checks to see if it a addition opperator or minus opperator
	 * and performs the corispoding operation resulting in the final answer
	 * @param o1 the first double that is in the equation being evaluated
	 * @param o2 the second double that is in the equation being evaluated
	 * @return a double that reprents the final answer to the operation being preformed
	 * @throws EvalException
	 */
    public double op(double o1, double o2) throws EvalException {
	if (addop.equals("+"))
	    return o1+o2;
	if (addop.equals("-"))
	    return o1-o2;
	throw new EvalException(pos,"bogus addop: "+addop);
    }

}
