package homework;

import java.util.Objects;

public class Notebook {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram &&
                storage == notebook.storage &&
                brand.equals(notebook.brand) &&
                os.equals(notebook.os) &&
                color.equals(notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, storage, os, color);
    }
}
