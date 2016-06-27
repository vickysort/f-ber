package fuber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CabServiceImpl implements CabService {

	private Location userLocation;
	private static List<String> travelLog = new ArrayList<String>();
	
	public List<String> getTravelLog() {
		return travelLog;
	}

	public void setTravelLog(List<String> travelLog) {
		CabServiceImpl.travelLog = travelLog;
	}

	/* (non-Javadoc)
	 * @see taxi4sure.CabService#getUserLocation()
	 */
	@Override
	public Location getUserLocation() {
		return userLocation;
	}

	/* (non-Javadoc)
	 * @see taxi4sure.CabService#setUserLocation(taxi4sure.Location)
	 */
	@Override
	public void setUserLocation(Location userLocation) {
		this.userLocation = userLocation;
	}

	/* (non-Javadoc)
	 * @see taxi4sure.CabService#getAllCabs()
	 */
	@Override
	public List<Cab> getAllCabs() {
		List<Cab> cabs = new ArrayList<Cab>();
		cabs.add(new Cab(1, new Location(10, 100), "green", true));
		cabs.add(new Cab(2, new Location(20, 200), "yellow", true));
		cabs.add(new Cab(3, new Location(30, 300), "pink", true));
		cabs.add(new Cab(4, new Location(40, 400), "blue", false));
		cabs.add(new Cab(5, new Location(50, 500), "orange", true));
		cabs.add(new Cab(6, new Location(60, 600), "pink", false));
		cabs.add(new Cab(7, new Location(70, 700), "red", true));
		cabs.add(new Cab(8, new Location(80, 800), "pink", true));
		cabs.add(new Cab(9, new Location(90, 900), "white", true));
		cabs.add(new Cab(10, new Location(100, 1000), "pink", true));
		return cabs;
	}

	public class MyComparator implements Comparator<Cab> {

		private Location userLocation;

		public MyComparator(Location userLocation) {
			super();
			this.userLocation = userLocation;
		}

		public int compare(Cab cab1, Cab cab2) {

			double distCab1 = CabServiceImpl.this.getDistance(cab1.getLocation(), this.userLocation);
			double distCab2 = CabServiceImpl.this.getDistance(cab2.getLocation(), this.userLocation);

			if (distCab1 > distCab2) {
				return 1;
			} else if (distCab1 == distCab2) {
				return 0;
			} else if (distCab1 < distCab2) {
				return -1;
			}
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see taxi4sure.CabService#assignCabToUser(taxi4sure.Location, java.lang.String)
	 */
	@Override
	public Cab assignCabToUser(Location userLocation, String colorPreference) {

		List<Cab> cabs = this.getAllCabs();

		if (colorPreference != null) {
			cabs = (List<Cab>) cabs.stream().filter(c -> c.getColor().equalsIgnoreCase(colorPreference) && c.isAvailable()).collect(Collectors.toList());
		}
		
		Collections.sort(cabs, new MyComparator(userLocation));
		
		/*for (Cab cab : cabs) {
			System.out.println(cab.getId());
		}*/

		if(cabs.size() != 0){
			return cabs.get(0);
		}
		else {
			return null;
		}
			
	}

	/* (non-Javadoc)
	 * @see taxi4sure.CabService#getDistance(taxi4sure.Location, taxi4sure.Location)
	 */
	@Override
	public double getDistance(Location location1, Location location2) {
		double distance = Math.abs(Math.sqrt((location1.getLatitude() - location2.getLatitude())
				* (location1.getLatitude() - location2.getLatitude())
				+ (location1.getLongitude() - location2.getLongitude())
				* (location1.getLongitude() - location2.getLongitude())));
		return distance;
	}
	
	public MobileApp calculateCost(MobileApp user){
		double cost = 0;
		double distance = this.getDistance(user.getLocation(), user.getDestination());
		user.setTravelDistance(Math.round(distance*100)/100);
		cost = (distance * 2) + (user.getTraveltime());
		if(user.getColorPreference().equalsIgnoreCase("pink")){
			cost += 5;
		}
		user.setCost(Math.round(cost*100)/100);
		
		travelLog.add(new Date() + " " + user.toString());
		
		return user;
	}

}
