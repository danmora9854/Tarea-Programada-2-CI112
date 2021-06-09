
/**
 * Clase que maneja las notas. Estas son listas simples de elementos.
 *
 * @author (Juan José Bermúdez Vargas y Daniel Mora Mora)
 * @version (08.06.2021)
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Nota
{
    String titulo;
    ArrayList <String> lista;
    
    public Nota (String titulo)
    {
        this.titulo = titulo;
        lista = new ArrayList <String> ();
    }
    
    public void guardeElementos ()
    {
        boolean hayElementos = true;
        while (hayElementos)
        {
            //Pregunta con JOption lo que quiere ingresar y lo guarda en una string
            String elemento = null;
            lista.add(elemento);
            
            //Pregunta con JOption si hay más elementos a ingresar en la lista. Si no es así hace hayElementos = false
        }
    }
}
