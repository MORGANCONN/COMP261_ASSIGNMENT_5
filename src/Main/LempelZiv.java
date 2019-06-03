package Main;

import java.util.Scanner;

/**
 * A new instance of Main.LempelZiv is created for every run.
 */
public class LempelZiv {
    String inputString;

    /**
     * Take uncompressed input as a text string, compress it, and return it as a
     * text string.
     */
    public String compress(String input) {
        this.inputString = input;
        StringBuilder output = new StringBuilder();
        int cursor = 0;
        int windowSize = 800;
        while (cursor < input.length()) {
            int length = 0;
            int prevMatch = 0;
            while (true) {
                // Chooses either the cursor or the window size to determine the window, preventing exceptions
                int searchStart = Math.min(cursor, windowSize);
                // Generates text to search
                StringBuilder toCheck = new StringBuilder();
                for (int i = cursor - searchStart; i < cursor; i++) {
                    toCheck.append(input.charAt(i));
                }
                // Generates pattern to check against
                StringBuilder patternToCheck = new StringBuilder();
                if (length == 0) {
                    patternToCheck.append(input.charAt(cursor));
                } else {
                    for (int i = cursor; i <= cursor + length; i++) {
                        if (cursor + length < input.length())
                            patternToCheck.append(input.charAt(i));
                    }
                }
                int match = new KMP(patternToCheck.toString(), toCheck.toString()).search();
                if (match != -1) {
                    prevMatch = cursor - ((cursor - searchStart) + match);
                    length++;
                } else {
                    String nextChar = "";
                    if (cursor + length < input.length()) {
                        nextChar = String.valueOf(input.charAt(cursor + length));
                    }
                    output.append(prevMatch).append("|").append(length).append("|").append(nextChar).append("]");
                    cursor = cursor + length + 1;
                    break;
                }
            }
        }
        return output.toString();
    }

    /**
     * Take compressed input as a text string, decompress it, and return it as a
     * text string.
     */
    public String decompress(String compressed) {
        int cursor = 0;
        Scanner scn = new Scanner(compressed).useDelimiter("([|\\]])");
        StringBuilder output = new StringBuilder();
        while (scn.hasNext()) {
            int offset = scn.nextInt();
            int length = scn.nextInt();
            String nextChar = scn.next();
            char chr = 0;
            if (!nextChar.equals("")) {
                chr = nextChar.charAt(0);
            }
            if (offset == 0 && length == 0) {
                output.append(chr);
                cursor++;
            } else {
                int currentCursorValue = cursor;
                for (int i = currentCursorValue - offset; i < currentCursorValue - offset + length; i++) {
                    output.append(output.charAt(i));
                    cursor++;
                }
                output.append(chr);
                cursor++;
            }
        }
        String toReturn = output.toString();
        return toReturn;
    }

    /**
     * The getInformation method is here for your convenience, you don't need to
     * fill it in if you don't want to. It is called on every run and its return
     * value is displayed on-screen. You can use this to print out any relevant
     * information from your compression.
     */
    public String getInformation() {
        return "";
    }
}
