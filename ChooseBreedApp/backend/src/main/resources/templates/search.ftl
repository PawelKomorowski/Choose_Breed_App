<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Wyszukiwanie | Choose Breed App</title>

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
            <li class="nav__item"><a class="nav__link nav__link--active" href="/">Wyszukiwanie</a></li>
            <li class="nav__item"><a class="nav__link" href="/all">Wszystkie rasy</a></li>
        </ul>
    </nav>
</header>
<main class="page__content" id="search-card">
    <h2 class="heading--2">Wyszukiwanie</h2>

    <article class="card color--white text--black">
        <h3 class="card__title">Cechy</h3>
        <div class="card__content">
            <form action="#">
                <!-- Rozmiar -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Rozmiar</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="size1" class="checkbox__input" name="size[]" value="mały">
                        <label for="size1" class="checkbox__label">Mały</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="size2" class="checkbox__input" name="size[]" value="średni">
                        <label for="size2" class="checkbox__label">Średni</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="size3" class="checkbox__input" name="size[]" value="duży">
                        <label for="size3" class="checkbox__label">Duży</label>
                    </div><br>
                </div>
                <!-- Waga -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Waga</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="weight1" class="checkbox__input" name="weight[]" value="mała">
                        <label for="weight1" class="checkbox__label">Mała</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="weight2" class="checkbox__input" name="weight[]" value="średnia">
                        <label for="weight2" class="checkbox__label">Średnia</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="weight3" class="checkbox__input" name="weight[]" value="duża">
                        <label for="weight3" class="checkbox__label">Duża</label>
                    </div><br>
                </div>
                <!-- Choroby -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Skłonność do chorób</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="illnesses1" class="checkbox__input" name="illnesses[]" value="mała">
                        <label for="illnesses1" class="checkbox__label">Mała</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="illnesses2" class="checkbox__input" name="illnesses[]" value="średnia">
                        <label for="illnesses2" class="checkbox__label">Średnia</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="illnesses3" class="checkbox__input" name="illnesses[]" value="duża">
                        <label for="illnesses3" class="checkbox__label">Duża</label>
                    </div><br>
                </div>
                <!-- Długość życia -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Długość życia</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="live_length1" class="checkbox__input" name="live_length[]" value="mała">
                        <label for="live_length1" class="checkbox__label">Mała</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="live_length2" class="checkbox__input" name="live_length[]" value="średnia">
                        <label for="live_length2" class="checkbox__label">Średnia</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="live_length3" class="checkbox__input" name="live_length[]" value="duża">
                        <label for="live_length3" class="checkbox__label">Duża</label>
                    </div><br>
                </div>
                <!-- Koszt zakupu -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Koszt zakupu</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cost1" class="checkbox__input" name="cost[]" value="mały">
                        <label for="cost1" class="checkbox__label">Mały</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cost2" class="checkbox__input" name="cost[]" value="średni">
                        <label for="cost2" class="checkbox__label">Średni</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cost3" class="checkbox__input" name="cost[]" value="duży">
                        <label for="cost3" class="checkbox__label">Duży</label>
                    </div><br>
                </div>
                <!-- Koszt utrzymania -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Koszt utrzymania</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="livelihood_cost1" class="checkbox__input" name="livelihood_cost[]" value="mały">
                        <label for="livelihood_cost1" class="checkbox__label">Mały</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="livelihood_cost2" class="checkbox__input" name="livelihood_cost[]" value="średni">
                        <label for="livelihood_cost2" class="checkbox__label">Średni</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="livelihood_cost3" class="checkbox__input" name="livelihood_cost[]" value="duży">
                        <label for="livelihood_cost3" class="checkbox__label">Duży</label>
                    </div><br>
                </div>
                <!-- Trudność czyszczenia -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Trudność czyszczenia</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cleaning_difficulty1" class="checkbox__input" name="cleaning_difficulty[]" value="łatwo">
                        <label for="cleaning_difficulty1" class="checkbox__label">Łatwo</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cleaning_difficulty2" class="checkbox__input" name="cleaning_difficulty[]" value="średnio">
                        <label for="cleaning_difficulty2" class="checkbox__label">Średnio</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cleaning_difficulty3" class="checkbox__input" name="cleaning_difficulty[]" value="trudno">
                        <label for="cleaning_difficulty3" class="checkbox__label">Trudno</label>
                    </div><br>
                </div>
                <!-- Trudność tresury -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Trudność tresury</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="training_difficulty1" class="checkbox__input" name="training_difficulty[]" value="łatwo">
                        <label for="training_difficulty1" class="checkbox__label">Łatwo</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="training_difficulty2" class="checkbox__input" name="training_difficulty[]" value="średnio">
                        <label for="training_difficulty2" class="checkbox__label">Średnio</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="training_difficulty3" class="checkbox__input" name="training_difficulty[]" value="trudno">
                        <label for="training_difficulty3" class="checkbox__label">Trudno</label>
                    </div><br>
                </div>
                <!-- Długość sierści -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Długość sierści</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="hair_length1" class="checkbox__input" name="hair_length[]" value="krótka">
                        <label for="hair_length1" class="checkbox__label">Krótka</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="hair_length2" class="checkbox__input" name="hair_length[]" value="średnia">
                        <label for="hair_length2" class="checkbox__label">Średnia</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="hair_length3" class="checkbox__input" name="hair_length[]" value="długa">
                        <label for="hair_length3" class="checkbox__label">Długa</label>
                    </div><br>
                </div>
                <!-- Typ sierści -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Typ sierści</h4>
                    <div class="checkbox grid__col--1-4">
                        <input type="checkbox" id="hair_type1" class="checkbox__input" name="hair_type[]" value="krótka">
                        <label for="hair_type1" class="checkbox__label">Gładka</label>
                    </div><br>
                    <div class="checkbox grid__col--1-4">
                        <input type="checkbox" id="hair_type2" class="checkbox__input" name="hair_type[]" value="średnia">
                        <label for="hair_type2" class="checkbox__label">Falista</label>
                    </div><br>
                    <div class="checkbox grid__col--1-4">
                        <input type="checkbox" id="hair_type3" class="checkbox__input" name="hair_type[]" value="długa">
                        <label for="hair_type3" class="checkbox__label">Puchata</label>
                    </div><br>
                    <div class="checkbox grid__col--1-4">
                        <input type="checkbox" id="hair_type4" class="checkbox__input" name="hair_type[]" value="długa">
                        <label for="hair_type4" class="checkbox__label">Szorstka</label>
                    </div><br>
                </div>
            </form>
        </div>
        <div class="card__actions">
            <a class="card__button text--teal ripple" href="result">Szukaj</a>
        </div>
    </article>
</main>
</body>

</html>
