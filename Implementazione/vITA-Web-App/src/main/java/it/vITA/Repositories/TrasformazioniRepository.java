package it.vITA.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.vITA.Models.Trasformazione;

public interface TrasformazioniRepository extends CrudRepository<Trasformazione, String> {
	@Modifying
	@Query("DELETE FROM Trasformazione p WHERE p.id = :id")
	void deleteTrasformazioneById(@Param("id") String id);
}
