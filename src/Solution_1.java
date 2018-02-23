/**
 * Created by dullam on 1/25/18.
 */
class Solution_1 {

//    public int cherryPickup(int[][] grid) {
//        /*Assuming that given array is not jagged*/
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int[][] sol= new int[rows][cols];
//        //sol = this.findMaxPath(grid,rows,cols);
//        int cherriesFromFirstMaxPath = sol[0][0];
//        if(cherriesFromFirstMaxPath <=0) return cherriesFromFirstMaxPath;
//        this.pickCherries(sol,grid,0,0,rows,cols);
//
//        for(int i=0;i<=rows-1;i++) {
//            for(int j=0;j<=cols-1;j++) {
//                sol[i][j]=0;
//            }
//        }
//
//        //sol = this.findMaxPath(grid,rows,cols);
//        int cherriesFromSecondMaxPath = sol[0][0];
//        return cherriesFromSecondMaxPath + cherriesFromFirstMaxPath;
//    }
//    private void pickCherries(int[][] sol, int[][] grid,int i,int j,int rows, int cols) {
//
//        grid[i][j] =0;
//
//        if(i==row-1 && j== cols-1) { return; }
//
//        if((i+1) > rows-1) {
//            pickCherries(sol,grid,i,j+1,rows,cols);
//        } else if((j+1) > cols-1) {
//            pickCherries(sol,grid,i+1,j,rows,cols);
//        } else {
//            if(sol[i+1][j] > sol[i][j+1])
//                pickCherries(sol,grid,i+1,j,rows,cols);
//            else
//                pickCherries(sol,grid,i,j+1,rows,cols);
//        }
//    }
//
//    private int[][] findMaxPath(int[][] sol, int[][] grid, int rows, int cols) {
//        /** Go down and right and find max path at each (i,j) to (N-1, N-1) */
//        for(int i=rows-1; i >= 0 ; i--) {
//            for(int j=cols-1; j >= 0; j--) {
//                if(i==rows-1 && j==cols-1)   {
//                    sol[i][j]=grid[i][j];
//                    continue;
//                }
//                if(grid[i][j] == -1) {
//                    sol[i][j] = -1;
//                    continue;
//                }
//                if((i+1) > rows-1) {
//                    if(sol[i+1][j] !=-1)
//                        sol[i][j] = grid[i][j] + sol[i][j+1];
//                    else
//                        sol[i][j] = -1;
//                } else if((j+1) > cols-1) {
//                    if(sol[i+1][j] !=-1)
//                        sol[i][j] = grid[i][j] + sol[i+1][j];
//                    else
//                        sol[i][j] = -1;
//                } else {
//                    if (sol[i+1][j]!= -1 && sol[i][j+1]!= -1) {
//                        sol[i][j] = grid[i][j] + Math.max(sol[i+1][j],sol[i][j+1]);
//                    }else if(sol[i+1][j] == -1 && sol[i][j+1] == -1 ) {
//                        sol[i][j] = -1;
//                    }else if(sol[i+1][j] == -1) {
//                        sol[i][j] = grid[i][j] + sol[i][j+1];
//                    }else if(sol[i][j+1] == -1){
//                        sol[i][j] = grid[i][j] + sol[i+1][j];
//                    }
//                }
//            }
//        }
//        return sol;
//    }

}