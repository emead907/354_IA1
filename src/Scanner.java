// This class is a scanner for the program
// and programming language being interpreted.

import java.util.*;

public class Scanner {

    private String program;	// source program being interpreted
    private int pos;		// index of next char in program
    private Token token;	// last/current scanned token

    // sets of various characters and lexemes
    private Set<String> whitespace=new HashSet<String>();
    private Set<String> digits=new HashSet<String>();
    private Set<String> letters=new HashSet<String>();
    private Set<String> legits=new HashSet<String>();
    private Set<String> keywords=new HashSet<String>();
    private Set<String> operators=new HashSet<String>();
	private Set<String> comments = new HashSet<String>();

    // initializers for previous sets

	/**
	 * fill is going to iterate through chars starting at
	 * lo and ending at hi adding each char to the Set of strings
	 * s
	 * @param s is a set of strings that chars will be added to
	 * @param lo is the starting char
	 * @param hi is the ending char
	 */
    private void fill(Set<String> s, char lo, char hi) {
	for (char c=lo; c<=hi; c++)
	    s.add(c+"");
    }

	/**
	 * initWhitespace is adding a space a newline and then a tab
	 * to the Set of strings called s
	 * @param s the Set of strings that the whitespace will be added to
	 */
    private void initWhitespace(Set<String> s) {
	s.add(" ");
	s.add("\n");
	s.add("\t");
    }

	/**
	 * initDigits adds chars 0 to 9 to s
	 * @param s is the Set of strings that the chars will be added to
	 */
    private void initDigits(Set<String> s) {
	fill(s,'0','9');
    }

	/**
	 * initLetters adds chars A to Z or a to z
	 * to s
	 * @param s the set of strings that the chars will be added to
	 */
    private void initLetters(Set<String> s) {
	fill(s,'A','Z');
	fill(s,'a','z');
    }

	/**
	 * initLegigts will add all numbers and all letters to s
	 * @param s the set of strings things will be added to
	 */
    private void initLegits(Set<String> s) {
	s.addAll(letters);
	s.addAll(digits);
    }

	/**
	 * initOperators adds operation chars like + - = to s
	 * @param s the set of strings things will be added to
	 */
    private void initOperators(Set<String> s) {
	s.add("=");
	s.add("+");
	s.add("-");
	s.add("*");
	s.add("/");
	s.add("(");
	s.add(")");
	s.add(";");
    }

	/**
	 * ummmm this is empty??
	 * @param s
	 */
    private void initKeywords(Set<String> s) {

    }

	/**
	 * Inizilize the comments
	 * @param s the set of strings
	 */
	private void initComment(Set<String> s){
		s.add("@");
	}

    // constructor:
    //   - squirrel-away source program
    //   - initialize sets
    public Scanner(String program) {
	this.program=program;
	pos=0;
	token=null;
	initWhitespace(whitespace);
	initDigits(digits);
	initLetters(letters);
	initLegits(legits);
	initKeywords(keywords);
	initOperators(operators);
	initComment(comments);
    }

    // handy string-processing methods

	/**
	 * Determins if the position is the last spot in the program
	 * @return true if it at the end false if not
	 */
    public boolean done() {
	return pos>=program.length();
    }


	/**
	 * This increments the pos when there are spaces
	 * @param s is the set of strings that will be interated through
	 */
    private void many(Set<String> s) {
	while (!done() && s.contains(program.charAt(pos)+""))
	    pos++;
    }
    
    // This method advances the scanner,
    // until the current input character
    // is just after a sequence of one or more
    // of a particular character.
    // Arguments:
    //     c = the character to search for
    // Members:
    //     program = the scanner's input
    //     pos = index of current input character
    private void past(char c) {
	while (!done() && c!=program.charAt(pos))
	    pos++;
	if (!done() && c==program.charAt(pos))
	    pos++;
    }

    // scan various kinds of lexeme

	/**
	 * nextNumber() is going to make a new token for the next
	 * number in the program
	 */
    private void nextNumber() {
	int old=pos;
	many(digits);
	token=new Token("num",program.substring(old,pos));
    }

	/**
	 * nextKwID is going to make a new token for the next
	 * 	keyword in the program
	 */
    private void nextKwId() {
	int old=pos;
	many(letters);
	many(legits);
	String lexeme=program.substring(old,pos);
	token=new Token((keywords.contains(lexeme) ? lexeme : "id"),lexeme);
    }

	/**
	 * nextOp() is going to make a new token for the next
	 * 	operation in the program
	 */
    private void nextOp() {
	int old=pos;
	pos=old+2;
	if (!done()) {
	    String lexeme=program.substring(old,pos);
	    if (operators.contains(lexeme)) {
		token=new Token(lexeme); // two-char operator
		return;
	    }
	}
	pos=old+1;
	String lexeme=program.substring(old,pos);
	token=new Token(lexeme); // one-char operator
    }

    // This method determines the kind of the next token (e.g., "id"),
    // and calls a method to scan that token's lexeme (e.g., "foo").

	/**
	 * next() determines the kind of the next token
	 * and then calls and collects that tokens lexeme
	 * @return true if token is not the end of file
	 */
    public boolean next() {
	many(whitespace);
	if (done()) {
	    token=new Token("EOF");
	    return false;
	}
	String c=program.charAt(pos)+"";
	if (digits.contains(c))
	    nextNumber();
	else if (letters.contains(c))
	    nextKwId();
	else if (operators.contains(c))
	    nextOp();
	else if (comments.contains(c)){
		pos++;
		past('@');
		next();
	}
	else {
	    System.err.println("illegal character at position "+pos);
	    pos++;
	    return next();
	}
	return true;
    }



	/**
	 * This method scans the next lexeme,  if the current token is the expected token.
	 * @param t the token that will be compared to this.token
	 * @throws SyntaxException
	 */
    public void match(Token t) throws SyntaxException {
	if (!t.equals(curr()))
	    throw new SyntaxException(pos,t,curr());
	next();
    }

	/**
	 * curr() checks to see if the token is null or not
	 * @return the token if not null
	 * @throws SyntaxException
	 */
    public Token curr() throws SyntaxException {
	if (token==null)
	    throw new SyntaxException(pos,new Token("ANY"),new Token("EMPTY"));
	return token;
    }

	/**
	 * The getter for position
	 * @return the current position
	 */
    public int pos() { return pos; }

    // for unit testing
    public static void main(String[] args) {
	try {
	    Scanner scanner=new Scanner(args[0]);
	    while (scanner.next())
		System.out.println(scanner.curr());
	} catch (SyntaxException e) {
	    System.err.println(e);
	}
    }

}
