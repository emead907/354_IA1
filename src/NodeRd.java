import java.util.Scanner;

public class NodeRd extends Node{

    private String id;
    private static Scanner scanner = null;

    public NodeRd(String id){
        this.id = id;
    }

    public double eval(Environment env) throws EvalException {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return env.get(this.pos,this.id);
    }
}
