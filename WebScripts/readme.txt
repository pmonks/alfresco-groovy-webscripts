!!!! WARNING WARNING WARNING !!!!
---------------------------------
One of these Web Scripts allows callers to execute arbitrary logic on the
Alfresco server, and that logic has full access to not only the Alfresco Java
API, but the entire Java API as well.

THIS MEANS THAT VIRTUALLY LIMITLESS DAMAGE CAN BE CAUSED IF THIS WEB SCRIPT
IS USED INAPPROPRIATELY.

For that reason the Web Script can only be used by administrators, but that
doesn't provide any defense if the admin password has not been changed from
its default value.


Description
-----------
This module contains two Groovy backed Web Scripts that:
1. allow an admin to submit arbitrary Groovy scripts to the server for
   execution.
2. allow a user to submit a CMIS query to the server for execution.


Author
------
Peter Monks (pmonks@gmail.com)


Pre-requisites
--------------
* Alfresco (Community or Enterprise) v4.0 or greater.

* The "Common" Groovy backed Web Script module has been installed (see
  http://code.google.com/p/alfresco-groovy-webscripts/source/browse/Common/readme.txt for
  details).


Installation
------------
1. Compile and package an AMP file for this project using the provided Maven
   build script:
      mvn clean package

2. Install the AMP using the Module Management Tool.


Running a CMIS Query
------------------------------
1. Start Alfresco

2. Browse to
   http://[alfresco_host]:[alfresco_port]/alfresco/s/groovy/cmisquery

3. Login as an Alfresco user

4. Type in any valid CMIS query (e.g. "SELECT * FROM cmis:document")

5. You should receive a formatted HTML table containing the matching result set.


Running a Groovy Script
-----------------------
1. Start Alfresco

2. Browse to
   http://[alfresco_host]:[alfresco_port]/alfresco/s/groovy/scriptrunner

3. Login as an admin user

4. Type in any valid Groovy script (e.g. "[1..100]")

5. You should receive a response in JSON format (note that your browser may
   ask you to save the response to disk - some browsers don't handle the JSON
   MIME type themselves)


Notes on Groovy Scripts
-----------------------
* Uploaded scripts have access to the Alfresco Foundation Services API via the
  ServiceRegistry (see
  http://dev.alfresco.com/resource/docs/java/repository/org/alfresco/service/ServiceRegistry.html).
  The ServiceRegistry gets injected into the script automatically and is
  accessible via a global variable called "serviceRegistry".

* Uploaded scripts have access to Alfresco's entire Spring ApplicationContext (see
  http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/beans.html).
  The ApplicationContext gets injected into the script automatically and is
  accessible via a global variable called "applicationContext".
  Be very careful using this object, as incorrect use can damage your Alfresco
  installation or repository!

* The result of the last line of the script is converted into JSON format and
  returned by the script.  This means that arbitrarily complex result sets can
  be generated as a POGO graph, and then simply returned off the end of the
  script to be returned to the caller.  Note that this is done entirely in
  memory, so extremely large POGO graphs may cause Alfresco to run out of
  memory.

* The script will run in a single Alfresco transaction, so care must be taken if
  lengthy processing is undertaken by the Groovy script.
