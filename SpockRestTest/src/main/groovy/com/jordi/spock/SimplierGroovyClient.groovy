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
class SimplierGroovyClient {
	

    public static String getResponse(String url,String json){
        
    final HttpURLConnection connection = makeURL(url).toURL().openConnection()
    connection.setDoOutput(true)
    connection.setRequestMethod("POST")
    connection.setRequestProperty("Content-Type", "application/json")
    connection.outputStream.withWriter { Writer writer ->
        writer << json    }

 

    String response = connection.inputStream.withReader { Reader reader -> reader.text }
    
    print response
    }




}

