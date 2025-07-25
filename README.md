# JSP CRUD Web Application

A simple and clean **JSP + Servlet + JDBC** CRUD (Create, Read, Update, Delete) web application following the MVC architecture. This project demonstrates basic operations on a database using JSP, Servlets with an Oracle database.

---

## 🚀 Features

- 🔄 Create, Read, Update, Delete Users
- 📦 MVC Structure (Model, View, Controller)
- 🧰 JDBC Connection Pooling (via JNDI)
- 🎨 Bootstrap 5 Styling
- 🔒 Servlet Filters for access control
- 📊 DataTables Integration for list view 

---

## 📁 Project Structure

```
jsp-sevlet-crud/
├── Web Pages/ 
│ ├── WEB-INF/
│ ├── auth/
│ ├── shared/
│ └── error/
│ └── user/
│ └── static/
├── src/
│ ├── controller/
│ ├── model/
│ ├── dto/
│ ├── service/
│ ├── util/
│ └── filter/
```

---

### 🗃️ Table Structure:

```sql
CREATE Table users (
	id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY NOT NULL PRIMARY KEY,
	fullName varchar2(255) NOT NULL,
	phoneNumber NUMBER,
	address varchar2(255),
	email varchar2(255) NOT NULL,
	password varchar2(255) NOT NULL
);
```

---

## 🛠️ Technologies Used

- Java 21
- JSP & Servlets
- JDBC (Oracle)
- GlassFish 7
- Bootstrap 5
- Maven 

---

## 📌 Architecture Flow:

```sql
  SOON
```

---

## 📸 Screenshot – Application :

-  SOON

---

## 🗺️ Roadmap

-  SOON
