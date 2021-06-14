

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
    ArrayList <String> cantidades;
    
    public Nota (String titulo)
    {
        this.titulo = titulo;
        recurso = new ArrayList <String> ();
        cantidades = new ArrayList <String> ();
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
        for(int i=0;i<recurso.size();i++){display+=recurso.get(i)+" con "+cantidades.get(i)+" cantidades.\n";}
        return display;
    }
    
    public void cambieElementos()
    {
        String[] elemNames = new String[recurso.size()];
        for(int j=0;j<recurso.size();j++){
            elemNames[j]=recurso.get(j);
        }
        String ans1 = (String)(JOptionPane.showInputDialog(null,"¿Cuál elemento desea modificar?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, elemNames, elemNames[0]));
        int ind=-1;
        for (int i = 0; i<elemNames.length; i++)
        {
            if (elemNames[i].equals(ans1)) {ind = i;}
        }
        
        boolean cambioElementos = true;
        while (cambioElementos)
        {
            String elemento = (String)(JOptionPane.showInputDialog(null,"Ingrese nuevo nombre del elemento."));
            String cantidad = (String)(JOptionPane.showInputDialog(null,"Ingrese nueva cantidad del elemento."));
            recurso.set(ind,elemento);
            cantidades.set(ind,cantidad);
            
            String [] ops = {"Sí","No"};
            String ans2 = (String)(JOptionPane.showInputDialog(null,"Desea cambiar otro elemento?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
            cambioElementos = (ans2.equals("Sí"))?true:false;
        }
    }
}
