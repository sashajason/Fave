package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.infm.springboottemplate.entities.BenutzerVote;
import ch.zhaw.infm.springboottemplate.entities.Genre;
import ch.zhaw.infm.springboottemplate.repositories.GenreRepository;

@RestController
public class GenreController {
	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping("/fave/genre")
	public ResponseEntity <List<Genre>> getAllGenres(){
		
		List<Genre> genres = genreRepository.findAll();

		if (genres != null && !genres.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<List<Genre>>(genres, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity<List<Genre>>(HttpStatus.NOT_FOUND);
		}
	
	}
}
