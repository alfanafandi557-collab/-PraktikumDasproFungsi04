import java.util.Scanner;

public class kafe04{
    // ... Menu(String, boolean) dan hitungTotalHargaNoAbsen seperti sebelumnya ...

    private static void Menu(String nama, boolean tampilkanMenu) {
        System.out.println("Selamat datang, " + nama + "!");
        if (tampilkanMenu) {
            System.out.println("Daftar menu tersedia (1-6)");
        }
    }

    private static int hitungTotalHargaNoAbsen(int pilihanMenu, int banyakItem) {
        int[] hargaMenu = {10000, 12000, 15000, 18000, 20000, 25000};
        return hargaMenu[pilihanMenu - 1] * banyakItem;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu("Andi", true);

        int total = 0;
        boolean selesai = false;
        while (!selesai) {
            System.out.print("\nMasukkan nomor menu (1-6): ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Menu tidak tersedia");
                continue;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            int subtotal = hitungTotalHargaNoAbsen(pilihanMenu, banyakItem);
            System.out.println("Subtotal: Rp" + subtotal);
            total += subtotal;

            System.out.print("Pesan menu lain? (y/n): ");
            selesai = !sc.next().equalsIgnoreCase("y");
        }

        System.out.println("\nTotal keseluruhan pesanan: Rp" + total);
    }
}
