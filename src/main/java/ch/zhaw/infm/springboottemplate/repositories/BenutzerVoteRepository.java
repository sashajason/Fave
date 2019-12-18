package ch.zhaw.infm.springboottemplate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.zhaw.infm.springboottemplate.entities.BenutzerVote;

public interface BenutzerVoteRepository extends JpaRepository<BenutzerVote,Long>{
	
	List<BenutzerVote> findByArtistArtistId(Long id);
	
}
