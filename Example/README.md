## Description
This module is an example showing how to implement a Groovy backed Web Script.

## Author
Peter Monks (pmonks@alfresco.com)

## Pre-requisites
* Alfresco (Community or Enterprise) v4.0 or greater.
* The "Common" Groovy backed Web Script module has been installed (see https://github.com/pmonks/alfresco-groovy-webscripts/tree/master/Common for details).

## Installation
1. Copy the *contents* of the ```/src/main/resources/alfresco/extension``` directory to ```${ALFRESCO_HOME}/tomcat/shared/classes/alfresco/extension```

NOTE: This code is not intended for production use and should not be installed
on a production system.

## Running the Example
1. Start Alfresco
2. Browse to ```http://[alfresco_host]:[alfresco_port]/alfresco/s/groovy/helloworld```
3. Login as an admin user

## Testing Hot Redeployment
While Alfresco is still running:

1. Open ```${ALFRESCO_HOME}/tomcat/shared/classes/alfresco/extension/groovy/webscripts/HelloWorldGroovyWebScript.groovy``` in a text editor
2. Change the greeting
3. Save the file
4. Refresh ```http://[alfresco_host]:[alfresco_port]/alfresco/s/groovy/helloworld``` in your browser
5. Repeat steps 2 through 4 several times
6. Bask in the knowledge that you didn't have to restart Alfresco at all during this process!  :-)

## TODO
* Demonstrate use of ```ServiceRegistry``` and/or other Alfresco APIs from within the Groovy script.
* Demonstrate use of Javascript in conjunction with this Web Script (it's based on the ```DeclarativeWebScript``` class, which supports mixed Java / Javascript / Freemarker Web Scripts).
