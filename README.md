# Thrifty 
## Personal Expense Tracker App with OCR

Thrifty is a personal finance management application with features that are beneficial for managing the finance of users. Personal finance management app developed includes updating income, tracking expenses and sending alerts at the right time, etc. Each of these activities involves accessing information from different locations, collecting and consolidating monetary information. This app helps users to set their goals, keep track of their income and expenses by monthly basis. Users can set reminders to get timely alerts. This app includes different modes of updating expenses either manually using the app’s interface or by using OCR. This app is designed to help users to manage their finances to understand where their money is going, pinpointing the areas of excessive expenditure and assist to take the decision of cutting down unnecessary expenses. Graphical representation of income and expenses of the individual is another feature of this app which makes the user view the graph at a glance and can make a decision very quickly which is hardly possible through descriptive reports. And finally, the user is provided with the printed report of expenses. The app is designed and developed using JAVA, XML, and SQLite as the backend database. 

### Sign up
Users can create an account in the app by entering name, email id, mobile number, and a password. The user can set a budget amount for the account during sign up. An account is created when the user agrees to the terms and conditions specified for the app.

### Login 
Users can login into the account by entering email id and password used to sign up for an account. After login the user is displayed with tip of the day in the splash screen.

### Dashboard
Users are lead to the dashboard once after they login. This dashboard gives an overall view of Income and Expenses of the user in the month, shows top 2 transactions and contains navigating links to all other screens such as Alerts screen, Transactions screen, add income screen, add expense screen and scan screen. 

### Add Income
In the add income screen (Take screen), Users can add income manually using UI.

### Add Expense
Users can add expenses either manually or by scanning bills using OCR. Expense amount and an expense tag given by the user is used to categorize the expenses. An entered expense cannot be removed.

### View Transactions
Users can view the transactions in 2 modes. The first one lists all transactions upto date in a list, whereas the second one is a Pie chart graph view that displays all expenses graphically in a pie chart according to the tag.

### Export Transactions as PDF
Users can create a PDF of the transaction made along with their dates and category. This can be used for reference and accounting. This PDF file gets downloaded and saved as TransactionsReport.pdf file in the Documents folder in the device.\

### Dialog Alerts, Reminders and Budget
Users are alerted by displaying dialog box alerts upon exceeding their budget limit. Users can add reminders with date and time. It is displayed in the order of the recent reminder first. This screen also displays the current budget and options to add new reminder and change the budget.
Users can set reminders and can view it from the alerts screen. The users can also set or change the monthly budget according to which alerts are sent to the user when the user continues spending beyond half of the allocated budget amount.

