/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alicebot.ab.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.Normalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author skost
 */
public class SprintUtils {
    private static final Logger log = LoggerFactory.getLogger(SprintUtils.class);
    
    
    public static String unaccent(String src, boolean isPolishMarks) 
    {
        String temp = src;
        if(src==null)
            return null;
        
        
        if(!isPolishMarks)
        {            
            temp = Normalizer.normalize(src.replaceAll("[łŁ]", "l"), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");   
        }
            
        temp = temp.replaceAll("[?]", "").replaceAll("[!]", "").replaceAll("[.]", "");
                             
        return temp;
    }  
    
    public static String callPlugin(String file, String classLoad, String methodName, String parameter, String sessionId)
    {
        //"pl.sprint.chatbot.ext.Test"
        
        //log.info("file: " + file + " classLoad: " + classLoad + " methodName: " + methodName + " parameters: " + Arrays.toString(parameters));
        String f = "jar:file:///" + file + "!/";
        String out = "";
        try {
            
                                    
            URL[] classLoaderUrls = new URL[]{new URL(f)};         
            // Create a new URLClassLoader 
            URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);

            // Load the target class
            Class<?> beanClass = urlClassLoader.loadClass(classLoad);

            // Create a new instance from the loaded class
            Constructor<?> constructor = beanClass.getConstructor();             

            Object beanObj = constructor.newInstance();

            //ChatBotRequest request = new ChatBotRequest(methodName, parameter, sessionId);

            // Getting a method from the loaded class and invoke it
            
            // public String processCustomResultPocessor(String session, String parameter, String method);
            Method method = beanClass.getMethod("processCustomResultPocessor", String.class, String.class, String.class);    
            String response = (String) method.invoke(beanObj, sessionId, parameter, methodName);
            log.info("Request: sessionId: " + sessionId + " parameter: " + parameter + " method: " + methodName + " plugin response: " + response);
            
            out = response;
            
        } catch (Exception e) 
        {
            out = "ERROR|" + e.getMessage();
            log.error("callPlugin file: " + f + " parameter : " +parameter + " ERROR : " + e, e);
        }
        
        return out;
    }
    
    
    
    public static String readBashScript(String scrip, String parameters)
    {                
        String out = "";
        
        if (scrip == null)
            return out;
          
        
        if(System.getProperty("os.name").equals("Linux"))
            scrip+=".sh";
        else
            scrip+=".bat";
        
        try {
            Process proc = Runtime.getRuntime().exec("external/" + scrip + " " + parameters); 
            BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            try {
                proc.waitFor();
            } catch (InterruptedException ex) {
                log.error("readBashScript script: " + scrip + " parameters : " +parameters + " InterruptedException ERROR : " + ex, ex); 
            }
            while (read.ready()) {
                out = read.readLine();
            }
        } catch (IOException e) {
            log.error("readBashScript script: " + scrip + " parameters : " +parameters + " IOException ERROR : " + e, e); 
        }
        
        log.info("readBashScript: scrip = {} parameters = {} [response = {}]",scrip, parameters, out);
        return out;
    }
}
