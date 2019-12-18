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

import ch.zhaw.infm.springboottemplate.entities.ArtistSocialMediaLink;
import ch.zhaw.infm.springboottemplate.entities.Genre;
import ch.zhaw.infm.springboottemplate.entities.Veranstaltung;
import ch.zhaw.infm.springboottemplate.repositories.ArtistSocialMediaLinkRepository;
import ch.zhaw.infm.springboottemplate.repositories.GenreRepository;

@RestController
public class ArtistSocialMediaLinkController {
	@Autowired
	private ArtistSocialMediaLinkRepository artistSocialMediaLinkRepository;
	
	@GetMapping("/fave/socialMediaLink/{artistId}")
	public ResponseEntity <List<ArtistSocialMediaLink>> getArtistSociaMediaLinks(@PathVariable("artistId") Long artistId){
		
		List<ArtistSocialMediaLink> links = artistSocialMediaLinkRepository.findByArtistArtistId(artistId);

		if (links != null && !links.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity<List<ArtistSocialMediaLink>>(links, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity<List<ArtistSocialMediaLink>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/fave/newSocialMediaLink")
	public ArtistSocialMediaLink newVeranstaltung(@RequestBody ArtistSocialMediaLink socialMediaLink) {
		return artistSocialMediaLinkRepository.save(socialMediaLink);
	}
	
	@RequestMapping(value = "/fave/updateSocialMediaLink/{socialMediaLinkId}", method = RequestMethod.PUT)
    public ResponseEntity<ArtistSocialMediaLink> updateVeranstaltung(@PathVariable("socialMediaLinkId") Long socialMediaLinkId, @RequestBody ArtistSocialMediaLink socialMediaLink) {
 
		ArtistSocialMediaLink currentSocialMediaLink = artistSocialMediaLinkRepository.findByArtistSocialMediaLinkId(socialMediaLinkId);
 
        currentSocialMediaLink.setFacebook(socialMediaLink.getFacebook());
        currentSocialMediaLink.setInstagram(socialMediaLink.getInstagram());
        currentSocialMediaLink.setYoutube(socialMediaLink.getYoutube());
        currentSocialMediaLink.setTwitter(socialMediaLink.getTwitter());
 
        artistSocialMediaLinkRepository.save(currentSocialMediaLink);
        return new ResponseEntity<ArtistSocialMediaLink>(currentSocialMediaLink, HttpStatus.OK);
    }
}
