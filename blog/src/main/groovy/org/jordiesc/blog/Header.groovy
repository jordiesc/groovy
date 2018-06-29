package org.jordiesc.blog

class Header {
	String name
	String description
	String date
	
	def headertemplate = { name,description,date ->
"""///---
///name:$name
///description:$description
///date:$date
///---
"""}

	def createHeader(String name,String descrition,String date) {
		def resutlTemplate = headertemplate(name,description,date)
	}
	
	
}
