# Jtwig + Spring Boot + Angular JS 2

This is a simple example of how to use Jtwig combined with Spring Boot and Angular JS 2.

## Starting server

```bash
# Start spring boot on port 8080
gradle bootRun

# Start with dev profile (with hot file reload)
gradle bootRun -Pprofile=dev
```

## Bundle app in jar

```bash
gradle bootRepackage
```