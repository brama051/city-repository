# City Repository API

## Open endpoints (No authentication required) 
HTTP POST `/login`
Post parameters:
`email` - mandatory
`password` - mandatory
 
HTTP POST `/register` 
Post parameters:
`email` - mandatory
`password` - mandatory

HTTP GET `/cities/{cityName}`



## Secured endpoints
HTTP POST `/cities`




## Build and deploy
Checkout the project and run `gradle bootRun`