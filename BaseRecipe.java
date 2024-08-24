public abstract class BaseRecipe {
    protected String name;
    protected String description;

    public BaseRecipe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void displayRecipe();
}
