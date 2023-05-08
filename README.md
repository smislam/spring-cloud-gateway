# Example of a Spring Cloud Gateway As a Proxy to othe Microservices

This example solves the use case where we have a centralized proxy that authenticates users and forwards some headers to the downstream applications. 

This example is using one downstream application.  If we have many, change the code accordingly.


## Implementation Details
This example is using one downstream application.  If we have many, change the code accordingly.  This example uses:
* Spring Cloud Gateway
* Auth0 as Oauth2/OIDC provider
* Spring Boot 2.7.11
* Java 8

## Steps to run
* Add your Auth Provider (I am using Auth0) information in the application.yml of the Proxy application
* Run the Client
* Run the Proxy
* Hit the URL: `http://localhost:8080`

## Results
If all goes well, you should see this:
![image](proxy.PNG "Proxy for Spring Boot")
