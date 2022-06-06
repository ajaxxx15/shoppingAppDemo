# shoppingAppDemo
Mindtree Hands on
Shopping Cart Application on Spring Boot with Hibernate/JPA
Create a shopping cart web application by implementing Spring boot with hibernate/JPA.
The main objective of the Shopping cart system is to manage the cart and product details.
User can add, update, remove and view the products in the cart. While displaying the cart contents system has to display all the items in the cart and total amount to be paid by the user.
Entity classes has to be designed as per the uml diagram below 

![image](https://user-images.githubusercontent.com/38243518/172138068-0e76a973-07c7-4b10-a04e-385153707d32.png)



Cardinality relationship between entities
One to One mapping between User class and Cart class
One to Many mapping between Cart class and Product class
Each product can be categorized by the sub class of Product class

Managing the Life cycle of Entities
In this Shopping cart application user need to manage the life cycle of only Cart Entities, So no need to add , delete , modify Product entities.
User can Search the Products by ID, or by product Name or by product Category

Adding a Product entity into a cart:
User can add same product multiple times in the cart. If the same product is added more than once  just need to increment the quantity by 1.  


Remove a Product entity from a cart:
User can remove a specific product and remove all products from the cart

Updating the Cart:
User can update the quantity of the products in the cart. Quantity should not be negative.
If the user updated the quantity as zero the product has to be removed from the cart.

Viewing the Cart:
User can view the products any time. The application has to display the total amount to be paid by the user

Hibernate and Spring module:
The life cycle of entity classes completely managed by Hibernate framework
Named query to be used
Spring Boot to be used to bootstrap the application
Spring data JPA to be used
Spring Transaction management to be used
