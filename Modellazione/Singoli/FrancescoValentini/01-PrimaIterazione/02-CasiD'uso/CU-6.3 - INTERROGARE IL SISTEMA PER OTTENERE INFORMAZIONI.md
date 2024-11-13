---
type: use-case
nome: CU-6.3 - INTERROGARE IL SISTEMA PER OTTENERE INFORMAZIONI
tags:
  - use-case
dataInserimento: 2024-11-10
orarioInserimento: 19:08
---
# CU-6.3 - INTERROGARE IL SISTEMA PER OTTENERE INFORMAZIONI

## Descrizione
Il seguente caso d'uso può essere utilizzato senza aver effettuato il login, consente di effettuare una ricerca che comprende
	- Ricerca per nome prodotto
	- Ricerca per categoria prodotto
	- Ricerca per codice univoco
L'utente può specificare direttamente se fare la ricerca per un determinato parametro o inserire del testo in una casella ed il sistema proverà poi a restituire gli elementi più coerenti con quanto specificato dall'utente

## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni


## Postcondizioni

## Sequenza Principale
1) **L'utente seleziona la modalità di ricerca** (nome prodotto, categoria prodotto, codice univoco) o inserisce del testo nella casella di ricerca.
2) **Il sistema elabora la richiesta di ricerca** e restituisce una lista di risultati coerenti con la ricerca effettuata dall'utente.
3) **L'utente visualizza i risultati della ricerca** e può selezionare un prodotto per visualizzare ulteriori informazioni.

## Sequenze Alternative
- Ricerca per nome prodotto
	1. **L'utente seleziona la modalità di ricerca** "Nome prodotto" e inserisce il nome del prodotto nella casella di ricerca.
	2. **Il sistema elabora la richiesta di ricerca** e restituisce una lista di prodotti che corrispondono al nome inserito dall'utente.
- Ricerca per categoria prodotto
	1. **L'utente seleziona la modalità di ricerca** "Categoria prodotto" e seleziona la categoria desiderata dalla lista di opzioni.
	2. **Il sistema elabora la richiesta di ricerca** e restituisce una lista di prodotti che appartengono alla categoria selezionata dall'utente.
- Ricerca per codice univoco
	1. **L'utente seleziona la modalità di ricerca** "Codice univoco" e inserisce il codice univoco del prodotto nella casella di ricerca.
	2. **Il sistema elabora la richiesta di ricerca** e restituisce il prodotto che corrisponde al codice univoco inserito dall'utente.

## Note
