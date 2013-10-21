/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Description: Node class, super class of Const, Binop, Plus, Minus, Mult, Divide class.
*/
import java.util.Random;

public abstract class Node implements Cloneable{    
	protected Node lChild, rChild;
	public int depth;
	// constructor
	public Node(){
		depth = 0;
	}
	
    public void setChild(int position, Node n){
    	if(position == 0)
    		lChild = n;
    	else if(position == 1)
    		rChild = n;
	}
    
	public double eval(double[] data){
		return 0;
	}
	public String toString(){
		return super.toString();
	}
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        }catch(Exception e) {
            System.out.println("Node can't clone.");
        }
        return obj;
    }
    // expand the algebra tree
    public abstract void addRandomKids(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand);

}