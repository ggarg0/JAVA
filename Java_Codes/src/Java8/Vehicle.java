package Java8;

public interface Vehicle {

	String getBrand();

	String speedUp();

	String slowDown();

	default String turnAlarmOn() {
		return "Turning the vehicle alarm on.";
	}

	default String turnAlarmOff() {
		return "Turning the vehicle alarm off.";
	}

	static int getHorsePower(int rpm, int torque) {
		return (rpm * torque) / 5252;
	}
}
