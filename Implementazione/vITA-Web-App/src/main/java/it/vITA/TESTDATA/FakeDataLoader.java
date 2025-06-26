package it.vITA.TESTDATA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.vITA.Models.Certificazione;
import it.vITA.Models.Evento;
import it.vITA.Models.Invito;
import it.vITA.Models.Posizione;
import it.vITA.Models.Prodotto;
import it.vITA.Models.ProdottoInVendita;
import it.vITA.Models.Produttore;
import it.vITA.Models.TipoRichiesta;
import it.vITA.Models.TipologiaEvento;
import it.vITA.Models.Trasformatore;
import it.vITA.Models.Trasformazione;
import it.vITA.Models.UtenteRegistrato;
import it.vITA.Repositories.CertificazioniRepository;
import it.vITA.Repositories.EventiRepository;
import it.vITA.Repositories.InvitiRepository;
import it.vITA.Repositories.PosizioniRepository;
import it.vITA.Repositories.ProdottiInVenditaRepository;
import it.vITA.Repositories.ProdottoRepository;
import it.vITA.Repositories.ProduttoriRepository;
import it.vITA.Repositories.RichiestaProdottoRepository;
import it.vITA.Repositories.TrasformatoreRepository;
import it.vITA.Repositories.TrasformazioniRepository;
import it.vITA.Repositories.UtenteRegistratoRepository;
import it.vITA.RichiesteBuilder.RichiestaProdotto;
import it.vITA.RichiesteBuilder.RichiestaProdottoBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
  
  @Autowired
	ProdottiInVenditaRepository repoProdottiInVendita;
  
  @Autowired
  ProduttoriRepository repoProduttori;
  
  @Autowired
  RichiestaProdottoRepository repoRichiestaP;

	
	
	
	@Override
	public void run(String... args) throws Exception {
		/*Posizione p1 = new Posizione("81919e63-4985-44a2-8331-79f82076466e","LAT1","LON1");
		Posizione p2 = new Posizione("b194f4eb-1c80-4e66-804e-544885ecf396","LAT2","LON2");
		Posizione p3 = new Posizione("766427fc-aadd-420c-a3be-78f36d308716","LAT3","LON3");
		
		repoPosizioni.save(p1);
		repoPosizioni.save(p2);
		repoPosizioni.save(p3);
		
		Evento e1 = new Evento(
				"f7807ce6-11eb-4de5-b338-6b99ba7bc67e",
					LocalDateTime.now(),
					"EVENTO1-TITOLO", 
					"EVENTO1-DESC", 
					0, 
					10, 
					TipologiaEvento.EVENTO_LOCALE, p1
				);
		
		Evento e2 = new Evento(
				"b03e74f7-050c-4b89-89f1-e747c29b290f",
				LocalDateTime.now(),
				"EVENTO2-TITOLO", 
				"EVENTO2-DESC", 
				50, 
				10, 
				TipologiaEvento.FIERA, p2
			);
		
		Evento e3 = new Evento(
				"bf50b819-a1a0-4544-a66a-3d332d71d599",
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
		
		UtenteRegistrato ur1 = new UtenteRegistrato("9bdc4e74-0518-4a54-a185-60fa3f9ebfae","mrossi", "pass123", "mario.rossi@example.com", "Mario", "Rossi", "3331234567", "Appassionato di tecnologia.");
		UtenteRegistrato ur2 = new UtenteRegistrato("879a7098-a2ef-43d9-9014-80c3ba7e9548","lbianchi", "ciao456", "laura.bianchi@example.com", "Laura", "Bianchi", "3349876543", "Amo la lettura e il trekking.");
		UtenteRegistrato ur3 = new UtenteRegistrato("8b87ec22-471e-4027-a9c2-1458e7fa530f","gverdi", "verde789", "gianni.verdi@example.com", "Gianni", "Verdi", "3351112223", "Scrittore freelance.");
		UtenteRegistrato ur4 = new UtenteRegistrato("49f60305-e6b1-4707-bf12-16319194eab5","sneri", "sunshine!", "sara.neri@example.com", "Sara", "Neri", "3364445556", "Musicista e insegnante di pianoforte.");
		UtenteRegistrato ur5 = new UtenteRegistrato("0f0e3177-4623-4302-95f1-2129ed324d7c","dbruno", "secureMe2024", "davide.bruno@example.com", "Davide", "Bruno", "3377778889", "Appassionato di fotografia.");

        repoUtentiRegistrati.save(ur1);
        repoUtentiRegistrati.save(ur2);
        repoUtentiRegistrati.save(ur3);
        repoUtentiRegistrati.save(ur4);
        repoUtentiRegistrati.save(ur5);
        
        
        Invito i1 = new Invito("4101c26f-f853-40d7-96a3-fc0f5c79b2af",ur1,e1);
        Invito i4 = new Invito("90925979-9021-4344-b7b9-1890454c0e45",ur2,e1);
        Invito i6 = new Invito("b5775f47-736a-4e76-9354-344da1bcd1bc",ur4,e1);
        Invito i2 = new Invito("406da84b-d2ee-49fa-aeaf-aceb79dfe65c",ur1,e2);
        Invito i3 = new Invito("df8867a4-64a9-4843-a6da-2e246fd1b568",ur1,e2);
        Invito i5 = new Invito("9f54b822-b7b4-4022-ba93-7a44137ce3fc",ur3,e3);

        repoInviti.save(i1);
        repoInviti.save(i2);
        repoInviti.save(i3);
        repoInviti.save(i4);
        repoInviti.save(i5);
        repoInviti.save(i6);
        
        
        // Produttori
        Produttore produ1 = new Produttore("508135e4-9287-48e0-bc9c-78b7248dc1d5","mrossi", "pass123", "mario.rossi@example.com", "Mario", "Rossi", "3331234567", "Appassionato di tecnologia.","PIVA","DENOMAZIENDA","TELEAZIENDALE",p1);
        Produttore produ2 = new Produttore("dbc34534-1a31-4e02-8bdc-170609701239","lbianchi", "ciao456", "laura.bianchi@example.com", "Laura", "Bianchi", "3349876543", "Amo la lettura e il trekking.","PIVA","DENOMAZIENDA","TELEAZIENDALE",p1);
        Produttore produ3 = new Produttore("9eebee05-0785-43cf-9184-052ccd85597a","gverdi", "verde789", "gianni.verdi@example.com", "Gianni", "Verdi", "3351112223", "Scrittore freelance.","PIVA","DENOMAZIENDA","TELEAZIENDALE",p1);
        Produttore produ4 = new Produttore("8ad25492-4c1a-44bb-8c17-1cb4a0b47c8d","sneri", "sunshine!", "sara.neri@example.com", "Sara", "Neri", "3364445556", "Musicista e insegnante di pianoforte.","PIVA","DENOMAZIENDA","TELEAZIENDALE",p1);
        Produttore produ5 = new Produttore("c3ce0581-eafb-4ede-abba-0014313c7406","dbruno", "secureMe2024", "davide.bruno@example.com", "Davide", "Bruno", "3377778889", "Appassionato di fotografia.","PIVA","DENOMAZIENDA","TELEAZIENDALE",p1);
		
        repoProduttori.save(produ1);
        repoProduttori.save(produ2);
        repoProduttori.save(produ3);
        repoProduttori.save(produ4);
        repoProduttori.save(produ5);

        // === CREAZIONE PRODOTTI ===
        Prodotto prod1 = new Prodotto("b753fc62-2fc3-40d0-8268-79ab06c28f24"," Mela Rossa", "Mela croccante e succosa", LocalDateTime.now().minusDays(10), LocalDateTime.now().plusDays(20), produ1);
        Prodotto prod2 = new Prodotto("37df3757-5aab-47f7-92eb-789c4ab1e464", "Pera Verde", "Dolce e succosa, ideale per dolci", LocalDateTime.now().minusDays(8), LocalDateTime.now().plusDays(18), produ1);
        Prodotto prod3 = new Prodotto("9dfc609a-f2fe-4b7c-ba1e-4db3f9a0caf2","Pomodoro", "Ideale per sughi e insalate", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(15), produ1);
        Prodotto prod4 = new Prodotto("ccff1230-208c-4143-b889-6f24d212d869", "Carota Bio", "Coltivata senza pesticidi", LocalDateTime.now().minusDays(5), LocalDateTime.now().plusDays(10), produ1);
        Prodotto prod5 = new Prodotto("ca741abd-401b-41f6-8aba-6c2bb9d88369", "Zucchina", "Fresca e leggera", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(12), produ1);
        Prodotto prod6 = new Prodotto("7baf2a4a-8772-4393-beee-a108f3656fa5","Patata Gialla", "Per fritture perfette", LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(30), produ1);
        Prodotto prod7 = new Prodotto("41428ac7-e39d-465a-8e92-660f2c438496","Cipolla Rossa", "Intensa e saporita", LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(25), produ1);
        Prodotto prod8 = new Prodotto("636e8ad1-aa38-4b20-a0a2-8ffc53d23894","Lattuga", "Croccante e fresca", LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(5), produ1);
        Prodotto prod9 = new Prodotto("c07684a7-9fc5-4ada-bdf4-8bce1e2385de","Sedano", "Ottimo per soffritti", LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(7), produ1);
        Prodotto prod10 = new Prodotto("3c429f6c-c2a0-4316-95c5-9712e1925c48","Cavolo Nero", "Ricco di fibre", LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(10), produ1);

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
        
        ProdottoInVendita pv1 = new ProdottoInVendita("ad4184cd-f194-4461-9a15-2cfa583909fc",50, 10,"Descrizione", prod1);
        ProdottoInVendita pv2 = new ProdottoInVendita("f8ea8836-4ba6-48a3-8b70-5d988f0ef836",11, 25,"Descrizione", prod2);
        ProdottoInVendita pv3 = new ProdottoInVendita("1e44c1e5-caa3-4ef7-9eef-75750548ee8b",14, 10,"Descrizione", prod3);
        ProdottoInVendita pv4 = new ProdottoInVendita("fbf5ba56-aa1d-414f-87b8-57afb6b027a8",1, 5,"Descrizione", prod4);
        
        repoProdottiInVendita.save(pv1);
        repoProdottiInVendita.save(pv2);
        repoProdottiInVendita.save(pv3);
        repoProdottiInVendita.save(pv4);
        
        
        
     //  creazione della richiesta prodotto 
        UtenteRegistrato creatore = repoUtentiRegistrati.findById(ur1.getId()).orElse(null);
        Prodotto prodotto = repoProdotti.findById(prod1.getId()).orElse(null);

        if (creatore != null && prodotto != null) {
            RichiestaProdottoBuilder builderRProdotto = new RichiestaProdottoBuilder();
            
            builderRProdotto.setCreatore(creatore);
            builderRProdotto.setApprovato(false);
            builderRProdotto.setElemento(prodotto);
            
            repoRichiestaP.save(builderRProdotto.build());
        }
        
     // === CREAZIONE TRASFORMATORI ===
        Trasformatore trasf1 = new Trasformatore("a226ca20-47f3-42cf-a495-168048e02ba1","username", "password" , "email", "nome" , "cognome" ,
        		"telefono", "biografia" , "PIVA123", "Azienda Bio", "0123456789", null);
        Trasformatore trasf2 = new Trasformatore("72ea9ec0-65f7-4ed8-846a-4dd7bb4a2a7c","username", "password" , "email", "nome" , "cognome" ,
        		"telefono", "biografia" ,"PIVA456", "Trasformazioni Verdi", "0987654321", null);
        
        repoTrasformatori.save(trasf1);
        repoTrasformatori.save(trasf2);
        
        
     // === CREAZIONE CERTIFICAZIONI ===
        Certificazione cert1 = new Certificazione(
                "faf9803f-edaf-4c37-8452-49df0e73932d",
                "Certificazione Biologica",
                "Conforme agli standard biologici UE",
                "BioEnte Europa",
                LocalDateTime.now(),
                LocalDateTime.now().plusYears(1)
            );

            Certificazione cert2 = new Certificazione(
                "a913bcb7-9491-438f-8d2e-749c690d483a",
                "Certificazione Sostenibilità",
                "Ridotto impatto ambientale nei processi produttivi",
                "GreenCert Italia",
                LocalDateTime.now(),
                LocalDateTime.now().plusYears(2)
            );

        repoCertificazioni.save(cert1);
        repoCertificazioni.save(cert2);
        
     // === CREAZIONE TRASFORMAZIONI ===
        Trasformazione t1 = new Trasformazione(
        	    "784c4cdd-cbee-49d8-8b16-45a761e7487e", // id (può essere generato altrove)
        	    "Trasformazione Frutta",
        	    "Produzione confetture biologiche",
        	    LocalDateTime.now(),
        	    LocalDateTime.now().plusDays(5),
        	    null, // trasformatore (da impostare se disponibile)
        	    new ArrayList<>() // certificazioni vuote (o popolate se disponibili)
        	);

        	Trasformazione t2 = new Trasformazione(
        	    "27e3b5fc-a56c-40c9-afb4-7b34e94f995e",
        	    "Lavorazione Verdure",
        	    "Conserve di verdure stagionali",
        	    LocalDateTime.now(),
        	    LocalDateTime.now().plusDays(7),
        	    null,
        	    new ArrayList<>()
        	);


        repoTrasformazioni.save(t1);
        repoTrasformazioni.save(t2);
        

        
        */
		logger.info("LOADED FAKE DATA FROM DATABASE");
		
	}
	
}
