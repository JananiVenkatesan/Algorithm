/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Description: RandomGenerator class, generate four random constants and three random operators
*/

import java.util.Random;

public class RandomGenerator{
	static Random r = new Random();
	// define constants
	Node[] con;

	public RandomGenerator(){
		// generate four Const nodes
		con = new Const[4];
		for(int i=0; i<4; i++)
			con[i] = randomConstant();
	}

	// generate random Const node
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
					generateOper(operInt[0],con[0],con[1]),
					generateOper(operInt[2],con[2],con[3])
			      );
		// return root of tree
		return n;
	}
}

