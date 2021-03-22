
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{

    private Random numero;
    ArrayList<String> respuestas;
    HashMap<HashSet<String>, String> respuestasHash;
    private String respuestaMemoria;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        numero = new Random();
        respuestas = new ArrayList<String>();
        respuestaMemoria = null;
        respuestas.add("Do you need help?");
        respuestas.add("I'll help you with that");
        respuestas.add("Hi. I'm the Tech Support. Do you have any problem with our product?");
        respuestas.add("If you have any problem, I'll try my best to help you");
        respuestas.add("I don't understand that...Can you explain more?");
        respuestas.add("That sounds interesting. Tell me more...");
        respuestas.add("Did you get error 101?");

        respuestasHash = new HashMap<>();

        HashSet<String> respSimple1,respSimple2,respSimple3,respSimple4;

        respSimple1 = new HashSet<>();
        respSimple2 = new HashSet<>();
        respSimple3 = new HashSet<>();
        respSimple4 = new HashSet<>();

        respSimple1.add("slow");
        respSimple2.add("work");
        respSimple3.add("stuck");
        respSimple4.add("device");

        respuestasHash.put(respSimple1,"I think this has to do with your hardware. Upgrading your processor should solve all performance problems. Have you got a problem with our software?");
        respuestasHash.put(respSimple2,"If our software doesn't work, try to restart your computer or updating your system's software");
        respuestasHash.put(respSimple3,"Our software runs many processes when you open the app. If it's stucked, wait a short time: closing the app might break the files.");
        respuestasHash.put(respSimple4,"That has to do with drivers. If your computer doesn't recognise the device, try to update them.");

        HashSet<String> respCompleja1 = new HashSet<>();
        HashSet<String> respCompleja2 = new HashSet<>();
        HashSet<String> respCompleja3 = new HashSet<>();
        HashSet<String> respCompleja4 = new HashSet<>();
        HashSet<String> respCompleja5 = new HashSet<>();
        HashSet<String> respCompleja6 = new HashSet<>();

        respCompleja1.add("free");
        respCompleja1.add("app");

        respCompleja2.add("problem");
        respCompleja2.add("linux");
        respCompleja2.add("crash");

        respCompleja3.add("input");
        respCompleja3.add("device");

        respCompleja4.add("problem");
        respCompleja4.add("corrupt");
        respCompleja4.add("windows");

        respCompleja5.add("error");
        respCompleja5.add("code");

        respCompleja6.add("error");
        respCompleja6.add("code");
        respCompleja6.add("101");

        respuestasHash.put(respCompleja1, "The app is free. Although, you can pay for the extra version.");
        respuestasHash.put(respCompleja2, "Our software is not supportedd for Linux OS.");
        respuestasHash.put(respCompleja3, "Be sure the cable you are using works correctly, and update your drivers.");
        respuestasHash.put(respCompleja4, "Our app doesnt work without internet connection. Be sure to be connected to an internet connection before openning it.");
        respuestasHash.put(respCompleja5, "Did you get a code or error message? Can you tell me what number?(101,140,192..))");
        respuestasHash.put(respCompleja6, "Error code 101 occurs when the app has been closed when loading. Delete a file from appdata/config called logfile.cmd.");

    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {   
        String aDevolver = null;
        int contador = 0;
        int minimo = 0;
        
        Iterator<HashSet<String>> respuestasIterated = respuestasHash.keySet().iterator();
        
        while (respuestasIterated.hasNext()){
            HashSet<String> respHash = respuestasIterated.next();
            for (String key : respHash){
                if(userInput.contains(key)){                   
                    contador++;                                   
                }  
            }
            if (contador > minimo){
                aDevolver = respuestasHash.get(respHash);
                minimo = contador;
            }              
            
            contador = 0;
        }
           
        if (minimo == 0 || respuestaMemoria == aDevolver){
            aDevolver = respuestas.get(numero.nextInt(respuestas.size()));
        }
        respuestaMemoria = aDevolver; 
        return aDevolver;
    }
}