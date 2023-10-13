package Patikastore;

import java.util.InputMismatchException;
import java.util.Scanner;


public class PatikaStore {
    private  int idNotebook=1;
    private  int mobilePhone=1;
    private static Brand br=new Brand();
    private static MobilePhoneOperation moperation=new MobilePhoneOperation();
    private static NotebookOperation note=new NotebookOperation();


    private String name;
    static Scanner scanner = new Scanner(System.in);

   private String brandName;

        public static void run () {
            //PatikaStore menü işlemleri

            int choice =1;
            while (choice != 0) {
                System.out.println("PatikaStore Ürün Yönetim Paneli");
                System.out.println("1 - Marka Ekle :");
                System.out.println("2 - Marka Listele:");
                System.out.println("3 - Notebook İşlemleri :");
                System.out.println("4 - Cep Telefonu İşlemleri :");
                System.out.println("0 - Çıkış :");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1: Brand.addBrand();        //Brand sınıfından marka ekleme metodu.

                    break;
                    case 2:
                        Brand.brandListele();        //Brand sınıfından marka listeleme metodu.
                    break;
                    case 3:
                         System.out.println("1-Notebook ekle");
                         System.out.println("2-Notebook sil");
                         System.out.println("3-Notebook Listele");  //Notebook işlemleri
                         System.out.println("4-Geri Gel");
                         int selectedOperation = scanner.nextInt();

                        if(selectedOperation==1) {
                            System.out.println("Sisteme eklenecek notebook sayısı girin.");
                            int total= scanner.nextInt();
                            if(Brand.sortBrand().isEmpty()){
                                System.out.println(" Eklenmiş herhangi bir marka bulunamadı");
                                 } else {

                            for(int i=0; i<total; i++) {

                                Brand.brandListele();
                                System.out.println("Eklemek istediğiniz Notebook markasını seçiniz:");
                                System.out.println("Geri gelmek için 10'u tuşlayın.");
                                int brandChoice = scanner.nextInt();
                                 if (brandChoice == 10) {
                                    total = 0;
                                  } else {

                                    System.out.println("Ürün ID numarası giriniz");
                                    int idNumber = scanner.nextInt();
                                    while (NotebookOperation.isNotebookInList(idNumber)) {
                                        System.out.println("Ürün zaten sisteme ekli yeni bir ID numarası giriniz : ");
                                        idNumber = scanner.nextInt();
                                    }
                                    try {
                                        NotebookOperation.AddNotebook(idNumber, brandChoice); //Notebook ekleme
                                    } catch (InputMismatchException e) {
                                        System.out.println("Yanlış bir seçim yaptınız tekrar deneyin");
                                        choice = 0;
                                        total = 0;
                                    }
                                 }
                               }
                              }
                            }
                        else if(selectedOperation==2){

                            NotebookOperation.removeNotebook();  //Notebook silme

                        }
                        else if(selectedOperation==3){
                            NotebookOperation.NotebookList();   //Notebook Listeleme
                            break;
                        }
                        else{
                            break;
                        }
                    break;
                    case 4:
                        System.out.println("1-Cep Telefonu ekle");
                        System.out.println("2-Cep Telefonu sil");
                        System.out.println("3-Cep Telefonu Listele");  //Cep Telefonu işlemleri
                        System.out.println("4-Geri Gel");
                        selectedOperation = scanner.nextInt();
                        if(selectedOperation==1) {
                            System.out.println("Sisteme eklenecek Cep Telefonu sayısı girin :");
                            int total= scanner.nextInt();
                            if(Brand.sortBrand().isEmpty()){
                                System.out.println(" Eklenmiş herhangi bir marka bulunamadı");
                            }else {
                            for(int i=0; i<total; i++) {

                                Brand.brandListele();
                                    System.out.println("Eklemek istediğiniz Cep Telefonu markasını seçiniz :");

                                    System.out.println("Geri gelmek için 10 tuşlayın.");

                                int brandChoice = scanner.nextInt();
                                    if(brandChoice==10){
                                        total=0;
                                    } else {

                                            System.out.println("Ürün ID numarası giriniz : ");
                                        int idNumber = scanner.nextInt();
                                        while (MobilePhoneOperation.isPhoneInList(idNumber)) {
                                            System.out.println("Ürün zaten sisteme ekli yeni bir ID numarası giriniz : ");
                                            idNumber = scanner.nextInt();
                                        }
                                        try {
                                            MobilePhoneOperation.AddMobilePhone(idNumber, brandChoice); //Notebook ekleme
                                        } catch (InputMismatchException e) {
                                            System.out.println("Yanlış bir seçim yaptınız tekrar deneyin");
                                            choice = 0;
                                            total = 0;
                                        }
                                    }
                                }
                            }

                        }else if(selectedOperation==2){
                            MobilePhoneOperation.removeMobilePhone();   //Notebook silme

                        }
                        else if(selectedOperation==3){
                            MobilePhoneOperation.ListMobilePhone();  //Notebook listeleme
                            break;
                        }
                        else{
                            break;
                        }
                        break;
                }
            }
        }

}
