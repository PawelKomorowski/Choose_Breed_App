<footer class="footer color--teal text--white">
    <div class="footer__left">
        Choose Breed App<br>
        Autor: Paweł Komorowski
    </div>
    <div class="footer__right">
        <#if isAdmin?? && isAdmin==true>
            Zalogowano jako administrator.<br>
            <a class="typography--link text--white" href="/logout">wyloguj</a>
        </#if>
    </div>
</footer>

</body>
</html>
