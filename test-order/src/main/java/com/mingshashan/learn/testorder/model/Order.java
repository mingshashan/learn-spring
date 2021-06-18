package com.mingshashan.learn.testorder.model;

/**
 * Order
 *
 * @author jasonxu
 */
public class Order {

    private Long id;

    private String productCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
