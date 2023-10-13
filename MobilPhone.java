package Patikastore;

public class MobilPhone extends Product{
    //Product sınıfından miras aldık bunun yanında sınıfa ait benzersiz değişkenleri tanımlıyoruz.
    private int batteryPower;
    private int camera;
    private String colour;

// Yapıcı Metotlarımı tanımlıyoruz.
    public MobilPhone(int id, double price, int stock, int discount, double screenSize, int ram, int storage,int camera, String productName, Brand brand, int batteryPower,String colour) {
        super(id, price, stock, discount, screenSize, ram, storage, productName, brand);
        this.batteryPower = batteryPower;
        this.colour=colour;
        this.camera=camera;

    }
//Getter ve Setter metotlarımızı tanımlıyoruz.


    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColour() {
        return colour;

    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
