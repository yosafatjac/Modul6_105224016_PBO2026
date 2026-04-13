//package untuk keteraturan supaya semua class yg berhubungan dengan perusahaan
//(Karyawan, Developer, Manajer) berada dalam satu package yang sama.
package perusahaan;

//Saya menggunakan extends agar dev ini otomatis memiliki semua atribut dan methodnya.
public class Developer extends Karyawan {

   //Atribut khusus untuk Developer, agar tidak perlu ada di superclass Karyawan.
    private String level;       
    private int    jumlahBugFix;

   //Konstruktor, saya gunakan  super() agar karyawan menginisialisasi dan validasi ratingKinerja miliknya
   //sehingga tdk perlu duplikat logika itu.
    public Developer(String idKaryawan, String nama, int tahunMasuk,
                     double gajiPokok, double ratingKinerja,
                     String level, int jumlahBugFix) {
        super(idKaryawan, nama, tahunMasuk, gajiPokok, ratingKinerja);
        this.level        = level;
        this.jumlahBugFix = jumlahBugFix;
    }

   //Getter dan setter untuk atribut khusus Developer agar nilai bisa diakses secara
   //terkontrol dari luar class
    public String getLevel()                      { return level; }
    public void   setLevel(String level)          { this.level = level; }
    public int  getJumlahBugFix()                 { return jumlahBugFix; }
    public void setJumlahBugFix(int jumlahBugFix) { this.jumlahBugFix = jumlahBugFix; }

  
   //override untuk menandai method ini menimpa override superclass,
   //overide disini karena Dev punya komponen gaji tambahan seperti tunjangan level dan bonus bug
   //yang tdk diimiliki karyawan biasa.
    @Override
    public double hitungGajiTotal() {
       //memanggil super agar logika bonus loyalitas, penalti kinerja karyawan, tetap berjalan.
        double totalGaji = super.hitungGajiTotal();

       //Menambahkan tunjangan berdasarkan level Developer, semakin tinggi senior level
       //maka semakin besar tunjanggannya.
        switch (level) {
            case "Junior":
                totalGaji += 0;     
                break;
            case "Mid":
                totalGaji += 1_500_000;
                break;
            case "Senior":
                totalGaji += 3_000_000;
                break;
            default:
               
                break;
        }

        //boonus bug ini diberikan jika rating kinerja 3.0 keatas, agar mendorong developer untuk memperbaiki bug dengan baik.
        if (getRatingKinerja() >= 3.0) {
            totalGaji += jumlahBugFix * 50_000;
        }
        //jika rating < 3.0, bonus bug hangus dan tdk akan dihitung.

        return totalGaji;
    }

   //overide ini supaya tampilan Developer juga menampilkan level dan jumlahbugFix
   //yang tidak ada di karyawan biasa, tanpa lagi panggil super.displayInfo()
   //agar seluruh tampilan lebih terkontrol.
    @Override
    public void displayInfo() {
        
        System.out.println("=============================================");
        System.out.println("Tipe      : Developer");
        System.out.println("ID        : " + getIdKaryawan());
        System.out.println("Nama      : " + getNama());
        System.out.println("Thn Masuk : " + getTahunMasuk());
        System.out.printf ("Rating    : %.1f%n", getRatingKinerja());
        System.out.printf ("Gaji Pokok: Rp %,.0f%n", getGajiPokok());
        System.out.println("Level     : " + level);
        System.out.println("Bug Fix   : " + jumlahBugFix);
    }
}