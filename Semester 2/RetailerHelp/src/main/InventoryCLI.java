package main;

import java.util.List;
import java.util.Scanner;

public class InventoryCLI {

    public void startProgram() {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. Produkt hinzufügen");
            System.out.println("2. Produkt entfernen");
            System.out.println("3. Produkt nach ID suchen");
            System.out.println("4. Produkte nach Kategorie anzeigen");
            System.out.println("5. Alle Produkte anzeigen");
            System.out.println("6. Produkte nach Namen sortieren");
            System.out.println("7. Produkte nach Preis sortieren");
            System.out.println("8. Produkte mit niedrigen Lagerbeständen anzeigen");
            System.out.println("9. Produkte nach benutzerdefiniertem Filter anzeigen");
            System.out.println("10. Preise aller Produkte um einen Prozentsatz erhöhen");
            System.out.println("11. Programm beenden");
            System.out.print("Auswahl: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Kategorie: ");
                    String category = scanner.nextLine();

                    System.out.print("Preis: ");
                    double price = scanner.nextDouble();

                    System.out.print("Bestand: ");
                    int quantity = scanner.nextInt();

                    Product product = new Product(
                            id, name, category, price, quantity);

                    inventory.addProduct(product);

                    System.out.println("Produkt hinzugefügt.");
                    break;

                case 2:
                    System.out.print("Produkt-ID: ");
                    id = scanner.nextInt();

                    if (inventory.removeProduct(id)) {
                        System.out.println("Produkt entfernt.");
                    } else {
                        System.out.println("Produkt nicht gefunden.");
                    }
                    break;

                case 3:
                    System.out.print("Produkt-ID: ");
                    id = scanner.nextInt();

                    Product found = inventory.findProductById(id);

                    if (found != null) {
                        System.out.println("\nName: " + found.getName() +
                                "\nBestand: " + found.getQuantity() +
                                "\nKategorie: " + found.getCategory() +
                                "\nPreis: " + found.getPrice());
                    } else {
                        System.out.println("Produkt nicht gefunden.");
                    }
                    break;

                case 4:
                    System.out.print("Kategorie: ");
                    category = scanner.nextLine();

                    List<Product> categoryProducts =
                            inventory.findProductsByCategory(category);

                    categoryProducts.forEach(p -> System.out.println("\nName: " + p.getName() +
                            "\nBestand: " + p.getQuantity() +
                            "\nProdukt-ID: " + p.getProductId() +
                            "\nPreis: " + p.getPrice()));
                    break;

                case 5:
                    inventory.getAllProducts()
                            .forEach(p -> System.out.println("\nName: " + p.getName() +
                                    "\nBestand: " + p.getQuantity() +
                                    "\nProdukt-ID: " + p.getProductId() +
                                    "\nPreis: " + p.getPrice() +
                                    "\nKategorie: " + p.getCategory()));
                    break;

                case 6:
                    inventory.sortProductsByName()
                            .forEach(p -> System.out.println("\nName: " + p.getName() +
                                    "\nBestand: " + p.getQuantity() +
                                    "\nProdukt-ID: " + p.getProductId() +
                                    "\nPreis: " + p.getPrice() +
                                    "\nKategorie: " + p.getCategory()));
                    break;

                case 7:
                    inventory.sortProductsByPrice()
                            .forEach(p -> System.out.println("\nName: " + p.getName() +
                                    "\nBestand: " + p.getQuantity() +
                                    "\nProdukt-ID: " + p.getProductId() +
                                    "\nPreis: " + p.getPrice() +
                                    "\nKategorie: " + p.getCategory()));
                    break;

                case 8:
                    System.out.print("Schwellenwert: ");
                    int threshold = scanner.nextInt();

                    inventory.getLowStockProducts(threshold)
                            .forEach(p -> System.out.println("\nName: " + p.getName() +
                                    "\nBestand: " + p.getQuantity() +
                                    "\nProdukt-ID: " + p.getProductId() +
                                    "\nPreis: " + p.getPrice() +
                                    "\nKategorie: " + p.getCategory()));
                    break;

                case 9:
                    System.out.println("Filteroption:");
                    System.out.println("1 = Preis kleiner als Wert");
                    System.out.println("2 = Bestand kleiner als Wert");

                    int filterChoice = scanner.nextInt();

                    if (filterChoice == 1) {

                        System.out.print("Maximaler Preis: ");
                        double maxPrice = scanner.nextDouble();

                        inventory.filterProducts(
                                        p -> p.getPrice() < maxPrice)
                                .forEach(p -> System.out.println("\nName: " + p.getName() +
                                        "\nBestand: " + p.getQuantity() +
                                        "\nProdukt-ID: " + p.getProductId() +
                                        "\nPreis: " + p.getPrice() +
                                        "\nKategorie: " + p.getCategory()));

                    } else if (filterChoice == 2) {

                        System.out.print("Maximaler Bestand: ");
                        int maxQuantity = scanner.nextInt();

                        inventory.filterProducts(
                                        p -> p.getQuantity() < maxQuantity)
                                .forEach(p -> System.out.println("\nName: " + p.getName() +
                                        "\nBestand: " + p.getQuantity() +
                                        "\nProdukt-ID: " + p.getProductId() +
                                        "\nPreis: " + p.getPrice() +
                                        "\nKategorie: " + p.getCategory()));
                    }

                    break;

                case 10:
                    System.out.print("Prozentuale Erhöhung: ");
                    double percent = scanner.nextDouble();

                    inventory.applyToProducts(productItem ->
                            productItem.setPrice(
                                    productItem.getPrice()
                                            * (1 + percent / 100)));

                    System.out.println("Preise aktualisiert.");
                    break;

                case 11:
                    running = false;
                    System.out.println("Programm beendet.");
                    break;

                default:
                    System.out.println("Ungültige Eingabe.");
            }
        }

        scanner.close();
    }
}