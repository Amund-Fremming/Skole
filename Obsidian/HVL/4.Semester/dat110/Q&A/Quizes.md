
### Quiz week 6
1. Meldings brokers kan gi følgende:
	- Håndtere applikasjoners heterogenity i en melings kø system
	- Can route meldinger til konsumer som har subscribed til ett topic
2. En prosess som pushed ut en melding og ikke bryr seg om hvem som mottar meldingene, men antar at det er andre prosesser som vil pulle meldingene, kan implementere
	- pipelining pattern
3. Meldings-orientert middleware tillater kommunikasjon mellom sender og mottaker til å være løst knyttet i tid
	- sant
4. KOmmunikasjons prosesser kan kobles til overlay network, hvilke av følgene er sanne? 
	- Prosesser kan bruke oiverlay netwerk til å route meldinger til andre prosesser i overlay
	- Overlay network kan gå over flere fysiske netverk
5. Ett overliggende nettverk som har en stretch av 2.0 between mellom to conneced nodes betyr
	- Overlay network has a delay cost to route message between the two nodes that is twice the delay cost of the underlying network
6. I flooding based multikasting, hvilke statements er sanne?
	- Meldinger vil bli routa gjennom hver tilkoblet node i nettverket
	- The number of messages routed always depend on the number of edges(path) in the overlay network

https://hvl.instructure.com/courses/21903/quizzes/13494 


<hr>


### Quiz week 7
1. Ett distribuert hash table kan gi følgende?
	- Tilgjengelighet
	- Skalerbarhet
	- Feil-tolerang
2. En challenge med home based approach
	- Geografisk skalerbarhet
3. Skalerbarhet feil som adresseres i DNS system er...
	- Replicating hiugher level DNS servere
4. Navn kan løses iterativt og rekursivt når det gjelder DNS. Hvilken av påstandene er korrekt?
	- I rekursiv løsning, vil kommunikasjons distangse ikke være noe problem, men høyere nivå servere kan få for mye load/trafikk
5. Ett name space inneholder...
	- Alle gyldige navn som gjennkjennes og styres av en service
6. Du skal lage ett system der vi skal designe lookupo for ett chord system som kan skalere, hvilken algoritme burde brukes?
	- En løsning der hver node bruker routing table som inneholder referanser til noen få eksponentielle noder
7. DNS brukes til å mappe hostname til IP adresse, hva er riktig? 
	- En authorativ name server er server som lagrer og gir IP adressen til hostname tiul den lokale DNS server
8. Ett distribuert hash table bruker 8bits til å definere adresse space, hvilken størrelse er adressen?
	- 2^8 = 256
9. Ett eksempel på location independent name er...
	- Domene 
10. En DHT chord ring har 3 aktive peers; P1, P2 og P3. P1 har adresse 20, P2 har adresse 10 og P3 har adresse 30. Hvilken av peers er ansvarlig for filene med følgende identifiers: 5, 12, 31 og 1
	- P1 holder 12, P2 holder 1, 5, 31


<hr>


### Quiz week 8
1. At Transport nivå gir en reliable data transfer service betyr at ...
	- Dataen som sendes er lik dataen som mottas, vise versa
2. Å gi data som er pakket inn i ett transport segment til riktig socket kalles ...
	- demultiplexing
3. Er det mulig for to prosesser som kjører på forskjellige hosts å sende UDP segmenter til den samme porten på en host
	- Ja
4. Hva slags pakker sendes mellom protocol entiteter på transport nivå?
	- Segmenter
5. Anta at en host mottaer ett UDP segment og finner ut at checksum er riktig, hva vet mottaker?
	- At segmentet som ble sendt er likt som segmentet motatt med høy sannsynelighet
6. Du blir gitt følgende 8-bit bytes: 01010011, 01100110, 00110100. Hva er komplementet av summen?
	- 00010010
7. Anta at vi har ett nettverk som kan ha duplikate datagrammer, men det er ingen transmisjonsfeil, loss eller overtaking. Hvilken protokoll mekanisme ville du brukt for å sikre reliable data transfer?
	- Sequence numbers
8. Er det mulig å håndtere transmission error på ACK/NAK segmenter i RDT 2.0 protokollen ved å retransmittere data segmentet i tilfellet der en korrupt ACK eller NAK er motatt av sender?
	- Nei
9. Er det mulig å unngå å bruke NAK-segmenter i RDT 2.1 protokollen ved å bruke sequence numbers i acknowledgement - og fortsatt vedlikeholde riktig protokoll
	- Ja
10. Hvis sender transport protokoll entitet i RDT 2.0 mottar en korrup ACK/NAK segment. - hva trenger sender å vite?
	- Noen segmenter ble motatt
11. Hvordan er TCP socket / connection identifisert?
	- Av ett tuppel bestående av source port, source IP adresse, destination port, og destination IP adresse
12. For hvilken av følgende transport protokoller er acknowledgements cumulative?
	- Selective-repeat
13. Hva er meningen med flow control?
	- Sikre reliable transmisjon for transport av segmenter
14. Tap av transport segmenter er allid en indikasjon på nettverk congestion?
	- Ja
15. Hva forholds kravene mellom sekvensnummer range og window size i selected report protokollen?
	- Sequence number range må være dobbelt av window size


<hr>


### Quiz week 10


<hr>


### Quiz week 11
1. Noen grunner til replication er
	 - Improve performance
	 - Increase reliability
	 - Improve availability
2. Faktorene som må beregnes når vi bruker relax consistency er
	- Typen kommunikasjonsprotokoller tilgjengelig for å gjøre oppdatering
	- Read og write patterns av den replicated data
	- Antall av replica servers tilgjengelig for replicated data item
	- Formålet til hva dataen brukes til
3. Continious consistency model can provide
	- En måte å måle og spesifisere levelen av inkonsistens som en applikasjon kan tolerere
4. Monotonic-read consistency model guarantees that
	- Når en prosess har sett verdien av x, vil den aldri se en eldre versjon av x
5. A client-centric consistency model where a client process can modify a password on a server replica and the password change is seen immediately by the same client on a different replica server can be said to implement
	- Read your writes model
6. In remote-write protocols
	- Every data item has a primary server assigned to it
7. The main challenge with active replication is that:
	- Events has to be orderes across all replicas
8. A replicated-write protocol which is based on majority voting is called:
	- Quorum-based protocol
9. One way to enforce cache coherence when shared data is cached locally is to let the server send an invalidation to all cahces when a data item is modified
	- true
10. In replicated-write protocols:
	- Write operations can be performed in multiple replicas
11. Client-centric consistency
	- Providing consistency for a single client that accesses different replicas
12. In primary based protocols
	- Updates can be performed in only one replica


<hr>


### Quiz week 12
1. 
