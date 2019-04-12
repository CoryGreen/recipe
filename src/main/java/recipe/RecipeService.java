package recipe;

public interface RecipeService {
	//C
	String addRecipe(String name);
		
	//R
	String getAllRecipes();
		
	String getARecipe(int recipeID);

	//U
	String updateRecipe(String name, int recipeID);

	//D
	String deleteRecipe(int recipeID);
		
	int cycleRecipes(String title);

}
