# Quarkus Testing



> Rest Assured and JUnit out-of-the-box
> Uses RestEasy client


# Links

1. [Quarkus Guides](https://quarkus.io/guides/)



# Native Test


Need to install GraalVM CLI [GraalVM Updater]() `gu` and native-image
 
    gu install native-image

After installing pre-requisites, run Native tests by running this:

```shell script
mvn verify -Dnative
```


# Test containers

# Source Code

## Test

1. `TestContainersDatabase`

Setup database. (Uses docker without need to install docker in your local machine)


2. `FruitResourceTest`