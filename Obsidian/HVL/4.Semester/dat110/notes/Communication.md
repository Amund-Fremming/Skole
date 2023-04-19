
##### Applikasjons nivå multicasting
![[Pasted image 20230217131151.png]]
- Overliggende nettverk trenger lav-kostnad-veier for å optimalisere meldingene som skal sendes mellom nodene


<hr>


##### Stretch/relative delay Pentalty (RDP)
- Stretch/RDP:
	- Er en ratio mellom ALM-nivå og nettverks-nivå veien
	- Regnes ut stretch/RDP
- Overlay-nivå: her regner vi gjennom netverks veien, så vi går innom alle rutere og alle veier
- Nettverk nivå: her går vi bare mellom de kobligene/kantenen vi har![[Pasted image 20230217131252.png]]
- Overlay (B til C)
	- B -> Rb -> Ra -> Re -> E -> Re -> Rc -> Rd -> D -> Rc -> C = 73
- Nettverk (B til C)
	- B -> Rb -> Rd -> Rc -> C = 47
- RDP regnet ut er da
	- Stretch/RDP = 73/47 = 1,55


<hr>


##### Tre kostnad
- Når vi ser på ett nettverk kan det deles inn i flere spanning-trees med forskjellige kostnader (delays) for overlay nettverk, meningen er å finne det treet med minst kostnader
- Vi tegner opp nettverket som en graf
![[Pasted image 20230217131430.png]]
- Deretter finner vi spanning tree med minst kostnad
![[Pasted image 20230217131453.png]]


<hr>


##### ALM-Layer-Communication model
- Bruks områder
	- P2P nettverk for å dele content
	- Replicated server oppdateringer
- Topologi
	- Strukturert: tre eller mesh
	- Ustrukturert: random graf
-   Problemer
	- Hvordan finne den delte content effektivt (som er delt mellom peers)
	- Hvor mange meldinger eller spørringer må sendes til peers
	- Vanskelig å scale
	- Hvor mange synkroniseringer trenger man?
- Så hvordan sender vi meldinger til peers?
	- Flooding
	- Epidemic


<hr>


##### Flooding-basert multicasting
- P sender en melding m til hver av sine naboer. Hver nabo vil sende meldingen videre, bortsett fra til P og heller ikke til andre som har sett m før
- Strukturert topologi
	- Modellerer et overlay nettverk som en sammenkoblet graf med N noder og M kanter
	- Hvis G er ett tre, vil vi sende M = N-1 meldinger (Optimalt)
	- Hvis G er fullt sammenkoblet (mesh), sender vi M = 1/2N, eller N-1 worst case
- Hoved problem:
	- Når resursen blir funnet vil meldinger fortsette å blir sendt videre av peers i nettverket (performance blir dårligere)
	- Jo fler kanter vi dyrere er det å multicaste meldinger


<hr>


##### Probabilistic Flooding-Based Multicasting
- Hoved mål: gjør performance bedre ved å redusere antall meldinger
	- P må floode meldinger m til andre noder
	- La P sende m, med en sannsynlighet p_flood til hver nabo
		- Kan ende med ett dramatisk drop i totalt meldinger sendt
- Risiko:
	- Jo lavere p_flood desto høyere sjanse er det for at ikke alle nodene i nettverket vil få meldingen
	- Hvorfor? Det er en sannsynlighet av (1-p_flood)^n  at en node Q med n naboer ikke får meldingen m, fordi alle naboene velger å ikke sende videre m
	- En forbedring er å bruke en nodes egne nummer av naboer for å justere p_flood


<hr>


### Epidemisk protokoll
- Hvorfor?
	- Veldig tilgjengelig, feil tolerant, raskt, skalerbar, spres til alle
- Typer noder
	- Infective - node som holder en oppdatering den kan/vil dele
	- Susceptible - node som ikke har fått oppdatering
	- Removed - node som har fått oppdatering men vil ikke dele lenger
		- S+i+r = 1


<hr>


##### Anti-entropy:
- Hver replika velger en annen replika random, og bytter/deler state differanser, som gjør at begge stater blir identiske
- Hoved operasjoner:
	- En node P velger en annen node Q fra systemet random
	- Pull: P trekker inn oppdateringer fra bare Q
	- Push: P gir oppdateringen sin til bare Q
	- Push-Pull: P og Q sender oppdateringer til hverandre
- Analyse
	- Jo nærmere 0, desto færre er det sannsynlighet for at ikke har fått oppdatering
	- Pull konvergerer til null mye fortere enn push
	- Push-pull konvergerer til null fortere enn pull
	- Push kan være dårlig om mange noder er infisert, da funker pull bedre


<hr>


##### Rumor spreading:
- En replika som akkurat har blitt oppdatert , forteller en mengde andre replikas om oppdateringen sin og får den selv
- Basic modell
	- En server S har en oppdatering å reportere, kontakter alle andre servere. Hvis en server kontakter en annen som allerede har blitt kontaktet så slutter den å dele med sannsynlighet p_stop
- Pros:
	- Mindre meldinger/trafikk enn flooding
	- Kjapt
- Cons
	- Noen steder kan bli unngått og ikke bli oppdatert
- Analyse
	- Er bra til å skalere ettersom det trengs færre synkroniseringger mellom prosesser sammenliknet med andre propagation metoder