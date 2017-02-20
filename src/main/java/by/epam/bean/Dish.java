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
}
