
#### Chapter 3
- R1: Host aksepterer 1200-bytes, en destinasjons adresse fra transport nivå. Desging en protokoll, modifiser prosessen så den gir en return adresse, i protokollene må transportnivået gjøre noe i netwerking core?
	- vi setter av 4-bytes til adresse og har igjen 1196-bytes til payload
	- Nå må vi legge til en ny adresse som er vår adresse som vi antar er 4-bytes også, og vi har igjen 1192-bytes til payload
	- Transport nivå er bare aktivt mellom applikasjonsnivå og netverk nivå, så gjør ikke noe spess for core
- R2: Vi bor på en planet med 6 familiemmbers, hvert hus har en adresse, hver person har ett navn, og vi har mail support som leverer mail fra hus til hus. Mail må vøre i en konfulutt.
	- Du gir mailen du skal sende til familie medlemmet som skal levere mailen etter du har pakket det inn i konfulutten din, så sendes det med medlemmet som skal levere (Trasport layer)
	- No, the destination is written on the envolope so only the receiver needs to open the letter
- R3: TCP mellom Host A og B. TCP segmentet fra A til B har source port x og destinasjonsport y, hva er source og destination for Host B?
	- source port: y, destination port: x
- R4: Hvorfor vil noen velge UDP ovenfor TCP?
	- TCP har innebygget congestion control som gjør den sikker så vi ikke mister frames eller pakker, og passer på å ikke sende for mye data om gangen til mottaker
	- UDP er da raskere men mindre pålitelig, så en applikasjon som er real time med hyppige oppdateringer som en sensor vil da kunne ha mye nytte av UDP, mens derimot en vanndam som skal åpnes og lukkes aldri kunne hatt UDP
- R6: Er det mulig for en applikasjon å ha Reliable Data Trasnfer uten TCP?
	- Det er mulig, vi kan implementere metoder for å håndtere dette i Applikasjonsnivået, men dette kan kreve mye tid og debugging
- R9: i RDT protokollen hvorfor introduserte vi sekvensnummre?
	- Dette er en sikkerhetsmekanisme som vil gjøre at vi kan sjekke at vi har fått riktig datapakke til riktig tid, og i riktig rekkefølge og at vi ikke sender pakker flere ganger (duplikater)
- P5: Mottaker får en UDP segment, regner ut Internet checksum, og ser at dette stemmer over ens med summen av pakken, er det helt sikkert at vi har fått rett pakke?
	- Nei, det er fortsatt mulig at det er bit errors, to data set kan ha samme checksum


