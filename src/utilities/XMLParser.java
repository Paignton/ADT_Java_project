package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import utilities.MyArrayList;
import utilities.MyQueue;
import utilities.MyStack;

public class XMLParser {

	// Constants
	private static final String OPEN_TAG = "<";
	private static final String CLOSE_TAG = ">";
	private static final String END_TAG = "/";
	private static final String XML_OPEN = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

	// Attributes
	private MyQueue<XMLTag> errorQue = new MyQueue<XMLTag>();
	private MyStack<XMLTag> tagStack = new MyStack<XMLTag>();
	private MyQueue<XMLTag> extrasQue = new MyQueue<XMLTag>();
	public MyArrayList<String> xmlLines;
	public String fileName;

	/**
	 * method to read in the xml file to a MyArrayList of string object
	 * String per line of XML
	 */

	// Constructors
	public XMLParser(String fileName)
	{
		this.fileName = fileName;
	}

	/**
	 * Method to read in the XML file to a MyArrayList of String objects,
	 * one String per line of XML.
	 **/
	public void inputXML() throws FileNotFoundException{
		
	
		xmlLines = new MyArrayList<String>();
		Scanner in = new Scanner(new File(fileName));
		String open = in.nextLine();
		if (open == XML_OPEN) {

			
		}
		
		while(in.hasNextLine()) {
			xmlLines.add(in.nextLine());
		}
		/*
		String first = in.nextLine();
		System.out.println(first);
		String second = in.nextLine();
		System.out.println(second);
		String third = in.nextLine();
		System.out.println(third);
		
		xmlLines.add(first);
		xmlLines.add(second);
		xmlLines.add(third);
		*/
		
		
	}


	/**
	 * Method to parse lines of XML from MyArrayList to a queue of XMLTag
	 * Objects. and do some error checking occurs here (unnecessary close tags)
	 * @throws FileNotFoundException 
	 **/
	public void parseXML() throws EmptyQueueException, FileNotFoundException{
	
		
		for(int i = 0; i < xmlLines.size(); i++) {
			String line = xmlLines.get(i);
			
			
		
			int indexOfOpenTag = xmlLines.get(i).indexOf(OPEN_TAG);
			int indexOfCloseTag = xmlLines.get(i).indexOf(CLOSE_TAG);
			
			
		
			
			String startTag = xmlLines.get(i).substring(indexOfOpenTag,indexOfCloseTag+1);
	
			
			if(line.substring(indexOfCloseTag-1, indexOfCloseTag).equals(END_TAG) ) {
				continue;
			}
		
			
	
			if((xmlLines.get(i)).contains(OPEN_TAG) && (xmlLines.get(i)).contains(CLOSE_TAG) && !(xmlLines.get(i)).contains(END_TAG) ) {
				XMLTag newTag = new XMLTag(line.substring(line.indexOf(OPEN_TAG)+1, line.indexOf(CLOSE_TAG)), false);
				tagStack.push(newTag);
            }
		
			if((xmlLines.get(i)).contains(OPEN_TAG) && (xmlLines.get(i)).contains(CLOSE_TAG) && (xmlLines.get(i)).contains(END_TAG) ) {
				XMLTag compareTag = new XMLTag(line.substring(line.indexOf(OPEN_TAG)+2, line.indexOf(CLOSE_TAG)), false);
				System.out.println(compareTag.getTagName());
				
				if(tagStack.peek().getTagName().equals(compareTag.getTagName())){
					tagStack.pop();
					System.out.println(tagStack.size());
				}
				
            }
				
			
		

			

		}
			
			
			
			
			
			
			
			
			
		
		
		
		
	}
	


}
