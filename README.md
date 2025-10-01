# Quiz Management System

This project is a simple **Quiz Application** made with Java.  
The idea is straightforward: there are **students** who can log in and take quizzes, and there is an **admin** who can manage the quiz questions and user accounts.  

Everything is stored in **JSON files** (like small databases in text form), so no big database setup is required.  
It’s just Java + JSON + console input/output.  

---

## What does it do?
- A student logs in with their username and password.  
- The system picks **10 random questions** from the quiz file.  
- Each question has 4 options, and the student selects one.  
- At the end, the student gets their **score** and a message about how well they did.  
- The admin can add new quiz questions or new users (students) into the system.  

---

## How is it built?
- **Java classes** handle different parts:
  - `LogIn.java` → lets users log in  
  - `StudentQuiz.java` → runs the quiz for students  
  - `AdminQuizManager.java` → admin can add or manage questions  
  - `WriteQuizJSON.java` → saves quiz data to a JSON file  
  - `WriteUsersJSON.java` → saves users to a JSON file  

- **Resources folder** contains the data:
  - `quiz.json` → where all quiz questions live  
  - `users.json` → where student login details are stored  

So, the code is the “engine,” and the JSON files are the “fuel.”

---

## Overview
This is a **role-based Quiz Management System** built using Java.  
It has two types of users:  

- 👨‍💼 **Admin** → Can add multiple-choice questions (MCQs) to the quiz bank.  
- 🎓 **Student** → Can log in and take a 10-question quiz.  

All data is stored in JSON files for persistence.

---

## User Accounts
- **Admin Account**  
  - Username: `admin`  
  - Password: `1234`  
  - Role: `admin`  

- **Student Account**  
  - Username: `salman`  
  - Password: `1234`  
  - Role: `student`  

---

## Features

### Admin Features
- Login with admin credentials.  
- Add MCQs with:
  - Question text  
  - 4 options  
  - Correct answer key  
- Questions are saved in `quiz.json`.  

### Student Features
- Login with student credentials.  
- Attempt **10 random questions** from the quiz bank.  
- Each correct answer = **1 mark**.  
- No negative marking.  
- At the end, a score message is shown:  
  - **8–10:** Excellent  
  - **5–7:** Good   
  - **3–4:** Very Poor  
  - **0–2:** Failed  

---

## File Structure
```text
main/
├── java/
│   ├── AdminQuizManager.java   # Admin adds questions
│   ├── LogIn.java              # User login and role selection
│   ├── StudentQuiz.java        # Quiz flow for students
│   ├── WriteQuizJSON.java      # Handles writing to quiz.json
│   └── WriteUsersJSON.java     # Handles writing to users.json
└── resources/
    ├── quiz.json               # Stores quiz questions
    └── users.json              # Stores usernames, passwords, roles
