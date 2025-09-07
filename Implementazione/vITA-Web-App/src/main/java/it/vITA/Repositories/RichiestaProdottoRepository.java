package it.vITA.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.vITA.RichiesteBuilder.RichiestaProdotto;



public interface RichiestaProdottoRepository extends CrudRepository<RichiestaProdotto, String>{
	
	@Modifying
	@Query("DELETE FROM RichiestaProdotto p WHERE p.id = :id")
	void deleteRichiestaProdottoById(@Param("id") String id);
}
