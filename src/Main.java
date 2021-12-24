import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.exe();
    }

    private void exe() {
        FactorialTask firstTask = new FactorialTask();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Future<Long> result = executor.submit(firstTask);

        try {
            System.out.println("Factorial Task");
            long factorial = result.get(3, TimeUnit.SECONDS);
            System.out.println("Factorial = " + factorial);
        } catch (InterruptedException e) {
            result.cancel(true);
            System.out.println("Task was cancelled");
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        FibonacciTask secondTask = new FibonacciTask();
        Future<?> result1 = executor.submit(secondTask);

        try{
            System.out.println("\nFibonacci numbers");
            result1.get(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            result.cancel(true);
            System.out.println("Task was cancelled");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e){
            result.cancel(true);
            System.out.println("Execution time is out");
        }

        StopwatchTask thirdTask = new StopwatchTask();
        Future<?> result2 = executor.submit(thirdTask);

        try {
            System.out.println("\nStopwatch Task");
            result2.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        CopyTask fourthTask = new CopyTask();
        Future<?> result3 = executor.submit(fourthTask);

        try {
            System.out.println("\nCopy Task");
            result3.get();
            if (result3.isDone()){
                System.out.println("Ready");
            }
        } catch (InterruptedException e){
            System.out.println("Copying was cancelled");
        } catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}

