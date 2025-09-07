package it.vITA.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.vITA.RichiesteBuilder.RichiestaTrasformazione;

public interface RichiestaTrasformazioneRepository extends CrudRepository<RichiestaTrasformazione, String> {
	
	@Modifying
	@Query("DELETE FROM RichiestaTrasformazione p WHERE p.id = :id")
	void deleteRichiestaTrasformazioneById(@Param("id") String id);
}

