---
type: use-case
nome: CU-4.1 - GESTONE RICHIESTE DI REVISIONE
tags:
  - use-case
dataInserimento: 2024-11-10
orarioInserimento: 18:24
---
# CU-4.1 - GESTONE RICHIESTE DI REVISIONE

## Descrizione
Il curatore riceve le richieste di revisione, tali richieste possono essere approvate o rifiutate per poi inviare il risultato al mittente.
## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma ed essere autorizzato per l'utilizzo del caso d'uso

## Postcondizioni

## Sequenza Principale
1) L'attore accede alla sua "dashboard" dove può vedere tutte le richieste di revisione che devono essere processate
2) L'attore seleziona la richiesta pendente che desidera revisionare e visualizza il contenuto che deve validare
3) L'attore può decidere se approvare o rifiutare la richiesta di revisione:
	1) **Approvazione:** Viene inviata una notifica all'attore che ha aperto la richiesta di revisione
	2) **Rifiuto:** L'attore può specificare una eventuale descrizione, l'operazione di rifiuto invia una notifica all'attore che ha aperto la richiesta di revisione al fine di visionare l'eventuale messaggio
## Sequenze Alternative
1) L'attore può decidere di non approvare ne rifiutare una richiesta ma di assegnare una etichetta per poi rivederla in futuro
## Note
