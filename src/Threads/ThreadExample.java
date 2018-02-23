package Threads;

/**
 * Created by dullam on 7/27/17.
 */
public class ThreadExample extends Thread {
    /*  Process   Program under execution is called the process
    *
    * For example Microsoft Word is a program.
    * When you open it, it requires some memory to run in the os
    *
    * Thread is a light weight process
    *
    * why Threads
    *
    * Single processor computers , we used to have only pne processor with pagination and vutrual memory techniques
    * optimized resource allocations and executing.
    *
    * For example playing movive in VLS.. 2.5 hours
    * It is mu
    *
    * Thread---> Execute in a single process.
    *
    * Word ---> oNE MAIN Thread is taking input and showing it on the document
    * second thread is spell check
    *
    *
    * Extend key word is precious.. you should save it to inherit more important classes
    * You should extend Thread
    * or Jave provides another to implement Runnable
    * */
    @Override
    public void run() {
        try {
            System.out.println(" I am running inside the run method  ");
        }catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        System.out.println(" Before I am in Main programm");
        for(int i=0;i<10;i++) {
            new ThreadExample().run();
        }
        System.out.println(" After I am in Main programm");
    }
}
