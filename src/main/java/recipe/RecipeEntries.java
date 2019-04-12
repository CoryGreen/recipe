package recipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecipeEntries {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int recipeID;
	private String nameOfRecipe;
	private String ownerOfRecipe;
	private String description;
	
	public RecipeEntries() {
		
	}
	public RecipeEntries(String nameOfRecipe, String ownerOfRecipe, String description) {
		this.nameOfRecipe = nameOfRecipe;
		this.ownerOfRecipe = ownerOfRecipe;
		this.description = description;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public String getNameOfRecipe() {
		return nameOfRecipe;
	}

	public void setNameOfRecipe(String nameOfRecipe) {
		this.nameOfRecipe = nameOfRecipe;
	}

	public String getOwnerOfRecipe() {
		return ownerOfRecipe;
	}

	public void setOwnerOfRecipe(String ownerOfRecipe) {
		this.ownerOfRecipe = ownerOfRecipe;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
