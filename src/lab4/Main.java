package lab4;
public class Main {
    public static void main(String[] args) {
        CustomExecutorService executorService = new CustomExecutorService(3);

        executorService.submit(() -> System.out.println("Task 1 executed"));
        executorService.submit(() -> System.out.println("Task 2 executed"));
        executorService.submit(() -> System.out.println("Task 3 executed"));
        executorService.submit(() -> System.out.println("Task 4 executed"));

        executorService.shutdown();
    }
}
