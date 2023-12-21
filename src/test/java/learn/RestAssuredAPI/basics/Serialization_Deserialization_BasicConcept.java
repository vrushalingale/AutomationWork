package learn.RestAssuredAPI.basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable {
	int i = 10, y = 20;
}

public class Serialization_Deserialization_BasicConcept {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Test t1 = new Test();
		
		//-----------Serialization--------------
		
		//Creating Output Stream to write Test class data into binary format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\java\\learn\\RestAssuredAPI\\basics\\test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//Saving Test object data into test.txt file
		oos.writeObject(t1);
		
		//--------------De-Serialization--------------
		
		//Referring test.txt file to read its data
		FileInputStream fis = new FileInputStream(".\\src\\test\\java\\learn\\RestAssuredAPI\\basics\\test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//Creating Object with t2 reference to read data from test.txt File
		Test t2 = (Test) ois.readObject();
		System.out.println("i= "+ t2.i +" "+ "y= "+ t2.y);
	}
}
