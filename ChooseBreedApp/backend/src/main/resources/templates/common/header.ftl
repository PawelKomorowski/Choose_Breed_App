<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${pageTitle} | Choose Breed App</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Stylesheets -->
    <link rel="stylesheet" href="/style/normalize.css">
    <link rel="stylesheet" href="/style/style.css">

    <!-- Roboto fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:500,300,300italic,400&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
</head>

<body class="page">
<header class="header header--compact color--teal text--white">
    <h1 class="header__title">
        <a class="header__link" href="/">Choose Breed App</a>
    </h1>

    <nav class="nav">
        <ul class="nav__list">
            <li class="nav__item"><a class="nav__link <#if pageTitle == "Wyszukiwanie">nav__link--active</#if>" href="/">Wyszukiwanie</a></li>
            <li class="nav__item"><a class="nav__link <#if pageTitle == "Wszystkie rasy">nav__link--active</#if>" href="/all">Wszystkie rasy</a></li>
        </ul>
    </nav>
</header>
