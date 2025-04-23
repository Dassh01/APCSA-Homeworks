
# AP CS A - Java OOP and Polymorphism Project

## Project Overview
In this project, you will create a Java program that models a **real-world object** using **inheritance and polymorphism**. You will:

1. Create a **base class** with at least three instance variables.
2. Create at least **two subclasses** that override methods for **polymorphism**.
3. Override **`toString()`** to display object details.
4. Override **`equals(Object o)`** to compare objects meaningfully.
5. Use an **ArrayList** to store objects and demonstrate polymorphism in a **tester class**.

---

## Project Requirements

### 1. Choose a Real-World Object
Pick an object that allows for meaningful subclasses. Some examples:

- **Book** → Novel, Textbook
- **Animal** → Dog, Cat
- **Bank Account** → CheckingAccount, SavingsAccount
- **Vehicle** → Car, Motorcycle
- **Employee** → Manager, Developer

---

### 2. Create a Base Class
Your base class must include:
- **At least three private instance variables**.
- **Getter methods** to access private variables.
- A `toString()` method that prints attributes.
- An **`equals(Object o)`** method to compare objects.
- A method that can be **overridden in subclasses** to demonstrate polymorphism.

#### Example Base Class (`Book`)
```java
public class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public void read() {
        System.out.println("Reading \"" + title + "\" by " + author);
    }

    @Override
    public String toString() {
        return "Book[Title: " + title + ", Author: " + author + ", Pages: " + pages + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book other = (Book) o;
            return this.title.equals(other.title) && this.author.equals(other.author) && this.pages == other.pages;
        }
        return false;
    }
}
```

### 3. Create at Least Two Subclasses
Each subclass must:
- Extend the base class.
- Override at least **one method** to provide unique behavior.
- Implement at least **one additional attribute**.

#### Example Subclass (`Novel`)
```java
public class Novel extends Book {
    private String genre;

    public Novel(String title, String author, int pages, String genre) {
        super(title, author, pages);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void read() {
        System.out.println("Enjoying the novel \"" + getTitle() + "\" in the " + genre + " genre.");
    }

    @Override
    public String toString() {
        return "Novel[Title: " + getTitle() + ", Author: " + getAuthor() + ", Pages: " + getPages() + ", Genre: " + genre + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Novel) {
            Novel other = (Novel) o;
            return super.equals(other) && this.genre.equals(other.genre);
        }
        return false;
    }
}
```
#### Example Subclass (`Textbook`)
```java
public class Textbook extends Book {
    private String subject;

    public Textbook(String title, String author, int pages, String subject) {
        super(title, author, pages);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void read() {
        System.out.println("Studying \"" + getTitle() + "\" for " + subject + ".");
    }

    @Override
    public String toString() {
        return "Textbook[Title: " + getTitle() + ", Author: " + getAuthor() + ", Pages: " + getPages() + ", Subject: " + subject + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Textbook) {
            Textbook other = (Textbook) o;
            return super.equals(other) && this.subject.equals(other.subject);
        }
        return false;
    }
}
```

### 4. Use an ArrayList to Demonstrate Polymorphism
Instead of using a fixed-size array, store objects in an `ArrayList<Book>` to allow for dynamic additions and removals.

#### Example Tester Class (`LibraryTest`)

```java
import java.util.ArrayList;

public class LibraryTest {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Novel("The Hobbit", "J.R.R. Tolkien", 310, "Fantasy"));
        books.add(new Textbook("Introduction to Java", "John Doe", 500, "Computer Science"));
        books.add(new Novel("The Hobbit", "J.R.R. Tolkien", 310, "Fantasy"));

        // Loop through books and demonstrate polymorphism
        for (Book b : books) {
            System.out.println(b); // Calls overridden toString()
            b.read(); // Calls overridden read() method
        }

        // Checking equality
        System.out.println("\nComparing books:");
        System.out.println("books.get(0) equals books.get(2): " + books.get(0).equals(books.get(2))); // true
        System.out.println("books.get(0) equals books.get(1): " + books.get(0).equals(books.get(1))); // false
    }
}
```

## Grading Criteria

### **Code Implementation (50 Points)**
| **Category**       | **Points** | **Description** |
|--------------------|------------|----------------|
| **Base Class**     | 10         | Defines a real-world object with three attributes, getters, `toString()`, and `equals()`. |
| **Two Subclasses** | 10         | Each subclass adds an attribute and overrides at least one method. |
| **Method Overriding** | 10      | `toString()`, `equals()`, and at least one other method are overridden. |
| **Encapsulation**  | 10         | Uses `private` variables with `public` getters. |
| **ArrayList Usage** | 10        | Objects are stored in an `ArrayList` and iterated using a loop. |

### **Program Behavior & Readability (10 Points)**
| **Category**           | **Points** | **Description** |
|------------------------|------------|----------------|
| **Polymorphism**       | 5          | Methods are called dynamically using the base class reference. |
| **Code Readability**   | 5          | Proper indentation, meaningful variable names, and comments where necessary. |

**Total: 60 Points**
