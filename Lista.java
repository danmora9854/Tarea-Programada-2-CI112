
/**
 * Clase dedicada a manejar una lista de tareas.
 *
 * @author (Juan José Bermúdez Vargas y Daniel Mora Mora)
 * @version (08.06.2021)
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Lista
{
    public String nombre;
    public int id;
    public String descripcion;
    public ArrayList <Tarea> coleccion;//Acá va guardando las distintas tareas
    public ArrayList <Integer> registro;//Acá va guardando el ID de cada tarea
    
    public Lista (int id, String nombre, String descripcion)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        coleccion = new ArrayList <Tarea> ();
        registro = new ArrayList <Integer> ();
    }

    /**
     * Método en que el usuario ingresa todas sus tareas de la lista y la información de cada una.
     */
    public void guardeTareas ()
    {
        boolean continua = true;
        do
        {
            
            Tarea newTarea = new Tarea ();
            newTarea.agregueInfo();
            
           String [] ops = {"Sí","No"};
           String ans = (String)(JOptionPane.showInputDialog(null,"Desea agregar alguna tarea más?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
           if(ans.equals("No")){continua=false}
        }while(continua==true)
    }
    
   

    /**
     * Método que permite modificar cualquiera de los atributos.
     * Lo que debería hacer es desplegar un menu de donde el usuario elija exactamente qué cambiar.
     * Puede que sea necesario hacer métodos extra dedicados a cambiar cosas específicas.
     */
    public void modifiqueInfo()
    {
        
    }
    
    /**
     * Método que despliega un menu al usuario y le permite elegir qué ver de la lista.
     */
    public void consulteLista()
    {
        
    }
}
