package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import ch.zhaw.infm.springboottemplate.entities.Veranstalter;
import ch.zhaw.infm.springboottemplate.repositories.VeranstalterRepository;

public class VeranstalterController {
	@Autowired
	private VeranstalterRepository veranstalterRepository;
	
	@GetMapping("/fave/veranstalter")
	public ResponseEntity <List<Veranstalter>> getAllVeranstalter(){
		
		List<Veranstalter> veranstalter = veranstalterRepository.findAll();

		if (veranstalter != null && !veranstalter.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<List<Veranstalter>>(veranstalter, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity<List<Veranstalter>>(HttpStatus.NOT_FOUND);
		}
	}
}
