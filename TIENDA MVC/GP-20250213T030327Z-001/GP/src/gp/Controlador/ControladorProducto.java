/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gp.Controlador;
import com.mongodb.client.MongoCursor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import com.mongodb.client.MongoCollection;



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



public class ControladorProducto {
    
    private MongoCollection<Document> collection;
    

    // Constructor que recibe la conexión a MongoDB
    public ControladorProducto(ConexionMongoDB conexion) {
        this.collection = conexion.getCollection();
    }

        // Método para limpiar una tabla en la interfaz
    public void limpiarTabla(DefaultTableModel dtm) {
        dtm.setRowCount(0);
    }

    // Método para crear un nuevo documento en la base de datos
    public void crearDato(String codigo, String nombre, int cantidad, double precio, DefaultTableModel dtm) {
        Document nuevoDocumento = new Document("codigo", codigo)
                .append("nombre", nombre)
                .append("cantidad", cantidad)
                .append("precio", precio);

        // Insertar en MongoDB
        collection.insertOne(nuevoDocumento);

        // Agregar a la tabla de la interfaz
        dtm.addRow(new Object[]{codigo, nombre, cantidad, precio});

        JOptionPane.showMessageDialog(null, "Documento insertado exitosamente...", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para cargar los datos de MongoDB en una tabla
    public void cargarDatos(DefaultTableModel dtm) {
        limpiarTabla(dtm);
        MongoCursor<Document> cursor = collection.find().iterator();

        while (cursor.hasNext()) {
            Document documento = cursor.next();
            dtm.addRow(new Object[]{
                documento.getString("codigo"),
                documento.getString("nombre"),
                documento.getInteger("cantidad"),
                documento.getDouble("precio")
            });
        }
        cursor.close();
        JOptionPane.showMessageDialog(null, "Carga de datos exitosa...", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para modificar un documento en la base de datos
    public void modificarDato(String codigoOriginal, String nuevoCodigo, String nuevoNombre, int nuevaCantidad, double nuevoPrecio, DefaultTableModel dtm, int filaSeleccionada) {
        Document filtro = new Document("codigo", codigoOriginal);
        Document nuevosValores = new Document("$set", new Document("codigo", nuevoCodigo)
                .append("nombre", nuevoNombre)
                .append("cantidad", nuevaCantidad)
                .append("precio", nuevoPrecio));

        collection.updateOne(filtro, nuevosValores);

        // Actualizar la tabla
        dtm.setValueAt(nuevoCodigo, filaSeleccionada, 0);
        dtm.setValueAt(nuevoNombre, filaSeleccionada, 1);
        dtm.setValueAt(nuevaCantidad, filaSeleccionada, 2);
        dtm.setValueAt(nuevoPrecio, filaSeleccionada, 3);

        JOptionPane.showMessageDialog(null, "Modificación realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para eliminar un documento en la base de datos
    public void eliminarDato(String codigo, DefaultTableModel dtm, int filaSeleccionada) {
        Document filtro = new Document("codigo", codigo);
        collection.deleteOne(filtro);
        dtm.removeRow(filaSeleccionada);

        JOptionPane.showMessageDialog(null, "Eliminación exitosa...", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

}