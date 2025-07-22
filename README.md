# ⏱️ Time Tracker App

A full-stack time tracking application built with **Angular** and **Spring Boot**. This app allows users to manage tasks, track time spent on them, and store the data persistently.

---

## 📁 Project Structure

```
time-tracker-app/
├── frontend/   → Angular 17 App (Task Tracker UI)
└── backend/    → Spring Boot App (REST API + DB)
```

---

## 🚀 Features

- ✅ Create, delete, and manage tasks
- ✅ Start/stop time tracking per task
- ✅ Track total time spent on each task
- ✅ Store data in a database
- ✅ RESTful API with Spring Boot
- ✅ Angular-based responsive UI

---

## 🛠️ Tech Stack

### Frontend:
- Angular 17+
- TypeScript
- RxJS
- Angular Standalone Components
- Tailwind (optional)

### Backend:
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 / MySQL (pluggable)
- Lombok

---

## 🔧 Getting Started

### 🚨 Prerequisites
- Node.js + npm
- Angular CLI (`npm install -g @angular/cli`)
- Java 17+
- Maven

---

### 📦 Run Backend

```bash
cd backend
mvn spring-boot:run
```

> Server will run on: `http://localhost:8080`

---

### 💻 Run Frontend

```bash
cd frontend
npm install
ng serve
```

> App will be available at: `http://localhost:4200`

---

## 🧪 API Endpoints (Backend)

| Method | Endpoint                 | Description         |
|--------|--------------------------|---------------------|
| GET    | `/api/tasks`             | List all tasks      |
| POST   | `/api/tasks`             | Create a new task   |
| DELETE | `/api/tasks/{id}`        | Delete a task       |
| POST   | `/api/tasks/{id}/start`  | Start tracking      |
| POST   | `/api/tasks/{id}/stop`   | Stop tracking       |

---

## 📷 Screenshots *(optional)*

> Include UI screenshots here to showcase the app.

---

## 📌 Future Enhancements

- ✅ Timer-based auto stop
- ✅ User authentication
- ✅ Export tracked time to CSV
- ✅ Docker support

---

## 👩‍💻 Author

**Swarupa Pradhan**  
[GitHub Profile](https://github.com/SwarupaPradhan)

---

## 🪪 License

This project is licensed under the MIT License. See `LICENSE` for more info.
