/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Description: Mult class, lChild * rChild
*/

public class Mult extends Binop{
	public Mult(Node l, Node r){
        super(l, r);
    }
    
    public double eval(){
        return lChild.eval() * rChild.eval();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("("+lChild.toString());
        sb.append(" * ");
        sb.append(rChild.toString()+")");

        return sb.toString();
    }
}