package edu.upc.dsa;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.upc.dsa.models.*;
import java.util.*;

public class ManagerTest {
    ManagerImpl manager = ManagerImpl.getInstance();
    PuntoInteres p1;
    PuntoInteres p2;
    PuntoInteres p3;
    Usuari u1;
    @Before
    public void setUp  () {
        manager.añadirUsuario(new Usuari("User1","22222222X"));
        manager.añadirUsuario(new Usuari("User2","33333333Y"));
        manager.añadirUsuario(new Usuari("User3","11111111Z"));
        p1 = new PuntoInteres("A32","Puerta", new LinkedList<Usuari>());
        p1.addLU("User1","22222222X");
        p1.addLU("User2","33333333Y");
        p2 = new PuntoInteres("A33","Puente", new LinkedList<Usuari>());
        p2.addLU("User1","22222222X");
        p2.addLU("User3","11111111Z");
        p3 = new PuntoInteres("A34","Casilla 2", new LinkedList<Usuari>());
        p3.addLU("User1","22222222X");
        p3.addLU("User3","11111111Z");
        p3.addLU("User2","33333333Y");
        u1 = new Usuari("User4", "44444444C");
        manager.PassaUsuari(u1,"A33");
        manager.ConsultarPuntsUser(u1);
        manager.LlistaUsuarisPunt(p1);
    }
    @Test
    public void probaAñadirUsuario(){
        manager.añadirUsuario(new Usuari("Toni","55555555T"));
        Assert.assertEquals(4,manager.getNumUsuarios());
        Assert.assertEquals("Toni",manager.getUsuaris().get("55555555T").getNomUser());
    }
    @After
    public void tearDown(){
        manager.borrarTot();
        p1= null;
        p2=null;
        p3=null;
        u1=null;
    }
}
