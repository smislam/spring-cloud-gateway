# An example of Spring Cloud Gateway as a Proxy to other Microservices

This example solves the use case where we have a centralized proxy that authenticates users.  Also forwards some headers to the downstream applications. 

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

### Notes
Please make sure you add additional security to downsteam application to validate that the request cam from the proxy application.  Otherwise anybody can bypass the proxy application.