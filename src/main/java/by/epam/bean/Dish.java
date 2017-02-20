package by.epam.bean;

import java.io.Serializable;

/**
 * Class Dish contains fields with required tags
 * and getters and setters
 */
public class Dish implements Serializable {
  private int id;
  private String category;
  private String photo;
  private String name;
  private String description;
  private String portion;
  private String price;

  public Dish(int id, String category, String photo, String name, String description, String portion, String price) {
    this.id = id;
    this.category = category;
    this.photo = photo;
    this.name = name;
    this.description = description;
    this.portion = portion;
    this.price = price;
  }

  public Dish() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPortion() {
    return portion;
  }

  public void setPortion(String portion) {
    this.portion = portion;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Dish dish = (Dish) o;

    if (getId() != dish.getId()) return false;
    if (getCategory() != null ? !getCategory().equals(dish.getCategory()) : dish.getCategory() != null) return false;
    if (getPhoto() != null ? !getPhoto().equals(dish.getPhoto()) : dish.getPhoto() != null) return false;
    if (getName() != null ? !getName().equals(dish.getName()) : dish.getName() != null) return false;
    if (getDescription() != null ? !getDescription().equals(dish.getDescription()) : dish.getDescription() != null)
      return false;
    if (getPortion() != null ? !getPortion().equals(dish.getPortion()) : dish.getPortion() != null) return false;
    return getPrice() != null ? getPrice().equals(dish.getPrice()) : dish.getPrice() == null;
  }

  @Override
  public int hashCode() {
    int result = getId();
    result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
    result = 31 * result + (getPhoto() != null ? getPhoto().hashCode() : 0);
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
    result = 31 * result + (getPortion() != null ? getPortion().hashCode() : 0);
    result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
    return result;
  }
}
