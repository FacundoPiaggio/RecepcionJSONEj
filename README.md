# RecepcionJSONEj

Para probar el controller ir a postman y una vez corrida la app realizar requests con el verbo "POST" a las siguientes rutas:

1. http://localhost:8080/api/recibirDatoSimple
2. http://localhost:8080/api/instanciarDatoAMano 
3. http://localhost:8080/api/instanciarDatoConClase
4. http://localhost:8080/api/datoConFramework

JSON de prueba:
```
{
    "unInteger":1,
    "unString":"Hola! :D",
    "unDouble":1.5
}
```

6. http://localhost:8080/api/RegionalAMano
7. http://localhost:8080/api/RegionalConClase

JSON de prueba:
```
{
    "nombre":"FRBA",
    "alumnos":[
        {
          "nombre":"Facundo",
          "apellido":"Piaggio",
          "edad":24,
          "egresado":false
        },
        {
          "nombre":"Ezequiel",
          "apellido":"Escobar",
          "edad":404,
          "egresado":true
        }
      ]
}
```
