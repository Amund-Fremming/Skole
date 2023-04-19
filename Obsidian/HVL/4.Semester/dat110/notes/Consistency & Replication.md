
## Reasons for replication

##### 1. Improve performance
- Skalere i form av størrelse (Større trafikk)
- Skalere på geografisk omåde (Over større område)

##### 2. Replication for high-availability
- Availability kan økes ved å lagre data på replicated steder (Isteden for å lagre en kopi av data på en server)

##### 3. Replication for enhancing scalability
- Dele data på flere servere hjelper ved å unngå bottle-necks på main server

##### 4. Replication for fault-tolerance
- Øker påliteligheten til ett system
	- Feil tolerang: hvis en replica krasjer, kan vi bytte til en annen replika
- Teknikken kan brukes til å gi en fault tolerant mot servere med faulty servere
	- Eks i p2p system, peers kan kordingere for å unngå at faulty data blir levert


<hr>


##### The price of replication
- Consistency krever at
- Kopier alltid er like
- Read operasjoner i alle replicas er alltid de samme
- Update på en replica er alltid propagated til alle kopier før en subswquent operasjon skjer
- Atomiske operasjoner over store systemer er vanskelig
	- Vi må sybkronisere alle replicas hele tiden
	- Tar lang tid å kommunisere når replicas er spredd over store nettverk
- Pros: vi kan fikse skalerings problemer ved å bruke replication og caching => imporved performance
- cons: Men, å holde alle kopier consistent så trenger vi global synkronisering som kan koste mye i form av performance
- løsning: relac consistency constraints
	- Kan være at noen kopier ikke er de samme hele tiden
- Hvor relaxed constrains er spørs på
	- Aksess og oppdaterings patterns av det replicated data
	- formålet med dataen


##### Acess/Update patterns av replicated data
- Hovedproblem
	- For å holde replicas consistent, så trenger vi å sikre at alle konflikt operasjoner gjøres i samme rekkefølge over alt
- Conflict operations: From the world of transactions
	- read-write conflict: En lese operasjon og en skrive operasjon skjer likt
	- write-write conflict: to write operasjoner skjer likt


<hr>


##### Consistency model
- En consistency model er en kontrakt mellom
	- prosessen som vil bruke data og
	- den replicated data repository (or data-store)


##### Types of Consistency models
- Consistency models kan deles inn i to kategorier
- Data-centric
	- Disse modellene definerer hvordan data oppdateringer er delt over replicas for å holde dem consistent
- Client-centric
	- Denne mdoellen antar at klienter kobles til forskjellige replicas hver gang
	- modellen sikrer at når en klient klobles til ett replica, replicaet oppdateres til date med replica som klienten var i sist 


##### Consistency specification models
- In replicated data-stores, trenger vi en maksnisme som kan
	- måle hvor inkonsistent data er på forskejllgie replicas
	- hvordan replicas og appllikasjoner kan måle tolerable inconsistency modeller
- Consistency Spescification models gjør det mulig å måle og spesifisere level av inkonsistency i en replicated data-store
- One consistency Specification Model er: Continious Consistenct model


##### Continious Consistency
- Level av consistency er definert over tre uavhengige axes:
	- Numeric deviation: Deviation i de numeriske verdiene mellom replicas
	- Order deviation: Devation med repsekt til rekkefølgen av oppdaterings operasjoner
	- Stateless Deviation: deviation i stateness between replicas


##### Consistency unit (CONIT)
- Numerical deviation
	- For a given replica R, how many updates at other replicas are not yet seen at R? What is the effect of the non-propagated updates on local Conit values?
- Order deviation
	- For a given replica R, how many local updates are yet to be committed?
- Staleness Deviaton
	- For a given replica R, how long has it been since updates were propagated?


##### Examples of conit and consistency measures
- Order deviation:
	- replica R er antall operasjoner i R som ikke har blitt commited i R
- Numerical deviation:
	- replica R er antall av operasjoner på andre replicaer som ikke er sett av R, med en sum av korresponderende missed values


<hr>


##### Sequention consistency model
- Sequential consistency model enforces at alle update operasjoner er kjørt på replicaene i en sekvensiell rekkefølge. Operasjoner ti lhver prosess kommer i rekkefølgen de som er spesifisert av programmet
- ![[Pasted image 20230324132821.png]]


<hr>


##### Casual consistency, recall: logical clocks
- Lamport cloks: C(a) < C(z) Conclusion None
- Vector clocks: V(a) < V(z) Conclusion: a -> ... -> z
- Distributed bulletin board application
	- Hver post blir sendt til alle andre brukere
	- Consistency goal: Ingen bruker kan se reply før den korresponderende orginale meldings post
	- Conclusion: Lever melding bare etter alle meldinger som er casually precede it har blitt levert


##### Casual consistency
1. Writes som er potentially casually related må bli sett av alle maskiner i lik rekkefølge
2. Concurrent writes kan ende med å bli sett i forskjellige rekkefølge på forskjellige maskiner
3. ![[Pasted image 20230324133449.png]]
- implications of adopting a casually consistent data-store for applications:
	- Processes må holde kontroll om hvilke prosesser som har sett ulike writes
	- dette krever mye vedlikehold


<hr>


##### Summary
- Replication is secessary for improving performance, scalability, availability and for providing fault tolerance
- Replicated data-stores should be designed after carefully evaluating the trade-off between tolerable data inconsistency and efficiency
- Consistency Models describe the contract between the data-store and process about what form of consistency to expert from the system
- Data-centric consistency models:
	- Continuous Consistency Models provide mechanisms to measure and specify inconsistencie
	- Consistency Models can be defined based on the type of ordering of operations that the replica guarantees the applications
		- Sequential Consistency Model and Causal consistency
