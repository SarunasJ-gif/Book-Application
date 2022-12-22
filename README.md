Project name

# BooksAplication

---

## Table of Contents

- [Description](#description)
- [Technologies](#technologies)
- [Dependencies](#Dependencies)
- [Building the project](#Building the project)

---

## Description

Application for quick book storage, update, access and total price calculation. 
- A client can use a REST call to put a book into the system providing its name, author,
barcode, quantity, price per unit.
- A client can use a REST call to update any of its detail providing the barcode and updated
  field information.
- A client can use a REST call to calculate the total price of specific books in the system given
  the barcode (including antique books and science journals).
- A client can use a REST call to request a list of all barcodes for the books in stock grouped by
  quantity.
-  A client can use a REST call to request a list of all barcodes for each group sorted by total price.
-  A client also wants to store and access antique books in his system. They are just like other books,
   but also have a release year parameter (no more recent than 1900).
-  A client also wants to store and access science journals in his system. They are just like other books,
   but also have a science index (int between 1 – 10).   



---

## Technologies

- Java
- Spring Framework
- SpringBoot

---

## Dependencies

Browse the Maven pom.xml file for details of libraries and versions used.


---

## Building the project

Clone the project and use Maven to build the server

```
$ mvn clean install
```


