<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="locale" />

<nav class="navbar navbar-expand-lg bg-dark text-light mb-4">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link text-light" href="/your_anime_list/controller?command=anime_list"><fmt:message key="navbar.anime" /></a>
        <c:choose>
          <c:when test="${role == 'Visitor'}">
            <a class="nav-link text-light" href="/your_anime_list/controller?command=login"><fmt:message key="navbar.login" /></a>
            <a class="nav-link text-light" href="/your_anime_list/controller?command=register"><fmt:message key="navbar.register" /></a>
          </c:when>
          <c:when test="${role == 'Administrator'}">
            <a class="nav-link text-light" href="/your_anime_list/controller?command=users">${header_users_label}</a>
            <a class="nav-link text-light" href="/your_anime_list/controller?command=add_anime">${header_add_anime_label}</a>
            <a class="nav-link text-light" href="/your_anime_list/controller?command=logout">${header_logout_label}</a>
          </c:when>
          <c:when test="${role == 'User'}">
            <a class="nav-link text-light" href="/your_anime_list/controller?command=profile">${header_profile_label}</a>
            <a class="nav-link text-light" href="/your_anime_list/controller?command=logout">${header_logout_label}</a>
          </c:when>
        </c:choose>
      </div>
    </div>
    <form method="POST" action="/your_anime_list/controller">
      <div class="dropdown">
        <input type="hidden" name="command" value="change_language" />
        <input type="hidden" name="curr_page_name" value="${curr_page_name}" />
        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          ${language_name}
        </button>
        <div class="dropdown-menu">
          <button class="dropdown-item" type="submit" name="language" value="russian">Русский</button>
          <button class="dropdown-item" type="submit" name="language" value="english">English</button>
        </div>
      </div>
    </form>
  </div>
</nav>