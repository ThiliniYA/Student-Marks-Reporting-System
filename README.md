# Student Marks Reporting System (Java Console Application)

A Java console application that reads student data from a text file and generates clear, structured reports for teachers.  
The program processes raw student marks, calculates averages and grades, and provides multiple reporting options through a menu‑driven interface.

This project demonstrates my skills in Java, file handling, object‑oriented programming, and building practical console applications.

---

## 📌 Project Overview

Teachers often receive student marks in plain text files that are difficult to interpret.  
This application solves that problem by:

- Loading and parsing student data from `students.txt`
- Storing information using object‑oriented classes
- Providing a simple console menu for navigation
- Generating formatted reports for individual students and the entire class

The system supports seven subjects:
**Mathematics, Art, History, Science, Geography, Economics, Literature**

---

## 🎯 Features

### ✔ Load and parse student data  
Reads each line of the text file and converts it into a `Student` object with course marks.

### ✔ Display all students  
Shows a formatted table including:
- Student ID  
- Full name  
- Marks for all seven courses  
- Final average  

### ✔ Display an individual student  
Search by student ID and display their full report.

### ✔ Top student per course  
Identifies the highest‑scoring student(s) for each subject.

### ✔ Class report  
Displays:
- Total number of students  
- Average mark per course  
- Grade per course (A–E scale)  

### ✔ Menu‑driven interface  
- Accepts user input  
- Validates invalid entries  
- Returns to the menu after each action  

### ✔ Exit option  
Closes the program with a friendly message.

---

## 🧱 Class Structure

### **Main**
- Loads the data file  
- Displays the menu  
- Handles user input and navigation  

### **Student**
- Stores student ID, first name, last name  
- Holds course marks  
- Calculates averages and final grade  
- Provides formatted output for reports  

### **Course**
- Stores course name and mark  
- Represents each subject for each student  

### **Report**
- Generates individual student reports  
- Generates class‑level summaries  
- Converts marks to grades  
- Formats output for readability  

---

## 📁 Data File Format (`students.txt`)

Each line contains:
StudentID, FirstName, LastName, Math, Art, History, Science, Geography, Economics, Literature

Example:
7, John, Smith, 100, 89, 88, 78, 98, 99, 78


---

## ▶️ How to Run the Application

1. Place `students.txt` in the project directory  
2. Open the project in **Eclipse** or any Java IDE  
3. Run `Main.java`  
4. Use the console menu to navigate through reporting options  

---

## 🧠 What I Learned

This project strengthened my skills in:

- Java file handling (`BufferedReader`, `FileReader`)
- Parsing and validating data
- Object‑oriented programming (classes, constructors, methods)
- Working with lists and collections
- Designing user‑friendly console menus
- Formatting readable reports
- Debugging and problem‑solving

---

## 🚀 Future Improvements

Planned enhancements include:

- Sorting students by average or name  
- Exporting reports to a text file  
- Adding input validation for student IDs  
- Adding colour‑coded console output  
- Converting the system into a GUI application  

---

## 👤 About Me

I’m Thilini Amarasekara, a junior software tester and aspiring developer with a strong interest in building practical applications.  
This project reflects my ability to work with data, apply OOP principles, and create tools that improve user experience.




