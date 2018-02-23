import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dullam on 1/31/18.
 */
public class LengthEachScene {

    public List<Integer> lengthEachScene(List<Character> inputList) {
        if(inputList.size() == 0) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        if(inputList.size() == 1) {
            result.add(1);
            return result;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int needle = inputList.lastIndexOf(inputList.get(0));
        map.put(inputList.get(0), needle);
        int currentElemLastIndex = needle;
        int prevNeedle =0;

        for(int i=1; i< inputList.size(); i++) {
            if(map.containsKey(inputList.get(i))) {
                currentElemLastIndex = map.get(inputList.get(i));
            } else {
                currentElemLastIndex = inputList.lastIndexOf(new Character(inputList.get(i)));
                map.put(inputList.get(i),currentElemLastIndex);
                if(prevNeedle == needle)
                    needle = currentElemLastIndex;
            }

            if(currentElemLastIndex == needle && needle == i) {
                if (result.size() == 0) {
                    result.add(needle+1-prevNeedle);
                } else {
                    result.add(needle-prevNeedle);
                }
                prevNeedle = needle;
            } else if(currentElemLastIndex > needle) {
                    needle = currentElemLastIndex;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        LengthEachScene les = new LengthEachScene();
        Character[] arr = new Character[]{'a','b','a','b','c','b','a','c','a','d','e','f','e','g','d','e','h','i','j','h','k','l','i','j'};
        List<Integer> result = les.lengthEachScene(Arrays.asList(arr));
        System.out.println(result);

        Character[] arr1 = new Character[]{'a','b','c','d','a'};
        List<Integer> result1 = les.lengthEachScene(Arrays.asList(arr1));
        System.out.println(result1);
    }
}
