public class NodeStmt extends Node {

    private NodeAssn assn;

    /**
     * Assigns the nodes assn to assn
     * @param assn the assn value that will be assigned to node
     */
    public NodeStmt(NodeAssn assn) {
	this.assn=assn;
    }

    /**
     * Evalutes assn
     * @param env the enviorment that is being used
     * @return the evaluation of assn
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
	return assn.eval(env);
    }

}
