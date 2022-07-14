# DisneyInventory

Endpoints for the REST webservices, deployed on your local environment

1. POST request for saving a product:
http://localhost:8082/products

Sample JSON data for input:

    {
        "inventoryId": 1,
        "experienceDetails": "Mickey mouse doll for kids",
        "content": "Mickey mouse",
        "stockLevel": 50
    }

    {
        "inventoryId": 2,
        "experienceDetails": "You will be able to see the whole park with this tram ride",
        "content": "Tram ride",
        "stockLevel": 20
    }


2. GET request for fetching all the products:
http://localhost:8082/products

3. GET request for fetching a product with product id:
http://localhost:8082/products/10

4. GET request for booking a product with product id:
http://localhost:8082/products/book/2

5. DELETE request for delete a product with product id:
http://localhost:8082/products/3
