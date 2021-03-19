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

    Random numero;
    ArrayList<String> respuestas;
    HashMap<HashSet<String>, String> respuestasHash;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        numero = new Random();
        respuestas = new ArrayList<String>();
        respuestas.add("Do you need help?");
        respuestas.add("I'll help you with that");
        respuestas.add("Hi. I'm the Tech Support. Do you have any problem with our product?");
        respuestas.add("If you have any problem, I'll try my best to help you");
        respuestas.add("I don't understand that...Can you explain more?");
        respuestas.add("That sounds interesting. Tell me more...");

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

        respCompleja1.add("free");
        respCompleja1.add("app");

        respCompleja2.add("problem");
        respCompleja2.add("linux");
        respCompleja2.add("crash");

        respCompleja3.add("input");
        respCompleja3.add("device");

        respCompleja4.add("internet");
        respCompleja4.add("connection");

        respuestasHash.put(respCompleja1, "The app is free. Although, you can pay for the extra version.");
        respuestasHash.put(respCompleja2, "Our software is not supportedd for Linux OS.");
        respuestasHash.put(respCompleja3, "Be sure the cable you are using works correctly, and update your drivers.");
        respuestasHash.put(respCompleja4, "Our app doesnt work without internet connection. Be sure to be connected to an internet connection before openning it.");

       
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {   
        String aDevolver = null;
        Iterator<String> inputIterator = userInput.iterator();

        if (respuestasHash.containsKey(userInput)) {
            aDevolver = respuestasHash.get(userInput);
        } else {
            int numeroAleat = numero.nextInt(respuestas.size());
            aDevolver = respuestas.get(numeroAleat);
        }
        return aDevolver;
    }
}
