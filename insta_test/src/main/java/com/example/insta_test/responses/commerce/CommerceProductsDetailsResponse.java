package com.example.insta_test.responses.commerce;

import com.example.insta_test.models.commerce.Product;
import com.example.insta_test.models.user.Profile;
import com.example.insta_test.responses.IGResponse;


public class CommerceProductsDetailsResponse extends IGResponse {
    private Profile merchant;
    private Product product_item;


    public Profile getMerchant() {
        return merchant;
    }

    public void setMerchant(Profile merchant) {
        this.merchant = merchant;
    }

    public Product getProduct_item() {
        return product_item;
    }

    public void setProduct_item(Product product_item) {
        this.product_item = product_item;
    }
}
