import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Long> {

    public int f = 10;
    public long result = 1;

    @Override
    public Long call() {

        for (int i = 1; i <= f; i++) {
            System.out.println(result + " * " + i + " = " + (result * i));
            result *= i;
        }
        return result;
    }
}
