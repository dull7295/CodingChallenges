/**
 * Created by dullam on 1/21/18.
 */
/**
 * Created by dullam on 1/20/18.
 */
public class BugHuntOpt {
    private static final boolean VERBOSE = true;
    private static int max_len;
    private static int max_value;
    static final int[] COLLATZ_BANK = new int[2_000_000];

    /**
     * Main accepts two arguments, a min and a max, and will find the number N
     that generates the longest collatz sequence
     * between them
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        Thread[] threads = new Thread[max-min+1];
// run all of our threads and store them to check for joins.
        for(int i = min;i <= max;i++) {
            Thread t = new CollatzRunner(i, VERBOSE);
            threads[i-min] = t;
            t.start();
        }
// wait for all the threads to complete.
        for(int i = 0;i < threads.length;i++) {
            threads[i].join();
        }
        System.out.println("The value " + max_value + " had a sequence of length " + max_len);
    }
    /**
     * CollatzRunner is a Thread that calculates the collatz sequence for a
     given number and
     * updates an outer class static variable if it is longer than all other
     sequences that have
     * previously updated said variable. For an explanation of collatz
     sequences, see the collatz()
     * function.
     *
     */
    private static class CollatzRunner extends Thread {
        private int number;
        private boolean verbosity;
        public CollatzRunner(int num, boolean verbose) {
            number = num;
            verbosity = verbose;
        }
        @Override
        public void run() {
            int result = collatz(number, verbosity);
            if(result > BugHuntOpt.max_len) {
                BugHuntOpt.max_len = result;
                BugHuntOpt.max_value = number;
            }
        }
        /**
         * collatz returns the length of the sequence required to get to '1' for
         the first time.
         * If verbose is true, it will also output the sequence itself. Warning:
         This can be long.
         *
         * For a given number n, the collatz sequence is defined:
         * If n(i) is even, n(i+1) is n(i) / 2, otherwise,
         * If n(i) is odd, n(i+1) is 3*n(i) + 1.
         *
         * It is conjectured (the collatz conjecture) that all such sequences
         eventually reach one, and
         * therefore eventually cycle 1-4-2 forever. (OEIS 6577)
         * @param i
         * @return
         */
        private int collatz(int i, boolean verbose) {
            int count = 0;
            StringBuffer sequence = new StringBuffer("" + i + " ");
// for the actual sequence.
            while (i != 1) {
                if (i < COLLATZ_BANK.length) {
                    int steps = COLLATZ_BANK[(int) i];
                    if (steps > 0) {
                        count += steps;
                        break;
                    }
                }
                sequence.append( i + " ");
                if (i % 2 == 0) {
                    count++;
                    i = i / 2;
                } else {
                    count = count + 2;
                    i = (3 * i + 1)/2;
                }
            }
            if(verbose) {
                System.out.println(sequence);
            }
            if (i < COLLATZ_BANK.length) {
                COLLATZ_BANK[(int) i] = (short) count;
            }
            return count;
        }
    }
}