package lab3;
public class Main {
    public static void main(String[] args) {
        ThreadSafeMap<String, Integer> safeMap = new ThreadSafeMap<>();
        ThreadSafeList<String> safeList = new ThreadSafeList<>();
        //добавления
        try {
            safeMap.put("key1", 1);
            safeMap.put("key2", 2);

            safeList.add("element1");
            safeList.add("element2");
            System.out.println("elements added");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //получение
        try {
            System.out.println("Value for key 'key1': " + safeMap.get("key1"));
            System.out.println("Element at index 0: " + safeList.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //удаление
        try {
            safeMap.remove("key2");
            safeList.remove("element1");
            System.out.println("elements deleted");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
