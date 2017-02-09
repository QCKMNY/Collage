<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<c:forEach var="num" items="${images}">
    ${num}<br/>
</c:forEach>
Hello
${imageHTML}
<h1>${text}</h1>
<img SRC="http://www.karta-sokrovish.by/images/picmain/pictures27.jpg" width="100" height="100">
<img SRC=${text} width="100" height="100">
${img}

</body>
</html>
