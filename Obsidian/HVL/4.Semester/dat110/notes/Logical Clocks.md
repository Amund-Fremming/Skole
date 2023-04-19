
##### Problem
- Hvis flere systemer skal ha tilgang til kritisk område kan det oppstå feil der flere prosesser endrer verdier samtidig, eks bank
- I ett distribuert system har vi ikke noe globalt konsept av tid
- Fysiske klokker er forskjellige på forskjellige systemer


<hr>


##### Fysiske klokker
- UTC, Universal Coordinated Time er basis for global tid
- Vi kan synkronisere klokkene på to måter
	- Anta at en maskin har UTC, så vi synkroniserer alle maskiner til denne => ekstern synkronisering
	- Hvis ingen har UTC, så prøver vi å holde maskinene så nære som mulig => intern synkronisering


<hr>


##### Logiske klokker - Lampars klokke
- Bruker eventer som en slabgs klokke og ikke absolutt tid
- hvis vi har tre prosesser vil første event i prosess 1 inkrementere klokken til en, det andre eventet vil inkrementere til to, når tredje event i prosess to skal utføres må det sendes en melding og klokken må inkrementeres, men her må vi ta den maksimale klokken siden klokker må gå framover


<hr>


##### Vector klokke
- I en vektorklokke har hver prosess en vektor med tellere/counters hvor hver teller mappes til en prosess. Når en prosess lager ett event inkrementeres telleren til prosessen
- Når en prosess får en melding fra en annen prosess oppdaterer den vektorklokken sin ved å ta maks verdi av counter i mottakende vektorklokke og sin egen klokke
- Her er ett eksempel
	- Vi har ett system med tre prosesser A, B og C, hver prosess har egen counter i vektorklokken
	- Prosess A lager ett event og inkrementerer sin counter, klokken er [1, 0, 0]
	- Prosess B lager ett event og inkrementerer sin counter, klokken er [0, 1, 0]
	- Prosess A sender en melding til prosess B med sin vektorklokke [1, 0, 0]
		- Prosess B mottar meldingen og oppdatere sin klokke ved å ta maks verdi av hver counter i mottakende klokke og sin klokke. klokken er [1, 1, 0]
	- Prosess C lager ett event og inkrementerer sin counter, klokken er [0, 0, 1]
	- Prosess B sender en melding til prosess C med sin vektorklokke [1, 1, 0]
		- Prosess C mottar meldingen og oppdaterer sin klokke ved å ta maks verdi av hver counter i mottakende klokke og sin klokke. klokken er [1, 1, 1]
- I praksis er det eneste som skjer at når man får en melding så oppdatere man egen klokke ved å se på mottakers klokke, er det to verdier, tar man største, er de like, tar man verdien til prosessen som kom først. Klokken kan aldri bli mindre, klokka går framover
- Bulletin Board System
	- Hvis prosess 3 får melding av prosess to, der den første prosessen har blitt inkrementert, og prosess tre ikke har fått noe melding, så vil prosess 3 vente til den får meldingen fra prosess en før den gjøre noe