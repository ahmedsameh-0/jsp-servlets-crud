<% 
 request.setAttribute("pageTitle", "Register");
%>
<%@page session="true"%>
<jsp:include page="../shared/header.jsp"/>

  <form action="${pageContext.request.contextPath}/AuthController" method="post">
      <input type="hidden" name="action" value="register">
            <div class="card-body">
                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" name="fullName" class="form-control" required>
                </div>
                 <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="password" name="phoneNo" class="form-control" >
                </div>
                 <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="password" name="address" class="form-control" >
                </div>
                 <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="password" name="email" class="form-control" required>
                </div>
                 <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" required>
                </div>
            </div>
            <div class="card-footer text-end">
                <button type="submit" class="btn btn-success">Sign Up</button>
                <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">Cancel</a>
            </div>
   </form>

<jsp:include page="../shared/footer.jsp"/>
