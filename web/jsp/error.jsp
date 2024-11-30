<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<html>


<body bgcolor="white">

<c:set var="message" value="${request.getAttribute('result')}"/>
<c:out value="${session.invalidate()}"/>
     
            <<h1>Error:<c:out value="${message}"/></h1>
</body>
</html>
