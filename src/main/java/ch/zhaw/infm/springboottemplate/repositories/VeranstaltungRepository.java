package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Veranstaltung;

public interface VeranstaltungRepository extends JpaRepository<Veranstaltung, Long>{
	Long deleteByveranstaltungId(Long veranstaltungId); 
	Veranstaltung findByVeranstaltungId(Long id);
}
