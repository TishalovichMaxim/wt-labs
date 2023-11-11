<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="locale"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Anime</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        html {
            height: 100%;
        }
        body {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            min-height: 100%;
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
    <h1>Add New Anime</h1>
    <form method="POST" action="/your_anime_list/controller" enctype="multipart/form-data" >
        <input type="hidden" name="command" value="do_add_anime" />
        <div class="form-group">
            <label for="animeName">Anime Name</label>
            <input type="text" class="form-control" id="animeName" placeholder="Enter the anime name" name="animeName">
        </div>
        <div class="form-group">
            <label for="authorName">Author Name</label>
            <input type="text" class="form-control" id="authorName" placeholder="Enter the author name" name="authorName">
        </div>
        <div class="form-group">
            <label for="animeYear">Anime Year</label>
            <input type="number" class="form-control" id="animeYear" placeholder="Enter the anime year" name="animeYear">
        </div>
        <div class="form-group">
            <div>
                <label for="animeImage">Anime Image</label>
            </div>
            <input type="file" class="form-control-file" id="animeImage" name="animeImage">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@include file="footer.html"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</body>
</html>
