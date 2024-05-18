package concepts.otherimport;

public class SingletonClass {
	
	/*
	 * This is the class were only one object can be created for it. we can create
	 * the another instace by making the previous instance null;
	 */
	private static volatile SingletonClass singletonClassInstance = null;
	
	
	
	private SingletonClass() {
		System.out.println("Singleton instance created");
	}
	
	public static SingletonClass getSingletonClassInstace() {
		if(singletonClassInstance==null) {
			synchronized (SingletonClass.class) {
				if(singletonClassInstance==null) {
					singletonClassInstance = new SingletonClass();
				}
			}
		}
		return singletonClassInstance;
		
	}

}
