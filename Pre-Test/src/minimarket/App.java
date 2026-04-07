package minimarket;
public class App {
    public static void main(String[] args) {
      
        MakananRingan snack = new MakananRingan("Lays", 12500.0, "Rumput Laut");
        
        System.out.println("=== Detail Produk Minimarket ===");
        
        snack.tampilkanDetail(); 
    }
}