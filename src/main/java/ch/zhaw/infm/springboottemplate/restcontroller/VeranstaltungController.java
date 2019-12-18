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

import ch.zhaw.infm.springboottemplate.entities.Veranstaltung;
import ch.zhaw.infm.springboottemplate.repositories.VeranstaltungRepository;

public class VeranstaltungController {
	@Autowired
	private VeranstaltungRepository veranstaltungRepository;
	
	@GetMapping("/fave/veranstaltungen")
	public ResponseEntity <List<Veranstaltung>> getAllVeranstaltungen(){
		
		List<Veranstaltung> veranstaltungen = veranstaltungRepository.findAll();

		if (veranstaltungen != null && !veranstaltungen.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<List<Veranstaltung>>(veranstaltungen, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity<List<Veranstaltung>>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	@PostMapping("/fave/newVeranstaltung")
	public Veranstaltung newVeranstaltung(@RequestBody Veranstaltung veranstaltung) {
		return veranstaltungRepository.save(veranstaltung);
	}
	
	@RequestMapping(value = "/fave/deleteVeranstaltung/{veranstaltungId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteVeranstaltung(@PathVariable("veranstaltungId") Long veranstaltungId) {

		boolean deleteSuccess = veranstaltungRepository.deleteByveranstaltungId(veranstaltungId) >= 1;

		if (deleteSuccess) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			// ... ansonsten String (404)
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/fave/updateVeranstaltung/{veranstaltungId}", method = RequestMethod.PUT)
    public ResponseEntity<Veranstaltung> updateVeranstaltung(@PathVariable("veranstaltungId") Long veranstaltungId, @RequestBody Veranstaltung veranstaltung) {
 
        Veranstaltung currentVeranstaltung = veranstaltungRepository.findByVeranstaltungId(veranstaltungId);
 
        currentVeranstaltung.setDatum(veranstaltung.getDatum());
        currentVeranstaltung.setAusverkauft(veranstaltung.getAusverkauft());
 
        veranstaltungRepository.save(currentVeranstaltung);
        return new ResponseEntity<Veranstaltung>(currentVeranstaltung, HttpStatus.OK);
    }
	
}
