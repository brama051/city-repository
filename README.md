City Repository API
===================
# Open endpoints (No authentication required) 
###HTTP POST: `/login`
Body parameters:
- `email` - mandatory
- `password` - mandatory

 
###HTTP POST: `/register` 
Body parameters:
- `email` - mandatory
- `password` - mandatory

###HTTP GET: `/cities[&orderBy]`
URL parameters
- `orderBy` - optional - text - [none/`favorites`/`created`] 


###HTTP GET: `/cities/{cityName}`
URL parameters
- `cityName` - mandatory - name



# Secured endpoints
###HTTP POST: `/cities`
Body parameters:
- `name` - mandatory - text
- `description` - mandatory - text
- `population` - mandatory - number

###HTTP GET: `/cities/{cityName}/favorite`
URL parameters
- `cityName` - mandatory - name

###HTTP GET: `/cities/{cityName}/unfavorite`
URL parameters
- `cityName` - mandatory - name




## Build and deploy
Checkout the project and run `gradle bootRun`