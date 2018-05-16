
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Submit a Question</title>
</head>
<body>
	<h1>What is your question?</h1>
	<p><form:form method="POST" action="/questions/new" modelAttribute="query">
    <form:label path="question">Question
    <form:errors path="question"/>
    <form:textarea path="question"></form:textarea>
    </form:label></p>
	<p>Tags <input type="text" name="input_tags"/></p>


    

    <p><input type="submit" value="Submit Question"/></p>
</form:form>
	
</body>
</html>