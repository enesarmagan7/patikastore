package Patikastore;

import java.util.*;
import java.util.stream.Collectors;

public class MobilePhoneOperation {
    //Notebook sınıfına ait operasyonları tanımlayacağımız sınıfımız

    //MobilePhone nesnelerini hashmap içinde tutacağımız için (<Id,Notebook>) hashmap değişkenini tanımlıyoruz.

    private static Map<Integer,MobilPhone> mobilPhones=new HashMap<>();
    static Scanner scanner=new Scanner(System.in);
    static Scanner str=new Scanner(System.in);

    public static void AddMobilePhone(int idNumber,int choice) { //MobilePhone ekleme metodu.
        int ram,storage,stock,discount,batteryPower,camera=0;
        double price,screenSize=0;                          //MobilePhone değişkenlerini tanımlıyoruz.

        //Kullanıcıdan değerleri alıyoruz.

            System.out.println("Cep Telefonu özelliklerini girin.");

            System.out.println("RAM miktarı(GB) :");

             ram = scanner.nextInt();
            System.out.println("Ekran Boyutu(Inc) : (Ondalıklı sayıyı virgül ile giriniz.)");
             screenSize = scanner.nextDouble();
            System.out.println("Pil Gücü (mA):");
            batteryPower = scanner.nextInt();
            System.out.println("Depolama (GB) :");

            storage = scanner.nextInt();
            System.out.println("Kamera:(MP) ");
             camera= scanner.nextInt();
            System.out.println("Renk : ");
            String colour=str.nextLine();
            System.out.println("Stok miktarı :");
             stock = scanner.nextInt();
            System.out.println("İndirim Oranı:");
             discount = scanner.nextInt();
            System.out.println("Ürün Fiyatı :");
            price = scanner.nextDouble();
            System.out.println("Ürün Adı :");

            String name = str.nextLine();
        // Yeni bir MobilePhone ekliyoruz
            mobilPhones.put(idNumber, new MobilPhone(idNumber, price, stock, discount, screenSize, ram, storage,camera, name, Brand.sortBrand().get(choice - 1), batteryPower,colour));

            }

        public static boolean isPhoneInList(int idNumber){
    // Verilen ID numarasına sahip bir cep telefonu sisteme kayıtlı mı kontrol eder.
        if(mobilPhones.containsKey(idNumber)){
            return true;
        }
        return false;
       }
    public static void ListMobilePhone(){  //Notebook listeleme metodu


        //HashMaplare Comparator vermek key değerlerini sıralar. Bu nedenle value değerlerini aldık.
        //Comparator nesnelerini parametre olarak veriyoruz.

        List<MobilPhone> sortedMobilePhonesByID = mobilPhones.values()
                .stream()
                .sorted(Helper.getIdComparator())            // MobilePhone'ları ID'ye göre sırala
                .collect(Collectors.toList());

        // MobilePhone'ları markaya göre sırala
        List<MobilPhone> sortedMobilePhonesByBrand = mobilPhones.values()
                .stream()
                .sorted(Helper.getProductComparator())
                .collect(Collectors.toList());

        //Sıralama işlemleri.
        System.out.println("1--ID numarasına göre sıralama");
        System.out.println("2--Markaya göre sıralama");
        int choice= scanner.nextInt();
        if(mobilPhones.isEmpty()){
            System.out.println("Sistemde kayıtlı Cep Telefonu bulunamadı...");
            choice=3;
        }
        switch (choice) {
            case 1:
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID | Ürün Adı               | Fiyat     | Marka   | Depolama | Ekran | Kamera | Pil    | RAM | Renk   |");
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                for (MobilPhone phone : sortedMobilePhonesByID) {

                    System.out.format("| %2d | %-21s | %-8.2f TL | %-6s | %-8d | %-5.1f | %-6d | %-6d | %-3d | %-7s |\n",
                            phone.getId(), phone.getProductName(), phone.getPrice(), phone.getBrand().getBrandName(),
                            phone.getStorage(), phone.getScreenSize(), phone.getCamera(), phone.getBatteryPower(), phone.getRam(), phone.getColour());

                }
                System.out.println("-----------------------------------------------------------");
                break;

            case 2:
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID | Ürün Adı               | Fiyat     | Marka   | Depolama | Ekran | Kamera | Pil    | RAM | Renk   |");
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                for (MobilPhone a : sortedMobilePhonesByBrand) {
                    System.out.format("| %2d | %-21s | %-8.2f TL | %-6s | %-8d | %-5.1f | %-6d | %-6d | %-3d | %-7s |\n",
                            a.getId(),a.getProductName(), a.getPrice(), a.getBrand().getBrandName(),
                            a.getStorage(), a.getScreenSize(), a.getCamera(), a.getBatteryPower(), a.getRam(), a.getColour());
                }
                break;
            case 3: break;
        }

    }

    //MobilePhone kaldırma metodu.
    public static void removeMobilePhone(){
        //Kullanıcıdan ID al ve ID var ise kaldır.
        System.out.println("Silmek istediğiniz Notebook için Id numarası giriniz");
        int ıd= scanner.nextInt();
        if(mobilPhones.containsKey(ıd)){
            mobilPhones.remove(ıd);
            System.out.println("Cep Telefonu silindi");
        }else{
            System.out.println("Ürün id bulunamadı.");
        }





    }

}
