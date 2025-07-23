<% 
 request.setAttribute("pageTitle", "Add user");
%>
<jsp:include page="../shared/header.jsp"/>
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-success text-white">
            <h4 class="mb-0">Add New User</h4>
        </div>
        <form action="UserController" method="post">
            <input type="hidden" name="action" value="create-user">
            <div class="card-body">
                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" name="name" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="number" name="phoneNo" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="text" name="address" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" required>
                </div>
                 <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" required>
                </div>
            </div>
            <div class="card-footer text-end">
                <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">Cancel</a>
                <button type="submit" class="btn btn-success">Add</button>
            </div>
        </form>
   </div>
</div>
<jsp:include page="../shared/footer.jsp"/>