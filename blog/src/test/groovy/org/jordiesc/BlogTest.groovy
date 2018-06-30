package org.jordiesc

import static org.junit.jupiter.api.Assertions.*

import org.jordiesc.blog.Header
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import javax.swing.DebugGraphics

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import groovy.sql.ResultSetMetaDataWrapper
import groovy.util.logging.Slf4j

import rg.codehaus.groovy.reflection.*

@Slf4j
class BlogTest {
	@ParameterizedTest
	@ValueSource(strings  = [ "2014-06-30", "2018-06-1","2018-1-1" ])
	void "create Header valid Dates"(date) {
		def header = new Header()
		def name = "hola"
		def description ="caracola"
		
		def streheader = header.createHeader(name, description, date,null)
		print streheader
		
		def gstring =  header.template
		
		assumeTrue(gstring==streheader)
	}
	/**
	 * this tets match taht the error has happened
	 * @param date
	 */
	@ParameterizedTest
	@ValueSource(strings  = [ "2014-06-XX", "201-06-1","2018-999-1" ])
	void "invalids  Dae in Header"(date) {
		boolean error = false;
		def header = new Header()
		def name = "hola"
		def description ="caracola"
		try {
			 header.createHeader(name, description, date,null)
		} catch (AssertionError e) {
			println "Something bad happened: " + e.getMessage()
			error = true;
		}
		assertTrue(error)
	}
	
	@Test
	void "crear Json"(){
		def header = new Header()
		def headerjson = header.createHeader("programing", "json de prueba", "2016-02-02",["java","groovy"])
		def result = """////---
{"name":"programing","description":"json de prueba","date":"2016-02-02","tags":["java","groovy"]}
---////"""
		assertTrue(result == headerjson)
	}
	
	@ParameterizedTest
	@ValueSource(strings  = [ "headertest.adoc" ,"headertesttags.adoc"])
	void "read Header from file "(namefile){
		
		def header = new Header()
		def fileheader = new File("src/test/resources/$namefile")
		header.readHeader(fileheader)
		
		assertTrue(header.name == "programing")
		assertTrue(header.description == "json de prueba")
	}
	
	
	@Test
	void "tags weell readed"() {
		def header = new Header()
		def fileheader = new File("src/test/resources/headertesttags.adoc")
		header.readHeader(fileheader)
		
		assertTrue(header.name == "programing")
		assertTrue(header.description == "json de prueba")
		assertTrue(header.tags[0] == "java")
		assertTrue(header.tags[1] == "groovy")
	}
	
}
