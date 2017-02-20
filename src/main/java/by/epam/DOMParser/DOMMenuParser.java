package by.epam.DOMParser;

import by.epam.bean.Dish;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Start point of the program
 */
public class DOMMenuParser {
  private static String XML_FILE = "Cafe.xml";
  private static String DISH = "cf:dish";
  private static String ID = "id";
  private static String PHOTO = "d:photo";
  private static String NAME = "d:name";
  private static String DESCRIPTION = "d:description";
  private static String PORTION = "d:portion";
  private static String PRICE = "d:price";

  /**
   * DOM parser for XML file
   *
   * @param args - cmd arguments
   * @throws SAXException
   * @throws IOException
   */
  public static void main(String[] args)/* throws SAXException, IOException */ {
    try {
      DOMParser parser = new DOMParser();
      parser.parse(XML_FILE);
      Document document = parser.getDocument();

      Element root = document.getDocumentElement();

      List<Dish> menu = new ArrayList<>();

      NodeList dishNodes = root.getElementsByTagName(DISH);
      Dish dish = null;
      for (int i = 0; i < dishNodes.getLength(); i++) {
        dish = new Dish();
        Element dishElement = (Element) dishNodes.item(i);

        dish.setId(Integer.parseInt(dishElement.getAttribute(ID)));
        dish.setPhoto(getSingleChild(dishElement, PHOTO).getTextContent().trim());
        dish.setName(getSingleChild(dishElement, NAME).getTextContent().trim());
        dish.setDescription(getSingleChild(dishElement, DESCRIPTION).getTextContent().trim());
        dish.setPortion(getSingleChild(dishElement, PORTION).getTextContent().trim());
        dish.setPrice(getSingleChild(dishElement, PRICE).getTextContent().trim());
        menu.add(dish);
      }
      for (Dish d : menu) {
        System.out.println(d.getId() + " " + d.getName() + " " + d.getDescription() + " " + d.getPortion() + " " + d.getPrice());
      }
    } catch (SAXException | IOException e) {
      System.out.println("Error!!!");
    }
  }

  /**
   * method is for getting single child
   *
   * @param element
   * @param childName
   * @return child
   */
  private static Element getSingleChild(Element element, String childName) {
    NodeList nList = element.getElementsByTagName(childName);
    Element child = (Element) nList.item(0);
    return child;
  }
}
