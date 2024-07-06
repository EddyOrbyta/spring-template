# Spring Template Project
Accelerate your project with this Spring Security configuration template. Includes user registration and authentication endpoints, along with admin-specific access controls based on JWT roles.

## Controllers

### UserController
Handles user registration and login.
Http Path: 

Signup -> POST http:host/backend-esame/auth/signup

Login ->  POST http:host/backend-esame/auth/login


### AdminController
Admin-only endpoints for specific operations.

Path: GET http:host/backend-esame/admin/prova (just for testing purpose)

## Security
Simplified setup with JWT authentication.
Public access to /signup and /login.
Admin role required for /admin endpoints.

## Getting Started
Clone the repository.
Configure and run the application.
Use /signup and /login for user operations.
Access /admin endpoints with admin credentials.

## Technologies
Spring Boot
Spring Security
JWT Authentication

## Considerations
Have Fun! 
Customize and expand this template to fit your project needs. 
Happy coding! 🙂
