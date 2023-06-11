import java.util.ArrayList;
import java.util.Scanner;

class DataMahasiswa {

    private static ArrayList<Mahasiswa> mhs = new ArrayList<>();

    public static ArrayList<Mahasiswa> getMahasiswaList(){
        return mhs;
    }

    public static ArrayList<Mahasiswa> tambahMahasiswa(Mahasiswa mahasiswa){
        mhs.add(mahasiswa);
        return mhs;
    }

    public static void tampilSemuaData(){
        int i = 1;
        for (Mahasiswa m : mhs) {
            System.out.println("==== Tampilan Data Mahasiswa " + i + " Filkom UB ====");
            System.out.println("Nama Mahasiswa  : " + m.getNama());
            System.out.println("Jurusan         : " + m.getJurusan());
            if (m.getStatus()) {
                System.out.println("Status          : Menikah");
            } else {
                System.out.println("Status          : Lajang");
            }
            i++;
        }
    }

    public static void cariMahasiswa(String nama){
        boolean found = false;
        for (Mahasiswa m : mhs) {
            if (m.getNama().equals(nama)) {
                System.out.println("Data mahasiswa atas nama " + nama + " ditemukan");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Data mahasiswa atas nama " + nama + " tidak ditemukan");
        }
    }

    public static void tampilMahasiswa(Mahasiswa mahasiswa){
        System.out.println("Nama Mahasiswa  : " + mahasiswa.getNama());
        System.out.println("Jurusan         : " + mahasiswa.getJurusan());
        if (mahasiswa.getStatus()) {
            System.out.println("Status          : Menikah");
        } else {
            System.out.println("Status          : Lajang");
        }


    }

    public static void updateMahasiswa(Mahasiswa mahasiswa, String nama, String jurusan, boolean status){
        for (int i = 0; i < mhs.size(); i++) {
            if (mhs.get(i).equals(mahasiswa)) {
                mhs.get(i).setNama(nama);
                mhs.get(i).setJurusan(jurusan);
                mhs.get(i).setStatus(status);

            }
        }
    }
}
