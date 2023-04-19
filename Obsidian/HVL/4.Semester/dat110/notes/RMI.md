
##### RMI (Remote Method Invocation)
- Er en Java API som er en mer oppdatert og moderne versjon av RPC
- RMI fungerer ved å bruke to objekter, stub og skeleton
- Det blir opprettet ett Register til en port og her vil metodene til serveren bundet til, klienten kan så prøve å finne registeret ved å ha porten som registeret er bundet til og dette vil da klienten kunne bruke til å kalle på metoder som ligger hos serveren
- Her brukes ofte ett callback objekt også slik at server kan jobbe og fristille klienten enn så lenge