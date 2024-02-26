public class Car {


    private String description;

    public Car(){
        this("Default description");
    }

    public Car(String description) {
        this.description = description;
    }


    public void startEngine(){
        System.out.println("Car -> startEngine");
    }

    public void drive(){
        runEngine();
        System.out.println("Car -> Driving...");

        String className = this.getClass().getSimpleName();

        switch(className){
            case "GasPoweredCar" -> System.out.printf("%s Running on gas \n ", className);
            case "ElectricCar" -> System.out.printf("%s Running on electricity \n", className);
            case "HybridCar" -> System.out.printf("%s Running on both \n", className);
            default -> System.out.println("Running on something unknown");
        }
    }

    protected void runEngine(){
        System.out.println("Car -> Running engine");
    }

}

class GasPoweredCar extends Car{
    private double avgKMPerLitre;
    private int cylinders = 6;


    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double avgKMPerLitre, int cylinders) {
        super(description);
        this.avgKMPerLitre = avgKMPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public String toString() {
        return "GasPoweredCar{" +
                "avgKMPerLitre=" + avgKMPerLitre +
                ", cylinders=" + cylinders +
                "} " + super.toString();
    }


    @Override
    public void startEngine() {
        System.out.printf("Gas -> All %d cylinders etc %n", cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Usage exceeds %f", avgKMPerLitre);
    }
}

