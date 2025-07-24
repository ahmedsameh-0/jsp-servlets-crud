<% 
 request.setAttribute("pageTitle", "Login");
%>
<%@page session="true"%>
<jsp:include page="../shared/header.jsp"/>

<form action="${pageContext.request.contextPath}/AuthController" method="post">
    <input type="hidden" name="action" value="login">
            <div class="card-body">
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" name="email"class="form-control" required>
                </div>
                 <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" required>
                </div>
            </div>
            <div class="card-footer text-end">
                <button type="submit" class="btn btn-success">Sign In</button>
                <a href="${pageContext.request.contextPath}/auth/register.jsp" class="btn btn-secondary">Sign up</a>
            </div>
   </form>
<jsp:include page="../shared/footer.jsp"/>
