package concepts.string;

public class StringConcepts {
	
	 public static void  main(String args[]) {
		 String s = new String("hanuma");
		 
		 System.out.println(s.charAt(1));
		 
		 
		 String s1 = new String("hanuma");
		 if(s==s1) {
			 //s==s1 -> false
			 //if s1=s then it will be true
			 System.out.println("== : "+true+s.compareTo(s1));
		 }
		 
		 String s2 = new String(" ");
		 if(s.equals(s1)) {
			 System.out.println("equals : "+true);
		 }
		 
		 System.out.println(String.format("|%n|",10));
		 System.out.println(s2.isEmpty());
		 
		 String str = "This is index of example";  
	        int index = str.lastIndexOf('s',5);  
	        System.out.println(str.substring(str.length()-1));   
	        
	        char[] ss = {'a','b'};
	        String sss = new String(ss);
		 
		 String ha = new String("hanuma");
		 String ha1 = new String("hanuma");
		 System.out.println(ha.equals(ha1));
		 System.out.println(ha==ha1);
		 System.out.println(ha!=ha1);
		 
	 }
	
	

}
