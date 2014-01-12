import java.io.*;

public class SerializeDemo{
	public static void main(String[] args){
		Employee e = new Employee();
		e.name = "John";
		e.address = "Pittsburgh, PA";
		e.SSN = 2009202462;
		e.number = 101;
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"));
			out.writeObject(e);
			out.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}


class Employee implements Serializable{
	public String name;
	public String address;
	public transient int SSN;
	public int number;
	public void mailCheck(){
		System.out.println("Mailing a check to " + name + " " + address);
	}
}