/*
Problem:
    An animal shelter holds only dogs and cats, and operates on 
a strictly "first in, first out" basis. People must adopt either the 
"oldest" (based on arrival time) of all animals at the shelter, or 
they can select whether they would prefer a dog or a cat (and will 
receive the oldest animal of that type). They cannot select which 
specific animal they would like. Create the data structures to maintain 
this system and implement opera- tions such as enqueue, dequeueAny, 
dequeueDog and dequeueCat. You may use the built-in LinkedList data 
structure.

Solution:
    page 217
*/

public abstract class Animal{
	private int order;
	private String name;
	public Animal(String n){
		name = n;
	}

	public void setOrder(int ord){
		order = ord;
	}

	public int getOrder(){
		return order;
	}

	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder();
	}
}

class Dog extends Animal{
	public Dog(String n){
		super(n);
	}
}

class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
}

public class AnimalQueue{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;  // act as timestamp

	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog){
			dogs.addLast((Dog)a);
		}else if(a instanceof Cat){
			cats.addLast((Cat)a);
		}
	}

	public Animal dequeueAny(){
		// Look at tops of dog and cat queues, and pop the stack with the oldest value.
		if(dogs.size() == 0){
			return dequeueDogs();
		}else if(cats.size() == 0){
			return dequeueCats()
		}

		Dog dog = dogs.peekFirst();
		Cat cat = cats.peekFirst();

		if(dog.isOlderThan(cat)){
			return dequeueDogs();
		}else{
			return dequeueCats();
		}
	}

	public Dog dequeueDogs(){
		return dogs.removeFirst();
	}

	public Cat dequeueCats(){
		return cats.removeFirst();
	}
}
















