
# Course Management System (FMS)

This is a Course Management System (FMS) built using Spring Boot, designed to manage courses, trainers, and training programs. It provides RESTful APIs to perform CRUD operations and manage various aspects of the system.

## Project Structure

The project is structured into different packages, each serving a specific purpose:

- **`controller`**: Contains REST controllers for handling HTTP requests related to courses, trainers, and training programs.
- **`dto`**: Contains Data Transfer Objects for transferring data between layers.
- **`entites`**: Contains entity classes representing database tables.
- **`exception`**: Contains custom exceptions.
- **`repository`**: Contains Spring Data JPA repositories for database access.
- **`service`**: Contains service interfaces and implementations for business logic.
- **`util`**: Contains utility classes for data transformation.

## API Endpoints

### Course Management

- **Add Course**
  - `POST /api/course`
  - Request Body: `CourseDto`
  - Response: `CourseDto`

- **Update Course**
  - `PUT /api/course`
  - Request Body: `CourseDto`
  - Response: `CourseDto`

- **Remove Course**
  - `DELETE /api/course/{courseId}`
  - Path Variable: `courseId`
  - Response: `CourseDto`

- **View Course**
  - `GET /api/course/{courseId}`
  - Path Variable: `courseId`
  - Response: `CourseDto`

- **View All Courses**
  - `GET /api/course/list`
  - Response: `List<CourseDto>`

### Trainer Management

- **Add Trainer**
  - `POST /api/emp`
  - Request Body: `EmployeeDto`
  - Response: `EmployeeDto`

- **Update Trainer**
  - `PUT /api/emp`
  - Request Body: `EmployeeDto`
  - Response: `EmployeeDto`

- **Remove Trainer**
  - `DELETE /api/emp/{id}`
  - Path Variable: `id`
  - Response: `EmployeeDto`

- **View Trainer**
  - `GET /api/emp/{id}`
  - Path Variable: `id`
  - Response: `EmployeeDto`

- **View All Trainers by Skill**
  - `GET /api/emp/skills/{Skills}`
  - Path Variable: `Skills`
  - Response: `List<EmployeeDto>`

- **View All Trainers**
  - `GET /api/emp/viewall`
  - Response: `List<EmployeeDto>`

### Program Management

- **Create Program**
  - `POST /api/program/add`
  - Request Body: `Program`
  - Response: `Program`

- **Update Program**
  - `PUT /api/program/update`
  - Request Body: `Program`
  - Response: `Program`

- **Remove Program**
  - `DELETE /api/program/delete/{id}`
  - Path Variable: `id`

- **View Program**
  - `GET /api/program/view/{id}`
  - Path Variable: `id`
  - Response: `Optional<Program>`

- **View All Programs**
  - `GET /api/program/list`
  - Response: `List<Program>`

- **View All Programs by ID**
  - `GET /api/program/views/{programId}`
  - Path Variable: `programId`
  - Response: `List<Program>`

- **View All Programs by Date**
  - `GET /api/program/bydate/{date}`
  - Path Variable: `date`
  - Response: `List<Program>`

- **View All Programs by Faculty ID**
  - `GET /api/program/empid/{id}`
  - Path Variable: `id`
  - Response: `List<Program>`

## Dependencies

- Spring Boot
- Spring Data JPA
- Spring Web
- H2 Database (for testing; replace with your preferred database in production)

## Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```bash
   cd <project-directory>
   ```

3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. The application will start on `http://localhost:8080`.

## Testing

You can test the API endpoints using tools like Postman or curl.
