# Project Scope Document
This document outlines the scope, objectives, and requirements for our 'Stock Price Web Application' group coursework assignment. The project aims to adhere to the principles of **Simple Architecture**, **Clean Architecture**, and **Service-Oriented Architecture (SOA)**, demonstrating the teachings obtained from in-class lectures and lab sessions. Our main objective is to develop a **Java-based financial analysis tool** that allows users to be able to retrieve, store, and compare historical stock prices of various companies over the span of 1-2 years. This tool will oversee financial insights by visualising stock trends over time in a chart display UI.

## (1) Project Objectives
- Fetch stock price data from an external API.
- Store retrieved data persistently for offline access.
- Present stock information in a graphical format to enable comparative analysis.
- Ensure an intuitive UI that provides users with seamless interaction.
- Implement an efficient, structured, and scalable architecture for long-term maintainability.

## (2) Core System Functionalities

### **Data Retrieval**
- The system will fetch reliable, real-time stock prices from Yahoo Finance API.
- The API layer will be implemented using an interface (`IStockData`), allowing for future integration of alternative data sources.

### **Data Storage**
- Data will be stored persistently using SQLite, chosen due to its lightweight nature, relational format, and compatibility with IntelliJ IDEA.
- The `IDataStorage` interface will define storage and retrieval operations, with `SQLiteDataStorage` handling actual database interactions.

### **Data Visualisation**
- Stock price data will be displayed using interactive graphing components.
- Users can compare stock price trends across different companies.
- The `ChartDisplay` class will handle UI rendering for stock comparisons.

## (3) Data Sources & Justification
When deciding on which application to choose to regulate data storage, we opted for SQLite over JSON, primarily due to SQLite's ability to efficiently handle large datasets, support scalability, and enable omplex querying using SQL.
| Data Source | Purpose | Justification |
|------------|---------|--------------|
| Yahoo Finance API | To fetch historical, real-time stock prices | Reliable, widely used in financial applications |
| SQLite | To persistently data storage (even as it's 'offline') | Lightweight, relational, and scalable |

## (4) Key Use Cases & User Stories
These key use cases demonstrate the main ways in which we expect & envision users to engage with our 'Stock Price Web Application' project.
| Use Case | Description |
|---------|------------|
| 1. Fetch stock price | Retrieve stock price data from Yahoo Finance |
| 2. Store stock data | Save stock prices in SQLite for offline access |
| 3. Compare stock trends | View stock performance of two different companies |
| 4. Visualise stock charts | Display stock price movements graphically |

**Fetch Stock Price**
As a user, I want to retrieve stock price data from Yahoo Finance so that I can get up-to-date information on stock prices.

**Store Stock Data**
As a user, I want to save stock prices in SQLite for offline access so that I can view the stock data even when I am not connected to the internet.

**Compare Stock Trends**
As a user, I want to view the stock performance of two different companies so that I can compare their trends and make informed investment decisions.

**Visualize Stock Charts**
As a user, I want to display stock price movements graphically so that I can easily analyze trends and patterns in the stock's price over time.

## (5) Project Deliverables
- **Project Repository**: Contains the essential documentation and complete codebase, including project files and the Java source code folder.

- **README.md**: Summarises project information, objectives, architecture, and technologies used.
- **Component UML Diagram**: Illustrates (and explains) the entire project structure and the shared interactions between different classes and interfaces (located within the README.md file).
  
- **Project Scope Document.md** - Defines the project scope and deliverables for this group coursework assignment.
- **Code of Conduct.pdf** - Establishes the rules and expectations for all group memembers.
- **Team Agreement Sheet.pdf** - Details roles and responsibilities expected from every team member involved in the group project.
- **Timesheet Availability.docx** - Displays the availability of team members on a weekly basis for this semester.
- **Meeting Notes.docx** - Records the discussion details between team members regarding the project's current progress & future plans.
  
- **Kanban Board**: Tracks progress on a sprint-by-sprint basis, using checklist items and tasks to ensure project deadlines are met.

## (6) Architectural Considerations
- **Simple Architecture**: Focuses on a well-structured, organised approach that keeps the system design minimal and easy-to-understand.
- **Clean Architecture**: Ensures 'separation of concerns' (by dividing the system into layers w/distinct responsibilities) and maintainability throughout the entire system.
- **Service-Oriented Architecture (SOA)**: Allows modular integration of APIs and services by organising functions into reusable services that can communicate over a network.

## Conclusion
The 'Share Price Comparison Web Application' is designed to provide users with consistent, real-time financial insights by fetching and visualising stock price data. By adhering to agile methodologies and architectural principles, the application ensures maintainability, extensibility, and efficient performance is upheld throughout the project's duration. This document serves as the foundation for defining the project's scope, objectives, and deliverables, providing a structured framework for successful execution.
