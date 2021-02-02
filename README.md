# spring-data-demo
# Example Spring data project
Demo project for stack-overflow question: [why-is-spring-data-jpa-repository-save-performing-an-insert-and-an-update-one-af](https://stackoverflow.com/questions/66014470/why-is-spring-data-jpa-repository-save-performing-an-insert-and-an-update-one-af)

## Requirements
1. Docker
2. Java 11 

## Database 
Just run 
```shell
docker-compose up -d db
```
And a new postgresql database will be lauched, one that is bound to `localhost:5432` on your machine.

## Spring app 
Just run the application in your ide or from the command line.
Running ```gradle bootRun ``` will launch the app. The default port is `8001` in case
something is already running on `8080`, you can change that in [application.yaml](src/main/resources/application.yaml).

## OpenApi docs 
A swagger ui is present to facilitate the test, the endpoints are pretty self-explanatory.
Provided you've launched the app with the default settings you can access the swagger ui [here](http://localhost:8001/swagger-ui.html).