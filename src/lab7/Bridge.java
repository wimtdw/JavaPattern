package lab7;

// Шаг 1: Создаем интерфейс для моста
interface Engine {
    void installEngine();
}

// Шаг 2: Создаем конкретные реализации для различных типов двигателей
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

// Шаг 3: Создаем абстракцию
abstract class Vehicle {
    protected Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    abstract void manufacture();
}

// Шаг 4: Создаем конкретные реализации транспортных средств
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

// Шаг 5: Используем паттерн Bridge
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

