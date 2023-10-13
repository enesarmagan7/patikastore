package Patikastore;

public class Notebook extends Product{
    //Product sınıfından miras aldık bunun yanında sınıfa ait benzersiz değişkenleri tanımlıyoruz.
    public Notebook(int id){
        super(id);
    }
    // Yapıcı Metotlarımı tanımlıyoruz.
    public Notebook(int id, double price, int stock, int discount, double screenSize, int ram, int storage, String productName, Brand brand) {
        super(id, price, stock, discount, screenSize, ram, storage, productName, brand);
    }
    //Getter ve Setter metotlarımızı tanımlıyoruz.
    @Override
    public Brand getBrand() {
        return super.getBrand();
    }

    @Override
    public void setBrand(Brand brand) {
        super.setBrand(brand);
    }
}
