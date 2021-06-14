
/**
 * Clase para manejar la informacion de una tarea
 *
 * @author (Juan José Bermúdez Vargas y Daniel Mora Mora )
 * @version (08.06.2021)
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Tarea
{
    ArrayList <Nota> notas;
    int id;
    String titulo;
    public Tarea (int id)
    {
        
        titulo = "";
        notas = new ArrayList <Nota> ();
        notas.add(new Nota ("Información Administrativa"));
        Nota infoAdmin = notas.get(0);
        infoAdmin.recurso.add("Grado de avance");
        infoAdmin.recurso.add("Colaborador");
        infoAdmin.recurso.add("Tiempo asignado");
        infoAdmin.recurso.add("Prioridad");
        infoAdmin.recurso.add("Complejidad");
        infoAdmin.recurso.add("Fecha de inicio");
        infoAdmin.recurso.add("Fecha de fin");
        infoAdmin.recurso.add("Estimación");
        infoAdmin.recurso.add("Estado");
        for (int i = 0; i<8; i++)
        {
            infoAdmin.cantidades.add("");
        }
        infoAdmin.cantidades.add("Pendiente");
        this.id = id;
    }
    
    public void agregueInfo ()
    {
        titulo = JOptionPane.showInputDialog(null,"Ingrese título de la tarea");
        //Un menu donde elige qué de infoAdmin llenar
        String [] ops = {"Grado de avance","Colaborador","Tiempo Asignado","Prioridad","Complejidad","Fecha de inicio","Fecha de fin","Estimación"};
        String ans = (String)(JOptionPane.showInputDialog(null,"Cuál entrada desea rellenar?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
        int index = -1;
        for (int i = 0; i<ops.length; i++)
        {
            if (ops[i].equals(ans)) {index = i;}
        }
        String data = (String)(JOptionPane.showInputDialog(null,"Ingrese los datos de la entrada"));
        notas.get(0).cantidades.set(index,data);
        
        //Por último pregunta si quiere agregar alguna nota. Las notas son listas simples de elementos. Como en el ejemplo que sale en el word
        //que mencionan una lista de recursos de la tarea.
        String [] ops1 = {"Sí","No"};
        String ans1 = (String)(JOptionPane.showInputDialog(null,"¿Desea ingresar alguna lista extra de elementos util para el manejo de la tarea?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
        boolean hayNotas = (ans1.equals("Sí"))?true:false;
        while (hayNotas)
        {
            //pregunta con JOptionPane por el titulo de la nota.
            String titulo = (String)(JOptionPane.showInputDialog(null,"Ingrese título de la lista"));
            Nota newNote = new Nota (titulo);
            newNote.guardeElementos();
            notas.add(newNote);
            
            ans = (String)(JOptionPane.showInputDialog(null,"¿Desea ingresar otra lista extra de elementos util para el manejo de la tarea?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
            hayNotas = (ans1.equals("Sí"))?true:false;
        }
    }
    
    public String muestreNota()
    {
        String[] nombresnotas=new String[notas.size()];
        for(int j=0;j<notas.size();j++){
            nombresnotas[j]=notas.get(j).titulo;
        }
        String ans = (String)(JOptionPane.showInputDialog(null,"¿Cuál nota desea ver?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, nombresnotas, nombresnotas[0]));
        int index=-1;
        for (int i = 0; i<nombresnotas.length; i++)
        {
            if (nombresnotas[i].equals(ans)) {index = i;}
        }
        return notas.get(index).muestreElementos();
    }
    
    public void modifiqueAtributos()
    {
        String [] ops = {"Título","ID"};
        String ans = (String)(JOptionPane.showInputDialog(null,"Seleccione el atributo a modificar","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
        String newVal = JOptionPane.showInputDialog(null,"Ingrese el nuevo valor del atributo. Recuerde que si cambia el ID este debe ser un número entero.");
        switch(ans)
        {
            case "Título":
                titulo = newVal;
                break;
            case "ID":
                id = Integer.parseInt(newVal);
                break;
        }        
    }
    
    //Metodo de cambio de notas
    public void modifiqueNota()
    {
        String[] nombresnotas=new String[notas.size()];
        for(int j=0;j<notas.size();j++){
            nombresnotas[j]=notas.get(j).titulo;
        }
        String ans = (String)(JOptionPane.showInputDialog(null,"¿Cuál nota desea modificar?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, nombresnotas, nombresnotas[0]));
        int index=-1;
        for (int i = 0; i<nombresnotas.length; i++)
        {
            if (nombresnotas[i].equals(ans)) {index = i;}
        }
        notas.get(index).cambieElementos();
    }
}
