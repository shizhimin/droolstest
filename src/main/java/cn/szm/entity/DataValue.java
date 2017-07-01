package cn.szm.entity;

/**
 * Created by Administrator on 2017/7/1.
 */
public class DataValue {
    public Double getPrice() {
        return price;
    }

    public DataValue() {
    }

    public DataValue(Double price) {
        this.price = price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;
}
