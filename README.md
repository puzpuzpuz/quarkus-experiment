# quarkus-experiment project

Simple experiment aimed towards understanding memory footprint of Quarkus (GraalVM) native image in combination with Hazelcast client.

## Build

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-experiment-1.0.0-SNAPSHOT-runner`

## Test

```shell script
curl -X POST -H "Content-Type: text/plain" -d '{"foo": "bar"}' http://127.0.0.1:8080/api/testmap/testkey
```

## Load Test

```shell script
npx autocannon -c 10 -d 10 -m POST -b "testvalue" -H "Content-Type: text/plain" http://localhost:8080/api/testmap/testkey
```
