## 一、八种数据类型

| Type  | byte | Type          |      |
| ----- | ---- | ------------- | ---- |
| byte  | 1    | float(带后缀) | 4    |
| short | 2    | double        | 8    |
| int   | 4    | char          | 2    |
| long  | 8    | boolean       | 1    |

## 二、运算符

### 算数运算符

| Operator | Meant | Operator | Meant                         |
| -------- | ----- | -------- | ----------------------------- |
| +        | 加    | +=       | 赋值运算，`a+=1;`等价`a=a+1;` |
| -        | 减    | ==       | 关系运算符，返回bool值        |
| *        | 乘    | a++、a-- | 后置递 增\减                  |
| /        | 除    | ++a、--a | 前置递 增\减                  |
| %        | 取余  |          |                               |

```java
public class Test {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        a = b++;//后增，先赋值再自增
        System.out.println("a=" + a);//a=1
        System.out.println("b=" + b);//b=2

        a = 1;
        b = 1;
        a = ++b;//后自增，先增后赋值
        System.out.println("a=" + a);//a=2
        System.out.println("b=" + b);//b=2
    }
}
```

### 逻辑运算符

`boolean a = true;boolean b = false;`

| Operator | Meant                | Operator | Meant                    |
| -------- | -------------------- | -------- | ------------------------ |
| &        | 与，`a & b = false`  | !        | 非，`!b = true`          |
| \|       | 或，`a | b = true`   | &&       | 短路与，`a && b = false` |
| ^        | 异或，`a ^ b = true` | \|\|     | 短路或，`a || b = true`  |

> &:分别计算表达式两边的结果，再做&运算，在做位运算时&表示**按位与**
> &&:先计算左边的表达式，如果false直接输出false
> 所以首选短路

### 位运算符

| Operator | Meant              | Operator | Meant              |
| -------- | ------------------ | -------- | ------------------ |
| &        | 与，`10 & 10 = 10` | \|       | 或，`10 | 10 = 10` |
| ^        | 异，`10 ^ 10 = 0`  | ~        | 反，`~10 = -11`    |
| <<       | 左移               | >>       | 带符号右移         |
| >>>      | 无符号右移         |          |                    |

```java
public class Test {
    public static void main(String[] args) {
        //练习:以最快的方法计算8*4
        //0000 1000 8
        //0010 0000 32
        System.out.println(8 << 2);

        //练习:通过键盘输入，初始化两个数将这两个数据交换位置后，输出显示交换后得数据
        Scanner sc = new Scanner(System.in);
        System.out.println("num1=");
        int num1 = sc.nextInt();
        System.out.println("num2=");
        int num2 = sc.nextInt();
        //方法一通过第三个变量交换
        int tmp=num1;
        num1=num2;
        num2=tmp;
        
        //方法二
        num1 = num1 + num2 - (num2 = num1);

        //方法三
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num1;

        //方法四，最快但不能相同
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
    }
}

```

## 三、程序流程结构

### 选择结构

1. 在分支判断时，把匹配成功率高的判断放在前面，可以提高效率
2. 在表达式判断中，尽量使用确定的值去跟不确定的值去判断 if(100==x)

#### 三目运算

`表达式0 ? 表达式1:表达式2 `：表达式0为真执行表达式1，表达式0为假执行表达式2

```java
public class Test {
    public static void main(String[] args) {
        int score = 90;
        boolean bool = score >= 60 ? true : false;
        System.out.println(bool);//true
    }
}
```

#### if语句

```java
public class Test {
    public static void main(String[] args) {
        //判断是否为闰年
        System.out.println("请输入一个年份");
        int year = input.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("闰年");
        } else {
            System.out.println("平年");
        }
    }
}
```

#### switch语句

switch分支语句：每一个case子句必须是唯一的常量值，需要添加break，否则将继续往下执行。default语句可以省略

