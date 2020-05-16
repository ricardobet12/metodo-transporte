/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Asignacion;

/**
 *
 * @author Mipc
 */
public class DatosAsignacion {
    private String costo;
    private boolean rayado;
    private boolean dobleRayado;
    private boolean asignado;
    private boolean colorea;

    public DatosAsignacion(String costo) {
        this.costo = costo;
        this.rayado = false;
        this.dobleRayado = false;
        this.asignado = false;
        this.colorea = false;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public boolean isRayado() {
        return rayado;
    }

    public void setRayado(boolean rayado) {
        this.rayado = rayado;
    }

    public boolean isDobleRayado() {
        return dobleRayado;
    }

    public void setDobleRayado(boolean dobleRayado) {
        this.dobleRayado = dobleRayado;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public boolean isColorea() {
        return colorea;
    }

    public void setColorea(boolean colorea) {
        this.colorea = colorea;
    }

    

   
}
