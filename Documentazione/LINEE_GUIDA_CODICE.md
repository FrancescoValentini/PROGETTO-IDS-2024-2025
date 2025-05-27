# Suddivisione dei Packages
Ogni classe, interfaccia, ... deve essere  realizzata all'interno del suo package name corrispondente, quest'ultimo se non esiste va creato dandogli il nome più adatto per ciò che dovrà contenere, ogni package va creato come sotto-package del principale.

**Nota:** Il package principale deve contenere soltanto la classe necessaria per l'avvio dell'applicazione
## Packages

| NOME         | DESCRIZIONE CONTENUTO                                                                |
| ------------ | ------------------------------------------------------------------------------------ |
| Models       | Modelli necessari per il progetto (UtenteRegistrato, Prodotto, ...)                  |
| REST         | Controllers REST                                                                     |
| Repositories | Repositories necessarie per la memorizzazione delle informazioni                     |
| DTO          | Data Transfer Objects                                                                |
| Filters      | Servlet Filter di Spring Boot                                                        |
| Config       | Configurazioni di Spring Boot (SpringSecurity, ...)                                  |
| Exceptions   | Eccezioni                                                                            |
| Utils        | Utility che svolgono azioni generiche nel progetto (Generazione e verifica JWT, ...) |
| TESTDATA     | Classi necessarie per il caricamento di informazioni di test                         |

**Composizione del Package:** seguendo la tabella sopracitata la composizione del package è:
- **it.vITA**.**nome**
- **Esempio:** package base: it.vITA
	- **Modelli:** it.vITA.models
	- **REST:** it.vITA.REST
	
# Nomenclatura classi
- **Controller Rest**: `NomeRisorsaController` (es. `UserController`).
- **Modelli**: `NomeModello` (es. `User`).
- **Repository**: `NomeModelloRepository` (es. `UserRepository`).
- **Eccezioni**: `NomeErroreException` (es. `UnauthorizedException`).
- **DTO**: `NomeModelloDTO` (es. `UserDTO`).
- **Filtri:** `NomeRisorsaFilter` (es. `JWTFilter` )
- **Utils:** `NomeRisorsaUtils` (es. `JWTUtils`)

# Nomenclatura dei Branch Git

**Prefisso**
- **feature/<iniziali nome cognome**: Per nuove funzionalità.
- **bugfix/<iniziali nome cognome**: Per correzioni di bug.
- **docs/<iniziali nome cognome**: Per preparare una nuova release.
- **refactor/<iniziali nome cognome** Per refactoring del codice.

**Esempi:**
- `feature/gb-controller-rest-produttori`
- `feature/gp-autenticazione`
- `docs/fv-controller-rest-produttori`

# Nomenclatura dei Metodi CRUD
- **Create**: `createNomeModello` (es. `createUser`).
- **Read**: `getNomeModello` o `getAllNomeModelli` (es. `getUser`, `getAllUsers`).
- **Update**: `updateNomeModello` (es. `updateUser`).
- **Delete**: `deleteNomeModello` (es. `deleteUser`).

# Nomenclatura degli Endpoint API e Metodi HTTP

| Metodo HTTP | Endpoint             | Descrizione                     | Esempio             |
| ----------- | -------------------- | ------------------------------- | ------------------- |
| GET         | `/nome-risorsa`      | Ottiene una lista di risorse.   | `GET /users`        |
| GET         | `/nome-risorsa/{id}` | Ottiene una risorsa specifica.  | `GET /users/123`    |
| POST        | `/nome-risorsa`      | Crea una nuova risorsa.         | `POST /users`       |
| PUT         | `/nome-risorsa/{id}` | Aggiorna una risorsa esistente. | `PUT /users/123`    |
| DELETE      | `/nome-risorsa/{id}` | Elimina una risorsa.            | `DELETE /users/123` |

# CODICI DI RISPOSTA HTTP
## CODICI DI SUCCESSO
| Codice HTTP | Descrizione                                                                           | Esempio di Utilizzo                          |
| ----------- | ------------------------------------------------------------------------------------- | -------------------------------------------- |
| 200         | OK - Richiesta eseguita con successo.                                                 | Richiesta GET per ottenere una risorsa.      |
| 201         | Creato - Richiesta eseguita con successo e nuova risorsa creata.                      | Richiesta POST per creare una nuova risorsa. |
| 204         | Nessun Contenuto - Richiesta eseguita con successo ma nessun contenuto da restituire. | Richiesta DELETE per eliminare una risorsa.  |

## CODICI DI ERRORE
| Codice HTTP | Descrizione                                                          | Esempio di Utilizzo                                       |
| ----------- | -------------------------------------------------------------------- | --------------------------------------------------------- |
| 400         | Richiesta Non Valida - La richiesta non è stata compresa dal server. | Dati mancanti o non validi o risorsa già esistente.       |
| 401         | Non Autorizzato - Autenticazione richiesta o fallita.                | Tentativo di accesso senza token JWT valido.              |
| 403         | Accesso Negato - Il client non ha i permessi necessari.              | Tentativo di accesso a una risorsa riservata.             |
| 404         | Non Trovato - La risorsa richiesta non è stata trovata.              | ID di una risorsa inesistente.                            |
| 500         | Errore Interno del Server - Errore generico del server.              | Errore imprevisto durante l'elaborazione della richiesta. |
| 501         | 501 Not Implemented                                                  | Metodo non ancora implementato                            |
