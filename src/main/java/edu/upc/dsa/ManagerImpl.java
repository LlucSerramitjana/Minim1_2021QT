package edu.upc.dsa;
import org.apache.log4j.Logger;
import edu.upc.dsa.models.*;
import java.util.*;
public class ManagerImpl implements Manager{

    private HashMap<String, Usuari> usuaris;
    private List<PuntoInteres> listaPuntos;

    private static ManagerImpl instance;

    final static Logger logger = Logger.getLogger(ManagerImpl.class);
    private ManagerImpl(){
        listaPuntos = new LinkedList<PuntoInteres>();
        usuaris = new HashMap<>();
    }
    public static ManagerImpl getInstance(){
        if (instance == null){
            instance = new ManagerImpl();
        }
        return instance;
    }
    public HashMap<String, Usuari> getUsuaris(){
        return usuaris;
    }
    public int getNumUsuarios(){ return usuaris.size();}
    public int getNumPuntos(){return listaPuntos.size();}
    public void añadirUsuario(Usuari usuari) {
        usuaris.put(usuari.getUsuariID(), usuari);
        logger.info("Usuario " + usuari.getNomUser() + " añadido.");
    }
    public void añadirPunto(PuntoInteres punto){
        listaPuntos.add(punto);
        logger.info("Producto "+punto.getNombrePunto()+" añadido.");
    }
    @Override
    public TreeMap<String, Usuari> OrdenarAlfabeticament(){
        TreeMap<String, Usuari> t = new TreeMap<>();
        t.putAll(usuaris);
        logger.info("Se han ordenado los usuarios alfabeticamente.");
        return t;
    }
    public Usuari getUsuari(String id){
        Usuari u = usuaris.get(id);
        return u;
    }
    @Override
    public void PassaUsuari(Usuari usuari, String idPunto){
        for(int i=0; i<listaPuntos.size(); i++){
            if(Objects.equals(this.listaPuntos.get(i).getIdPunto(idPunto), idPunto)){
                this.listaPuntos.get(i).getUsuarispassat().add(usuari);
                logger.info(usuari +" ha passat per el punt d'interés amb id " + idPunto);
            }
        }
    }
    @Override
    public List<PuntoInteres> ConsultarPuntsUser(Usuari usuari){
        List<PuntoInteres> puntoInteresList = new LinkedList<>();
        List<PuntoInteres> listaAux = this.listaPuntos;
        for(int i=0; i<listaAux.size(); i++){
            if(listaAux.get(i).getUsuarispassat() == usuari){
                puntoInteresList.add(listaAux.get(i));
            }
        }
        return puntoInteresList;
    }
    @Override
    public List<Usuari> LlistaUsuarisPunt(PuntoInteres punt){
        List<Usuari> usuarisPunt = punt.getUsuarispassat();
        return usuarisPunt;
    }
    public void borrarTot(){
        listaPuntos.clear();
        usuaris.clear();
    }
}
