---
type: use-case
nome: CU-5.1 - GESTIONE DEGLI EVENTI
tags:
  - use-case
dataInserimento: 2024-11-10
orarioInserimento: 18:40
---
# CU-5.1 - GESTIONE DEGLI EVENTI

## Descrizione
Consente la gestione degli eventi, le attività come visite alle aziende, o tour di degustazione sono considerati eventi al pari delle fiere e non richiedono trattamenti differenti dei loro attributi (o attributi aggiuntivi)

## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma ed essere autorizzato per l'utilizzo del caso d'uso


## Postcondizioni

## Sequenza Principale
1) L'attore accede ad una "dashboard" dove può vedere una lista degli eventi che ha creato e può decidere di inserirne di nuovi, modificare quelli esistenti o eliminarli
2) L'attore attiva la funzione per l'inserimento di un novo evento
3) Il sistema richiede all'attore l'inserimento di:
	- Denominazione evento
	- Data e ora evento
	- Luogo evento
	- Locandina
	- Descrizione evento
	- Prezzo di ingresso
	- Posti disponibili
4) L'attore può confermare l'inserimento dell'evento, se viene confermato si trova in uno stato dove è possibile l'invio di inviti ad altri attori
## Sequenze Alternative
1) Se l'evento non ha un prezzo di ingresso è possibile non specificarlo
2) Se l'evento non ha un numero limitato di posti disponibili è possibile non specificare il valore
## Note
