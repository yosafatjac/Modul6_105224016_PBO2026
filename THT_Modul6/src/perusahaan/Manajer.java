//package untuk keteraturan supaya semua class yg berhubungan dengan perusahaan
//(Karyawan, Developer, Manajer) berada dalam satu package yang sama.
package perusahaan;

//Extend agar manajer tdk perlu mendefinisikan ulang atribut seperti nama, gaji dll.
//cukup tambahkan yg beda
public class Manajer extends Karyawan {

   //Ini atribut khusus untuk Manajer, agar tidak perlu ada di superclass Karyawan.
    private String divisi;
    private int    jumlahAnggotaTim;

   //super() untuk karyawan mengurus inisialisasi atribut sendiri termasuk validasi ratingKinerja.
    public Manajer(String idKaryawan, String nama, int tahunMasuk,
                   double gajiPokok, double ratingKinerja,
                   String divisi, int jumlahAnggotaTim) {
        super(idKaryawan, nama, tahunMasuk, gajiPokok, ratingKinerja);
        this.divisi            = divisi;
        this.jumlahAnggotaTim  = jumlahAnggotaTim;
    }

    //Menggunakan getter dan setter untuk atribut khusus Manajer agar nilai bisa diakses secara
    //terkontrol/aman dari luar class
    public String getDivisi()          { return divisi; }
    public void   setDivisi(String divisi) { this.divisi = divisi; }

    public int  getJumlahAnggotaTim()        { return jumlahAnggotaTim; }
    public void setJumlahAnggotaTim(int jumlahAnggotaTim) {
        this.jumlahAnggotaTim = jumlahAnggotaTim;
    }

    
   //Override untuk menandai method ini menimpa override superclass,
    //overide disini karena Manajer punya komponen gaji tambahan seperti 
    //tunjangan manajerial + bonus kinerja yg tdk dimiliki karyawan biasa maupun developer.
    @Override
    public double hitungGajiTotal() {
        //panggil super.hitungGajiTotal() agar logika bonus loyalitas, penalti kinerja karyawan tetap berjalan.
        double totalGaji = super.hitungGajiTotal();

        //Tunjangan manajerial 300.000 per anggota tim diberikan sebagai kompensasi tanggung jawab
        //Manajer memimpin tim.
        double tunjanganManajerial = 300_000 * jumlahAnggotaTim;
        totalGaji += tunjanganManajerial;

        //Untuk bonus kinerja, jika rating kinerja manajer lebih dari 4.5,
        //maka total gaji bulan ini akan ditambah 15% sebagai apresiasi atas kinerja luar biasa.
        if (getRatingKinerja() > 4.5) {
            totalGaji *= 1.15;
        }

        return totalGaji;
    }

    //Override ini supaya tampilan Manajer juga menampilkan divisi dan jumlah anggota tim
    // yang tidak ada di kelas lain, jadi saya gunakan (getNama(), dll)
    // karena atribut superclass sudah private dan tdk bisa diakses langsung.
    @Override
    public void displayInfo() {
        System.out.println("=============================================");
        System.out.println("Tipe      : Manajer");
        System.out.println("ID        : " + getIdKaryawan());
        System.out.println("Nama      : " + getNama());
        System.out.println("Thn Masuk : " + getTahunMasuk());
        System.out.printf ("Rating    : %.1f%n", getRatingKinerja());
        System.out.printf ("Gaji Pokok: Rp %,.0f%n", getGajiPokok());
        System.out.println("Divisi    : " + divisi);
        System.out.println("Jml Tim   : " + jumlahAnggotaTim + " orang");
    }
}