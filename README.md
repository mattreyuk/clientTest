# clientTest
If you add the `nphs-ref-commercefacility-1.0-SNAPSHOT-stubs.jar` to your local Maven repo under `com/example/nphs/ref/nphs-ref-commercefacility` and build the project, the `ApplicationTest` will run the client and startup stubrunner to serve the stub data. The client service has Eureka and Config clients included. These are turned off by the `standalone` profile set in the test class.

 The stubrunner container tries to connect to a config server on `localhost:8888` and after the set number of retries, aborts due to `failFast` which fails the test.

 Doing some digging, it appears that the stubrunner starts with a `development` profile. If you uncomment the `development` profile section in the `bootstrap.yml`, the test will run correctly.
