package aed.tiendaonline;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class UnmarshallerTienda {
    public static Tienda unmarshall(String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Tienda.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Tienda) unmarshaller.unmarshal(new File(fileName));
    }
}
