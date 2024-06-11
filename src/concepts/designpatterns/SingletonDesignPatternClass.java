package concepts.designpatterns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class SingletonDesignPatternClass {
	
	/*
	 * This is the class were only one object can be created for it. we can create
	 * the another instace by making the previous instance null;
	 */
	
	/*
	 * The volatile keyword in Java is used to indicate that a variable's value can
	 * be modified by different threads. Used with the syntax, volatile dataType
	 * variableName = x; It ensures that changes made to a volatile variable by one
	 * thread are immediately visible to other threads.
	 * 
	 */
	
	/*
	 * private static volatile SingletonDesignPatternClass singletonClassInstance =
	 * null;
	 * 
	 * 
	 * 
	 * private SingletonDesignPatternClass() {
	 * System.out.println("Singleton instance created"); }
	 * 
	 * public static SingletonDesignPatternClass getSingletonClassInstace() {
	 * if(singletonClassInstance==null) { synchronized
	 * (SingletonDesignPatternClass.class) { if(singletonClassInstance==null) {
	 * singletonClassInstance = new SingletonDesignPatternClass(); } } }
	 * 
	 * return singletonClassInstance;
	 * 
	 * }
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		/* 1. EagerInitializedSingleton
		 * //Here in EagerInitializedSingleton the Object is created during the class
		 * loading so it wont get destroyed and same Object(Single) can be
		 *  returned for all the instances of the class
		 */		
		EagerInitializedSingleton eagerInitializedSingleton1 = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton eagerInitializedSingleton2 = EagerInitializedSingleton.getInstance();
		
		System.out.println("eagerInitializedSingleton1 hashcode "+eagerInitializedSingleton1.hashCode());
		System.out.println("eagerInitializedSingleton2 hashcode "+eagerInitializedSingleton2.hashCode());
		
		//----------------------------------------------------------------------------------------------------
		/* 2. StaticBlockSingleton
		 * //Here in StaticBlockSingleton the Object is created during the class
		 * loading so it wont get destroyed and same Object(Single) can be
		 *  returned for all the instances of the class
		 *  
		 *  The extra case is we handle the exception in the static block as shown in the class declaration
		 */		
		StaticBlockSingleton StaticBlockSingleton1 = StaticBlockSingleton.getInstance();
		StaticBlockSingleton StaticBlockSingleton2 = StaticBlockSingleton.getInstance();
		
		System.out.println("StaticBlockSingleton1 hashcode "+StaticBlockSingleton1.hashCode());
		System.out.println("StaticBlockSingleton2 hashcode "+StaticBlockSingleton2.hashCode());
		
		//----------------------------------------------------------------------------------------------------
		
		/* 3. LazyInitializedSingleton
		 * //Here in LazyInitializedSingleton the instantiation can be done only when if it not already set. if it
		 * is already set then same object would be shared among all the other multiple threads without any lock mechanism
		 * which is bad practice during the processing of data
		 *  
		 *  This would be helpful only during single threaded case
		 *  
		 *  This can be overcome during the ThreadSafeSingleTon
		 */
		
		LazyInitializedSingleton LazyInitializedSingleton1 = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton LazyInitializedSingleton2 = LazyInitializedSingleton.getInstance();
		
		System.out.println("LazyInitializedSingleton1 hashcode "+LazyInitializedSingleton1.hashCode());
		System.out.println("LazyInitializedSingleton2 hashcode "+LazyInitializedSingleton2.hashCode());
		
		//----------------------------------------------------------------------------------------------------

		/* 4. ThreadSafeSingleton
		 * //Here in LazyInitializedSingleton the instantiation can be done only when if it not already set. if it
		 * is already set then same object would be shared among all the other multiple threads but lock mechanism is enabled
		 * 
		 *  
		 *  This would be helpful multiple threaded case as well
		 * 
		 */
		
		ThreadSafeSingleton ThreadSafeSingleton1 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		ThreadSafeSingleton ThreadSafeSingleton2 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		
		System.out.println("ThreadSafeSingleton1 hashcode "+ThreadSafeSingleton1.hashCode());
		System.out.println("ThreadSafeSingleton2 hashcode "+ThreadSafeSingleton2.hashCode());
		
		
		//----------------------------------------------------------------------------------------------------

		//6. Using Reflection to destroy Singleton Pattern
		//Reflection can be used to destroy all the previous singleton implementation approaches
		/*
		 * //if we check the hash codes of the instance one and two both will be
		 * different because we will be destroying the instance one before instantiating
		 * the instance two.
		 */
		EagerInitializedSingleton EagerInitializedSingletoninstanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton EagerInitializedSingletoninstanceTwo = null;
        try {
            Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                // This code will destroy the singleton pattern
                constructor.setAccessible(true);
                EagerInitializedSingletoninstanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("EagerInitializedSingletoninstanceOne hashcode : "+EagerInitializedSingletoninstanceOne.hashCode());
        System.out.println("EagerInitializedSingletoninstanceTwo hashcode : "+EagerInitializedSingletoninstanceTwo.hashCode());
		
      //----------------------------------------------------------------------------------------------------
        
      //8. Serialization and Singleton 
        /*
         * sometimes in distributed systems, we need to implement Serializable interface
         * in the singleton class so that we can store its state in the file system and
         * retrieve it at a later point in time. Here is a small singleton class that
         * implements Serializable interface also:
         */
       
        //Initially the hashcodes would be diff in serializable and deserializable  objects refer the SerializedSingleton class for getting the same hashcode
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        // deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("serializable instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("de-serializable instanceTwo hashCode="+instanceTwo.hashCode());

    }

	

}


