---
type: use-case
nome: GESTIONE PRODOTTI MARKETPLACE
tags:
  - use-case
dataInserimento: 2024-11-01
orarioInserimento: 18:33
---
# Caso d'Uso: CU-1.2-GESTIONE PRODOTTI MARKETPLACE

## Descrizione
Consente l'inserimento, la modifica e la rimozione di un annuncio nel marketplace

## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma


## Postcondizioni

## Sequenza Principale
1) L'attore deve inserire le seguenti informazioni:
	- Prezzo di vendita
	- Categoria prodotto
	- Immagine della confezione
	- Descrizione annuncio
2) L'attore può confermare o rifiutare l'operazione
	1) **Conferma:** il prodotto viene inserito nel marketplace
	2) **Annulla:** i dati inseriti vengono cancellati e l'operazione è annullata
## Sequenze Alternative
1) Il prodotto non esiste
	- Viene richiesto l'inserimento del prodotto
2) Il prodotto non è stato approvato da un curatore
	- Il prodotto viene caricato nel marketplace ma con uno stato di "non pubblicato" e quindi non sarà visibile agli altri attori finché non viene approvato dal curatore
## Note
