package byteuawesome.bungkus.SectionFood;

import java.util.Comparator;

/**
 * Created by Laptop on 2/16/2018.
 */

public class SectionFoodModel {

    private String menuName, menuPrice, menuDescription, processCategory, storeName;

    private Boolean storeState = false;

    public SectionFoodModel(String menuName, String menuPrice, String menuDescription, String processCategory, String storeName) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
        this.processCategory = processCategory;
        this.storeName = storeName;
    }

    public static final Comparator<SectionFoodModel> SORT_BY_NAME = new Comparator<SectionFoodModel>() {
        @Override
        public int compare(SectionFoodModel sectionFoodModel, SectionFoodModel t1) {
            return sectionFoodModel.getMenuName().compareTo(t1.getMenuName());
        }
    };

    public static final Comparator<SectionFoodModel> SORT_BY_PRICE = new Comparator<SectionFoodModel>() {
        @Override
        public int compare(SectionFoodModel sectionFoodModel, SectionFoodModel t1) {
            Integer valueA = Integer.parseInt(sectionFoodModel.getMenuPrice());
            Integer valueB = Integer.parseInt(t1.getMenuPrice());
            return valueA.compareTo(valueB);
        }
    };

    public Boolean getStoreState() {
        return storeState;
    }

    public void setStoreState(Boolean storeState) {
        this.storeState = storeState;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getProcessCategory() {
        return processCategory;
    }

    public void setProcessCategory(String processCategory) {
        this.processCategory = processCategory;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


}
