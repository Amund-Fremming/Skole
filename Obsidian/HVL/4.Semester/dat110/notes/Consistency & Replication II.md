
### Four types of client centric consistency models

##### Monotonic Reads
- Modellen gir og garanterer sikker reads
- Hvis en kloient prosess leser en verdi fra data item x, så vil hver eneste prosess som leser denne verdien x få samme verdi
- Eksempler
	1.  Automatisk lese din personlig kalender oppdatering fra forskjellige servere
		-  Monotonic reads garanterer at alle brukere ser alle oppdateringer, uansett hvilken server den automatiske lesingen skjer
	2. Lese inkommende email mens du er on the move
		- Hver gang du kobles til en ny email server, vil den server fetche alle oppdateringer fra serveren du var på forrige gang


<hr> 


##### Montonic Writes
- En skirve operasjon av en klient prosess på data item x er fullført før en annen write operasjon på x kan gjøres av samme prosess
	- En ny write på en replica burde vente for alle gamle writes på hvilken som helst replica
	- ![[Pasted image 20230324134347.png]]
- Eksempler
	- Oppdatere inviduelle bibliotek i ett stort software source code som er replicated
		- Hvis en oppdatering skjer på biblioteket, så må alle preceding updates på samme bibliotek først oppdateres


<hr>


##### Read your writes
- Effekten av en write operajson på ett data item x av en process vil alltid bli sett av en successive read operasjon på x av den samme processen.
- Eksempel senario
	- I ett system hvor passord lagres i en replicated data-base, passord change må ses umiddelbart
	- Oppdatere web siden og garantere at web browser viser den nyeste versjonen istedenfor en cached copy
	- ![[Pasted image 20230324134916.png]]


<hr>


##### Writes follow reads
- En write operasjon som gjøres av en process på ett data item x 
