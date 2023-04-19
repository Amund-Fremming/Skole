##### RPC funker ikke så bra i praksis
-   Både klient og server må være på for at meldinger skal kunne deles
-   Dette løser for eks MQTT som meldings middleware ved bruk av køer


<hr>


##### MQTT (Message Queue Telemetry Transport)
-   Fungerer som sender/mottaker, eller publisher/subscriber
-   En subscriber vil kunne abonnere på topics som blir lagret i en tre struktur som lokasliserers med /, så skal jeg har temperatur vil det kunne være /vær/temperatur
-   Subscriberen vil da abonnere på en broker som da har topics, og vil være koblingen mellom alle subscribers og publishers
-   En broker vil ofte være en server
-   Vi har også publishers som vil sende inn informasjon til de forksjellige topicsene de er koblet til, når en oppdatering kommer fra en publisher vil alle subscribers bli oppdatert
	- Ofte vil også broker holde siste oppdatering i sin kø slik at om det kommer noen nye abonnenter så slipper de å vente til neste oppdatering for å få data


<hr>


##### MQTT - QOS - Kvalitet service (best til verst)
-   QoS level 2:
	- Exactly-once delivery
	-   Meldingen leveres akkurat en gang og det blir sendt en rekke med ekstra kontroll meldinger
	-   Client får tilbakemelding etter sendt melding fra server, client sier til server igjen at han fikk reply
-   QoS level 1:
	-   At-least-once delivery
	-   Client får PUBACK men sender ikke enda en melding til server