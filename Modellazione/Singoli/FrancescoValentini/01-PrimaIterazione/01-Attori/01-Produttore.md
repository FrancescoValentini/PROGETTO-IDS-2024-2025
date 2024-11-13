---
type: attore
nome: Produttore
tipoAttore:
  - primario
settore:
  - agricoltura
tags:
  - attore
dataInserimento: 2024-10-31
orarioInserimento: 23:10
---
# Attore: Produttore

## Descrizione
può caricare informazioni sui propri prodotti (metodi di coltivazione, certificazioni ecc.) e venderli nel marketplace.  
## Obiettivi
- Gestire le proprie informazioni come produttore
	- Username e password
	- Dettagli di contatto
	- Dettagli geografici
	- Denominazione del produttore
	- Descrizione del produttore
- Gestire le informazioni dei propri prodotti
- Gestione dei prodotti nel marketplace: i prodotti vengono presi tra quelli già inseriti dal produttore
- Gestire la comunicazione con il [[04-Curatore]]
## Casi d'Uso Associati
- [[CU-1.1-GESTIONE INFORMAZIONI PRODOTTI]]
- [[CU-1.2-GESTIONE PRODOTTI MARKETPLACE]]
- [[CU-1.3-INTERAZIONE CON CURATORE]]
## Interazioni con altri attori
- [[04-Curatore]]
## Note
- Ogni prodotto deve avere anche un codice univoco assegnato dal sistema, il "codice interno" è relativo al contesto del produttore
- I dettagli geografici di un prodotto possono essere differenti da quelli del produttore
- 