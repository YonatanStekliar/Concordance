package finalProject;
 
import java.util.Arrays;


public class MyList<T> {
	private WordAndIndex[] wordAndIndexArr;
	private int size = 0;
	private static final int DEAFULT_SIZE = 10;

	public MyList() {
		wordAndIndexArr = new WordAndIndex[DEAFULT_SIZE];
	}

	public void addOnlyIndexToExistingWord(int index, int indexToUpdate) { // adds the index of String to the array of indexes
		wordAndIndexArr[indexToUpdate].addIndex(index);
	}
	
	public void add(String str, int index) { // adds new String to the list of WordAndIndex
		if(size == wordAndIndexArr.length) 
			enlargeTheCpacity();
		wordAndIndexArr[size++] = new WordAndIndex(str,index);
	}
	
	private void enlargeTheCpacity() { // if the space in the list ends, enlarge the list
		int newSize = wordAndIndexArr.length*2;
		wordAndIndexArr = Arrays.copyOf(wordAndIndexArr, newSize);
	}

	public WordAndIndex get(int i) { // returns the element in the wanted index
		return wordAndIndexArr[i];
	}

	public int size() { // returns the size (number of elements in the list)
		return size;
	}

	public WordAndIndex[] getArrWords() { /// returns the Strings in the list
		return wordAndIndexArr;
	}
	
	public void set(int indexToChange, WordAndIndex element) { // changes the value of the String in the specific index
		wordAndIndexArr[indexToChange] = element;
	}
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<wordAndIndexArr.length; i++) {
			if(wordAndIndexArr[i]!=null) 
				sb.append(wordAndIndexArr[i]);
		}
		return sb.toString();
	}
}
