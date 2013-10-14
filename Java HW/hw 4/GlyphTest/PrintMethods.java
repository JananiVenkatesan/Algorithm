import java.lang.refelct.*;

public class PrintMethods{
	public static void main(String[] args){

		Object object = new String();
		listMethods(object);
	}

	public static void listMethods(Object o) throws Exception{
      Class c = o.getClass();
      Method[] methods = c.getDeclaredMethods();
      for(Method method:methods)
          System.out.println(method);
	}

} 