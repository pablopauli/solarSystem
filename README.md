# Examen Mercado Libre - solarSystem


## Consigna
En una galaxia lejana, existen tres civilizaciones. Vulcanos, Ferengis y Betasoides. Cada civilización vive en paz en su respectivo planeta.

Dominan la predicción del clima mediante un complejo sistema informático. A continuación el diagrama del sistema solar.

## Premisas:

* El planeta Ferengi se desplaza con una velocidad angular de 1 grados/día en sentido horario. Su distancia con respecto al sol es de 500Km.
* El planeta Betasoide se desplaza con una velocidad angular de 3 grados/día en sentido horario. Su distancia con respecto al sol es de 2000Km.
* El planeta Vulcano se desplaza con una velocidad angular de 5 grados/día en sentido anti­horario, su distancia con respecto al sol es de 1000Km.
* Todas las órbitas son circulares.

Cuando los tres planetas están alineados entre sí y a su vez alineados con respecto al sol, el sistema solar experimenta un período de sequía. Cuando los tres planetas no están alineados, forman entre sí un triángulo. Es sabido que en el momento en el que el sol se encuentra dentro del triángulo, el sistema solar experimenta un período de lluvia, teniendo éste, un pico de intensidad cuando el perímetro del triángulo está en su máximo.

Las condiciones óptimas de presión y temperatura se dan cuando los tres planetas están alineados entre sí pero no están alineados con el sol.


## Preguntas
Realizar un programa informático para poder predecir en los próximos 10 años:

1. ¿Cuántos períodos de sequía habrá?
2. ¿Cuántos períodos de lluvia habrá y qué día será el pico máximo de lluvia?
3. ¿Cuántos períodos de condiciones óptimas de presión y temperatura habrá?


## Bonus:
Para poder utilizar el sistema como un servicio a las otras civilizaciones, los Vulcanos requieren tener una base de datos con las condiciones meteorológicas de todos los días y brindar una API REST de consulta sobre las condiciones de un día en particular.

1. Generar un modelo de datos con las condiciones de todos los días hasta 10 años en adelante utilizando un job para calcularlas.
2. Generar una API REST la cual devuelve en formato JSON la condición climática del día consultado.
3. Hostear el modelo de datos y la API REST en un cloud computing libre (como APP Engine o Cloudfoudry) y enviar la URL para consulta: Ej: GET → http://....../clima?dia=566 → Respuesta: {“dia”:566, “clima”:”lluvia”}

## Respuesta

### API hosteada en Amazon AWS usando Elastic Beanstalk

- [Solar System API](http://solarsystem-env.eba-v92vtivz.us-east-2.elasticbeanstalk.com/swagger-ui.html).


Metodos curl para ejecutar los metodos de la API:

* Para generar la simulacion del sistema solar
```
curl -X POST "http://localhost:9090/simular" -H "accept: */*"
```

* Para obtener el resultado de la simulacion
```
curl -X GET "http://localhost:9090/resultado" -H "accept: application/json"
```

* Para obtener el clima de un dia especifico
```
curl -X GET "http://localhost:9090/clima?dia=2" -H "accept: application/json"
```


### Tecnologías utilizadas

* [JAVA](https://www.java.com/)
* [Spring boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)
* [H2 database](https://www.h2database.com/)
* [Swagger](https://swagger.io/)
* [Lombok](https://projectlombok.org/)
