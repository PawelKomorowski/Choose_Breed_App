<#include "/common/header.ftl">

<main class="page__content" id="search-card">
    <h2 class="heading--2">${pageAction}</h2>

    <article class="card color--white text--black">
        <h3 class="card__title">Cechy</h3>
        <div class="card__content">
            <form action="/save" method="POST" id="form-edit">
                <!-- Nazwa -->
                <div class="text-field">
                    <input type="text" class="text-field__input" id="name" name="name" required
                        <#if breed??>value="${breed.name}" disabled</#if>>
                    <label for="name" class="text-field__label">Nazwa</label>
                </div><br>
                <!-- Grupa -->
                <div class="select">
                    <select type="select" class="select__select" id="group" name="group" required>
                        <option value="">Wybierz...</option>
                        <#list groups as group>
                            <option value="${group.getId()}" <#if breed?? && group.getId()=breed.getBreedGroup().getId()>selected</#if>>${group.getName()}</option>
                        </#list>
                    </select>
                    <label for="group" class="select__label">Grupa</label>
                </div><br>
                <!-- Rozmiar -->
                <div class="select">
                    <select type="select" class="select__select" id="size" name="size" required>
                        <option value="">Wybierz...</option>
                        <option value="maly" <#if breed?? && breed.size="MALY">selected</#if>>Mały</option>
                        <option value="sredni" <#if breed?? && breed.size="SREDNI">selected</#if>>Średni</option>
                        <option value="duzy" <#if breed?? && breed.size="DUZY">selected</#if>>Duży</option>
                    </select>
                    <label for="size" class="select__label">Rozmiar</label>
                </div><br>
                <!-- Waga -->
                <div class="text-field">
                    <input type="number" class="text-field__input" id="weight" name="weight" required value="<#if breed??>${breed.weight?c}</#if>">
                    <label for="weight" class="text-field__label">Waga</label>
                </div><br>
                <!-- Choroby -->
                <div class="select">
                    <select type="select" class="select__select" id="illnesses" name="illnesses" required>
                        <option value="">Wybierz...</option>
                        <option value="mala" <#if breed?? && breed.illnessPossibility="MALA">selected</#if>>Mała</option>
                        <option value="srednia" <#if breed?? && breed.illnessPossibility="SREDNIA">selected</#if>>Średnia</option>
                        <option value="duza" <#if breed?? && breed.illnessPossibility="DUZA">selected</#if>>Duża</option>
                    </select>
                    <label for="illnesses" class="select__label">Skłonność do chorób</label>
                </div><br>
                <!-- Długość życia -->
                <div class="text-field">
                    <input type="number" class="text-field__input" id="live_length" name="live_length" required value="<#if breed??>${breed.liveLength?c}</#if>">
                    <label for="live_length" class="text-field__label">Długość życia</label>
                </div><br>
                <!-- Koszt zakupu -->
                <div class="text-field">
                    <input type="number" class="text-field__input" id="cost" name="cost" required value="<#if breed??>${breed.cost?c}</#if>">
                    <label for="cost" class="text-field__label">Koszt zakupu</label>
                </div><br>
                <!-- Koszt utrzymania -->
                <div class="text-field">
                    <input type="number" class="text-field__input" id="livelihood_cost" name="livelihood_cost" required value="<#if breed??>${breed.livelihoodCost?c}</#if>">
                    <label for="livelihood_cost" class="text-field__label">Koszt utrzymania</label>
                </div><br>
                <!-- Trudność czyszczenia -->
                <div class="select">
                    <select type="select" class="select__select" id="cleaning_difficulty" name="cleaning_difficulty" required>
                        <option value="">Wybierz...</option>
                        <option value="latwo" <#if breed?? && breed.cleaningDifficulty="LATWO">selected</#if>>Łatwo</option>
                        <option value="srednio" <#if breed?? && breed.cleaningDifficulty="SREDNIO">selected</#if>>Średnio</option>
                        <option value="trudno" <#if breed?? && breed.cleaningDifficulty="TRUDNO">selected</#if>>Trudno</option>
                    </select>
                    <label for="cleaning_difficulty" class="select__label">Trudność czyszczenia</label>
                </div><br>
                <!-- Trudność tresury -->
                <div class="select">
                    <select type="select" class="select__select" id="training_difficulty" name="training_difficulty" required>
                        <option value="">Wybierz...</option>
                        <option value="latwo" <#if breed?? && breed.trainDifficulty="LATWO">selected</#if>>Łatwo</option>
                        <option value="srednio" <#if breed?? && breed.trainDifficulty="SREDNIO">selected</#if>>Średnio</option>
                        <option value="trudno" <#if breed?? && breed.trainDifficulty="TRUDNO">selected</#if>>Trudno</option>
                    </select>
                    <label for="training_difficulty" class="select__label">Trudność tresury</label>
                </div><br>
                <!-- Długość sierści -->
                <div class="select">
                    <select type="select" class="select__select" id="hair_length" name="hair_length" required>
                        <option value="">Wybierz...</option>
                        <option value="krotka" <#if breed?? && breed.hairLength="KROTKA">selected</#if>>Krótka</option>
                        <option value="srednia" <#if breed?? && breed.hairLength="SREDNIA">selected</#if>>Średnia</option>
                        <option value="dluga" <#if breed?? && breed.hairLength="DLUGA">selected</#if>>Długa</option>
                    </select>
                    <label for="hair_length" class="select__label">Długość sierści</label>
                </div><br>
                <!-- Typ sierści -->
                <div class="select">
                    <select type="select" class="select__select" id="hair_type" name="hair_type" required>
                        <option value="">Wybierz...</option>
                        <option value="gladka" <#if breed?? && breed.hairType="GLADKA">selected</#if>>Gładka</option>
                        <option value="falista" <#if breed?? && breed.hairType="FALISTA">selected</#if>>Falista</option>
                        <option value="puchata" <#if breed?? && breed.hairType="PUCHATA">selected</#if>>Puchata</option>
                        <option value="szorstka" <#if breed?? && breed.hairType="SZORSTKA">selected</#if>>Szorstka</option>
                    </select>
                    <label for="hair_type" class="select__label">Typ sierści</label>
                </div><br>
                <!-- Opis -->
                <div class="text-field">
                    <textarea type="text" class="text-field__input text-field__input--textarea" id="description" name="description" required><#if breed??>${breed.description}</#if></textarea>
                    <label for="description" class="text-field__label">Opis</label>
                </div>
            </form>
        </div>
        <div class="card__actions">
            <input type="submit" class="card__button text--teal" form="form-edit" value="Zapisz">
        </div>
    </article>

    <article class="card color--white text--black">
        <h3 class="card__title">Galeria</h3>
        <div class="card__content">
            <h4 class="heading--6">Zdjęcia</h4>

            <ul class="gallery">
                <#list photos as photo>
                    <li class="gallery__item">
                        <div class="gallery__container">
                            <img src="${photo.file}" alt="Zdjęcie psa" class="gallery__image">
                        </div>
                        <div class="gallery__caption">
                            <a href="/delphoto/${photo.id}" class="typography--link text--teal">usuń</a>
                        </div>
                    </li>
                </#list>
            </ul>

            <h4 class="heading--6">Dodawanie</h4>
            <form action="/savephoto" method="POST">
                <input type="file" name="image" id="image" value="Nie wybrano pliku"><br>
                <input type="submit" value="Dodaj" class="button text--teal">
            </form>
        </div>
    </article>

</main>

<#include "/common/footer.ftl">
