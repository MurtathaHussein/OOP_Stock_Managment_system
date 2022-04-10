package SKU;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Product> products = new ArrayList<Product>();
    static List<Customer> customers = new ArrayList<Customer>();
    static List<Order> orders = new ArrayList<Order>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        products.add(new Product("MS123", "X box series x", 44999));
        products.add(new Product("MS124", "X box series s", 24999));
        products.add(new Product("PSX125", "Playstation 5", 44999));
        products.add(new Product("PSX126", "Playstation 5 Digital Edition", 44999));
        products.add(new Product("VAL128", "Steam Deck", 35900));

        customers.add(new Customer(1, "Darren", "Dancey", new Address("5", "Chester Street", "Manchester", "Greater Manchester", "M1-5GD"), "555-1212"));
        customers.add(new Customer(2, "Jane", "Bloggs", new Address("52", "Bond Street", "Manchester", "Greater Manchester", "M1-7DD"), "555-14312"));
        customers.add(new Customer(3, "Rachel", "Greene", new Address("10", "Manhatten Street", "Manhatten", "New York", "NY 221"), "555-1231"));


        String selection = "";

        do {
            System.out.println("----------------------------");
            System.out.println("The everything store");
            System.out.println("Choose from these options");
            System.out.println("----------------------------");
            System.out.println("[1] List all products");
            System.out.println("[2] Search for product by SKU");
            System.out.println("[3] Add a new product");
            System.out.println("[4] Update a product's price");
            System.out.println("[5] Change a product's description");
            System.out.println("[6] Delete a product");
            System.out.println("[10] List all customers");
            System.out.println("[11] Search for customer by ID");
            System.out.println("[12] Add a new customer");
            System.out.println("[13] Update a customer's details");
            System.out.println("[14] Delete a customer");
            System.out.println("[20] List all orders");
            System.out.println("[21] Display order by ID");
            System.out.println("[22] Mark an order complete");
            System.out.println("[23] Create an order");
            System.out.println("[24] Update an order");
            System.out.println("[99] Exit");
            System.out.println();
            selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    listAllProducts();
                    break;

                case "2":
                    searchProduct();
                    break;

                case "3":
                    addNewProduct();
                    break;

                case "4":
                    updateProductPrice();
                    break;

                case "5":
                    changeProductDescription();
                    break;

                case "6":
                    deleteProduct();
                    break;

                case "10":
                    listAllCustomers();
                    break;

                case "11":
                    searchCustomer();
                    break;

                case "12":
                    addCustomer();
                    break;

                case "13":
                    updateCustomerDetails();
                    break;

                case "14":
                    deleteCustomer();
                    break;

                case "20":
                    listAllOrders();
                    break;

                case "21":
                    searchOrder();
                    break;

                case "22":
                    markOrderComplete();
                    break;

                case "23":
                    createOrder();
                    break;

                case "24":
                    updateOrder();
                    break;

                case "99":
                    System.exit(0);

                default:
                    System.out.println("Please enter an option from above menu only..");
                    break;
            }
        } while(!selection.equals("99"));
    }

    private static void updateOrder() {
        System.out.println("Enter order id:");
        int id = scanner.nextInt();
        boolean isOrderExists = false;

        Iterator<Order> itr = orders.iterator();
        while (itr.hasNext()) {
            Order order = itr.next();
            if (id == order.getOrderId()) {
                isOrderExists = true;
                order.getItems().clear();

                System.out.println("Enter number of products to order:");
                int n = scanner.nextInt();
                List<Product> products = new ArrayList<Product>();
                for (int i=0; i<n; i++) {
                    Product product = searchProduct();
                    products.add(product);
                }

                order.setItems(products);
                System.out.println("Product updated successfully..");
            }
        }

        if (!isOrderExists) {
            System.out.println("There is no order available with id: "+id);
        }
    }

    private static void createOrder() {
        Customer customer = searchCustomer();
        System.out.println("Enter number of products to order:");
        int n = scanner.nextInt();
        List<Product> products = new ArrayList<Product>();
        for (int i=0; i<n; i++) {
            Product product = searchProduct();
            products.add(product);
        }

        Order order = new Order(customer, products, orders.size()+1, false);
        orders.add(order);
        System.out.println("Order created successfully..");
    }

    private static void markOrderComplete() {
        System.out.println("Enter order id:");
        int id = scanner.nextInt();
        boolean isOrderExists = false;

        Iterator<Order> itr = orders.iterator();
        while (itr.hasNext()) {
            Order order = itr.next();
            if (id == order.getOrderId()) {
                isOrderExists = true;
                order.setComplete(true);
                System.out.println("Order marked complete successfully..");
            }
        }

        if (!isOrderExists) {
            System.out.println("There is no order available with id: "+id);
        }
    }

    private static void searchOrder() {
        System.out.println("Enter order id:");
        int id = scanner.nextInt();
        boolean isOrderExists = false;
        for (Order order: orders) {
            if (id == order.getOrderId()) {
                isOrderExists = true;
                System.out.println(order);
            }
        }

        if (!isOrderExists) {
            System.out.println("There is no customer available with id: "+id);
        }
    }

    private static void listAllOrders() {
        for (Order order: orders) {
            System.out.println(order);
        }
    }

    private static void deleteCustomer() {
        System.out.println("Enter customer id:");
        int id = scanner.nextInt();

        boolean isCustomerExists = false;
        Iterator<Customer> itr = customers.iterator();
        while (itr.hasNext()) {
            Customer customer = itr.next();
            if (id == customer.getCustomerId()) {
                isCustomerExists = true;
                itr.remove();
                System.out.println("Customer deleted successfully..");
            }
        }

        if (!isCustomerExists) {
            System.out.println("There is no customer available with id: "+id);
        }
    }

    private static void updateCustomerDetails() {
        System.out.println("Enter customer id:");
        int id = scanner.nextInt();

        boolean isCustomerExists = false;
        Iterator<Customer> itr = customers.iterator();
        while (itr.hasNext()) {
            Customer customer = itr.next();
            if (id == customer.getCustomerId()) {
                isCustomerExists = true;

                System.out.println("Enter first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter second name:");
                String secondName = scanner.nextLine();
                System.out.println("Enter telephone number:");
                String telephoneNumber = scanner.nextLine();
                System.out.println("Enter house number:");
                String house = scanner.nextLine();
                System.out.println("Enter address Line1:");
                String addressLine1 = scanner.nextLine();
                System.out.println("Enter address Line2:");
                String addressLine2 = scanner.nextLine();
                System.out.println("Enter country:");
                String country = scanner.nextLine();
                System.out.println("Enter post Code:");
                String postCode = scanner.nextLine();

                customer.setFirstName(firstName);
                customer.setSecondName(secondName);
                customer.setTelephoneNumber(telephoneNumber);
                customer.setAddress(new Address(house, addressLine1, addressLine2, country, postCode));
                System.out.println("Customer updated successfully..");
            }
        }

        if (!isCustomerExists) {
            System.out.println("There is no customer available with id: "+id);
        }
    }

    private static void addCustomer() {
        System.out.println("Enter customer id:");
        int id = scanner.nextInt();
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter second name:");
        String secondName = scanner.nextLine();
        System.out.println("Enter telephone number:");
        String telephoneNumber = scanner.nextLine();
        System.out.println("Enter house number:");
        String house = scanner.nextLine();
        System.out.println("Enter address Line1:");
        String addressLine1 = scanner.nextLine();
        System.out.println("Enter address Line2:");
        String addressLine2 = scanner.nextLine();
        System.out.println("Enter country:");
        String country = scanner.nextLine();
        System.out.println("Enter post Code:");
        String postCode = scanner.nextLine();

        Customer customer = new Customer(id, firstName, secondName, new Address(house, addressLine1, addressLine2, country, postCode), telephoneNumber);
        customers.add(customer);
        System.out.println("Customer added successfully...");
    }

    private static Customer searchCustomer() {
        System.out.println("Enter customer id:");
        int id = scanner.nextInt();
        boolean isCustomerExists = false;
        for (Customer customer: customers) {
            if (id == customer.getCustomerId()) {
                isCustomerExists = true;
                System.out.println(customer);
                return customer;
            }
        }

        if (!isCustomerExists) {
            System.out.println("There is no customer available with id: "+id);
        }
        return null;
    }

    private static void listAllCustomers() {
        for (Customer customer: customers) {
            System.out.println(customer);
        }
    }

    private static void deleteProduct() {
        System.out.println("Enter product's SKU: ");
        String SKU = scanner.nextLine();
        boolean isProductExists = false;

        Iterator<Product> itr = products.iterator();
        while (itr.hasNext()) {
            Product product = itr.next();
            if (SKU.equalsIgnoreCase(product.getSKU())) {
                isProductExists = true;
                itr.remove();
                System.out.println("Product deleted successfully..");
            }
        }
        if (!isProductExists) {
            System.out.println("There is no product available with SKU: "+SKU);
        }
    }

    private static void changeProductDescription() {
        System.out.println("Enter product's SKU: ");
        String SKU = scanner.nextLine();
        System.out.println("Enter new description: ");
        String description = scanner.nextLine();
        boolean isProductExists = false;

        Iterator<Product> itr = products.iterator();
        while (itr.hasNext()) {
            Product product = itr.next();
            if (SKU.equalsIgnoreCase(product.getSKU())) {
                isProductExists = true;
                product.setDescription(description);
                System.out.println("Product description updated successfully..");
            }
        }
        if (!isProductExists) {
            System.out.println("There is no product available with SKU: "+SKU);
        }
    }

    private static void updateProductPrice() {
        System.out.println("Enter product's SKU: ");
        String SKU = scanner.nextLine();
        System.out.println("Enter new price: ");
        int price = scanner.nextInt();
        boolean isProductExists = false;

        Iterator<Product> itr = products.iterator();
        while (itr.hasNext()) {
            Product product = itr.next();
            if (SKU.equalsIgnoreCase(product.getSKU())) {
                isProductExists = true;
                product.setPrice(price);
                System.out.println("Product price updated successfully..");
            }
        }
        if (!isProductExists) {
            System.out.println("There is no product available with SKU: "+SKU);
        }
    }

    private static void addNewProduct() {
        System.out.println("Enter SKU:");
        String SKU = scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        System.out.println("Enter price:");
        int price = scanner.nextInt();

        Product product = new Product(SKU, description, price);
        products.add(product);
        System.out.println("Product added successfully...");
    }

    private static Product searchProduct() {
        System.out.println("Enter product's SKU: ");
        String SKU = scanner.nextLine();
        boolean isProductExists = false;
        for (Product product: products) {
            if (SKU.equalsIgnoreCase(product.getSKU())) {
                isProductExists = true;
                System.out.println(product);
                return product;
            }
        }
        if (!isProductExists) {
            System.out.println("There is no product available with SKU: "+SKU);
        }
        return null;
    }

    private static void listAllProducts() {
        for (Product product: products) {
            System.out.println(product);
        }
    }
}
