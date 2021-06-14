
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
    public void ingreseTareas ()
    {
        boolean continua = true;
        do
        {
            int id_job = 0;
            boolean invalid = true;
            while(invalid) {
                try {
                    String s = (String) (JOptionPane.showInputDialog(null,"Ingrese el ID de la tarea"));
                    id_job = Integer.parseInt(s);
                    invalid = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"¡Ingrese un número entero válido!");
                }
            }
            
            Tarea newTarea = new Tarea (id_job);
            newTarea.agregueInfo();
            
            String [] ops = {"Sí","No"};
            String ans = (String)(JOptionPane.showInputDialog(null,"Desea agregar alguna tarea más?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
            if(ans.equals("No")){continua=false;}
        }while(continua==true);
    }

    /**
     *  Método que modifica tres posibles atributos básicos de la lista: nombre, descripción, ID.
     */
    public void modifiqueAtributos ()
    {
        String [] ops = {"Nombre","Descripción","ID"};
        String ans = (String)(JOptionPane.showInputDialog(null,"Seleccione el atributo a modificar","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
        String newVal = JOptionPane.showInputDialog(null,"Ingrese el nuevo valor del atributo. Recuerde que si cambia el ID este debe ser un número entero.");
        switch(ans)
        {
            case "Nombre":
                nombre = newVal;
                break;
            case "Descripción":
                descripcion = newVal;
                break;
            case "ID":
                id = Integer.parseInt(newVal);
                break;
        }
    }
    
    /**
     * Método que permite modificar alguna tarea de la lista.
     * Lo que debería hacer es desplegar un menu de donde el usuario elija exactamente qué cambiar.
     * Puede que sea necesario hacer métodos extra dedicados a cambiar cosas específicas.
     */
    public void modifiqueTarea()
    {
        String [] nombres = new String [coleccion.size()];
        for (int i = 0; i<nombres.length; i++)
        {
            nombres[i] = coleccion.get(i).titulo;
        }
        String ans = (String)(JOptionPane.showInputDialog(null,"¿Cuál tarea desea modificar?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, nombres, nombres[0]));
        int index=-1;
        for (int i = 0; i<nombres.length; i++)
        {
            if (nombres[i].equals(ans)) {index = i;}
        }
        
        String [] ops1 = {"Modificar título o ID de la tarea","Modificar información interna de la tarea"};
        String ans1 = (String)(JOptionPane.showInputDialog(null,"Seleccione la modificación a realizar","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
        
        switch(ans1)
        {
            case "Modificar título o ID de la tarea":
                coleccion.get(index).modifiqueAtributos();
                break;
            case "Modificar información interna de la tarea":
                coleccion.get(index).modifiqueNota();
                break;
        }
        
        coleccion.get(index).modifiqueNota();
    }    
    
    /**
     * Método que devuelve en una String cualquiera de las notas de una tarea.
     */
    public String muestreTarea()
    {
        String [] nombres = new String [coleccion.size()];
        for (int i = 0; i<nombres.length; i++)
        {
            nombres[i] = coleccion.get(i).titulo;
        }
        String ans = (String)(JOptionPane.showInputDialog(null,"¿Cuál tarea desea modificar?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, nombres, nombres[0]));
        int index=-1;
        for (int i = 0; i<nombres.length; i++)
        {
            if (nombres[i].equals(ans)) {index = i;}
        }
        return coleccion.get(index).muestreNota();
    }
}
