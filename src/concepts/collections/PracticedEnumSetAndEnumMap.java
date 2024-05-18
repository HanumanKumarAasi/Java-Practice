package concepts.collections;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

enum days {  
	  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY  
	}  

public class PracticedEnumSetAndEnumMap {
	private final static String VALUE="value";
	public static void main(String args[]) {
		/*
		 * Java EnumSet class is the specialized Set implementation for use with enum
		 * types. It inherits AbstractSet class and implements the Set interface.
		 */		
		
		Set<days> enumSetAddOF = EnumSet.allOf(days.class);// adds all the enums from the enum class
		Set<days> enumSetOF = EnumSet.of(days.FRIDAY,days.SUNDAY);// adds only friday and Sunday
		Set<days> enumSetNoneOf = EnumSet.noneOf(days.class); // not goinf to add anythong
		
		//All the other set methods
		
		/*
		 * Java EnumMap class is the specialized Map implementation for enum keys. It
		 * inherits Enum and AbstractMap classes.
		 */		
		EnumMap<days, String> enumMap = new EnumMap<>(days.class);
		enumMap.put(days.MONDAY, "1st day");
		enumMap.put(days.TUESDAY, "2nd day");
		enumMap.put(days.WEDNESDAY, "3rd day");
		enumMap.put(days.THURSDAY, "4th day");
		enumMap.put(days.FRIDAY, "5th day");
		enumMap.put(days.SATURDAY, "6th day");
		enumMap.put(days.SUNDAY, "weekend");
		//All the other map methods
	}

}
