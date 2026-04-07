package rental;
import java.util.Locale; 

public class Kendaraan {
    protected String nomorPolisi;
    protected String merk;
    protected int tahunProduksi;
    protected double hargaSewaDasar;

    public Kendaraan(String nomorPolisi, String merk, int tahunProduksi, double hargaSewaDasar) {
        this.nomorPolisi  = nomorPolisi;
        this.merk         = merk;
        this.tahunProduksi = tahunProduksi;
        this.hargaSewaDasar = hargaSewaDasar;
    }

    public void displayInfo() {
        System.out.println("  Nomor Polisi  : " + nomorPolisi);
        System.out.println("  Merk          : " + merk);
        System.out.println("  Tahun Produksi: " + tahunProduksi);
        
        System.out.printf(new Locale("id", "ID"), "  Harga Sewa    : Rp%,.0f / hari%n", hargaSewaDasar);
    }

    public double hitungHargaSewa(int hari) {
        double total = hargaSewaDasar * hari;
        if (tahunProduksi < 2015) {
            total = total * 0.90;
            System.out.println("  [Diskon 10% kendaraan lama diterapkan]");
        }
        return total;
    }
}