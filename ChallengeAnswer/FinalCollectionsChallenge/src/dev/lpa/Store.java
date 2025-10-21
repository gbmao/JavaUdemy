package dev.lpa;

import java.util.*;

public class Store {


    private static Random random = new Random();
    private Map<String, InventoryItem> inventory;
    private NavigableSet<Cart> carts = new TreeSet<>(Comparator.comparing(Cart::getId));
    private Map<Category, Map<String, InventoryItem>> aisleInventory;

    public static void main(String[] args) {

        Store myStore = new Store();
        myStore.stockStore();
        myStore.listInventory();

        myStore.stockAisle();
        myStore.listProductsByCategory();

        myStore.manageStoreCarts();
        myStore.listProductsByCategory(false, true);
    }

    private void manageStoreCarts() {

        Cart cart1 = new Cart(Cart.CartType.PHYSICAL, 1);
        carts.add(cart1);

        InventoryItem item = aisleInventory.get(Category.PRODUCE).get("Apple");
        cart1.addItem(item, 6);
        cart1.addItem(aisleInventory.get(Category.PRODUCE).get("Banana"), 5);
        cart1.addItem(aisleInventory.get(Category.BEVERAGE).get("Coffee"), 5);
        System.out.println(cart1);

        cart1.removeItem(aisleInventory.get(Category.PRODUCE).get("Banana"), 2);
        System.out.println(cart1);



    }

    private boolean checkOutCart() {

        return false;
    }

    private void abandonCarts() {

    }

    private void listProductsByCategory() {

//        aisleInventory.keySet().forEach(k -> {
//            System.out.println("--------------\n "+ k + "\n-----------------");
//            aisleInventory.get(k).keySet().forEach(System.out::println);
//        });
        listProductsByCategory(true,false);
    }

    private void listProductsByCategory(boolean includeHeader, boolean includeDetail) {

        aisleInventory.keySet().forEach(k -> {
           if(includeHeader) System.out.println("--------------\n "+ k + "\n-----------------");
           if(!includeDetail) {
               aisleInventory.get(k).keySet().forEach(System.out::println);
           } else {
               aisleInventory.get(k).values().forEach(System.out::println);
           }
        });
    }

    private void stockStore() {

        inventory = new HashMap<>();
        List<Product> products = new ArrayList<>( List.of(
                // PRODUCE
                new Product("A100", "Apple", "Local", Category.PRODUCE),
                new Product("A101", "Banana", "Ecuador", Category.PRODUCE),
                new Product("A102", "Tomato", "Green Valley Farms", Category.PRODUCE),
                new Product("A103", "Lettuce", "Fresh Leaf", Category.PRODUCE),
                new Product("A104", "Carrot", "Organic Roots", Category.PRODUCE),

// DAIRY
                new Product("D200", "Milk", "DairyPure", Category.DAIRY),
                new Product("D201", "Cheddar Cheese", "Farmhouse", Category.DAIRY),
                new Product("D202", "Greek Yogurt", "Oikos", Category.DAIRY),
                new Product("D203", "Butter", "Country Gold", Category.DAIRY),
                new Product("D204", "Cream Cheese", "Philadelphia", Category.DAIRY),

// CEREAL
                new Product("C300", "Oatmeal", "Quaker", Category.CEREAL),
                new Product("C301", "Corn Flakes", "Kellogg's", Category.CEREAL),
                new Product("C302", "Granola", "Nature Valley", Category.CEREAL),
                new Product("C303", "Rice Cereal", "Gerber", Category.CEREAL),
                new Product("C304", "Wheat Biscuits", "Weetabix", Category.CEREAL),

// MEAT
                new Product("M400", "Chicken Breast", "Tyson", Category.MEAT),
                new Product("M401", "Pork Chops", "Smithfield", Category.MEAT),
                new Product("M402", "Beef Steak", "Angus Choice", Category.MEAT),
                new Product("M403", "Ground Turkey", "Butterball", Category.MEAT),
                new Product("M404", "Bacon", "Oscar Mayer", Category.MEAT),

// BEVERAGE
                new Product("B500", "Orange Juice", "Tropicana", Category.BEVERAGE),
                new Product("B501", "Cola", "Coca-Cola", Category.BEVERAGE),
                new Product("B502", "Mineral Water", "Evian", Category.BEVERAGE),
                new Product("B503", "Coffee", "Starbucks", Category.BEVERAGE),
                new Product("B504", "Green Tea", "Lipton", Category.BEVERAGE)

        ));

        products.forEach(p -> inventory.put(p.sku(), new InventoryItem(p,
                random.nextDouble(0,1.25), 1000, 5)));
    }

    private void stockAisle() {

        aisleInventory = new EnumMap<>(Category.class);
        for (InventoryItem item : inventory.values()) {
            Category aisle = item.getProduct().category();

            Map<String, InventoryItem> productMap = aisleInventory.get(aisle);
            if (productMap == null) {
                productMap = new TreeMap<>();
            }
            productMap.put(item.getProduct().name(), item);
            aisleInventory.putIfAbsent(aisle, productMap);
        }
    }

    private void listInventory() {

        System.out.println("----------------------");
        inventory.values().forEach(System.out::println);
    }

}
