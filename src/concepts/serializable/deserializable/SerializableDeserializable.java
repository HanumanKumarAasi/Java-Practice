package concepts.serializable.deserializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Function;

public class SerializableDeserializable {
	
	public static void main(String[] args) throws Exception
    {
 
        // Calling above method 3 and method 4
        // in the main() body
		SerializableDeserializableImpl.serializeAndDeserializeFunction();
    }

}

class SerializableDeserializableImpl {

	private static void serialize(Serializable obj, String outputPath) throws IOException {
		File outputFile = new File(outputPath);
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			outputStream.writeObject(obj);
		}
	}

	private static Object deserialize(String inputPath) throws IOException, ClassNotFoundException {
		File inputFile = new File(inputPath);
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inputFile))) {
			return inputStream.readObject();
		}
	}

	public static void serializeAndDeserializeFunction() throws Exception {
		Function<Student, String> fn = (Function<Student, String> & Serializable) (n) -> "";
		System.out.println("Run original function: " + fn.apply(new Student("hanuma", 25, "gudur", 102)));

		String path = "C:/Users/haasi/Downloads/serialized-fn";

		serialize((Serializable) fn, path);
		System.out.println("Serialized function to " + path);

		Function<Student, Student> deserializedFn = (Function<Student, Student>) deserialize(path);
		System.out.println("Deserialized function from " + path);
		System.out.println("Run deserialized function: " + deserializedFn.apply(new Student("hanuma", 25, "gudur", 102)));
	}

}

class Student {

	String name;
	int age;
	String location;
	int rollno;

	public Student(String name, int age, String location, int rollno) {
		super();
		this.name = name;
		this.age = age;
		this.location = location;
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", location=" + location + ", rollno=" + rollno + "]";
	}

}
