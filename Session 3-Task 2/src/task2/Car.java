package task2;

public class Car implements Vehicle {

 private DataBase dataBase;
    private String brand;



 public Car(DataBase dataBase) {
     this.dataBase = dataBase;
 }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void saveToDatabase(Vehicle vehicle) {
      dataBase.save(vehicle);
    }
    @Override
    public String getBrand() {
     return this.brand;
    }
}
