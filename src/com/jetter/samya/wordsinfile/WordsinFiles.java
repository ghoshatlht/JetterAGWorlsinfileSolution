/**
 * 
 */
package com.jetter.samya.wordsinfile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

/**
 * @author Samya
 *
 */


// Create a new class called WordsInFiles . Put all the remaining listed items in this class.//


public class WordsinFiles {
	
	 /*Create a private variable to store a HashMap that maps a word to an ArrayList of
	filenames.*/
	
	private HashMap<String, ArrayList<String>> myMap;
	
	// Write a constructor to initialize the HashMap variable, Using Default constructor to initialize the HashMap variable
	
	
	public WordsinFiles() 
	{
        myMap = new HashMap<String, ArrayList<String>>();
        
    }

	
	/* Write a private void method named addWordsFromFile that has one parameter f of type File. This method should add all the words from f into the map. 
	 * If a word is not in the map then must create a new ArrayList of type String with this word. 
	 * and have the word map to this ArrayList. If a word is already in the map, 
	 * then add the current filename to its ArrayList, unless the filename is already in the ArrayList.
	 * 
	 */
	
	
	private void addWordsFromFile(File file) 
	{
        FileResource frs = new FileResource(file.toString());
        String allName = file.getName();
       
        for (String word: frs.words()) 
        {
            if (!myMap.containsKey(word)) {
            	myMap.put(word, new ArrayList<String>());
            	myMap.get(word).add(allName);
            }
            else if (myMap.containsKey(word))
            {
                if (!myMap.get(word).contains(allName)) myMap.get(word).add(allName);
            }
        }
        
    }
	
	
	
	/*Write a void method named buildWordFileMap that has no parameters
	 * This method first clears the map, and then uses a DirectoryResource to select a group of files.
	 * For each file, it puts all of its words into the map by calling the method addWordsFromFile 
	 * The remaining methods to write all assume that the HashMap has been built.
	 */
	
	
	
	private void buildWordFileMap() 
	{
        myMap.clear();  // clear the map 
        DirectoryResource dr = new DirectoryResource();
        for (File file: dr.selectedFiles()) 
        {
            addWordsFromFile(file);
        }
        
    }
	
	
	
	
	
	/* Write the method maxNumber that has no parameters
	 * This method returns the maximum number of files any word appears in, considering all words from a group of files
	 * 
	 */
	
	
	private int maxNumber() 
	{
		int maximumnumber = 0;
		int currentnumber = 0;
        
        
        for (String word: myMap.keySet())
        {
        	currentnumber = myMap.get(word).size();
            if (maximumnumber < currentnumber)maximumnumber = currentnumber ;
        }
        
        return maximumnumber;
    }
	
	
	
	
	/* Write the method wordsInNumFiles that has one integer parameter called number .
	 * This method returns an ArrayList of words that appear in exactly number files.
	 */
	
	
	private ArrayList<String> wordsInNumFiles(int number)
{
        int currentnumber = 0;
     // Constructs an empty list to add words here //
        
        ArrayList<String> wordlist = new ArrayList<String>(); 
        for (String word: myMap.keySet()) 
        {
            currentnumber = myMap.get(word).size();
            if (currentnumber==number) wordlist.add(word);
        }
        return wordlist;
    }
	
	
	
	
	/* Write the void method printFilesIn that has one String parameter named word .
	 * This method prints the names of the files this word appears in, one filename per line. 
	 */
	
	
	 private void printFilesIn(String word) 
	 {
	        System.out.println("These files contain this word:  "+word+" is the word : \t ");
	        
	        ArrayList<String> list = new ArrayList<String>();
	        for (String current: myMap.keySet())
	        {
	            if (current==word) list = myMap.get(current);
	        }
	        for (int i = 0; i < list.size(); i++) 
	        {
	            System.out.println(list.get(i)+" ");
	        }
	    }
	
	
	/* Write the void method tester that has no parameters.
	 * This method should call buildWordFileMap() to select a group of files and build a HashMap of words, with each word mapped to an ArrayList of the filenames this word appears in.
	 * determine the maximum number of files any word is in, considering all words.
	 * determine all the words that are in the maximum number of files and for each such word, print the filenames of the files it is in.
	 */
	
	
	 
	 public void tester() 
	 {
	        buildWordFileMap();
	        int maximummuber = maxNumber();
	        ArrayList<String> list = wordsInNumFiles(maximummuber);
	        
	        System.out.println("The Highest number of files a word appears is:  "+maximummuber+", here is "+list.size()+ "  words : "  );
	        for (int i = 0; i < list.size(); i++)
	        {
	            System.out.println(list.get(i)+"\t");
	        }
	        System.out.println("\t");
	        for (int j = 0; j < list.size(); j++) 
	        {
	            printFilesIn(list.get(j));
	        }
	        
	        
	    }
	
}





