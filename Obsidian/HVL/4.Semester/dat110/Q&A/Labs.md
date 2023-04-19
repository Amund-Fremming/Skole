
### Week 9
- Hvordan brukes porter i UDP segmenter for å supporte multi-plexing og request-delay kommunikasjons mønster?
	- Multipleksing er da at man pakker inn segmenter og sender flere datastreams over en enkel kommunikasjons kanal
	- i UDP gjøres dette med porter, source port og destination port, der sender sender ett segment med begge deler og får de samme tilbake igjen som reply
- Hvilke TCP segmenter brukes for å åpne TCP tilkoblingen, hvordan brukes sekvensnumrene under data overføring, og hvilke segmenter brukes til å lukke tilkoblingen?
	- Segmenter
		1. SYN (Synchronize) brukes til å initialisere en TCP tilkobling mellom to endepunkter. Sender sender SYN flag settes til 1
		2. SYN-ACK segmentet sendes i respons til SYN segmentet. Mottaker setter SYN flag til 1, og ACK flag til 1 for å acknowledge mottak av SYN regmentet. 
		3. ACK segmentet sendes i respons til SYN-ACK segmentet. Sender setter ACK flag til 1 for å godkjenne responsen av SYN-ACK segmentet
	- Sekvensnummer under dataoverføring
		- Etter tilkoblingen er satt opp, kan data overføres ved bruk av TCP segmenter. Hvert segment har ett sekvensnummer og ack nummer.
		- segmentnummer brukes til å identifisere posjosjonen av datastrømmen av bytes fra motsatt endepunkt
		- ack nummer brukes til å godkjenne svar fra det andre endepunktet
		- Når data overføres vil segmentnummeret inkrementeres av nummer bytes etter hvert sendt segment
		- Ack nummer settes til neste forventa segment, når mottaker TCP segment, sender han ack segment tilbake med ack nummer som tilsvarer neste forventa segment
	- Lukke en tilkobling
		1. FIN segmentet initialiserer lukkingen av TCP tilkoblingen. Sender setter FIN flag til , som indikerer at han har sluttet å sende data
		2. ACK, mottaker sender ACK segment for å fortelle at han har fått FIN
		3. mottaker sender FIN segment for å slutte sin tilkobling
		4. ACK, sender sender ACK segment fo rå si ifra at han fikk FIN meldingen


- ![[Pasted image 20230228164013.png]]
1.  Forklar kort hvilken service TCP protokollen gir og funksjonen til segment fields: Source port, dest port, Sequence number, Acknowledge number, Receive Window, Internet checksum and data
	- TCP protokollen
		- Gir en pålitelig, sortert og error checked delivery av data mellom apper, som kommuniserer over ett IP nettverk
		- Gir reliable data ved å dele data opp i mindre segmenter, nummererer de, og sender de inviduelt over nettverket, hvert segment blir ack av mottaker, og sender resender de som ikke får tilbake ack
	- Segment fields
		- Source port:
			- identifiserer port nummer til sender applikasjonens prosess
		- Destination port:
			- Portnummer som mottakende applikasjons prosess skal ha
		- Sequence number:
			- nummererer hver byte i ett segment, den første bytes til segmentet inkluderes i header
		- Acknowledge number
			- ack nummer har tallet som mottakende ende forventer at segmentnummeret er
		- Receive window
			- Denne spesifiserer nummer av bytes som mottaker er villig til å motta på ett gitt tidspunkt
			- sender må ikke sende mer data enn mottaker kan motta
		- Internet checksum:
			- Er der for å fange opp error i TCP segmentet, skal passe på segmentet som en helhet
		- Data:
			- Den faktiske dataen som skal sendes over internettet, kan være alt fra null til flere tusen bytes

2. Anta at i denne selective repeat protocol at vindu størrelsen er 3 og anta at de tre første data pakkene med sekvens nummer 1, 2 og 3 er transmitert. hvordan vil protokollen reagere i tilfellet der alle tre datapakkene mistes?
	- Siden pakkene ikke kommer fram vil ikke mottaker sende ACK tilbake til sender, så etter ett visst tidsintervall vil sender prøve å sende pakkene igjen og fortsette slik helt til alle pakkene har fått ack tilbake fra mottaker
	- da vil vinduet flyttes og nye segmenter vil bli sendt

3. Hva vil skje om alle tre data pakkene mottas og bare acknowledge for data pakke 3 er motatt? (Acknowledge for datra packet 1 og 2 er lost?)
	- Mottaker vil da få tilbake ACK fra pakke 3, vinduet blir stående og sender vil vente en viss periode på ACK før den retrasnmitterer de pakkene som den ikke fikk tilbake ACK fra
	- Denne prosessen fortsetter helt til sender har fått ACK for alle 3 pakkene, da vil vinduet flytte seg tre hakk til høyre for å starte å sende nye pakker

4. Foreslå ett segment format som kan brukes til å implementere selective Repeat Protocol tilfelle sekvensnummer kan representeres med 4-bits og data payload kan være mellom 0 og 127 (2^7 -1) bytes
```
|-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+|
| Sequence Number (4 bits) | Acknowledgment Number |
|+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|
|         Window Size      |       Checksum        |
|+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|
|                                                  |
|               Data (0-127 bytes)                 |
|                                                  |
|+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|
```

