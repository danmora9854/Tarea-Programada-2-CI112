
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
    public ArrayList <String> colaboradores;
    public String [] infoAdmin;
    public ArrayList <Nota> notas;
    public int id;
    
    public Tarea ()
    {
        colaboradores = new ArrayList <String> ();
        infoAdmin = new String [4];
        notas = new ArrayList <Nota> ();
        id = 0;
    }
    
    public void agregueInfo ()
    {
        //Un menu donde elige qué de infoAdmin llenar
        String [] ops = {"Fecha de inicio","Fecha de fin","Estimación","Grado de avance"};
        
        //Luego pregunta si quiere definir colaboradores para la tarea.
        boolean hayColab = true;
        if (hayColab)
        {
            //Aca pregunta por el tiempo que se le dará al grupo para completar la tarea y lo guarda en el primer espacio del ArrayList colaboradores
            
            //Aca pregunta por el número de colaboradores de la tarea, digamos N, y los lee junto al tiempo semanal que se les da
            int N = 0;
            boolean invalid = true;
            while(invalid) {
                try {
                    String s = (String) (JOptionPane.showInputDialog(null,"Ingrese el número de colaboradores"));
                    N = Integer.parseInt(s);
                    invalid = false;
                    if (N <= 0) {
                        JOptionPane.showMessageDialog(null,"¡El número debe ser un entero positivo!");
                        invalid = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"¡Ingrese un número válido!");
                }
            }
            
            for (int i = 0; i<N; i++)
            {
                //Pregunta por nombre del colaborador i y lo va guardando en el ArrayList colaboradores
            }
        }
        
        //Por último pregunta si quiere agregar alguna nota. Las notas son listas simples de elementos. Como en el ejemplo que sale en el word
        //que mencionan una lista de recursos de la tarea.
        boolean hayNotas = true;
        while (hayNotas)
        {
            //pregunta con JOptionPane por el titulo de la nota.
            String titulo = null;
            Nota newNote = new Nota (titulo);
            newNote.guardeElementos();
            notas.add(newNote);
            
            //pregunta si quiere ingresar alguna otra nota. Si no, hace hayNotas = false
        }
    }
}
