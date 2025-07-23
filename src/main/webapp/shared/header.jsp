<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../static/css/style.css">
<!-- Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- DataTables -->       
        <link rel="stylesheet" href="https://cdn.datatables.net/2.3.2/css/dataTables.dataTables.css" />
        
        <title><%= request.getAttribute("pageTitle") != null ? request.getAttribute("pageTitle") : "My App" %></title>
    </head>
    <body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">A</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/user/add.jsp">Add User</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/user/edit.jsp">Edit User</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/user/list.jsp">All Users</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/">|</a>
        </li>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/auth/login.jsp">Login</a>
        </li>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/auth/register.jsp">Register</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">