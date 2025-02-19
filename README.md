(CMP020N207S) Software Architecture & Design
# CSWRK: SHARE PRICE COMPARISON WEB APPLICATION
### Written by. "G6-SAD"

## G6-SAD Group Member Details
- Keisha Geyrozaga (GEY23581805) [GitHub Profile](https://github.com/MOMORII)
- Anderson Ricardo Gomes Ballestroz (GOM21551647) [GitHub Profile](https://github.com/AndersonRGB)
- Clement Irivibeguai (IRI22514509) [GitHub Profile](https://github.com/clems27)
- Angelo Bongon (BON22529894) [GitHub Profile](https://github.com/Z3R018)
  
## Repository Information
This repository contains the development of our S.A.D GROUP COURSEWORK ASSIGNMENT 'SHARE PRICE COMPARISON WEB APPLICATION'. The project is built in Java using 'IntelliJ IDEA' and follows architectural principles such as Simple Architecture, Clean Architecture, and Service-Oriented Architecture (SOA). In addition to this, we have included numerous files evidencing our commitment to producing well-structured, organised deliverables. Using a Kanban board, we allocated tasks between us fairly and equally amongst ourselves. This board contains the product backlog, which will be updated with additional tasks according to the immediate sprint checklist—ensuring we prioritise the current sprint’s deadlines before moving on to the next. 

## Project Overview
The following information will aim to summarise project information in accordance with the 'Software Architecture & Design' assignment brief.

### Team Member Roles:
- Keisha - Product Owner
- Anderson - Scrum Master
- Clement & Angelo - Developers

### Project Summary
The "SHARE PRICE COMPARISON WEB APPLICATION" is a Java-based financial analysis tool that enables users to track and compare historical stock prices of different companies. The system retrieves stock price data from an external API, stores it persistently for offline access, and presents stock information in a graphical format. Designed with 'Simple Architecture' and 'Clean Architecture' principles in mind, the application ensures it takes a structured approach to financial data visualisation. The project aims to allow users to view and compare stock/share performance of different companies over time. Relying on agile development methodologies, such as 'Kanban' and 'Scrum', we aim to implement sound architectural foundations, core functionlities, and system integrations to achieve all coursework objectives.

### Core Features
1. Fetch **daily share price data** from an API
2. Store retrieved data persistently in a **database store of ****SQLite**
3. Display **interactive** stock price charts
4. **Compare stock performance** between two different companies
6. Ensure a **basic, functional UI** for user interaction

****SQLite** was chosen as our database as we will be storing fetched stock prices in a relational format. This means we will need a database that is capable of handling large datasets, supporting scalability for long-term storage, and integrating seamlessly with our chosen IDE, 'IntelliJ IDEA'. Additionally, we will be able to use SQL queries to easily access, filter, sort, and retrieve stock prices. Thus, making SQLite the most reasonable choice to opt for.

### Technology Stack
This will establish the technologies that will be using to model our current progress, team communication, and develop our project to the fullest.

- **Programming Languages**: HTML, CSS, JavaScript
- **IDE**: IntelliJ IDEA
- **Version Control**: Git & GitHub 
- **Database**: SQLite
- **External API**: 'Yahoo Finance' Stock Price API
- **Task Management**: GitHub Projects 

### Development Approach
We are following the 'Scrum' methodology, using GitHub Project for task management and sprint tracking. Our main programming language will be JavaScript and 'IntelliJ IDEA' will be the IDE we develop the program in. Our team aims to maintain regular communications through a WhatsApp groupchat for quick updates on current progress, and, 'Microsoft Teams' for weekly team meetings.

## System Architecture
Our architecture follows 'Simple Architecture' principles with the following as core components:

- **API Service** - Fetches stock prices from 'Yahoo Finance'
- **Database Layer** - Stores historical stock data
- **Graphing Module** - Generates the visual comparisons
- **UI Layer** - Basic frontend for displaying data

### Component Specification Diagram
Using PlantUML, we created a component UML diagram to illustrate the structure of key components we plan to use in our stock price comparison web application project. It provides us with a graphical representation and a visual overview of the system's archietcture, highlighting the interactions &  relationships between key components, as well as maintaining the application's core functionalities.

![image](https://github.com/user-attachments/assets/108f9d7f-f95f-4ca4-8639-4fe29b0a761d)

- The **'Main'** class acts as the enrty point foir our applciation and it controls the data retrieval, storage, and UI components. 

- The API layer incluides **'IStockData'** (interface defined to fetch stock price data) and **'YahooFinance'** (class that implements the **'IStockData'** interface to retrieve real-time stock prices from the 'Yahoo Finance' API). 

- Data storage includes the abstract interface **'IDataStorage'** (defines methods to save/retrieve stock price data, evenif the chart is not activelyu in use) and the **'SQLiteDataStorage'** class (implements the **'IDataStorage'** interface to actually store/retrieve strock price data). 

- UI  is handled in the **'ChartDisplay'** class, which  renders stock price charts so users can compare price trends over two different companies over the span of up to 2 years. 

- The data model class **'StockPrice'** is used throughout the program to handle stock price attributes obtained from the data collected. Data processed from the **'StockPrice'** class is made into a visual, interactive chart layout in the **'ChartDisplay'** class.

In conclusion, this UML diagram is pivotal towards constructing the project structure and abstract code on our integrated development environment (IDE), IntelliJ,. and clearly demonstrates our adherence to simple architectural principles.

## Kanban board
This is the Kanban board we use to track progress, organise tasks, and ensure smooth workflow management. Each column represents a different stage of the process, helping us visualise work in progress and prioritise tasks effectively. [Kanban Board Link](https://github.com/users/MOMORII/projects/1/views/1)

## Conclusion
As a team, we were able to effectively distribute task responsibilities amongst ourselves and work towards meeting 'Sprint 1' checklist objectives outlined in the coursework assignment brief. Through clear and consistent communication via WhatsApp and Microsoft Teams, we utilised GitHub and IntelliJ to achieve our development goals efficiently.
