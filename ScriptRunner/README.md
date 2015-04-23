# !!!! WARNING WARNING WARNING !!!!
This Web Script allows callers to execute arbitrary logic on the Alfresco server, and that logic has full access to not only the native Alfresco Foundation Service API, but also the entire Java API as well.

THIS MEANS THAT VIRTUALLY LIMITLESS DAMAGE CAN BE CAUSED IF THIS WEB SCRIPT IS USED INAPPROPRIATELY.

For that reason the Web Script can only be used by administrators, but that doesn't provide any defense if the admin password has not been changed from its default value.

## Description
This module is a Groovy backed Web Script that allows the user to submit arbitrary Groovy scripts to the server for execution.  These scripts have full access to the Alfresco Foundation Services API (via the Alfresco ```ServiceRegistry```) as well as full access to native Java APIs (via Groovy's standard integration with the JVM and Java class libraries).

## Author
Peter Monks (pmonks@alfresco.com)

## Pre-requisites
* Alfresco (Community or Enterprise) v4.0 or greater.
* The "Common" Groovy backed Web Script module has been installed (see https://github.com/pmonks/alfresco-groovy-webscripts/tree/master/Common for details).

## Installation
1. Compile and package an AMP file for this project using the provided Maven build script:
      ```mvn clean package```
2. Install the AMP using the Module Management Tool.

## Running a Custom Groovy Script
1. Start Alfresco
2. Browse to ```http://[alfresco_host]:[alfresco_port]/alfresco/s/groovy/scriptrunner```
3. Login as an admin user
4. Type in any valid Groovy script eg. [1..100]
5. You should receive a response in JSON format (note that your browser may ask you to save the response to disk - some browsers don't handle the JSON MIME type themselves)

## Notes on Uploaded Scripts
* Uploaded scripts have access to the Alfresco Foundation Services API via the ```ServiceRegistry``` (see http://dev.alfresco.com/resource/docs/java/repository/org/alfresco/service/ServiceRegistry.html). The ```ServiceRegistry``` gets injected into the script automatically and is accessible via a global variable called "serviceRegistry".
* The result of the last line of the script is converted into JSON format and returned by the script.  This means that arbitrarily complex result sets can be generated as a POGO graph, and then simply returned off the end of the script to be returned to the caller.  Note that this is done entirely in memory, so extremely large POGO graphs may cause Alfresco to run out of memory.
