/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p_uts_22090121_c;

import com.mongodb.client.MongoDatabase;

import com.mongodb.client.MongoIterable;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.Date;
import java.util.Scanner;
import org.bson.Document;
import org.bson.types.ObjectId;
/**
 *
 * @author LENOVO
 */
public class CRUD_22090121_4C {
    public static void main(String[] args) {
        try {
         Scanner scanner = new Scanner(System.in);

        MongoDatabase database = KoneksiArda.menyambung();

    MongoCollection<Document> col = database.getCollection("col_22090121_4C");
          System.out.println("============Menu=============");
            System.out.println("daftar tabel dalam database");
            MongoIterable<String> tables = database.listCollectionNames();
            for (String Name : tables) {
                System.out.println(Name);
            }
            
            
                 System.out.println("============Menu=============");
            System.out.println("menambahkan data");
            
            Document doc = new Document();
            doc.put("nama", "Arda yudrik malana");
            doc.put("nim", 22090121);
            col.insertOne(doc);
            System.out.println("data telah disimpan dalam koleksi");
            
            
            Document doc2 = new Document();
               System.out.println("============Menu=============");
            System.out.println("menambahkan data 2");
            doc2.put("nama", "Arda yudrik M");
            doc2.put("nim", 22090121);
            doc2.put("alamat","Brebes");
            col.insertOne(doc2);
            System.out.println("data telah disimpan dalam koleksi");
            
            
            Document doc3 = new Document();
                 System.out.println("============Menu=============");
            System.out.println("menambahkan data 3");
     doc3.put("nama", "Amad yudrik M");
            doc3.put("nim", 22090121);
            doc3.put("alamat","Brebes");
            doc3.put("hobi", "futsal" );
            
            col.insertOne(doc3);
            System.out.println("data telah disimpan dalam koleksi");
            
            ObjectId id = new ObjectId(doc.get("_id").toString());
            
             System.out.println("============Menu=============");
            System.out.println("data dalam koleksi mahasiswa");
            MongoCursor<Document> cursor = col.find().iterator();
            while (cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
            
          
            
            Document myDoc = col.find(eq("_id", id)).first();
            System.out.println("============Menu=============");
            System.out.println("pencarian data data "+id);
            System.out.println(myDoc.toJson());
            
          
            
            Document docs = new Document();
            
            docs.put("nim", 2209111);
            Document doc_edit = new Document("$set",docs);
            UpdateResult hasil_edit = col.updateOne(eq("nama","amad"),doc_edit);
            System.out.println(hasil_edit.getModifiedCount());
            
            
            
            System.out.println("==========================");
            System.out.println("data koleksi data mahasiswa");
            cursor = col.find().iterator();
            while (cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
            
            
            
            col.deleteOne(eq("nama","komputer"));
            
            System.out.println("==========================");
            System.out.println("data koleksi mahasiswa");
            cursor = col.find().iterator();
             while (cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
        } catch (Exception e) {
        }
    }
}
