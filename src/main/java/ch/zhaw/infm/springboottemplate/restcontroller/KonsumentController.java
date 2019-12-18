package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.infm.springboottemplate.entities.Konsument;
import ch.zhaw.infm.springboottemplate.repositories.KonsumentRepository;

@RestController
public class KonsumentController {
	@Autowired
	private KonsumentRepository konusmentRepository;
	
	@GetMapping("/fave/konsumenten")
	public ResponseEntity <List<Konsument>> getAllKonsumenten(){
		
		List<Konsument> konsumenten = konusmentRepository.findAll();

		if (konsumenten != null && !konsumenten.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<List<Konsument>>(konsumenten, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity<List<Konsument>>(HttpStatus.NOT_FOUND);
		}
	
	}
}
