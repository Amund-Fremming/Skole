<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../css/profile.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <title>Profil</title>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <ul>
            <li class="nav-li-left"><a href="/login">Profil</a></li>
            <li class="nav-li-left"><a href="/aboutus">Om oss</a></li>
        </ul>
        <ul>
            <li class="nav-li-right"><a href="/home">Hjem</a></li>
        </ul>
    </nav>

    <!-- Profil content -->
    
    <div class="profile_container">
        <h1>Profil</h1>
    	<p style="color: red; margin-top: 0; margin-bottom: 0;">${innlogget}</p>
        <p><a href="/login" class="profile_btn">Logg inn</a></p>
        <p><a href="/logout" class="profile_btn">Logg ut</a></p>
        <p><a href="/deliver" class="profile_btn">Lever</a></p>
        <p><a href="/history" class="profile_btn">Historikk</a></p>
    </div>
       
</body>  

</html>