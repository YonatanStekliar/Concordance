package finalProject;

import java.util.Arrays;

public class WordAndIndex {
	
	private String word;
	private int [] theIndexes;
	private int indexesCounter = 0;
	
	public WordAndIndex(String word, int index) { 
		this.word = word;
		theIndexes = new int [10];
		addIndex(index);
	}
	
	public void addIndex(int index) { // adds index to the collection of indexes of an existing srting
		if(indexesCounter == theIndexes.length) 
			enlargeTheCpacity();
		theIndexes[indexesCounter++]=index; 
	}
	
	private void enlargeTheCpacity() { // // if the space in the list ends, enlarge the list
		int newSize = theIndexes.length*10;
		theIndexes = Arrays.copyOf(theIndexes, newSize);
	}

	public String getWord() { // get the String
		return word;
	}

	public int[] getIndex() { // get the array of indexes
		return theIndexes;
	}
	
	public boolean getSpecificLineIndex(int i) { // get the specific index
		int specificIndex =  theIndexes[i];
		if(specificIndex!=0)
			return true;
		return false;
	}

	public int getHowManyIndexes() { // get the number of indexes
		return indexesCounter;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(word+", "+ "The indexes are: ");
		for(int i=0; i<theIndexes.length; i++) {
			if(theIndexes[i]!=0)
				sb.append(theIndexes[i]+" ");
		}
		sb.append("\n");
		return sb.toString();
	}
}
