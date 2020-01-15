package P0010;

public class P0010 {

    // Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.

    public static void main(String[] args) {

        Runnable newFunction = () -> System.out.println("waited some time before running this.. ");

        try {
            solution(newFunction, 5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void solution(Runnable f, int n) throws InterruptedException {
        System.out.println(String.format("Waiting %s millisec before running", n));
        Thread.sleep(n);
        f.run();
    }

}
