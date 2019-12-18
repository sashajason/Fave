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
		List<Artist> artists = artistRepository.findAll();
		
		if(artists != null && !artists.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity<List<Artist>>(HttpStatus.NOT_FOUND);
        }
		
	}
	
	/*@GetMapping("/fave/artistsWithVeranstaltung")
	public ResponseEntity<List<Artist>> getArtistsWithVernastaltung()
	{
				List<Artist> artists = artistRepository.findArtistsWithVeranstaltung(new java.util.Date());
				
				if(artists != null && !artists.isEmpty()){
		            // ... dann diese als Body zurückgeben
		            return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
		        } else {
		            // ... ansonsten ResourceNotFoundException (404)
		            return new ResponseEntity<List<Artist>>(HttpStatus.NOT_FOUND);
		        }
	}*/
	
}
