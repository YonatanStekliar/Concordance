package finalProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Concordance {
	MyList<WordAndIndex> listOfWords;
	BufferedReader bufferReader;
	String str;
	String[] strArr;
	int indexOfLine = 1;
	int indexToUpdate;

	public Concordance() throws IOException {
		readFromFile();
		listOfWords = new MyList<WordAndIndex>();
		while (str != null) {
			strArr = str.split(" "); // makes strArr an array of words from the text file
			for (int i = 0; i < strArr.length; i++) {
				strArr[i] = removeNonAlphabetic(strArr[i]);
				if(isTheSameWord(strArr[i])) {
					addIndexToExistingWord(indexOfLine);
				}
				else
					listOfWords.add(strArr[i],indexOfLine); //adds the words to myList object
			}
			str = bufferReader.readLine(); // reads the next line and makes sure it exists
			indexLineCounter(); 
		}
		sort();
		createFileAndWriteToIt();
	}
	
	
	private void readFromFile() throws IOException { // read from file
		bufferReader = new BufferedReader(new FileReader(
				// Enter Your Directory));
		str = bufferReader.readLine(); // receives line from the text and put in a String
	}
	
	
	public void sort() { // sorts the myList alphabeticlly 
		WordAndIndex temp;
		for(int i=0; i<listOfWords.size(); i++) {
			for(int j=i+1; j<listOfWords.size(); j++) {
				if(listOfWords.get(i).getWord().compareTo(listOfWords.get(j).getWord())>0) {
					temp = listOfWords.get(i);
					listOfWords.set(i, listOfWords.get(j));
					listOfWords.set(j, temp);
				}
			}
		}
	} 
	
	public boolean isTheSameWord(String str) { // checks if the word is already in the list
		for(int i=0; i<listOfWords.size(); i++) {
			if(listOfWords.get(i).getWord().equalsIgnoreCase(str)) {
				indexToUpdate = i;
				return true;
			}
		}
		return false;
	}
	
	public void addIndexToExistingWord(int indexOfExistingWord) { // adds only the index to existing word
		listOfWords.get(indexToUpdate).addIndex(indexOfExistingWord);
	}

	public String removeNonAlphabetic(String str) { // removes all un-alphabetical chars
		str = str.replaceAll( "[^a-zA-Z0-9]", "");
		return str;
	}
	
	public int indexLineCounter() { //counts the number of lines
		indexOfLine++;
		return indexOfLine;
	}
	
	public void createFileAndWriteToIt() throws IOException { // opens text file and write to it the content of the concordance
		File theFile = new File(// Enter Your Directory));
		FileWriter writer = new FileWriter(theFile);
		writer.write(listOfWords.toString());
		writer.close();
	}
}
