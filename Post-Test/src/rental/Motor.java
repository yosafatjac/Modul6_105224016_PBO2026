package rental;

public class Motor extends Kendaraan {
    private int kapasitasMesin; // dalam CC

    public Motor(String nomorPolisi, String merk, int tahunProduksi,
                 double hargaSewaDasar, int kapasitasMesin) {
        super(nomorPolisi, merk, tahunProduksi, hargaSewaDasar);
        this.kapasitasMesin = kapasitasMesin;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Tipe          : Motor");
        System.out.println("  Kapasitas Mesin: " + kapasitasMesin + " CC");
    }

    @Override
    public double hitungHargaSewa(int hari) {
        double total = super.hitungHargaSewa(hari);

        if (kapasitasMesin >= 250) {
            double pajakMewah = 25_000 * hari;
            total += pajakMewah;
            System.out.printf("  [Pajak barang mewah (CC >= 250): Rp%.0f (Rp25.000 x %d hari)]%n",
                              pajakMewah, hari);
        }

        return total;
    }
}