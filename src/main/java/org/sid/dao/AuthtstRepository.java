package org.sid.dao;

import org.sid.entities.Authtst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthtstRepository extends JpaRepository<Authtst,Long> {

}
