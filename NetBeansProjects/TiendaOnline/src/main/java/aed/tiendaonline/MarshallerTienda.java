package aed.tiendaonline;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class MarshallerTienda {
    public static void marshall(Tienda tienda, String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Tienda.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(tienda, new File(fileName));
    }
}
