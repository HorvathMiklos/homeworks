package xyz.codingmentor.javaeehomework.beans;

import java.util.Objects;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import xyz.codingmentor.javaeehomework.constraint.AppleBlackOrWhite;
import xyz.codingmentor.javaeehomework.constraint.SamsungIsNotGreen;
import xyz.codingmentor.javaeehomework.constraint.ValidNaturalNumber;
import xyz.codingmentor.javaeehomework.constraint.ValidPositive;

/**
 *
 * @author mhorvath
 */
@AppleBlackOrWhite
@SamsungIsNotGreen
public class Device {

    @Pattern.List({
        @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"),})
    @NotNull
    @Size(min = 36)
    String id;

   

    @NotNull
    Manufacturer manufacturer;
    @NotNull
    @Size(min = 3)
    String type;
    @NotNull
    @ValidPositive
    Integer price;
    @NotNull
    Color color;
    @NotNull
    @ValidNaturalNumber
    Integer count;

 @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Device other = (Device) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public Color getColor() {
        return color;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getId() {
        return id;
    }

}
