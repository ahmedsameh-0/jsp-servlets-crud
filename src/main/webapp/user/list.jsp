<%@page session="true"%>
<%
    request.setAttribute("pageTitle", "List Users");
%>
<jsp:include page="../shared/header.jsp"/>

    <div class="card shadow">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h4 class="mb-0">All Users</h4>
    </div>
         
    <div class="card-body">
        <table id="userTable" class="display">
        <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Phone Number</th>
        <th>Address</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    </thead>
</table>
        </div>
    </div>

<jsp:include page="../shared/footer.jsp"/>

<script>
    
    $(document).ready(function () {
        $('#userTable').DataTable({
            "ajax": {
                url: '${pageContext.request.contextPath}/UserController?action=list-json',
                "dataSrc": function(json) {
                    console.log("DataTables received JSON:", json);
                        return json.data || [];
                }
            },
            "columns": [
                { "data": "id" },
                { "data": "fullName" },
                { "data": "phoneNo" },
                { "data": "address" },
                { "data": "email" },
                { "data": "password" } 
            ]
        });
    });

</script>
