##### Mutual exclusion
- Replicated processes - Shared DB
	- hver prosess er koblet til samme database og vi kan ende opp med å skrive til en variabel samtidig, og feil oppstår
- Replicated processes - Distributed DB
	- Hver prosess har egen DN, ikke noe feil
- Election Algoritme - App eks.
	- For å forhindre dette har vi en kordinator som snakker til alle andre databaser
	- Krasjer kordinator blir det automatisk valg og en ny blir valgt
- Concurrency requires coordination and collaboration amoung distributed processes
	- 2 broad catebories of mutual exclustion alogorithms 
		- Token based:
			- Token sendes rundt blandt prosessene, den som har token får tilgang til DB, og sender videre når den ikke trenger
		- Permission based:
			- en prosess som vil inn i DB må ha lov fra andre prosesser
- Krav til algoritmene
	- Sikkerhet: bare en i kritisk seksjon om gangen
	- Liveness property: null deadlock/starvation, ingen prosesser skal vente evig på meldinger som ikke kommer
	- Fairess: Hver prosess får sjanse til kritisk seksjon


<hr>


##### Performance metrics for Mutual Exclusion algo
- Melding kompleksitet:
	- Antall meldinger som trengs for krisisk seksjon utførelse
- Synkronisering delay:
	- Tiden mellom en prosess går ut av KS og en annen prosess går inn i KS
- Message Transfer Time Unit (MTTU):
	- Delay mellom når en prosess trenger å gå inn i KS, til den faktisk går inn


<hr>


## Mutual Exlusion Algorithms

##### Centralized Algorithm
- Velg en prosess som er kordinator
- Prosesser som vil inn i delte ressurser sender en request til kordinator og spør om lov til å gå inn i KS
- Pros:
	- Garanterer mutual exclusion når bare en kan være i KS om gangen
	- Fair siden requests kjøres i rekkefølgen de kommer inn i køen
	- Enkel å implementere, trenger bare tre meldinger(request, grant, relsease)
- Cons:
	- Krasjer kordinator kan hele systemet gå ned
	- Når kordinator ikke svarer kan den være død, eller nede, men prosessene kan bare tro at de fikk access denied
	- I ett stort system, må den ene kordinatoren styre med utrolig mange prosesser


##### Distributed Algorithm
- Baseres på event sortering og time stamps, hver prosess har logisk klokke
- Prosess k går inn i KS som følger
	- Inkrementerer logiske klokken L_k = L_k + 1 
	- Multicast a message (L_k, k) til alle prosesser => (N-1) msgs
	- Vent til reply/permission mottas fra hver process => (N-1= msgs)
	- Gå inn i KS
- Når prosessen får en request melding, prosess j
	- Sender en OK melding til sender hver denne prosessen er på utsiden av KS => (1) msg
	- Hvis allerede i KS, svarer ikke prosessen, men putter meldingen i køen
	- Hvis denne prosessen vil inn i KS selv, sammenlikner de timestamp - sender OK melding til k hvis(L_k, k) < (L_j, j) hvis ikke puttes k´s request i køen
- Når en prosess er ferdig i KS
	- sender OK melding til alle prosesser i sin kø og sletter dem deretter fra køen => (0-N-1)msgs
- Pros:
	- Mutual Exclusion er garanter uten deadlock/starvation
	- Liniær time complexity
- Cons:
	- Har N points of failure
	- Hver prosess må ha en liste med alle i gruppa
	- Jobber best med små grupper av prosesser der gruppene aldri endres
	- Alle prosesser er med i å bestemme access til KS


##### Token-Ring Algorithm
- organiser systemet som en ring
- Token passeres gjennom ringen
- må vente til man får token før man kan gå inn i KS
- Gi token videre hvis ikke interessert
- Pros:
	- Bare en prosess har token om gangen
	- Mutual exclusion er garantert og ingen starvation 
- Cons:
	- Token loss => krasj
	- Nabo crasjer, må håndteres
	- Hver prosess må ha ring config


##### Decentralized Algorithm
- En resurs kopierers N ganger
- Hver replica har egen kordinator for å kontrollere access til concurrent prosesses
- En prosess trenger flertallet votes av m > N/2 kordinatorer for å gå inn i KS
- Kan skje feil om kordinator resetter
- implementasjon:
	- En ressurs kan replicates N ganger
	- hvis det unike navnet av resursen er rname
		- Then the i-th replica will be named rname_i
		- This is subsequently used to compute a unique name using a known hash function
		- Every process can then generate the N keys if given the resource name
		- Lookup each node responsible for the replica
		- If request is denied (< m votes), process will back off for a randomly-chosen time, and try again
- Pros:
	- Feil tolerang: ingen single point of failure
	- kan skalere:
- Cons:
	- Lav ressurs utilisering når mange noder vil access samme resurs
		- konkuranse mellom nodes å få access ressurs kan lede til ikke nok votes av hver node
			- starvation kan skje


#### Sammenlikninger: Mutual Exclustion
- Centralized:
	- 3 meldinger: REQUEST, GRANT, RELEASE
- Distributed:
	- 3 (N-1) meldinger: REQ=(N-1), OK/GRANT=(N-1), RELEASE=(0 - N-1) queue!
- Token ring:
	- Antall meldinger varierer
		- hvis hver proses vil inn i KS, da har vi 1 entry og 1 exit melding når token passeres
		- Hvis ingen prosess er interesert i CS, tokenmsg vil bli motatt = unbounded num meldinger
- Desentralsiert:
	- REQUEST = m coords, RESPONSE = m msgs, (k = number of msg attempts)
	- RELEASE/EXIT = m msgs (coords) = 2.m.k+m messages


## Election Algorithm

- Kordination elekction problem er å velge en prosess i gruppen som skal være kordinator
- vi har en algoritme for dette
- anta at
	- alle prosesser har en unik id
	- alle prosesser vet id av alle andre prosesser i systemet
	- election betyr å identifisere prosessen med høyest id som er oppe


##### Bully Algoritm
- Biggest guy in down always wins
- Prinsipp
	- Consider N processes {P0 , . . . , PN-1} and let id (Pk) = k.
	- When a process Pk notices that the coordinator is no longer responding to requests, it initiates an election
		- Pk sends an ELECTION message to all processes with higher identifiers: Pk+1,Pk+2,...,PN-1
		- If no one responds, Pk wins the election and becomes coordinator.
		- If one of the higher-ups answers, it takes over and Pk ’s job is done.


##### Ring Algorithm
- Prosess prioritet holdes ved å organisere prosesser i en logisk ring, prosess med høyest prioritet velges til kordinator
	- Alle prosesser kan starte en election ved å sende ELECTION melding til sin successor. Hvis sucessor er nede sendes meldingen til neste sucessor
	- Hvis en melding sendes videre, legger sender til seg selv i listen. Når den kommer tilbake til initiator(som sendte den), har alle fått mulighet til å legge seg selv til
	- Initiator sender en COORDINATOR melding rundt i ringen som inneholder en lsite med alle levende proseser, den med høyest prioritet velges som kordinator

