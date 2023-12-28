package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Services {
    private static Connection conn=null;

    static {
        String url="jdbc:mysql://localhost:3306/j2ee";
        String user="root";
        String pass="tiger";
        try {
            conn= DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // insert product
     int inertProduct(Product newproduct){
        int n=0;
        String quaary="insert into product_info values(?,?,?,?)";
        try {
            PreparedStatement prsmt=conn.prepareStatement(quaary);
            prsmt.setInt(1,newproduct.getProductId());
            prsmt.setString(2,newproduct.getProductName());
            prsmt.setDouble(3,newproduct.getProductPrice());
            prsmt.setString(4,newproduct.getProducType());
            n= prsmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
         return n;
     }

    // update product
    int updateProduct(Product newproduct){
        int n=0;
        String quaary="update product_info set product_name=?,  product_price=? , product_type=? where product_id=?";
        try {
            PreparedStatement prsmt=conn.prepareStatement(quaary);
            prsmt.setString(1,newproduct.getProductName());
            prsmt.setDouble(2,newproduct.getProductPrice());
            prsmt.setString(3,newproduct.getProducType());
            prsmt.setInt(4,newproduct.getProductId());
            n= prsmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("product not found");
        }
        return n;
    }

    int removeProduct(Product newProduct){
        int n=0;
        String qurey="delete from product_info where product_id=?";
        try {
            PreparedStatement prsmt=conn.prepareStatement(qurey);
            prsmt.setInt(1,newProduct.getProductId());
            n = prsmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("product not fond");
        }
        return n;
    }

    public List<Product> displayAllproduc(){
        String displayQuary="Select * from product_info";
        List<Product> prolist=new ArrayList<>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(displayQuary);

            while (rs.next()){
                int product_id=rs.getInt(1);
                String productName=rs.getString(2);
                double prodctPrice=rs.getDouble(3);
                String productType=rs.getString(4);

                Product productList=new Product(product_id,productName,prodctPrice,productType);
                prolist.add(productList);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return prolist;

    }

    public Product displayProductByid(Product newProduct){
        String diaplayq="select * from product_info where product_id=?";
        Product product=new Product();
        try {
            PreparedStatement prst = conn.prepareStatement(diaplayq);
            prst.setInt(1,newProduct.getProductId());
            ResultSet rs=prst.executeQuery();
            while (rs.next()){
                 product=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return product;

    }

    public List<Product> filterByPrice(double lPrice, double hPrice) {
        String quaryfilterByprice="select * from product_info where product_price between ? and ? order by product_price";
        List<Product> p=new ArrayList<>();
        try {
            PreparedStatement ptsmt=conn.prepareStatement(quaryfilterByprice);
            ptsmt.setDouble(1,lPrice);
            ptsmt.setDouble(2,hPrice);
            ResultSet rs =ptsmt.executeQuery();
            while (rs.next()){
               Product pr = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
               p.add(pr);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }

    public List<Product> filterByCatgry(String ctgry) {
        String qforCatery="select * from product_info where product_type=?";
        List<Product> pl= new ArrayList<>();
        try {
            PreparedStatement prstm=conn.prepareStatement(qforCatery);
            prstm.setString(1,ctgry);
            ResultSet rs=prstm.executeQuery();
            while (rs.next()){
                Product p = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
                pl.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pl;
    }
}
