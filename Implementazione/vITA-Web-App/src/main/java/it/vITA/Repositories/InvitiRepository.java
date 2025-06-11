package it.vITA.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.vITA.Models.Invito;

public interface InvitiRepository extends CrudRepository<Invito, String> {
	@Modifying
	@Query("DELETE FROM Invito i WHERE i.id = :id")
	void deleteInvitoById(@Param("id") String id);
}
