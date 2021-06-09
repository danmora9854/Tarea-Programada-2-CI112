
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
    public String estado;
    public ArrayList <Tarea> coleccion;//Acá va guardando las distintas tareas
    public ArrayList <Integer> registro;//Acá va guardando el ID de cada tarea
    
    public Lista (int id)
    {
        this.id = id;
        estado = "pendiente";
        //Deberia implementarse que el JOptionPane le pregunta ahi al usuario por el nombre y descripcion
        nombre = "";
        descripcion = "";
        
        coleccion = new ArrayList <Tarea> ();
        registro = new ArrayList <Integer> ();
    }

    /**
     * Método en que el usuario ingresa todas sus tareas de la lista y la información de cada una.
     */
    public void guardeTareas ()
    {
        boolean continua = true;
        while (continua)
        {
            
            Tarea newTarea = new Tarea ();
            newTarea.agregueInfo();
            
            //Mete un JOption que pregunte si quiere ingresar otra tarea. Si no es así, hace continua = false.
        }
    }
    
    /**
     * Devuelve el nombre de la lista.
     */
    public String deNombre ()
    {
        return nombre;
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
    public void consulte ()
    {
        
    }
}
