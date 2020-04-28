package org.sid.dao;


import java.util.List;


import org.sid.entities.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone,Long>{

	

	List<Telephone> findByMarqueId(Long studentId);

	
	@Query("select m FROM Telephone m inner join m.marque n ON n.id like:id where m.name like :x OR m.telimg like :x" ) 
	public List<Telephone> findByNameLike(@Param("x") String name,@Param("id") Long marqueId);



	@Query("select m from Telephone m where m.name like :x OR m.telimg like :x" )
	public List<Telephone> findByNameLike2(@Param("x")String name);
}
