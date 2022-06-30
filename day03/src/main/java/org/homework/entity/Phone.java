package org.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
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
