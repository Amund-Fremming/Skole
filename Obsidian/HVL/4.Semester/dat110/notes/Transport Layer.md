
##### Transport services
- TCP: Transport Control Protocol 
	- Connection-orientert: TIlkobling mellom applikasjons prosesser lages før data skal sendes over
	- Reliable service: Streamen bytres som sendes vil være lik streamen bytes som blir motattt
	- Flow Control: Sender kan justere raten som mottaker mottar segmenter



<hr>


#####  Sockets og porter
- Sockets (TCP/UDP) Representerer transport service aksess endepungter gjennom en prosess som kan sende og motta data
- Socket identifikasjon
	- IP adresse (32/128-bit)
	- Port nummer (16-bit) for å identifisere prosessen
- Port nummer bruk
	- [0-1023] assosiueres med kjente services
	- [1024-65535] tilgjengelig for generelt bruk


<hr>


##### Koblingsløs Transport - User Datagram Protocol (UDP)
![[Pasted image 20230221092738.png | 300]]
-  Connection-less: Trenger ikke å få en tilkobling mellom apllikasjons prosesser
	- Unreliable servcie: segmenter kan mistes, dupliseres eller motas i feil rekkefølge, men integriteten av segmenter er garantert
- Source port number: for å gi mulighet for request og reply kommunikasjon
- Destination port number: for multipleksing/demultipleksing
	- Multipleksing: Samler flere informasjonskanaler/strømmer til en felles strøm for sending
	- Demultipleksing: gjør den ene felles strømmen tilbake til flere informasjonskanaler/strømmer
	- Pakker inn port numre fra og til prosessen i Ip adressen fra og til, og så pakkes ut til bare port nummer fra t og til
- Length: spesifiserer totalt number av bytes (Header + payload) av segmentet
- Checksum: beskytte mot korrupsjon av pakken - tilfelle noen av bytes blit borte så kan man sjekke dette med check sum
	- Baseres på 1s complement av summen av alle 16-bit words i segmentet
	- eks - tre 16-bits ord
		- 0110 0110 0110 000 (source port)
		- 0101 0101 0101 0101 (destinasjons port)
		- 0000 1111 0000 1110 (length)
		- sender siden regner summen av alle tre 16-bits ord og finner 1er komplement
		- 1100 1010 1100 0001 -> 0011 0101 0011 1110
		- Mottaker side regner summen av alle fire 16-bits ord og summen må være lik 1111 1111 1111 1111


<hr>


##### Protocol logikk og endelige tilstandsmaskiner
- Den abstrakte operasjonen av protocol entiteter spesifiseres med endelige tilstandsmaskiner
	- Sirkler som representerer de mulige tilstandene til protocollen
	- Piler representerer endringer av state etter ting som skjer
	- Pil labels spesifiserer hvilken handling som gjøres i en repsons til ett eksternt event


##### Implementere protocolen til tilstandsmaskiner
- Protokoll entiteter er objekter av en klasse som implementerer stopable thread abstraksjonen
	- States: er representert ved å bruke enumeration type og en attributt
	- Events: er representert ved enumeration type
	- Events mottas via en event queue
	- Actions er methoder til klassen som kjøres
	- Run-lop av en stopable-thread bytter state basert på den nåværende staten og sjekker event queue for nye eventer som skal prosesseres

![[Pasted image 20230222085151.png | 500]]


<hr>


##### Protocol Design
- i RDT2 har vi checksum som sjekker om det har skjedd bit error i segmentet. NAK sendes om det er error i dataen, ACK hvis ikke
	- kan fortsatt bli feil i ACK/NAK segmentene som kan løses ved å bruke ett sekvensnummer, 1-bit (0/1)
	- Sender sender data med nummer 0 helt til den får en ACK med likt nummer kommer tilbake, da vil neste segment bli sendt med 1 som sekvensnummer
	- mottaker motar bare data om sekvensnummeret matcher nummeret som er forventet
	- Mottaker endrer sin neste forventa sekvensnummer til motsatt etter å ha sendt ACK
- RDT3 loss of data and ackowledge segements
	- Timeout og retransmisjon av data segmenter og sekvensnummer i data og ack segementer
	- Timeout og retransmisjon av data skjer om det tar for lang til før man mottar ack
	- sekevensnummer brukes til å detektere retransmitted data segmenter
- RDT4 håndtere overataking av segmenter på nettverket
	- sender sender den samme data segmentene med den samme sekvensnummeret til ett matchende ack mottas
	- sender inkrementerer sekvensnummeret med 1 når han mottar ack for data segmentet
	- mottaker holder ett forventa sekvensnummer, og inkrementerer nummeret med en når han mottar datra segment med riktig sekvensnummer
	- mottaker sender ack med sekvensnuymmeret den forventer


<hr>


##### Mer effektivt
- Stop-and-wait protokoller
	- ett data segment / ack blir sendt om gangen
- Pipelined protokoller
	- flere data segmenter og ack sendes samtidig, bruker en buffer på segmentene
- Go-Back-N (GBN) protocol
	- sender har ett vindu på strl N som har segmenter som skal/sendes under transmisjon
	- Når ett ack mottas, oppdateres vinduet så det er plass til ett nytt segment (sliding window)
	- en timer brukes for å triggere retransmit av all data segmenter i vinduet
	- mottaker sender ack når all data har kommet fram


<hr>


##### Selective Repeat (SR) protocol
- GBN sletter all data om det er noe som ikke kom fram i intervallet, dette er unødvendig om bare en pakke blir borte
- mottaker buffrer motatt segmenter og acknowledger alle inviduelt
- Sender retransmiterer hvert data segment basert på individuell timers, ikke en eksakt tid for hele vinduet


<hr>


##### TCP Protocol - elements
- Hovedelementer i TCP Protocol
	- Connection gjøres gjennom en three-way-handshake
	- Reliable data transfer basert på sliding window techniques
	- tilkobling shutdown begge veier
- Flow control
	- Målet er å unngå at sender overfyller mottaker med data
	- sender justerer segmenter som blir sendt basert på receiver feedback
- Congestion control
	- Målet er å unngå å bidra til netverk congestion
	- Sender justerer segment rate basert på perceived congestion


<hr>


##### UDP vs. TCP
- Application-level control of transmisson
	- UDP passerer data til nettverksnivå direkte
	- TCP flow- og congestion control kan senke ned data
	- Gjør UDP bedre for visse real-time applikasjoner
- Connection establishment delay
	- UDP kan starte transmisjon av data direkte
	- TCP må ha en three-way-handshake
	- Gjør UDP bedre for request-reply protokoller som har små mengder data (DNS, sensor data ..)
- Connection state and small overhead
	- TCP segmenter (20-byte header) UDP (8-byte header)





