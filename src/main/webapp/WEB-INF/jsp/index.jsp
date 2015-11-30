<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GeoAPI v1</title>
</head>
<body>
<h2>GeoAPI v1</h2>
<div>
    <table>
        <tr>
            <td>{[/city/find/{name}],methods=[GET]}</td>
            <td>name - строка поиска</td>
            <td>возвращает массив CitiesEntity максимум длиной 5</td>
        </tr>
        <tr>
            <td>{[/city/find/{name}/{size}],methods=[GET]}"</td>
            <td>name - строка поиска,size - количество результатов(<=15)</td>
            <td>возвращает массив CitiesEntity длинной size</td>
        </tr>
        <tr>
            <td>{[/city/{id}],methods=[GET]}</td>
            <td>id - id города</td>
            <td>возвращает CitiesEntity</td>
        </tr>
         <tr>
             <td>{[/country/{id}],methods=[GET]}</td>
             <td>id - id страны</td>
             <td>возвращаетCountriesEntity</td>
         </tr>
    </table>
</div>
</body>
</html>
