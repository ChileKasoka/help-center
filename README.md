🧹 Help Center Management System
Overview

The Help Center Management System is a web-based ERP-style platform designed to digitally manage operations for a local cleaners’ center. It provides a structured way for administrators, staff, and clients to interact, manage tasks, and track activities — all in one centralized system.

The goal is to automate and simplify day-to-day operations such as:

Registering and managing cleaners and clients

Assigning cleaners to cleaning tasks or companies

Tracking work progress and availability

Managing users with proper roles and access control

🎯 Purpose and Goals

Local help centers often rely on paper-based or spreadsheet systems to manage workers (cleaners), clients, and schedules. This leads to inefficiency, human error, and lack of transparency.

This system aims to:

Digitize operations — everything from client registration to work assignment happens online.

Provide controlled access using role-based access control (RBAC).

Allow scalability — it can later support multiple help centers or companies.

Provide real-time data visibility for administrators and clients.

Offer a modular architecture (with clear separation between backend, frontend, and database).

🏗️ System Architecture
🧠 Backend

Language: Java

Framework: Spring boot mvn

Architecture: Controller → Service → Repository

Database: PostgreSQL

Authentication: JWT-based + Spring Security

Authorization: Role-Based Access Control (RBAC) spring security injection

Mailing: (Optional) Brevo for transactional emails

Core modules:

User Management: Create, update, delete users; assign roles (Admin, Staff, Client, Cleaner).

Role Management: Admins can create new roles and assign permissions based on REST actions( future enhancement)

Client Management: Register and manage clients (individual or company).

Cleaner Management: Register cleaners, assign tasks, and manage their work schedules.

Company Management: For centers managing contracts with multiple organizations.

💻 Frontend

Framework: React js/ Vite/ Typescript

UI: Simple, clean, and responsive layout with modals for creating/viewing users and clients.

API Connection: Consumes REST API from Go backend (localhost:8080).

Features:

Dynamic pages for viewing and managing users, clients, and cleaners

Forms for registration (e.g., “Create Client”, “Register Cleaner”)

Role-aware UI (Admins see more options than regular users)


🧩 Key Features
Feature	Description
User Registration & Login	Secure signup/login with JWT authentication
Role-Based Access Control (RBAC)	Different user levels (Admin, Staff, Client, Cleaner) with permission-based access
Client Registration	Allows admins/staff to register new clients
Cleaner Management	Add, update, or assign cleaners to specific companies or clients
Company Management	Manage companies using cleaning services
System Users	Option to mark a user as a system-level account for administrative purposes
REST API Design	All backend logic exposed via clear REST endpoints for frontend consumption
Scalable Structure	Modular design allows adding future features like bookings, payments, or reporting
⚙️ Installation & Setup
Backend Setup

Clone the repository

git clone https://github.com/yourusername/help-center.git
cd help-center/backend


Configure your PostgreSQL database in .env file

DB_HOST=localhost
DB_PORT=5432
DB_USER=postgres
DB_PASSWORD=yourpassword
DB_NAME=help_center
JWT_SECRET=your_secret_key


Run migrations (if applicable)

go run migrations/migrate.go


Start the server

go run main.go


The backend runs on:
👉 http://localhost:8080

Frontend Setup (Vue.js)

Navigate to the frontend folder

cd help-center/frontend


Install dependencies

npm install


Run the development server

npm run dev


The frontend runs on:
👉 http://localhost:5173


🧠 Future Enhancements

Task scheduling and tracking

Payment and invoicing module

SMS/email notifications

Cleaner performance tracking and reporting dashboard

Multi-company support (franchise version)

🧾 Summary

The Help Center Management System provides an efficient, digital, and secure platform for managing cleaners, clients, and operations under a help center.
It brings structure, accountability, and scalability to an otherwise manual process — making it ideal for cleaning service agencies, domestic help centers, and facilities management organizations.