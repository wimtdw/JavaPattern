package lab5;

public class Main {
    public static void main(String[] args) {

        SingletonLazy lazySingleton = SingletonLazy.getInstance();
        SingletonSynchronized synchronizedSingleton = SingletonSynchronized.getInstance();
        SingletonBillPugh billPughSingleton = SingletonBillPugh.getInstance();


        System.out.println("Lazy Singleton: " + lazySingleton.hashCode());
        System.out.println("Synchronized Singleton: " + synchronizedSingleton.hashCode());
        System.out.println("Bill Pugh Singleton: " + billPughSingleton.hashCode());
    }
}
