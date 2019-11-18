<#iclude "/common/header.ftl">

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
<main class="page__content">
    <h2 class="heading--2">${pageTitle}</h2>

    <article class="card color--white text--black">
        <div class="card__image card__image--right">
            <img class="card__img" src="img/border.jpg" alt="Obrazek bordera">
        </div>
        <h3 class="card__title">Border Collie</h3>
        <div class="card__content">Border Collie pasterstwo ma we krwi. Za sprawą niewiarygodnego wręcz zamiłowania do pracy oraz z całą pewnością wartej wspomnienia w tym miejscy wysokiej inteligencji pies tej rasy potrafi bez wysiłku utrzymać w ryzach niejedno stado zwierząt. Wybitnym fachowcem jest zwłaszcza w zakresie wypasania owiec. [...]</div>
        <div class="card__actions">
            <a class="card__button text--teal" href="#">Więcej</a>
        </div>
    </article>

    <article class="card color--white text--black">
        <div class="card__image card__image--right">
            <img class="card__img" src="img/york.jpg" alt="Obrazek yorka">
        </div>
        <h3 class="card__title">Yorkshire Terrier</h3>
        <div class="card__content">Yorkshire terrier przypomina nieco dumnego, miniaturowego lwa z imponujacą, długą grzywą. Choć może to wyglądać rozkosznie, nie wolno zapominać, że pies ten jest terrierem i jako taki był użytkowany w przeszłości, zanim wkroczył na salony. [...]</div>
        <div class="card__actions">
            <a class="card__button text--teal" href="#">Więcej</a>
        </div>
    </article>

    <article class="card color--white text--black">
        <div class="card__image card__image--right">
            <img class="card__img" src="img/jamnik.jpg" alt="Obrazek jamnika">
        </div>
        <h3 class="card__title">Jamnik</h3>
        <div class="card__content">Jamniki bardzo łatwo można rozpoznać po ich specyficznej budowie ciała: Krótkie nóżki dźwigają muskularny, nieproporcjonalnie długi tułów. Do standardu rasy należy również klinowata głowa z wiszącymi uszami. [...]</div>
        <div class="card__actions">
            <a class="card__button text--teal" href="#">Więcej</a>
        </div>
    </article>
</main>
</body>

<#include "/common/footer.ftl">
