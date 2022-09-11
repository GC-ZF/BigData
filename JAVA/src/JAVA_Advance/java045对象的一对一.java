package JAVA_Advance;

/**
 * 两个对象之间的一对一关系：一个英雄（Hero)对应一个兵器（Weapon)
 * 双向一对一
 * 单向一对一
 */

public class java045对象的一对一 {
    public static void main(String[] args) {
        Hero hero=new Hero("刘备",300);
        Weapon w=new Weapon("双股剑",3);

        //把两个对象关联
        hero.setWeapon(w);
        w.setHero(hero);

        //通过英雄获取武器
        String name=hero.getName();
        int age=hero.getAge();
        System.out.println("姓名："+name+" 年龄："+age+" 武器:"+hero.getWeapon().getName()+" 排行："+w.getGrade());

        //
    }
}


class Hero {
    private int age;
    private String name;
    private Weapon weapon;//一对一

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Hero() {
    }

    public Hero( String name,int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Weapon {
    private String name;
    private int grade;
    private Hero hero;

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public Weapon() {
    }

    public Weapon(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
