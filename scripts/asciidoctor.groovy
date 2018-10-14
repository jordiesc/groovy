    @Grab('org.asciidoctor:asciidoctor-maven-plugin:1.5.3')

import org.asciidoctor.Asciidoctor
import static org.asciidoctor.Asciidoctor.Factory.create
if (args[0]) {

   fileContents = new File(args[0]).text
   print fileContents 

}
Asciidoctor asciidoctor = create();
def result = asciidoctor.convert(fileContents, new HashMap<String, Object>());
	
print result
