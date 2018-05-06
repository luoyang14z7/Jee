package model;

public class shoplist {
    private Integer id;

    private String shopname;

    private Integer prce;

    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public Integer getPrce() {
        return prce;
    }

    public void setPrce(Integer prce) {
        this.prce = prce;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}