```java
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("今天是星期几");
        int day = sc.nextInt();
        switch (day) {
            case 1:
                System.out.println("星期一");
                System.out.println("周一比较堵，1.公交 2.地铁");
                int method = sc.nextInt();
                if (method == 1) {
                    System.out.println("公交");
                } else {
                    System.out.println("地铁");
                }
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期七");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }
}
```

### 循环结构

#### for

```java
public class Test {
    public static void main(String[] args) {
        //1.标准写法
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        //2.表达式1省略，但在外部声明
        int j = 0;
        for (; j < 10; j++) {
            System.out.println(j);
        }

        //3.表达式2省略，死循环
        for (int i = 0; ; i++) {
            System.out.println(i);
        }

        //4.表达式3省略，但要声明在循环内部
        for (int i = 0; i < 10) {
            System.out.println(i);
            i++;
        }

        //5.表达式1，3省略，但是要声明在循环的外部和内部
        int x = 0;
        for (; x < 10; ) {
            System.out.println(x);
            x++;
        }

        //6.三个表达式都省略，死循环
        for (; ; ) {

        }
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        /*
            打印输出0~200之间能被7整除但不能被4整除的所有整数
         */
        for (int i = 0; i <= 200; i++) {
            if (i % 7 == 0 && i % 4 != 0) {
                System.out.println(i);
            }
        }

        /*
            输出10个斐波那契数列 第1，2为1，之后为前两项之和
        */
        int n1 = 1;
        int n2 = 1;
        for (int i = 1; i <= 10; i++) {
            if (i <= 2) {
                System.out.println(1);
            } else {
                System.out.println(n1 + n2);
                n2 = n1 + n2;
                n1 = n2 - n1;
            }
        }
    }
}
```

#### while 与 do...while

```java
public class Test {
    public static void main(String[] args) {
        //while 先判断再执行
        // 计算1~100
        int num = 0;    //计算总数
        int i = 1;
        while (i <= 100) {
            num += i;
            i++;
        }
        System.out.println(num);

        //计算10的阶乘
        num = 1;
        i = 1;
        while (i <= 10) {
            num *= i;
            i++;
        }
        System.out.println(num);

        //打印100以内所有奇数,偶数和3的倍数
        i = 1;
        while (i < 100) {
            if (i % 2 != 0) {
                System.out.println("奇数" + i + " ");
            } else if (i % 2 == 0) {
                System.out.println("偶数" + i + " ");
            } else if (i % 3 == 0) {
                System.out.println("3的倍数" + i + " ");
            }
            i++;
        }

        /*
            do...while 先执行再判断，最少执行一次
            逆序输出10~0
         */
        i = 10;
        do {
            System.out.print(i + " ");
            i--;
        } while (i >= 0);

        //阶乘求和
        i = 1;
        int j = 1;
        num = 1;
        int sum = 0;
        while (i <= 10) {
            while (j <= i) {
                num *= j;
                j++;
            }
            i++;
            j = 1;
            sum += num;
            num = 1;
        }
        System.out.println("sum=" + sum);

        i = 1;
        sum = 0;
        do {
            j = 1;
            num = 1;
            while (j <= i) {
                num *= j;
                j++;
            }
            sum += num;
            i++;
        } while (i <= 10);
        System.out.println("do sum=" + sum);
    }
}
```

## 四、数组



```java
/*
    数组的定义：一组能够存储相同数据类型的数据集合
    数组一定要有长度
    数组中的每个数据称为元素
 */
public class Test {
    public static void main(String[] args) {
        //第一种
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        //第二种
        int[] nums2;    //先声明，再定义
        nums2 = new int[5];

        //第三种
        int[] nums3 = new int[]{1, 2, 3, 4, 5};

        //第四种
        int[] nums4 = {1, 2, 3, 4, 5};

        System.out.println(nums.length);
    }
}
```

数组遍历与异常

