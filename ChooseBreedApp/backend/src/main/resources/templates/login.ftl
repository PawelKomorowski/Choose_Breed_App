<#include "/common/header.ftl">

<main class="page__content" id="search-card">

    <article class="card color--white text--black">
        <h3 class="card__title">Logowanie</h3>
        <div class="card__content">
            <form action="/auth" method="POST" id="login">
                <div class="text-field">
                    <input type="text" class="text-field__input" id="user" name="user" required>
                    <label for="user" class="text-field__label">Użytkownik</label>
                </div><br>
                <div class="text-field">
                    <input type="password" class="text-field__input" id="pass" name="pass" required>
                    <label for="pass" class="text-field__label">Hasło</label>
                </div>
            </form>
        </div>
        <div class="card__actions">
            <input type="submit" class="card__button text--teal" form="login" value="Zaloguj">
        </div>
    </article>

</main>

<#include "/common/footer.ftl">
