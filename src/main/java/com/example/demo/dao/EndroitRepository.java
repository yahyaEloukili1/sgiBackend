package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.BenificiaireArchive;
import com.example.demo.entities.Endroit;
import com.example.demo.projections.BenificiaireProjection2;
import com.example.demo.projections.EndroitProjection;



@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = EndroitProjection.class)
public interface EndroitRepository extends JpaRepository<EndroitProjection, Integer> {


	@Query("SELECT b.cin, b FROM Endroit b")
	List<Object[]> findByIdentifiantGrouped();
	List<EndroitProjection> findByIdentifiantIgnoreCase(String identifiant);

	List<EndroitProjection> findByAnnexeId(Integer id);
}