```java
public class Test {
    public static void main(String[] args) {
        int[] scores = {80, 81, 82, 83, 84};
        System.out.println("数组的长度" + scores.length);
        //for遍历
        int len = scores.length;
        for (int i = 0; i < len; i++) {
            System.out.println(scores[i]);
        }

        //forearch遍历
        for (int x : scores) {
            System.out.println(x);
        }

        print(scores);
        print2(1, 2, 3, 4, 5);
    }

    public static void print(int[] x) {
        int len = x.length;
        for (int i = 0; i < len; i++) {
            System.out.println(x[i]);
        }
    }

    /*
        JSK1.5可变参数
        可变参数只能是参数列表中的最后一个
        可变参数作为数组使用
     */
    public static void print2(int... x) {
        int len = x.length;
        for (int i = 0; i < len; i++) {
            System.out.println(x[i]);
        }
    }

    //测试数组的异常NullPointerException(空指针)
    public static void print3(int[] x) {
        // java.lang.NullPointerException
        //当一个变量为null（没有赋值时）时，我们去调用了该变量的属性和方法
        System.out.println("数组的长度为：" + x.length);
    }

    //测试数组的异常,数组下标越界
    // java.lang.ArrayIndexOutOfBoundsException
    public static void print4(int[] x) {
        for (int i = 0; i <= x.length; i++) {
            System.out.println(x[i]);
        }
    }
}
```



## 五、函数

函数的定义

```java
public class Test {
    public static void main(String[] args) {
        getMenu();  //调用
        printStart(5);  //传入参数称为实参

    }


    /*
        定义方法
        访问权限+修饰符+返回值+方法名
     */
    public static void getMenu() {
        System.out.println("-----菜单-----");
        System.out.println("1、宫保鸡丁 22");
        System.out.println("2、韭菜鸡蛋 20");
        System.out.println("3、红烧狮子头 26");
        System.out.println("4、滋补牛尾汤 38");
        System.out.println("5、美颜酱猪蹄 38");
    }

    /*
        打印星星
        形参：在方法定义时的参数称为形参
     */
    public static void printStart(int line) {
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

方法的重载

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(isRun(2017) ? "闰年" : "平年");
    }

    /*
    方法函数
    方法的返回值：1、判断给定的是否是闰年
    */
    public static boolean isRun(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
        方法重载：在同一个类中，方法相同，参数列表不同。返回值不能作为重载的条件
     */
    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }
}
```

## 六、练习

### 猜数字

```java
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要猜的数");
        int num = sc.nextInt();
        System.out.println(guessNum(num) ? "在" : "不在");
    }

    /**
     * 数组示例：1、猜数游戏：从键盘中任意输入一个数据，判断数列中是否包含此数。
     */
    public static boolean guessNum(int num) {

        int[] data = new int[5];
        int len = data.length;
        Random rand = new Random();//随机数
        for (int i = 0; i < len; i++) {
            data[i] = rand.nextInt();
        }
        for (int i = 0; i < len; i++) {
            if (num == data[i]) {
                return true;
            }
        }
        return false;
    }
}
```

### 打印正三角形

```java
/**
 * 数组示例：2、打印正三角形。
 *     A
 *    B B
 *   C C C
 *  D D D D
 * E E E E E
 */
public class Test {
    public static void main(String[] args) {
        printTraingle(5);
    }
}    
public static void printTraingle(int num) {
    for (int i = 1; i <= num; i++) {
        //每排先打印num-i个空格
        for (int m = 1; m <= num - i; m++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= i; j++) {
            char a = (char) (64 + i);
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
```

### 多维数组

```java
/**
 * 二维数组示例:JAVA中没有真正的多维数组，多维数组的表示方式是数组中的元素还是数组。
 * 有3个班级各3名学员参赛，记录每个学员的成绩，并计算每个班的平均分。
 */
public class Test {
    public static void main(String[] args) {
        int[][] scores = {{78, 98, 88}, {87, 96, 85}, {67, 78, 89}};
        int classLen = scores.length;
        for (int i = 0; i < classLen; i++) {
            int sum = 0;
            int count = scores[i].length;
            for (int j = 0; j < count; j++) {
                sum += scores[i][j];
            }
            System.out.println(i + 1 + "平均分为" + sum / count);
        }
    }
}
```

