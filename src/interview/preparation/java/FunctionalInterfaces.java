package interview.preparation.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

	public static void main(String args[]) {
		ConsumerInterfaceImpl consumerImpl = new ConsumerInterfaceImpl();
		
		System.out.println("accept impl.........");
		
		consumerImpl.acceptImpl(10);
		System.out.println();
		System.out.println("andThen impl.........");
		
		consumerImpl.andThenImpl();
		
		//Biconsumer
		
		BiConsumerInterfaceImpl biconsumerimpl = new BiConsumerInterfaceImpl();
		
		// Create the first list
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(2);
        lista.add(1);
        lista.add(3);
 
        // Create the second list
        List<Integer> listb = new ArrayList<Integer>();
        listb.add(2);
        listb.add(1);
        listb.add(2);
        
        biconsumerimpl.acceptImpl(lista, listb);
        
        biconsumerimpl.andThenImpl();
        
        //predicate
        
        PredicateImpl predicateImpl = new PredicateImpl();
        
        predicateImpl.predicateChainingUsingAndOrNegateFunctions();
        
        //predicate on collections
        List<User> users = new ArrayList<User>(); 
        users.add(new User("John", "admin")); 
        users.add(new User("Peter", "member")); 
        List<User> admins = User.process(users, (User u) -> u.getRole().equals("admin")); 
        System.out.println(admins); 
        
        //Function Interface
        FunctionInterfaceImpl functionInterfaceImpl =new FunctionInterfaceImpl();
        
        System.out.println(functionInterfaceImpl.applyImpl(10));
        System.out.println(functionInterfaceImpl.andThenImpl(10));
        System.out.println(functionInterfaceImpl.composeImpl(10));
        System.out.println(functionInterfaceImpl.identityImpl(10));
        
        //Supplier
        
        SupplierImpl supplierImpl = new SupplierImpl();
        
        supplierImpl.getImpl();
        
        
	}
	
}


//consumer interface accepts 1 argument
class ConsumerInterfaceImpl{
	
	public void acceptImpl(int val) {
		Consumer<Integer> consumer = a -> {
			
			System.out.println(a*a);
		};
		
		consumer.accept(val);
		
		// Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
 
        // Consumer to display a list of numbers
        Consumer<List<Integer> >
            dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
 
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
 
        // Implement modify using accept()
        modify.accept(list);
 
        // Implement dispList using accept()
        dispList.accept(list);
		
	}
	
	
	public void andThenImpl() {
		
		//As in the accept impl methods we have a modify consumer which modifies the given list by multiplying by 2 and disList will display all the modified list of params
		
		//the same this can be perfomef in one line using andThen method.
		
		// the andThen - This method accepts a parameter after(Consumer(dispList)) which is the Consumer to be applied after the current one(modify).
		
		
		// Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
 
        // Consumer to display a list of numbers
        Consumer<List<Integer> >
            dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
 
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
 
        //first modify consumer will be performed after dispList will be performed.
        modify.andThen(dispList).accept(list);
        
        System.out.println();
        //This method throws NullPointerException if the after operation is null.
        try {
            // using addThen()
            modify.andThen(null).accept(list);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
		
	}
}


//Biconsumer interfcae accepts 2 arguments
class BiConsumerInterfaceImpl{
	
	
	public void acceptImpl(List<Integer>lista, List<Integer> listb) {
		BiConsumer<List<Integer>, List<Integer> > equals = (list1, list2) ->
        {
            if (list1.size() != list2.size()) {
                System.out.println("sizes are not equal");
            }
            else {
                for (int i = 0; i < list1.size(); i++)
                    if (list1.get(i) != list2.get(i)) {
                        System.out.println("all the elements in lista and listb are not same");
                        return;
                    }
                System.out.println("all the elements in lista and listb are same");
            }
        };
        
        equals.accept(lista, listb);
	}
	
	
	public void andThenImpl() {
		// Create first list
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(2);
        lista.add(1);
        lista.add(3);
 
        // Create second list
        List<Integer> listb = new ArrayList<Integer>();
        listb.add(2);
        listb.add(1);
        listb.add(3);
 
        // BiConsumer to compare 2 lists of integers
        BiConsumer<List<Integer>, List<Integer> > equals = (list1, list2) ->
        {
        	if (list1.size() != list2.size()) {
                System.out.println("sizes are not equal");
            }
            else {
                for (int i = 0; i < list1.size(); i++)
                    if (list1.get(i) != list2.get(i)) {
                        System.out.println("all the elements in lista and listb are not same");
                        return;
                    }
                System.out.println("all the elements in lista and listb are same");
            }
        };
 
        // BiConsumer to print 2 lists
        BiConsumer<List<Integer>, List<Integer> > disp = (list1, list2) ->
        {
            list1.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
            list2.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };
 
        // Using addThen() method
        equals.andThen(disp).accept(lista, listb);
        
      //This method throws NullPointerException if the after operation is null.
        try {
            equals.andThen(null).accept(lista, listb);
        }
        catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    
	}
}

//this predicate interface contains the test method

//it improves the manageability of the code, helps in unit-testing them separately.
class PredicateImpl{
	
