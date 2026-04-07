package rental;

public class Mobil extends Kendaraan {
    private int kapasitasPenumpang;

    public Mobil(String nomorPolisi, String merk, int tahunProduksi,
                 double hargaSewaDasar, int kapasitasPenumpang) {
        super(nomorPolisi, merk, tahunProduksi, hargaSewaDasar);
        this.kapasitasPenumpang = kapasitasPenumpang;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Tipe          : Mobil");
        System.out.println("  Kap. Penumpang: " + kapasitasPenumpang + " orang");
    }

    @Override
    public double hitungHargaSewa(int hari) {
        double total = super.hitungHargaSewa(hari);

        double asuransi = 50_000 * hari;
        total += asuransi;
        System.out.printf("  [Asuransi wajib: Rp%.0f (Rp50.000 x %d hari)]%n", asuransi, hari);

        if (kapasitasPenumpang > 5) {
            total += 50_000;
            System.out.println("  [Biaya kebersihan (kapasitas > 5): Rp50.000]");
        }

        return total;
    }
}