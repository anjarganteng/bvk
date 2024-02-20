# bvk
Springboot Microservice BVK + H2 Database in memory

JDK 21

Init data Table User 
1. username: rey || password: password
2. username: axel || password: password
3. username: anjar || password: password

Module :
1. User (port: 8080)
2. Inventory (port: 8081)
3. Order (port: 8082)

DB Admin H2 :
1. User : http://localhost:8080/h2-console
2. Inventory : http://localhost:8081/h2-console
3. Order : http://localhost:8082/h2-console
- JDBC Url : jdbc:h2:mem:app_microservice
- user : root
- password : root

Swagger :
1. User : http://localhost:8080/swagger-ui/index.html
2. Inventory : http://localhost:8081/swagger-ui/index.html
3. Order : http://localhost:8082/swagger-ui/index.html
