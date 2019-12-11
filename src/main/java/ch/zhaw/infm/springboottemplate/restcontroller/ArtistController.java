package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.infm.springboottemplate.entities.Artist;
import ch.zhaw.infm.springboottemplate.repositories.ArtistRepository;

@RestController
public class ArtistController {
	@Autowired
	private ArtistRepository artistRepository;

	@GetMapping("/fave/artists")
	public ResponseEntity<List<Artist>> getArtists() {
		return new ResponseEntity<List<Artist>>(artistRepository.findAll(), HttpStatus.OK);
	}
}
