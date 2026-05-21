package controllers;

import models.Brand;

public class BrandController {
  public Brand[] sortBubbleDesc(Brand[] brands) {

    for (int i = 0; i < brands.length; i++) {
      for (int j = i + 1; j < brands.length - 1; j++){
        if (brands[j].getTotalValidYear() > brands[j + 1].getTotalValidYear()) {
          Brand temp = brands[i];
          brands[i] = brands[j];
          brands[j] = temp;
        }
      }
    }
    return brands;

  }


  public Brand binarySearchByValidYears(Brand[] brands, int validYears,boolean isAscending) {
    int left = 0;
    int right = brands.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;
        int midYears = brands[mid].getTotalValidYear();
        if (midYears == validYears) {
            return brands[mid];
        }
        if (isAscending) {
            if (midYears < validYears) left = mid + 1;
            else right = mid - 1;
        } else {
            if (midYears > validYears) left = mid + 1;
            else right = mid - 1;
        }
    }
    return null;
}

}
