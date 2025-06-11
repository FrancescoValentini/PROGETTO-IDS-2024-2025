package it.vITA.TESTDATA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.vITA.Models.Evento;
import it.vITA.Models.Invito;
import it.vITA.Models.Posizione;
import it.vITA.Models.TipologiaEvento;
import it.vITA.Models.UtenteRegistrato;
import it.vITA.Repositories.EventiRepository;
import it.vITA.Repositories.InvitiRepository;
import it.vITA.Repositories.PosizioniRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;

import java.time.LocalDateTime;

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
        
        
        Invito i1 = new Invito(ur1);
        Invito i2 = new Invito(ur1);
        Invito i3 = new Invito(ur1);
        Invito i4 = new Invito(ur2);
        Invito i5 = new Invito(ur3);
        Invito i6 = new Invito(ur4);

        repoInviti.save(i1);
        repoInviti.save(i2);
        repoInviti.save(i3);
        repoInviti.save(i4);
        repoInviti.save(i5);
        repoInviti.save(i6);
        
        
		
		logger.info("LOADED FAKE DATA");
		
	}
	
}
