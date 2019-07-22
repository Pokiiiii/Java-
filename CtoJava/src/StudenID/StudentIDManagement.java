package StudenID;


// 无用的依赖提交前要清理，IDEA有选项自动清理的
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentIDManagement {
    class Node {
        //可以加修饰符的,范围由大到小
        private String name;   //所有人都可以访问
        private String sex; //同个包～～
        private long num;             //默认，子类～～
        private int EnterSchoolYear; //只有它自己~~
        private int SchoolSystem;
        private String college;
        private String major;
        private int cla;
        private long id;

        //通常都是private，然后使用下面这些方法访问
        // 自动生成的
        // 当然还有另外一种更加优雅的方案，下面几十行代码都不用写
        public void setName(String name) {
            this.name = name;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setNum(long num) {
            this.num = num;
        }

        public void setEnterSchoolYear(int enterSchoolYear) {
            EnterSchoolYear = enterSchoolYear;
        }

        public void setSchoolSystem(int schoolSystem) {
            SchoolSystem = schoolSystem;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public void setCla(int cla) {
            this.cla = cla;
        }

        public void setId(long id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public long getNum() {
            return num;
        }

        public int getEnterSchoolYear() {
            return EnterSchoolYear;
        }

        public int getSchoolSystem() {
            return SchoolSystem;
        }

        public String getCollege() {
            return college;
        }

        public String getMajor() {
            return major;
        }

        public int getCla() {
            return cla;
        }

        public long getId() {
            return id;
        }
    }//class

    //用private
    // 使用修饰附是为了封装，即只把对别人有用的东西给别人看，
    // 自己内部的实现细节不要给别人看，会干扰别人用你的代码

    //!!!!! 变量名小写开头，而且List这个变量名被一个java常用的数组（相当于c++的Vector用了，别冲突了）
    private ArrayList<Node> list = new ArrayList<>();

    //boolean isEmpty()用ArrayList的方法判断list空否

    //!!驼峰式命名
    //下面这个函数怪怪的：P
    private int searchImfo(long num)
    {
        int i;
        for(i=0; i< list.size(); i++)
        {
            Node student = list.get(i);
            if(student.getNum() ==num)return i;
        }
        return -1;
    }


    private Scanner sc = new Scanner(System.in);
    
    private int readInt(String message){
        System.out.println(message);
        int i;
        //演示捕获错误（异常）
        //下面的代码应该是有问题的，只是为了演示，因为没有强制结束
        //还有很多种方法可以捕获异常，或者提前判断接下来是不是int
        // 比如 sc.hasNextInt();
        while (true){
            try{
                // a
                i = sc.nextInt(); //读一个整数，如果输入错误（比如输入字符串）会跳到c，不然继续执行b
                //b
                break; //退出死循环
            }catch (Exception e){
                //c
                System.out.println("解析错误，请输入一个整数:");
                //接下来整个try语句结束，while循环还没结束
            }
        }
        return i;
    }
    //下面两个就不捕获异常了(懒）
    private long readLong(String message){
        System.out.println(message);
        return sc.nextLong();
    }
    
    private String readLine(String message){
        System.out.println(message);
        //这样也是有问题的，假如第一次就输入字符串怎么办
        //解决方法很简单 →.→
        sc.nextLine();
        return sc.nextLine();
    }

    private void inputStudentInfo(ArrayList<Node> list)
    {
        //下面的代码其实还有两种更加好的写法，构造器和工厂函数
        Node student = new Node();
        student.setNum(readLong("请输入学生学号："));
        student.setName(readLine("请输入学生姓名："));
        student.setSex(readLine("请输入学生性别："));
        student.setEnterSchoolYear(readInt("请输入学生入学年份："));
        student.setSchoolSystem(readInt("请输入学生学制："));
        student.setCollege(readLine("请输入学生所属学院："));
        student.setMajor(readLine("请输入学生所学专业："));
        student.setCla(readInt("请输入学生所在班级："));
        student.setId(readLong("请输入学生身份证号码："));
        list.add(student);
    }

    private void addStudentInfo(ArrayList<Node> List)
    {
        int i=1;
        int n=0;
        //标准输入文件最好只被占用一次，不然可能有预料之外的错误
        //  Scanner cin = new Scanner(System.in);
        while(i==1)
        {
            //println自带换行（ln == line）
            System.out.println("***开始录入学生证信息***");
            System.out.println("***如需返回菜单请输入0，继续录入请输入1***");
            i = sc.nextInt();
            if(i==0)break;
            inputStudentInfo(List);
            n++;
            System.out.println("***该学生学生证信息已录入完毕***");
            System.out.println("***如需返回菜单请输入0，继续录入请输入1***");
            i = sc.nextInt();
            if(i==0)break;
        }
        System.out.println("***"+n+"位学生的学生证信息已录入完毕***");
    }

    public  void ShowStuInfo()
    {
        long num;
        int i,f=1;
        while(f==1)
        {
            System.out.println("***开始查询学生证信息***\n");
            System.out.println("***如需返回菜单请输入0，继续录入请输入1***\n");
            f = sc.nextInt();
            if(f==0)break;
            System.out.println("***请输入要查询学生的学号***\n");
            num = sc.nextLong();
            i = searchImfo(num);
            if(i==-1) {
                System.out.println("***该学生证信息不存在，请确认是否输入准确***\n");
            } else {
                Node student = list.get(i);
                System.out.println("该学生学号："+ student.getNum());
                System.out.println("该学生姓名："+ student.getName());
                System.out.println("该学生性别："+ student.getSex());
                System.out.println("该学生入学年份："+ student.getEnterSchoolYear());
                System.out.println("该学生学制："+ student.getSchoolSystem() +"年");
                System.out.println("该学生所属学院："+ student.getCollege());
                System.out.println("该学生所学专业："+ student.getMajor());
                System.out.println("该学生所在班级："+ student.getCla() +"班");
                System.out.println("该学生身份证号码："+ student.getId());
            }
            System.out.println("***如需返回菜单请输入0，继续录入请输入1***\n");
            f = sc.nextInt();
            //下面两句是多余的？
//            if(f==0)
//                break;
        }
        System.out.println("***查询完毕***\n");
    }


    private void menu1()
    {
        System.out.println("\n========主菜单=========\n|                     |");
        System.out.println("|  1.管理学生证信息   |");
        System.out.println("|                     |\n|  2.查询学生证信息   |");
        System.out.println("|                     |\n|  3.统计学生证信息   |");
        System.out.println("|                     |\n|   0.退出系统操作    |");
        System.out.println("|                     |\n=======================\n");
    }


    private void menu2()
    {
        System.out.println("\n========管理学生证信息=========\n");
        System.out.println("       1.添加学生证信息");
        System.out.println("\n       2.修改学生证信息");
        System.out.println("\n       3.删除学生证信息");
        System.out.println("\n       4.保存学生证信息");
        System.out.println("\n        0.返回主菜单");
        System.out.println("\n===============================\n");
    }

    private void menu3()
    {
        System.out.println("\n========查询学生证信息=========\n");
        System.out.println("     1.查询单个学生证信息");
        System.out.println("\n   2.查询班级全部学生证信息");
        System.out.println("\n        0.返回主菜单");
        System.out.println("\n===============================\n");
    }

    private void SaveFile() throws IOException{
        int i;
        String path = "D:\\test\\student.txt";
        BufferedWriter out = new BufferedWriter(
                //new OutputStreamWriter(new FileOutputStream(path,true)));
        new OutputStreamWriter(new FileOutputStream(path)));
        for(i=0; i< list.size(); i++)
        {
            Node student = list.get(i);
            out.write(student.getName() + "\t");
            out.write(student.getNum() + "\t");
            out.write(student.getSex() + "\t");
            out.write(student.getEnterSchoolYear() + "\t");
            out.write(student.getSchoolSystem() + "\t");
            out.write(student.getCollege() + "\t");
            out.write(student.getMajor() + "\t");
            out.write(student.getCla() + "\t");
            out.write(student.getId() + "\t");
        }
        out.close();
    }
    private void getFile() throws FileNotFoundException {
        Scanner sc=new Scanner(new File("D:\\test\\student.txt"));
        while(sc.hasNextLine()) {
            Node student = new Node();
            student.setNum(sc.nextLong());
            student.setName(sc.nextLine());
            student.setSex(sc.nextLine());
            student.setEnterSchoolYear(sc.nextInt());
            student.setSchoolSystem(sc.nextInt());
            student.setCollege(sc.nextLine());
            student.setMajor(sc.nextLine());
            student.setCla(sc.nextInt());
            student.setId(sc.nextLong());
            list.add(student);
        }
        sc.close();
    }
    private void start() throws IOException {
        //ArrayList<Node> list = new ArrayList<Node>();
        //addStudentInfo(list);
        int choice,c;
        Scanner cin = new Scanner(System.in);
        menu1();
        while(true)
        {
            System.out.println("请选择操作");
            choice = cin.nextInt();
            //一个case就用if
            if (choice == 1) {
                menu2();
                while (true) {
                    System.out.println("请选择操作");
                    c = cin.nextInt();
                    switch (c) {
                        //习惯上switch都加花括号吧
                        case 1: {
                            addStudentInfo(list);
                            break;
                        }case 2: {
                            break;
                        }case 3: {
                            break;
                        }case 4: {
                            SaveFile();
                            break;
                        }case 0: {
                            break;
                        }default: {
                            System.out.println("输入错误，请重新选择操作！");
                        }
                    }
                }
            }
            if(choice==0)break;
        }
    }
    public static void main(String[] args)throws IOException {
        new StudentIDManagement().start();
    }
}
