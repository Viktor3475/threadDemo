public class ThreadDemo { // Thread Demo class
    private static ThreadDemo tr; // shared instance between threads
    private int c = 0; // member variable for testing purpose, we are going to increment this variable

    public static void main(String[] args) {
        // Start both threads
       thread1.start();
       thread2.start();
    }

    private ThreadDemo(){} // Prevent initialization outside this class

    public static ThreadDemo getInstance(){ // singleton instance
        if(tr == null){
            tr = new ThreadDemo();
        }
        return tr;
    }

    // Both threads will call count instance method to increment variable c

    // since The Runnable interface is functional, we can use lambda instead
    // of anonymous class
     private static final Thread thread1 = new Thread(() -> getInstance().count());

     private static final Thread thread2 = new Thread(() -> getInstance().count());

     // synchronized block is used to prevent two threads
     // from writing at the same time (thread1, thread2) to
     // member variable c, ensuring thread safety for variable c

    private void count(){
        synchronized (this){
            for (int i = 0; i < 10; i++){
                ++c;
                System.out.println(c);
            }

        }

    }
}
