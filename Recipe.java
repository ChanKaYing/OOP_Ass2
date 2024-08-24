import java.util.ArrayList;

public class Recipe extends BaseRecipe implements RecipeManagement, RecipeAnalysis, Cloneable {
    private ArrayList<Ingredient> ingredients;

    public Recipe(String name, String description) {
        super(name, description);
        ingredients = new ArrayList<>();
    }

    @Override
    public void displayRecipe() {
        System.out.println("Recipe Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) {
            System.out.println("- " + ingredient.getName() + ": " + ingredient.getQuantity() + " " + ingredient.getUnit());
        }
    }

    // Implementing RecipeManagement methods
    @Override
    public void addNewIngredient(String name, double quantity, String unit) {
        ingredients.add(new Ingredient(name, quantity, unit));
    }

    @Override
    public void removeIngredient(String name) {
        ingredients.removeIf(ingredient -> ingredient.getName().equals(name));
    }

    @Override
    public void updateIngredientQuantity(String name, double quantity) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(name)) {
                ingredient.setQuantity(quantity);
                break;
            }
        }
    }

    // Implementing RecipeAnalysis methods
    @Override
    public double calculateTotalQuantity() {
        double total = 0;
        for (Ingredient ingredient : ingredients) {
            total += ingredient.getQuantity();
        }
        return total;
    }

    @Override
    public boolean isIngredientPresent(String name) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getMostUsedIngredient() {
        if (ingredients.isEmpty()) return null;

        Ingredient mostUsed = ingredients.get(0);
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getQuantity() > mostUsed.getQuantity()) {
                mostUsed = ingredient;
            }
        }
        return mostUsed.getName();
    }

    // Implementing Cloneable
    @Override
    public Recipe clone() {
        try {
            Recipe cloned = (Recipe) super.clone();
            cloned.ingredients = new ArrayList<>(this.ingredients);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    // Main method to demonstrate the usage
    public static void main(String[] args) {
        Recipe recipe = new Recipe("Cake", "A delicious chocolate cake.");
        recipe.addNewIngredient("Flour", 500, "grams");
        recipe.addNewIngredient("Sugar", 200, "grams");
        recipe.addNewIngredient("Eggs", 3, "pieces");

        recipe.displayRecipe();
        double totalQuantity = recipe.calculateTotalQuantity();
        System.out.println("Total quantity: " + totalQuantity);

        System.out.println("Is Sugar present: " + recipe.isIngredientPresent("Sugar"));
        System.out.println("Most used ingredient: " + recipe.getMostUsedIngredient());

        Recipe clonedRecipe = recipe.clone();
        System.out.println("Cloned Recipe's most used ingredient: " + clonedRecipe.getMostUsedIngredient());
    }
}
