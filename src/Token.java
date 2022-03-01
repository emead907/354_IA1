// This class models a token, which has two parts:
// 1) the token itself (e.g., "id" or "+")
// 2) the token's lexeme (e.g., "foo")

public class Token {

    private String token;
    private String lexeme;

    /**
     * Creates a new token that has a token value and a lexeme value
     * @param token the value that will be saved as the tokens token value
     * @param lexeme the String that will be saved as the token lexeme value
     */
    public Token(String token, String lexeme) {
	this.token=token;
	this.lexeme=lexeme;
    }

    /**
     * sets the tokens token
     * @param token the String value that will be saved as the tokens new token
     */
    public Token(String token) {
	this(token,token);
    }

    /**
     * Tok returns the value of the tokens token
     * @return the tokens token value
     */
    public String tok() { return token; }

    /**
     * the getting for the tokens lexeme
     * @return the String value of the tokens lexeme
     */
    public String lex() { return lexeme; }

    /**
     * Checks and sees if the this.token is equal to the
     * token being passed in.
     * @param t the token that will be compared to the this.token
     * @return true if the two tokens are == else returns false
     */
    public boolean equals(Token t) {
	return token.equals(t.token);
    }

    /**
     * Creates a string that shows the tokens token value and lexeme value
     * @return a string denoting the tokens inforamtion
     */
    public String toString() {
	return "<"+tok()+","+lex()+">";
    }

}
