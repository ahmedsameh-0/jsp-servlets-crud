<% 
 request.setAttribute("pageTitle", "FORBIDDEN");
%>
<jsp:include page="../shared/header.jsp"/>

<div class="container d-flex flex-column align-items-center justify-content-center" style="min-height: 80vh;">
    <h1 class="display-1 text-danger fw-bold">403</h1>
    <p class="fs-4 text-secondary">Access Denied: You don’t have permission to access this page.</p>
 <a href="<%= request.getContextPath() %>/auth/login.jsp" class="btn btn-outline-danger mt-3">
        Back to Login
    </a>
</div>
 
<jsp:include page="../shared/footer.jsp"/>