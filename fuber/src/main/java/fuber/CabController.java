package fuber;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CabController {
	
	@Autowired
	CabService cabService;
	
	@RequestMapping(value = {"/","index"})
    public String index()
    {
        return "index";
    }
	
	@RequestMapping(value="/cab", method=RequestMethod.GET)
	public @ResponseBody MobileApp displayBookCab(){
		return new MobileApp(new Location(0, 0), "");
	}
	
	@RequestMapping(value="/cab", method=RequestMethod.POST)
	public @ResponseBody Cab getCorrespondingCab(@RequestBody MobileApp user){
		cabService.setUserLocation(user.getLocation());
		Cab result = cabService.assignCabToUser(user.getLocation(), user.getColorPreference());
		return result;
	}
	
	@RequestMapping(value="/getallcabs")
	public @ResponseBody ResponseEntity<Object> getAllCabs(){
		List<Cab> result = cabService.getAllCabs();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/endride")
	public @ResponseBody MobileApp getCost(@RequestBody MobileApp user){
		return cabService.calculateCost(user);
	}
	
	@RequestMapping(value="/travellog")
	public @ResponseBody List<String> getTravelLog(){
		List<String> travelLog = cabService.getTravelLog();
		System.out.println(travelLog);
		return travelLog;
	}

}
