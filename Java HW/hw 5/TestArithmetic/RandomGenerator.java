/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Description: RandomGenerator class, generate four random terminals and three random operators,
                 calculate the equation, and display it
*/

import java.util.Random;

public class RandomGenerator{
	static Random r = new Random();
	Node[] ter = new Node[4];  // define terminals
	static double[] x = new double[3];       // variable array
	
	// constructor
	public RandomGenerator(int[] xth){
		// read variable array
		for(int i = 0; i < 3; i++){
			x[i] = (double)xth[i];
		}
	
		// generate four terminals
		ter = new Node[4];
		System.out.println("");
		for(int i = 0; i < 4; i++){
			if((ter[i] = randomTerminal()) instanceof Const)
				System.out.println("Terminal "+(i+1)+" is Constant : "+((Const)ter[i]).eval(x));
			else 
				System.out.println("Terminal "+(i+1)+" is Variable : "+((Variable)ter[i]).eval(x));
		}
	}
	// for testing
	public void displayTerminal(){
		for(int i = 0; i < 4; i++){
		if(ter[i] instanceof Const)
			System.out.println(ter[i].eval(x));
		if(ter[i] instanceof Variable)
			System.out.println(((Variable)ter[i]).eval(x));
		}
	}
	// generate random Terminal
	private Node randomTerminal(){
		// flip a coin
		int i = r.nextInt(2);
		if(i == 0){  // coin comes up with head
			return randomConstant();
		}else{       // coin comes up with tail
			return randomVariable();
		}
	}
	// generate random Const
	private Const randomConstant(){
		int i; 
		// generate constant within [1, 20]
		while(true){
			i = r.nextInt(21);
			if(i!=0)
				break;
		}
		// generate Const node with the constant
		return new Const((double)i);
	}
	// generate random Variable
	private Variable randomVariable(){ 
		// generate index within {0,1,2}
		int i = r.nextInt(3);
		// generate Const node with the constant
		return new Variable(i);
	}

	// generate random operator	
	private int[] randomOperator(){
		// create random integers which are used to generate operators
		int[] operInt = new int[3]; 
		for(int i=0; i<3; i++)
			operInt[i] = r.nextInt(4);
		return operInt;
	}
	// generate operators according to different integer 0,1,2,3
	private Binop generateOper(int i, Node l, Node r){
		if(i==0)
			return new Plus(l, r);
		else if(i==1)
			return new Minus(l, r);
		else if(i==2)
			return new Mult(l, r);
		else
			return new Divide(l, r);
	}
	
	// generate arithmetic tree
	public Binop generateTree(){
		// generate random operator
		int[] operInt = randomOperator();
		// generate one arithmetic tree
		Binop n = generateOper(operInt[1],
					generateOper(operInt[0],ter[0],ter[1]),
					generateOper(operInt[2],ter[2],ter[3])
			      );
		// return root of tree
		return n;
	}
	// display the whole equation
	public static void displayTree(Binop node){
		Binop root = node; // rg[i].generateTree();
        // print out equation
        System.out.println(root.toString()+" = "+ root.eval(x));
	}
}

