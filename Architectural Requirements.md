# Architectural Requirements - UML DIAGRAMS
The architectural design of the Share Price Comparison Web Application follows key principles of Simple Architecture, Clean Architecture, and Service-Oriented Architecture (SOA) to ensure modularity, scalability, and maintainability. This section presents a series of UML diagrams that illustrate the system’s component structure, business logic, use case interactions, and system interfaces, and thhus, providing a clear overview of how different parts of the application interact with one another.

## Revised Component UML Diagram
The component UML diagram below has been refined to reflect a structured and modular approach to application architecture through numerous revisions and renditions created to better reflect what we expect our project to be comprised of. The revised diagram encapsulates key functional components, including the 'StockDataProvider' compound component subsystem, which integrates both 'SQLiteStorage' and 'Yahoo Finance API' for data retrieval and persistence. This ensures efficient stock data management and provides a clear separation of concerns. The diagram also showcases the provided and required interfaces that enable seamless communication between components while maintaining architectural integrity.

![Screenshot 2025-03-18 150356](https://github.com/user-attachments/assets/aa2e6b89-5491-473e-92b7-3e0246a8d8e8)

| Components | Role |
|-----------------------|------|
| StockApplication | The core application component responsible for managing user interactions, providing the main interface for other components. |
| StockPrice | Manages price retrieval, storage, and availability for external components, e.g., 'ChartDisplay'|
| ChartDisplay | Responsible for visualising stock data obtained from StockPrice. |
| Watchlist | Handles the tracking and monitoring of user-specified stocks. |
| UserPortfolio | Manages user’s stock holdings, portfolio management, and investment tracking. |
| SQLiteStorage | Acts as the local database responsible for storing stock price data retrieved from Yahoo Finance. |
| YahooFinance | Serves as the real-time stock price data provider, fetching up-to-date price information from an external (Yahoo) API. |
| StockDataProvider (Subsystem/Compound) | Encapsulates 'SQLiteStorage' & 'YahooFinance' as internal components, delegating retrieval/storage functions while exposing only the IDataStorage & IStockData interfaces. |

As mentioned before, this component UML diagram has been made to better reflect SOLID principles and clean architecture, eliminating cyclic dependencies and ensure data handling was encapsulated properly through our use of compound components (subsystems). Based on the feedback recieved from our lecturer, we ensured we strictly adhered to UML component modelling, evident through the lollipops (for provided interfaces), sockets (for required interfaces), and delegate arrows (<<delegate>>) incorporated into our new component design.

## (1) Business Concept Model 
The business concept model (BCM) defines the core business entities and their relationships within the stock price comparison system. It provides a high-level abstraction of how different elements (such as stocks, users, and share price data) interact with one another. By modeling business concepts, this diagram ensures that the system’s functional design aligns with the intended business objectives, making it easier to map real-world requirements to technical implementations.

![Screenshot 2025-03-19 025017](https://github.com/user-attachments/assets/a52e22b8-f629-4cc4-bb44-3c23ad9f04e9)


## (2) Use Case Models
The use case models capture the key user interactions and system behaviors required to fulfill the application’s primary functions, which have been illustrated on the README.md file and further emphasised on the 'Project Scope Document'.md file. These core functionalities include fetching stock prices, storing data persistently, comparing stock trends, and visualising stock performance over time. Each use case diagram identifies the actors (users) and their roles, mapping out a step-by-step flow of system interactions. These models provide a foundation for defining system requirements and ensuring a seamless user experience.

### Use Cases Recap
___

| Use Case | Description |
|---------|------------|
| 1. Fetch stock price | Retrieve stock price data from Yahoo Finance |
| 2. Store stock data | Save stock prices in SQLite for offline access |
| 3. Compare stock trends | View stock performance of two different companies |
| 4. Visualise stock charts | Display stock price movements graphically |

### Use Case Models

___
(1) **Use Case: Fetch stock price**         
        Main Actor: User

Steps:
1. User searches up a stock symbol.
   1. System Displays an input field for the stock symbol
2. User requests stock price. System sends request to YahooFinance API.
   1. User input is recieved
   2. System sends a request to YahooFinance API.
3. System fetches stock price
   1. YahooFinance API responds to the system
   2. The system recieves the response (real-time data from the API)
   3. The system returns the latest stock price
4. System displays stock price
   1. The system presents the stock price to the user          

___
(2) **Use Case: Store Stock Data**     
          Main Actor: System (on behalf of the user)

Steps:
1. System receives stock price
   1. System retrieves stock price from Yahoo Finance API
2. System checks database/storage
   1. System queries SQLite database to check for pre-existing data
3. System stores stock data
   1. If the stock data already exists, update the price
   2. Otherwise, insert a new entry
4. System confirms storage
   1. System logs the transaction and confirms successful storage.          
                  
___
(3) Use Case: Compare Stock Trends     
          Main Actor: User

Steps:
1. User selects two stock symbols
   1. System presents two input fields for the user to search up two different stocks
   2. User inputs a different company name 
2. User requests comparison
   1. System retrieves historical price data for both stock symbols from SQLite
3. System processes trend analysis
   1. System calculates percentage changes, moving averages, and trends
4. System displays comparison results
   1. System presents a side-by-side graphical representation of the two stock trends          
             
___
(4) **Use Case: Visualise Stock Trends**     
          Main Actor: User

Steps:
1. User selects two stock symbols
   1. System presents two input fields for the user to search up two different stocks
   2. User inputs a different company name 
2. User requests comparison
   1. System retrieves historical price data for both stock symbols from SQLite
3. System processes trend analysis
   1. System calculates percentage changes, moving averages, and trends
4. System displays comparison results
   1. System presents a side-by-side graphical representation of the two stock trends        
                   

## (3) System Interfaces
To support a well-structured and maintainable architecture, the system relies on clearly defined interfaces that dictate how components interact. This section outlines the essential system interfaces, each mapped to a specific use case requirement. Interfaces (such as IStockPriceFetcher, IStockDataStorage, IStockComparison, and IStockChartRenderer ensure that system functionalities—ranging from data retrieval and persistence to visualization—are modular and loosely coupled. These interfaces play a crucial role in ensuring flexibility and scalability for future enhancements.

1. FETCH STOCK PRICE:    
![image](https://github.com/user-attachments/assets/89d2e269-bae5-42c5-ad7c-1fbea34408dd)

2. STORE STOCK DATA:   
![image](https://github.com/user-attachments/assets/2fd75bc7-d05f-4245-98dd-042dd2392b6a)


3. COMPARE STOCK TRENDS
![image](https://github.com/user-attachments/assets/64532d72-cfc7-4ddc-a098-550f1882550c)


4. VISUALISE STOCK CHARTS
![image](https://github.com/user-attachments/assets/0d0d8224-2ad2-4ec6-a359-b63f4bfd433a)


## (4) Business Type Model
This UML provides a detailed breakdown of key bussinss objects, their attributes, and their relationships within the stock price comparison web application. It effectively serves as a blueprint for database design and object-oriented implementation. This model is able to ensure data consistency across different components and is capable of supporting efficient querying and manipulation of stock price data.

![image](https://github.com/user-attachments/assets/def87f48-bd1e-4ea7-8685-211db0578203)



## (5) Initial System Architecture
The Initial System Architecture (ISA) lays the foundation for the entire software design by incorporating principles of SOLID principles, service-oriented architecture (SOA) and clean architectural require,ments. It outlines the web application's high-level structure, detailing how data flows between components, APIs, storage systems, and the user interface. By establishing clear layers of abstraction, this architectural model ensures that business logic, data handling, and UI components remain decoupled, promoting maintainability and scalability.      

![Screenshot 2025-03-23 024356](https://github.com/user-attachments/assets/2655ae8d-ae40-4560-bb32-9582fb8b7321)



## (6) Business Interfaces
Business interfaces define how different components of a system interact while maintaining modularity and flexibility. They act as contracts between system services and business objects, ensuring clear communication without creating direct dependencies. By using UML to model these interfaces, we can better understand how data flows through the system and how different components collaborate to fulfill business use cases. This structured approach improves maintainability, scalability, and ease of future modifications.
![image](https://github.com/user-attachments/assets/bb7416aa-db86-47ab-a3d8-205f26173dc8)

