<jsp:include page="../shared/header.jsp"/>

<form action="auth-login" method="post">
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
                <button type="submit" class="btn btn-success">Sign in</button>
                <a href="index.jsp" class="btn btn-secondary">Sign up</a>
            </div>
   </form>
 <div style="color: red; background-color: #ffe0e0; padding: 10px; margin-bottom: 15px; border-radius: 5px;">
${error}
    </div>
<jsp:include page="../shared/footer.jsp"/>
