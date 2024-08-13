# TestAstra
A simple application that runs queries against the `system.local` table on Astra DB using the Java client.

## Requirements
 - Java 21
 - Maven
 - An [Astra DB](astra.datastax.com) account and active database.

## Environment Variables
_Note: This app uses the old CLIENT_ID/SECRET method of authentication._
 - `CLIENT_ID`: The generated clientId for a role.
 - `SECRET`: The generated secret for a role.
 - `SECURE_CONNECT_BUNDLE`: Full path of the Astra DB database's `secure_connect_bundle.zip` file.

## To Build
```
mvn clean install
```

## To Run
```
java -jar target/testastra-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

Output:
```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
4.0.11-09ec37c912ed
9d4e5590-597f-11ef-b3c5-673ade8c6a44
1723559010738
1723559015378
```
