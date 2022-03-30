public class NodeBlockStmt extends NodeStmt{
    private NodeBlock block;

    /**
     * Assigns the nodes assn to assn
     * @param block the assn value that will be assigned to node
     */
    public NodeBlockStmt(NodeBlock block) {
        this.block=block;
    }
    public double eval(Environment env) throws EvalException {
        return block.eval(env);
    }
}
