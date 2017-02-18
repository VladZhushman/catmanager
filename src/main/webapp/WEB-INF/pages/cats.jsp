<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Cats Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Cat List</h1>

<c:if test="${!empty listCats}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Owner</th>
            <th width="120">Color</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCats}" var="cat">
            <tr>
                <td>${cat.id}</td>
                <td><a href="/catdata/${cat.id}" target="_blank">${cat.catName}</a></td>
                <td>${cat.catOwner}</td>
                <td>${cat.catColor}</td>
                <td><a href="<c:url value='/edit/${cat.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${cat.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Cat</h1>

<c:url var="addAction" value="/cats/add"/>

<form:form action="${addAction}" commandName="cat">
    <table>
        <c:if test="${!empty cat.catName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="catName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="catName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="catOwner">
                    <spring:message text="Owner"/>
                </form:label>
            </td>
            <td>
                <form:input path="catOwner"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="catColor">
                    <spring:message text="Color"/>
                </form:label>
            </td>
            <td>
                <form:input path="catColor"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty cat.catName}">
                    <input type="submit"
                           value="<spring:message text="Edit Book"/>"/>
                </c:if>
                <c:if test="${empty cat.catName}">
                    <input type="submit"
                           value="<spring:message text="Add Book"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>