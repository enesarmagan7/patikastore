package Patikastore;

import java.util.Comparator;

public class Helper {
    //Projede Comparator 'u sık kullanacağımızdan yardımcı bir sınıf açıyoruz.
    private static Comparator<Brand> brandComparator = new Comparator<Brand>() {
        //Marka sınıfı içinde marka isimine göre sıralama yapmak için
        // Comparator sınıfı oluşturuyoruz.
        @Override
        public int compare(Brand b, Brand a) {
            return b.getBrandName().compareTo(a.getBrandName());
        }
    };

    private static Comparator<Product> ıdComparator = new Comparator<Product>() {
        // Telefon ve Notebookları id numarasına göre sıralama yapmak için
        // Comparator nesnesi oluşturuyoruz. .
        @Override
        public int compare(Product b,Product a) {
            return b.getId()-a.getId();
        }

    };
    private static  Comparator<Product> productComparator = new Comparator<Product>() {
        //Telefon ve Notebookları marka isimine göre sıralamasını yapmak için
        //Comparator nesnesi oluşturuyoruz.
        @Override
        public int compare(Product b, Product a) {
            return b.getBrand().getBrandName().compareTo(a.getBrand().getBrandName());
        }
    };

    public static Comparator<Brand> getBrandComparator() {
        return brandComparator;
    }

    public static void setBrandComparator(Comparator<Brand> brandComparator) {
        Helper.brandComparator = brandComparator;
    }

    public static Comparator<Product> getIdComparator() {
        return ıdComparator;
    }

    public static void setIdComparator(Comparator<Product> ıdComparator) {
        Helper.ıdComparator = ıdComparator;
    }

    public static Comparator<Product> getProductComparator() {
        return productComparator;
    }

    public static void setProductComparator(Comparator<Product> productComparator) {
        Helper.productComparator = productComparator;
    }
}
