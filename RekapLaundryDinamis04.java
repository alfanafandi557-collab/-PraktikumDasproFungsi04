import java.util.Scanner;

public class RekapLaundryDinamis04 {

    static Scanner input = new Scanner(System.in);

    static void tampilData(
        String[] nama, int[][] data
    ) {
        System.out.println("\n===== REKAP LAUNDRY =====");

        System.out.printf("%-18s", "Layanan");

        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%10s", "Hari ke-" + (j + 1));
        }

        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-18s", nama[i]);

            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%10d", data[i][j]);
            }

            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;

        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }

        return total;
    }

    static int hariTersibuk(int[][] data) {
        int indeksTerbesar = 0;

        for (int j = 1; j < data[0].length; j++) {
            int totalHari = 0;
            int totalTerbesar = 0;

            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
                totalTerbesar += data[i][indeksTerbesar];
            }

            if (totalHari > totalTerbesar) {
                indeksTerbesar = j;
            }
        }

        return indeksTerbesar;
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = input.nextInt();

        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = input.nextInt();

        if (jumlahLayanan <= 0 || jumlahHari <= 0) {
            System.out.println("Jumlah layanan dan hari harus lebih dari 0.");
            input.close();
            return;
        }

        input.nextLine();

        String[] nama = new String[jumlahLayanan];
        int[] harga = new int[jumlahLayanan];

        int[][] data = new int[jumlahLayanan][jumlahHari];

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            nama[i] = input.nextLine();

            System.out.print("Harga per kg: ");
            harga[i] = input.nextInt();
            input.nextLine();
        }
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println("\n" + nama[i]);

            for (int j = 0; j < jumlahHari; j++) {
                System.out.print(
                    "Berat cucian Hari ke-" + (j + 1) + ": "
                );

                data[i][j] = input.nextInt();
            }
        }

        tampilData(nama, data);

        System.out.println("\n===== TOTAL PER LAYANAN =====");

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println(
                nama[i] + ": " + totalPerLayanan(data, i) + " kg"
            );
        }

        int indeksTerbesar = 0;

        for (int i = 1; i < jumlahLayanan; i++) {
            if (totalPerLayanan(data, i)
                > totalPerLayanan(data, indeksTerbesar)) {

                indeksTerbesar = i;
            }
        }

        System.out.println(
            "\nLayanan tertinggi: " + nama[indeksTerbesar]
        );

        System.out.println(
            "Total: " + totalPerLayanan(data, indeksTerbesar) + " kg"
        );

        int hari = hariTersibuk(data);

        System.out.println(
            "\nHari tersibuk: Hari ke-" + (hari + 1)
        );

        double totalPendapatan = 0;

        System.out.println("\n===== PENDAPATAN =====");

        for (int i = 0; i < jumlahLayanan; i++) {
            double pendapatan = totalPerLayanan(data, i) * harga[i];

            System.out.println(
                nama[i] + ": Rp " + pendapatan
            );

            totalPendapatan += pendapatan;
        }

        System.out.println(
            "Total pendapatan: Rp " + totalPendapatan
        );

        input.close();
    }
}