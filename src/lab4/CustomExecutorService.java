package lab4;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CustomExecutorService {
    private final List<Thread> threads = new ArrayList<>();
    private final Queue<Runnable> taskQueue = new ArrayBlockingQueue<>(10);
    private volatile boolean isStopped = false;

    public CustomExecutorService(int numThreads) {
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                while (!isStopped) {
                    Runnable task = taskQueue.poll();
                    if (task != null) {
                        task.run();
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    public void submit(Runnable task) {
        if (!isStopped) {
            taskQueue.offer(task);
        } else {
            throw new IllegalStateException("ExecutorService is stopped, cannot accept new tasks");
        }
    }

    public void shutdown() {
        isStopped = true;
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
