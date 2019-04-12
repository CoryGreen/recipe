package recipe;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/recipe")
public class RecipeEndpoint {
	
	@Inject
	private RecipeImplementation service;

	@Path("/getAllRecipes")
	@GET
	@Produces({ "application/json" })
	public String getAllRecipes() {
		return service.getAllRecipes();
	}
	
	/*@Path("/cycleRecipes/{title}")
	@GET
	@Produces({ "application/json" })
	public int cycleRecipes(@PathParam("title") String name) {
		return service.cycleRecipes(name);
	}*/
	
	@Path("/getARecipe/{id}")
	@GET
	@Produces({ "application/json" })
	public String getARecipe(@PathParam("recipeID") int recipeID) {
		return service.retrieveRecipe();
	}

	@Path("/createRecipe")
	@POST
	@Produces({ "application/json" })
	public String addRecipe(String recipe) {
		return service.addRecipe(recipe);
	}

	@Path("/deleteRecipe/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRecipe(@PathParam("recipeID") int recipeID) {
		return service.deleteRecipe(recipeID);
	}

	public void setService(RecipeImplementation service) {
		this.service = service;
	}

}
