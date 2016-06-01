/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_entidades;

/**
 *
 * @author diego
 */
public class Proyecto {
    
    String pro_id,dep_id,lug_id,pro_nombre;

    public Proyecto() {
    }

    public Proyecto(String pro_id, String dep_id, String lug_id, String pro_nombre) {
        this.pro_id = pro_id;
        this.dep_id = dep_id;
        this.lug_id = lug_id;
        this.pro_nombre = pro_nombre;
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getDep_id() {
        return dep_id;
    }

    public void setDep_id(String dep_id) {
        this.dep_id = dep_id;
    }

    public String getLug_id() {
        return lug_id;
    }

    public void setLug_id(String lug_id) {
        this.lug_id = lug_id;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }
    
    
}
