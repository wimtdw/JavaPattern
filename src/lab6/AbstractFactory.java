package lab6;

interface CarFactory {
    Car createCar();
    CarSpecification createSpecification();
}
class FirstCarFactory implements CarFactory {
    public Car createCar() {
        return new Ford();
    }

    public CarSpecification createSpecification() {
        return new NorthAmericaSpecification();
    }
}

class SecondCarFactory implements CarFactory {
    public Car createCar() {
        return new Renault();
    }

    public CarSpecification createSpecification() {
        return new EuropeSpecification();
    }
}

interface Car {
    void assemble();
}

// Abstract Product Interface for Car Specifications
interface CarSpecification {
    void display();
}

class Ford implements Car {
    public void assemble() {
        System.out.println("Assembling Ford car.");
    }
}

// Concrete Product for Hatchback Car
class Renault implements Car {
    public void assemble() {
        System.out.println("Assembling Renault car.");
    }
}

// Concrete Product for North America Car Specification
class NorthAmericaSpecification implements CarSpecification {
    public void display() {
        System.out.println("North America Car Specification: Safety features compliant with local regulations.");
    }
}

// Concrete Product for Europe Car Specification
class EuropeSpecification implements CarSpecification {
    public void display() {
        System.out.println("Europe Car Specification: Fuel efficiency and emissions compliant with EU standards.");
    }
}
class CarFactoryClient {
    public static void main(String[] args) {
        // Creating cars for North America
        CarFactory firstCarFactory = new FirstCarFactory();
        Car firstCar = firstCarFactory.createCar();
        CarSpecification northAmericaSpec = firstCarFactory.createSpecification();

        firstCar.assemble();
        northAmericaSpec.display();

        // Creating cars for Europe
        CarFactory secondCarFactory = new SecondCarFactory();
        Car secondCar = secondCarFactory.createCar();
        CarSpecification europeSpec = secondCarFactory.createSpecification();

        secondCar.assemble();
        europeSpec.display();
    }
}
