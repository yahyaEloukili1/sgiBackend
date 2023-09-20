package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.BenificiaireArchive;
import com.example.demo.entities.Endroit;
import com.example.demo.projections.BenificiaireProjection2;
import com.example.demo.projections.EndroitProjection;



@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = EndroitProjection.class)
public interface EndroitRepository extends JpaRepository<Endroit, Integer> {


	@Query("SELECT b.designation, b FROM Endroit b")
	List<Object[]> findByDesignationGrouped();
	List<Endroit> findByDesignationIgnoreCase(String designation);

	List<Endroit> findByAnnexeId(Integer id);
	List<Endroit> findByDistrictId(Integer id);
	List<Endroit> findByCategorieId(Integer id);
	 @Query("SELECT e FROM Endroit e WHERE e.annexe.id = :annexeId AND e.categorie.id = :categorieId")
	    List<Endroit> findByAnnexeAndCategorie(@Param("annexeId") Integer annexeId, @Param("categorieId") Integer categorieId);

}
