<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../css/main.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <title>Lever</title>
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

    <!-- Profil content -->
    <div class="profile_container">
        <h1>Lever</h1>

        <form action="deliver" method="post">
            <input class="input_params" type="text" placeholder="kilometer kjørt" name="km_end">
            <input class="profile_btn" value="Lever" type="submit"/>
        </form>
    </div>
</body>  
</html>