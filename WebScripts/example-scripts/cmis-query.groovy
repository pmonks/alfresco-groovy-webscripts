import org.alfresco.service.cmr.repository.*

def output = []
def cmisQuery = """
SELECT *
FROM cmis:document
"""

def ss = serviceRegistry.getSearchService();
def results = ss.query(StoreRef.STORE_REF_WORKSPACE_SPACESSTORE , ss.LANGUAGE_CMIS_ALFRESCO , cmisQuery)
def iter = results.iterator();

while (iter.hasNext())
{
  def result = iter.next();

  output << result.getNodeRef().toString()
}

output
