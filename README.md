# Alas d.o.o. Java developer test assignment

## How to run the application

1. Install Java 8: Go to https://adoptopenjdk.net/ and download version 8. If the Operating System is Windows: set the system environments for `JAVA_HOME` (jdk root folder) and `PATH` (jdk root folder\bin)
2. To start the backend run `mvnw spring-boot:run` command (control + c will kill the application)
3. Build the frontend: `cd src/frontend`, `yarn`. (install `yarn` and `node` if needed)
4. To start the frontend go to `src/frontend` and run `yarn start`. It will run on `localhost:3000`.

## How to run automated tests

You can run tests from command line if you positionate to the root directory of project and type mvn test.

Default browser is set to Firefox, but you have options to run it in Internet Explorer, Microsoft Edge and Chrome.

If you want to specify certain browser for testing you can type `mvc test -D browser="{browser}"`.
{browser} could be replaced with some of these parameters (lower or upper case does not matter):

1. `chrome` - Chrome
2. `ie` - Internet Explorer
3. `edge` - Microsoft Edge

You need to download a WebDrivers based on version of browser which you have locally.
So, files in drivers folder could work if you have browser with this build version in other cases you need to replace them.
