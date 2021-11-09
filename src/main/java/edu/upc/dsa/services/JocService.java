package edu.upc.dsa.services;
import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

@Api(value = "/joc", description = "Endpoint to Joc Service")
@Path("/joc")
public class JocService {
    private Manager manager;
    public JocService(){
        this.manager = ManagerImpl.getInstance();
        if(manager.getNumUsuarios()==0){
            manager.añadirUsuario(new Usuari("U1","X"));
            manager.añadirUsuario(new Usuari("U2","33333333Y"));
            manager.añadirUsuario(new Usuari("U3","11111111Z"));
        }
        if(manager.getNumPuntos()==0){
            List<Usuari> llista = new LinkedList<Usuari>();
            llista.add(new Usuari("U3","11111111Z"));
            manager.añadirPunto(new PuntoInteres("A32","Puerta",llista));
        }
    }
    @GET
    @ApiOperation(value = "get Usuarios que han pasado por un punto de interes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class, responseContainer="List"),
    })
    @Path("/UsuariosPunto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuariosPorPunto(@PathParam("punto") PuntoInteres punto) {

        List<Usuari> UsuariosPorPunto = manager.LlistaUsuarisPunt(punto);

        GenericEntity<List<Usuari>> entity = new GenericEntity<List<Usuari>>(UsuariosPorPunto) {};
        return Response.status(201).entity(entity).build()  ;

    }
    @GET
    @ApiOperation(value = "get info de un Usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class, responseContainer="List"),
    })
    @Path("/UsuarioInfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") String id) {

        Usuari user = manager.getUsuari(id);

        GenericEntity<Usuari> entity = new GenericEntity<Usuari>(user) {};
        return Response.status(201).entity(entity).build()  ;

    }
    @GET
    @ApiOperation(value = "get puntos por los que ha pasado un Usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = PuntoInteres.class, responseContainer="List"),
    })
    @Path("/UsuarioPuntos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuariosPunto(@PathParam("user") Usuari user) {

        List<PuntoInteres> puntoInteresList = manager.ConsultarPuntsUser(user);

        GenericEntity<List<PuntoInteres>> entity = new GenericEntity<List<PuntoInteres>>(puntoInteresList) {};
        return Response.status(201).entity(entity).build()  ;

    }
    @GET
    @ApiOperation(value = "get Usuarios ordenados", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = PuntoInteres.class, responseContainer="List"),
    })
    @Path("/UsuarioOrden")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuariosOrdenados() {

        TreeMap<String, Usuari> t = manager.OrdenarAlfabeticament();

        GenericEntity<TreeMap<String, Usuari>> entity = new GenericEntity<TreeMap<String, Usuari>>(t) {};
        return Response.status(201).entity(entity).build()  ;

    }
    @POST
    @ApiOperation(value = "añadir usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Usuari.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/AddUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response añadirUsuario(Usuari user) {

        int error = 0;
        if(user.getUsuariID()==null){
            error = 1;
        }

        if(error == 1){
            return Response.status(500).entity(user).build();
        }
        else{

            this.manager.añadirUsuario(user);
            return Response.status(201).entity(user).build();
        }

    }

}
