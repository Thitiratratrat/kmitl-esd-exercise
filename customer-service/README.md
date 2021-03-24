# Customer Service Module

The customer service module contains 4 packages inside:
1. Controller
2. Model
3. Repository
4. Service

## Controller
The controller package contains the REST controllers for the customer and
 quotation model. The controllers support CRUD operations. This package sits
  in the controller layer and provides REST API for the clients to request.
  
## Model
The model package sits in the entity layer. The model contains two entities
: customer and quotation. The model layer defines the structure of the
 database such as the tables, columns, and the column specifications (max
 , min characters). The model uses JPA.
#### Customer
The customer entity contains the customer's information which includes the
 customer's id, name, birthday, phonenumber, creationDateTime, email
 , tempRemark, and age.
 
#### Quotation
The quotation entity contains the customer's quotations information. A
 quotation must belong to a customer. The quotation contains id, reference, a
  reference to the customer who quotes, price, creation date time, valid
   date time, and the saved date time.

##   Repository
The repository sits on the repository layer and handles the persistence of
 the model. Each model has its own repository that handles the accessing and
  manipulating the persisted model. The repository extends from the Spring data
   CRUD repository.
   
## Service
The service sits on the business logic layer and handles the application's
 business logic. The service uses the repositories to access the models and
  manipulate data. The service package has two services: quotation service
   and customer service. The customer service handles the calculation of the
    customer's age based on the customer's birthday on each request. 
