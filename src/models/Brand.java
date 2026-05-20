package models;

import java.util.Arrays;
import models.CarYear;

public class Brand {
  private String brandName;
  private CarModel[] models;

  public Brand(String brandName, CarModel[] models) {
    this.brandName = brandName;
    this.models = models;
  }

  public String getBrandName() {
    return brandName;
  }
  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }
  public CarModel[] getModels() {
    return models;
  }
  public void setModels(CarModel[] models) {
    this.models = models;
  }

  public int getTotalValidYear() {
    int c = 0;
    for (int i = 0; i < models.length-1; i++) {
      for(int j = 0; j < models[i].getYears().length; j++) {
        if (models[i].getYears()[j].isValid()) c++;
      }
    }

    /* Mejor forma
    for (CarModel carModel : models) {
      for (CarYear year : carModel.getYears()) {
         if (year.isValid()) {
          c++;
        }
      }
    }
    */

    return c;
  }

  @Override
  public String toString() {
    return "Brand [brandName=" + brandName + ", models=" + Arrays.toString(models) + "]";
  }
  

}
