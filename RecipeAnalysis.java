public interface RecipeAnalysis {
    double calculateTotalQuantity();
    boolean isIngredientPresent(String name);
    String getMostUsedIngredient();
}
