<#include "/common/header.ftl">

<main class="page__content" id="search-card">
    <h2 class="heading--2">${pageTitle}</h2>

    <article class="card color--white text--black">
        <h3 class="card__title">Cechy</h3>
        <div class="card__content">
            <form id="search" action="#">
                <!-- Rozmiar -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Rozmiar</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="size1" class="checkbox__input" name="size[]" value="maly">
                        <label for="size1" class="checkbox__label">Mały</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="size2" class="checkbox__input" name="size[]" value="sredni">
                        <label for="size2" class="checkbox__label">Średni</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="size3" class="checkbox__input" name="size[]" value="duzy">
                        <label for="size3" class="checkbox__label">Duży</label>
                    </div><br>
                </div>
                <!-- Waga -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Waga</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="weight1" class="checkbox__input" name="weight[]" value="mala">
                        <label for="weight1" class="checkbox__label">Mała</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="weight2" class="checkbox__input" name="weight[]" value="srednia">
                        <label for="weight2" class="checkbox__label">Średnia</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="weight3" class="checkbox__input" name="weight[]" value="duza">
                        <label for="weight3" class="checkbox__label">Duża</label>
                    </div><br>
                </div>
                <!-- Choroby -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Skłonność do chorób</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="illnesses1" class="checkbox__input" name="illnesses[]" value="mala">
                        <label for="illnesses1" class="checkbox__label">Mała</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="illnesses2" class="checkbox__input" name="illnesses[]" value="srednia">
                        <label for="illnesses2" class="checkbox__label">Średnia</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="illnesses3" class="checkbox__input" name="illnesses[]" value="duza">
                        <label for="illnesses3" class="checkbox__label">Duża</label>
                    </div><br>
                </div>
                <!-- Długość życia -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Długość życia</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="live_length1" class="checkbox__input" name="live_length[]" value="mala">
                        <label for="live_length1" class="checkbox__label">Mała</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="live_length2" class="checkbox__input" name="live_length[]" value="srednia">
                        <label for="live_length2" class="checkbox__label">Średnia</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="live_length3" class="checkbox__input" name="live_length[]" value="duza">
                        <label for="live_length3" class="checkbox__label">Duża</label>
                    </div><br>
                </div>
                <!-- Koszt zakupu -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Koszt zakupu</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cost1" class="checkbox__input" name="cost[]" value="maly">
                        <label for="cost1" class="checkbox__label">Mały</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cost2" class="checkbox__input" name="cost[]" value="sredni">
                        <label for="cost2" class="checkbox__label">Średni</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cost3" class="checkbox__input" name="cost[]" value="duzy">
                        <label for="cost3" class="checkbox__label">Duży</label>
                    </div><br>
                </div>
                <!-- Koszt utrzymania -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Koszt utrzymania</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="livelihood_cost1" class="checkbox__input" name="livelihood_cost[]" value="maly">
                        <label for="livelihood_cost1" class="checkbox__label">Mały</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="livelihood_cost2" class="checkbox__input" name="livelihood_cost[]" value="sredni">
                        <label for="livelihood_cost2" class="checkbox__label">Średni</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="livelihood_cost3" class="checkbox__input" name="livelihood_cost[]" value="duzy">
                        <label for="livelihood_cost3" class="checkbox__label">Duży</label>
                    </div><br>
                </div>
                <!-- Trudność czyszczenia -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Trudność czyszczenia</h4>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cleaning_difficulty1" class="checkbox__input" name="cleaning_difficulty[]" value="latwo">
                        <label for="cleaning_difficulty1" class="checkbox__label">Łatwo</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="cleaning_difficulty2" class="checkbox__input" name="cleaning_difficulty[]" value="srednio">
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
                        <input type="checkbox" id="training_difficulty1" class="checkbox__input" name="training_difficulty[]" value="latwo">
                        <label for="training_difficulty1" class="checkbox__label">Łatwo</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="training_difficulty2" class="checkbox__input" name="training_difficulty[]" value="srednio">
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
                        <input type="checkbox" id="hair_length1" class="checkbox__input" name="hair_length[]" value="krotka">
                        <label for="hair_length1" class="checkbox__label">Krótka</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="hair_length2" class="checkbox__input" name="hair_length[]" value="srednia">
                        <label for="hair_length2" class="checkbox__label">Średnia</label>
                    </div><br>
                    <div class="checkbox grid__col--1-3">
                        <input type="checkbox" id="hair_length3" class="checkbox__input" name="hair_length[]" value="dluga">
                        <label for="hair_length3" class="checkbox__label">Długa</label>
                    </div><br>
                </div>
                <!-- Typ sierści -->
                <div class="grid">
                    <h4 class="heading--6 grid__col--1">Typ sierści</h4>
                    <div class="checkbox grid__col--1-4">
                        <input type="checkbox" id="hair_type1" class="checkbox__input" name="hair_type[]" value="gladka">
                        <label for="hair_type1" class="checkbox__label">Gładka</label>
                    </div><br>
                    <div class="checkbox grid__col--1-4">
                        <input type="checkbox" id="hair_type2" class="checkbox__input" name="hair_type[]" value="falista">
                        <label for="hair_type2" class="checkbox__label">Falista</label>
                    </div><br>
                    <div class="checkbox grid__col--1-4">
                        <input type="checkbox" id="hair_type3" class="checkbox__input" name="hair_type[]" value="puchata">
                        <label for="hair_type3" class="checkbox__label">Puchata</label>
                    </div><br>
                    <div class="checkbox grid__col--1-4">
                        <input type="checkbox" id="hair_type4" class="checkbox__input" name="hair_type[]" value="szorstka">
                        <label for="hair_type4" class="checkbox__label">Szorstka</label>
                    </div><br>
                </div>
            </form>
        </div>
        <div class="card__actions">
            <input class="card__button text--teal ripple" type="submit" form="search" value="Szukaj">
        </div>
    </article>
</main>

<#include "/common/footer.ftl">
