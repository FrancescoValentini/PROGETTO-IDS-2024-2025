package it.vITA.TESTDATA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.vITA.Models.Certificazione;
import it.vITA.Models.Evento;
import it.vITA.Models.Invito;
import it.vITA.Models.Posizione;
import it.vITA.Models.Prodotto;
import it.vITA.Models.Produttore;
import it.vITA.Models.TipologiaEvento;
import it.vITA.Models.Trasformatore;
import it.vITA.Models.Trasformazione;
import it.vITA.Models.UtenteRegistrato;
import it.vITA.Repositories.CertificazioniRepository;
import it.vITA.Repositories.EventiRepository;
import it.vITA.Repositories.InvitiRepository;
import it.vITA.Repositories.PosizioniRepository;
import it.vITA.Repositories.ProdottoRepository;
import it.vITA.Repositories.TrasformatoreRepository;
import it.vITA.Repositories.TrasformazioniRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class FakeDataLoader implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(FakeDataLoader.class);
	
	@Autowired
	EventiRepository repoEventi;
	
	@Autowired
	PosizioniRepository repoPosizioni;
	
	@Autowired
	UtenteRegistratoRepository repoUtentiRegistrati;

	@Autowired
	InvitiRepository repoInviti;
	
	@Autowired
	ProdottoRepository repoProdotti;
	
	@Autowired
	TrasformazioniRepository repoTrasformazioni;

	@Autowired
	TrasformatoreRepository repoTrasformatori;

	@Autowired
	CertificazioniRepository repoCertificazioni;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		Posizione p1 = new Posizione("LAT1","LON1");
		Posizione p2 = new Posizione("LAT2","LON2");
		Posizione p3 = new Posizione("LAT3","LON3");
		
		repoPosizioni.save(p1);
		repoPosizioni.save(p2);
		repoPosizioni.save(p3);
		
		Evento e1 = new Evento(
					LocalDateTime.now(),
					"EVENTO1-TITOLO", 
					"EVENTO1-DESC", 
					0, 
					10, 
					TipologiaEvento.EVENTO_LOCALE, p1
				);
		
		Evento e2 = new Evento(
				LocalDateTime.now(),
				"EVENTO2-TITOLO", 
				"EVENTO2-DESC", 
				50, 
				10, 
				TipologiaEvento.FIERA, p2
			);
		
		Evento e3 = new Evento(
				LocalDateTime.now(), 
				"EVENTO3-TITOLO", 
				"EVENTO3-DESC", 
				500, 
				10, 
				TipologiaEvento.FIERA, p1
			);
		
		
		repoEventi.save(e1);
		repoEventi.save(e2);
		repoEventi.save(e3);
		
        UtenteRegistrato ur1 = new UtenteRegistrato("mrossi", "pass123", "mario.rossi@example.com", "Mario", "Rossi", "3331234567", "Appassionato di tecnologia.");
        UtenteRegistrato ur2 = new UtenteRegistrato("lbianchi", "ciao456", "laura.bianchi@example.com", "Laura", "Bianchi", "3349876543", "Amo la lettura e il trekking.");
        UtenteRegistrato ur3 = new UtenteRegistrato("gverdi", "verde789", "gianni.verdi@example.com", "Gianni", "Verdi", "3351112223", "Scrittore freelance.");
        UtenteRegistrato ur4 = new UtenteRegistrato("sneri", "sunshine!", "sara.neri@example.com", "Sara", "Neri", "3364445556", "Musicista e insegnante di pianoforte.");
        UtenteRegistrato ur5 = new UtenteRegistrato("dbruno", "secureMe2024", "davide.bruno@example.com", "Davide", "Bruno", "3377778889", "Appassionato di fotografia.");

        repoUtentiRegistrati.save(ur1);
        repoUtentiRegistrati.save(ur2);
        repoUtentiRegistrati.save(ur3);
        repoUtentiRegistrati.save(ur4);
        repoUtentiRegistrati.save(ur5);
        
        
        Invito i1 = new Invito(ur1,e1);
        Invito i4 = new Invito(ur2,e1);
        Invito i6 = new Invito(ur4,e1);
        Invito i2 = new Invito(ur1,e2);
        Invito i3 = new Invito(ur1,e2);
        Invito i5 = new Invito(ur3,e3);

        repoInviti.save(i1);
        repoInviti.save(i2);
        repoInviti.save(i3);
        repoInviti.save(i4);
        repoInviti.save(i5);
        repoInviti.save(i6);
        
        



        // === CREAZIONE PRODOTTI ===
        Prodotto prod1 = new Prodotto("Mela Rossa", "Mela croccante e succosa", LocalDateTime.now().minusDays(10), LocalDateTime.now().plusDays(20), null);
        Prodotto prod2 = new Prodotto("Pera Verde", "Dolce e succosa, ideale per dolci", LocalDateTime.now().minusDays(8), LocalDateTime.now().plusDays(18), null);
        Prodotto prod3 = new Prodotto("Pomodoro", "Ideale per sughi e insalate", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(15), null);
        Prodotto prod4 = new Prodotto("Carota Bio", "Coltivata senza pesticidi", LocalDateTime.now().minusDays(5), LocalDateTime.now().plusDays(10), null);
        Prodotto prod5 = new Prodotto("Zucchina", "Fresca e leggera", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(12), null);
        Prodotto prod6 = new Prodotto("Patata Gialla", "Per fritture perfette", LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(30), null);
        Prodotto prod7 = new Prodotto("Cipolla Rossa", "Intensa e saporita", LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(25), null);
        Prodotto prod8 = new Prodotto("Lattuga", "Croccante e fresca", LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(5), null);
        Prodotto prod9 = new Prodotto("Sedano", "Ottimo per soffritti", LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(7), null);
        Prodotto prod10 = new Prodotto("Cavolo Nero", "Ricco di fibre", LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(10), null);

        repoProdotti.save(prod1);
        repoProdotti.save(prod2);
        repoProdotti.save(prod3);
        repoProdotti.save(prod4);
        repoProdotti.save(prod5);
        repoProdotti.save(prod6);
        repoProdotti.save(prod7);
        repoProdotti.save(prod8);
        repoProdotti.save(prod9);
        repoProdotti.save(prod10);
        
        
     // === CREAZIONE TRASFORMATORI ===
        Trasformatore trasf1 = new Trasformatore("username", "password" , "email", "nome" , "cognome" ,
        		"telefono", "biografia" , "PIVA123", "Azienda Bio", "0123456789", null);
        Trasformatore trasf2 = new Trasformatore("username", "password" , "email", "nome" , "cognome" ,
        		"telefono", "biografia" ,"PIVA456", "Trasformazioni Verdi", "0987654321", null);
        repoTrasformatori.save(trasf1);
        repoTrasformatori.save(trasf2);
        
        
     // === CREAZIONE CERTIFICAZIONI ===
        Certificazione cert1 = new Certificazione();
        cert1.setDenominazione("Certificazione Biologica");
        cert1.setDescrizione("Conforme agli standard biologici UE");
        cert1.setDenominazioneEnteCertificatore("BioEnte Europa");
        cert1.setDataConseguimento(LocalDateTime.now());
        cert1.setDataScadenza(LocalDateTime.now().plusYears(1));

        Certificazione cert2 = new Certificazione();
        cert2.setDenominazione("Certificazione Sostenibilità");
        cert2.setDescrizione("Ridotto impatto ambientale nei processi produttivi");
        cert2.setDenominazioneEnteCertificatore("GreenCert Italia");
        cert2.setDataConseguimento(LocalDateTime.now());
        cert2.setDataScadenza(LocalDateTime.now().plusYears(2));

        repoCertificazioni.save(cert1);
        repoCertificazioni.save(cert2);
        
     // === CREAZIONE TRASFORMAZIONI ===
        Trasformazione t1 = new Trasformazione();
        t1.setDenominazione("Trasformazione Frutta");
        t1.setDescrizione("Produzione confetture biologiche");
        t1.setDataInizioFase(LocalDateTime.now());
        t1.setDataFineFase(LocalDateTime.now().plusDays(5));
        //t1.setTrasformatore(trasf1);
        //t1.setCertificazioni(List.of(cert1, cert2));

        Trasformazione t2 = new Trasformazione();
        t2.setDenominazione("Lavorazione Verdure");
        t2.setDescrizione("Conserve di verdure stagionali");
        t2.setDataInizioFase(LocalDateTime.now());
        t2.setDataFineFase(LocalDateTime.now().plusDays(7));
        //t2.setTrasformatore(trasf2);
        //t2.setCertificazioni(List.of(cert2));

        repoTrasformazioni.save(t1);
        repoTrasformazioni.save(t2);
		
		logger.info("LOADED FAKE DATA");
		
	}
	
}
