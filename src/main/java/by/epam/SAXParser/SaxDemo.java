package by.epam.SAXParser;

import by.epam.bean.Dish;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

/**
 * Start point of the program
 */
public class SaxDemo {
  private static String XML_FILE = "Cafe.xml";

  /**
   * SAX parser of the XML file
   *
   * @param args - cmd arguments
   */
  public static void main(String[] args) {
    try {
      XMLReader reader = XMLReaderFactory.createXMLReader();
      MenuSaxHandler handler = new MenuSaxHandler();
      reader.setContentHandler(handler);
      reader.parse(new InputSource(XML_FILE));

      List<Dish> menu = handler.getDishList();
      for (Dish dish : menu) {
        System.out.println(dish.getId() + " " + dish.getName() + " " + dish.getDescription() + " " + dish.getPortion() + " " + dish.getPrice());
      }
    } catch (SAXException | IOException e) {
      System.out.println("Error!!!");
    }
  }
}
