package by.epam.parking.entity;

public class Slot {

	private int id;
	private boolean occupied;
	private Car car;

	public Slot(int id, boolean occupied, Car car) {
		super();
		this.id = id;
		this.occupied = occupied;
		this.car = car;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Slot [id=" + id + ", occupied=" + occupied + ", car=" + car + "]";
	}

}
