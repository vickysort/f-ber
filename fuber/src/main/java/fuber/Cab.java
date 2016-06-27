package fuber;

public class Cab {
	
	private long id;
	private Location location;
	private String color;
	private boolean available;
	
	public Cab(long id, Location location, String color, boolean available) {
		super();
		this.id = id;
		this.location = location;
		this.color = color;
		this.available = available;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Cab [id=" + id + ", location=" + location + ", color=" + color + ", availability=" + available + "]";
	}

	
}
