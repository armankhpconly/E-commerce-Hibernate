# Hibernate E-Commerce System

A modular, layered Java backend built using **Hibernate ORM** and **PostgreSQL**, modeling a simplified e-commerce platform.
This project demonstrates real-world backend architecture using DAO, Service Layer, and Entity relationships.

---

## 🚀 Features

* Customer Management (Create, Read, Update, Delete)
* Address Management (Used for Customer and Order delivery)
* Category & Product Management
* Product linking through Category (Unidirectional 1 → Many)
* Order Placement with multiple Order Items
* Clean Layered Architecture (Controller → Service → DAO → Entity)
* Console-based UI with menu-driven operations

---

## 🧱 Project Architecture

```
Controller  (Driver)
     ↓
Service Layer       → business logic, validation, object creation
     ↓
DAO Layer           → DB operations via EntityManager
     ↓
Hibernate ORM       → entity mapping & persistence
     ↓
PostgreSQL          → relational database
```

---

## 🗂️ Entity Structure & Relationships

### **Customer**

* `customer_id`, `name`, `email`
* **One-to-One → Address** (unidirectional)

### **Address**

* `address_id`, `city`, `pincode`
* Reused by Customer and Order

### **Category**

* `category_id`, `category_name`
* **One-to-Many → Product** (unidirectional, owns FK via `@JoinColumn`)

### **Product**

* `productId`, `name`, `price`, `categoryId`
* Belongs to Category
* Used inside OrderItem

### **Order**

* `orderId`, `orderDate`
* **One-to-One → Address** (delivery address)
* **One-to-Many → OrderItem**

### **OrderItem**

* `orderItemId`, `quantity`
* **Many-to-One → Product**
* Linked back to Order via FK

---

## 🔗 Relationship Diagram

```
Customer ----1:1----> Address <----1:1---- Order ----1:M----> OrderItem ----M:1----> Product ----M:1----> Category
```

---

## 📁 Folder Structure (Simplified)

```
src/
 ├── com.controller/
 │     └── Driver.java
 ├── com.service/
 │     ├── CustomerService.java
 │     ├── CustomerServiceImpl.java
 │     ├── CategoryService.java
 │     ├── CategoryServiceImpl.java
 │     ├── ProductService.java
 │     ├── ProductServiceImpl.java
 │     ├── OrderService.java
 │     └── OrderServiceImpl.java
 ├── com.dao/
 │     ├── CustomerDao.java
 │     ├── CustomerDaoImpl.java
 │     ├── CategoryDao.java
 │     ├── CategoryDaoImpl.java
 │     ├── ProductDao.java
 │     ├── ProductDaoImpl.java
 │     ├── OrderDao.java
 │     └── OrderDaoImpl.java
 ├── com.dto/
 │     ├── Customer.java
 │     ├── Address.java
 │     ├── Category.java
 │     ├── Product.java
 │     ├── Order.java
 │     └── OrderItem.java
 └── utility/
        └── Utility.java
```

---

## 🛠️ How to Run the Project

### **1. Setup PostgreSQL**

Create a database:

```sql
CREATE DATABASE hibernate_ecommerce;
```

### **2. Configure Connection**

Update your `persistence.xml`:

```xml
<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/hibernate_ecommerce" />
<property name="javax.persistence.jdbc.user" value="postgres" />
<property name="javax.persistence.jdbc.password" value="yourpassword" />
```

### **3. Run Application**

Run the `Driver` class and follow the console menu.

---

## 📚 Key Hibernate Concepts Used

* @Entity, @Id, @GeneratedValue
* @OneToOne, @OneToMany, @ManyToOne
* @JoinColumn, FK handling
* Unidirectional relationships
* persist() vs merge()
* Detached vs Managed entity states
* Layered architecture best practices

---

## 🌱 Future Enhancements

* Add Customer ↔ Order mapping
* Introduce cascade types
* Convert to Spring Boot REST API
* Add authentication & JWT
* Add pagination & sorting
* Add unit tests

---

## ✨ Author

**Arman Khan**

Project created as a structured learning implementation of Hibernate ORM.
