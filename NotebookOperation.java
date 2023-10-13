package Patikastore;

import java.util.*;
import java.util.stream.Collectors;

public class NotebookOperation {
    //Notebook sınıfına ait operasyonları tanımlayacağımız sınıfımız

    static Scanner sc = new Scanner(System.in);
    static Scanner str = new Scanner(System.in);
//Notebook nesnelerini hashmap içinde tutacağımız için (<Id,Notebook>) hashmap değişkenini tanımlıyoruz.
    private static Map<Integer, Notebook> notebookMap = new HashMap<>();


    //Notebook listeleme metodu
    public static void NotebookList() {


        //HashMaplare Comparator vermek key değerlerini sıralar. Bu nedenle value değerlerini aldık.
        //Comparator nesnelerini parametre olarak veriyoruz.

        // Notebook'ları ID'ye göre sırala
        List<Notebook> sortedNotebooksByID = notebookMap.values()
                .stream()
                .sorted(Helper.getIdComparator())
                .collect(Collectors.toList());

        // Notebook'ları markaya göre sırala
        List<Notebook> sortedNotebooksByBrand = notebookMap.values()
                .stream()
                .sorted(Helper.getProductComparator())
                .collect(Collectors.toList());

         //Sıralama işlemleri.
        System.out.println("1--ID numarasına göre sıralama");
        System.out.println("2--Markaya göre sıralama");
        int choice = sc.nextInt();
        if (notebookMap.isEmpty()) {
            System.out.println("Sistemde kayıtlı Notebook bulunamadı..");
            choice = 3;
        }
        switch (choice) {
            case 1:
                System.out.println("-----------------------------------------------------------");
                System.out.println("| ID | Ürün Adı                | Fiyat     | Marka   | Depolama | Ekran | RAM |");
                System.out.println("-----------------------------------------------------------");
                for (Notebook note : sortedNotebooksByID) {

                    System.out.format("| %2d | %-24s | %-9.2f | %-7s | %-9d | %-5.1f | %-3d |\n", note.getId(), note.getProductName(), note.getPrice(), note.getBrand().getBrandName(), note.getStorage(), note.getScreenSize(), note.getRam());

                }
                System.out.println("-----------------------------------------------------------");
                break;

            case 2:
                System.out.println("-----------------------------------------------------------");
                System.out.println("| ID | Ürün Adı                | Fiyat     | Marka   | Depolama | Ekran | RAM |");
                System.out.println("-----------------------------------------------------------");
                for (Notebook a : sortedNotebooksByBrand) {
                    System.out.format("| %2d | %-24s | %-9.2f | %-7s | %-9d | %-5.1f | %-3d |\n", a.getId(), a.getProductName(), a.getPrice(), a.getBrand().getBrandName(), a.getStorage(), a.getScreenSize(), a.getRam());
                }
                break;

            case 3:
                break;
        }
    }

    public static void AddNotebook(int idNumber, int choice) {   //Notebook ekleme metodu.

          int ram,storage,stock,discount=0;  //Notebook değişkenlerini tanımlıyoruz.
          double price,screenSize=0;        //Kullanıcıdan değerleri alıyoruz.
          String name="";
          System.out.println("Notebook özelliklerini giriniz.");

          System.out.println("RAM miktarı(GB) giriniz :");
           ram = str.nextInt();
          System.out.println("Ekran Boyutu(Inc) giriniz :(Ondalıklı sayıyı virgül ile giriniz.)");
           screenSize = str.nextDouble();
          System.out.println("Depolama miktarı giriniz(GB):");
           storage = str.nextInt();
          System.out.println("Stok miktarı giriniz :");
           stock = str.nextInt();
          System.out.println("İndirim Oranı giriniz:");
          discount = str.nextInt();
          System.out.println("Ürün Fiyatını giriniz :");
           price = str.nextDouble();
          System.out.println("Ürün Adını giriniz :");
           name = sc.nextLine();

        // Yeni bir notebook ekliyoruz
          notebookMap.put(idNumber, new Notebook(idNumber, price, stock, discount, screenSize, ram, storage, name, Brand.sortBrand().get(choice - 1)));
          System.out.println("Notebook sisteme başarıyla eklendi..");
      }






    public static boolean isNotebookInList(int idNumber){
        if(notebookMap.containsKey(idNumber)){
            return true;
        }
       return false;
    }
    //Notebook kaldırma metodu.
    public static void removeNotebook(){
        //Kullanıcıdan ID al ve ID var ise kaldır.
        System.out.println("Silmek istediğiniz Notebook için Id numarası giriniz");
        int ıd= sc.nextInt();
        int i=0;
        if(notebookMap.isEmpty()){
            System.out.println("Eklenmiş cihaz bulunamadı");
        } else {
            if(notebookMap.containsKey(ıd)) {
                notebookMap.remove(ıd);
                System.out.println("Notebook silindi");
            }else{
                System.out.println("Ürün id bulunamadı.");
            }

        }


    }
}
