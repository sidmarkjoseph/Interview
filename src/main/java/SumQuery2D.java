import java.util.Random;

/**
 * Created by siddharthjoseph on 7/22/17.
 */
public class SumQuery2D {
    static int[][] array;
    static int[][] basearray;
    static Random random = new Random();

    public static int query(int row1, int col1, int row2, int col2) {
        row1 = row1 + 1;
        col1 = col1 + 1;
        row2 = row2 + 1;
        col2 = col2 + 1;
        return array[row2][col2] - (array[row1 - 1][col2] + array[row2][col1 - 1]) + array[row1 - 1][col1 - 1];
    }

    public static void processArray(int number) {
        for (int i = 0; i <= number; i++) {
            array[i][0] = 0;
            array[0][i] = 0;
        }
        for (int i = 1; i <= number; i++) {
            array[i][1] = basearray[i - 1][0] + array[i - 1][1];
            array[1][i] = basearray[0][i - 1] + array[1][i - 1];
        }
        for (int i = 2; i <= number; i++) {
            for (int j = 2; j <= number; j++) {
                array[i][j] = basearray[i - 1][j - 1] + array[i][j - 1] + array[i - 1][j] - array[i - 1][j - 1];
            }
        }

    }

    public static void main(String[] args) {
        array = new int[Integer.parseInt(args[0]) + 1][Integer.parseInt(args[0]) + 1];
        basearray = new int[Integer.parseInt(args[0])][Integer.parseInt(args[0])];
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            for (int j = 0; j < Integer.parseInt(args[0]); j++) {
                basearray[i][j] = random.nextInt(10);
            }
        }
        System.out.println("------------Generated Matrix--------------\n");
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            for (int j = 0; j < Integer.parseInt(args[0]); j++) {
                System.out.print(basearray[i][j] + "    ");
            }
            System.out.println("\n");
        }
        System.out.println("---------------------------------------------\n");
        processArray(Integer.parseInt(args[0]));
        System.out.println("Query Sum with entered values " + query(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));


    }
}
