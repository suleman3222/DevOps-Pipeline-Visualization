# DevOps Pipeline Visualization

## Project Overview
DevOps Pipeline Visualization is a Java-based academic project that demonstrates a complete CI/CD workflow using industry-standard DevOps tools. The project visualizes how source code is automatically built, tested, containerized, and deployed. It also stores and displays pipeline execution data to ensure data integrity and consistency.

---

## Objectives
- Understand CI/CD concepts through practical implementation
- Automate build, test, and deployment processes
- Visualize DevOps pipeline stages clearly
- Maintain data integrity and consistency
- Provide visual representations and summary outputs

---

## Tech Stack
- Programming Language: Java (Spring Boot)
- Build Tool: Maven
- CI Tool: Jenkins
- Containerization: Docker
- Database: MongoDB
- Version Control: Git & GitHub
- Deployment: Docker

---

## Project Structure
DevOps-Pipeline-Visualization/
├── src/
├── screenshots/
│ ├── mongodb_pipeline_stages.png
│ └── pipeline_visualizer_ui.png
├── Dockerfile
├── Jenkinsfile
├── pom.xml
├── README.md

yaml
Copy code

---

## CI/CD Pipeline Flow
1. Developer pushes code to GitHub
2. Jenkins automatically triggers the CI pipeline
3. Maven builds the application
4. Automated tests are executed
5. Docker image is created
6. Application is deployed using Docker
7. Pipeline execution status is stored and visualized

---

## Visual Representation & Outputs

### 1. Pipeline Data Storage (MongoDB)
This output shows pipeline execution details stored in MongoDB, including stage name, status, execution duration, and logs. This confirms data integrity and consistency of pipeline runs.

![MongoDB Pipeline Stages](screenshots/mongodb_pipeline_stages.png)

### 2. DevOps Pipeline Visualizer – Web Output
The web interface visually represents pipeline stages with success/failure status and execution details. It also provides a summary view of recent pipeline runs.

![Pipeline Visualizer UI](screenshots/pipeline_visualizer_ui.png)

---

## How to Run the Project

### Prerequisites
- Java 8 or above
- Maven
- Docker
- Jenkins
- Git

### Steps
1. Clone the repository  
   `git clone <GitHub_Repository_Link>`

2. Navigate to the project directory  
   `cd DevOps-Pipeline-Visualization`

3. Build the project  
   `mvn clean install`

4. Build Docker image  
   `docker build -t devops-pipeline-app .`

5. Run Docker container  
   `docker run -p 8080:8080 devops-pipeline-app`

6. Access the application in browser  
   `http://localhost:8080`

---

## Code Quality & Standards
- Modular and well-structured code
- Proper comments for clarity
- Follows Java and DevOps best practices
- Clear and consistent documentation

---

## Submission Compliance
- GitHub repository is public and accessible
- Code is up-to-date
- README clearly explains setup and execution
- Visual representations included as required
- Data integrity and consistency ensured

---

## Author
Name: Suleman Shaik  
Project Type: Academic – DevOps CI/CD Pipeline Project

---

## GitHub Repository Link
[<Add your GitHub repository link here before submission>](https://github.com/suleman3222/DevOps-Pipeline-Visualization)
