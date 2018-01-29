package com.jordi.spock

import static groovyx.net.http.HttpBuilder.configure

import groovyx.net.http.HttpBuilder


 

/**
 *
 * @author jordi
 */
class SimpleRestClient {
    
    def url
    def json
    
   SimpleRestClient(url,json){
       this.url = url
       this.json = json
   }
    
   def retorno(){ 
     
    def httpBin = HttpBuilder.configure {
        request.uri = 'http://localhost:8080/'
    }
    def result = httpBin.post {
        request.uri.path = '/tasques'
        request.contentType = 'application/json'
        request.body = json
    }
    
    return result
   }	
    
}

