package Greedy;

/**
 * Created by dullam on 4/27/18.
 */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i < gas.length; i++) {
            if(gas[i] >= cost[i])
                if(isPossibleToMove(gas,cost,i,gas[i],i))
                    return i;
        }
        return -1;
    }

    private static boolean isPossibleToMove(int[] gas, int[] cost, int index, int inTank, int startIndex) {
        if((index+1) % gas.length != startIndex) {
            if(inTank < cost[index]) return false;
            inTank = inTank-cost[index % gas.length]+gas[(index+1) % gas.length];
            return inTank >= 0 && isPossibleToMove(gas,cost,(index+1) % gas.length,inTank,startIndex);
        }
        return  inTank >= cost[index];
    }

    public static void main(String[] args) {

        int[] gas = new int[]{5,1,2,3,4};
        int[] cost = new int[]{4,4,1,5,1};

        System.out.println(" At what index we can start " + GasStation.canCompleteCircuit(gas, cost));
    }
}
