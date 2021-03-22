1)Login 
La richiesta di login arriva a AuthenticationRestController con /api/authenticate
Il metodo authorize genera un token con username e password
Il token viene aggiunto a Authentication
Il Authentication viene aggiunto a SecurityContextHolder

Bisogna generare il jwt token chiamo quindi  tokenProvider.createToken
	Da application.yml prendo i valori che indicano la durata dei token
	**createToken
	 prendo le authorities da Authentication
	 genero un jwts token con nome,authorities, chiave di crittografia e durata

Genero gli headers http e aggiungo il jwtToken
Nella risposta aggiungo JWTToken(jwt), httpHeaders, HttpStatus.OK 

2)Richiesta
La richiesta arriva a JWTFilter
prende la servletRequest
risolve il token a partire dalla httpServletRequest
il token viene validato da tokenProvider 
	Authentication-> tokenProvider.getAuthentication(jwt);
Authentication viene inserita nel SecurityContextHolder

