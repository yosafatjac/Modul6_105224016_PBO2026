package rental;
import rental.Mobil;
import rental.Motor;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n=== Daftar Kendaraan Rental ===\n");

        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

        daftarKendaraan.add(new Mobil("B 1 QOP", "Mercedes AMG G63 BRABUS", 2026,
                            20_000_000, 5));

        daftarKendaraan.add(new Mobil("B 2 TEW", "Cadillac Escalade ESV", 2020,
                            10_000_000, 7));

        daftarKendaraan.add(new Motor("B 32 S", "Ducati Panigale V4R", 2021,
                            5_500_000, 998));

        daftarKendaraan.add(new Motor("B 4 GLW", "Suzuki Hayabusa", 2012,
                            3_000_000, 1340));

        int hariSewa = 5;

        for (Kendaraan k : daftarKendaraan) {
            k.displayInfo();
            double totalBiaya = k.hitungHargaSewa(hariSewa);
            System.out.printf(new Locale("id", "ID"), "  Total Biaya Sewa selama %d Hari: Rp%,.0f%n", hariSewa, totalBiaya);
            System.out.println("----------------------------------");
           
        }
    }
}