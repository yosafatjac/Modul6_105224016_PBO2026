
//Saya mengimport class Karyawan, Developer, dan Manajer dari package perusahaan
//agar diakai di class Main tanpa mendefinisikan ulang class tersebut.
import perusahaan.Karyawan;
import perusahaan.Developer;
import perusahaan.Manajer;

//Arraylist harus di import karena package java.util tdk otomatis di import seperti string.
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Disini saya membuat objek-objek karyawan dengan berbagai tipe Karyaawa, Developer, dan Manajer.
        ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

       //Saya menambahkan beberapa karyawan dengan berbagai atribut, termasuk nama, tahun masuk, gaji pokok, rating kinerja, level untuk developer
        daftarKaryawan.add(new Karyawan(
                "PK92083", "Yosafat Jacobus", 2020, 5_000_000, 2.0));

        daftarKaryawan.add(new Developer(
                "PD94320", "Dwi Setiawan", 2018, 7_000_000, 4.0, "Senior", 20));

        daftarKaryawan.add(new Developer(
                "PD98426", "Pradana Akbar Razan", 2024, 6_000_000, 2.8, "Mid", 15));

        daftarKaryawan.add(new Manajer(
                "PM01859", "Michael Alexander Newton", 2015, 10_000_000, 4.8, "IT", 10));

        daftarKaryawan.add(new Manajer(
                "PM09523", "Erlangga Aditya Permana", 2025, 8_000_000, 3.5, "HR", 3));

        //untuk variabel akumulasi, disiapkan di luar loop supaya nilai terus terjumlah dari setiap iterasi 
        //dan dipakai di akhir program.
        double totalAnggaranGaji    = 0;        
        double gajiBersihTertinggi  = 0;        
        String namaGajiTertinggi    = "";       
        double totalRating          = 0;        

                
       //Ini adalah inti dari polimorfisme, dimana kita bisa menyimpan 
       //objek dari subclass (Developer, Manajer) dalam list yang bertipe superclass (Karyawan).
        for (Karyawan k : daftarKaryawan) {
            k.displayInfo();    

            double gajiTotal = k.hitungGajiTotal();
            System.out.printf("Total Gaji Bulan Ini: Rp %,.0f%n", gajiTotal);
            System.out.println();

                
            totalAnggaranGaji += gajiTotal;

            //ini untuk mengakumulasi total rating kinerja semua karyawan, agar nanti bisa menghitung rata-rata rating kinerjanya tersebut.    
            totalRating += k.getRatingKinerja();
            //cek apakah gaji total karyawan lebih tinggi dari gaji bersih tertinggi
            //jika ya, update gaji bersih dan nama karyawan yang paling tinggi
            if (gajiTotal > gajiBersihTertinggi) {
                gajiBersihTertinggi = gajiTotal;
                namaGajiTertinggi   = k.getNama();
            }
        }
        //Terakhir, saya membuat tampilan ringkasan yang menampilkan total, anggaran gaji, nama karyawanan 
        //dengan gaji tertinggi, dan untuk rata-rata rating kinerja.

        System.out.println("=============================================");
        System.out.println("         RINGKASAN PERUSAHAAN A");
        System.out.println("=============================================");
        System.out.printf("Total Anggaran Gaji   : Rp %,.0f%n", totalAnggaranGaji);
        System.out.println("Highest Earner        : " + namaGajiTertinggi
                + String.format(" (Rp %,.0f)", gajiBersihTertinggi));
        System.out.printf("Rata-rata Rating      : %.2f%n",
                totalRating / daftarKaryawan.size());
    }
}