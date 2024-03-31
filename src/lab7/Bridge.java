package lab7;

interface Engine {
    void installEngine();
}

class GasolineEngine implements Engine {
    @Override
    public void installEngine() {
        System.out.println("Installing gasoline engine");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void installEngine() {
        System.out.println("Installing electric engine");
    }
}

abstract class Vehicle {
    protected Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    abstract void manufacture();
}

class Car extends Vehicle {
    public Car(Engine engine) {
        super(engine);
    }

    @Override
    void manufacture() {
        System.out.print("Car ");
        engine.installEngine();
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(Engine engine) {
        super(engine);
    }

    @Override
    void manufacture() {
        System.out.print("Motorcycle ");
        engine.installEngine();
    }
}

class BridgePatternExample {
    public static void main(String[] args) {
        Engine gasolineEngine = new GasolineEngine();
        Engine electricEngine = new ElectricEngine();

        Vehicle car = new Car(gasolineEngine);
        car.manufacture();

        Vehicle electricBike = new Motorcycle(electricEngine);
        electricBike.manufacture();
    }
}

