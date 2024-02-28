package lab5;

public class Main {
    public static void main(String[] args) {

        SingletonLazy lazySingleton = SingletonLazy.getInstance();
        SingletonSynchronized synchronizedSingleton = SingletonSynchronized.getInstance();
        SingletonEnum enumSingleton = SingletonEnum.INSTANCE.getInstance();


        System.out.println("Lazy Singleton: " + lazySingleton.hashCode());
        System.out.println("Synchronized Singleton: " + synchronizedSingleton.hashCode());
        System.out.println("Enum Singleton: " + enumSingleton.hashCode());
    }
}
