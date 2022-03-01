public class NodeTerm extends Node {

    private NodeFact fact;
    private NodeMulop mulop;
    private NodeTerm term;

    public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
	this.fact=fact;
	this.mulop=mulop;
	this.term=term;
    }

	/**
	 * Updates the Nodes information based on a new term
	 * @param term the new term
	 */
    public void append(NodeTerm term) {
	if (this.term==null) {
	    this.mulop=term.mulop;
	    this.term=term;
	    term.mulop=null;
	} else
	    this.term.append(term);
    }

	/**
	 * Not gonna lie im not finalular with this syntax and have no idea whats going on
	 * @param env the enviorment that is being used
	 * @return soemthing important im sure
	 * @throws EvalException
	 */
    public double eval(Environment env) throws EvalException {
	return term==null
	    ? fact.eval(env)
	    : mulop.op(term.eval(env),fact.eval(env));
    }

}
