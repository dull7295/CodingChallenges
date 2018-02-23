package backtracking;

/**
 * Created by dullam on 8/6/17.
 */
public class FindWordIn2DMatrix {
    public int[][] solution;
    public int rows=0;
    public int columns=0;

    public boolean checkIfWordExits(char[][] matrix, String word) {
        char c = word.charAt(0);
        System.out.println("  " +rows + " " + columns );

        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                if(matrix[i][j] == c){
                    solution[i][j]=1;
                    System.out.println("calling-->  " +i + " " + j );
                    if(isWordExists(matrix,i,j,word,1)){
                        return true;
                    } else {
                        for(int x=0;x<rows;x++)
                            for(int y=0;y<columns;y++)
                                solution[x][y]=0;
                    }
                }
            }
        }
        return false;
    }

    private boolean isWordExists(char[][] a,int i,int j, String word,int index) {
        if(index == word.length()) {
            System.out.println("index =  " + index +  " word len =  " + word.length());
            return true;
        }

        for(int row=i-1; row<=i+1 && row<rows ;row++) {
            for(int column=j-1; column<=j+1 && column<columns;column++) {
                System.out.println(" " +row + " " + column);
                if(row>=0 && column>=0) {
                    if(a[row][column]==word.charAt(index)) {
                        System.out.println(" " + row + " " + column );
                        if(isWordExists(a,row,column,word,index+1)) {
                            solution[row][column]=1;
                            return true;
                        }
                    }
                }
            }
        }
        /* */
        solution[i][j]=0;
        return false;
    }

    public static void main(String[] args) {
        char[][] twoDArray = new char[5][5];
        /* First row */
        twoDArray[0][0]='t';
        twoDArray[0][1]='z';
        twoDArray[0][2]='x';
        twoDArray[0][3]='c';
        twoDArray[0][4]='d';

         /* Second row */
        twoDArray[1][0]='a';
        twoDArray[1][1]='h';
        twoDArray[1][2]='b';
        twoDArray[1][3]='z';
        twoDArray[1][4]='x';


        /* Third row */
        twoDArray[2][0]='h';
        twoDArray[2][1]='w';
        twoDArray[2][2]='o';
        twoDArray[2][3]='i';
        twoDArray[2][4]='o';

         /* Fourth row */
        twoDArray[3][0]='o';
        twoDArray[3][1]='r';
        twoDArray[3][2]='p';
        twoDArray[3][3]='r';
        twoDArray[3][4]='n';

         /* Fifth row */
        twoDArray[4][0]='a';
        twoDArray[4][1]='b';
        twoDArray[4][2]='r';
        twoDArray[4][3]='i';
        twoDArray[4][4]='n';

        FindWordIn2DMatrix fw = new FindWordIn2DMatrix();
        fw.rows = twoDArray.length;
        fw.columns= twoDArray[0].length;
        fw.solution = new int[fw.rows][fw.columns];

        System.out.println("\n");
        for(int x=0;x<fw.rows;x++) {
            for(int y=0;y<fw.columns;y++)
            {
                    System.out.print("  " +twoDArray[x][y] + "  ");
            }
            System.out.println("\n");
        }


        if(fw.checkIfWordExits(twoDArray,"rin")) {
            System.out.println(" found given word at the following position");
            for(int x=0;x<fw.rows;x++) {
                for(int y=0;y<fw.columns;y++)
                {
                    if(fw.solution[x][y]== 0){
                        System.out.print("  0  ");
                    } else {
                        System.out.print("  " +twoDArray[x][y] + "  ");
                    }
                }
                System.out.println("\n");
            }

        } else {
            System.out.println(" Did not find given word in the given Matrix");
        }


    }
}
