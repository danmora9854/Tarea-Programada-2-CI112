
/**
 * Clase dedicada a manejar una lista de tareas.
 *
 * @author (Juan José Bermúdez Vargas y Daniel Mora Mora)
 * @version (08.06.2021)
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
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
            coleccion.add(newTarea);
            registro.add(id_job);
            
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
        String ans = (String)(JOptionPane.showInputDialog(null,"¿Cuál tarea desea ver?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, nombres, nombres[0]));
        int index=-1;
        for (int i = 0; i<nombres.length; i++)
        {
            if (nombres[i].equals(ans)) {index = i;}
        }
        return coleccion.get(index).muestreNota();
    }
    
    /**
     * Método que guarda en archivos todas las tareas de una lista.
     */
    public void guardeLista()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.CANCEL_OPTION)
            return;

        File fileName = fileChooser.getSelectedFile();

        if (fileName == null || fileName.getName().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ERROR", "Nombre de archivo es inválido",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
                out.write(nombre + ";" + id + ";" + descripcion + ";");
                out.flush();
                out.newLine();
                //Guarda info basica de la lista
                for (int i = 0; i<coleccion.size(); i++)
                {
                    coleccion.get(i).guardeTarea(out);
                }
                out.close();
            }
            catch (IOException e)
            {
                System.out.println("Excepcion al grabar archivo");
            }
        }
    }
    public void sortTareas(){
        Collections.sort(registro);
        Tarea[] arrayTareas=new Tarea[coleccion.size()];
        int[] arrayID=new int[coleccion.size()];
        for(int i=0;i<coleccion.size;i++){
            arrayTareas[i]=coleccion.get(i);
            arrayID[i]=coleccion.get(i).id;
        }
        for(int j=0;i<arrayTareas.length-1;i++){
            for(int k=i+1;k<arrayTareas.length;k++){
                int temp=0;
                Tarea tempTarea=null;
                if(arrayID[i]>arrayID[j]){
                    temp=arrayID[i];
                    tempTarea=arrayTareas[i];
                    arrayID[i]=arrayID[j];
                    arrayTareas[i]=arrayTareas[j];
                    arrayID[j]=temp;
                    arrayTareas[j]=tempTarea
                }
            }
        ArrayList<Tarea> tempArray=ArrayList<Tarea>;
        for(int i=0;i<arrayTareas.length;i++){
            temp.add(arrayTareas[i]);
        }
        Collections.copy(coleccion,tempArray);
        }
    }
}
