/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jordi.spock

/**
 *
 * @author jordi
 */
class MainGroovySpock {
    
       static void main(args) {
         println "Hello from Groovy!"
         
        def json = """
        
        {
  "codigo": "caracola",
  "descripcion": "pepe",
  "horas": 0
}
"""
         
        def clienteRest = new SimpleRestClient("",json)
        println clienteRest.retorno()
        
        SimplierGroovyClient.getResponse("http;//localhost:8080",json)
   }
	
}

