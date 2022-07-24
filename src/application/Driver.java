package application;



import java.io.FileNotFoundException;

import utilities.EmptyQueueException;
import utilities.MyArrayList;
import utilities.XMLParser;

public class Driver {

	public static <E> void main(String[] args) throws FileNotFoundException, EmptyQueueException {
		MyArrayList<String> myarray = new MyArrayList<String>();
		MyArrayList<String> toAdd = new MyArrayList<String>();
		String[] to = new String[3];


		String SAMPLE1 = "res/sample1.xml";

		XMLParser xmlParser = new XMLParser(SAMPLE1);

		xmlParser.inputXML();
		xmlParser.parseXML();

		//System.out.println(xmlParser.xmlLines.get(0));





		/*
		toAdd.add( "lola");
		toAdd.add("lola1");
		toAdd.add( "lola2");
		System.out.println(toAdd.get(0)+", " + toAdd.get(1) + ", " + toAdd.get(2));



		myarray.add("hello");
		myarray.add("hello1");
		myarray.add( "hello2");

		to = myarray.toArray(to);



		System.out.println("!!"+ myarray.iterator().next());
		System.out.println("!!"+ myarray.iterator().next());
		System.out.println("!!"+ myarray.iterator().hasNext());
		System.out.println("!!"+ myarray.iterator().hasNext());

		System.out.println(myarray.size());

		System.out.println(myarray.set(0,  "hello6"));
		System.out.println(myarray.set(2, "welcome"));
		System.out.println(myarray.size());

		System.out.println(myarray.get(0)+", " + myarray.get(1) + ", " + myarray.get(2));

		System.out.println(myarray.addAll(toAdd));


		System.out.println(myarray.size());
		System.out.println(myarray.get(3)+", " + myarray.get(4) + ", " + myarray.get(5));


		System.out.println(myarray.contains("hello4"));
		System.out.println(myarray.contains( "hello3"));
		System.out.println(myarray.contains( "hello2"));
		myarray.remove(2);
		System.out.println(myarray.size());
		System.out.println(myarray.get(0)+", " + myarray.get(1));
		myarray.remove(1);
		System.out.println(myarray.size());
		System.out.println(myarray.get(0));
		myarray.remove(0);

		//System.out.println(myarray.remove((E) "hello2"));

		System.out.println("after remove " + myarray.size());

		myarray.add( "hello");
		myarray.add( "hello1");
		myarray.add( "hello2");
		System.out.println("after add " + myarray.size());

		myarray.clear();
		System.out.println(myarray.size());

		System.out.println("empty? " + myarray.isEmpty());
		System.out.println();
		 */
	}

}