	public void testImpl() {
		Predicate<Integer> predicate = a -> (a<18);
		
		System.out.println(predicate.test(10));
	}
	
	//passing the predicate lambda function as an argument of the method
	public void pred(int number, Predicate<Integer> predicate) 
    { 
        if (predicate.test(number)) { 
            System.out.println("Number " + number); 
        } 
    }
	
	public void predicateChainingUsingAndOrNegateFunctions() {
		  	//predicate-1
			Predicate<Integer> greaterThanTen = (i) -> i > 10; 
		  
	        //predicate-2
	        Predicate<Integer> lowerThanTwenty = (i) -> i < 20; 
	        
	        //passing the predicate lambda function as an method argument
	        pred(10, (i) -> i > 7);
	        
	        //predicate and
	        boolean result = greaterThanTen.and(lowerThanTwenty).test(15); 
	        System.out.println(result); 
	        
	        //predicate or
	        boolean result1 = greaterThanTen.or(lowerThanTwenty).test(15); 
	        System.out.println(result1);
	  
	        // Calling Predicate method 
	        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15); 
	        System.out.println(result2);
	}
	
}

//predicate using collections
class User 
{ 
    String name, role; 
    User(String a, String b) { 
        name = a; 
        role = b; 
    } 
    String getRole() { return role; } 
    String getName() { return name; }     
    public String toString() { 
       return "User Name : " + name + ", Role :" + role; 
    } 
  
    public static void main(String args[]) 
    {       
        List<User> users = new ArrayList<User>(); 
        users.add(new User("John", "admin")); 
        users.add(new User("Peter", "member")); 
        List<User> admins = process(users, (User u) -> u.getRole().equals("admin")); 
        System.out.println(admins); 
    } 
  
    public static List<User> process(List<User> users,  
                            Predicate<User> predicate) 
    { 
        List<User> result = new ArrayList<User>(); 
        for (User user: users)         
            if (predicate.test(user))             
                result.add(user); 
        return result; 
    } 
}


//it takes input and manipulates the input and returns the same.
class FunctionInterfaceImpl{
	//apply(arg)
	//andThen(Function<I,R> after)
	//compose(Function<I,R> before)
	//identity
	
	public int applyImpl(int val) {
		//function
		Function<Integer,Integer> function = a -> (a*3);
		
		return function.apply(10);
	}
	
	public int andThenImpl(int val) {
		//function
		Function<Integer,Integer> function1 = a -> (a*3);
		
		Function<Integer,Integer> function2 = a -> (a*4);
		
		return function1.andThen(function2).apply(10);
	}
	
	public int composeImpl(int val) {
		//function
		Function<Integer,Integer> function1 = a -> (a*3);
		
		Function<Integer,Integer> function2 = a -> (a*4);
		
		return function1.compose(function2).apply(10);
	}
	
	public int identityImpl(int val) {
		//function
		Function<Integer,Integer> function1 = Function.identity();
		
		return function1.apply(10);
	}
}

//supplier interface constains a method get that doesnt take any input but supplies the output.

class SupplierImpl{
	
	//get()
	
	
	public void getImpl() {
		 // This function returns a random value. 
        Supplier<Double> randomValue = () -> Math.random(); 
  
        // Print the random value using get() 
        System.out.println(randomValue.get());
	}
	
}