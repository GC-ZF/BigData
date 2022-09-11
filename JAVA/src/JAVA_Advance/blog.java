package JAVA_Advance;

import java.util.Scanner;

public class blog {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("图片名字");
        String photo=sc.next();
        System.out.println("Hexo_img/top_img/"+photo+".png");
    }
}
