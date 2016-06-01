/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_servicio_web;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pkg_entidades.Proyecto;

/**
 *
 * @author diego
 */
@WebService(serviceName = "servicio_web_servidor")
public class servicio_web_servidor {

    

    EntityManagerFactory factory=Persistence.createEntityManagerFactory("cons_servidorPU");
EntityManager em1=factory.createEntityManager(); @WebMethod(operationName = "insertar")
public int insertar(@WebParam(name = "pro_id") String pro_id, @WebParam(name = "dep_id") String dep_id,@WebParam(name = "lug_id") String lug_id,@WebParam(name = "pro_nombre") String pro_nombre)
{
    
String sql ="insert into proyecto (pro_id,dep_id,lug_id,pro_nombre) values ('"+pro_id+"'"+","+"'"+dep_id+"',"+"'"+lug_id+"',"+"'"+pro_nombre+"')";
em1.getTransaction().begin();
Query qe=em1.createNativeQuery(sql); try
{
qe.executeUpdate(); em1.getTransaction().commit(); return 1;
}
catch (Exception ex)
{ em1.getTransaction().rollback();
return -1; }
}
@WebMethod(operationName = "eliminar")
public int eliminar(@WebParam(name = "pro_id") String pro_id) {
String sql ="delete from proyecto where pro_id='"+pro_id+"'"; em1.getTransaction().begin();
Query qe=em1.createNativeQuery(sql);
int li_filas= qe.executeUpdate(); if (li_filas>=1)
{
em1.getTransaction().commit();
return 1; }
else {
em1.getTransaction().rollback();
return 0; }
}
@WebMethod(operationName = "modificar")
public int modificar(@WebParam(name = "pro_id") String pro_id,@WebParam(name = "dep_id") String dep_id,@WebParam(name = "lug_id") String lug_id,@WebParam(name = "pro_nombre") String pro_nombre)
{
String sql ="update proyecto set dep_id='"+dep_id+"',lug_id='"+lug_id+"',pro_nombre='"+pro_nombre+"' where pro_id='"+pro_id+"'"; em1.getTransaction().begin();
Query qe=em1.createNativeQuery(sql);
int li_filas=qe.executeUpdate(); if (li_filas>=1)
{
em1.getTransaction().commit(); return 1;
} else {
em1.getTransaction().rollback(); return 0;
} }
public String buscar(@WebParam(name = "pro_id") String pro_id ) {
String sql ="select * from proyecto where pro_id="+"'"+pro_id+"'"; Query qe=em1.createNativeQuery(sql);
List l1=qe.getResultList();
if (l1.size()>=1)
{
Object [] ar_objeto=(Object [])(l1.get(0)); String ls_nombre=ar_objeto[1].toString(); return ls_nombre;
} else {
return null; }
}
 /*
public ArrayList buscartodo( ) {
String sql ="select * from proyecto"; Query qe=em1.createNativeQuery(sql);
List l1=qe.getResultList();
 ArrayList<Proyecto> lista= new ArrayList<>();   
int a=0,b=1,c=2,d=3;
if (l1.size()>=1)
{
//Object [] ar_objeto=(Object [])(l1.get(0)); String ls_nombre=ar_objeto[1].toString(); return ls_nombre;
    for (int i = 0; i < l1.size(); i++) {
        Object [] ar_objeto=(Object [])(l1.get(i));
        
        lista.add(new Proyecto(ar_objeto[0].toString(), ar_objeto[1].toString(), ar_objeto[2].toString(), ar_objeto[3].toString()));
   
        System.out.println(""+ar_objeto[3].toString()+"ss");
    }
} 

else {
return null; }

return lista;
}
    */

public List buscartodo( ) {
String sql ="select * from proyecto"; Query qe=em1.createNativeQuery(sql);
List l1=qe.getResultList();
 
if (l1.size()>=1)
{
return l1;
} 

else {
return null; }


}
}
