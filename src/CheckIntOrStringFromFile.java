/**
 * Created by dullam on 10/12/17.
 */



import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class CheckIntOrStringFromFile {


    public static boolean isNumeric(String sNumber)
    {

        try
        {
            if ((sNumber == null) || (sNumber.equals("")))
            {
                return (false);  // empty String
            }

            Double.parseDouble(sNumber);
            return (true);   // No exception
        }
        catch (Exception e)
        {
            return (false);   // Num format exception
        }
    } // end isNumeric()



    public static boolean isInteger(String sIntegerLong)
    {

        try
        {
            if ((sIntegerLong == null) || (sIntegerLong.equals("")))
            {
                return (false);  // empty String
            }

            Long.parseLong(sIntegerLong);
            return (true);   // No exception
        }
        catch (Exception e)
        {
            return (false);   // Num format exception
        }
    } // end isInteger()


    /*
         * Test if [a-zA-Z] contained in String
         *   AM: ID#1009441 11/18/2015
         * @param sInput - Input String to check
         * @return true - contains Alpha Chars, false - does not
         */
    public static boolean isStringContainAlpha(String sInput)
    {
        boolean bReturn = false;

            Pattern p = Pattern.compile("[a-zA-Z]");
            Matcher m = p.matcher(sInput);
            if (m.find())
            { bReturn = true; }

        return (bReturn);

    } //isStringContainAlpha()
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "input.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(isNumeric(line)) {
                    if(isInteger(line)){
                        int foo = Integer.parseInt(line);
                        foo=foo+1;
                        System.out.println(foo);
                    }else{
                        double foo = Double.parseDouble(line);
                        foo=foo+1;
                        System.out.println(foo);

                    }

                }else if(isStringContainAlpha(line)){
                    String reverse = new StringBuffer(line).reverse().toString();
                    System.out.println(reverse);

                }

            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
