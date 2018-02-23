/**
 * Created by dullam on 8/20/17.
 */


import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class IncreDecreSubArray {

    public static void main(String[] args) {
        File file = new File("Data.txt");   ///Users/dullam/self/content/CTRP_4X_GIT/CodingChallenges/src/backtracking
        Scanner sc = null;
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        if (file.exists()) {
            try {
                sc = new Scanner(file);
                String line = "";
                String regExpr = "\\s+";
                String[] lines = new String[2];
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    lines = line.split(regExpr);
                    System.out.println(Arrays.toString(lines));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                sc.close();
            }
        } else {
            System.out.println("File Doesnt Exist");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken: " + (endTime - startTime) + "ms");
    }
}
