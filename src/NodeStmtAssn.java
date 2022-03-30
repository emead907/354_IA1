import java.net.StandardSocketOptions;

public class NodeStmtAssn extends NodeStmt{
    private NodeAssn assn;

    /**
     * Assigns the nodes assn to assn
     * @param assn the assn value that will be assigned to node
     */
    public NodeStmtAssn(NodeAssn assn) {
        this.assn=assn;
    }
    public double eval(Environment env) throws EvalException {
        return assn.eval(env);
    }


}
