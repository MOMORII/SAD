# Project Scope Document

## 1. Introduction
This document outlines the scope, objectives, and requirements for the **Share Price Comparison Web Application**. The project follows the **Software Architecture & Design (CMP020N207S) coursework brief**, adhering to the principles of **Simple Architecture**, **Clean Architecture**, and **Service-Oriented Architecture (SOA)**.

The objective is to develop a **Java-based financial analysis tool** that allows users to retrieve, store, and compare historical stock prices of various companies. This tool will facilitate financial insights by visualizing stock trends over time.

## 2. Project Objectives
- Fetch stock price data from an external API.
- Store retrieved data persistently for offline access.
- Present stock information in a **graphical format** to enable comparative analysis.
- Ensure an intuitive UI that provides users with seamless interaction.
- Implement an **efficient, structured, and scalable architecture** for long-term maintainability.

## 3. Core System Functionalities
### **1. Data Retrieval**
- The system will fetch **historical and real-time stock prices** from **Yahoo Finance API**.
- The API layer will be implemented using an interface (`IStockData`), allowing for future integration of alternative data sources.

### **2. Data Storage**
- Data will be stored persistently using **SQLite**, chosen due to its lightweight nature, relational format, and compatibility with IntelliJ IDEA.
- The `IDataStorage` interface will define storage and retrieval operations, with `SQLiteDataStorage` handling actual database interactions.

### **3. Data Visualization**
- Stock price data will be displayed using interactive **graphing components**.
- Users can compare stock price trends across different companies.
- The `ChartDisplay` class will handle UI rendering for stock comparisons.

## 4. Data Sources & Justification
| Data Source | Purpose | Justification |
|------------|---------|--------------|
| Yahoo Finance API | Fetch historical & real-time stock prices | Reliable, widely used in financial applications |
| SQLite | Persistent data storage | Lightweight, relational, and scalable |

SQLite was selected over JSON storage due to its ability to efficiently handle **large datasets**, support **scalability**, and enable **complex querying using SQL**.

## 5. Key Use Cases
| Use Case | Description |
|---------|------------|
| Fetch stock price | Retrieve stock price data from Yahoo Finance |
| Store stock data | Save stock prices in SQLite for offline access |
| Compare stock trends | View stock performance of two different companies |
| Visualize stock charts | Display stock price movements graphically |

## 6. Project Deliverables
- **Project Repository**: Contains source code, documentation, UML diagrams, and test cases.
- **README.md**: Summarises project information, objectives, architecture, and technologies used.
- **Kanban Board**: Tracks sprint progress and backlog tasks.
- **Component UML Diagram**: Illustrates project structure and interactions.

## 7. Architectural Considerations
- **Simple Architecture**: Focuses on a well-structured, organised approach.
- **Clean Architecture**: Ensures separation of concerns and maintainability.
- **Service-Oriented Architecture (SOA)**: Allows modular integration of APIs and services.

## 8. Conclusion
The **Share Price Comparison Web Application** is designed to provide users with **reliable financial insights** by fetching and visualizing stock price data. By adhering to **agile methodologies** and architectural principles, the project ensures maintainability, extensibility, and efficient performance. This document serves as the foundation for development, guiding the implementation of core functionalities in 'Sprint 1' and beyond.

