package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.infm.springboottemplate.entities.Artist;
import ch.zhaw.infm.springboottemplate.entities.Genre;
import ch.zhaw.infm.springboottemplate.repositories.ArtistRepository;
import ch.zhaw.infm.springboottemplate.repositories.GenreRepository;

@RestController
public class ArtistController {
	@Autowired
	private ArtistRepository artistRepository;

	@GetMapping("/fave/artists")
	public ResponseEntity <List<Artist>> getArtists(){
		return new ResponseEntity<List<Artist>>(artistRepository.findAll(),HttpStatus.OK);
	}
	}
