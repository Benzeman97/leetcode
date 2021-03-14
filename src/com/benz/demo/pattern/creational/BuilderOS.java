package com.benz.demo.pattern.creational;

class OperatingSystem{

    private String name;
    private int version;
    private String vendor;
    private double price;

    public OperatingSystem(String name,int version,String vendor,double price)
    {
        this.name=name;
        this.version=version;
        this.vendor=vendor;
        this.price=price;
    }

    public static OperatingSystem builder(BuilderOS builderOS)
    {
        return new OperatingSystem(builderOS.getName(),builderOS.getVersion(),builderOS.getVendor(),builderOS.getPrice());
    }

    @Override
    public String toString() {
        return "OperatingSystem{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                '}';
    }
}

public class BuilderOS {

    private String name;
    private int version;
    private String vendor;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OperatingSystem getOS(BuilderOS builderOS)
    {
        return OperatingSystem.builder(builderOS);
    }
}
