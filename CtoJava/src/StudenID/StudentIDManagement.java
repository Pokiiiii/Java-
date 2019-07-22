package StudenID;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentIDManagement {
    static class Node {
        String name;
        String sex;
        long num;
        int EnterSchoolYear;
        int SchoolSystem;
        String college;
        String major;
        int cla;
        long id;
    };

    static ArrayList<Node> List = new ArrayList<Node>();

/*
    public static String getName(Node a){
        return a.name;
    }
    public static String getSex(Node a){
        return a.sex;
    }
    public static long getNum(Node a){
        return a.num;
    }
    public static int getYear(Node a){
        return a.EnterSchoolYear;
    }
    public static int getSchoolSystem(Node a){
        return a.SchoolSystem;
    }
    public static String getCollge(Node a){
        return a.college;
    }
    public static String getMajor(Node a){
        return a.major;
    }
    public static int getCla(Node a){
        return a.cla;
    }
    public static long getID(Node a){
        return a.id;
    }*/
    //class Node extdend Node{}
    //boolean isEmpty()用ArrayList的方法判断list空否

    public static int Search_Imfo(long num)
    {
        int i;
        for(i=0;i<List.size();i++)
        {
            Node student = List.get(i);
            if(student.num==num)return i;
        }
        return -1;
    }


    public static void InputStudentInfo(ArrayList<Node> List)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        long num = sc.nextLong();
        System.out.println("请输入学生姓名：");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("请输入学生性别：");
        sc.nextLine();
        String sex = sc.nextLine();
        System.out.println("请输入学生入学年份：");
        int EnterSchoolYear = sc.nextInt();
        System.out.println("请输入学生学制：");
        int SchoolSystem = sc.nextInt();
        System.out.println("请输入学生所属学院：");
        sc.nextLine();
        String college = sc.nextLine();
        System.out.println("请输入学生所学专业：");
        sc.nextLine();
        String major = sc.nextLine();
        System.out.println("请输入学生所在班级：");
        int cla = sc.nextInt();
        System.out.println("请输入学生身份证号码：");
        long id = sc.nextLong();
        Node student = new Node();
        student.num = num;
        student.name = name;
        student.sex = sex;
        student.EnterSchoolYear = EnterSchoolYear;
        student.SchoolSystem = SchoolSystem;
        student.college = college;
        student.major = major;
        student.cla = cla;
        student.id = id;
        List.add(student);
    }


    public static void AddStudentInfo(ArrayList<Node> List)
    {
        int i=1;
        int n=0;
        Scanner cin = new Scanner(System.in);
        while(i==1)
        {
            System.out.println("***开始录入学生证信息***\n");
            System.out.println("***如需返回菜单请输入0，继续录入请输入1***\n");
            i = cin.nextInt();
            if(i==0)break;
            InputStudentInfo(List);
            n++;
            System.out.println("***该学生学生证信息已录入完毕***\n");
            System.out.println("***如需返回菜单请输入0，继续录入请输入1***\n");
            i = cin.nextInt();
            if(i==0)break;
        }
        System.out.println("***"+n+"位学生的学生证信息已录入完毕***\n");
    }

    public static void ShowStuInfo()
    {
        Scanner cin = new Scanner(System.in);
        long num;
        int i,f=1;
        while(f==1)
        {
            System.out.println("***开始查询学生证信息***\n");
            System.out.println("***如需返回菜单请输入0，继续录入请输入1***\n");
            f = cin.nextInt();
            if(f==0)break;
            System.out.println("***请输入要查询学生的学号***\n");
            num = cin.nextLong();
            i = Search_Imfo(num);
            if(i==-1)System.out.println("***该学生证信息不存在，请确认是否输入准确***\n");
            else
            {
                Node student = List.get(i);
                System.out.println("该学生学号："+student.num);
                System.out.println("该学生姓名："+student.name);
                System.out.println("该学生性别："+student.sex);
                System.out.println("该学生入学年份："+student.EnterSchoolYear);
                System.out.println("该学生学制："+student.SchoolSystem+"年");
                System.out.println("该学生所属学院："+student.college);
                System.out.println("该学生所学专业："+student.major);
                System.out.println("该学生所在班级："+student.cla+"班");
                System.out.println("该学生身份证号码："+student.id);
            }
            System.out.println("***如需返回菜单请输入0，继续录入请输入1***\n");
            f = cin.nextInt();
            if(f==0)break;
        }
        System.out.println("***查询完毕***\n");
    }


    public static void menu1()
    {
        System.out.println("\n========主菜单=========\n|                     |");
        System.out.println("|  1.管理学生证信息   |");
        System.out.println("|                     |\n|  2.查询学生证信息   |");
        System.out.println("|                     |\n|  3.统计学生证信息   |");
        System.out.println("|                     |\n|   0.退出系统操作    |");
        System.out.println("|                     |\n=======================\n");
    }


    public static void menu2()
    {
        System.out.println("\n========管理学生证信息=========\n");
        System.out.println("       1.添加学生证信息");
        System.out.println("\n       2.修改学生证信息");
        System.out.println("\n       3.删除学生证信息");
        System.out.println("\n       4.保存学生证信息");
        System.out.println("\n        0.返回主菜单");
        System.out.println("\n===============================\n");
    }

    public static void menu3()
    {
        System.out.println("\n========查询学生证信息=========\n");
        System.out.println("     1.查询单个学生证信息");
        System.out.println("\n   2.查询班级全部学生证信息");
        System.out.println("\n        0.返回主菜单");
        System.out.println("\n===============================\n");
    }

    public static void SaveFile()
            throws IOException{
        int i;
        String path = "D:\\test\\student.txt";
        BufferedWriter out = new BufferedWriter(
                //new OutputStreamWriter(new FileOutputStream(path,true)));
        new OutputStreamWriter(new FileOutputStream(path)));
        for(i=0;i<List.size();i++)
        {
            Node student = List.get(i);
            out.write(student.name+ "\t");
            out.write(student.num+ "\t");
            out.write(student.sex+ "\t");
            out.write(student.EnterSchoolYear+ "\t");
            out.write(student.SchoolSystem+ "\t");
            out.write(student.college+ "\t");
            out.write(student.major+ "\t");
            out.write(student.cla+ "\t");
            out.write(student.id+ "\t");
        }
        out.close();
    }
    public static void getFile()
            throws FileNotFoundException {
        Scanner sc=new Scanner(new File("D:\\test\\student.txt"));
        while(sc.hasNextLine()) {
            Node student = new Node();
            student.num = sc.nextLong();
            student.name = sc.nextLine();
            student.sex = sc.nextLine();
            student.EnterSchoolYear = sc.nextInt();
            student.SchoolSystem = sc.nextInt();
            student.college = sc.nextLine();
            student.major = sc.nextLine();
            student.cla = sc.nextInt();
            student.id = sc.nextLong();
            List.add(student);
        }
        sc.close();
    }
    public static void main(String[] args)throws IOException {
        //ArrayList<Node> List = new ArrayList<Node>();
        //AddStudentInfo(List);
        int choice,c;
        Scanner cin = new Scanner(System.in);
        menu1();
        while(true)
        {
            System.out.println("请选择操作");
            choice = cin.nextInt();
            switch (choice)
            {
                case 1:menu2();
                while(true)
                {
                    System.out.println("请选择操作");
                    c = cin.nextInt();
                    switch (c) {
                        case 1:
                            AddStudentInfo(List);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            SaveFile();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("输入错误，请重新选择操作！");
                    }
                }
            }
            if(choice==0)break;
        }
    }
}
