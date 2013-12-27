Motivation
	The Factory Design Pattern is probably the most used design pattern 
	in modern programming languages like Java and C#. It comes in different 
	variants and implementations. If you are searching for it, most likely, 
	you will find references about the GoF patterns: Factory Method and Abstract 
	Factory.

Intent
	- creates objects without exposing the instantiation logic to the client.
	- refers to the newly created object through a common interface


Implementation
	The implementation is really simple
	- The client needs a product, but instead of creating it directly using 
	  the new operator, it asks the factory object for a new product, providing 
	  the information about the type of object it needs.
	- The factory instantiates a new concrete product and then returns to the 
	  client the newly created product(casted to abstract product class).
	- The client uses the products as abstract products without being aware 
	  about their concrete implementation.

Applicability & Examples
	For example a graphical application works with shapes. In our implementation 
	the drawing framework is the client, and the shapes are the products. All the 
	shapes are derived from an abstract shape class (or interface). The Shape class 
	defines the draw and move operations which must be implemented by the concrete 
	shapes. Let us assume a command is selected from the menu to create a new Circle. 
	The framework receives the shape type as a string parameter, it asks the factory 
	to create a new shape sending the parameter received from menu. The factory 
	creates a new circle and returns it to the framework, casted to an abstract shape. 
	Then the framework uses the object as casted to the abstract class without being 
	aware of the concrete object type.

	The advantage is obvious: New shapes can be added without changing a single line 
	of code in the framework(the client code that uses the shapes from the factory). 
	As it is shown in the next sections, there are certain factory implementations 
	that allow adding new products without even modifying the factory class.


// noob implementation
public class ShapeFactory{
	public Shape createShape(String s){
		if(s.equals("Circle"))
			return new Circle();
		if(s.equals("Square"))
			return new Square();
		if(s.equals("Triangle"))
			return new Triangle();
		return null;
	}
}

// Class Registration - using reflection
class ShapeFactory{
	private HashMap registeredShapes = new HashMap();

	public void registerShape(String name, Class shapeClass){
		registeredShapes.put(name, shapeClass);
	}

	public Shape createShape(String name){
		Class shapeClass = (Class)registeredShapes.get(name);
		Constructor c = shapeClass.getDeclaredConstructor(new Class[] {String.class});
		return (Shape)c.newInstance(new Object[]{});
	}
}

// Class Registration - avoiding reflection
abstract class Shape{
	public abstract Shape createShape();
	...
}

class Circle extend Shape{
	...
	static{
		ShapeFactory.instance().registerShape("Circle", new Circle());
	}
	public Circle createShape(){
		return new Circle();
	}
	...
}

class ShapeFactory{
	private HashMap registeredShapes = new HashMap();

	public void registerShape(String name, Shape s){
		registeredShapes.put(name, s);
	}
	public Shape createShape(String name){
		((Shape)registeredShapes.get(name)).createShape();
	}
}






















