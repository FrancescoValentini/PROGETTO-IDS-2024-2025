---
type: use-case
nome: CU-2.1-GESTIONE DELLE FASI DI PRODUZIONE
tags:
  - use-case
dataInserimento: 2024-11-03
orarioInserimento: 19:08
---
# CU-2.1-GESTIONE INFORMAZIONI PROCESSI DI TRASFORMAZIONE

## Descrizione


## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma ed essere autorizzato per l'utilizzo del caso d'uso

## Postcondizioni

## Sequenza Principale
1) L'Attore decide il prodotto già presente nel sistema a cui aggiungere le informazioni
2) Il sistema chiede all'attore l'inserimento di:
	1) Denominazione della fase di produzione
	2) Descrizione della fase di produzione
	3) Data di inizio della fase di produzione
	4) Data di fine della fase di produzione
	5) (opzionale) Note
3) L'attore può confermare o rifiutare l'operazione
	1) **Conferma:** le informazioni caricate sono in uno stato di "attesa revisione"
	2) **Annulla:** i dati inseriti vengono cancellati e l'operazione è annullata
## Sequenze Alternative
1) L'attore può non inserire le note
2) L'attore può specificare ulteriori dettagli relativi alla collocazione geografica di dove è avvenuta la trasformazione
## Note
