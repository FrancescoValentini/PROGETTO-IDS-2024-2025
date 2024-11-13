---
type: use-case
nome: CU-8.1-GESTIONE UTENTI
tags:
  - use-case
dataInserimento: 2024-11-11
orarioInserimento: 15:24
---
# CU-8.1-GESTIONE UTENTI

## Descrizione
Consente all'attore di gestire gli utenti nella piattaforma e i loro ruoli 

## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma ed essere autorizzato per l'utilizzo del caso d'uso

## Postcondizioni

## Sequenza Principale
1) L'attore accede alla dashboard per la gestione delle utenze dove può modificare utenti già esistenti, o aggiungerne di nuovi
	1) **Aggiunta utente:**
		- Il sistema chiede l'inserimento del nome utente e della mail
		- Il sistema chiede all'attore di specificare il ruolo dell'utente
		- Il sistema genera una password random associata all'utente
	2) **Modifica utente:**
		 - L'attore seleziona l'utente da modificare
		 - Il sistema apre la schermata che consente la modifica dei dati utente
	3) **Eliminazione utente:**
		- L'attore seleziona l'utente da eliminare
		- Il sistema chiede conferma
		- Il sistema chiede la password di amministrazione
			- **Password corretta:** l'utente selezionato viene eliminato
			- **Password errata:** Viene richiesto di reinserire la password
## Sequenze Alternative
1) L'attore potrebbe decidere di caricare informazioni ulteriori all'utente
	- Il sistema chiede l'inserimento del nome utente e della mail
	- Il sistema chiede all'attore di specificare il ruolo dell'utente
		- L'attore specifica informazioni aggiuntive relative al ruolo assegnato all'utente
	- Il sistema genera una password random associata all'utente
2) L'attore può scegliere di sospendere temporaneamente un utente senza eliminare l'account (specificando una motivazione opzionali)
## Note
