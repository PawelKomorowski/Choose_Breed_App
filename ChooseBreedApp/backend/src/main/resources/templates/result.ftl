<#include "/common/header.ftl">

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

    <#list results as result>
        <article class="card color--white text--black">
            <!-- <div class="card__image card__image--right"> -->
            <!--     <img class="card__img" src="" alt=""> -->
            <!-- </div> -->
            <h3 class="card__title">${result.name}</h3>
            <div class="card__content">
                ${result.description?truncate(350)}
            </div>
            <div class="card__actions">
                <a class="card__button text--teal" href="/breed/${result.urlEncode()}">Więcej</a>
            </div>
        </article>
    </#list>
</main>
</body>

<#include "/common/footer.ftl">
