package org.jordiesc.blog

import groovy.json.JsonGenerator
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j

@Slf4j
class Header {
	def name
	def description
	def date
	def tags 
		
	def template = { jsonresult ->"""////---
$jsonresult
---////"""
	}

	def createHeader(String name,String description,String date,List tags) {
		def matcher = (date ==~ /20[0-9]{2}-[0-9]{1,2}-[0-3]{1,2}/)
		assert matcher == true
		
		this.name = name
		this.description = description
    	this.date = date ?: new Date().parseTemplate("yyyy-mm-dd")
		//this.tags = tags ?: String[]
		this.tags = tags
		
		def generator = new JsonGenerator.Options().excludeNulls().build()
		def jsonheader = generator.toJson([name:this.name,description:this.description, date:this.date,tags:this.tags])
		log.info("json header is :"+jsonheader)
		def resutlTemplate = template(jsonheader)
		
		
		}
	
	def parseTemplate(String code) {
		def matcher = (code  ==~ /20[0-9]{2}-[0-9]{1,2}-[0-3]{1,2}/)

	}
	/**
	 * the header must to start with 
	 * ////---
	 * 	JSON content here
	 * ---////
	 * @param filename
	 * @return
	 */
	
	def readHeader(File filename){
		
		boolean init
		boolean fin
		int i =0
		String jsonstring = ""
		
		filename.eachLine {  line ->  
			 log.debug("the line is "+line)
			 def begginer = ( line ==~ /\/{4}-{3}/ )
			 def endding = (line ==~ /-{3}\/{4}/ )
			
			 if (begginer)
				 init = true
			 else if (endding) {
				 fin = true
				 
			 }else {
				 //la llogica es si no es linici y encara no ha arribat al final sagrega
				 if (init && !fin)
					 jsonstring = jsonstring + line
				log.debug("json string is"+jsonstring)	  
			 }
			 	 
		} 
		log.debug("the header is "+jsonstring)
		JsonSlurper jsonSlurper = new JsonSlurper();
        Object json = jsonSlurper.parseText(jsonstring);
		this.name = json.name
		this.description = json.description
		this.date = json.date
		this.tags = json.tags;
	
	}
}
