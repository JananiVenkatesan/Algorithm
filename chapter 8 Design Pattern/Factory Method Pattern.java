Motivation
	Also known as Virtual Constructor, the Factory Method is related to 
	the idea on which libraries work: a library uses abstract classes 
	for defining and maintaining relations between objects. One type of 
	responsibility is creating such objects. The library knows when an 
	object needs to be created, but not what kind of object it should 
	create, this being specific to the application using the library.

	The Factory method works just the same way: it defines an interface 
	for creating an object, but leaves the choice of its type to the 
	subclasses, creation being deferred at runtime. A simple real life 
	example of the Factory Method is the hotel. When staying in a hotel 
	you first have to check in. The person working at the front desk will 
	give you a key to your room after you have paid for the room you want 
	and this way he can be looked at as a room factory. While staying at 
	the hotel, you might need to make a phone call, so you call the front 
	desk and the person there will connect you with the number you need, 
	becoming a phone-call factory, because he controls the access to calls, too.

Intent
	- Defines an interface for creating objects, but let subclasses to decide which class to instantiate
	- Refers to the newly created object through a common interface















