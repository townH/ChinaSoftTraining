package org.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.naming.Name;
import javax.print.attribute.standard.RequestingUserName;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Iphone {
    private String name;
    private String brand;
    private int price;

    @Override
    public String toString() {
        return "{" +
                "品牌：" + brand  +
                ", 名称：" + name +
                ", 价格：" + price +
                '}';
    }
}
