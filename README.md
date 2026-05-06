# 🧩 Kanban Task Manager (Java CLI)

A command-line task manager built in Java that implements a **Kanban-style workflow** (TODO → DOING → DONE).
This project demonstrates strong **object-oriented design**, **state management**, and **file-based persistence**.

---
## 📖 Story Behind the Project

This project started as a **learning challenge**.

Coming from a C++ background, the goal was to **learn Java quickly through practice**, not just theory. Instead of following tutorials, the approach was to build a small but complete system that forces understanding of:

* Java syntax and structure
* Object-oriented design in a Java context
* Differences in memory handling and collections

At the same time, there was a personal motivation behind it.

Being highly organized, there was a need for a **simple, distraction-free tool** to manage daily tasks directly from the terminal. Most existing tools felt too heavy or overcomplicated for quick usage.

So this project became both:

* 🧠 A **learning vehicle** to transition from C++ to Java
* 🛠️ A **practical tool** used in day-to-day workflow

The result is a lightweight Kanban-style task manager that reflects both **technical growth** and **real-world utility**.

---


## 🚀 Features

* ✅ Create and manage tasks from the command line
* 🔄 Move tasks across workflow states (TODO, DOING, DONE)
* 💾 Persistent storage using file I/O (tasks saved between sessions)
* 🧠 Clean object-oriented architecture (separation of concerns)
* 📂 Lightweight and dependency-free (pure Java)

---

## 🏗️ Project Structure

```
.
├── Main.java           # Entry point (user interaction & menu)
├── Task.java           # Task model (data representation)
├── TaskManager.java    # Core logic (task operations & persistence)
├── Status.java         # Enum for task states (TODO, DOING, DONE)
├── tasks_sample.txt    # Example data file
├── .gitignore
└── README.md
```

---

## 🧠 Design Overview

This project follows a clean separation of responsibilities:

* **Task** → Represents a single task (data model)
* **Status** → Enum defining task states (state management)
* **TaskManager** → Handles all business logic (add, move, display, save/load)
* **Main** → Handles user interaction and program flow

This structure reflects real-world backend design principles.

---

## ⚙️ How It Works

### 1. Task Creation

Users can add tasks via CLI input.

### 2. State Management

Each task moves through:

```
TODO → DOING → DONE
```

### 3. Persistence

Tasks are saved to a file (`tasks.txt`) and reloaded when the program starts.

---

## 💾 File Storage Format

Tasks are stored in a simple CSV-like format:

```
Finish homework,TODO
Build project,DOING
Submit assignment,DONE
```

---

## ▶️ How to Run

### Compile:

```bash
javac Main.java
```

### Run:

```bash
java Main
```

---

## 🧪 Example Usage

```
1. Add Task
2. View Tasks
3. Move Task
4. Exit

Enter choice: 1
Enter task: Study Java

Enter choice: 2
=== TODO ===
0: Study Java
```

---

## 📌 Key Concepts Demonstrated

* Object-Oriented Programming (OOP)
* Encapsulation and separation of concerns
* Java Collections (`ArrayList`)
* File I/O (read/write)
* Enum-based state modeling
* CLI-based user interaction

---


## 🚀 Future Improvements

* 🎨 GUI version (desktop or web-based)
* 🗂️ Task categories or priorities
* 📅 Due dates and reminders
* 🔍 Search and filtering
* 🌐 Backend API version

---

## 👤 Author

Mariam Touré
Computer Science Student

---

## ⭐ Notes

* `tasks.txt` is generated at runtime and ignored by Git
* `tasks_sample.txt` is provided for testing

---

## 💡 Summary

This project goes beyond a simple “to-do app” by introducing:

* Structured architecture
* State-driven design
* Persistent data handling

It reflects the foundation of real-world software systems in a simple, practical format.

---
