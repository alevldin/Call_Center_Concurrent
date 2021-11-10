import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CallCenter {
    private int count;
    private static final int CALLS = 10;
    private static final int PAUSE = 1000;
    private static final int DELAY = 3000;

    private final BlockingQueue<String> calls = new ArrayBlockingQueue<>(CALLS);

    public CallCenter(int count) {

        this.count = count;
    }

    public void addCall() {
        while (count != 0 || !calls.isEmpty()) {
            try {
                String name = calls.take();
                System.out.printf("%s начал обработку звонка %s\n", Thread.currentThread().getName(), name);
                Thread.sleep(DELAY);
                System.out.printf("%s обработал звонок %s\n", Thread.currentThread().getName(), name);
            } catch (InterruptedException ignored) {

            }
        }
    }

    public void takeCall() {
        while (count != 0) {
            try {
                Thread.sleep(PAUSE);
                String personName = " от клиента " + count;
                System.out.println(personName + " поступил звонок");
                calls.put(personName);
                count--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
