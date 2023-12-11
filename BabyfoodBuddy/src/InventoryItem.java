public class InventoryItem {
    String ingredient;
    int quantity;
    Category category;


    public InventoryItem(String ingredient, int quantity, Category category) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.category = category;
    }

    public String getIngredient() {
        return ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}