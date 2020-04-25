## Introduction

This project is about building a web application (referred to as W) that tracks the personal expenses of an individual (customer C or also user U).
Assume after shopping, C has a receipt listing all products bought. C could enter the details from the receipt into the web UI to track expenses.
With the web application, C does not need to keep all paper back receipts. The web application could provide some more advanced analysis tools later.
This document is a high-level design footprint of the web application.

## Database Design

### Table `user`
W needs to track the basic information of an user such as first name, last name, telephone number, email, address, start date of each month.

### Table `monthly_allowance`
W needs to store the amount of money U has set beforehand at the start date of each month. For example, at the 5th of every month, John is forced to enter an amount of money he affords for shopping before he could access W.

### Table `receipt`
W stores all the receipts and their information such as time of print, list of purchased product(s), store, user, notes.

### Table `store`
W needs to stores fundamental information on each store like address, weekday opening hour, weekend opening hour, telephone.

### Table `purchased_product`
A product has basic information such as name, price, date of purchase, store of purchase, quantity.

### Table `note`
U could give each entry in a receipt a note. For example, John could note that the milk is about to expire in 7 days so he consumes it as soon as possible.