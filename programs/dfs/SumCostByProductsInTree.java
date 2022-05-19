package dfs;

import java.util.*;

class Product {
    String name;
    int price;
    List<Product> subProducts;

    public Product(String name, int price, List<Product> subProducts) {
        this.name = name;
        this.price = price;
        this.subProducts = subProducts;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class SumCostByProductsInTree {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        List<Product> order = List.of(
                new Product("pizza", 4, null),
                new Product("burger", 3,
                        List.of(
                                new Product("pizza", 6, null),
                                new Product("burger", 2,
                                        List.of(
                                                new Product("pasta", 7, null),
                                                new Product("menu", 4, null)
                                        )
                                )
                        )
                ),
                new Product("coke", 1, null),
                new Product("menu", 5, null),
                new Product("fanta", 1,
                        List.of(
                                new Product("pizza", 3, null),
                                new Product("burger", 8, null)
                        )

                )
        );
        solution(order);

        // printing solution 1
        /*Map<String, Integer> map2 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, LinkedHashMap::new))*/;

//        System.out.println(map2);

        // printing solution 2
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).filter(entry -> !entry.getKey().equals("menu"))
                .forEach(entry -> System.out.println(entry.getKey() + " : " +entry.getValue()));

    }

    private static void solution(List<Product> order) {

        for (Product product :
                order) {

            if (product.subProducts != null)
                solution(product.subProducts);

            if (map.get(product.name) != null)
                map.put(product.name, map.get(product.name) + product.price);
            else
                map.put(product.name, product.price);


        }


    }
}
