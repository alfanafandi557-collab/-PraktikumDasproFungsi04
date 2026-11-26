import java.util.Scanner;

public class Kafe04 {
    // ... Menu(String, boolean) dan hitungTotalHargaNoAbsen seperti sebelumnya ...

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
