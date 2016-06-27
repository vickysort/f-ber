package fuber;

public class MobileApp {
	
	private Location location;
	private Location destination;
	private String colorPreference;
	private double cost;
	private int traveltime;
	private double travelDistance;
	
	public MobileApp() {
	}
	
	public MobileApp(Location location, String colorPreference) {
		super();
		this.location = location;
		this.colorPreference = colorPreference;
	}
	
	public double getTravelDistance() {
		return travelDistance;
	}

	public void setTravelDistance(double travelDistance) {
		this.travelDistance = travelDistance;
	}

	public int getTraveltime() {
		return traveltime;
	}

	public void setTraveltime(int traveltime) {
		this.traveltime = traveltime;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getColorPreference() {
		return colorPreference;
	}
	public void setColorPreference(String colorPreference) {
		this.colorPreference = colorPreference;
	}

	@Override
	public String toString() {
		return "MobileApp [location=" + location + ", destination=" + destination + ", colorPreference="
				+ colorPreference + ", cost=" + cost + ", traveltime=" + traveltime + ", travelDistance="
				+ travelDistance + "]";
	}
}
