<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/static/css/my.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/bootstrap-theme.min.css" />" rel="stylesheet">

    <title>GeoAPI v1</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">GeoAPI v1</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">API Refrences</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <div class="my-template">
        <div class="table-responsive">
        <table class="table table-bordered">
            <tr>
                <th>Req string</th>
                <th>Params</th>
                <th>Answer</th>
            </tr>
            <tr>
                <td><b>/city/find/{name} method=GET</b></td>
                <td>name - строка поиска, от 4 символов</td>
                <td>возвращает массив CitiesEntity максимум длиной 5</td>
            </tr>
            <tr>
                <td><b>/city/find/{name}/{size} method=GET</b></td>
                <td>name - строка поиска от 4 символов, size - количество результатов до 15</td>
                <td>возвращает массив CitiesEntity длинной size</td>
            </tr>
            <tr>
                <td><b>/city/{id}] method =GET</b></td>
                <td>id - id города</td>
                <td>возвращает массив CitiesEntity</td>
            </tr>
            <tr>
                <td><b>/country/{id} method=GET</b></td>
                <td>id - id страны</td>
                <td>возвращает массив CountriesEntity</td>
            </tr>
            <tr>
                <td><b>/county/find/{name}] method =GET</b></td>
                <td>name - строка поиска</td>
                <td>возвращает массив CountriesEntity</td>
            </tr>
        </table>
            </div>
    </div>
</div>
<script src="<c:url value="/static/js/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</body>
</html>
