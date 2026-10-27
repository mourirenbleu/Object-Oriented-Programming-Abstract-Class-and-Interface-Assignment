/**
 * Another concrete subclass. It applies a different pricing rule:
 * the fee depends on the number of therapy sessions.
 */
public class Fisioterapi extends LayananMedis implements DapatDijadwalkan {
    private int jumlahSesi;

    public Fisioterapi(int jumlahSesi) {
        super("Fisioterapi", 100000);
        if (jumlahSesi < 1) {
            throw new IllegalArgumentException("Jumlah sesi minimal 1.");
        }
        this.jumlahSesi = jumlahSesi;
    }

    @Override
    public double hitungBiaya() {
        return biayaDasar * jumlahSesi;
    }

    @Override
    public String getJenisLayanan() {
        return "Fisioterapi";
    }

    @Override
    public void jadwalkan(String namaPasien, String waktu) {
        System.out.println("Booking fisioterapi berhasil: " + namaPasien
                + ", " + jumlahSesi + " sesi, mulai " + waktu + ".");
    }
}
