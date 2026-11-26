import java.util.Scanner;

public class kafe04 {
    public static void ubahNama(String nama) {
        nama = "Tamu";
        System.out.println("Di dalam fungsi: " + nama);
    }

    public static void Menu(String nama, boolean isMember, int jam) {
        System.out.println("Selamat datang, " + nama + "!");
        System.out.println("Member: " + (isMember ? "Ya" : "Tidak"));
        System.out.println("Jam kunjung: " + jam);
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String nama = sc.nextLine();

        System.out.print("Apakah member (y/n)? ");
        String jawab = sc.nextLine();
        boolean isMember = jawab.equalsIgnoreCase("y");

        System.out.print("Masukkan jam kunjung (0-23): ");
        int jam = sc.nextInt();

        System.out.println();
        Menu(nama, isMember, jam);
        sc.close();
    }
}