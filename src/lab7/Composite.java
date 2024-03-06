package lab7;

import java.util.ArrayList;
import java.util.List;
abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void operation();
}
class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " operation");
    }
}



class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite " + name + " operation");
        for (Component component : children) {
            component.operation();
        }
    }
}
class Main {
    public static void main(String[] args) {
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");

        Composite composite = new Composite("Composite 1");
        composite.add(leaf1);
        composite.add(leaf2);

        Composite composite2 = new Composite("Composite 2");
        composite2.add(new Leaf("Leaf 3"));

        composite.add(composite2);

        composite.operation();
    }
}