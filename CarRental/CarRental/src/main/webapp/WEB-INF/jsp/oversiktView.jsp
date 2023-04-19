<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="../css/main.css">
    <title>Oversikt</title>
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
    
    <div class="container-about">
    <h1>Oversikt over aktive leieforhold</h1>
    
    <table>
    	<c:forEach var="active" items="${aktive}"> 
   
    		<tr>
    		<td>Mobil: ${active.mobile.mobile}  Registeringsnummer: ${active.regnr.regnr}</td>
    		</tr>
    		
  
    	</c:forEach>
    
    </table>
    </div>
</body>
</html>