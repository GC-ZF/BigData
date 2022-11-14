package JAVA_Advance;

import java.util.Arrays;

/**
 * 实现一个化妆品商城的化妆品管理
 * 1.定义一个化妆品类(Cosmetic)
 * 2.定义一个化妆品管理类(CosmeticMangaer)
 * - 实现进货功能
 * - 可以输出所有化妆品信息
 * 3.使用继承实现一个可按单价排序输出所有化妆品的功能
 * 4.使用继承实现一个只输出进口化妆品的功能
 */
public class java055继承应用示例 {
    public static void main(String[] args) {
        SortCosmeticManger cm = new SortCosmeticManger();
        cm.add(new Cosmetic("香奈儿", "进口", 1000));
        cm.add(new Cosmetic("圣罗兰", "进口", 800));
        cm.add(new Cosmetic("大宝", "国产", 20));
        cm.add(new Cosmetic("万紫千红", "国产", 15));
        cm.getInfo();

        Entrance en = new Entrance();
        en.add(new Cosmetic("香奈儿", "进口", 1000));
        en.add(new Cosmetic("圣罗兰", "进口", 800));
        en.add(new Cosmetic("大宝", "国产", 20));
        en.add(new Cosmetic("万紫千红", "国产", 15));
        en.getInfo();

    }
}

//只输出进口化妆品
class Entrance extends CosmeticManger {
    public void getInfo() {
        System.out.println("进口化妆品有:");
        for (int i = 0; i < count; i++) {
            if (cs[i].getType().equals("进口")) {
                System.out.println(cs[i].getInfo());
            }
        }
    }
}

//排序输出
class SortCosmeticManger extends CosmeticManger {
    public void getInfo() {
        Cosmetic[] tmp = Arrays.copyOf(cs, count);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (tmp[j].getPrice() > tmp[j + 1].getPrice()) {
                    int price = tmp[j].getPrice();
                    tmp[j].setPrice(tmp[j + 1].getPrice());
                    tmp[j + 1].setPrice(price);
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(tmp[i].getInfo());
        }
    }
}

//化妆品管理类
class CosmeticManger {
    protected Cosmetic[] cs = new Cosmetic[4];
    protected int count = 0;

    /**
     * 添加商品
     *
     * @param c 商品类
     */
    public void add(Cosmetic c) {
        int len = cs.length;
        if (count > len) {
            cs = Arrays.copyOf(cs, len * 2);
        }
        cs[count] = c;
        count++;
    }

    /**
     * 输出商品信息
     */
    public void getInfo() {
        int len = cs.length;
        for (int i = 0; i < len; i++) {
            System.out.println(cs[i].getInfo());
        }
    }
}

//化妆品类
class Cosmetic {
    private String name; //品牌
    private String type; //进口或国产
    private int price;//单价

    public Cosmetic() {
    }

    public Cosmetic(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfo() {
        return "name=" + name + ",type=" + type + ",price=" + price;
    }
}

