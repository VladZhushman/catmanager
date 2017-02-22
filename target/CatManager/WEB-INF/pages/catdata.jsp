<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>CatData</title>

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
<h1>Cat Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Owner</th>
        <th width="120">Color</th>
        <th>Photo</th>
    </tr>
    <tr>
        <td>${cat.id}</td>
        <td>${cat.catName}</td>
        <td>${cat.catOwner}</td>
        <td>${cat.catColor}</td>
        <td><img src="${cat.photo}" alt="No Photo" ></td>
    </tr>
</table>

<img src="/resources/cat1.png">


<form:form method="post" action="handleUpload/${cat.id}" enctype="multipart/form-data">
    <p><label for="image">Choose Image</label></p>
    <p><input name="file" id="fileToUpload" type="file" /></p>
    <p><input type="submit" value="Upload"></p>
</form:form>



</body>
</html>
