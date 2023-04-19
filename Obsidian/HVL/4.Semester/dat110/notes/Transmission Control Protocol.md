
##### TCP Protocol - elementer
- Hoved elementer i TCP protocol
	- Tilkobling ved å bruke en three-way handshake
	- Reliable data transfer baser på sliding window techniques
	- tilkobling stenges begge veier
- Flow control
	- Målet er å unngå at sender overflower mottaker med data
	- sender justerer segment rate basert på mottakers feedback
- Congenstion control
	- Målet er å unngå nettverks congestion
	- sender justerer segment rate basert på perceived congestion
- TCP segments
![[Pasted image 20230223211017.png]]

![[Pasted image 20230223211415.png]]

- Når en fil skal sendes vil den desles opp i byte segmenter
- sequence nummer:
	- sier hvilken byte som er den første i segmentet
- acknowledge number:
	- byte stream nummeret som mottaker forventer å være neste