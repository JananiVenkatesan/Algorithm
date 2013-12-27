
The Decorator design pattern is used to wrap one object 
with another object. The point of wrapping one object 
with another object is so that the original object’s behavior 
can be modified.

The wrapper object can be used as a substitute for the 
original object because of the fact that both objects 
either share the same abstract class or implement the 
same interface.


-----------------------

Inheritance vs the Decorator Pattern

	The thing that both inheritance and the decorator pattern 
	have in common is the fact that they both allow you to change 
	how an object behaves. But how they achieve this change in 
	behavior is where inheritance and the decorator pattern are 
	different.

The Decorator pattern makes run-time object changes easier

	With inheritance, dynamically changing the behavior of an object 
	can be a burdensome process. Suppose that you want to dynamically 
	change the behavior of an object using inheritance. Since we are 
	dealing with inheritance, you will need to use a child class and 
	then create an object of that child class in order to get the 
	desired effect. After you create the child class object you will 
	then need to copy the state from the current object into the new 
	child class object – because you will presumably want to still 
	save the state of the current object. And finally, after you are 
	done copying the state, you will want to discard the old object 
	since you no longer need it. This is obviously a long process that 
	can be quite a pain to implement over and over again.

	But if we use the Decorator pattern instead, it is a lot easier 
	to dynamically change the behavior of the object. All we have to 
	do is wrap the current object with another object that contains 
	the extra behavior that is desired.

The Decorator Pattern makes multiple behavior modifications easier

	Suppose that you have many different changes that you would like 
	to implement for a given class. And, also assume that those changes 
	do not conflict with one another, so you can combine those modifications
	in any order without having to worry about potential conflicts. In 
	this scenario, using the Decorator pattern can be very advantageous 
	over inheritance. Let’s go over an example to understand this concept 
	further.

	As our example, let’s say that we have a Car class. This class could 
	have many different behaviors like Automatic, Manual, Convertible, etc. 
	We could have these behaviors implemented using inheritance. So, we 
	could create classes called AutomaticCar, ManualCar, or ConvertibleCar 
	that all derive from the Car class. While this is just fine for a 
	reasonable number of child classes, for more behaviors (like LuxuryCar, 
	SedanCar, etc) this process of creating more and more child classes can 
	quickly become very messy. But, by using the Decorator pattern instead 
	of inheritance, we can avoid this problem of having far too many child 
	classes. This is because with the Decorator pattern, each and every 
	behavior is described by just one Decorator class. And, you can specify 
	whatever behaviors you want by applying the desired set of decorations.


The Decorator pattern is not necessary in non-dynamic situations

	Using the Decorator pattern is pretty darn complex. If you actually need 
	to dynamically change the way an object behaves, then using the Decorator 
	pattern is a good idea. But, if you do not need to dynamically change the 
	way an object behaves, then inheritance is the better option because you 
	then do not need to deal with the complexity of the Decorator pattern.







