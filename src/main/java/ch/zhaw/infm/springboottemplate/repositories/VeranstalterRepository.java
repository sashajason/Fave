package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Veranstalter;

public interface VeranstalterRepository extends JpaRepository<Veranstalter, Long>{

}