### 双色球

```java
/**
 * 模拟双色球综合案例
 * 1.用户选择是机选还是手选号码
 * 2.接收用户选号（6红，1蓝）
 * 3.生成系统号码和用户号码，记录个数
 * 4.比较系统号码和用户号码，记录个数
 * 5.验证是否中奖
 * 6.系统号码排序
 * 7.公布结果
 */

public class Test {
    public static void main(String[] args) {
        //定义相关的变量
        int[] userRedBall = new int[6];//用户选择红球号码
        int[] sysRedBall = new int[6];//系统选择红球号码
        int userBlueBall = 0;//用户选择蓝球号码
        int sysBlueBall = 0;//系统选择蓝球号码
        int redCount = 0;//记录用户选择正确红球个数
        int blueCount = 0;//记录用户选择正确蓝球个数
        int[] redBall = new int[33];//存储1~33的红球号码
        //随机生成6个在1~33之间不重复的数
        for (int i = 0; i < redBall.length; i++) {
            redBall[i] = i + 1;
        }

        //游戏开始提示
        System.out.println("双色球游戏开始");
        System.out.println("1.机选 2.手选");

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        boolean flag = true;//判断是否需要重新输入机选或手选
        while (flag) {
            int isAuto = sc.nextInt();
            switch (isAuto) {
                case 1:
                    computer(redBall, userRedBall);//机选红球
                    userBlueBall = r.nextInt(16) + 1;//机选蓝球
                    flag = false;
                    break;
                case 2:
                    System.out.println("请选择6个红球号码(1~33)：");
                    for (int i = 0; i < userRedBall.length; i++) {
                        userRedBall[i] = sc.nextInt();
                    }
                    System.out.println("请输入1个蓝球号码(1~16)：");
                    userBlueBall = sc.nextInt();
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }

        //系统随机生成号码
        //红球
        computer(redBall, sysRedBall);
        //蓝球
        sysBlueBall = r.nextInt(16) + 1;

        //统计结果
        //红球
        for (int i = 0; i < userRedBall.length; i++) {
            for (int j = 0; j < sysRedBall.length - redCount; j++) {
                //找到以后交换位置，减少6行sysRedBall.length - redCount比较次数
                if (userRedBall[i] == sysRedBall[j]) {
                    int tmp = sysRedBall[j];
                    sysRedBall[j] = sysRedBall[sysRedBall.length - 1 - redCount];
                    sysRedBall[sysRedBall.length - 1 - redCount] = tmp;
                    redCount++;
                    break;
                }
            }
        }
        //蓝球
        if (userBlueBall == sysBlueBall) {
            blueCount = 1;
        }

        //验证是否中奖
        if (blueCount == 0 && redCount <= 3) {
            System.out.println("未中奖");
        } else if (blueCount == 1 && redCount < 1) {
            System.out.println("中了六等奖，5块钱！");
        } else if (blueCount == 1 && redCount == 3 || (blueCount == 0 && redCount == 4)) {
            System.out.println("中了五等奖，10块钱");
        } else if (blueCount == 1 && redCount == 4 || (blueCount == 0 && redCount == 5)) {
            System.out.println("中了四等奖，200块钱");
        } else if (blueCount == 1 && redCount == 5) {
            System.out.println("中了三等奖，3000块钱");
        } else if (blueCount == 0 && redCount == 6) {
            System.out.println("中了二等奖，150w");
        } else if (blueCount == 1 && redCount == 6) {
            System.out.println("中了一等奖，500w");
        } else {
            System.out.println("系统出错");
        }

        //公布系统号码
        System.out.println("本期中奖红球号码为");
        sort(sysRedBall);
        System.out.println(Arrays.toString(sysRedBall));
        System.out.println("本期中奖蓝球号码为:" + sysBlueBall);

        //公布用户号码
        System.out.println("您选择的红球号码为");
        sort(userRedBall);
        System.out.println(Arrays.toString(userRedBall));
        System.out.println("您选择的蓝球号码为:" + userBlueBall);

        System.out.println("谢谢参与");
    }

    //冒泡

    public static void sort(int[] ball) {
        for (int i = 0; i < ball.length - 1; i++) {
            for (int j = 0; j < ball.length - i - 1; j++) {
                if (ball[j] > ball[j + 1]) {
                    ball[j] = ball[j] + ball[j + 1];
                    ball[j + 1] = ball[j] - ball[j + 1];
                    ball[j] = ball[j] - ball[j + 1];
                }
            }
        }
    }

    //用于在指定数列中，随机生成多个不重复的数
    public static void computer(int[] redBall, int[] userRedBall) {
        Random r = new Random();
        int index = -1;
        int len = userRedBall.length;//生成六个随机数
        for (int i = 0; i < len; i++) {
            index = r.nextInt(redBall.length - i);
            userRedBall[i] = redBall[index];

            //改变数组顺序，与倒数第i为交换，在下一次生成随机数时排除在外（137行）
            int tmp = redBall[index];
            redBall[index] = redBall[redBall.length - 1 - i];
            redBall[redBall.length - 1 - i] = tmp;
        }
    }
}
```

