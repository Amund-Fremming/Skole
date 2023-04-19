<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="../css/main.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <title>Logg inn</title>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <ul>
            <li class="nav-li-left"><a href="/profil">Profil</a></li>
            <li class="nav-li-left"><a href="/aboutus">Om oss</a></li>
        </ul>
        <ul>
            <li class="nav-li-right"><a href="/home">Hjem</a></li>
        </ul>
    </nav>

    <!-- Login content -->
    <form action="/register" method="post">
	    <div class="register_container">
	    	
	    	<p style="color: red">${redirectMessage}</p>
	    	
	        <h1 class="login_h1">Registrering</h1>
	
	        <input class="register_input_params" type="text" placeholder="Fornavn" name="fname">
	        <input class="register_input_params" type="text" placeholder="Etternavn" name="lname">
	        <input class="register_input_params" type="text" placeholder="Telefonnummer" name="mobile">
	        <input class="register_input_params" type="password" placeholder="Passord" name="password">
	        <input class="register_input_params" type="text" placeholder="Adresse" name="streetadr">
	        <input class="register_input_params" type="text" placeholder="Postnummer" name="postalcode">
	        <input class="register_input_params" type="text" placeholder="Poststed" name="region">
	        
	        <input type="submit" class="register_btn" value="Registrer"/>
	        
	        <p class="login"><a href="/login">Har du bruker? Logg inn her!</a></p>
	    </div>
    </form>
</body>  

</html>