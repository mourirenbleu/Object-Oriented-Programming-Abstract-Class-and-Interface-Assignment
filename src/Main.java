import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Console demo for a small clinic service and appointment system.
 * Demonstrates abstract class, interface, inheritance, and polymorphism.
 */
public class Main {
    private static final NumberFormat RUPIAH =
            NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Polymorphism: one list of the parent type stores different subclasses.
        ArrayList<LayananMedis> daftarLayanan = new ArrayList<>();
        daftarLayanan.add(new KonsultasiDokter("dr. Aulia", 25000));
        daftarLayanan.add(new Fisioterapi(3));

        int pilihan;
        do {
            System.out.println("\n=== SISTEM BOOKING KLINIK ===");
            System.out.println("1. Lihat layanan dan biaya");
            System.out.println("2. Booking layanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            while (!input.hasNextInt()) {
                System.out.print("Masukkan angka menu: ");
                input.next();
            }
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR LAYANAN ---");
                    for (int i = 0; i < daftarLayanan.size(); i++) {
                        LayananMedis layanan = daftarLayanan.get(i);
                        // Runtime polymorphism: Java calls each subclass's
                        // own implementation of hitungBiaya().
                        System.out.println((i + 1) + ". "
                                + layanan.getNamaLayanan()
                                + " (" + layanan.getJenisLayanan() + ")");
                        System.out.println("   Biaya: "
                                + RUPIAH.format(layanan.hitungBiaya()));
                    }
                    break;

                case 2:
                    System.out.println("\nPilih layanan:");
                    for (int i = 0; i < daftarLayanan.size(); i++) {
                        System.out.println((i + 1) + ". "
                                + daftarLayanan.get(i).getNamaLayanan());
                    }
                    System.out.print("Nomor layanan: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Pilihan harus berupa angka.");
                        input.nextLine();
                        break;
                    }
                    int nomor = input.nextInt();
                    input.nextLine();

                    if (nomor < 1 || nomor > daftarLayanan.size()) {
                        System.out.println("Layanan tidak tersedia.");
                        break;
                    }

                    System.out.print("Nama pasien: ");
                    String pasien = input.nextLine().trim();
                    System.out.print("Tanggal dan waktu (contoh: 28-10-2026 09:00): ");
                    String waktu = input.nextLine().trim();

                    if (pasien.isEmpty() || waktu.isEmpty()) {
                        System.out.println("Nama pasien dan jadwal wajib diisi.");
                        break;
                    }

                    LayananMedis layananDipilih = daftarLayanan.get(nomor - 1);
                    // Interface polymorphism: call through the capability type.
                    if (layananDipilih instanceof DapatDijadwalkan) {
                        DapatDijadwalkan jadwal =
                                (DapatDijadwalkan) layananDipilih;
                        jadwal.jadwalkan(pasien, waktu);
                        System.out.println("Estimasi biaya: "
                                + RUPIAH.format(layananDipilih.hitungBiaya()));
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 0);

        input.close();
    }
}
