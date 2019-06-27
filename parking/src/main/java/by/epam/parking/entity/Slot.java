package by.epam.parking.entity;

public class Slot {

	private int id;
	private boolean occupied;
	private Car car;

	
	public Slot() {
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (occupied ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		if (id != other.id)
			return false;
		if (occupied != other.occupied)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Slot [id=" + id + ", occupied=" + occupied + "]";
	}

}
