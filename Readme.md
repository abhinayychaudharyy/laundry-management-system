# Laundry Management System

A full-stack web application for managing laundry services, built with Spring Boot and Next.js.

## 🚀 Features

- User Authentication (Student & Staff)
- Order Management
- QR Code Generation & Scanning
- Order Tracking
- Staff Dashboard
- Student Dashboard
- Real-time Order Status Updates
- Payment Integration

## 🛠️ Technologies Used

### Backend
- Java 17
- Spring Boot 3.4.4
- MySQL Database
- Maven
- Thymeleaf Template Engine

### Frontend
- Next.js
- TypeScript
- Tailwind CSS
- React

## 📋 Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Node.js 14 or higher
- Maven

## 🔧 Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/abhinayychaudharyy/laundry-management-system.git
   cd laundry-management-system
   ```

2. **Database Setup**
   - Create a MySQL database named `spinx`
   - Update database credentials in `src/main/resources/application.properties` if needed

3. **Backend Setup**
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

4. **Frontend Setup**
   ```bash
   cd frontend
   npm install
   npm run dev
   ```

## 🔐 Default Credentials

### Staff Login
- Email: staff@bennett.edu.in
- Password: staffbu123

### Student Login
- Register as a new student
- Use your college email for registration

## 📱 Application Access

- Main Application: http://localhost:8080
- Login Page: http://localhost:8080/login
- Registration: http://localhost:8080/register
- Dashboard: http://localhost:8080/dashboard

## 🎯 Project Structure

```
laundry-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/spinx/
│   │   │       ├── controllers/
│   │   │       ├── models/
│   │   │       ├── repositories/
│   │   │       └── services/
│   │   └── resources/
│   │       ├── static/
│   │       └── templates/
├── frontend/
│   ├── components/
│   ├── pages/
│   └── public/
└── pom.xml
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

- Abhinay Chaudhary - Initial work

## 🙏 Acknowledgments

- Spring Boot Team
- Next.js Team
- All contributors who have helped in the development
