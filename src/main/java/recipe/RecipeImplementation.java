package recipe;

import javax.inject.Inject;
public class RecipeImplementation implements RecipeService{
	
	@Inject
	private RecipeDBRepository repo;
	
	public String addRecipe(String recipe) {
		if (recipe.contains("bacon")) {
			return "This recipe cannot be added";
		}
		return repo.createRecipe(recipe);
	}
	
	String retrieveRecipe() {
		return repo.getAllRecipes();
	}
	
	@Override
	public String deleteRecipe(int recipeID) {
		return repo.deleteRecipe(recipeID);
	}

	@Override
	public String getAllRecipes() {
		// TODO Auto-generated method stub
		return repo.getAllRecipes();
	}

	@Override
	public String getARecipe(int recipeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRecipe(String recipe, int recipeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cycleRecipes(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
}
