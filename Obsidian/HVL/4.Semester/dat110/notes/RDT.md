q
##### Reliable Data transfer (RDT)
- Skal omgjøre en unreliable kanal til en reliable kanal
- Oppnås ved å legge til en protocol som kjører på toppen av den unreliable kanalen for å gi en reliable service
- Design og implementasjons approach
	1. RDT 1.0 protocol opererer over reliable kanaler
	2. RDT 2.0 protocol over kanaler med transmisjons error (bit-errors) og bruker positive og negative sekvens nummere
	3. RDT 3.0 protocol over kanaler med loss og transmissjons errors ved å bruke sekvens nummere, timers, og retransmissjon
	4. RDT 4.0 protocol over kanaler med loss, transmissjons error, duplication og overtaking


##### RDT: Reliable Data Transfer framework
- Kjøres på ett enkelt JVM ved å bruke tråder og ett siumulert nettverk
	- Application layer: Sender prosess og mottaker prosess
	- Transport layer: transport sender og transport mottaker protocol entities implementerer endelige tilstandsmaskiner og protokoll lokgikken
	- Nettwork layer: nettverk service for transport sender og transport mottaker kommuniserer over simulated kommunikasjons kanaler
- Demo av utskrift når vi kjører i java
![[Pasted image 20230222085819.png | 400]]
