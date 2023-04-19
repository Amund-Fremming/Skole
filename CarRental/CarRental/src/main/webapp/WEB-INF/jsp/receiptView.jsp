<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="../css/main.css">
    <title>Kvittering</title>
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

    <!-- Receipt -->
    <div class="invoice-box">
        <table>
            <tr class="top">
                <td colspan="2">
                    <table>
                        <tr>
                            <td class="title">
                                <h3>${car.brand} ${car.model}</h3>
                            </td>

                            <td>
                                Kvittering #: 123<br />
                                Leie start: ${dateFrom}<br />
                                Leie slutt: ${dateTo}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr class="information">
                <td colspan="2">
                    <table>
                        <tr>
                            <td>
                                Utleiested: ${office}
                            </td>

                            <td>
                                ${user.lname}, ${user.fname}<br />
                                ${user.mobile}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr class="heading">
                <td>Betalingsmetode</td>

                <td></td>
            </tr>

            <tr class="details">
                <td>Kredittkort</td>
            </tr>

            <tr class="heading">
                <td>Bil</td>

                <td>Sum</td>
            </tr>

            <tr class="item">
                <td>Bil ${car.color}, ${car.brand} ${car.model}</td>
                <td>1600,-</td>
            </tr>

			 <tr class="item">
                <td></td>
                <td>Mva: 279,-</td>
            </tr>
            <tr class="total">
                <td></td>
                <td>Total: 1879,-</td>
            </tr>
        </table>
    </div>
</body>
</html>