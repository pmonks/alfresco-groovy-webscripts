[#ftl]
<html>
<head>
<title>Alfresco CMIS Query Tool</title>
<link rel="stylesheet" href="/alfresco/css/main.css" type="text/css"/>
</head>
<body>
<div style="float:left;width:60%;height:50%">
  Type your Groovy script here:<br/>
  <form method="POST" action="${url.service}.json" target="results">
    <textarea cols="160" rows="25" name="cmisQuery"></textarea>
    <br/>
    <input type="submit" value="Go!"/>
  </form>
</div>
<div style="float:right;width:40%;height:50%">
  <br/>
  Notes:
  <ul>
    <li>The query is executed with the "Alfresco" version of CMIS-QL.</li>
  </ul>
</div>
<div style="width:100%;height:300px">
  Results:</br/>
  <iframe style="width:80%;height:300px" name="results" src=""></iframe>
</div>
</body>
</html>
