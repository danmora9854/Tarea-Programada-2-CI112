
/**
 * Clase que maneja todas las listas de tareas.
 *
 * @author (Juan José Bermúdez Vargas B71082 y Daniel Mora Mora B64720)
 * @version (08.06.2021)
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Agenda
{
    //Aca va a guardar las diversas listas de tareas
    public ArrayList <Lista> coleccion;
    
    
    /**
     * Constructor de la clase agenda. Inicializa la coleccion de listas de tareas.
     */
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
        JOptionPane.showMessageDialog(null,"Su lista ha sido creada exitosamente. Ahora procederá a ingresar las tareas de su lista.");
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
            ops[i] = coleccion.get(i).nombre + " (ID: " + coleccion.get(i).id + ")";
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
     * Método que devuelve hilera con informacion de todas las listas presentes en la coleccion.
     * Para cada lista de tareas incluye el nombre, ID y descripción de esta.
     * Todo lo anterior va en un bloque. Luego se deja un espacio en blanco y se sigue con otro bloque de otra lista de tareas.
     * @ return msg = hilera con informacion a imprimir
     */
    public String muestreColeccion ()
    {
        String msg = "";
        for (int i = 0; i<coleccion.size(); i++)
        {
            msg += coleccion.get(i).nombre + " (ID: " + coleccion.get(i).id + ")\n";
            msg += "Descripción: " + coleccion.get(i).descripcion + "\n\n";
        }
        return msg;
    }
    
    /**
     * Método que devuelve una hilera con la info interna de alguna tarea de alguna lista.
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
        String ans = (String)(JOptionPane.showInputDialog(null,"Seleccione la lista que desea ver?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
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
     */
    public void leaLista()
    {
        String nombre = "";
        String descripcion = "";
        int id = 0;
        
        //Primero lee toda la data de la tarea y la mantiene por acá en memoria
        JFileChooser fileChooser = new JFileChooser();  //Ventana para el manejo de directorios
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(null);  //intenta abrir diálogo para manejo de dir

        if (result == JFileChooser.CANCEL_OPTION)       //usuario da click sobre la X de la ventana
            return;                                                                    //se obliga a terminar acá

        File fileName = fileChooser.getSelectedFile();        //tome archivo seleccionado

        if (fileName == null || fileName.getName().equals(""))
            JOptionPane.showMessageDialog(null, "ERROR", "Nombre de archivo es inválido",
                JOptionPane.ERROR_MESSAGE);
        else
        {
            try
            {
                //El BufferedReader lee eficientemente caracteres, arrays y lineas
                //toma los bytes del FileReader, los convierte a char y los guarda
                BufferedReader in = new BufferedReader(new FileReader(fileName));
                String str = in.readLine();
                StringTokenizer st = new StringTokenizer(str, ";");
                nombre = st.nextToken();
                id = Integer.parseInt(st.nextToken());
                descripcion = st.nextToken();
                Lista lista = new Lista(id,nombre,descripcion);
                ArrayList <Tarea> tareas = new ArrayList <Tarea> (); 
                ArrayList <Integer> registros = new ArrayList <Integer> ();
                
                while ((str = in.readLine()) != null)                   //mientras hallan datos
                {
                    // manejo de los datos de entrada (str) y los pasa a matriz
                    StringTokenizer st2 = new StringTokenizer(str, ";");
                    int id_tarea = Integer.parseInt(st2.nextToken());
                    registros.add(id_tarea);
                    Tarea tarea = new Tarea (id_tarea);
                    tarea.titulo = st2.nextToken();
                    tarea.estado = st2.nextToken();
                    
                    while ((str = in.readLine()) != null)
                    {   
                        StringTokenizer st3 = new StringTokenizer(str,";");
                        String token1 = st3.nextToken();
                        if (token1.equals("FIN DE TAREA"))
                        {
                            break;
                        }
                        
                        Nota nota = new Nota (token1);
                        str = in.readLine();
                        StringTokenizer st4 = new StringTokenizer(str,";");
                        while (st4.hasMoreTokens())
                        {
                            nota.recurso.add(st4.nextToken());
                        }
                        str = in.readLine();
                        StringTokenizer st5 = new StringTokenizer(str,";");
                        while (st5.hasMoreTokens())
                        {
                            nota.cantidades.add(st5.nextToken());
                        }
                        
                        tarea.notas.add(nota);
                    }
                    tareas.add(tarea);
                }
                lista.coleccion = tareas;
                lista.registro = registros;
                coleccion.add(lista);
                in.close();
            }
            catch (IOException e)
            {
                System.out.println("Excepcion");
            }
        }
    }

    /**
     * Método que guarda todas las listas de la agenda en archivos .txt.
     * Todos los archivos son guardados por default en la carpeta del proyecto.
     * Hay un archivo por lista.
     */
    public void guardeAgenda()
    {
        for (int i = 0; i<coleccion.size(); i++)
        {
            JOptionPane.showMessageDialog(null,"A continuación ingrese la dirección de guardado de la lista " + coleccion.get(i).nombre + ". Debe incluir el nombre del archivo con extension .txt");
            coleccion.get(i).guardeLista();
        }
    }
    public static void main(String a[]){
        Agenda agenda=new Agenda ();
        
        String[] ops1={"Crear una lista nueva","Leer alguna lista"};
        String ans1 = (String)(JOptionPane.showInputDialog(null,"¿Qué desea hacer para comenzar?","Escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
        switch(ans1){
            case "Crear una lista nueva":
                agenda.agregarLista();
                break;
            case "Leer alguna lista":
                agenda.leaLista();
                break;
        }
        boolean flag=true;
        do{
            String[] ops2={"Agregar una nueva lista de tareas","Eliminar una lista","Modificar una lista","Mostrar todas las listas guardadas","Ver contenidos de una lista","Ver tareas de una lista por estado","Leer alguna lista","Guardar la agenda y salir"};
            String ans2 = (String)(JOptionPane.showInputDialog(null,"¿Qué desea hacer?","Escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops2, ops2[0]));
            if(ans2.equals("Guardar la agenda y salir"))
            {
                agenda.guardeAgenda();
                flag=false;
            }
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
                        JOptionPane.showMessageDialog(null,agenda.muestreColeccion());
                        break; 
                    case "Ver contenidos de una lista":
                        JOptionPane.showMessageDialog(null,agenda.muestreLista());
                        break;
                    case "Leer alguna lista":
                        agenda.leaLista();
                        break; 
                    case "Ver tareas de una lista por estado":
                        String [] ops11 = new String [agenda.coleccion.size()];
                        for (int i = 0; i<agenda.coleccion.size(); i++)
                        {
                            ops11[i] = agenda.coleccion.get(i).nombre + " (ID: " + (i+1) + ")";
                        }

                        String ans11 = (String)(JOptionPane.showInputDialog(null,"Seleccione la lista que desea ver?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops11, ops11[0]));
                        int index1 = -1;
                        for (int j = 0; j<agenda.coleccion.size(); j++)
                        {
                            if(ops11[j].equals(ans11)) {index1 = j;}
                        }
                        String[] options={"Pendiente", "Finalizada", "Haciendo"};
                        String ans12 = (String)(JOptionPane.showInputDialog(null,"¿Cuál estado desea ver? La lista se imprimirá en terminal.","Escoja una opción",JOptionPane.QUESTION_MESSAGE, null, options, options[0]));
                        switch(ans12){
                            case "Pendiente":
                                System.out.println(agenda.coleccion.get(index1).filtrarEstados("Pendiente"));
                                break;
                            case "Finalizada":
                                System.out.println(agenda.coleccion.get(index1).filtrarEstados("Finalizada"));
                                break;   
                            case "Haciendo":
                                System.out.println(agenda.coleccion.get(index1).filtrarEstados("Haciendo"));
                                break;
                        }
                        break;
                }
              }
        }while(flag==true);
    }
}
