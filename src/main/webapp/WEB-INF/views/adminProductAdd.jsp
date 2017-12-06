<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Product</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<h1> LobanTM </h1>

<div class="container">

    <form modelAttribute="addProduct" method="POST" action="" class="form-signin">


        <label>name product</label>
            <input name="nameProduct" type="text" autofocus="true"/>
        <br>
        <label>price</label>
            <input name="price" type="number" />
        <br>
        <label>manufacturer</label>
        <p><select size="5"  name="manufID">
            <%--<option disabled>products</option>--%>
            <c:forEach items="${manufS}" var="manufS">
                <option value="${manufS.id}" > <c:out value="${manufS.name}"/></option>
            </c:forEach>
        </select></p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">add product</button>

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>