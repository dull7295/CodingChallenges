package backtracking;

/**
 * Created by dullam on 4/14/18.
 */
public class FindWordLeetCode {
    int[][] sol;

    public boolean exist(char[][] board, String word) {
        sol = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    sol[i][j] = 1;
                    if (findWord(board, i, j, word, 1))
                        return true;
                    else
                        resetSol();
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;

        if(j-1 >= 0 && sol[i][j-1] != 1 && board[i][j-1] == word.charAt(index)) {
            sol[i][j-1] = 1;
            if (findWord(board, i, j-1, word, index + 1))
                return true;
            else
                sol[i][j-1] = 0;
        }

        if(j+1 <= board[0].length && sol[i][j+1] != 1 && board[i][j+1] == word.charAt(index)) {
            sol[i][j+1] = 1;
            if (findWord(board, i, j+1, word, index + 1))
                return true;
            else
                sol[i][j+1] = 0;
        }

        if(i-1 >= 0 && sol[i-1][j] != 1 && board[i-1][j] == word.charAt(index)) {
            sol[i-1][j] = 1;
            if (findWord(board, i-1, j, word, index + 1))
                return true;
            else
                sol[i-1][j] = 0;
        }

        if(i+1 <= board.length && sol[i+1][j] != 1 && board[i+1][j] == word.charAt(index)) {
            sol[i+1][j] = 1;
            if (findWord(board, i+1, j, word, index + 1))
                return true;
            else
                sol[i+1][j] = 0;
        }


        return false;
    }

    private void resetSol() {
        for (int i = 0; i < sol.length; i++)
            for (int j = 0; j < sol[0].length; j++)
                sol[i][j] = 0;
    }

    public int trailingZeroes(int n) {
        int res = 0, rem = n%10;

        while(n > 0)
        {
            n = n/10;
            res += 2;
        }
        if(rem >= 5)
            res += 1;
        return res;
    }

    public static void main(String[] args) {


        char[][] twoDArray = new char[2][2];
        /* First row */
        twoDArray[0][0]='a';
        //twoDArray[0][1]='b';
//        twoDArray[1][0]='c';
//        twoDArray[1][1]='d';
        //twoDArray[0][4]='d';

//         /* Second row */
//        twoDArray[1][0]='a';
//        twoDArray[1][1]='h';
//        twoDArray[1][2]='b';
//        twoDArray[1][3]='z';
//        twoDArray[1][4]='x';
//
//
//        /* Third row */
//        twoDArray[2][0]='h';
//        twoDArray[2][1]='w';
//        twoDArray[2][2]='o';
//        twoDArray[2][3]='i';
//        twoDArray[2][4]='o';
//
//         /* Fourth row */
//        twoDArray[3][0]='o';
//        twoDArray[3][1]='r';
//        twoDArray[3][2]='p';
//        twoDArray[3][3]='r';
//        twoDArray[3][4]='n';
//
//         /* Fifth row */
//        twoDArray[4][0]='a';
//        twoDArray[4][1]='b';
//        twoDArray[4][2]='r';
//        twoDArray[4][3]='i';
//        twoDArray[4][4]='n';

        FindWordLeetCode findWordLeetCode = new FindWordLeetCode();
        System.out.println(" found given word " + findWordLeetCode.trailingZeroes(216));

        //System.out.println(" found given word " + findWordLeetCode.exist(twoDArray, "ab"));

//        FindWordIn2DMatrix fw = new FindWordIn2DMatrix();
//        fw.rows = twoDArray.length;
//        fw.columns= twoDArray[0].length;
//        fw.solution = new int[fw.rows][fw.columns];
//
//        System.out.println("\n");
//        for(int x=0;x<fw.rows;x++) {
//            for(int y=0;y<fw.columns;y++)
//            {
//                System.out.print("  " +twoDArray[x][y] + "  ");
//            }
//            System.out.println("\n");
//        }
//
//
//        if(fw.checkIfWordExits(twoDArray,"rin")) {
//            System.out.println(" found given word at the following position");
//            for(int x=0;x<fw.rows;x++) {
//                for(int y=0;y<fw.columns;y++)
//                {
//                    if(fw.solution[x][y]== 0){
//                        System.out.print("  0  ");
//                    } else {
//                        System.out.print("  " +twoDArray[x][y] + "  ");
//                    }
//                }
//                System.out.println("\n");
//            }
//
//        } else {
//            System.out.println(" Did not find given word in the given Matrix");
//        }


    }

}
