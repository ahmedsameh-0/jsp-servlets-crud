<%@page import="entity.User"%>
<%@page import="service.UserService"%>
<%@page import="java.util.List"%>
<%
    List<User> users = (List<User>) request.getAttribute("listUser");
%>
<jsp:include page="../shared/header.jsp"/>
     
    <div class="card shadow">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h4 class="mb-0">All Users</h4>
        </div>
         
        <div class="card-body">
            <table class="table table-striped table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th style="width: 120px;">Actions</th>
                    </tr>
                </thead>
                <tbody>
<%                    if (users != null && !users.isEmpty()) {
                        for (User user : users) {
%>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getFullName()%></td>
                        <td><%= user.getPhoneNo()%></td>
                        <td><%= user.getAddress()%></td>
                        <td><%= user.getEmail()%></td>
                        <td><%= user.getPassword()%></td>
                        <td>
                            <a href="delete-user?id=<%= user.getId() %>" class="btn btn-sm btn-danger"
                               onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                        </td>
                    </tr>
<%
        }
    } else {
%>
                    <tr>
                        <td colspan="4" class="text-center">No users found</td>
                    </tr>
<%
    }
%>
                </tbody>
             </table>
        </div>
    </div>

<jsp:include page="../shared/footer.jsp"/>