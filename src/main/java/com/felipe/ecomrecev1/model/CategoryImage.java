package com.felipe.ecomrecev1.model;

public class CategoryImage {

    private String mobile;
    private String tablet;
    private String desktop;

    public CategoryImage() {
    }

    public CategoryImage(String mobile, String tablet, String desktop) {
        this.mobile = mobile;
        this.tablet = tablet;
        this.desktop = desktop;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTablet() {
        return tablet;
    }

    public void setTablet(String tablet) {
        this.tablet = tablet;
    }

    public String getDesktop() {
        return desktop;
    }

    public void setDesktop(String desktop) {
        this.desktop = desktop;
    }
}
