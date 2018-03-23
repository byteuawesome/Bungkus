package byteuawesome.bungkus.ActivityCart;

/**
 * Created by Laptop on 2/18/2018.
 */

public class CartModel {

    private String storeImgUrl, storeName, productImgUrl, productName, productQuantity, transportPrice, subTotalPrice, productPrice;

    public CartModel(String storeImgUrl, String storeName, String productImgUrl, String productName, String productQuantity, String transportPrice, String subTotalPrice, String productPrice) {
        this.storeImgUrl = storeImgUrl;
        this.storeName = storeName;
        this.productImgUrl = productImgUrl;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.transportPrice = transportPrice;
        this.subTotalPrice = subTotalPrice;
        this.productPrice = productPrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getStoreImgUrl() {
        return storeImgUrl;
    }

    public void setStoreImgUrl(String storeImgUrl) {
        this.storeImgUrl = storeImgUrl;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(String transportPrice) {
        this.transportPrice = transportPrice;
    }

    public String getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(String subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }
}
