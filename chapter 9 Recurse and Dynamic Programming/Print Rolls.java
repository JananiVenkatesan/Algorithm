/*
X.printRolls(2)
	11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26, …. 65, 66

X.printRolls(3)
	111, 112, 113, … 121, 122, 123, … 
*/
class X {
	public static printRolls(int numDice) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		if(numDice == 0)
				return;
			printRolls(numDice, l);
		  }
		private void printRolls(int numDice, ArrayList<Integer> l){
			if(numDice == 0){
				printPath(l);
			return;
		}
			for(int i = 1; i <= 6; i ++){
			l.add(i);
			printRolls(numDice - 1, l);
			l.remove(l.size() - 1);
		}
	}
	private void printPath(ArrayList<Integer> l){
		for(Integer i : l){
			System.out.print(i);
		}
		System.out.println();
	}
}



