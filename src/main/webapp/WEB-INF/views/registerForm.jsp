<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>

<html>
  <head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>

  <body>
    <h1>Rejestracja</h1>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    <sf:form method="POST" commandName="spitter">
      <sf:errors path="*" element="div" cssClass="errors"/>
      <sf:label path="firstName" cssErrorClass="error">Imie</sf:label>
      <sf:input path="firstName" cssErrorClass="error"/> <br/>
      Nazwisko: <sf:input path="lastName"/><br/>
      Adres e-mail: <sf:input path="email" type="email"/><br/>
      Nazwa użytkownika: <sf:input path="userName"/>  <br/>
      Hasło: <sf:password path="password"/> <br/>
      <input type="submit" value="Zarejestruj" />
    </sf:form>
  </body>
</html>
