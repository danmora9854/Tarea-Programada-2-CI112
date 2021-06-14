
/**
 * Clase que maneja todas las listas de tareas.
 *
 * @author (Juan José Bermúdez Vargas y Daniel Mora Mora)
 * @version (08.06.2021)
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Agenda
{
    //Aca va a guardar las diversas listas de tareas
    public ArrayList <Lista> coleccion;
    
    public Agenda ()
    {
        coleccion = new ArrayList <Lista> ();
    }
    
    /**
     * Método que agrega una lista de tareas a la colección.
     */
    public void agregarLista ()
    {
        //Aca crea una lista de tareas nueva, guarda su informacion y la añade a la coleccion.
        //Se ha asumido que el ID asociado a la primer lista es 1, a la segunda lista es 2, y así va asignandolo
        Lista newList = new Lista (coleccion.size() + 1);
        newList.guardeTareas();
        coleccion.add(newList);
    }
    
    /**
     * Método que elimina una lista de tareas de la colección.
     */
    public void eliminarLista ()
    {
        String [] ops = new String [coleccion.size()];
        for (int i = 0; i<coleccion.size(); i++)
        {
            ops[i] = coleccion.get(i).nombre + " (ID: " + (i+1) + ")";
        }
        
        //Luego pone un menu del JOptionPane que le muestre al usuario esas opciones de arriba y escoja cual lista eliminar.
        //Despues elimina la lista escogida de la coleccion y del registro
        String ans = (String)(JOptionPane.showInputDialog(null,"Seleccione la lista de tareas a eliminar?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
        int index = -1;
        for (int j = 0; j<coleccion.size(); j++)
        {
            if(ops[j].equals(ans)) {index = j;}
        }
        coleccion.remove(index);
    }
    
    /**
     * Método que modifica la información de alguna de las listas de la colección.
     */
    public void modificarLista ()
    {
        String [] ops = new String [coleccion.size()];
        for (int i = 0; i<coleccion.size(); i++)
        {
            ops[i] = coleccion.get(i).nombre + " (ID: " + (i+1) + ")";
        }
        
        //Luego pone un menu del JOptionPane que le muestre al usuario esas opciones de arriba y escoja cual lista modificar.
        //Digamos que el ID de la lista a modificar es id.
        //Invoca un metodo de la clase Lista que le permite al usuario modificar cualquier informacion de esa lista de tareas.
        String ans = (String)(JOptionPane.showInputDialog(null,"Seleccione la lista de tareas a eliminar?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
        int index = -1;
        for (int j = 0; j<coleccion.size(); j++)
        {
            if(ops[j].equals(ans)) {index = j;}
        }
        coleccion.get(index).modifiqueInfo();
    }
    
    /**
     * Método que imprime en terminal a todas las listas presentes en la coleccion.
     * Para cada lista de tareas imprime el nombre, ID y descripción de esta.
     * Todo lo anterior va en un bloque. Luego se deja un espacio en blanco y se sigue con otro bloque de otra lista de tareas.
     */
    public String muestreColeccion ()
    {
        String msg = "";
        for (int i = 0; i<coleccion.size(); i++)
        {
            msg += coleccion.get(i).nombre + " (ID: " + (i+1) + ")\n";
            msg += coleccion.get(i).descripcion + "\n\n";
        }
        return msg;
    }
    
    /**
     * Método que permite acceder a la información más específica de una lista en particular.
     */
    public void consultarLista ()
    {
        String [] ops = new String [coleccion.size()];
        for (int i = 0; i<coleccion.size(); i++)
        {
            ops[i] = coleccion.get(i).nombre + " (ID: " + (i+1) + ")";
        }
        
        //Luego pone un menu del JOptionPane que le muestre al usuario esas opciones de arriba y escoja cual lista modificar.
        //Digamos que el ID de la lista a modificar es id.
        String ans = (String)(JOptionPane.showInputDialog(null,"Seleccione la lista de tareas a eliminar?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
        int index = -1;
        for (int j = 0; j<coleccion.size(); j++)
        {
            if(ops[j].equals(ans)) {index = j;}
        }
        coleccion.get(index).consulte();
    }
}
