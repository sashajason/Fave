package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

	Long deleteBylocationId(Long locationId); 
	
}
