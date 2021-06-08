import java.util.ArrayList;
public class Tarea{
 String nombre;
 String id;
 String estado;
 ArrayList<String> recursos;
public Tarea(String n, String i){
 nombre=n;
 id=i;
 estado="Pendiente";
 recursos=new ArrayList<String>();
}
 public void cambieEstado(int n){
  switch(n){
   case n=1:
   estado="Pendiente";
   break;
   case n=2;
   estado="Haciendo";
    break;
   case n=3;
   estado="Finalizado";
    break;
  }
  public void agregaRecurso(String p){
   recursos.add(p);
  }
  public void muestraRecursos(){
   System.out.println(recursos);
  }
  
 }
}
