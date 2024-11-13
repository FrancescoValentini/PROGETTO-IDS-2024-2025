---
type: use-case
nome: CU-6.1 - PRENOTARE LA PARTECIPAZIONE AD EVENTI
tags:
  - use-case
dataInserimento: 2024-11-10
orarioInserimento: 19:07
---
# CU-6.1 - PRENOTARE LA PARTECIPAZIONE AD EVENTI

## Descrizione
Consente ad un utente registrato di prenotarsi ad uno o più eventi

## Attori Coinvolti
- **Attore principale**:
- **Altri attori**: 

## Precondizioni
- l'Utente deve aver effettuato il login nella piattaforma ed essere autorizzato per l'utilizzo del caso d'uso

## Postcondizioni

## Sequenza Principale
1. **Utente seleziona evento**: l'Utente seleziona l'evento per cui desidera prenotarsi
2. **Sistema verifica disponibilità**: il sistema verifica la disponibilità di posti per l'evento selezionato
3. **Utente conferma prenotazione**: l'Utente conferma la prenotazione per l'evento selezionato
4. **Sistema registra prenotazione**: il sistema registra la prenotazione per l'evento selezionato
5. **Sistema invia conferma**: il sistema invia una conferma della prenotazione via email o notifica sul sistema
## Sequenze Alternative
1) Nel caso in cui l'evento abbia posti limitati ed il limite sia stato raggiunto allora la prenotazione viene aggiunta in una "coda" e l'attore sarà notificato qualora qualche altro utente dovesse ritirarsi
## Note
