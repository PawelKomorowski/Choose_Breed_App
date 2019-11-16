<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>allBreedsView</title>
</head>
<body>
<table>
    <tr>
        <th>Nazwa</th>
        <th>Grupa</th>
        <th>Rozmiar</th>
    </tr>

    <#list breedsInfos as breed>
        <tr>
            <td><a href="/breed/${breed.name}">${breed.name}</a></td>
            <td>${breed.groupName}</td>
            <td>${breed.size}</td>
        </tr>
    </#list>
</table>
</body>
</html>