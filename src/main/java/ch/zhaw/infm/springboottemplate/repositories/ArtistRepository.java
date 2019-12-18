package ch.zhaw.infm.springboottemplate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.infm.springboottemplate.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist,Long>{
	
	@Query(value="SELECT * FROM Artist a JOIN a.veranstaltungen v where v.Datum > ?1", nativeQuery = true)
	List<Artist> findArtistsWithVeranstaltung(Long datum);
	
	Artist findByArtistId(Long id);
	
}
