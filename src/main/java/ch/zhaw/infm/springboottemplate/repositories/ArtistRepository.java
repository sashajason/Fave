package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist,Long>{

}
