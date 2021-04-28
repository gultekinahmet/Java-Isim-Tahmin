package com.company;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.Random;

public class KelimeTahmin {

    // tahmin edilecek char tipinde girdinin alfabeden herhangi bir harf olup olmadığının kontrolünü regex aracılığıyla
    //  ve diğer kontrollerle yapan fonksiyon
    public static boolean sadeceHarfMi(@NotNull String str)
    {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z]*$")));
    }

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        String[] isimler = new String[]{"mehmet","ahmet","ayşe",
                "selim","tunç","evren","zeynep","buse","damla","atilla"};


        // İsimlerin rastgele bir şekilde seçilebilmesi için random sınıfı kullanılmıştır.
        Random rand = new Random();
        int rand_sayi = rand.nextInt(10);
        String tahminEdilecekKelime = isimler[rand_sayi];
        System.out.println(tahminEdilecekKelime);

        // Tahminler yapıldığında varsayılan olarak gelecek çizgilerin tanımlandığı dizidir,
        // sonrasında tahminler yapıldıkça bu dizi değişiklik gösterecek.
        char [] harfler= new char[tahminEdilecekKelime.length()];
        for (int i = 0; i < tahminEdilecekKelime.length(); i++) {
            harfler[i] = '_';
        }

        // Kullanıcı girdisinin kontrollerini sağlayabilmek için char dizisi tanımlanmıştır.
        char[] tahminKelimeDizi;
        tahminKelimeDizi = tahminEdilecekKelime.toCharArray();

        int tahminHakki = 5;
        char kullaniciGirdisi;

        while(tahminHakki != 0) {
                System.out.println("Kalan tahmin hakkınız " + tahminHakki +
                        "\nHarf giriniz : ");

                for(char harf: harfler) {
                    System.out.print(harf +" ");
                }

                kullaniciGirdisi = sc.next().charAt(0);
                String kullaniciGirdisiKontrol = String.valueOf(kullaniciGirdisi);
                boolean girdiKontrolDogrumu = sadeceHarfMi(kullaniciGirdisiKontrol);
                tahminHakki--;

                if(girdiKontrolDogrumu) {
                    // Kullanıcı girdisinin tahmin edilecek kelime dizisindeki herhangi bir karaktere eşit olup olmadığının kontrolü yapılır eşit ise harfler
                    // dizisindeki çizgilerin yerini alacak şekilde atama yapılır.
                    for(int j=0; j<tahminEdilecekKelime.length(); j++) {
                        if(kullaniciGirdisi == tahminKelimeDizi[j]) {
                            System.out.println("Tebrikler " + kullaniciGirdisi + " harfi doğru");
                            harfler[j] = kullaniciGirdisi;
                        }
                    }

                    // burada char dizisinin(kullanıcının girişlerinin atandığı) dönüşümünü string yaparak kontrol mekanizmasını sağlayıp,
                    // oyuncunun tahmin ettiği harflerin tamamıyla kelime ile eşleşip eşleşmediği kontrol ediliyor
                    if(String.valueOf(harfler).equals(tahminEdilecekKelime)) {
                        System.out.println("Cevabınız : " + String.valueOf(harfler));
                        System.out.println("Tebrikler.... Kazandınız");
                        break;
                    }
                    else if(tahminHakki == 0) {
                        System.out.println("Tahmin hakkınız tükenmiştir.\n " +
                                "Oyunu kaybettiniz");
                        System.out.println("Doğru cevap " + tahminEdilecekKelime + " olacaktı");
                    }

                } else {
                    System.out.println("Lütfen harf girdiğinizden emin olun ve tekrar deneyin");
                }

        }

    }

}
