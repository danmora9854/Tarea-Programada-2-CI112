

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
    
    /**
     * Constructor de la clase Nota.
     * Inicializa el titulo de la nota asi como los arraylist para guardar recursos y cantidades asociadas en la nota.
     */
    public Nota (String titulo)
    {
        this.titulo = titulo;
        recurso = new ArrayList <String> ();
        cantidades = new ArrayList <String> ();
    }
    
    /**
     * Método que ingresa nuevas entradas en una nota.
     */
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
    
    /**
     * Método que devuelve una hilera con los contenidos de la nota.
     * @return display = hilera con la información a imprimir
     */
    public String muestreElementos(){
        String display="Contenidos de " + titulo + ": \n\n";
        for(int i=0;i<recurso.size();i++){display+=recurso.get(i)+" : "+cantidades.get(i)+" \n";}
        return display;
    }
    
    /**
     * Método que realiza la modificación de alguna entrada de la nota.
     */
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
