package org.jordiesc;

import static org.asciidoctor.Asciidoctor.Factory.create;
import org.asciidoctor.Asciidoctor;

public class AsciDooConverter {

    static void main(String[] args) {
        print "hola caracola"
		def resource = AsciDooConverter.class.getClassLoader().getResourceAsStream("sample.adoc").getText()
		
		print resource
		
		
		Asciidoctor asciidoctor = create();
		
		def result = asciidoctor.convert(resource, new HashMap<String, Object>());
		
		print result
		
    }
}