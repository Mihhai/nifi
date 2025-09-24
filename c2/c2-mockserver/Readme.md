# C2 Mock Server

The purpose of this code is to generate OpenAPI Specs for the C2 interface.

## Instructions

A make file is provided with the common commands. Note that some dependencies are required from the nifi project itself. So it would be best to run `mvn clean install` at least once from the root nifi source.

For building the mock server you can run (from c2-mockserver workdir):

```
# this will run mvn clean package and generate the jar file
make
```

To run the mock server, execute this:

```
make run
```

An alternate way to run the spring application is this:
```
mvn spring-boot:run
```

The openapi spec should be available here:
`http://localhost:8080/swagger-ui/index.html`

The [Makefile](Makefile) also provides some docker options. Refer to the file itself.