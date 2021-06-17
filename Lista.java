
/**
 * Clase dedicada a manejar una lista de tareas.
 *
 * @author (Juan José Bermúdez Vargas y Daniel Mora Mora)
 * @version (08.06.2021)
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
     * Método que comprueba si la tarea de indice index en la coleccion tiene sus tareas anteriores finalizadas.
     */
    public boolean compruebePermiso (int index)
    {
        if (index != 0)
        {
            Tarea anterior = coleccion.get(index-1);
            if (!(anterior.estado.equals("Finalizada")))
            {
                return false;
            }
        }
        return true;
    }
    
    public void creeProxy (int index)
    {
        //Añade una tarea juguete con el mismo id que la tarea que queremos iniciar.
        //Debe colocar esta tarea dentro de coleccion justo detrás de la tarea que quiere iniciar (o sea metala en posicion index y mueve todo lo demás una posición)
        //Esta tarea debe ser inicializada con el estado = "Finalizada"
        Tarea proxy = new Tarea (coleccion.get(index).id);
        proxy.titulo = "Proxy";
        proxy.estado = "Finalizada";
        
        ArrayList <Tarea> lista = new ArrayList <Tarea> ();
        for (int i = 0; i<index-1; i++)
        {
            lista.add(coleccion.get(i));
        }
        lista.add(proxy);
        for (int j = index; j<coleccion.size(); j++)
        {
            lista.add(coleccion.get(j));
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
        
        String [] ops1 = {"Modificar título o ID de la tarea","Modificar información interna de la tarea","Modificar estado de la tarea"};
        String ans1 = (String)(JOptionPane.showInputDialog(null,"Seleccione la modificación a realizar","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
        
        switch(ans1)
        {
            case "Modificar título o ID de la tarea":
                coleccion.get(index).modifiqueAtributos();
                break;
            case "Modificar información interna de la tarea":
                coleccion.get(index).modifiqueNota();
                break;
            case "Modificar estado de la tarea":
                boolean permiso = compruebePermiso(index);
                if (permiso)
                {
                    String [] estados = {"Finalizada","Pendiente","Haciendo"};
                    String ans2 = (String)(JOptionPane.showInputDialog(null,"Seleccione la modificación a realizar","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
                    coleccion.get(index).estado = ans2;
                }
                else
                {
                    String [] ops2 = {"Sí","No"};
                    String prox_ans = (String)(JOptionPane.showInputDialog(null,"La tarea no puede iniciar sin haber finalizado las tareas anteriores! Desea crear un proxy?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops2, ops2[0]));
                    switch (prox_ans)
                    {
                        case "Sí":
                            creeProxy(index);
                            String [] estados = {"Finalizada","Pendiente","Haciendo"};
                            String ans2 = (String)(JOptionPane.showInputDialog(null,"Seleccione la modificación a realizar","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
                            coleccion.get(index).estado = ans2;
                            break;
                        case "No":
                            break;
                    }
                }
                break;
        }
    }    
    
    /**
     * Método que devuelve en una String cualquiera de las notas de una tarea.
     */
    public String muestreTarea()
    {
        String [] ops = {"Ver información básica de la lista","Ver una tarea de la lista"};
        String qans = (String)(JOptionPane.showInputDialog(null,"¿Qué desea hacer?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
        if (qans.equals("Ver información básica de la lista"))
        {
            String res = "Lista: " + nombre + " (ID: " + id + ")\nDescripción: " + descripcion;
            return res;
        }
        else
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
                    out.write("FIN DE TAREA");
                    out.flush();
                    out.newLine();
                }
                out.close();
            }
            catch (IOException e)
            {
                System.out.println("Excepcion al grabar archivo");
            }
        }
    }
    public ArrayList<String> filtrarEstados(String p){
        ArrayList<String> estados=new ArrayList<String>;
        for (Tarea c:coleccion){
            if(c.estado=="p"){estados.add(c.titulo);}
        }
        return estados;
    }
    
    public void sortTareas()
    {
        Collections.sort(registro);
        ArrayList <Tarea> arrayTareas = new ArrayList <Tarea> ();
        int [] arrayID = new int [coleccion.size()];
        boolean [] flag = new boolean [coleccion.size()];
        for(int i = 0; i<coleccion.size(); i++){
            arrayID[i] = coleccion.get(i).id;
            flag[i] = true;
        }
        for (int j = 0; j<coleccion.size(); j++)
        {
            for (int k = 0; k<coleccion.size(); k++)
            {
                if ((registro.get(j) == arrayID[k]) && flag[k])
                {
                    arrayTareas.add(coleccion.get(k));
                    flag[k] = false;
                }
            }
        }
        Collections.copy(coleccion,arrayTareas);
        
        /*for(int j=0;j<arrayTareas.length-1;j++){
            for(int k=i+1;k<arrayTareas.length;k++){
                int temp=0;
                Tarea tempTarea=null;
                if(arrayID[i]>arrayID[j]){
                    temp=arrayID[i];
                    tempTarea=arrayTareas[i];
                    arrayID[i]=arrayID[j];
                    arrayTareas[i]=arrayTareas[j];
                    arrayID[j]=temp;
                    arrayTareas[j]=tempTarea;
                }
            }
            ArrayList <Tarea> tempArray = new ArrayList <Tarea> ();
            for(int i=0;i<arrayTareas.length;i++)
            {
                tempArray.add(arrayTareas[i]);
            }
            Collections.copy(coleccion,tempArray);
        }*/
    }
}
