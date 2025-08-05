# OneBill - Ecommerce and Order Management System

A complete, full-stack billing and inventory management system designed to automate and streamline retail operations.

## Badges

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![React](https://img.shields.io/badge/React-18.x-blue?logo=react)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange?logo=mysql)
![AWS S3](https://img.shields.io/badge/AWS%20S3-orange?logo=amazonaws)
![Docker](https://img.shields.io/badge/Docker-blue?logo=docker)
## 📖 About The Project

OneBill is a comprehensive, real-world application built to solve the daily challenges faced by retail businesses. It provides a robust platform for managing sales, generating invoices, tracking inventory in real-time, and processing payments seamlessly.

The system is architected with a secure, stateless backend using **Spring Boot** and a responsive, dynamic frontend using **React.js**, ensuring a reliable and user-friendly experience for both administrators and cashiers. This project demonstrates a full software development lifecycle, from system design and database integration to securing APIs and integrating third-party services.## 📸 Screenshots

<table>
<tr>
  <td align="center"><strong>Admin Dashboard</strong></td>
  <td align="center"><strong>Login</strong></td>
</tr>
<tr>
  <td><img src="https://drive.google.com/uc?export=view&id=1r7V-tGjwvM-j7h1NhgWxb6rDQTER6Gzb" width="100%"></td>
  <td><img src="https://drive.google.com/uc?export=view&id=1_DQo63sWkhAB396EgvHbPfubn6k2wf89" width="100%"></td>

</tr>
  <tr>
    <td align="center"><strong>Point of Sale (POS) Interface</strong></td>
    <td align="center"><strong>Inventory Management</strong></td>
  </tr>
  <tr>
    <td><img src="https://drive.google.com/uc?export=view&id=165jFdrjQyI6XXq7LSixSpwEkFr2jLqQF" width="100%"></td>
    <td><img src="https://drive.google.com/uc?export=view&id=1iMfG9zAfRX2vaJVP_IrI6xbEDqfxRaR4" width="100%"></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><img src="https://drive.google.com/uc?export=view&id=15yOcnNmrBTmwnZcOZuvs6yRJPnyfOL-p" width="100%"></td>
  </tr>
  <tr>
    <td align="center" colspan="2"><strong>Generated Invoice</strong></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><img src="https://drive.google.com/uc?export=view&id=12FlPG9v_qKTC7EW91ZA_NCsnh-kxHUhs" width="100%"></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><img src="https://drive.google.com/uc?export=view&id=1XVyt7TSsv-Qe-CYq4hQ1lEnYsv72_Ine" width="100%"></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><img src="https://drive.google.com/uc?export=view&id=1KEcfyViCGOaH1JRNsP24p8FO7Nl3VpbX" width="100%"></td>
  </tr>
</table>

## ✨ Key Features

* **Secure Authentication:** JWT-based secure login system for authorized access.
* **Role-Based Access Control:** Separate dashboards and permissions for `Admin` and `Cashier` roles.
    * **Admin:** Full access to inventory management, sales reports, and user management.
    * **Cashier:** Access limited to the billing system and invoice generation.
* **Real-Time Product Cart:** Dynamically add, update, and remove items from the cart.
* **Automated Invoice Generation:** Instantly generate and print professional invoices for sales transactions.
* **Inventory Management:** A complete CRUD (Create, Read, Update, Delete) system for managing products and stock levels.
* **Payment Gateway Integration:** Seamlessly process payments using the **Razorpay API**, including secure signature verification.
* **Cloud Storage:** Integrated with **AWS S3** for storing product images securely in the cloud.
* **Dashboard Analytics:** A dedicated endpoint that aggregates real-time sales data and recent order history.
## 🚀 Tech Stack

The project is built using a modern, scalable technology stack:

* **Backend:** Java 21, Spring Boot, Spring Security, Spring Data JPA (Hibernate)
* **Frontend:** React.js, HTML5, CSS3
* **Database:** MySQL
* **Security:** JSON Web Tokens (JWT)
* **Cloud Services:** AWS S3
* **Payment Gateway:** Razorpay
* **Build & Dependency:** Maven
* **Containerization:** Docker
## 🏁 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

* Java (JDK 21)
* Maven
* Node.js & npm
* MySQL Server
* Docker (Optional, for containerized deployment)

### Backend Installation

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/Ankit0217/onebill.git](https://github.com/Ankit0217/onebill.git)
    cd onebill
    ```
2.  **Create a MySQL database:**
    ```sql
    CREATE DATABASE onebilldb;
    ```
3.  **Configure Environment Variables:**
    Create an `application.properties` file in `src/main/resources` or set environment variables with your credentials:
    ```properties
    # Database
    SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/onebilldb
    SPRING_DATASOURCE_USERNAME=your_db_user
    SPRING_DATASOURCE_PASSWORD=your_db_password
    SPRING_JPA_HIBERNATE_DDL_AUTO=update

    # Services
    AWS_ACCESS_KEY=your_aws_key
    AWS_SECRET_KEY=your_aws_secret
    AWS_REGION=your_aws_region
    AWS_BUCKET_NAME=your_s3_bucket
    JWT_SECRET_KEY=your_jwt_secret
    RAZORPAY_KEY_ID=your_razorpay_id
    RAZORPAY_KEY_SECRET=your_razorpay_secret
    ```
4.  **Run the application:**
    ```sh
    ./mvnw spring-boot:run
    ```

### Frontend Installation

1.  **Navigate to the frontend directory:**
    *(Assuming your React code is in a `frontend` subfolder)*
    ```sh
    cd frontend
    ```
2.  **Install NPM packages:**
    ```sh
    npm install
    ```
3.  **Start the development server:**
    ```sh
    npm start
    ```

---

### **6. API Endpoints Section**

This makes your API understandable.

```markdown
⚙️ API Endpoints

A brief overview of the core API endpoints.

| HTTP Method | Endpoint                 | Description                                    | Access      |
|-------------|--------------------------|------------------------------------------------|-------------|
| `POST`      | `/login`                 | Authenticates a user and returns a JWT.        | Public      |
| `POST`      | `/admin/register`        | Registers a new user (Admin only).             | Admin       |
| `GET`       | `/categories`            | Fetches all product categories.                | Authenticated |
| `POST`      | `/admin/items`           | Adds a new item to the inventory.              | Admin       |
| `GET`       | `/items`                 | Fetches all items.                             | Authenticated |
| `POST`      | `/orders`                | Creates a new order.                           | Authenticated |
| `POST`      | `/payments/create-order` | Creates a Razorpay payment order.              | Authenticated |
| `POST`      | `/payments/verify`       | Verifies the payment signature.                | Authenticated |
| `GET`       | `/dashboard`             | Gets aggregated sales and order data.          | Authenticated |

```
## 📄 License

Distributed under the MIT License. See `LICENSE.txt` for more information.
## Documentation

[Documentation](https://linktodocumentation)

