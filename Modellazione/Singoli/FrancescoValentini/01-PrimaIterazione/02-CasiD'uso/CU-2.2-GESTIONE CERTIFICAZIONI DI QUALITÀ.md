---
type: use-case
nome: CU-2.2-GESTIONE CERTIFICAZIONI DI QUALITÀ
tags:
  - use-case
dataInserimento: 2024-11-03
orarioInserimento: 19:22
---
# CU-2.2-GESTIONE CERTIFICAZIONI DI QUALITÀ

## Descrizione
Consente al [[02-Trasformatore]] di gestire le informazioni relative alle certificazioni di qualità dei prodotti

## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma ed essere autorizzato per l'utilizzo del caso d'uso
- Il prodotto a cui si vuole associare la certificazione deve essere già inserito nel sistema

## Postcondizioni

## Sequenza Principale
1) L'Attore decide il prodotto già presente nel sistema a cui aggiungere la certificazione
2) Il sistema chiede all'attore l'inserimento di:
	- Denominazione
	- Descrizione
	- Data acquisizione della certificazione
	- Certificatore
	- URL Certificazione
	- Documentazione associata
3) L'attore può confermare o rifiutare l'operazione
	1) **Conferma:** le informazioni caricate sono in uno stato di "attesa revisione"
	2) **Annulla:** i dati inseriti vengono cancellati e l'operazione è annullata

## Sequenze Alternative
1) Nel caso in cui la certificazione non abbia un URL ma solo un documento è possibile caricare solo quello
2) L'attore può non specificare l'URL e/o la documentazione, in questo caso la certificazione rimane "pendente" e non può essere inviata in revisione finché tutti i dati non sono presenti
## Note
