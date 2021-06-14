
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
    String colabolador;
    ArrayList <Nota> notas;
    int id;
    
    public Tarea ()
    {
        colaborador ="" ;
   
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
        for (int i = 0; i<8; i++)
        {
            infoAdmin.cantidades.add("");
        }
        id = 0;
    }
    
    public void agregueInfo ()
    {
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
        boolean hayNotas = true;
        while (hayNotas)
        {
            //pregunta con JOptionPane por el titulo de la nota.
            String titulo = (String) ;
            Nota newNote = new Nota (titulo);
            newNote.guardeElementos();
            notas.add(newNote);
            
            //pregunta si quiere ingresar alguna otra nota. Si no, hace hayNotas = false
        }
    }
}
