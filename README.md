# Prueba CRUD API REST
Prueba del CRUD API REST

- Para Ejecutar el proyecto es necesario tener instalado PostgreSQL o MySQL, el proyecti funciona en Java 8
- Las configuraciones de la base de datos de encuentran en application.properties, dependiendo de cual se desea usar se comentan la una o la otra
- la base de datos debe de llamarse " db_springboot_backend " la contraseña y usuario se cambian segun la configuracion creada
- Se puede correr la aplicacion, por defecto en el archivo import.sql el agregara unos datos de prueba
- para acceder a los servicios se probo con PostMan a traves de la URL de tipo:
* GET " http://localhost:8080/api/clientes ", 
* GET " http://localhost:8080/api/clientes/? ",  
- POST " http://localhost:8080/api/clientes" enviando en el cuerpo del proyecto el formato JSON Eje: 
{
                                                                                                                                                                                      "id": 13455,
                                                                                                                                                                                      "nombre": "Edilson",
                                                                                                                                                                                      "apellido": "Pardo",
                                                                                                                                                                                      "email": "edilsoncorreo@gmail.com",
                                                                                                                                                                                      "numeroTarjeta" : 9876543456,
                                                                                                                                                                                      "createAt": "2018-01-01"
                                                                                                                                                                                  } 
- PUT " http://localhost:8080/api/clientes/? ",enviando en el cuerpo del proyecto el formato JSON Eje: 
{
                                                                                                                                                                                      "id": 83655,
                                                                                                                                                                                      "nombre": "Edilson",
                                                                                                                                                                                      "apellido": "Pardo",
                                                                                                                                                                                      "email": "edilsoncorreo@gmail.com",
                                                                                                                                                                                      "numeroTarjeta" : 9876543456,
                                                                                                                                                                                      "createAt": "2018-01-01"
                                                                                                                                                                                  }
* DELETE " http://localhost:8080/api/clientes/? "
