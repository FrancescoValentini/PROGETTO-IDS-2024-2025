---
type: use-case
nome: GESTIONE INFORMAZIONI PRODOTTI
tags:
  - use-case
dataInserimento: 2024-11-01
orarioInserimento: 18:32
---
# Caso d'Uso: CU-1.1-GESTIONE INFORMAZIONI PRODOTTI

## Descrizione
Consente l'inserimento, la modifica e la rimozione delle informazioni relative al prodotto


## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma

## Postcondizioni

## Sequenza Principale
1) Il sistema chiede all'attore di inserire le seguenti informazioni
	- "Codice Interno"
	- Denominazione
	- Descrizione del prodotto
	- Immagine prodotto
	- Data di produzione
	- Data di scadenza prodotto
	- Informazioni riguardo la presenza di eventuali allergeni
	- Informazioni geografiche del prodotto
	- Metodologia di coltivazione
	- Certificazioni
2) L'attore può confermare o rifiutare l'operazione
	1) **Conferma:** il prodotto viene messo in uno stato di "attesa revisione"
	2) **Annulla:** i dati inseriti vengono cancellati e l'operazione è annullata
## Sequenze Alternative
1) L'attore non possiede la certificazione del prodotto:
	- Il prodotto viene inserito in uno stato di "non certificato" e non può essere inviato al curatore

## Note
