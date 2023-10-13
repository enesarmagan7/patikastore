package Patikastore;

public abstract class Product {
    //Product sınıfının değişkenlerini tanımlıyoruz.
    int id;
    private double price;
    private int stock;
    private int discount;
    private  double screenSize;
    private int ram;
    private int storage;
    private String productName;
     private Brand brand;
public Product(int id){
    this.id=id;
}
//Yapıcı Metotlarımı tanımlıyoruz.
    public Product(int id, double price, int stock, int discount, double screenSize, int ram, int storage, String productName, Brand brand) {
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
        this.screenSize = screenSize;
        this.ram = ram;
        this.storage = storage;
        this.productName = productName;
        this.brand = brand;
    }

    //Getter ve Setter metotlarımızı tanımlıyoruz.
    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
