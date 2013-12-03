/*

FizzBuzz Problem

	Write a program that prints the numbers from 1 to 100. But 
for multiples of three print “Fizz” instead of the number and 
for the multiples of five print “Buzz”. For numbers which are 
multiples of both three and five print “FizzBuzz”.


*/

public void fizzBuzz(){
	for(int i = 1; i <= 100; i++){
		boolean fizz = (i % 3 == 0);
		boolean buzz = (i % 5 == 0);

		if(fizz && buzz){
			System.out.println("FizzBuzz");
		}else if(fizz){
			System.out.println("Fizz");
		}else if(buzz){
			System.out.println("Buzz");
		}else{
			System.out.println(i);
		}
	}
}
