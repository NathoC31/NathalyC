/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gp.Controlador;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 * UNIVERSIDAD DE LAS FUERZAS ARMADAS - ESPE
 * DEPARTAMENTO DE CIENCIAS DE LA COMPUTACIÓN
 * ASIGNATURA: PROGRAMACIÓN ORIENTADO A OBJETOS
 * DOCENTE: MGRT. JARAMILLO L.
 * TEMA: PROYECTO
 * INTEGRANTES: 
 *  BERNAL SHEYLA
 *  BORJA HENRY
 *  CUASAPAZ NATHALY
 *  GRANADA DAVID
 */



public class ConexionMongoDB {
    // Atributos estáticos para la conexión y la colección
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    // Método para iniciar la conexión
    public static void iniciarConexion() {
        try {
            mongoClient = new MongoClient("localhost", 27017);
            database = mongoClient.getDatabase("dbmongo");
            collection = database.getCollection("productos");

            // Agrega mensaje de conexión exitosa
            JOptionPane.showMessageDialog(null, "Conexión exitosa...", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexión no válida...", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error en agregar: " + e);
        }
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            JOptionPane.showMessageDialog(null, "Conexión cerrada con éxito...", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public MongoCollection<Document>getCollection(){
        return collection;
    }
}
