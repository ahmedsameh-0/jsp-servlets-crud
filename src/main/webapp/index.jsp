<jsp:include page="../includes/header.jsp"/>
<%
    String username = (String) session.getAttribute("username");
//    if (username == null) {
////        response.sendRedirect("login.jsp");
//        return;
//    }
%>
<p class="fw-bold">Welcome {$username} 👋</p>

<jsp:include page="../includes/footer.jsp"/>