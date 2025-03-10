package lab22;

public class Word {

	public static final int ORIGINAL = 0, BYNAME = 1, BYCOUNTS = 2;
	private String theWord;
	private int count;
	private static int sortCriterion = ORIGINAL;
	
	public Word(String arg1, int arg2) {
		
		theWord = arg1;
		count = arg2;
	}
	
	public int getCount() {
		
		return count;
	}
	
	public String getWord() {
		
		return theWord;
	}
	
	public static void setCriterion(int arg) {
		
		if((arg == ORIGINAL) || (arg == BYNAME) || (arg == BYCOUNTS)) {
			sortCriterion = arg;
		}	
	}
	
	public int compareTo(Word arg) {
		int returnint = 0;
		if (sortCriterion == ORIGINAL) {
			returnint = 2;
		}
		else if(sortCriterion == BYCOUNTS) {
			if (count < arg.count) {
				returnint = -1;
			}
			else if(count == arg.count) {
				returnint = 0;
			}
			else if(count>arg.count){
				returnint = 1;
			}
		}
		else {
			returnint = theWord.compareTo(arg.theWord);
		}
		return returnint;
	}
	
	public String toString() {
		
		return String.format("Word: %10s	Count: %3d", theWord,count);
	}
	
}