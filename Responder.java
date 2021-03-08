import java.util.Random;
import java.util.ArrayList;
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
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {   
        int numeroAleat = numero.nextInt(respuestas.size());
        return respuestas.get(numeroAleat);
    }
}
