public class NodeRelop extends Node{
    private String relop;

    public NodeRelop(int pos, String relop) {
        this.pos=pos;
        this.relop=relop;
    }

    public double op(double o1, double o2) throws EvalException {
        if (relop.equals("<")){
            if(o1 < 02){
                return 1.0;
            }
            else{
                return 0.0;
            }
        }
        if (relop.equals("<="))
            return o1/o2;
        if (relop.equals(">"))
            return o1*o2;
        if (relop.equals(">="))
            return o1/o2;
        if (relop.equals("<>"))
            return o1*o2;
        if (relop.equals("=="))
            return o1/o2;
        throw new EvalException(pos,"bogus mulop: "+relop);
    }

}

