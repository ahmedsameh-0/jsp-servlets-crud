<%@page import="entity.User"%>
<%
 request.setAttribute("pageTitle", "Welcome");
 User user = (User) session.getAttribute("user");
%>
<jsp:include page="shared/header.jsp"/>
<div class="container">
    <h2 class="fw-bold">Welcome, <%= user != null ? user.getFullName() : "Guest" %> 👋</h2>
    </div>
<jsp:include page="shared/footer.jsp"/>