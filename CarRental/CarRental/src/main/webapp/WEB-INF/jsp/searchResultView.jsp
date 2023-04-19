<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/main.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<title>Søk</title>
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

	<!-- Search content -->
	<div class="search_container">

		<c:forEach var="car" items="${availableCars}">
			<form action="searchResult" method="post">
				<div id="card_container">
					<div class="car_details">
						<h1>${car.brand} ${car.model}</h1>
		
						<p class="information">Dette er en moderne, ${car.color} ${car.brand} ${car.model} fra
							Italia.</p>
							
						<p class="information">Bilen inngår i størrelseklasse: ${car.sizegroup}</p>
						<p class="information">Lorem ipsum dolor sit amet consectetur
							adipisicing elit. Beatae, facilis. Animi tempora nisi eveniet hic
							numquam vero blanditiis labore rerum quasi?</p>
		
						<div class="control">
							<button type="submit" class="btn">
								<span class="price">500,-</span> <span class="buy">Lei bil</span>
							</button>
						</div>
						<input name="regnr" hidden="hidden" value="${car.regnr}" />
		
					</div>
		
					<div class="car_image">
						<img
							src="${car.img}">
					</div>
				</div>
			</form>
		</c:forEach>


	</div>
</body>
</html>