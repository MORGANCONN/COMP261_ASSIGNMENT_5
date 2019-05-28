package Main;

/**
 * A new Main.KMP instance is created for every substring search performed. Both the
 * pattern and the text are passed to the constructor and the search method. You
 * could, for example, use the constructor to create the match table and the
 * search method to perform the search itself.
 */
public class KMP {
	private int searchTable[];
	public KMP(String pattern, String text) {
		searchTable = generateKMPSearchTable(pattern);
	}

	/**
	 * Generates a KMP search table
	 * @param pattern the pattern that is having a table generated
	 * @return the generated table
	 */
	static public int[] generateKMPSearchTable(String pattern) {
		int[] toReturn = new int[pattern.length()];
		char[] charPattern = pattern.toCharArray();
		int i = 0;
		int j = 0;
		while(i<toReturn.length){
			if(i==0){
				toReturn[i] = 0;
				i++;
			} else if(charPattern[i]==charPattern[j]){
				toReturn[i] = j+1;
				i++;
				j++;
			} else{
				toReturn[i]=0;
				j = 0;
				i++;
			}
		}
		return toReturn;
	}

	/**
	 * Perform Main.KMP substring search on the given text with the given pattern.
	 * 
	 * This should return the starting index of the first substring match if it
	 * exists, or -1 if it doesn't.
	 */
	public int search(String pattern, String text) {
		// TODO fill this in.
		return -1;
	}
}
