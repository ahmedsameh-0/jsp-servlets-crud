<% 
 request.setAttribute("pageTitle", "NOT_FOUND");
%>
<jsp:include page="../shared/header.jsp"/>

<div class="container text-center mt-5">
    <h1 class="display-1 text-danger">404</h1>
    <h3>Page Not Found</h3>
    <p>The page you are looking for doesn't exist or has been moved.</p>
    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary mt-3">Go to Home</a>
</div>
    
<jsp:include page="../shared/footer.jsp"/>