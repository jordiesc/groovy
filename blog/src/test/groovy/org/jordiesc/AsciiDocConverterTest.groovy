package org.jordiesc

import org.asciidoctor.Asciidoctor
import static org.asciidoctor.Asciidoctor.Factory.create;
import org.asciidoctor.OptionsBuilder
import static org.asciidoctor.SafeMode.UNSAFE;

import static org.asciidoctor.AttributesBuilder.attributes;
import static org.asciidoctor.OptionsBuilder.options;

import org.asciidoctor.Options;
import org.asciidoctor.SafeMode;
import org.asciidoctor.Attributes;

import spock.lang.*

class AsciiDocConverterTest extends Specification {
	
		/**
		 * write basic block html
		 * @return
		 */
		def "testSimplehtmlBlock" (){
			given:
			print "hola caracola test"
			
			def resource = AsciDooConverter.class.getClassLoader().getResourceAsStream("sample.adoc").getText()
			
			print resource
				
			Asciidoctor asciidoctor = create();
			
			def result = asciidoctor.convert(resource, new HashMap<String, Object>());
			
			print result
		}
		
		def "testfullhmtml" () {
			given:
/*
						def options = OptionsBuilder.options()
				.backend("xhtml5")
				.safe(UNSAFE).get()
	*/		
			def resource = AsciDooConverter.class.getClassLoader().getResourceAsStream("sample.adoc").getText()
				
			print resource
			
			Options options = new Options();
			options.setHeaderFooter(true);
			
			Attributes attr = new Attributes()
			
			attr.setSourceHighlighter("highlightjs")
			attr.setStyleSheetName("dark.css")
			
			options.setAttributes(attr)
			
			
						
			Asciidoctor asciidoctor = create();
			String rendered = asciidoctor.convert(resource, options);
			
			
			
			print rendered;

	
			 
			
		}
		
		
}
