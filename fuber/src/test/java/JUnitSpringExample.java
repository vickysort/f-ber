import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import fuber.Cab;
import fuber.CabService;
import fuber.Location;
import fuber.MobileApp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class JUnitSpringExample {

	@Autowired
	private CabService cabService;

	@Test
	public void assignCabToUser() {
		MobileApp user = new MobileApp();
		user.setColorPreference("pink");
		user.setLocation(new Location(10,100));
		Cab cab = cabService.assignCabToUser(user.getLocation(), user.getColorPreference());
		Assert.assertNotNull(cab);
	}
	
	@Test
	public void getAllCabs() {
		org.springframework.util.Assert.notEmpty(cabService.getAllCabs()); 
	}
	
	@Test
	public void getTravelCost() {
		MobileApp user = new MobileApp();
		user.setColorPreference("pink");
		user.setLocation(new Location(10,100));
		user.setDestination(new Location(20,200));
		user.setTraveltime(20);
		user = cabService.calculateCost(user);
		Assert.assertNotNull(user);
	}


}