package com.andrelake.diospringmvcjedi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrelake.diospringmvcjedi.model.Jedi;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long>{

	List<Jedi> findByNameContainingIgnoreCase(final String name);
}
