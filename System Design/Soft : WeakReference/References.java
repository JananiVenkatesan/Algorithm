
// Demonstrates Reference objects  

import java.lang.ref.*;  
import java.util.*;  
  
class VeryBig{  
    private static final int SIZE = 10000;  
    private long[] la = new long[SIZE];  
    private String ident;  
  
    public VeryBig(String id) {  
        ident = id;  
    }  
  
    public String toString() {  
        return ident;  
    }  
      
    protected void finalize() {  
        System.out.println("Finalizing " + ident);  
    }  
}  
  
public class References{  
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();  
  
    public static Reference<? extends VeryBig> checkQueue() {  
        Reference<? extends VeryBig> inq = rq.poll();  
        System.out.println("inq : =" + inq);  
        if (inq != null)  
            System.out.println("In queue: " + inq.get());  
        return inq;  
    }  
  
    public static void main(String[] args) throws InterruptedException {  
        int size = 10;  
        // Or, choose size via the command line:  
        if (args.length > 0)  
            size = new Integer(args[0]);  
          
        /* 下面这个循环中的对象被包装成SoftReference，而且程序中没有这些对象的强引用  
         * 那么在JVM还没有out of memory的时候就不会回收，这些VeryBig对象，也就不会执行finalize()方法。  
         */    
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();  
        for (int i = 0; i < size; i++) {  
            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft " + i), rq));  
            System.out.println("Just created: " + sa.getLast());  
            checkQueue();  
        }  
          
          
        /*下面这些对象被包装成WeakReference，在没有强引用的时候，gc会将它们都进行标记  
         * 表示可以被回收，在被回收之前，对象会执行finalize()方法。  
         */    
        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();  
        for (int i = 0; i < size; i++) {  
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i), rq));  
            System.out.println("Just created: " + wa.getLast());  
            checkQueue();  
        }  
          
          
        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("Soft"));  
        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));  
        PhantomReference<VeryBig> z = new PhantomReference<VeryBig>(new VeryBig("Weak"), rq);  
              
          
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();  
        for (int i = 0; i < size; i++) {  
            pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom " + i),rq));  
            System.out.println("Just created: " + pa.getLast());  
            checkQueue();  
        }  
          
    }  
} /* (Execute to see output) */

/*
Just created: java.lang.ref.SoftReference@272d7a10
inq : =null
Just created: java.lang.ref.SoftReference@1aa8c488
inq : =null
Just created: java.lang.ref.SoftReference@3dfeca64
inq : =null
Just created: java.lang.ref.SoftReference@22998b08
inq : =null
Just created: java.lang.ref.SoftReference@e76cbf7
inq : =null
Just created: java.lang.ref.SoftReference@1948cc8c
inq : =null
Just created: java.lang.ref.SoftReference@7a6d084b
inq : =null
Just created: java.lang.ref.SoftReference@c3bb2b8
inq : =null
Just created: java.lang.ref.SoftReference@2352544e
inq : =null
Just created: java.lang.ref.SoftReference@721cdeff
inq : =null
Just created: java.lang.ref.WeakReference@457471e0
inq : =null
Just created: java.lang.ref.WeakReference@5fe04cbf
inq : =null
Just created: java.lang.ref.WeakReference@7ecec0c5
inq : =null
Just created: java.lang.ref.WeakReference@37d2068d
inq : =null
Just created: java.lang.ref.WeakReference@3dac2f9c
inq : =null
Just created: java.lang.ref.WeakReference@7369ca65
inq : =null
Just created: java.lang.ref.WeakReference@2666e815
inq : =null
Just created: java.lang.ref.WeakReference@2e0ece65
inq : =null
Just created: java.lang.ref.WeakReference@4e106082
inq : =null
Just created: java.lang.ref.WeakReference@15301ed8
inq : =null
Just created: java.lang.ref.PhantomReference@a3901c6
inq : =null
Just created: java.lang.ref.PhantomReference@24a37368
inq : =null
Just created: java.lang.ref.PhantomReference@66edc3a2
inq : =null
Just created: java.lang.ref.PhantomReference@3c6f579
inq : =null
Just created: java.lang.ref.PhantomReference@7b1ddcde
inq : =null
Just created: java.lang.ref.PhantomReference@658fb1f7
inq : =null
Just created: java.lang.ref.PhantomReference@3ced0338
inq : =null
Just created: java.lang.ref.PhantomReference@6c6e70c7
inq : =null
Just created: java.lang.ref.PhantomReference@46ae506e
inq : =null
Just created: java.lang.ref.PhantomReference@5e228a02
inq : =null
*/