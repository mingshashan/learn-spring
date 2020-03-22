package com.mingshashan.learn.integration.demo01;

import java.math.BigDecimal;

/**
 * Software
 *
 * @author jasonxu
 */
public class Software extends Item{

    private String version;

    public Software(String title, String publisher, BigDecimal price, int yearPublished, String version) {
        super(title, publisher, price, yearPublished);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Software{");
        sb.append("version='").append(version).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", price=").append(price);
        sb.append(", yearPublished=").append(yearPublished);
        sb.append('}');
        return sb.toString();
    }
}
