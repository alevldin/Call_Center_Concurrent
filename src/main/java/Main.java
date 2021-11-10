public class Main {
    public static void main(String[] args) throws InterruptedException {
        CallCenter centre = new CallCenter(7);
        Thread ats = new Thread(centre::takeCall);

        Thread thread1 = new Thread(centre::addCall, "специалист 1");
        Thread thread2 = new Thread(centre::addCall, "специалист 2");
        Thread thread3 = new Thread(centre::addCall, "специалист 3");

        ats.start();
        thread1.start();
        thread2.start();
        thread3.start();

        ats.join();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}