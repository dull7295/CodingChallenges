/**
 * Created by dullam on 6/29/17.
 */
import java.io.*;
import java.util.*;
public class ItemAssociation {

    public static String[] getItemAssociations(String[][] itemAssociations) {
         //SortedMap<String, ArrayList<String>>  map = new TreeMap<String,ArrayList<String>>();
        HashMap<String, ArrayList<String>>  map = new HashMap<String,ArrayList<String>>();
         for(String[] itemArray : itemAssociations) {
             if(map.containsKey(itemArray[0])) {
                 //map.get(itemArray[0]).add(itemArray[0]);
                 map.get(itemArray[0]).add(itemArray[1]);
             } else {
                 ArrayList<String> valueList = new ArrayList();
                 valueList.add(itemArray[0]);
                 valueList.add(itemArray[1]);
                 map.put(itemArray[0],valueList);
             }

             if(map.containsKey(itemArray[1])) {
                 //map.get(itemArray[1]).add(itemArray[1]);
                 map.get(itemArray[1]).add(itemArray[0]);
             } else {
                 ArrayList<String> valueList = new ArrayList();
                 valueList.add(itemArray[0]);
                 valueList.add(itemArray[1]);
                 map.put(itemArray[1],valueList);
             }
         }

         System.out.println(map);
         //ArrayList[] h = map.values().toArray(ArrayList<String>[]);

        //System.out.println(map.values().toArray(ArrayList<String>[]));

        for(ArrayList l: map.values()) {

        }

        String [] str = new String[10];
        return  str;

    }

    public static void main(String[] args) {
        String[][] str= new String[3][2];
        str[0][0] ="Item1";
        str[0][1] ="Item2";

        str[1][0] ="Item3";
        str[1][1] ="Item4";

        str[2][0] ="Item4";
        str[2][1] ="Item5";

        for (String[] s1: str)
        System.out.println(s1[0] + " , " + s1[1]);

        String[] result = ItemAssociation.getItemAssociations(str);

        System.out.println(result);
    }
}
