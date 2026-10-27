/**
 * Abstract class: defines shared data and behavior for all clinic services.
 * It cannot be instantiated directly. Concrete services must implement
 * hitungBiaya() and getJenisLayanan().
 */
public abstract class LayananMedis {
    protected String namaLayanan;
    protected double biayaDasar;

    public LayananMedis(String namaLayanan, double biayaDasar) {
        this.namaLayanan = namaLayanan;
        this.biayaDasar = biayaDasar;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public double getBiayaDasar() {
        return biayaDasar;
    }

    // Abstract methods: each type of service defines its own behavior.
    public abstract double hitungBiaya();
    public abstract String getJenisLayanan();
}
