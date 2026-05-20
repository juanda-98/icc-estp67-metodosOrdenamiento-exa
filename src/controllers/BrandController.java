package controllers;

import models.Brand;

public class BrandController {
  public Brand[] sortBubbleDesc(Brand[] brands) {

    for (int i = 0; i < brands.length; i++) {
      for (int j = i + 1; j < brands.length - 1; j++){
        Brand temp = null;
        if (brands[i].getTotalValidYear() > brands[j].getTotalValidYear())
        temp = brands[i];
        brands[i] = brands[j];
        brands[j] = temp;

      }
    }
    return brands;

  }


  public Brand binarySearchByValidYears(Brand[] brands, int validYears,boolean isAscending) {
    int left = 0;
    int right = brands.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midValidYears = brands[mid].getTotalValidYear();

        if (midValidYears == validYears) {
            return brands[mid];
        }

        if (isAscending) {
            // Arreglo ordenado ascendentemente
            if (midValidYears < validYears) {
                left = mid + 1;  // Buscar en la mitad derecha
            } else {
                right = mid - 1; // Buscar en la mitad izquierda
            }
        } else {
            // Arreglo ordenado descendentemente
            if (midValidYears > validYears) {
                left = mid + 1;  // Buscar en la mitad derecha
            } else {
                right = mid - 1; // Buscar en la mitad izquierda
            }
        }
    }

    return null; // No encontrado
}

}
