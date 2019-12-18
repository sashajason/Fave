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
	public ResponseEntity<List<BenutzerVote>> getArtistVotes(@PathVariable("artistId") Long artistId) {

		List<BenutzerVote> votes = benutzerVoteRepository.findByArtistArtistId(artistId);

		if (votes != null && !votes.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<List<BenutzerVote>>(votes, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity<List<BenutzerVote>>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/fave/newBenutzerVote")
	public BenutzerVote newVeranstaltung(@RequestBody BenutzerVote benutzerVote) {
		return benutzerVoteRepository.save(benutzerVote);
	}
	
	@RequestMapping(value = "/fave/deleteVote/{benutzeVoteId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteVote(@PathVariable("benutzeVoteId") Long benutzeVoteId) {

		boolean deleteSuccess = benutzerVoteRepository.deleteBybenutzerVoteId(benutzeVoteId) >= 1;

		if (deleteSuccess) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			// ... ansonsten String (404)
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
