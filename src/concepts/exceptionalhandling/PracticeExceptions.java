package concepts.exceptionalhandling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PracticeExceptions {
	
	
	public static void main(String args[]) throws Exception,RuntimeException {
		int a=10;
		int b=0;
		
		try {
			//we will be writing the code that might throw an Uncheckedexception
			if(b==0) {
				// it we doesnt throw arithmetic Exception will be thrown for the below statement.
				throw new UnCheckedExceptions("denominator is Zero");
			}
			//below code in try block wont be executed because of above Exception
			int c=a/b;
			System.out.println(c);
		}catch(ArithmeticException e) {
			//we are throwing UnCheckedException for Runtime exceptions
			throw new UnCheckedExceptions("Arithematic Exception",e);
		}catch(UnCheckedExceptions e) {
			//we are Listening the Exception and not throwing it because
			//to handle rest of the code.
			System.out.println(e);
		}finally{
			System.out.println("Finally executed");
		}
		
		
		System.out.println("rest of the code");
		
		
		 PrintWriter pw;  
	        try {  
	            pw = new PrintWriter("jtp.txt"); //may throw exception   
	            pw.println("saved");  
	        }  
			// providing the checked exception handler  
			 catch (FileNotFoundException e) {  
			              
			            System.out.println(e);  
			}
	        
	        PracticeExceptions pe = new PracticeExceptions();
	        System.gc();
	        System.out.println("End of the garbage collection");     
	}

	/*
	 * When running in a Java virtual machine in which finalization has beendisabled
	 * or removed, the garbage collector will never call finalize(). In a Java
	 * virtual machine in which finalization isenabled, the garbage collector might
	 * call finalize only after anindefinite delay.
	 */
	
	@Override
	protected void finalize()     
    {     
        System.out.println("Called the finalize() method");     
    } 
	
	

}
