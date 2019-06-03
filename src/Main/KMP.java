package Main;

import java.util.ArrayList;

/**
 * A new Main.KMP instance is created for every substring search performed. Both the
 * pattern and the text are passed to the constructor and the search method. You
 * could, for example, use the constructor to create the match table and the
 * search method to perform the search itself.
 */
public class KMP {
    private int[] searchTable;
    private String toSearch;
    private String searchPattern;
    public Long timeTaken;
    public int comparisons;

    public KMP(String pattern, String text) {
        this.searchTable = generateKMPSearchTable(pattern);
        this.toSearch = text;
        this.searchPattern = pattern;
    }

    /**
     * Generates a KMP search table
     *
     * @param pattern the pattern that is having a table generated
     * @return the generated table
     */
    public static int[] generateKMPSearchTable(String pattern) {
        int[] toReturn = new int[pattern.length() + 1];
        char[] charPattern = pattern.toCharArray();
        int i = 0;
        int j = 0;
        while (i < toReturn.length - 1) {
            if (i == 0 || i == 1) {
                toReturn[i] = 0;
                i++;
            } else if (charPattern[i] == charPattern[j]) {
                toReturn[i] = j + 1;
                i++;
                j++;
            } else {
                j = 0;
                if (charPattern[i] == charPattern[j]) {
                    toReturn[i] = j + 1;
                    i++;
                    j++;
                } else {
                    toReturn[i] = 0;
                    i++;
                }

            }
        }
        for (int x = toReturn.length - 2; x >= 0; x--) {
            toReturn[x + 1] = toReturn[x];
        }
        return toReturn;
    }

    /**
     * Perform Main.KMP substring search on the given text with the given pattern.
     * <p>
     * This should return the starting index of the first substring match if it
     * exists, or -1 if it doesn't.
     */
    public int search() {
        long startTime = System.nanoTime();
        int i = 0;
        int j = 0;
        int stepsTaken = 0;
        char[] toSearch = this.toSearch.toCharArray();
        char[] searchPattern = new char[this.searchPattern.length() + 1];
        char[] toAdd = this.searchPattern.toCharArray();
        if (toAdd.length == 0) {
            return -1;
        }
        for (int q = 1; q < this.searchPattern.length() + 1; q++) {
            searchPattern[q] = toAdd[q - 1];
        }
        if (searchPattern.length == 0) {
            return -1;
        }

        while (i < toSearch.length) {
            stepsTaken++;
            if (toSearch[i] == searchPattern[j + 1]) {
                i++;
                j++;
                if (j == searchPattern.length - 1) {
                    timeTaken = (((System.nanoTime() - startTime) / 1000));
                    comparisons = stepsTaken;
                    return i - j;
                }
            } else {
                if (j > 0) {
                    j = searchTable[j];
                    stepsTaken++;
                }
                if (toSearch[i] == searchPattern[j+1]) {
                    i++;
                    j++;
                } else {
                    i++;

                }
            }
        }

        timeTaken = (((System.nanoTime() - startTime) / 1000));
        comparisons = stepsTaken;
        return -1;
    }

    public int bruteForce() {
        long startTime = System.nanoTime();
        int i = 0;
        int j = 0;
        int stepsTaken = 0;
        char[] toSearch = this.toSearch.toCharArray();
        char[] searchPattern = this.searchPattern.toCharArray();
        int currentSweepStart;
        while (i < toSearch.length) {
            stepsTaken++;
            if (toSearch[i] == searchPattern[j]) {
                currentSweepStart = i;
                while (j < searchPattern.length) {
                    stepsTaken++;
                    if (toSearch[i] == searchPattern[j]) {
                        if (j == searchPattern.length - 1) {
                            timeTaken = (((System.nanoTime() - startTime) / 1000));
                            comparisons = stepsTaken;
                            return i - j;
                        }
                        i++;
                        j++;
                    } else {
                        stepsTaken++;
                        i = currentSweepStart + 1;
                        j = 0;
                        break;
                    }
                }
            } else {
                i++;
            }
        }
        timeTaken = (((System.nanoTime() - startTime) / 1000));
        comparisons = stepsTaken;
        return -1;
    }


}
