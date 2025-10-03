package task2;

public class Plane implements Vehicle {

private DataBase db;
    private String brand;
    public void setDb(DataBase db) {
        this.db = db;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void saveToDatabase(Vehicle vehicle) {
        db.save(vehicle);
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

}
