package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Konsument;

public interface KonsumentRepository extends JpaRepository<Konsument, Long>{

}
