package rest.MariaDBExample;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import rest.MariaDBExample.dao.ContactsDAO;
import rest.MariaDBExample.dao.MariaDBContactsImpl;
import rest.MariaDBExample.model.Contact;

@Path("/contacts")
public class ContactsResource {
	
	private ContactsDAO dao = new MariaDBContactsImpl();
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response getContact(@PathParam("id") Long id) {
		return Response.ok(dao.findByID(id)).build();
	}
	
	@GET
	@Produces("application/json")
	public Response getAllContacts() {
		return Response.ok(dao.findAll()).build();
	}
	
	@POST
	@Consumes("application/json")
	public Response addNewContact(Contact contact) {
		String result = dao.addContact(contact);
		return Response.ok(result).build();
	}
	
	@Path("/{id}")
	@PUT
	@Consumes("application/json")
	public Response updateContact(@PathParam("id") Long id, Contact contact) {
		contact.setId(id);
		
		String result = dao.updateContact(contact);
		return Response.ok(result).build();
	}
	
	@Path("/{id}")
	@DELETE
	public Response deleteContact(@PathParam("id") Long id) {
		dao.deleteContact(id);
		return Response.ok().build();
	}
	
}
