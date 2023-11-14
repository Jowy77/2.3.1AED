
package pkg2.pkg3.pkg1aed;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XmlWriter {

    public static void main(String[] args) {
        // Llamar al método para escribir el documento XML
        escribirXml();
    }

    // Método para escribir un documento XML básico sobre guitarras
    public static void escribirXml() {
        // Crear una instancia de XMLOutputFactory
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try {
            // Crear un XMLStreamWriter
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("src\\recursos\\guitarras.xml"));

            // Escribir el encabezado del documento XML
            xmlStreamWriter.writeStartDocument();
            // Escribir el elemento raíz
            xmlStreamWriter.writeStartElement("guitarras");

            // Escribir información sobre la primera guitarra
            escribirGuitarra(xmlStreamWriter, "Gibson", "Les Paul", "Gold Top", 6, "Mahogany", "Rosewood", "Humbucker");

            // Ejemplos adicionales de guitarras
            escribirGuitarra(xmlStreamWriter, "Fender", "Telecaster", "Butterscotch Blonde", 6, "Ash", "Maple", "Single-coil");
            escribirGuitarra(xmlStreamWriter, "Ibanez", "RG550", "Neon Green", 6, "Basswood", "Maple", "Humbucker");
            escribirGuitarra(xmlStreamWriter, "PRS", "Custom 24", "Cherry Sunburst", 6, "Mahogany", "Rosewood", "Humbucker");
            escribirGuitarra(xmlStreamWriter, "Jackson", "Soloist", "Black", 7, "Mahogany", "Ebony", "Humbucker");
            escribirGuitarra(xmlStreamWriter, "Gretsch", "White Falcon", "White", 6, "Maple", "Ebony", "Filter'Tron");
            escribirGuitarra(xmlStreamWriter, "Epiphone", "Casino", "Natural", 6, "Maple", "Rosewood", "P-90");
            escribirGuitarra(xmlStreamWriter, "ESP", "LTD EC-1000", "Vintage Black", 6, "Mahogany", "Ebony", "Active Humbucker");
            escribirGuitarra(xmlStreamWriter, "Schecter", "Hellraiser C-1", "Black Cherry", 6, "Mahogany", "Rosewood", "Active EMG");
            escribirGuitarra(xmlStreamWriter, "Gibson", "SG Standard", "Heritage Cherry", 6, "Mahogany", "Rosewood", "Humbucker");
            escribirGuitarra(xmlStreamWriter, "Music Man", "John Petrucci Majesty", "Royal Red", 7, "Basswood", "Ebony", "Humbucker");

            // Cerrar los elementos
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();

            // Cerrar el XMLStreamWriter
            xmlStreamWriter.close();

            System.out.println("Documento XML creado con éxito.");

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para escribir información sobre una guitarra
    private static void escribirGuitarra(XMLStreamWriter xmlStreamWriter, String marca, String modelo, String color,
            int cuerdas, String cuerpo, String diapasón, String pastillas) throws XMLStreamException {
        // Escribir el elemento de la guitarra
        xmlStreamWriter.writeStartElement("guitarra");

        // Escribir los elementos dentro de la guitarra
        escribirElemento(xmlStreamWriter, "marca", marca);
        escribirElemento(xmlStreamWriter, "modelo", modelo);
        escribirElemento(xmlStreamWriter, "color", color);
        escribirElemento(xmlStreamWriter, "cuerdas", Integer.toString(cuerdas));

        // Elementos adicionales
        escribirElemento(xmlStreamWriter, "cuerpo", cuerpo);
        escribirElemento(xmlStreamWriter, "diapason", diapasón);
        escribirElemento(xmlStreamWriter, "pastillas", pastillas);

        // Cerrar el elemento de la guitarra
        xmlStreamWriter.writeEndElement();
    }

    // Método auxiliar para escribir un elemento con un nombre y un valor
    private static void escribirElemento(XMLStreamWriter xmlStreamWriter, String nombre, String valor)
            throws XMLStreamException {
        // Escribir el elemento con un nombre y un valor
        xmlStreamWriter.writeStartElement(nombre);
        xmlStreamWriter.writeCharacters(valor);
        xmlStreamWriter.writeEndElement();
    }
}