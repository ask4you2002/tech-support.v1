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
    HashMap<String, String> respuestasHash;
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
        respuestasHash.put("slow","I think this has to do with your hardware. Upgrading your processor should solve all performance problems. Have you got a problem with our software?");
        respuestasHash.put("work","If our software doesn't work, try to restart your computer or updating your system's software");
        respuestasHash.put("connect","Be sure you have internet connection, before openning our software. If you open the software without connection, the program won't work at all.");
        respuestasHash.put("device", "That has to do with drivers. If your computer doesn't recognise the device, try to update them.");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {   
        String aDevolver = null;
        Iterator<String> inputIterator = userInput.iterator();
        while (inputIterator.hasNext()) {
            String nextIteration = inputIterator.next();
            if (respuestasHash.containsKey(nextIteration)) {
                aDevolver = respuestasHash.get(nextIteration);
            } else {
                int numeroAleat = numero.nextInt(respuestas.size());
                aDevolver = respuestas.get(numeroAleat);
            }
        }
        return aDevolver;
    }
}
