package application;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Services servicerr=new Services();
    private static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("select option");
        System.out.println("1 Insert product");
        System.out.println("2 update product");
        System.out.println("3 remove product");
        System.out.println("4 display product");
        System.out.println("5 display y id");
        System.out.println("6 filter");
        System.out.println("7 exit");

        int ch= sc.nextInt();

        switch (ch){
            case 1:
                insertProduct();
                break;
            case 2:
                updateProduct();
                break;
            case 3:
                removeProduct();
                break;
            case 4:
                 displayProduct();
                break;

            case 5:
                displayProductByid();
                break;
            case 6:
                filterProduct();
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("invalid input");
                break;
        }
        main(args);
    }

    // interst main
    public static void insertProduct(){
        System.out.println("enter productId");
        int productId= sc.nextInt();
        System.out.println("enter product name ");
        String productName=sc.next();
        System.out.println("entrer product price");
        double productPrice=sc.nextDouble();
        System.out.println("enter product type");
        String productType=sc.next();
        Product newProduct=new Product(productId,productName,productPrice,productType);
        int n=servicerr.inertProduct(newProduct);
        System.out.println( n + " recode updste");
    }

    // update procut
    public static void updateProduct(){
        System.out.println("enter productId theat u wnaht to update");
        int productId= sc.nextInt();
        System.out.println("enter product update name ");
        String productName=sc.next();
        System.out.println("entrer product update price");
        double productPrice=sc.nextDouble();
        System.out.println("enter product update type");
        String productType=sc.next();
        Product newProduct=new Product(productId,productName,productPrice,productType);
        int n=servicerr.updateProduct(newProduct);
        System.out.println( n + " recode updste");

    }
    //remove product
    public static void removeProduct(){
        System.out.println("enter product id");
        int productId= sc.nextInt();
        Product newProduct=new Product(productId);
        int n=servicerr.removeProduct(newProduct);
        System.out.println(n +" recode delete");
    }

    public static void displayProduct(){
       List<Product> p= servicerr.displayAllproduc();
        System.out.println(" id   name    price   type ");
        for (Product pro:p){
            System.out.println(pro.getProductId()+"  "+pro.getProductPrice()+" "+pro.getProductName()+" "+pro.getProducType());
        }

    }
    public static void displayProductByid(){
        System.out.println("enter product id ");
        int id=sc.nextInt();
        Product newProduct=new Product(id);
        Product p =servicerr.displayProductByid(newProduct);
        System.out.println(p.getProductId()+" "+p.getProductPrice()+" "+p.getProductName()+" "+p.getProducType());
    }
    public static void filterProduct(){
        System.out.println("1 filter by price");
        System.out.println("2 filter by catogary");
        int ch= sc.nextInt();
        switch (ch){
            case 1:
                System.out.println("enter lower limit");
                double lPrice=sc.nextDouble();
                System.out.println("enter uper limit");
                double hPrice= sc.nextDouble();
                List<Product> pr=servicerr.filterByPrice(lPrice,hPrice);
                for (Product p:pr){
                    System.out.println(p.getProductId()+" "+p.getProductPrice()+" "+p.getProductName()+" "+p.getProducType());
                }
                break;
            case 2:
                System.out.println("enter ctogary");
                String ctgry=sc.next();
                List<Product> prc=servicerr.filterByCatgry(ctgry);
                for(Product pra:prc){
                    System.out.println(pra.getProductId()+" "+pra.getProductName()+" "+pra.getProductPrice()+" "+pra.getProducType());
                }
                break;
            default:
                System.out.println("invalid input");
        }
    }

}

