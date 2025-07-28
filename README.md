OneBill – Retail Billing & Inventory Management System

A complete, full-stack billing and inventory management system designed to automate and streamline retail operations.

                                                                    About • Features •Tech Stack •Getting Started •API Endpoints •Screenshots

📖 About The Project
OneBill is a comprehensive, real-world application built to solve the daily challenges faced by retail businesses. It provides a robust platform for managing sales, generating invoices, tracking inventory in real-time, and processing payments seamlessly. The system is architected with a secure back-end using Spring Boot and a responsive, dynamic front-end using React.js, ensuring a reliable and user-friendly experience for both administrators and cashiers.

This project demonstrates a full software development lifecycle, from system design and database integration to securing APIs and integrating third-party services.

✨ Key Features
Secure Authentication: JWT-based secure login system for authorized access.

Role-Based Access Control: Separate dashboards and permissions for Admin and Cashier roles.

Admin: Full access to inventory management, sales reports, and user management.

Cashier: Access limited to the billing system and invoice generation.

Real-Time Product Cart: Dynamically add, update, and remove items from the cart.

Automated Invoice Generation: Instantly generate and print professional invoices for sales transactions.

Inventory Management: A complete CRUD (Create, Read, Update, Delete) system for managing products and stock levels.

Payment Gateway Integration: Seamlessly process payments using the Razorpay API.

Cloud Storage: Integrated with AWS S3 for storing invoices and other related files securely in the cloud.


🚀 Tech Stack
The project is built using a modern, scalable technology stack:


Of course, my apologies for the misunderstanding. Enhancing your GitHub repository with a professional and detailed README.md file is crucial. A great README makes your project stand out to recruiters and other developers.

Here is a comprehensive, well-structured template for your README.md file. You can copy and paste this directly into the README.md file in your "OneBill" GitHub repository.

OneBill – Retail Billing & Inventory Management System

A complete, full-stack billing and inventory management system designed to automate and streamline retail operations.


About •
Features •
Tech Stack •
Getting Started •
API Endpoints •
Screenshots

📖 About The Project
OneBill is a comprehensive, real-world application built to solve the daily challenges faced by retail businesses. It provides a robust platform for managing sales, generating invoices, tracking inventory in real-time, and processing payments seamlessly. The system is architected with a secure back-end using Spring Boot and a responsive, dynamic front-end using React.js, ensuring a reliable and user-friendly experience for both administrators and cashiers.

This project demonstrates a full software development lifecycle, from system design and database integration to securing APIs and integrating third-party services.

✨ Key Features
Secure Authentication: JWT-based secure login system for authorized access.

Role-Based Access Control: Separate dashboards and permissions for Admin and Cashier roles.

Admin: Full access to inventory management, sales reports, and user management.

Cashier: Access limited to the billing system and invoice generation.

Real-Time Product Cart: Dynamically add, update, and remove items from the cart.

Automated Invoice Generation: Instantly generate and print professional invoices for sales transactions.

Inventory Management: A complete CRUD (Create, Read, Update, Delete) system for managing products and stock levels.

Payment Gateway Integration: Seamlessly process payments using the Razorpay API.

Cloud Storage: Integrated with AWS S3 for storing invoices and other related files securely in the cloud.

🚀 Tech Stack
The project is built using a modern, scalable technology stack:

Front-End	Back-End	Database	Cloud & APIs


📸 Screenshots

Good examples include the login page, admin dashboard, billing interface, and inventory page.




🛠️ Getting Started
Follow these instructions to set up the project locally on your machine.

Prerequisites
Java Development Kit (JDK) 11 or higher

Apache Maven

Node.js and npm

MySQL Server

An AWS account with S3 bucket credentials

A Razorpay account with API keys

Installation
Clone the repository:
bash
git clone https://github.com/Ankit0217/onebill.git
cd onebill
Configure the Back-End (Spring Boot):

Open the src/main/resources/application.properties file.

Update the MySQL database URL, username, and password:

Properties

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
Add your JWT secret key, AWS credentials, and Razorpay keys:

Properties

jwt.secret=your_jwt_secret
aws.accessKeyId=your_aws_access_key
aws.secretKey=your_aws_secret_key
razorpay.keyId=your_razorpay_key_id
razorpay.keySecret=your_razorpay_key_secret
Run the backend server:

bash
mvn spring-boot:run
The server will start on http://localhost:8080.

Configure the Front-End (React):

Navigate to the frontend directory (e.g., cd frontend):

Bash

cd path/to/your/frontend_directory
Install the required npm packages:

Bash

npm install
Start the React development server:

Bash

npm start
The application will be accessible at http://localhost:3000.



 API Endpoints

Here are some of the key API endpoints available:

⚙️ Method	Endpoint	Description
POST	/api/auth/login	Authenticate a user and receive a JWT.
GET	/api/products	Fetch a list of all products.
POST	/api/products	Add a new product (Admin only).
GET	/api/invoices/{invoiceId}	Get details of a specific invoice.
POST	/api/invoices/generate	Generate a new invoice from the cart.
POST	/api/payments/create_order	Create a payment order with Razorpay.



📧 Contact
Ankit Jain - LinkedIn - www.linkedin.com/in/ankitjain0217
Email: ankit.jain.0217@gmail.com

Project Link: https://github.com/Ankit0217/onebill
Live : https://onebill-ashy.vercel.app/

