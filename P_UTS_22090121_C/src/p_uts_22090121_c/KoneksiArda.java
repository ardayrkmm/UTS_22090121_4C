/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p_uts_22090121_c;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import org.bson.Document;



public class KoneksiArda {
    public static MongoDatabase menyambung() {
        MongoDatabase database = null;
        try {
            // Menggunakan URI MongoDB untuk koneksi
            ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
            MongoClient mongoClient = MongoClients.create(connectionString);
            database = mongoClient.getDatabase("uts_22090121_4C");
        } catch (Exception e) {
            System.err.println(e);
        }
        return database;
    }

    public static void main(String[] args) {
        MongoDatabase db = menyambung();
        if (db != null) {
            System.out.println("Koneksi MongoDB berhasil.");
        } else {
            System.out.println("Gagal terhubung ke MongoDB.");
        }
    }
}
