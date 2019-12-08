<#include "/common/header.ftl">

<main class="page__content">
    <h2 class="heading--2">${pageTitle}</h2>

    <article class="card color--white text--black">
        <div class="card__content">
            <table class="table">
                <thead class="table__head">
                <tr class="table__row--head">
                    <th class="table__cell table__cell--head table__cell--non-numeric">Nazwa</th>
                    <th class="table__cell table__cell--head table__cell--non-numeric">Rozmiar</th>
                    <th class="table__cell table__cell--head table__cell--non-numeric">Skłonność do chorób</th>
                    <th class="table__cell table__cell--head table__cell--non-numeric">Długość życia</th>
                    <th class="table__cell table__cell--head">Cena</th>
                    <#if isAdmin?? && isAdmin==true>
                        <th class="table__cell table__cell--head table__cell--non-numeric">Akcje</th>
                    </#if>
                </tr>
                </thead>
                <tbody class="table__body">
                    <#list breedsInfos as breed>
                        <tr class="table__row">
                            <td class="table__cell table__cell--non-numeric">
                                <a class="typography--link typography--strong text--teal" href="/breed/${breed.urlEncode()}">${breed.name}</a>
                            </td>
                            <td class="table__cell table__cell--non-numeric">${breed.size.getSize()}</td>
                            <td class="table__cell table__cell--non-numeric">${breed.illnessPossibility.getIllness()}</td>
                            <td class="table__cell table__cell--non-numeric">${breed.liveLength}</td>
                            <td class="table__cell">${breed.cost}</td>
                            <#if isAdmin?? && isAdmin==true>
                                <td class="table__cell table__cell--head table__cell--non-numeric">
                                    <a href="/edit/${breed.urlEncode()}" class="button button--flat text--teal color--white">edytuj</a>
                                    <a href="/add" class="button button--flat text--teal color--white">dodaj</a>
                                    <a href="/delete/${breed.urlEncode()}" class="button button--flat text--teal color--white">usuń</a>
                                </td>
                            </#if>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </article>

</main>

<#include "/common/footer.ftl">
