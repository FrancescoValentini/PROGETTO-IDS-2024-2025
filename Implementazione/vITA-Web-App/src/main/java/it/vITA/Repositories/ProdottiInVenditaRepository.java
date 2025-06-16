package it.vITA.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.vITA.Models.ProdottoInVendita;

public interface ProdottiInVenditaRepository extends CrudRepository<ProdottoInVendita, String> {
	@Modifying
	@Query("DELETE FROM ProdottoInVendita p WHERE p.id = :id")
	void deleteProdottoInVenditaById(@Param("id") String id);
}
