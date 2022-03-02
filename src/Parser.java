// This class is a recursive-descent parser,
// modeled after the programming language's grammar.
// It constructs and has-a Scanner for the program
// being parsed.

import java.util.*;

public class Parser {

    private Scanner scanner;

	/**
	 * Checks to see if a new token in a duplicate or not
	 * @param s the string that will be made into a new token
	 * @throws SyntaxException
	 */
    private void match(String s) throws SyntaxException {
	scanner.match(new Token(s));
    }

	/**
	 * Checks to see if the current token being parsed in null or not
	 * @return the token if not null else thorws exception
	 * @throws SyntaxException
	 */
    private Token curr() throws SyntaxException {
	return scanner.curr();
    }

	/**
	 * @return the current position of the parsing
	 */
    private int pos() {
	return scanner.pos();
    }

	/**
	 * Determins and makes a new node based on what operation will be
	 * preformed
	 * @return the new node
	 * @throws SyntaxException
	 */
    private NodeMulop parseMulop() throws SyntaxException {
	if (curr().equals(new Token("*"))) {
	    match("*");
	    return new NodeMulop(pos(),"*");
	}
	if (curr().equals(new Token("/"))) {
	    match("/");
	    return new NodeMulop(pos(),"/");
	}
	return null;
    }
	/**
	 * Determins and makes a new node based on what operation will be
	 * preformed
	 * @return the new node
	 * @throws SyntaxException
	 */
    private NodeAddop parseAddop() throws SyntaxException {
	if (curr().equals(new Token("+"))) {
	    match("+");
	    return new NodeAddop(pos(),"+");
	}
	if (curr().equals(new Token("-"))) {
	    match("-");
	    return new NodeAddop(pos(),"-");
	}
	return null;
    }

	/**
	 * Determins what type of token the Fact is then
	 * @return the new node
	 * @throws SyntaxException
	 */
    private NodeFact parseFact() throws SyntaxException {
	if (curr().equals(new Token("("))) {
	    match("(");
	    NodeExpr expr=parseExpr();
	    match(")");
	    return new NodeFactExpr(expr);
	}
	if (curr().equals(new Token("id"))) {
	    Token id=curr();
	    match("id");
	    return new NodeFactId(pos(),id.lex());
	}
	if (curr().equals(new Token("-"))){
		match("-");
		NodeFact minus = parseFact();
		return new UnaryMinus(minus);
	}
	Token num=curr();
	match("num");
	return new NodeFactNum(num.lex());
    }

	/**
	 * Creates a new node for the term
	 * @return a new node
	 * @throws SyntaxException
	 */
    private NodeTerm parseTerm() throws SyntaxException {
	NodeFact fact=parseFact();
	NodeMulop mulop=parseMulop();
	if (mulop==null)
	    return new NodeTerm(fact,null,null);
	NodeTerm term=parseTerm();
	term.append(new NodeTerm(fact,mulop,null));
	return term;
    }

	/**
	 *
	 * @return the new node
	 * @throws SyntaxException
	 */
    private NodeExpr parseExpr() throws SyntaxException {
	NodeTerm term=parseTerm();
	NodeAddop addop=parseAddop();
	if (addop==null)
	    return new NodeExpr(term,null,null);
	NodeExpr expr=parseExpr();
	expr.append(new NodeExpr(term,addop,null));
	return expr;
    }

	/**
	 * parses until it finds a = sign
	 * @return the assn node that contains a lexeme and a expresion
	 * @throws SyntaxException
	 */
    private NodeAssn parseAssn() throws SyntaxException {
	Token id=curr();
	match("id");
	match("=");
	NodeExpr expr=parseExpr();
	NodeAssn assn=new NodeAssn(id.lex(),expr);
	return assn;
    }

	/**
	 * Parses a statment until it gets to a ;
	 * @return the statement from beginning to ;
	 * @throws SyntaxException
	 */
    private NodeStmt parseStmt() throws SyntaxException {
	NodeAssn assn=parseAssn();
	match(";");
	NodeStmt stmt=new NodeStmt(assn);
	return stmt;
    }

	/**
	 * parse a program from beginning to end of file creating a
	 * statement
	 * @param program
	 * @return the statement that is made
	 * @throws SyntaxException
	 */
    public Node parse(String program) throws SyntaxException {
	scanner=new Scanner(program);
	scanner.next();
	NodeStmt stmt=parseStmt();
	match("EOF");
	return stmt;
    }

}
