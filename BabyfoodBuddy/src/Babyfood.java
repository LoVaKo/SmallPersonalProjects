/*
Simple program by own design to practice navigating menu's and submenu's and calling different methods.
Objective:
- Have adaptable lists with available ingrediënts
- Have the program provide you with random combinations based on 1 chosen ingrediënt or no ingrediënts at all.
- ADAPT PROGRAM TO USE QUANTITIES
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Babyfood {

    public static void main(String[] args) {
        // Setting up the ingrediënt lists
        ArrayList<InventoryItem> protein = new ArrayList<>();
        ArrayList<InventoryItem> starch = new ArrayList<>();
        ArrayList<InventoryItem> vegetable = new ArrayList<>();
        ArrayList<InventoryItem> fruit = new ArrayList<>();

        // Providing lists with some base ingrediënts
        protein.add(new InventoryItem("Chicken", 10, Category.PROTEIN));
        protein.add(new InventoryItem("Egg", 10, Category.PROTEIN));
        protein.add(new InventoryItem("Minced Meat", 10, Category.PROTEIN));
        protein.add(new InventoryItem("Chickpeas", 10, Category.PROTEIN));
        protein.add(new InventoryItem("Lentils", 10, Category.PROTEIN));

        starch.add(new InventoryItem("Potatoes", 10, Category.STARCH));
        starch.add(new InventoryItem("Rice", 10, Category.STARCH));
        starch.add(new InventoryItem("Couscous", 10, Category.STARCH));
        starch.add(new InventoryItem("Quinoa", 10, Category.STARCH));
        starch.add(new InventoryItem("Pasta", 10, Category.STARCH));

        vegetable.add(new InventoryItem("Pumpkin", 10, Category.VEGETABLE));
        vegetable.add(new InventoryItem("Green Beans", 10, Category.VEGETABLE));
        vegetable.add(new InventoryItem("Bell Pepper", 10, Category.VEGETABLE));
        vegetable.add(new InventoryItem("Carrots", 10, Category.VEGETABLE));
        vegetable.add(new InventoryItem("Parsnip", 10, Category.VEGETABLE));

        fruit.add(new InventoryItem("Banana", 10, Category.FRUIT));
        fruit.add(new InventoryItem("Strawberry", 10, Category.FRUIT));
        fruit.add(new InventoryItem("Peach", 10, Category.FRUIT));
        fruit.add(new InventoryItem("Cherry", 10, Category.FRUIT));
        fruit.add(new InventoryItem("Apple", 10, Category.FRUIT));

        System.out.println("""
                 ____        _            __                _   ____            _     _      \s
                |  _ \\      | |          / _|              | | |  _ \\          | |   | |     \s
                | |_) | __ _| |__  _   _| |_ ___   ___   __| | | |_) |_   _  __| | __| |_   _\s
                |  _ < / _` | '_ \\| | | |  _/ _ \\ / _ \\ / _` | |  _ <| | | |/ _` |/ _` | | | |
                | |_) | (_| | |_) | |_| | || (_) | (_) | (_| | | |_) | |_| | (_| | (_| | |_| |
                |____/ \\__,_|_.__/ \\__, |_| \\___/ \\___/ \\__,_| |____/ \\__,_|\\__,_|\\__,_|\\__, |
                                    __/ |                                                __/ |
                                   |___/                                                |___/\s""");

        // Initializing variables for menu
        int mainChoice;
        int subChoice;
        boolean backToMain;
        Scanner sc = new Scanner(System.in);

        // The following block is the menu
        while (true) {
            backToMain = false;
            System.out.println("""
                    \n========= MENU =========
                    1. Create dinner recipe
                    2. Create fruit combo
                    3. View ingrediënts
                    4. Alter ingrediënts
                    ========================""");

            if (sc.hasNextInt()) {
                mainChoice = sc.nextInt();
                sc.nextLine();

                switch (mainChoice) {
                    case 1: // Submenu for dinner recipes
                        while (!backToMain) {
                            System.out.println("""
                                    \n=== CREATE RECIPE ===
                                    1. Choose protein
                                    2. Choose starch
                                    3. Choose vegetable
                                    4. Random
                                    5. Back to main menu""");

                            if (sc.hasNextInt()) {
                                subChoice = sc.nextInt();
                                sc.nextLine();

                                switch (subChoice) {
                                    case 1: // Choose protein
                                        InventoryItem choiceOfProtein = null;
                                        while (choiceOfProtein == null) {
                                            System.out.println("\nWhich type of protein do you want to use in your recipe?");
                                            System.out.println("\nAvailable protein sources:");
                                            for (InventoryItem item : protein) {
                                                System.out.println(item.getQuantity() + "x " + item.getIngredient());
                                            }

                                            String userInput = sc.nextLine();

                                            for (InventoryItem item : protein) {
                                                if (userInput.equalsIgnoreCase(item.getIngredient())) {
                                                    choiceOfProtein = item;
                                                }
                                            }
                                            if (choiceOfProtein == null) {
                                                System.out.println("\n" + userInput + " is not currently in your inventory. Please pick again.");
                                            }
                                        }
                                        System.out.println("\nHere's your random recipe with: " + choiceOfProtein.getIngredient());
                                        for (InventoryItem item : proteinBasedRecipe(choiceOfProtein, starch, vegetable)) {
                                            System.out.println(item.getIngredient());
                                        }
                                        break;

                                    case 2: // Choose starch
                                        InventoryItem choiceOfStarch = null;
                                        while (choiceOfStarch == null) {
                                            System.out.println("\nWhich type of starch do you want to use in your recipe?");
                                            System.out.println("\nAvailable starch sources:");
                                            for (InventoryItem item : starch) {
                                                System.out.println(item.getQuantity() + "x " + item.getIngredient());
                                            }

                                            String userInput = sc.nextLine();

                                            for (InventoryItem item : starch) {
                                                if (item.getIngredient().equalsIgnoreCase(userInput)) {
                                                    choiceOfStarch = item;
                                                }
                                            }

                                            if (choiceOfStarch == null) {
                                                System.out.println("\n" + userInput + " is not currently in your inventory. Please pick again.");
                                            }
                                        }
                                        System.out.println("\nHere's your random recipe with: " + choiceOfStarch.getIngredient());
                                        for (InventoryItem item : starchBasedRecipe(choiceOfStarch, protein, vegetable)) {
                                            System.out.println(item.getIngredient());
                                        }
                                        break;

                                    case 3: // Choose vegetable
                                        InventoryItem choiceOfVegetable = null;
                                        while (choiceOfVegetable == null) {
                                            System.out.println("\nWhich type of vegetable do you want to use in your recipe?");
                                            System.out.println("Available vegetables:");
                                            for (InventoryItem item : vegetable) {
                                                System.out.println(item.getQuantity() + "x " + item.getIngredient());
                                            }

                                            String userInput = sc.nextLine();

                                            for (InventoryItem item : vegetable) {
                                                if (item.getIngredient().equalsIgnoreCase(userInput)) {
                                                    choiceOfVegetable = item;
                                                }
                                            }
                                            if (choiceOfVegetable == null) {
                                                System.out.println("\n" + userInput + " is not currently in your inventory. Please pick again.");
                                            }
                                        }
                                        System.out.println("\nHere's your random recipe with: " + choiceOfVegetable.getIngredient());
                                        for (InventoryItem item : vegetableBasedRecipe(choiceOfVegetable, starch, protein)) {
                                            System.out.println(item.getIngredient());
                                        }
                                        break;

                                    case 4: // Random
                                        System.out.println("\nHere's your random recipe:");
                                        for (InventoryItem item : randomRecipe(protein, starch, vegetable)) {
                                            System.out.println(item.getIngredient());
                                        }
                                        break;

                                    case 5: // Back to main
                                        backToMain = true;
                                        break;

                                    default:
                                        System.out.println("Invalid input. Please enter a number from 1 - 5");
                                }

                                if (subChoice != 5) {
                                    System.out.println("\nDo you want to go back to the main menu? (y/n)");
                                    String response = sc.next();

                                    if (response.equalsIgnoreCase("y")) {
                                        break; // Exit the submenu loop
                                    }

                                }

                            }
                        }
                        break;

                    case 2: // Submenu for fruit recipes
                        while (!backToMain) {
                            System.out.println("""
                                    \n=== CREATE FRUIT COMBO ===
                                    1. Pick a fruit
                                    2. Random
                                    3. Back to main menu""");

                            if (sc.hasNextInt()) {
                                subChoice = sc.nextInt();

                                switch (subChoice) {
                                    case 1: // Pick a fruit
                                        InventoryItem choiceOfFruit = null;
                                        while (choiceOfFruit == null) {
                                            System.out.println("\nWhich type of fruit do you want to use in your fruit combo?");
                                            System.out.println("Available fruits:");
                                            for (InventoryItem item : fruit) {
                                                System.out.println(item.getQuantity() + "x " + item.getIngredient());
                                            }
                                            String userInput = sc.next();


                                            for (InventoryItem item : fruit) {
                                                if (item.getIngredient().equalsIgnoreCase(userInput)) {
                                                    choiceOfFruit = item;
                                                }
                                            }
                                            if (choiceOfFruit == null){
                                                System.out.println("\n" + userInput + " is not currently in your inventory. Please pick again.");
                                            }
                                        }

                                        System.out.println("\nHere's your random recipe with: " + choiceOfFruit.getIngredient());
                                        for (InventoryItem item : pickAFruit(choiceOfFruit, fruit)) {
                                            System.out.println(item.getIngredient());
                                        }
                                        break;

                                    case 2: // Random
                                        System.out.println("\nHere is your random fruit Combo:");
                                        for (InventoryItem item : fruitCombo(fruit)) {
                                            System.out.println(item.getIngredient());
                                        }
                                        break;

                                    case 3: // Back to main
                                        backToMain = true;
                                        break;

                                    default:
                                        System.out.println("Invalid input. Please enter a number from 1 - 3");
                                }
                                if (subChoice != 3) {
                                    System.out.println("\nDo you want to go back to the main menu? (y/n)");
                                    String response = sc.next();

                                    if (response.equalsIgnoreCase("y")) {
                                        break; // Exit the submenu loop
                                    }
                                }
                            }
                        }
                        break;

                    case 3: // Submenu for viewing ingrediënt lists
                        while (!backToMain) {
                            System.out.println("""
                                    \n=== VIEW INGREDIENTS ===
                                    1. View proteins
                                    2. View starches
                                    3. View vegetables
                                    4. View fruits
                                    5. Back to main menu""");

                            if (sc.hasNextInt()) {
                                subChoice = sc.nextInt();

                                switch (subChoice) {
                                    case 1:
                                        System.out.println("\n === Current list of proteins ===");
                                        for (InventoryItem item : protein) {
                                            System.out.println(item.getQuantity() + "x " + item.getIngredient());
                                        }
                                        break;

                                    case 2:
                                        System.out.println("\n === Current list of starches===");
                                        for (InventoryItem item : starch) {
                                            System.out.println(item.getQuantity() + "x " + item.getIngredient());
                                        }
                                        break;

                                    case 3:
                                        System.out.println("\n === Current list of vegetables ===");
                                        for (InventoryItem item : vegetable) {
                                            System.out.println(item.getQuantity() + "x " + item.getIngredient());
                                        }
                                        break;

                                    case 4:
                                        System.out.println("\n === Current list of fruits ===");
                                        for (InventoryItem item : fruit) {
                                            System.out.println(item.getQuantity() + "x " + item.getIngredient());
                                        }
                                        break;

                                    case 5: // Back to main
                                        backToMain = true;
                                        break;

                                    default:
                                        System.out.println("Invalid input. Please enter a number from 1 to 5");
                                }
                                if (subChoice != 5) {
                                    System.out.println("\nDo you want to go back to the main menu? (y/n)");
                                    String response = sc.next();

                                    if (response.equalsIgnoreCase("y")) {
                                        break; // Exit the submenu loop
                                    }
                                }
                            }
                        }
                        break;

                    case 4: // Submenu for altering ingrediënt lists
                        while (!backToMain) {
                            System.out.println("""
                                    \n=== ALTER INGREDIENTS ===
                                    1. Add ingrediënts
                                    2. Remove ingrediënts
                                    3. Alter ingrediënt quantity
                                    4. Back to main menu""");

                            if (sc.hasNextInt()) {
                                subChoice = sc.nextInt();
                                sc.nextLine();

                                switch (subChoice) {
                                    case 1: // Add ingrediënts
                                        boolean keepAdding = true;
                                        while(keepAdding) {
                                            System.out.println("Enter the name of the ingrediënt you want to add");
                                            String name = sc.nextLine();
                                            System.out.println("Enter the number of portions of " + name + " you want to add");
                                            int quantity = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("Enter the category for " + name + " [PROTEIN, STARCH, VEGETABLE, FRUIT]");
                                            String userInput = sc.nextLine().toUpperCase();
                                            Category category = Category.valueOf(userInput);

                                            if (category == Category.PROTEIN) {
                                                protein.add(new InventoryItem(name, quantity, category));
                                            } else if (category == Category.STARCH) {
                                                starch.add(new InventoryItem(name, quantity, category));
                                            } else if (category == Category.VEGETABLE) {
                                                vegetable.add(new InventoryItem(name, quantity, category));
                                            } else if (category == Category.FRUIT) {
                                                fruit.add(new InventoryItem(name, quantity, category));
                                            }
                                            System.out.println("\n" + quantity + " portions of " + name + " have been added to the list: " + category);

                                            System.out.println("\nDo you want to add another item? [y/n]");
                                            String response = sc.nextLine();
                                            if (response.equalsIgnoreCase("n")) keepAdding = false;
                                        }

                                        break;
                                    case 2: // Remove ingrediënts
                                        boolean keepRemoving = true;
                                        while (keepRemoving) {
                                            System.out.println("Enter the name of the ingrediënt you want to remove");
                                            String removedItem = sc.nextLine();
                                            InventoryItem targetItem = null;

                                            for (InventoryItem item : protein) {
                                                if (removedItem.equalsIgnoreCase(item.getIngredient())) {
                                                    targetItem = item;
                                                    protein.remove(item);
                                                    System.out.println(item.getIngredient() + " has been removed from the list of protein sources.");
                                                    break;
                                                }
                                            }
                                            for (InventoryItem item : starch) {
                                                if (removedItem.equalsIgnoreCase(item.getIngredient())) {
                                                    targetItem = item;
                                                    starch.remove(item);
                                                    System.out.println(item.getIngredient() + " has been removed from the list of starch sources.");
                                                    break;
                                                }
                                            }
                                            for (InventoryItem item : vegetable) {
                                                if (removedItem.equalsIgnoreCase(item.getIngredient())) {
                                                    targetItem = item;
                                                    vegetable.remove(item);
                                                    System.out.println(item.getIngredient() + " has been removed from the list of vegetables.");
                                                    break;
                                                }
                                            }
                                            for (InventoryItem item : fruit) {
                                                if (removedItem.equalsIgnoreCase(item.getIngredient())) {
                                                    targetItem = item;
                                                    fruit.remove(item);
                                                    System.out.println(item.getIngredient() + " has been removed from the list of fruits.");
                                                    break;
                                                }
                                            }
                                            if (targetItem == null) {
                                                System.out.println("Item not found.");
                                            }

                                            System.out.println("\nDo you want to remove another item? [y/n]");
                                            String response = sc.nextLine();
                                            if (response.equalsIgnoreCase("n")) keepRemoving = false;
                                        }

                                        break;
                                    case 3: // Alter ingrediënt quantity
                                        break;
                                    case 4: // Back to main
                                        backToMain = true;
                                        break;
                                    default:
                                        System.out.println("Invalid input. Please enter a number from 1 to 4.");
                                }
                                if (subChoice != 4) {
                                    System.out.println("\nDo you want to go back to the main menu? [y/n]");
                                    String response = sc.next();
                                    if (response.equalsIgnoreCase("y")) {
                                        break; // Exit submenu loop
                                    }
                                }
                            }
                        }
                        break;

                }
            }
        }
    }


    // This method creates a fruit recipe with 2 random ingredients from the fruit category.
    private static ArrayList<InventoryItem> fruitCombo(ArrayList<InventoryItem> fruit) {
        ArrayList<InventoryItem> fruitCombo = new ArrayList<>();
        Random random = new Random();
        int firstIndex = random.nextInt(fruit.size());
        int secondIndex;
        do {
            secondIndex = random.nextInt(fruit.size());
        } while (secondIndex == firstIndex);

        fruitCombo.add(fruit.get(firstIndex));
        fruitCombo.add(fruit.get(secondIndex));
        return fruitCombo;
    }

    // This method creates a fruit recipe where the user picks the first type of fruit and the second type is randomly selected
    private static ArrayList<InventoryItem> pickAFruit(InventoryItem chosenFruit, ArrayList<InventoryItem> fruit) {
        ArrayList<InventoryItem> fruitCombo = new ArrayList<>();
        Random random = new Random();
        InventoryItem secondFruit;
        do {
            secondFruit = fruit.get(random.nextInt(fruit.size()));
        } while (secondFruit.equals(chosenFruit));

        fruitCombo.add(chosenFruit);
        fruitCombo.add(secondFruit);
        return fruitCombo;
    }

    // This method creates a recipe with 1 random ingredient from each category.
    private static ArrayList<InventoryItem> randomRecipe(ArrayList<InventoryItem> protein, ArrayList<InventoryItem> starch, ArrayList<InventoryItem> vegetable) {
        ArrayList<InventoryItem> recipe = new ArrayList<>();
        Random random = new Random();
        recipe.add(protein.get(random.nextInt(protein.size())));
        recipe.add(starch.get(random.nextInt(starch.size())));
        recipe.add(vegetable.get(random.nextInt(vegetable.size())));
        return recipe;
    }

    // This method creates a recipe with a protein source selected by the user, a random starch source and a random vegetable.
    private static ArrayList<InventoryItem> proteinBasedRecipe(InventoryItem protein, ArrayList<InventoryItem> starch, ArrayList<InventoryItem> vegetable) {
        ArrayList<InventoryItem> recipe = new ArrayList<>();
        Random random = new Random();
        recipe.add(protein);
        recipe.add(starch.get(random.nextInt(starch.size())));
        recipe.add(vegetable.get(random.nextInt(vegetable.size())));
        return recipe;
    }

    // This method creates a recipe with a starch source selected by the user, a random protein source and a random vegetable.
    private static ArrayList<InventoryItem> starchBasedRecipe(InventoryItem starch, ArrayList<InventoryItem> protein, ArrayList<InventoryItem> vegetable) {
        ArrayList<InventoryItem> recipe = new ArrayList<>();
        Random random = new Random();
        recipe.add(protein.get(random.nextInt(protein.size())));
        recipe.add(starch);
        recipe.add(vegetable.get(random.nextInt(vegetable.size())));
        return recipe;
    }

    // This method creates a recipe with a vegetable selected by the user, a random starch source and a random protein source.
    private static ArrayList<InventoryItem> vegetableBasedRecipe(InventoryItem vegetable, ArrayList<InventoryItem> starch, ArrayList<InventoryItem> protein) {
        ArrayList<InventoryItem> recipe = new ArrayList<>();
        Random random = new Random();
        recipe.add(protein.get(random.nextInt(protein.size())));
        recipe.add(starch.get(random.nextInt(starch.size())));
        recipe.add(vegetable);
        return recipe;
    }


}