package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.infm.springboottemplate.entities.BenutzerVote;
import ch.zhaw.infm.springboottemplate.repositories.BenutzerVoteRepository;

@RestController
public class BenutzerVoteController {
	@Autowired
	private BenutzerVoteRepository benutzerVoteRepository;

	/*
	 * @GetMapping("/fave/artists") public ResponseEntity<List<Artist>> getArtists()
	 * { return new ResponseEntity<List<Artist>>(artistRepository.findAll(),
	 * HttpStatus.OK); }
	 */
	@GetMapping("/fave/artistVotes/{artistId}")
	public ResponseEntity<List<BenutzerVote>> getArtistVotes(@PathVariable ("artistId") Long artistId) {

		List<BenutzerVote> votes = benutzerVoteRepository.findByArtistArtistId(artistId);

		if (votes != null && !votes.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<List<BenutzerVote>>(votes, HttpStatus.OK);
		} 
		else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity<List<BenutzerVote>>(HttpStatus.NOT_FOUND);
		}
	}
}
