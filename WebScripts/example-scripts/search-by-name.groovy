import org.alfresco.service.cmr.repository.*

def output = []
def searchTerm = "Alfresco"

def ss = serviceRegistry.getSearchService();
def results = ss.query(StoreRef.STORE_REF_WORKSPACE_SPACESSTORE , ss.LANGUAGE_LUCENE, "@cm\\:name:${searchTerm}")
def iter = results.iterator();

while (iter.hasNext())
{
  def result = iter.next();

  output << result.getNodeRef().toString()
}

output
