import java.io.*;

public class DeserializeDemo{
	public static void main(String[] args){
		Employee e = null;
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"));
			e = (Employee)in.readObject();
			in.close();
		}
		catch(IOException io){
			io.printStackTrace();
			return;
		}
		catch(ClassNotFoundException ex){
			ex.printStackTrace();
			return;
		}
	    System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
	}
}