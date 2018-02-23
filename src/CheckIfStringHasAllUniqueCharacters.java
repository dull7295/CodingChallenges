import java.util.Arrays;

/**
 * Created by dullam on 2/8/18.
 */
public class CheckIfStringHasAllUniqueCharacters {

    public boolean checkIfStringHasAllUniqueCharacters(String str) {
        boolean[] ascii = new boolean[256];
        Arrays.fill(ascii, false);

        for(Character c: str.toCharArray()) {
            if(ascii[c])
                return false;
            else
                ascii[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfStringHasAllUniqueCharacters checkIfStringHasAllUniqueCharacters = new CheckIfStringHasAllUniqueCharacters();
        String str = "iamvery- -";
        boolean bool = checkIfStringHasAllUniqueCharacters.checkIfStringHasAllUniqueCharacters(str);
        System.out.println(" Given string " +str + " has unique chars? ::  " + bool);
    }
}
