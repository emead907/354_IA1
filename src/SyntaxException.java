public class SyntaxException extends Exception {

    private int pos;
    private Token expected;
    private Token found;

    public SyntaxException(int pos, Token expected, Token found) {
	this.pos=pos;
	this.expected=expected;
	this.found=found;
    }

    /**
     * toString method for the StntaxException
     * @return a string that
     */
    public String toString() {
	return "syntax error"
	    +", pos="+pos
	    +", expected="+expected
	    +", found="+found;
    }

}
