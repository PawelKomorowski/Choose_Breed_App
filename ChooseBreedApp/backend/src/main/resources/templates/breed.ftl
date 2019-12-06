<#include "/common/header.ftl">

<main class="page__content">
    <h2 class="heading--2">${pageTitle}</h2>

    <div class="grid">
        <article class="card color--white text--black grid__col--2-3">
            <h3 class="card__title">Opis</h3>
            <div class="card__content">
                <p>${breed.description}</p>
            </div>
        </article>
        <article class="card color--white text--black grid__col--1-3">
            <h3 class="card__title">Cechy</h3>
            <div class="card__content">
                <table class="table">
                    <thead class="table__head">
                    <tr class="table__row--head">
                        <th class="table__cell table__cell--head table__cell--non-numeric">Cecha</th>
                        <th class="table__cell table__cell--head table__cell--non-numeric">Wartość</th>
                    </tr>
                    </thead>
                    <tbody class="table__body">
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Grupa</td>
                        <td class="table__cell table__cell--non-numeric">${breed.groupName}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Rozmiar</td>
                        <td class="table__cell table__cell--non-numeric">${breed.size.getSize()}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Waga</td>
                        <td class="table__cell table__cell--non-numeric">${breed.weight}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Skłonność do chorób</td>
                        <td class="table__cell table__cell--non-numeric">${breed.illnessPossibility.getIllness()}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Długość życia</td>
                        <td class="table__cell table__cell--non-numeric">${breed.liveLength}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Koszt rasy</td>
                        <td class="table__cell table__cell--non-numeric">${breed.cost}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Koszt utrzymania</td>
                        <td class="table__cell table__cell--non-numeric">${breed.livelihoodCost}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Utrzymanie czystości</td>
                        <td class="table__cell table__cell--non-numeric">${breed.cleaningDifficulty.getDifficulty()}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Trudność tresury</td>
                        <td class="table__cell table__cell--non-numeric">${breed.trainDifficulty.getDifficulty()}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Długość sierści</td>
                        <td class="table__cell table__cell--non-numeric">${breed.hairLength.getLength()}</td>
                    </tr>
                    <tr class="table__row">
                        <td class="table__cell table__cell--non-numeric">Rodzaj sierści</td>
                        <td class="table__cell table__cell--non-numeric">${breed.hairType.getType()}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </article>
    </div>

    <article class="card color--white text--black">
        <h3 class="card__title">Galeria</h3>
        <div class="card__content">
            <ul class="gallery">
                <#list photos as photo>
                    <li class="gallery__item">
                        <div class="gallery__container">
                            <img src="${photo.file}" alt="Zdjęcie psa rasy ${breed.name}." class="gallery__image">
                        </div>
                    </li>
                </#list>
            </ul>
        </div>
    </article>

</main>

<#include "/common/footer.ftl">
