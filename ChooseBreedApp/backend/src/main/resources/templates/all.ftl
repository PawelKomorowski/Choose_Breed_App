<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Wszystkie rasy | Choose Breed App</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Stylesheets -->
    <link rel="stylesheet" href="/style/normalize.css">
    <link rel="stylesheet" href="/style/style.css">

    <!-- Roboto fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:500,300,300italic,400&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
</head>

<body class="page">
<header class="header header--compact color--teal text--white">
    <h1 class="header__title">
        <a class="header__link" href="/">Choose Breed App</a>
    </h1>

    <nav class="nav">
        <ul class="nav__list">
            <li class="nav__item"><a class="nav__link" href="/">Wyszukiwanie</a></li>
            <li class="nav__item"><a class="nav__link nav__link--active" href="/all">Wszystkie rasy</a></li>
        </ul>
    </nav>
</header>
<main class="page__content">
    <h2 class="heading--2">Wszystkie rasy</h2>

    <article class="card color--white text--black">
        <div class="card__content">
            <table class="table">
                <thead class="table__head">
                <tr class="table__row--head">
                    <th class="table__cell table__cell--head table__cell--non-numeric">Nazwa</th>
                    <th class="table__cell table__cell--head table__cell--non-numeric">Grupa</th>
                    <th class="table__cell table__cell--head table__cell--non-numeric">Rozmiar</th>
                    <th class="table__cell table__cell--head table__cell--non-numeric">Długość życia</th>
                    <th class="table__cell table__cell--head">Cena</th>
                </tr>
                </thead>
                <tbody class="table__body">
                    <#list breedsInfos as breed>
                        <tr class="table__row">
                            <td class="table__cell table__cell--non-numeric">
                                <a class="typography--link typography--strong text--teal" href="/breed/${breed.urlEncode()}">${breed.name}</a>
                            </td>
                            <td class="table__cell table__cell--non-numeric">${breed.groupName}</td>
                            <td class="table__cell table__cell--non-numeric">${breed.size.getSize()}</td>
                            <td class="table__cell table__cell--non-numeric">${breed.liveLength}</td>
                            <td class="table__cell">${breed.cost}</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </article>

</main>
</body>

</html>
