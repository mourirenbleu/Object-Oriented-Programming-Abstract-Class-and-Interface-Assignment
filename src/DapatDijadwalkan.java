/**
 * Interface: a capability/contract, not a shared parent class.
 * Any service implementing this interface promises to support booking.
 */
public interface DapatDijadwalkan {
    void jadwalkan(String namaPasien, String waktu);
}
