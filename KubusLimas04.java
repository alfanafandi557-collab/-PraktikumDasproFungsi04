import java.util.Scanner;

public class KubusLimas04 {

    static int luasPersegi(int s) {
        return s * s;
    }

    static int volumeKubus(int s) {
        return s * s * s;
    }

    static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    static double volumeLimasPersegi(int s, int t) {
        return luasPersegi(s) * (double) t / 3;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pilihan;

        do {
            System.out.println("\n===== MENU BANGUN RUANG =====");
            System.out.println("1. Luas persegi");
            System.out.println("2. Volume kubus");
            System.out.println("3. Luas permukaan kubus");
            System.out.println("4. Volume limas persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();

            if (pilihan >= 1 && pilihan <= 4) {
                System.out.print("Masukkan panjang sisi: ");
                int s = input.nextInt();

                if (pilihan == 1) {
                    System.out.println(
                        "Luas persegi: " + luasPersegi(s)
                    );

                } else if (pilihan == 2) {
                    System.out.println(
                        "Volume kubus: " + volumeKubus(s)
                    );

                } else if (pilihan == 3) {
                    System.out.println(
                        "Luas permukaan kubus: "
                        + luasPermukaanKubus(s)
                    );

                } else {
                    System.out.print("Masukkan tinggi limas: ");
                    int t = input.nextInt();

                    System.out.println(
                        "Volume limas: " + volumeLimasPersegi(s, t)
                    );
                }

            } else if (pilihan != 0) {
                System.out.println("Menu tidak tersedia");
            }

        } while (pilihan != 0);

        System.out.println("Program selesai.");
        input.close();
    }
}