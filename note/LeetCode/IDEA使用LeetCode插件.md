# IDEA使用LeetCode插件

## 前言

我们习惯用idea编写、调试代码，在LeetCode上刷题时，如果能够在IDEA编写代码，并且做好代码管理和保存，是一件事半功倍的事情。对于后续复习题目，做笔记也会非常便利。

本文目的在于介绍LeetCode Editor的使用，以及配置工具类，最终目录结构如下：

![image-20220228174912271](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228174912271.png)

- note：放置笔记
- src：放置代码
  - leetcode.editor.cn：插件LeetCode Editor自动生成
  - utils：自定义的工具包，可用于自动化输入测试用例，定义题目需要的类（结构体）
- out：运行测试时自动生成

LeetCode Editor GitHub：https://github.com/shuzijun/leetcode-editor

## 新建项目

新建一个java项目，选择jdk

![image-20220228175854078](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228175854078.png)

直接next，不要使用模板

![image-20220228180025956](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228180025956.png)

输入项目名，finish

![image-20220228180013733](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228180013733.png)

## 使用插件

### 1.安装插件

文件 -> 设置 -> plugins -> 安装LeetCode Editor

![image-20220228180420191](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228180420191.png)

LeetCode Editor Plus 需要付费才能使用

### 2.配置插件

如果安装成功，此时idea右下角应该出现LeetCode图标（首次点开需要登录），如果没有图标：文件 -> 设置 -> 工具 -> leetcode plugin

![image-20220228181345616](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228181345616.png)

![image-20220228181527728](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228181527728.png)

URL：有国内版本与国际版本可供选择

CodeType：编程语言

LoginName&Password：LeetCode的登录账号

**TempFilePath：插件自动生成的文件的位置。路径保存在src目录下**

接下来是插件自动生成文件的模板，我觉得默认就挺好，没有改动。

**这些配置在使用之后可以随时更改，实时变化**

### 3.使用插件

配置完后刷新一下，打开题目，会自动生成java文件，首次打开题目会在TempFilePath路径下生成leetcode.editor.cn包

![image-20220228182712713](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228182712713.png)

![image-20220228182739868](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228182739868.png)



由上图可知，可以利用这个题目做提交，查看题目状态等操作。（注意打开题目后需要标明包package leetcode.editor.cn;）

到了这一步，LeetCode插件已经介绍完毕，接下来具体说一下针对题目做一些自动化操作，这样配置出于我的个人使用习惯，大家可参考使用。

## 配置ListNode

当我们在刷链表相关的题目时，会经常看到ListNode这个对象，这不是jdk内置对象，是LeetCode自定义对象，以下通过题目2进行讲解

首次打开题目长这样，这是插件自动生成的java文件：

```java
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 7554 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution53 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
      
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```

1. 首先做一些准备工作，引入包，改类名（不然会冲突，结合插件生成的文件，我的习惯是在solution后面添加题号），然后根据我们的使用习惯，会需要创建main函数，用于运行测试

   ```java
   package leetcode.editor.cn;
   class Solution2 {
       
       
       public static void main(String[] args) {
           
       }
       
       
       public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           
         
       }
   }
   ```

2. 题目中已经给出ListNode的结构

   ```java
   /**
    * Definition for singly-linked list.
    * public class ListNode {
    * int val;
    * ListNode next;
    * ListNode() {}
    * ListNode(int val) { this.val = val; }
    * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    * }
    */
   ```

   在LeetCode平台中当我们提交测试时会自动加载这个类，那么为了在本地测试，需要新建这个类，我把这个类放到utils包中，项目结构看文章开头的图片

3. ListNode.java

   ```java
   package utils;
   
   /**
    * @author JonnyOu
    * @date 2022/2/24 16:10
    * @email JonnyOu1012@gmail.com
    */
   public class ListNode {
       public int val;
       public ListNode next;
       
       public ListNode(int x) { val = x; }
   
       // 链表节点的构造函数
       // 使用arr为参数，创建一个链表，当前的ListNode为链表头节点
       public ListNode(int[] arr){
           if(arr == null || arr.length == 0)
               throw new Error("arr can not be empty");
   
           this.val = arr[0];
           ListNode cur = this;
           for(int i = 1; i < arr.length; i ++){
               cur.next = new ListNode(arr[i]);
               cur = cur.next;
           }
       }
       
       //以当前节点为头节点的链表信息字符串 方便查看
       @Override
       public String toString(){
           StringBuilder res = new StringBuilder();
           ListNode cur = this;
           while(cur != null){
               res.append(cur.val + "->");
               cur = cur.next;
           }
           res.append("NULL");
           return res.toString();
       }
   }
   
   ```

   两个构造方法，用于生成int数组数据和当个int数据，toString用于测试时打印查看内容。这样在链表问题中引入此包即可随心测试了。

