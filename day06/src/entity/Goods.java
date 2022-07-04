package entity;

public class Goods {
    private String goodsId;
    private String name;
    private float price;
    private int stock;

    public Goods() {
    }

    public Goods(String[] good) {
        this.goodsId = good[0];
        this.name = good[1];
        this.price = Float.parseFloat(good[2]);
        this.stock = Integer.parseInt(good[3]);
    }

    public Goods(String goodsId, String name, float price, int stock) {
        this.goodsId = goodsId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return this.getGoodsId() + "\t\t"
                + this.getName() + "\t\t"
                + this.getPrice() + "\t"
                + this.getStock() + "\n";
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
