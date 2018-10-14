package org.jordiesc.storage

import groovy.util.logging.Slf4j
import groovy.sql.Sql

@Slf4j
class Storage {

    String dbpath

    void createDB(String pathfile){
        this.dbpath = pathfile ?:  "blog.db"
		def sql = Sql.newInstance( 'jdbc:sqlite:$dbpath', '' , '' , 'org.sqlite.JDBC' )
	}
	
	void initTablesDDL() {
		def sql =''' CREATE TABLE IF NOT EXISTS entry 
		(	id text primary key,
			name text,
			category text,
			content text,
			datecreation text,
			dateupdate text
		) '''
	}
	def insertEntry(Map entry) {
		def insert ='''
			INSERT into entry (id,name,category,content,datecreation,dateupdate)
			VALUES ($id,$name,$category,$content,$datecreation,$dateupdate)
		'''
	}
}
class Entry {
	String id,name,category,content
	Date datecreration,dateupdate
	
	
}