/**
 * Created by dullam on 8/7/17.
 */
public class FindWord {

    public int rows;
    public int columns;
    public int[][] solutionMatrix;

    public boolean isthere(char[][] characterMatrix, String word) {
        char c = word.charAt(0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (characterMatrix[i][j] == c) {
                    solutionMatrix[i][j] = 1;
                    boolean iswordExist = wordExists(characterMatrix, i, j, word, 1);
                    if (iswordExist) {
                        return true;
                    } else {
                        for (int k = 0; k < rows; k++) {
                            for (int l = 0; l < columns; l++) {
                                solutionMatrix[k][l] = 0;
                            }
                        }
                    }
                }
            }
        }

        return false;

    }

    public boolean wordExists(char[][] characters, int i, int j, String word, int index) {
        if (index == word.length())
            return true;
        for (int row = i-1; row <= i + 1 && row < rows; row++) {
            for (int column = j - 1; column <= j + 1 && column < columns; column++) {
                if (row >= 0 && column >= 0) {
                    if (characters[row][column] == word.charAt(index)) {
                        if (wordExists(characters, row, column, word, index + 1)) {
                            solutionMatrix[row][column] = 1;
                            return true;
                        }
                    }
                }
            }
        }
        solutionMatrix[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        String word = "pet";
        char[][] characters = new char[4][4];
        FindWord words = new FindWord();

        characters[0][0] = 'd';
        characters[0][1] = 'a';
        characters[0][2] = 'e';
        characters[0][3] = 'x';

        characters[1][0] = 'f';
        characters[1][1] = 't';
        characters[1][2] = 'p';
        characters[1][3] = 'f';

        characters[2][0] = 'a';
        characters[2][1] = 'p';
        characters[2][2] = 'a';
        characters[2][3] = 'y';

        characters[3][0] = 'a';
        characters[3][1] = 'b';
        characters[3][2] = 'p';
        characters[3][3] = 'f';

        words.rows = characters.length;
        words.columns = characters[0].length;
        words.solutionMatrix = new int[words.rows][words.columns];

        System.out.println("Given Matrix is : " + " \n");
        for (int i = 0; i < words.rows; i++) {
            for (int j = 0; j < words.columns; j++) {
                System.out.print(" " + characters[i][j] + " ");
            }
            System.out.println("\n");
        }

        System.out.println("Solution Martix is :" + " \n");

        if (words.isthere(characters, word)) {
            for (int i = 0; i < words.rows; i++) {
                for (int j = 0; j < words.columns; j++) {
                    if (words.solutionMatrix[i][j] == 0)
                        System.out.print(" 0 ");
                    else
                        System.out.print(" " + characters[i][j] + " ");

                }
                System.out.println("\n");
            }

        } else {
            System.out.println("No Path Found");
        }
    }

}