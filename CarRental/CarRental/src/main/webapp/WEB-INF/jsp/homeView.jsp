
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>the Incubator</title>
    <link rel="stylesheet" href="../css/main.css"/>
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

    <div class="home">
        <h1>
            Rent a car
        </h1>
        <div class="search">
            <form method="POST" class="searchForm" action="/home">
                <select name="rentalOffice" id="city">
                    <c:forEach var="rentalOffice" items="${officeList}">
                    	<option value="${rentalOffice.name}"><c:out value="${rentalOffice.name}"/></option>
                    </c:forEach>                    
                </select>
                <label>From</label>
                <input name="dateFrom" id="dateFrom" type="date">
                <label>To</label>
                <input name="dateTo" id="dateTo" type="date">
                <input type="submit" value="Søk">
            </form>
        </div>
    </div>
</body>
</html>