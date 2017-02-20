package by.epam.StAXParser;

/**
 * Enum class for the tags of the menu
 */
public enum MenuTagName {
  CATEGORY,
  CAFE,
  DISH,
  PHOTO,
  NAME,
  DESCRIPTION,
  PORTION,
  PRICE;

  /**
   * method is for getting tag of the element
   *
   * @param element
   * @return tag of the menu
   */
  public static MenuTagName getElementTagName(String element) {
    switch (element) {
      case "category":
        return CATEGORY;
      case "cafe":
        return CAFE;
      case "dish":
        return DISH;
      case "photo":
        return PHOTO;
      case "name":
        return NAME;
      case "description":
        return DESCRIPTION;
      case "portion":
        return PORTION;
      case "price":
        return PRICE;
      default:
        throw new EnumConstantNotPresentException(MenuTagName.class, element);
    }
  }
}
