<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/main.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<title>Logg inn</title>
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar">
		<ul>
			<li class="nav-li-left"><a href="/profile">Profil</a></li>
			<li class="nav-li-left"><a href="/aboutus">Om oss</a></li>
		</ul>
		<ul>
			<li class="nav-li-right"><a href="/home">Hjem</a></li>
		</ul>
	</nav>

	<!-- Login content -->
	<div class="login_container">
		<form class="login_form" action="/login" method="post">
			<h1 class="login_h1">Logg inn</h1>

			<p style="color: red">${redirectMessage}</p>

			<input class="input_params" type="text" placeholder="Brukernavn"
				name="mobile"> <input class="input_params" type="password"
				placeholder="Passord" name="password"> <input
				class="login_btn" type="submit" value="Logg inn" />

			<p class="forgot">
				<a href="#">Glemt passord?</a>
			</p>
			<p class="forgot">
				<a href="/register">Har du ikke bruker? Registrer deg her!</a>
			</p>
		</form>
	</div>

</body>

</html>