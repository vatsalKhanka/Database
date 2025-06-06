# Small DB – A Command-Line Java Database Engine

*An internship project designed to explore the fundamentals of database systems using pure Java.*

---

## Project Overview

**Small DB** is a lightweight, command-line database engine built entirely in Java. Developed as part of an internship, this project serves as a hands-on exploration into the inner workings of database systems. It allows users to:

- Create and delete tables  
- Insert, update, and delete records  
- Query data with basic filtering  
- Manage schema and data integrity  

While currently a console-based application, future enhancements aim to introduce advanced features such as:

- SQL-like query support  
- Data validation mechanisms  
- Indexing for performance optimization  
- User authentication and access control  

---

## Tech Stack

- **Language**: Java (no external libraries)  
- **Database Engine**: Custom-built in Java  
- **Architecture**: Command-line interface  

---

## Installation & Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/DataForge.git
   cd DataForge
   ```

2. **Compile the Project**:
   ```bash
   javac Main.java
   ```

3. **Run the Application**:
   ```bash
   java Main
   ```

---

## Usage Example

```bash

create table users (id int, name str);
insert into users values (1, 'Alice');
insert into users values (2, 'Bob');

select * from users;
```

---

## Features

- **Table Management**: Create, delete, and describe tables  
- **Data Manipulation**: Insert, update, and delete records  
- **Querying**: Retrieve data with basic filtering  
- **Schema Management**: Define and modify table structures  

---

## Future Enhancements

- SQL-like query language support  
- Advanced data validation  
- Indexing and performance optimizations  
- User authentication and role-based access  

---

## Author

Developed by Vatsal Khanka as part of an internship project.

---

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
