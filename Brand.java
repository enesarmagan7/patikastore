package Patikastore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class Brand {
    private String brandName;


    static Scanner scanner=new Scanner(System.in);
    private int brandId;
    private static ArrayList<Brand> brands =new ArrayList<>();



    private static Comparator<Brand> brandComparator = new Comparator<Brand>() {
        @Override
        public int compare(Brand b, Brand a) {
            return b.getBrandName().compareTo(a.getBrandName());
        }
    };
    public Brand(){

    }
    public Brand(String brandName, int brandId) {
        this.brandName = brandName;

        this.brandId = brandId;
    }

    public static ArrayList<Brand> getBrands() {
        return brands;
    }

    public static void setBrands(ArrayList<Brand> brands) {
        Brand.brands = brands;
    }

    public static Comparator<Brand> getBrandComparator() {
        return brandComparator;
    }

    public static void setBrandComparator(Comparator<Brand> brandComparator) {
        Brand.brandComparator = brandComparator;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }



    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
    public static void addBrand(){
        boolean isBrandExist=false;
        boolean wrongChoice=false;
        System.out.println("1- Samsung");
        System.out.println("2- Lenovo");
        System.out.println("3- Apple");
        System.out.println("4- Huawei");
        System.out.println("5- Casper");
        System.out.println("6- Asus");
        System.out.println("7- HP");
        System.out.println("8- Xiaomi");
        System.out.println("9- Monster");
        System.out.println("Eklemek istediğiniz marka seçin:");
        String brandName="";
        int secim = scanner.nextInt();

        switch (secim) {
            case 1:
                brandName="Samsung";
                break;
            case 2:
                brandName="Lenovo";

                break;
            case 3:
                brandName="Apple";
                break;

            case 4:
                brandName="Huwaei";
                break;
            case 5:
                brandName="Casper";
                break;
            case 6:
                brandName="Asus";
                break;
            case 7:
                brandName="HP";
                break;
            case 8:
                brandName="Xiaomi";
                break;
            case 9:
                brandName="Monster";
                break;
            default:
                System.out.println("Yanlış bir secim yaptınız.");
                wrongChoice=true;
                break;
        }
        for(Brand brand: brands){
            if(brand.getBrandName().equals(brandName)) {
                isBrandExist = true;
                break;
            }
        }
        if (isBrandExist) {
            System.out.println("Marka zaten ekli.");
            System.out.println("----------------");
        } else if(!wrongChoice) {
            brands.add(new Brand(brandName, secim));
            System.out.println("Marka Eklendi.");
        }

    }
    public static List<Brand> sortBrand(){


        brands.sort(brandComparator);
        return brands;
    }
    public static void brandListele(){
        if(sortBrand().isEmpty()){
            System.out.println(" Eklenmiş herhangi bir marka bulunamadı");
        }
            int i = 0;
            for (Brand a : sortBrand()) {
                System.out.println(i + 1 + "-" + a.getBrandName());
                i++;
            }

    }



}
