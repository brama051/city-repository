City Repository API
===================
# Open endpoints (No authentication required) 
###HTTP POST: `/login`
Body parameters:
- `email` - mandatory
- `password` - mandatory
 
 Success response

> Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoidmVkcmFuIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTUyNzQ5MTI0OSwiYXV0aG9yaXRpZXMiOlsiU1RBTkRBUkRfVVNFUiJdLCJqdGkiOiI5NzU0MTgxNC0yMmE0LTRlNTMtOWUxMi1lYmY5MmI2MmQzYTciLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.wEdeoY1gvAKvR-IsJLLA8RNMCDan5Rdc2bfpYqfwc_s
 
 
###HTTP POST: `/register` 
Body parameters:
- `email` - mandatory
- `password` - mandatory

Success response

> Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoidmVkcmFuIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTUyNzQ5MTI0OSwiYXV0aG9yaXRpZXMiOlsiU1RBTkRBUkRfVVNFUiJdLCJqdGkiOiI5NzU0MTgxNC0yMmE0LTRlNTMtOWUxMi1lYmY5MmI2MmQzYTciLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.wEdeoY1gvAKvR-IsJLLA8RNMCDan5Rdc2bfpYqfwc_s

###HTTP GET: `/cities[&orderBy]`
URL parameters
- `orderBy` - optional - text - [none/`favorites`/`created`] 

###HTTP GET: `/cities/{cityName}`
URL parameters
- `cityName` - mandatory - name


# Secured endpoints
To consume any of the secured endpoints, user must first login or register. By doing so, one will acquire a token which must be provided in `Authorization` header

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




# Build and deploy
Checkout the project and run `gradle bootRun`