
##### Hosts og rounters
- Må ha ett nettverkskort for å koble hosts til routers for å kommunisere
- Ettt nettverk interface representerer koblingen mellom en host/router og kommunikasjonslink via en port
- Nettverk layer addresse (IP adresse) er assosiert med (identifies) nettverk interfaces og nettverk
- Kan kjøre ifconfig for å se interface
	- inet er ip adresse
	- lo0 er loopback interface virtuelt
	- en0 er trådløst interface fysisk
	- Ether adressen er adressen til link nivå, netverkskortet
- Ping og traceroute
	- ping example.com viser tiden for request-reply pattern
	- traceroute example.com viser alle interfaces datagrammet går gjennon på ruten fra host


<hr>


##### Forwarding - data place
- Ruter sender data videre
- Forwarding steps
	1. Får datagram på en rouuter input port
	2. Bestemmer riktig outgoing port (next-hop) basert på datagram destinasjons adressen og den lokale forwarding table 
	3. Send datagram til rikitg outgoing link


##### Routing - control plane
- Bestemmer innholdet til local forwarding table
- to hoved approaches
	- Routing algorithm: komponenter implementert på hver router som deler routing informasjon mellom peer routers
	- Software-defined networking: hvor en remote routing controller interacts med local routing controll agents


<hr>


# Routers


![[Pasted image 20230329095109.png]]

![[Pasted image 20230329095308.png]]

![[Pasted image 20230329095402.png]]

![[Pasted image 20230329095443.png]]

# Mer effectivt ->
![[Pasted image 20230329095858.png]]

![[Pasted image 20230329095940.png]]


<hr>


## IPv4

##### Adresser - IPv4
- Adressering baseres på 32-bit internett (IP) adresse
- Bruker dotted decimal notation
- 11001000 00010111 00010000 00000000
	- 128+64+8  .  16+4+2+1  .  16  .  0
	- 200.23.16.0
- Rollen tl Ip adresser
	- Identifisere ett netverk interface på en host/router
	- Hvert nettverk interface på en host/router må ha en IP adresse
	- Hosts kan ha - og routers typisk har - flere nettverk interfaces og flere IP adresser


##### Adresser og route aggrigation
- Destinasjons adresser i forwarding table må aggregeres for at routingen skal skalere
![[Pasted image 20230330101750.png]]


##### IP forwarding
- Entiteter i ett forwarding (routing table) er typisk basert på ett intervall av 32-bit IP addresse
- Når vi skal sjekke opp adresser til hvilket link interface pakkene skal til burker vi adressse prefix matching
![[Pasted image 20230330102144.png]]


##### Nettverk interface og subnets
- Route aggregation using prefixes requires a hierarchical structure on the configuration of network addresses
- Nettverk interfaces som er koblet til samme nettverk (subnet) deler den samme nettverk adresse prefiksen (nettverk adresse)
- 223.1.1.0/24
	- de første er adressen til nettverket
	- /24 sier hvor mange avd e første bit i IP adressen som utgir adressen
	- kalles CIDR notation


<hr>


## DHCP: The Dynamic Host Configuration Protocol

##### IP adresse configuration
- Nettverk interfaces på hosts og routers må konfigureres
	- statisk eller manuelt (not practical)
- Typisk informasjon som trenger å configureres på host
	- IP adressen til nettverk interface
	- IP adresse til router som kan brukes til å forwarde datagram på utsiden av (sub)nettverk til hosten
	- Nettverk mask som spesifiserer hvilken del av IP adressen som er (sub)nettverk
	- IP adressen til ett domene name system server (DNS Server) trengs for hostnames into IP adresser for å brukes som destinasjons adresser for datagram


##### Dynamic Host Configuration Protocol
- Client-server protocol based on UDP for automatically assigning IP addressen to host
- DHCP server vedlikeholder ett pool med tilgjengelige IP adresser som kan gis til klienter
- DHCP kan også brukes til å gi nettverk konfigurering informasjon


<hr>


## IPv6: Next generation Internet Protocol 

![[Pasted image 20230411193542.png]]

![[Pasted image 20230411193624.png]]
#### IPv6 address space 128-bit (ekstremt mye)

##### Overgangen
- vil ta noe tid ettersom vi ikke kan skru av internett og bytte IPv4 med IPv6
- Vi må fortsette å utnytte IPv4, og gradvis bytte ut
- Må oppdatere
	- IP adresse representasjon fra 32-bit til 128-bit
	- IPv6 datagram prosessering i brannmurer på transport nivå
	- IPv6 routing på nettverk nivå
	- IPv6 datagram enkapsulering på fysisk nivå


![[Pasted image 20230411194316.png]]


![[Pasted image 20230411194508.png]]


![[Pasted image 20230411194651.png]]