## 自定义测试用例

我们在测试题目时可能会使用多组测试用例，那么如果能够通过手动输入用例，会方便很多。这是一个高度定制化的内容，因为考虑到用例的格式五花八门。但凭借以往在其他平台刷题的一些浅薄的经验，其实用例经常就是一段字符串，一个数组，甚至是几个数字，比较复杂一点的用例就是一个二维数组（矩阵）。

继续以题目2作为例子，看看需要什么样的测试用例，我们定制一个，这个测试类也可用在其他地方。

![image-20220228185954521](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/image-20220228185954521.png)

**这个题目需要输入的测试用例就是两个int类型的数组。**（在这里建议查看题目和提交题目还是建议在官网中进行，虽然插件能够做到这个功能，但是不能现实图片，提交代码时也不能将main函数的代码一起提交，否则会报错）

那么我们可以编写一个方法：**读取控制台输入的数组，然后返回此数组**

不卖关子，直接给出这个类：

```java
package utils;

import java.util.Scanner;

/**
 * @author JonnyOu
 * @date 2022/2/28 17:21
 * @email JonnyOu1012@gmail.com
 */
public class TestIntArr {
    
    /**
     * 根据输入获取数组类型用例
     * @return
     */
    public int[] getIntArrExample() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一行数字，以空格分开...");
        String line = sc.nextLine();
        String[] strArr= line.split("\\s+");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
    
    public static void main(String[] args) {
        int[] arr = new TestIntArr().getIntArrExample();
        for (int i : arr) {
            System.out.println(i);
        }        
    }
}
```

题目2的代码：

```java
package leetcode.editor.cn;

import utils.ListNode;
import utils.TestIntArr;

class Solution2 {

    public static void main(String[] args) {
		
        // 调用输入方法
        int[] arr1 = new TestIntArr().getIntArrExample();
        int[] arr2 = new TestIntArr().getIntArrExample();

        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        System.out.println(new Solution2().addTwoNumbers2(l1, l2));
    }
    
    
    // 法一
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode node = l1, preL1 = null;
        int flag = 0;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + flag;
            if (val > 9) {
                l1.val = val % 10;
                flag = 1;
            } else {
                l1.val = val;
                flag = 0;
            }
            preL1 = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 != null) {
            preL1.next = l2;
            l1 = preL1.next;
        }

        while (l1 != null && l1.next != null) {
            int val = l1.val + flag;
            if (val > 9) {
                l1.val = val % 10;
                flag = 1;
            } else {
                l1.val = val;
                flag = 0;
            }
            l1 = l1.next;
        }

        // 处理最后可能进1的情况
        if (l1 != null) {
            if (l1.val == 9 && flag == 1) {
                ListNode last = new ListNode(1);
                l1.val = 0;
                l1.next = last;
            } else {
                l1.val = flag + l1.val;
            }
        } else {
            if (flag == 1) {
                ListNode last = new ListNode(1);
                preL1.next = last;
            }
        }
        
        return node;
    }

    // 法2
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;
        int flag = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + flag;
            flag = val > 9 ? 1 : 0;
            if (head == null) {
                head = tail = new ListNode(val % 10);
            } else {
                tail.next = new ListNode(val % 10);
                tail = tail.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (flag == 1) {
            tail.next = new ListNode(1);
        }

        return head;
    }
}
```

可能有人觉得这样太过于小题大做，对于简单的题目确实没太大必要，但是对于复杂的题目就不一样了。况且封装测试类的通用性其实还可以进一步提高。

## 尾声

在一开始的项目目录中可看出，我还新建了一个目录用于存放刷题的笔记。不仅如此，其实我们大可不必局限在LeetCode的网站，我们可以在同级目录建一个牛客网的包，用于存放牛客网的题目，牛客网没有对应像LeetCode Editor这样方便的插件。再放到GitHub上管理。

通过这个目录框架，对于我个人而言，是比较方便的，大大减少思考解题思路以外的时间，同时也可以使用idea的快捷键增加编码效率，也方便日后对代码的查看和管理。
