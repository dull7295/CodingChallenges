/**
 * Created by dullam on 7/5/17.
 */
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {

        String str1 = new String("MURALI");
        String str2 = new String("MURALI");

        String literal1 = "MURALI";

        String literal2 = "MURALI";

        System.out.println("Are literal equal " + (literal1 == literal2));

        System.out.println("Are strings equal " + (str1 == str2));


        System.out.println("Are string and literal equal " + (str1 == literal1));


        System.out.println("Are string and literal equal " + (str1.intern() == literal1.intern()));

        String board = Board.constructBoard();
        System.out.println("This is connect4 game board /n");
        System.out.println(board);
    }
}

class User {

    public String userType;
//    public Coin(String userType) {
//     this.userType  = userType;
//     }

    public String getUserType() {
        return this.userType;
    }

}

class Coin {
    public String color;
    public Coin(String color) {
        this.color  = color;
    }
    public String getColor() {
        return this.color;
    }
}

class Cell {
    public Coin coin;
    public Boolean isEmpty() {
        if(this.coin == null) {
            return true;
        } else {
            return false;
        }
    }

    public String getCoin() {
        return toString();
    }
    public String toString() {
        if (!this.isEmpty()) {

            return this.coin.getColor();
        } else {
            return null;
        }

    }

    public void insertCoin(Coin coin) {
        this.coin = coin;
    }

}

class Board {

    private static ArrayList<ArrayList<Cell>> board;

    public static String constructBoard() {
        board = new ArrayList<ArrayList<Cell>>();

        for (int i =0;i<6;i++) {
            ArrayList<Cell> row = new ArrayList<Cell>();

            for (int j =0;j<6;j++) {
                row.add(new Cell());
            }

            board.add(row);

        }
        return board.toString();

    }
    public String toString() {
        return board.toString();
    }
}




