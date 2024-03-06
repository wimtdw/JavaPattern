package lab8;


interface MyIterator {
    boolean hasNext();
    Object next();
}


class MyContainer {
    private String[] elements = {"Элемент 1", "Элемент 2", "Элемент 3"};


    private class ContainerIterator implements MyIterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public Object next() {
            return elements[index++];
        }
    }


    public MyIterator getIterator() {
        return new ContainerIterator();
    }
}

class Tester {
    public static void main(String[] args) {
        MyContainer container = new MyContainer();
        MyIterator iterator = container.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}