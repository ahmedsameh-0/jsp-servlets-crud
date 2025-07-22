<jsp:include page="../shared/header.jsp"/>

  <form action="auth-register" method="post">
            <div class="card-body">
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" name="username" class="form-control" required>
                </div>
                 <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" required>
                </div>
            </div>
            <div class="card-footer text-end">
                <a href="index.jsp" class="btn btn-secondary">Sign up</a>
                <button type="submit" class="btn btn-success">Sign in</button>
            </div>
   </form>

<jsp:include page="../shared/footer.jsp"/>
