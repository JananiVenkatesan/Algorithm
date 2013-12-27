Motivation

    when applied to a given class, basically limits the 
    class itself to having just one instance created.

    !!A private constructor is key to the Singleton!!

    Sometimes it's important to have only one instance for a 
    class. For example, in a system there should be only one 
    window manager (or only a file system or only a print spooler). 
    Usually singletons are used for centralized management of 
    internal or external resources and they provide a global 
    point of access to themselves.

Intent
    - Ensure that only one instance of a class is created.
    - Provide a global point of access to the object.

Implementation

// Eager Instantiation / Early Instantiation
class Singleton{
    private final static Singleton s = new Singleton();
    private Singleton(){
    }
    
    public static Singleton getSingleton(){
        return s;
    }
    ...
    public void doSomething(){
        ... 
    }
}

// Lazy Instantiation / Lazy Loading
class Singleton{
    private static Singleton s = null;

    private Singleton(){
    }
    
    public static Singleton getSingleton(){
        if(s == null) 
            s= new Singleton();
        return s;    
    }
    ...
    public void doSomething(){
        ... 
    }
}

// The getInstance method is used also to provide a global point of 
// access to the object and it can be used in the following manner:
Singleton.getInstance().doSomething();

// Thread Safe Singleton  -> synchronized
class Singleton{
    private static Singleton s = new Singleton();

    private Singleton(){
    }
    
    public synchronized static Singleton getSingleton(){
        if(s == null) 
            s= new Singleton();
        return s;    
    }
}


//Lazy instantiation using double locking mechanism.
class Singleton{
    private static Singleton instance;

    private Singleton(){
    System.out.println("Singleton(): Initializing Instance");
    }

    public static Singleton getInstance(){
        if (instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new Singleton();
                }
            }            
        }

        return instance;
    }

    public void doSomething(){
        System.out.println("doSomething(): Singleton does something!");
    }
}



/*
Suppose you have a logger class that is used to log error and warning 
messages. How can you implement this class while using the Singleton 
design pattern?
*/

public class Logging{
    private static final Logging singletonInstance = new Logging();

    private Logging(){}

    public static Logging getSingleton() { 
      return singletonInstance; 
    }

    /* This will print a message to the screen:
       sample call: Logging.getSingleton().log("testing message");
    */
    public void log( String message ){
      System.out.println( System.currentTimeMillis() 
      + ": " + message );
    }
}


Example 1 - Logger Classes

    The Singleton pattern is used in the design of logger classes. This classes 
    are ussualy implemented as a singletons, and provides a global logging access 
    point in all the application components without being necessary to create an 
    object each time a logging operations is performed.

Example 2 - Configuration Classes

    The Singleton pattern is used to design the classes which provides the 
    configuration settings for an application. By implementing configuration 
    classes as Singleton not only that we provide a global access point, but we 
    also keep the instance we use as a cache object. When the class is instantiated( 
    or when a value is read ) the singleton will keep the values in its internal 
    structure. If the values are read from the database or from files this avoids 
    the reloading the values each time the configuration parameters are used.

Example 3 - Accesing resources in shared mode

    It can be used in the design of an application that needs to work with the 
    serial port. Let's say that there are many classes in the application, working 
    in an multi-threading environment, which needs to operate actions on the serial 
    port. In this case a singleton with synchronized methods could be used to be 
    used to manage all the operations on the serial port.

Example 4 - Factories implemented as Singletons

    Let's assume that we design an application with a factory to generate new 
    objects(Acount, Customer, Site, Address objects) with their ids, in an 
    multithreading environment. If the factory is instantiated twice in 2 
    different threads then is possible to have 2 overlapping ids for 2 different 
    objects. If we implement the Factory as a singleton we avoid this problem. 
    Combining Abstract Factory or Factory Method and Singleton design patterns 
    is a common practice.



/*
Suppose you have an application that uses the Singleton Design pattern 
for one of it’s classes. But, the problem is that the singleton is expensive 
to create, because a resource intensive database access is necessary to 
create the singleton. What can you do to possibly add some efficiency to the 
process of creating a singleton?
*/

public class Logging{
    private static Logging singletonInstance = null; 
    
    private Logging(){}
    
    public static Logging getSingleton() { 
        return singletonInstance; 
    }
    public static Logging getSingleton() {
        if( singletonInstance  == null ){
            singletonInstance  = new Logging();
        }
        return singletonInstance;
    }
}















