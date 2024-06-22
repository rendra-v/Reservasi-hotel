/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lastprojectpbo;
/**
 *
 * @author Bagus
 */
public class UserPerson extends javax.swing.JFrame{
    protected String nama;
    protected String alamat;
    protected String notel;

    public UserPerson(String nama, String alamat, String notel) {
        this.nama = nama;
        this.alamat = alamat;
        this.notel = notel;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNotel() {
        return notel;
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("No. Telp: " + notel);
    }
}
