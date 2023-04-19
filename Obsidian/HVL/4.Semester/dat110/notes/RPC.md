
##### RPC (Remote Procedure Call)
- I tradisjonell RPC vil en prosesser blokkerer til operasjonen er fullført før den returnerer det som skal tilbake. Prosessen er synkronisert
- Asynkron RPC fjerner den strenge request reply oppførselen, og lar klienten fortsette uten å måtte vente på ett svar fra serveren
- Fungerer ofte med en callback funksjon som gir tilbake svar til klienten

<hr>

##### Multicast RPC
- Essensen: sende en RPC request til flere RPC server
	- Brukes til å dele opp store prosesser som for eks passord cracking eller finne primtall (RSA)

<hr>

##### MoM (Message-Oriented Middleware)
- Asynkron meldings deling
- Lagrer meldinger i kø systemer
- Sender og mottaker er løst i tid
- Vi har en producer/Sender som er en prosess som sender meldinger
- Vi har en Queue som er en buffer som lagrer meldinger
- Vi har en Consumer/receiver som er en prosess som mottar meldinger

<hr>

##### Persistent MoM
- Asynkron persistent kommuniksasjon gjennom en support av MoM køer
- Applikasjoner kommuniserer ved å putte meldinger i spesifikke køer
- Køer korresponderer til buffere på kommunikasjons servere

<hr>

![[Pasted image 20230217130121.png]]
![[Pasted image 20230217130147.png]]
![[Pasted image 20230217130155.png]]
![[Pasted image 20230217130201.png]]
