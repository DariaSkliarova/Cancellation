public class StopwatchTask implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int i = 1;
                while (true) {
                    Thread.sleep(1000);
                    System.out.println(i);
                    i++;
                }
            } catch (InterruptedException e) {
                System.out.println("The Task was cancelled");
                e.printStackTrace();
            }
        }
        System.out.println("The Task was cancelled");
    }
}
