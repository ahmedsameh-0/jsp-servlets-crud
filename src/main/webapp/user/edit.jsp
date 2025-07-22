<%@page import="entity.User"%>
<%@page import="service.UserService"%>

<jsp:include page="../shared/header.jsp"/>
        <div class="card-header bg-warning text-dark">
            <h4 class="mb-0">Edit User</h4>
        </div>
        <form action="update-user" method="post">
            <div class="card-body">
                <div class="mb-3">
                    <label class="form-label">ID</label>
                    <input type="number" name="id" class="form-control" required minlength="3">
                </div>
                <div class="mb-3">
                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" name="name" class="form-control" required minlength="3">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="text" name="name" class="form-control" required minlength="3">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="text" name="name" class="form-control" required minlength="3">
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
                <a href="index.jsp" class="btn btn-secondary">Cancel</a>
                <button type="submit" class="btn btn-warning">Update</button>
            </div>
        </form>
<jsp:include page="../shared/footer.jsp.jsp"/>