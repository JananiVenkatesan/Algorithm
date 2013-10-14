/*
	Author: Bowen Li
	Andrew ID: bowenl

	Description: Checks for the reflexive, symmetric and transitive properties of the equals function
*/

public class TestTimeEquals {
    public static void main(String[] args) {
    	Time t1 = new Time(20, 3, 45);

    	// x.equals(null) should return false.
    	System.out.println("t1.equals(null) = " + t1.equals(null));
		System.out.println("");

    	// Reflexive - x.equals(x) should return true.
    	System.out.println("Reflexive - x.equals(x) should return true.");
    	System.out.println("t2.equals(t2) = " + t1.equals(t1));
		System.out.println("");

    	// Symmetric - x.equals(y) should return true if and only if y.equals(x) returns true.
		Time t2 = new Time(20, 3, 45);
		System.out.println("Symmetric - x.equals(y) should return true if and only if y.equals(x) returns true.");
		System.out.println("t1.equals(t2) = " + t1.equals(t2) + "   t2.equals(t1) = " + t2.equals(t1));
		System.out.println("");

		// Transitive - if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
		Time t3 = new Time(20, 3, 45);
		System.out.println("Transitive  - if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.");
		System.out.print("t1.equals(t2) = " + t1.equals(t2) );
		System.out.print("  t2.equals(t3) = " + t2.equals(t3));
		System.out.println(" -> t1.equals(t3) = " + t1.equals(t3));
		System.out.println("");

		// Consistent - if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
		System.out.println("Consistent - multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.");
		// Subcase 1: consistently true?
		int count = 0;
		System.out.print("t1.equals(t2) = " + t1.equals(t2));
		for(int i = 0; i < 10000; i++){
			// if not consistent, record it
			if(!t1.equals(t2))
				count++;
		}
		if(count!=0)
			System.out.println("  -  Not consistent!");
		else
			System.out.println("  -  Consistent!");
		// Subcase 2: consistently false?
		count = 0;
		Time t4 = new Time(1,1,1);
		System.out.print("t1.equals(t4) = " + t1.equals(t4));
		for(int i = 0; i < 10000; i++){
			// if not consistent, record it
			if(t1.equals(t4))
				count++;
		}
		if(count!=0)
			System.out.println("  -  Not consistent!");
		else
			System.out.println("  -  Consistent!");
    }
}
