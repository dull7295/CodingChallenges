/**
 * Created by dullam on 7/22/17.
 */
public class StaticExample {
    public static int numberofInstances=0;
    public int y=0;

    public StaticExample(){
        this.y++;
        this.numberofInstances++;
    }

    public static void main(String[] args) {

        StaticExample se1= new StaticExample();

        System.out.println("Non static for se1  " + se1.y + " statid for se1 " +se1.numberofInstances);

        StaticExample se2 = new StaticExample();

        System.out.println("Non static for se2  " +se2.y + " statid for se2 " +StaticExample.numberofInstances);

        StaticExample se3 = new StaticExample();

        System.out.println(" Non static for se3 " + se3.y +   " statid for se2 " +StaticExample.numberofInstances);

    }
}
