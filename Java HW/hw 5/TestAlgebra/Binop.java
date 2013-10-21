/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Binop class, superclass of Plus, Minus, Mult, and Divide
*/

    import java.util.Random;

	public class Binop extends Node{
	    public Binop(){
	    	super();
	    }
	    public Binop(Node l, Node r){
	    	lChild = l; 
	    	rChild = r;
	    }	 
	    // expand the algebra tree
		@Override
		public void addRandomKids(OperatorFactory of, TerminalFactory tf, int maxDepth, Random rand) {
			if(depth == maxDepth){
				setChild(0, tf.getTerminal(rand));
				setChild(1, tf.getTerminal(rand));
				return;
			}
			
			if(depth < maxDepth){
				// left recursion
				int i = rand.nextInt(of.getNumOps()+tf.getNumIndepVars());
				if(i < of.getNumOps()){
					setChild(0, of.getOperator(rand));
					lChild.depth = depth + 1;
					lChild.addRandomKids(of, tf, maxDepth, rand);
				}else{
					setChild(0, tf.getTerminal(rand));				
				}
				// right recursion
				i = rand.nextInt(of.getNumOps()+tf.getNumIndepVars());
				if(i < of.getNumOps()){
					setChild(1, of.getOperator(rand));
					rChild.depth = depth + 1;
					rChild.addRandomKids(of, tf, maxDepth, rand);
				}else{
					setChild(1, tf.getTerminal(rand));				
				}
			}
			
		}    
	}
