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
                        <#if breed??>value="${breed.name}" readonly</#if>>
                    <label for="name" class="text-field__label">Nazwa</label>
                </div><br>
                <!-- Grupa -->
                <div class="select">
                    <select type="select" class="select__select" id="group" name="breedGroup" required>
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
                        <option value="MALY" <#if breed?? && breed.size="MALY">selected</#if>>Mały</option>
                        <option value="SREDNI" <#if breed?? && breed.size="SREDNI">selected</#if>>Średni</option>
                        <option value="DUZY" <#if breed?? && breed.size="DUZY">selected</#if>>Duży</option>
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
                    <select type="select" class="select__select" id="illnesses" name="illnessPossibility" required>
                        <option value="">Wybierz...</option>
                        <option value="MALA" <#if breed?? && breed.illnessPossibility="MALA">selected</#if>>Mała</option>
                        <option value="SREDNIA" <#if breed?? && breed.illnessPossibility="SREDNIA">selected</#if>>Średnia</option>
                        <option value="DUZA" <#if breed?? && breed.illnessPossibility="DUZA">selected</#if>>Duża</option>
                    </select>
                    <label for="illnesses" class="select__label">Skłonność do chorób</label>
                </div><br>
                <!-- Długość życia -->
                <div class="text-field">
                    <input type="number" class="text-field__input" id="live_length" name="liveLength" required value="<#if breed??>${breed.liveLength?c}</#if>">
                    <label for="live_length" class="text-field__label">Długość życia</label>
                </div><br>
                <!-- Koszt zakupu -->
                <div class="text-field">
                    <input type="number" class="text-field__input" id="cost" name="cost" required value="<#if breed??>${breed.cost?c}</#if>">
                    <label for="cost" class="text-field__label">Koszt zakupu</label>
                </div><br>
                <!-- Koszt utrzymania -->
                <div class="text-field">
                    <input type="number" class="text-field__input" id="livelihood_cost" name="livelihoodCost" required value="<#if breed??>${breed.livelihoodCost?c}</#if>">
                    <label for="livelihood_cost" class="text-field__label">Koszt utrzymania</label>
                </div><br>
                <!-- Trudność czyszczenia -->
                <div class="select">
                    <select type="select" class="select__select" id="cleaning_difficulty" name="cleaningDifficulty" required>
                        <option value="">Wybierz...</option>
                        <option value="LATWO" <#if breed?? && breed.cleaningDifficulty="LATWO">selected</#if>>Łatwo</option>
                        <option value="SREDNIO" <#if breed?? && breed.cleaningDifficulty="SREDNIO">selected</#if>>Średnio</option>
                        <option value="TRUDNO" <#if breed?? && breed.cleaningDifficulty="TRUDNO">selected</#if>>Trudno</option>
                    </select>
                    <label for="cleaning_difficulty" class="select__label">Trudność czyszczenia</label>
                </div><br>
                <!-- Trudność tresury -->
                <div class="select">
                    <select type="select" class="select__select" id="training_difficulty" name="trainDifficulty" required>
                        <option value="">Wybierz...</option>
                        <option value="LATWO" <#if breed?? && breed.trainDifficulty="LATWO">selected</#if>>Łatwo</option>
                        <option value="SREDNIO" <#if breed?? && breed.trainDifficulty="SREDNIO">selected</#if>>Średnio</option>
                        <option value="TRUDNO" <#if breed?? && breed.trainDifficulty="TRUDNO">selected</#if>>Trudno</option>
                    </select>
                    <label for="training_difficulty" class="select__label">Trudność tresury</label>
                </div><br>
                <!-- Długość sierści -->
                <div class="select">
                    <select type="select" class="select__select" id="hair_length" name="hairLength" required>
                        <option value="">Wybierz...</option>
                        <option value="KROTKA" <#if breed?? && breed.hairLength="KROTKA">selected</#if>>Krótka</option>
                        <option value="SREDNIA" <#if breed?? && breed.hairLength="SREDNIA">selected</#if>>Średnia</option>
                        <option value="DLUGA" <#if breed?? && breed.hairLength="DLUGA">selected</#if>>Długa</option>
                    </select>
                    <label for="hair_length" class="select__label">Długość sierści</label>
                </div><br>
                <!-- Typ sierści -->
                <div class="select">
                    <select type="select" class="select__select" id="hair_type" name="hairType" required>
                        <option value="">Wybierz...</option>
                        <option value="GLADKA" <#if breed?? && breed.hairType="GLADKA">selected</#if>>Gładka</option>
                        <option value="PUCHATA" <#if breed?? && breed.hairType="PUCHATA">selected</#if>>Puchata</option>
                        <option value="SZORSTKA" <#if breed?? && breed.hairType="SZORSTKA">selected</#if>>Szorstka</option>
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

</main>

<#include "/common/footer.ftl">
