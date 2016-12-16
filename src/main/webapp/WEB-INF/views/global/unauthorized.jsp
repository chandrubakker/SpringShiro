<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	YOU ARE NOT AUTHORIZED.
</div>
<div>
	<c:url value="/" var="home"></c:url>
	<a href="${home}">Go To Home</a>
</div>