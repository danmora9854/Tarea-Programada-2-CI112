

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
            int cantidad = 0;
            boolean invalid = true;
            while(invalid) {
                try {
                    String s = (String) (JOptionPane.showInputDialog(null,"Ingrese la cantidad del elemento."));
                    cantidad = Integer.parseInt(s);
                    invalid = false;
                    if (cantidad < 0) {
                        JOptionPane.showMessageDialog(null,"¡El número debe ser un entero positivo!");
                        invalid = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"¡Ingrese un número válido!");
                }
            }
            recurso.add(elemento);
            cantidades.add(cantidad);
            
            String [] ops = {"Sí","No"};
            String ans = (String)(JOptionPane.showInputDialog(null,"Desea ingresar otro elemento?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]));
            hayElementos = (ans.equals("Sí"))?true:false;
        }
    }
}