// 1. Eager initialization: in this methodology the instance will get created at the time of the class loading as it is the static variable
// this methodology does suits only if you are not using this class for lot of resources it can be preferred

//but as per the singleton pattern the instantiation should be done only when we are calling the global access point other than that it should be null
class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // private constructor to avoid client applications using the constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}

//2. StaticBlockSingleton
//Static block initialization implementation is similar to eager initialization, except that instance of the class is created in the static block that provides the option for exception handling.
//Both eager initialization and static block initialization create the instance even before it’s being used and that is not the best practice to use.
class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    // static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

///3. LazyInitializedSingleton
/*
 * //This implementation works fine in the case of the single-threaded
 * environment, but when it comes to multi-threaded systems, it can cause issues
 * if multiple threads are inside the if condition at the same time. It will
 * destroy the singleton pattern and both threads will get different instances
 * of the singleton class. In the next section, we will see different ways to
 * create a thread-safe singleton class.
 */class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

//4. Thread Safe Singleton
//A simple way to create a thread-safe singleton class is to make the global access method synchronized so that only one thread can execute this method at a time. Here is a general implementation of this approach



class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
    /*
     * The preceding implementation works fine and provides thread-safety, but it
     * reduces the performance because of the cost associated with the synchronized
     * method, although we need it only for the first few threads that might create
     * separate instances. To avoid this extra overhead every time, double-checked
     * locking principle is used. In this approach, the synchronized block is used
     * inside the if condition with an additional check to ensure that only one
     * instance of a singleton class is created. The following code snippet provides
     * the double-checked locking implementation
     */
    
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

}


//5. Bill Pugh Singleton Implementation(This is used before Java 5 because of lot of issues in the memory model)
/*
 * Prior to Java 5, the Java memory model had a lot of issues, and the previous
 * approaches used to fail in certain scenarios where too many threads tried to
 * get the instance of the singleton class simultaneously. So Bill Pugh came up
 * with a different approach to create the singleton class using an inner static
 * helper class. Here is an example of the Bill Pugh Singleton implementation:
 */
class BillPughSingleton {

    private BillPughSingleton(){}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

/*
 * Notice the private inner static class that contains the instance of the
 * singleton class. When the singleton class is loaded, SingletonHelper class is
 * not loaded into memory and only when someone calls the getInstance() method,
 * this class gets loaded and creates the singleton class instance. This is the
 * most widely used approach for the singleton class as it doesn’t require
 * synchronization.
 */

//6. Using Reflection to destroy Singleton Pattern
//Reflection can be used to destroy all the previous singleton implementation approaches

class ReflectionSingletonTest {

    public static void mainn(String[] args) {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                // This code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("instanceOne hashcode : "+instanceOne.hashCode());
        System.out.println("instanceTwo hashcode : "+instanceTwo.hashCode());
    }
    
    

}

//7. Enum Singleton : this implementation states that enum value is instantiated only once in a Java program.


/*
 * Since Java Enum values are globally accessible, so is the singleton. The
 * drawback is that the enum type is somewhat inflexible (for example, it does
 * not allow lazy initialization).
 */

enum EnumSingleton {

    INSTANCE;

    public static void doSomething() {
        // do something
    }
}

//8. Serialization and Singleton 
/*
 * sometimes in distributed systems, we need to implement Serializable interface
 * in the singleton class so that we can store its state in the file system and
 * retrieve it at a later point in time. Here is a small singleton class that
 * implements Serializable interface also:
 */

class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }
    
	/*
	 * So the above code destroys the singleton pattern of the serialized object and
	 * provide new instance after deserialization which is not a good practice as we
	 * need to access the same object after deserialization. To overcome this
	 * scenario, all we need to do is provide the implementation of readResolve()
	 * method.
	 */
    
    protected Object readResolve() {
        return getInstance();
    }
    
    
}

/*
 * The problem with serialized singleton class is that whenever we deserialize
 * it, it will create a new instance of the class. Here is an example:
 */