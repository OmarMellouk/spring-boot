package org.sid.dao;

import java.util.List;

import org.sid.entities.Marque;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque,Long> {
	
	@Query("select m from Marque m where m.name like :x OR m.mrqimg like :x" )
	public List<Marque> findByNameLike(@Param("x")String name);
	
	
}
