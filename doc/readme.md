# Algo Trader

This will be a free-time project where I try to make some reliable income from the stock-market. The strategy of sell/buy entries will be described under the "strategy.txt"-file. The absolute end goal is to make a solid 0.5% income each day.

Updates to this document will be made frequently, as a sort of notebook or diary. All of these notes will be gathered under the "Notes" - Header. 

## Classes and overall structure
There will be a number of classes in this project. Mainly, there will be two different sections in the project. The server-section and the client-section. The server-section will be created first, and the command-line will be used in order to interact with it. The client-section will then be added to the project in order to create a user-interface for the user to specify things such as which companies it wishes for the algorithm to add to the company-watchlist.

### Server
The following is a list of all use-cases in the server. Under the list, there will also be a more in-dept explanation of each use-case.

Use cases:
 - Log into a user-account
 - Add/remove a user, thus starting a session
 - Add/remove company from the watchlist
 - Buy/sell stocks of the company
 
The server can let a person log onto their account, upon which it sends back a list of all the companies the person has in their watchlist (both active and non-active). It is important to note that the server also will check wether or not the user-credentials also are correct.

### Avanza API
The Avanza-API is an api which can present data of a single user. It can also act on behalf of said user, thus making it possible to concurrently check the cost of a stock, selling and/or buying shares of the company

# Notes

All notes should start of with the date of the notes, and should contain information which is important for the project, such as inefficiencies with the current working-structure, algorithms or so on.


## 15-03-2025
I am gonna try getting comfortable with AI. I will use GitHub Copilot for smaller tasks such as "What is the error here" after trying to find and fix the problem for a while myself (minimum of 5 minutes).