package fuber;

import java.util.List;

public interface CabService {

	Location getUserLocation();

	void setUserLocation(Location userLocation);

	List<Cab> getAllCabs();

	Cab assignCabToUser(Location userLocation, String colorPreference);

	double getDistance(Location location1, Location location2);
	
	MobileApp calculateCost(MobileApp user);
	
	public List<String> getTravelLog();
	
	public void setTravelLog(List<String> travelLog);

}