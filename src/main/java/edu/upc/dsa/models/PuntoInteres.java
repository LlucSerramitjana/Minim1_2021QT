package edu.upc.dsa.models;
import java.util.LinkedList;
import java.util.List;
public class PuntoInteres {
    String idPunto;
    String nombrePunto;
    List<Usuari> usuarispassat;
    public PuntoInteres(String idPunto, String nombrePunto, List<Usuari> usuarispassat){
        this.setIdPunto(idPunto);
        this.setNombrePunto(nombrePunto);
        this.setUsuarispassat(usuarispassat);
    }
    public String getIdPunto(String idPunto) {
        return this.idPunto;
    }

    public void setIdPunto(String idPunto) {
        this.idPunto = idPunto;
    }

    public String getNombrePunto() {
        return nombrePunto;
    }

    public void setNombrePunto(String nombrePunto) {
        this.nombrePunto = nombrePunto;
    }

    public void PassatUsuari(Usuari usuari){
        this.usuarispassat.add(usuari);
    }
    public List<Usuari> getUsuarispassat() {
        return this.usuarispassat;
    }

    public void setUsuarispassat(List<Usuari> usuarispassat) {
        this.usuarispassat = usuarispassat;
    }
    public void addLU(String NombreUser, String idUser){
        this.usuarispassat.add(new Usuari(NombreUser,idUser));
    }
}
