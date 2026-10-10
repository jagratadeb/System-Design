class Car {
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + "'s " + model + " : Engine has started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + "'s " + model + " : Engine has turned off.");
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println("Cannot accelerate: Engine is off!");
            return;
        }
        currentSpeed += 10;
        System.out.println(brand + "'s " + model + " current speed: " + currentSpeed);
    }

    public void brake() {
        if (!isEngineOn) {
            System.out.println("Engine is off, braking does not make any sense!");
            return;
        }
        currentSpeed -= 10;
        if (currentSpeed < 0)
            currentSpeed = 0;
        System.out.println(brand + " " + model + " braking! Speed is now: " + currentSpeed);
    }
}

class ManualCar extends Car {
    private int currentGear;

    public ManualCar(String brand, String model) {
        super(brand, model);
        this.currentGear = 0;
    }

    public void shiftGear(int gear) {
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

}

class ElectricCar extends Car {

    private int batteryLevel;

    public ElectricCar(String brand, String model) {
        super(brand, model);
        this.batteryLevel = 100;
    }

    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }
}

class Inheritance {
    public static void main(String[] args) {
        ManualCar myManualCar = new ManualCar("Ford", "Mustang");
        myManualCar.startEngine();
        myManualCar.shiftGear(1);
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        ElectricCar myElectricCar = new ElectricCar("Tesla", "Model-S");
        myElectricCar.chargeBattery();
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.brake();
        myElectricCar.stopEngine();
    }
}