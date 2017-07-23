/**
 * Created by siddharthjoseph on 7/21/17.
 */
public class LongestCommonSubstring {
    static int[][] array;
    static int row;
    static int column;

    public static StringBuffer returnString(String str1) {
        String str = new String("");
        while (array[row][column] != 0) {
            str += str1.charAt(row - 1);
            row--;
            column--;
        }
        return new StringBuffer(str).reverse();
    }

    public static int findLongestSubsrting(String str1, String str2) {
        array = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            array[i][0] = 0;
        }
        for (int j = 0; j <= str2.length(); j++) {
            array[0][j] = 0;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        int max = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    row = i;
                    column = j;

                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------");
        System.out.println("Longest Common Substring is of length " + findLongestSubsrting(args[0], args[1]) + " String is " + returnString(args[0]));
        System.out.println("------------------------------------------------------------");

    }
}
