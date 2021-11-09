package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.Usuari;

import java.util.List;
import java.util.TreeMap;

public interface Manager {
    TreeMap<String, Usuari> OrdenarAlfabeticament();
    public Usuari getUsuari(String id);
    public void añadirUsuario(Usuari usuari);
    public void PassaUsuari(Usuari usuari, String idPunto);
    public List<PuntoInteres> ConsultarPuntsUser(Usuari usuari);
    public int getNumUsuarios();
    List<Usuari> LlistaUsuarisPunt(PuntoInteres punt);
    public int getNumPuntos();
    public void añadirPunto(PuntoInteres punto);
}
