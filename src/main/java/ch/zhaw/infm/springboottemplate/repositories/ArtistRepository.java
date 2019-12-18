package ch.zhaw.infm.springboottemplate.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.infm.springboottemplate.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist,Long>{
	
	/*@Query("SELECT a.artistId, a.name, a.artistImage FROM Artist a JOIN a.veranstaltungen v where v.Datum > ?1")
	List<Artist> findArtistsWithVeranstaltung(Date datum);*/
	
}
