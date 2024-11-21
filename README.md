# **Exam Registration Service**

A RESTful API built with Spring Boot to manage the exam enrollment process for a Learning Management System (LMS). This service supports CRUD operations for **Students**, **Subjects**, and **Exams**, with Foreign Key relationships and proper validation.

---

## **Features**
- **Student Management**:  
  - Add, view, and delete students.  
  - Enroll students in subjects and register them for exams.  

- **Subject Management**:  
  - Add, view, and delete subjects.  
  - Link students to subjects.  

- **Exam Management**:  
  - Create, view, and delete exams.  
  - Register students for exams.  

- **Easter Egg**:  
  - Generate random facts about numbers using the Numbers API via a hidden endpoint.

- **Error Handling**:  
  - Graceful handling of common errors with appropriate HTTP status codes.  

- **Testing**:  
  - Unit tests implemented with MockMvc and Mockito to ensure functionality.  

---

## **Technologies Used**
- **Backend**: Spring Boot  
- **Database**: MySQL  
- **Testing**: JUnit 5, Mockito, MockMvc  
- **API Integration**: Numbers API  
- **Build Tool**: Maven  
- **Version Control**: Git  

---

## **Setup Instructions**

### **Pre-requisites**
- Java 17+  
- MySQL  
- Maven  

### **Steps to Run**
1. **Clone the Repository**  
   ```bash
   git clone https://github.com/<your-username>/exam-registration-service.git
   cd exam-registration-service
