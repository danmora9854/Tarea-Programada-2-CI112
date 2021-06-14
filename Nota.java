

/**
 * Clase que maneja las notas de recursos.
 *
 * @author (Juan José Bermúdez Vargas y Daniel Mora Mora)
 * @version (08.06.2021)
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Nota
{
    String titulo;
    ArrayList <String> recurso;
    ArrayList <Integer> cantidades;
    
    public Nota (String titulo)
    {
        this.titulo = titulo;
        recurso = new ArrayList <String> ();
        cantidades = new ArrayList <Integer> ();
    }
    
    public void guardeElementos ()
    {
        boolean hayElementos = true;
        while (hayElementos)
        {
            String elemento = (String)(JOptionPane.showInputDialog(null,"Ingrese tipo de elemento."));
            String cantidad = (String)(JOptionPane.showInputDialog(null,"Ingrese cantidad de elemento."));
            recurso.add(elemento);
            cantidades.add(cantidad);
            
            String [] ops = {"Sí","No"};
            String ans = (String)(JOptionPane.showInputDialog(null,"Desea ingresar otro elemento?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
            hayElementos = (ans.equals("Sí"))?true:false;
        }
    }
    public String muestreElementos(){
        String display="Los recursos de esta tarea son: \n";
        for(int i=0;i<recurso.size;i++){display=recurso.get(i)+" con "+cantidades.get(i)+" cantidades.\n"}
        return display;
    }
}
