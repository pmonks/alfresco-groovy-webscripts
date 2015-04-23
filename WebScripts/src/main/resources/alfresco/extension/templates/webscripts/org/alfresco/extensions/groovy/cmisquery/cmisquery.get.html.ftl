[#ftl]
<!doctype html>
<html>
<head>
<title>Alfresco CMIS Query Tool</title>
<link rel="stylesheet" href="/alfresco/css/main.css" type="text/css"/>
</head>
<body>
<div style="display:block;width:100%;height="35%">
  <div style="display:inline-block;vertical-alignment:top;width=75%">
    <h2>CMIS query:</h2>
    <form style="display:inline" method="POST" action="${url.service}" target="results">
      <textarea cols="160" rows="20" name="cmisQuery"></textarea>
      <br/>
      <button type="submit"><span style="font-size:150%;font-weight:bold">&nbsp;&nbsp;&nbsp;&nbsp;Go!&nbsp;&nbsp;&nbsp;&nbsp;</button>
    </form>
  </div>
  <div style="float:right;display:inline-block;vertical-alignment:top;width=25%">
    <h2>Notes:</h2>
    <ul>
      <li>The query is executed with the "Alfresco" version of CMIS-QL.</li>
    </ul>
  </div>
</div>
<div style="display:block;width:100%;height:60%">
  <h2>Results:</h2>
  <iframe style="width:99%;height:55%" name="results" src=""></iframe>
</div>
</body>
</html>
