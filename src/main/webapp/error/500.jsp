<% 
 request.setAttribute("pageTitle", "INTERNAL_SERVER_ERROR");
%>
<jsp:include page="../shared/header.jsp"/>

<div class="container text-center mt-5">s
    <h1 class="display-1 text-warning">500</h1>
    <h3>Server Error</h3>
    <p>Oops! Something went wrong.</p>

    <% if (exception != null) { %>
        <div class="alert alert-danger mt-4 text-start" style="max-width:600px; margin:auto;">
            <strong>Error Details:</strong><br>
            <%= exception.getClass().getSimpleName() %>: <%= exception.getMessage() %>
        </div>
    <% } %>

    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mt-3">Back to Home</a>
</div>

<jsp:include page="../shared/footer.jsp"/>