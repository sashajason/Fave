package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.zhaw.infm.springboottemplate.entities.Location;
import ch.zhaw.infm.springboottemplate.repositories.LocationRepository;

public class LocationController {
	@Autowired
	private LocationRepository locationRepository;

	@GetMapping("/fave/locations")
	public ResponseEntity<List<Location>> getAllLocations() {

		List<Location> locations = locationRepository.findAll();

		if (locations != null && !locations.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity<List<Location>>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/fave/newLocation")
	public Location newLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@RequestMapping(value = "/fave/deleteLocation/{locationId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteLocation(@PathVariable("locationId") Long locationId) {

		boolean deleteSuccess = locationRepository.deleteBylocationId(locationId) >= 1;

		if (deleteSuccess) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			// ... ansonsten String (404)
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
