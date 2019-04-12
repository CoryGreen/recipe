package recipe;

public interface RecipeDBRepository {
	//C
		String createRecipe(String recipe);
		
		//R
		String getAllRecipes();
		
		String getRecipe(int recipeID);
		
		//U
		String updateRecipe(String recipe, int recipeID);

		//D
		String deleteRecipe(int recipeID);
		
		int cycleRecipes(String title);

}
