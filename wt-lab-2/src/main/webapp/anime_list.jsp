<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="locale"/>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        .element-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .element {
            width: calc(25% - 10px);
            margin-bottom: 20px;
        }
    </style>

</head>
<body>
<%@include file="navbar.jsp"%>
<div class="element-container">
    <c:forEach var="anime" items="${animeList}">
        <a href="?command=anime&id=${anime.getId()}">
            <div class="container">
                <div class="card element" style="width: 13rem;">
                    <img src="images/${anime.getImagePath()}" class="card-img-top" alt="Anime Image">
                    <div class="card-body">
                        <h5 class="card-title">${anime.getName()}</h5>
                    </div>
                </div>
            </div>
        </a>
    </c:forEach>
</div>
<%@include file="footer.html"%>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
