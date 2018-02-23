import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by dullam on 7/26/17.
 */
public class CuisineProblem {

    public String[][] solution(String[][] lunchPairs, String[][] teamCusinePairs) {
        HashMap<String,ArrayList<String>> lunchMap = new HashMap<String,ArrayList<String>>();
        ArrayList<String> aList;
        HashSet<String> dishSet = new HashSet<String>();
        int k=0;

        for(int i=0;i<lunchPairs.length;i++){
            String dish = lunchPairs[i][0];
            String type = lunchPairs[i][1];
            if(lunchMap.containsKey(type)) {
                aList = lunchMap.get(type);
                aList.add(dish);
            } else {
                aList = new ArrayList<String>();
                aList.add(dish);
                lunchMap.put(type,aList);
            }
            dishSet.add(dish);
        }

        String[][] result = new String[dishSet.size()*teamCusinePairs.length][2];
        for(int i=0;i<teamCusinePairs.length;i++){
            String person = teamCusinePairs[i][0];
            String type = teamCusinePairs[i][1];
            if(lunchMap.containsKey(type)) {
                aList = lunchMap.get(type);
                for(String s: aList) {
                    result[k][0] =person;
                    result[k][1] =s;
                    k++;
                }
            } else {
                if(type.equals("*")) {
                    for(String s: dishSet) {
                        result[k][0] =person;
                        result[k][1] =s;
                        k++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[][] lunchPairs= new String[4][2];
        String[][] teamCusinePairs= new String[3][2];

        lunchPairs[0][0] = "Biryani";
        lunchPairs[0][1] = "Indian";

        lunchPairs[1][0] = "Curry";
        lunchPairs[1][1] = "Indian";

        lunchPairs[2][0] = "Pizza";
        lunchPairs[2][1] = "Italian";

        lunchPairs[3][0] = "Burger";
        lunchPairs[3][1] = "American";

        teamCusinePairs[0][0] = "Raghu";
        teamCusinePairs[0][1] = "Italian";

        teamCusinePairs[1][0] = "Mahesh";
        teamCusinePairs[1][1] = "Indian";

        teamCusinePairs[2][0] = "Murali";
        teamCusinePairs[2][1] = "*";


        CuisineProblem cp = new CuisineProblem();
        String[][] result = cp.solution(lunchPairs,teamCusinePairs);

        for(int i=0;i<result.length;i++){
            System.out.println(" " +result[i][0]+ "  " +result[i][1]);
        }

    }
}
