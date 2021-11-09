package edu.upc.dsa.models;

public class Usuari {
    String NomUser;
    String usuariID;

    public Usuari (String NomUser, String usuariID) {
        this.setNomUser(NomUser);
        this.setUsuariID(usuariID);
    }
    public String getNomUser() {
        return NomUser;
    }

    public void setNomUser(String nomUser) {
        NomUser = nomUser;
    }

    public String getUsuariID() {
        return usuariID;
    }

    public void setUsuariID(String usuariID) {
        this.usuariID = usuariID;
    }
}
