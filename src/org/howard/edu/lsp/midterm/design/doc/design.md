Class: Order

Responsibilities:
- store order data (customer name, email, item, price)
- calculate tax (7%)
- apply discount if price > 500
- calculate final total
- provide details for printing/saving  
  Collaborators: none

Class: OrderProcessor

Responsibilities:
- orchestrate order processing (calculate, print, save, email, log)  
  Collaborators: Order, ReceiptPrinter, FileSaver, EmailSender, Logger

Class: ReceiptPrinter

Responsibilities:
- print receipt (Customer, Item, Total)  
  Collaborators: Order

Class: FileSaver

Responsibilities:
- save order line to orders.txt  
  Collaborators: Order

- Class: EmailSender

Responsibilities:
- send confirmation email (simulated via console)  
  Collaborators: Order

Class: Logger

Responsibilities:
- log processing timestamp  
  Collaborators: none