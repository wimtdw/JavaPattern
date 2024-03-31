package lab6;

interface Prototype {
    Prototype clone();
}

class ConcretePrototype implements Prototype {
    private int value;

    public ConcretePrototype(int value) {
        this.value = value;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


class Test {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype(5);
        ConcretePrototype clonedPrototype = (ConcretePrototype) prototype.clone();

        System.out.println("Original Prototype Value: " + prototype.getValue());
        System.out.println("Cloned Prototype Value: " + clonedPrototype.getValue());

        clonedPrototype.setValue(6);

        System.out.println("Original Prototype Value after cloning: " + prototype.getValue());
        System.out.println("Cloned Prototype Value after modification: " + clonedPrototype.getValue());
    }
}

