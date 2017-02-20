package by.epam.StAXParser;

import by.epam.bean.Dish;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Start point of the program
 */
public class StAXMenuParser {
  private static String XML_FILE = "Cafe.xml";
  private static String ID = "id";

  /**
   * StAX parser of the XML file
   *
   * @param args - cmd arguments
   */
  public static void main(String[] args) {
    try {
      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
      InputStream input = new FileInputStream(XML_FILE);
      XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
      List<Dish> menu = process(reader);

      for (Dish dish : menu) {
        System.out.println(dish.getName());
        System.out.println(dish.getDescription());
      }
    } catch (XMLStreamException | FileNotFoundException e) {
      System.out.println("Error!!!");
    }
  }

  /**
   * method is for processing
   *
   * @param reader
   * @return menu
   * @throws XMLStreamException - caused exceptions
   */
  private static List<Dish> process(XMLStreamReader reader) throws XMLStreamException {
    List<Dish> menu = new ArrayList<>();
    Dish dish = null;
    MenuTagName elementName = null;
    while (reader.hasNext()) {
      int type = reader.next();
      switch (type) {
        case XMLStreamConstants.START_ELEMENT:
          elementName = MenuTagName.getElementTagName(reader.getLocalName());
          switch (elementName) {
            case DISH:
              dish = new Dish();
              Integer id = Integer.parseInt(reader.getAttributeValue(null, ID));
              dish.setId(id);
              break;
          }
          break;

        case XMLStreamConstants.CHARACTERS:
          String text = reader.getText().trim();

          if (text.isEmpty()) {
            break;
          }
          switch (elementName) {
            case PHOTO:
              dish.setPhoto(text);
              break;
            case NAME:
              dish.setName(text);
              break;
            case DESCRIPTION:
              dish.setDescription(text);
              break;
            case PORTION:
              dish.setPortion(text);
              break;
            case PRICE:
              dish.setPrice(text);
              break;
          }
          break;

        case XMLStreamConstants.END_ELEMENT:
          elementName = MenuTagName.getElementTagName(reader.getLocalName());
          switch (elementName) {
            case DISH:
              menu.add(dish);
          }
      }
    }
    return menu;
  }
}
