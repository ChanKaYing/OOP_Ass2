public interface RecipeManagement {
    void addNewIngredient(String name, double quantity, String unit);
    void removeIngredient(String name);
    void updateIngredientQuantity(String name, double quantity);
}
