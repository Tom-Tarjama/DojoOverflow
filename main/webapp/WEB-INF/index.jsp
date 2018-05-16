
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
<h1>Question Dashboard</h1>
<table class="table">
<thead>
<tr>
	<th>Question</th>

	<th>Tags</th>
</tr>
</thead>
<tbody>
<c:forEach items="${questions}" var="question">
    <tr>    
    <td><c:out value="${question.question}"/></td>

	<td><c:forEach items="${question.tags}" var="tag"><c:out value="${tag.subject} "/></c:forEach></td>
    </tr>
</c:forEach>
<p><a href="/questions/new">Ask a Question</a></p>
</tbody>
</table>
</body>
</html>