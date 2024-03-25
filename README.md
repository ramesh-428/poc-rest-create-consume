This POC demonstrates below:
1) Creating Restful Webservices
2) Consuming Restful Webservices
3) Connect to SQL H2 DB using entity, repo and Service
4) Connect to Doc Cloud DB using doc, repo and Service
5) Exception Handling
6) Unit Tests

**Highlevel Flow**
Client can consume below endpoints:
/api/products/{id} [GET]
/api/products/{id} [POST]
/api/productname/{id} [GET]

**Underthe Hood of REST APIs**
Product Service-> Product Name Service and Prodct Price Service -> Error Handler, H2 In Memory, Doc DB Cloud and Initial Load


