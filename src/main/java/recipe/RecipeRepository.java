package recipe;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


@Transactional(SUPPORTS)
@Default
public class RecipeRepository implements RecipeDBRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public int cycleRecipe(String name) {

		Query query = manager.createQuery("Select a FROM RecipeEntries a");
		Collection<RecipeEntries> recipes = (Collection<RecipeEntries>) query.getResultList();

		List<RecipeEntries> validList = recipes.stream().filter(n -> n.getNameOfRecipe().equals(name)).collect(Collectors.toList());

		return validList.size();
	}

	public String getAllRecipes() {
		Query query = manager.createQuery("Select m FROM RecipeEntries m");
		Collection<RecipeEntries> recipes =  (Collection<RecipeEntries>) query.getResultList();
		
//		manager.find(Movie.class, 1L);

		return util.getJSONForObject(recipes);
	}

	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
		RecipeEntries aRecipe = util.getObjectForJSON(recipe, RecipeEntries.class);
		manager.persist(aRecipe);
		return "{\"message\": \"recipe has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteRecipe(int recipeID) {
		RecipeEntries recipeInDB = util.getObjectForJSON(getARecipe(recipeID), RecipeEntries.class);

		if (manager.contains(manager.find(RecipeEntries.class, recipeID))) {

			manager.remove(manager.find(RecipeEntries.class, recipeID));
		}
		return "{\"message\": \"recipe sucessfully deleted\"}";
	}

	public String getARecipe(int recipeID) {
		return util.getJSONForObject(manager.find(RecipeEntries.class, recipeID));
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	public String updateRecipe(String recipe, int recipeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecipe(int recipeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cycleRecipes(String title) {
		// TODO Auto-generated method stub
		return 0;
	}
}
