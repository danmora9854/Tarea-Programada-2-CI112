
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
        String nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre de la lista");
        String descripcion = JOptionPane.showInputDialog(null,"Ingrese una breve descripción de la lista");
        Lista newList = new Lista (coleccion.size() + 1,nombre,descripcion);
        newList.ingreseTareas();
        newList.sortTareas();
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
     * Método que modifica la información de alguna de las listas.
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
        String ans = (String)(JOptionPane.showInputDialog(null,"Seleccione la lista de tareas a modificar","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
        int index = -1;
        for (int j = 0; j<coleccion.size(); j++)
        {
            if(ops[j].equals(ans)) {index = j;}
        }
        //do while aqui?
         String [] ops1 = {"Modificar nombre, descripción o ID de la lista","Modificar información de alguna tarea"};
        String ans1 = (String)(JOptionPane.showInputDialog(null,"Seleccione la modificación a realizar","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
        
        switch(ans1)
        {
            case "Modificar nombre, descripción o ID de la lista":
                coleccion.get(index).modifiqueAtributos();
                break;
            case "Modificar información de alguna tarea":
                coleccion.get(index).modifiqueTarea();
                break;
        }
        coleccion.get(index).sortTareas();
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
     * Método que devuelve en String la info de alguna nota de alguna tarea de alguna lista.
     */
    public String muestreLista ()
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
        return coleccion.get(index).muestreTarea();
    }
    
    /**
     * Método que lee un archivo .txt con la data de una tarea.
     * Al usuario se le abre una ventana para seleccionar la localización del archivo.
     * Si la lista a la que pertenece esta tarea no existe, se crea y añade a la agenda.
     */
    public void leaLista()
    {
        //Primero lee toda la data de la tarea y la mantiene por acá en memoria
        
        //Revisa si la lista a la que pertenece la tarea existe en la agenda.
        //Si es así basta con hacer que la lista añada la tarea que le decimos a su colección.
        //Si no es así se crea una lista nueva y ahí se añade la tarea.

    }

    /**
     * Método que guarda todas las listas de la agenda en archivos .txt.
     * Todos los archivos son guardados por default en la carpeta del proyecto.
     * Hay un archivo por tarea.
     */
    public void guardeAgenda()
    {
        for (int i = 0; i<coleccion.size(); i++)
        {
            coleccion.get(i).guardeLista();
        }
    }
    public static void main(String a[]){
        Agenda agenda=new Agenda;
        
        
        String[] ops1={"Crear una lista nueva","Leer alguna lista"};
        String ans1 = (String)(JOptionPane.showInputDialog(null,"¿Qué desea hacer para comenzar?","Escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
        if(ans1.equals("Salir")){flag=false;}
        else{
        
        switch(ans1){
        case "Crear una lista nueva":
            agenda.agregarLista();
        break;
        case "Leer alguna lista":
            agenda.leaLista();
        break;
        }
        }
        boolean flag=true;
        do{
        String[] ops2={"Agregar una nueva lista de tareas","Eliminar una lista","Modificar una lista","Mostrar todas las listas guardadas","Leer alguna lista","Guardar la agenda y salir"};
        String ans2 = (String)(JOptionPane.showInputDialog(null,"¿Qué desea hacer?","Escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops2, ops2[0]));
        if(ans2.equals("Guardar la agenda y salir")){agenda.guardeAgenda();flag=false;}
        else{
        //Aqui vienen los resultados de las opciones
        switch(ans2){
        case "Agregar una nueva lista de tareas":
            agenda.agregarLista();
        break;
        case "Eliminar una lista":
            agenda.eliminarLista();
        break;
        case "Modificar una lista":
            agenda.modificarLista();
        break;
        case "Mostrar todas las listas guardadas":
            agenda.muestreColeccion();
        break; 
        case "Leer alguna lista":
            agenda.leaLista();
        break;         
        }
        }
        }while(flag==true);
    }
}
