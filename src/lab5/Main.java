package lab5;

public class Main {
    public static void main(String[] args) {
        // Тестируем каждую реализацию Singleton
        SingletonLazy lazySingleton = SingletonLazy.getInstance();
        SingletonSynchronized synchronizedSingleton = SingletonSynchronized.getInstance();
        SingletonBillPugh billPughSingleton = SingletonBillPugh.getInstance();

        // Выводим хэш-коды каждого объекта Singleton для проверки
        System.out.println("Lazy Singleton: " + lazySingleton.hashCode());
        System.out.println("Synchronized Singleton: " + synchronizedSingleton.hashCode());
        System.out.println("Bill Pugh Singleton: " + billPughSingleton.hashCode());
    }
}
