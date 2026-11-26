import java.util.Scanner;

public class BankSampah04 {

    static Scanner input = new Scanner(System.in);

    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];

        for (int i = 0; i < setoran.length; i++) {
            System.out.print(
                "Masukkan setoran nasabah ke-" + (i + 1) + " (kg): "
            );

            setoran[i] = input.nextDouble();
        }

        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        System.out.println("\n===== DATA SETORAN =====");

        for (int i = 0; i < setoran.length; i++) {
            System.out.println(
                "Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg"
            );
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;

        for (double berat : setoran) {
            total += berat;
        }

        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int indeksTerbesar = 0;

        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeksTerbesar]) {
                indeksTerbesar = i;
            }
        }

        return indeksTerbesar;
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah nasabah: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Jumlah nasabah harus lebih dari 0.");
            input.close();
            return;
        }

        double[] setoran = inputSetoran(n);

        tampilSetoran(setoran);

        System.out.println(
            "\nTotal setoran: " + totalSetoran(setoran) + " kg"
        );

        System.out.println("\n===== SALDO NASABAH =====");

        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], 3000);

            System.out.println(
                "Nasabah ke-" + (i + 1) + ": Rp " + saldo
            );
        }

        int terbesar = nasabahTerbanyak(setoran);

        System.out.println(
            "\nNasabah dengan setoran terbesar: Nasabah ke-"
            + (terbesar + 1)
        );

        System.out.println(
            "Berat setoran: " + setoran[terbesar] + " kg"
        );

        input.close();
    }
}