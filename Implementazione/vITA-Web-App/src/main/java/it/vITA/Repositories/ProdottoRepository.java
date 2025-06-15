package it.vITA.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.vITA.Models.Prodotto;

public interface ProdottoRepository extends CrudRepository<Prodotto, String> {
	@Modifying
	@Query("DELETE FROM Prodotto p WHERE p.id = :id")
	void deleteProdottoById(@Param("id") String id);
}

