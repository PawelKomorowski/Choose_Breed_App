<#include "/common/header.ftl">

<main class="page__content">
    <h2 class="heading--2">${pageTitle}</h2>

    <#list results as result>
        <article class="card color--white text--black">
            <!-- <div class="card__image card__image--right"> -->
            <!--     <img class="card__img" src="" alt=""> -->
            <!-- </div> -->
            <h3 class="card__title">${result.breedsInfo.name} - ${result.percentageScore}%</h3>
            <div class="card__content">
                ${result.breedsInfo.description?truncate(350)}
            </div>
            <div class="card__actions">
                <a class="card__button text--teal" href="/breed/${result.breedsInfo.urlEncode()}">Więcej</a>
            </div>
        </article>
    </#list>
</main>

<#include "/common/footer.ftl">
