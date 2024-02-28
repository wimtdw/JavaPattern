package lab3;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<E> {
    private final List<E> list = new ArrayList<>();
    private final Lock lock = new ReentrantLock(); // Инициализация ReentrantLock

    public void add(E element) {
        lock.lock();
        try {
            list.add(element);
        } finally {
            lock.unlock();
        }
    }

    public E get(int index) {
        lock.lock();
        try {
            return list.get(index);
        } finally {
            lock.unlock();
        }
    }
    public boolean remove(E element) {
        lock.lock();
        try {
            return list.remove(element);
        } finally {
            lock.unlock();
        }
    }

}