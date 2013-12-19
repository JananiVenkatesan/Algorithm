class Singleton{
    private final static Singleton s = new Singleton();
    private Singleton(){
    }
    
    public static Singleton getSingleton(){
        return s;
    }
}

class Singleton{
    private static Singleton s = new Singleton();

    private Singleton(){
    }
    
    public static Singleton getSingleton(){
        if(s == null) 
            s= new Singleton();
        return s;    
    }
}
