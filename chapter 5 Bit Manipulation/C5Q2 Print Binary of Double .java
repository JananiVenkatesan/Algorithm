/*
Problem:
	Given a real number between 0 and 1 (e.g., 0.625) that is passed in as 
a double, print the binary representation. If the number cannot be 
represented accurately in binary with at most 32 characters, print "ERROR."


Solution:
	When otherwise ambiguous, we'll use the subscripts x(2) and x(10) 
to indicate whether x is in base 2 or base 10.

	First, let's start off by asking ourselves what a non-integer 
number in binary looks like. By analogy to a decimal number, the 
binary number 0.101(2) would look like:

	0.101(2) = 1*(1/2^1)+0*(1/2^2)+1*(1/2^3) = 0.625(10).

	To print the decimal part, we can multiply by 2 and check if 
2n is greater than or equal to 1.This is essentially "shifting" 
the fractional sum. That is:

  r = 2(10) * n
	= 2(10) * 0.101(2)
	= 1 * (1/2^0) + 0 * (1/2^1) + 1 * (1/2^2) 
	= 1.01 (2)

	If r >= 1, then we know that n had a 1 right after the decimal 
point. By doing this continuously, we can check every digit.

*/

import java.util.*;

public class Test  {
    public static void main(String[] args) {
        double d = 0.625;
        System.out.println(printBinary(d));
        // 0.101
    }

    public static String printBinary(double num){
        if(num <=0 || num >= 1)
            return "ERROR 1";

        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while(num > 0){
            if(sb.length() >= 32)
                return "Error 2";

            System.out.println(sb.toString());
            num = num * 2;
            if(num >= 1){
                sb.append(1);
                num -= 1;
            }
            else{
                sb.append(0);
            }
        }
        return sb.toString();
    }
}

/*
	Alternatively, rather than multiplying the number by two and 
comparing it to 1, we can compare the number to .5, then .25, and 
so on. The code below demonstrates this approach.

*/
public static String printBinary_2(double num){
	if(num >= 1 || num <= 0){
		return "ERROR";
	}

	StringBuilder sb = new StringBuilder();
	double frac = 0.5;
	sb.append(".");
	while(num > 0){
		/* Setting a limit on length: 32 characters */
		if(sb.length() >= 32){
			return "ERROR";
		}

		if(num >= frac){
			sb.append(1);
			num -= frac; 
		}else{
			sb.append(0);
		}
		frac /= 2;
	}
	return sb.toString();
}







