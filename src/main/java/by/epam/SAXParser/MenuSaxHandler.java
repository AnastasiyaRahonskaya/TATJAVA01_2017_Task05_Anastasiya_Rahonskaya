package by.epam.SAXParser;

import by.epam.bean.Dish;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Class handler for XML file
 */
public class MenuSaxHandler extends DefaultHandler {
  private List<Dish> dishList = new ArrayList<>();
  private Dish dish;
  private StringBuilder text;
  private String DISH = "dish";
  private String ID = "id";

  public List<Dish> getDishList() {
    return dishList;
  }

  /**
   * method is for starting document
   *
   * @throws SAXException - caused exceptions
   */
  public void startDocument() throws SAXException {
    System.out.println("Parsing started.");
  }

  /**
   * method is for ending document
   *
   * @throws SAXException - caused exceptions
   */
  public void endDocument() throws SAXException {
    System.out.println("Parsing ended.");
  }

  /**
   * method is for starting element
   *
   * @param uri
   * @param localName  - tag
   * @param qName      - tag with prefix
   * @param attributes
   * @throws SAXException - caused exceptions
   */
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    System.out.println("startElement-> " + "uri: " + uri + " , localName: " + localName + ", qName: " + qName);
    text = new StringBuilder();
    if (localName.equals(DISH)) {
      dish = new Dish();
      dish.setId((Integer.parseInt(attributes.getValue(ID))));
    }
  }

  /**
   * method is for characters
   *
   * @param buffer
   * @param start
   * @param length
   */
  public void characters(char[] buffer, int start, int length) {
    text.append(buffer, start, length);
  }

  /**
   * method is for ending element
   *
   * @param uri
   * @param localName - tag
   * @param qName     - tag with prefix
   * @throws SAXException - caused exceptions
   */
  public void endElement(String uri, String localName, String qName) throws SAXException {
    MenuTagName tagName = MenuTagName.valueOf(localName.toUpperCase().replace("-", "_"));
    switch (tagName) {
      case CATEGORY:
        dish.setCategory(text.toString());
      case PHOTO:
        dish.setPhoto(text.toString());
        break;
      case NAME:
        dish.setName(text.toString());
        break;
      case DESCRIPTION:
        dish.setDescription(text.toString());
        break;
      case PORTION:
        dish.setPortion(text.toString());
        break;
      case PRICE:
        dish.setPrice(text.toString());
        break;
      case DISH:
        dishList.add(dish);
        break;
    }
  }

  /**
   * method is for warning
   *
   * @param exception
   */
  public void warning(SAXParseException exception) {
    System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
  }

  /**
   * method is for error
   *
   * @param exception
   */
  public void error(SAXParseException exception) {
    System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
  }

  /**
   * method is for fatal error
   *
   * @param exception
   * @throws SAXException - caused exceptions
   */
  public void fatalError(SAXParseException exception) throws SAXException {
    System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
    throw (exception);
  }
}
