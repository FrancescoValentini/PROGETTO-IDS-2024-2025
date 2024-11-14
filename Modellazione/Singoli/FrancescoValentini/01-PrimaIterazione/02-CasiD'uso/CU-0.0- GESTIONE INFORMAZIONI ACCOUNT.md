---
type: use-case
nome: CU-0.0- GESTIONE INFORMAZIONI ACCOUNT
tags:
  - use-case
dataInserimento: 2024-11-14
orarioInserimento: 19:29
---
# CU-0.0- GESTIONE INFORMAZIONI ACCOUNT

## Descrizione
Consente all'utente di gestire le proprie informazioni di base generiche come:
- Nome
- Cognome
- Email
- Username
- Password
- Numero di telefono

## Attori Coinvolti
- **Attore principale**: 
- **Altri attori**: 

## Precondizioni
- L'attore deve aver effettuato l'accesso

## Postcondizioni

## Sequenza Principale
- **Modifica delle proprie informazioni:**
	- L'utente seleziona l'opzione per modificare le proprie informazioni
	- Il sistema mostra all'utente le informazioni che ha memorizzato riguardo l'utente
	- L'utente modifica uno o più elementi
	- L'utente conferma la modifica
	- Il sistema verifica la password dell'utente
	- Il sistema conferma l'avvenuta modifica delle informazioni
- **Modifica della password:**
	- L'utente seleziona l'opzione di modifica della password
	- Il sistema chiede all'utente l'inserimento della password attuale e della nuova password che deve essere ripetuta due volte
	- Il sistema verifica che la nuova password sia valida in entrambi i campi
	- Il sistema verifica che la password precedente sia valida
	- il sistema aggiorna la password e mostra all'utente il messaggio di conferma

## Sequenze Alternative
- **Password dimenticata:** 
	- Il sistema propone all'utente l'apertura di un ticket di supporto per l'amministratoe di sistema
	- l'utente conferma l'invio del ticket
	- Il sistema mostra all'utente il messaggio di avvenuta creazione del ticket
## Note