## 七、算法

经典算法动图：[十大经典排序算法（动图演示）](https://www.cnblogs.com/onepixel/articles/7674659.html)

### 冒泡排序

```java
/**
 * 冒泡排序算法
 * 冒泡排序算法的运作如下：（从后往前）
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {34, 4, 56, 17, 90, 65};
        int len = nums.length;
        //外循环控制轮数，内循环控制比较次数
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int max = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = max;
                }
            }
        }
        for (int z = 0; z < len; z++) {
            System.out.print(nums[z] + "  ");
        }
    }
}
```

### 选择排序

```java
/**
 * 选择排序算法
 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，
 * 顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
 * 选择排序是不稳定的排序方法。
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {34, 4, 56, 17, 90, 65};
        int len = nums.length;
        int min = 0;
        for (int i = 0; i < len - 1; i++) {
            min = i;
            for (int j = i; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
        for (int z = 0; z < len; z++) {
            System.out.print(nums[z] + " ");
        }
    }
}
```

### 插入排序

```java
/**
 * 直接插入排序算法
 * （从后向前找到合适位置后插入）
 * 基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的子序列的合适位置（从后向前找到
 * 合适位置后），直到全部插入排序完为止。
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {34, 4, 56, 17, 90, 65};//待排序的数列
        //控制比较的轮数：
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];  //记录操作数
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            if (nums[j + 1] != temp) {
                nums[j + 1] = temp;
            }
        }
        //输出结果：
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
```

### 二分查找

```java
/**
 * 二分法查找（折半查找）：前提是在已经排好序的数组中，
 * 通过将待查找的元素与中间索引值对应的元素进行比较，若大于中间索引值对应的元素，
 * 去右半部分查找，否则，去左半部分查找。
 * 依此类推。直到找到为止；找不到返回一个负数。
 */
public class Test {
    public static void main(String[] args) {
        //必须保正数列是有序的
        int[] num = {10, 20, 50, 65, 88, 90};
        int index = binarySearch(num, 88);
        System.out.println(index);
    }

    //二分查找算法
    public static int binarySearch(int[] num, int key) {
        int start = 0;//开始下标
        int end = num.length - 1;//结束下标

        while (start <= end) {
            int middle = (start + end) >>> 1;
            //左边查
            if (num[middle] > key) {
                end = middle - 1;
            }
            //右边查
            else if (num[middle] < key) {
                start = middle + 1;
            }
            //找见
            else {
                return middle;
            }

        }
        return -1;
    }
}
```
