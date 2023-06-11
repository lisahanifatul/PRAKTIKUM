import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DataMahasiswa.tambahMahasiswa(new Mahasiswa("Denar Abidin", "Pendidikan Teknologi Informasi", false));
        DataMahasiswa.tambahMahasiswa(new Mahasiswa("Grenda Jamaludin", "Ilmu Komputer", true));
        DataMahasiswa.tambahMahasiswa(new Mahasiswa("Aisyah Putri", "Sistem Informasi", false)); // contoh modifikasi data tambah mahasiswa

        Scanner input = new Scanner(System.in);

        int pilihan = 0;
        do {
            System.out.println("\nMenu : ");
            System.out.println("1. Lihat Data Seluruh Mahasiswa Filkom UB");
            System.out.println("2. Cari Data Mahasiswa Filkom UB");
            System.out.println("3. Update Data Mahasiswa Filkom UB");
            System.out.println("4. Keluar");
            System.out.print("Pilihan anda: ");
            pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.println("=== Tampilan Semua Data Mahasiswa Filkom UB ===");
                    DataMahasiswa.tampilSemuaData();
                    break;
                case 2:
                    System.out.print("Masukkan nama mahasiswa yang ingin dicari: ");
                    String namaMahasiswa = input.nextLine();
                    DataMahasiswa.cariMahasiswa(namaMahasiswa);
                    break;
                case 3:
                    System.out.print("Masukkan nama mahasiswa yang ingin diupdate datanya: ");
                    String namaMahasiswaUpdate = input.nextLine();
                    boolean found = false;
                    for (Mahasiswa m : DataMahasiswa.getMahasiswaList()) {
                        if (m.getNama().equals(namaMahasiswaUpdate)) {
                            System.out.println("=== Tampilan Data Mahasiswa Sebelum Diupdate ===");
                            DataMahasiswa.tampilMahasiswa(m);
                            System.out.print("Masukkan nama mahasiswa baru: ");
                            String namaBaru = input.nextLine();
                            System.out.print("Masukkan jurusan mahasiswa baru: ");
                            String jurusanBaru = input.nextLine();
                            System.out.print("Masukkan status mahasiswa baru (true = menikah, false = lajang): ");
                            boolean statusBaru = input.nextBoolean();
                            input.nextLine(); // membersihkan buffer
                            DataMahasiswa.updateMahasiswa(m, namaBaru, jurusanBaru, statusBaru);
                            System.out.println("\n=== Tampilan Data Mahasiswa Setelah Diupdate ===");
                            DataMahasiswa.tampilMahasiswa(m);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Data mahasiswa atas nama " + namaMahasiswaUpdate + " tidak ditemukan");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silahkan coba lagi.");
                    break;
            }

        } while (pilihan != 4);
    }
}
