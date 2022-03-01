public class EvalException extends Exception {

    private int pos;
    private String msg;

    /**
     * Creates a EvalException that includes a position and a message
     * @param pos the position that is being evaluated
     * @param msg the message that is about the thing at the postion
     */
    public EvalException(int pos, String msg) {
	this.pos=pos;
	this.msg=msg;
    }

    /**
     * Concatinates a sting that is to be returned
     * @return A sting that informs the user there is an erroe
     */
    public String toString() {
	return "eval error"
	    +", pos="+pos
	    +", "+msg;
    }

}
