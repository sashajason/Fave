package ch.zhaw.infm.springboottemplate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.ArtistSocialMediaLink;
import ch.zhaw.infm.springboottemplate.entities.Veranstaltung;

public interface ArtistSocialMediaLinkRepository extends JpaRepository<ArtistSocialMediaLink, Long>{
	List<ArtistSocialMediaLink> findByArtistArtistId(Long id);
	ArtistSocialMediaLink findByArtistSocialMediaLinkId(Long id);
	
}
