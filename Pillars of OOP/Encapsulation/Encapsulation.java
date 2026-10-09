class SportsCar {
    private String brand;
    private String model;
    private boolean isEngineOn = false;
    private int currentSpeed = 0;
    private int currentGear = 0;

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + "'s engine has started!");
    }

    public void stopEngine() {
        isEngineOn = false;
        System.out.println(brand + " " + model + "'s engine is now off!");

    }

    public void shiftGear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + "'s engine is off, could not shift gear!");
            return;
        }

        this.currentGear = gear;
        System.out.println(brand + " " + model + " is now at gear: " + currentGear);
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + "'s engine is off, could not accelerate");
            return;
        }

        this.currentSpeed += 10;
        System.out.println(brand + " " + model + "'s current speed is " + currentSpeed);
    }

    public void brake() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + "'s engine is off, braking makes no sense!");
            return;
        }

        if (this.currentSpeed == 0) {
            System.out.println(brand + " " + model + " is not moving, braking makes no sense!");
            return;
        }

        this.currentSpeed -= 10;
        if (this.currentSpeed < 0)
            this.currentSpeed = 0;
        System.out.println(brand + " " + model + " is now braking and the current speed is " + currentSpeed);

    }

}

public class Encapsulation {
    public static void main(String[] args) {
        SportsCar myCar = new SportsCar("Jaguar", "F-Type");

        myCar.startEngine();
        myCar.brake();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.shiftGear(1);
        myCar.brake();
        myCar.stopEngine();
    }
}