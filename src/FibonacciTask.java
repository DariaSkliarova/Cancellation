public class FibonacciTask implements Runnable{

    @Override
    public void run() {
        long x = 0;
        long y = 1;
        for (int i = 0; i < 50; i++){
            System.out.print(x + " " + y + " ");
            x += y;
            y += x;
        } System.out.print(x + " " + y + " \n");
    }
}
