---
type: use-case
nome: CU-8.3-GESTIONE TICKETS SUPPORTO
tags:
  - use-case
dataInserimento: 2024-11-11
orarioInserimento: 15:33
---
# CU-8.3-GESTIONE TICKETS SUPPORTO

## Descrizione
L'amministratore di sistema può ricevere eventuali richieste di supporto da utenti

## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma ed essere autorizzato per l'utilizzo del caso d'uso

## Postcondizioni

## Sequenza Principale
1) L'attore accede alla dashboard dove può vedere i ticket aperti dagli utenti e gestirli
	- **Risoluzione di un ticket:**
		1) L'attore apre il ticket desiderato
		2) Il sistema mostra all'attore tutti i dettagli specificati dall'utente nel ticket
			- Nome utente
			- Data e ora apertura ticket
			- Data e ora ultima modifica
			- Priorità del ticket
			- Categoria
			- Descrizione del ticket
		3) L'Attore può chiudere il ticket inviando all'utente una risposta:
			- L'Attore sceglie di chiudere il ticket
			- Il sistema chiede l'inserimento di una descrizione riguardo la risoluzione del ticket
			- L'attore conferma la chiusura
			- Il sistema chiude il ticket e invia una notifica all'utente mittente del ticket

## Sequenze Alternative
1) L'attore può decidere la chiusura del ticket specificando un modello preimpostato per la descrizione della risoluzione del problema
2) L'attore può chiudere il ticket senza specificare alcuna descrizione (per problemi non provocati direttamente dall'utente)
## Note
