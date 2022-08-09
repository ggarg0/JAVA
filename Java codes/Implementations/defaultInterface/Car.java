package defaultInterface;

public class Car implements Vehicle//, Alarm
{
	
	private String brand;
	public Car(String brand) {
		super();
		this.brand = brand;
	}
    
    @Override
    public String getBrand() {
        return brand;
    }
     
    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }
     
    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }
    
   /* public String turnAlarmOn() {
		return "Turning the Main alarm on.";
	}

	public String turnAlarmOff() {
		return "Turning the Main alarm off.";
	}*/
    
    public static void main(String[] args) { 
        Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
        System.out.println(Vehicle.getHorsePower(1200,1000));
        
    }
}
