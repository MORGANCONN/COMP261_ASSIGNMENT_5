package Main;

import java.util.Scanner;

/**
 * A new instance of Main.LempelZiv is created for every run.
 */
public class LempelZiv {
    /**
     * Take uncompressed input as a text string, compress it, and return it as a
     * text string.
     */
    public String compress(String input) {
        StringBuilder output = new StringBuilder();
        int cursor = 0;
        int windowSize = 100;
        while (cursor < input.length()) {
            int length = 0;
            int prevMatch = 0;
            while (true) {
                int searchStart = Math.min(cursor,windowSize);
                int match = new KMP(((length==0)?String.valueOf(input.charAt(cursor)):input.substring(cursor,cursor+length)),input.substring(cursor-searchStart,cursor)).search();
                if (match != -1) {
                    prevMatch = cursor-match;
                    length++;
                } else {
                    output.append(prevMatch).append("|").append(length).append("|").append(input.charAt(cursor + length)).append("]");
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
            char chr = scn.next().charAt(0);
            if (offset == 0 && length == 0) {
                output.append(chr);
                cursor++;
            } else {
                output.append(output.substring(cursor - offset, cursor - offset + length));
                cursor = cursor + length;

            }
        }
        return output.toString();
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
