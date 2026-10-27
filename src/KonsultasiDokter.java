/**
 * Inheritance: KonsultasiDokter extends the abstract LayananMedis class.
 * Interface implementation: it also implements DapatDijadwalkan.
 */
public class KonsultasiDokter extends LayananMedis implements DapatDijadwalkan {
    private String namaDokter;
    private double biayaAdministrasi;

    public KonsultasiDokter(String namaDokter, double biayaAdministrasi) {
        super("Konsultasi Dokter", 150000);
        this.namaDokter = namaDokter;
        this.biayaAdministrasi = biayaAdministrasi;
    }

    @Override
    public double hitungBiaya() {
        return biayaDasar + biayaAdministrasi;
    }

    @Override
    public String getJenisLayanan() {
        return "Konsultasi";
    }

    @Override
    public void jadwalkan(String namaPasien, String waktu) {
        System.out.println("Booking konsultasi berhasil: " + namaPasien
                + " dengan " + namaDokter + " pada " + waktu + ".");
    }
}
