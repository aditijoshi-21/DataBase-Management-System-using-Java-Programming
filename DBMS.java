package Project4;

import java.util.*;

class program10
{
    public static void main(String arg[])
    {
        DBMS obj = new DBMS();
        obj.StartDBMS();

        // obj.InsertIntoTable("Rahul", 23,89);
        // obj.InsertIntoTable("Sagar", 26,98);
        // obj.InsertIntoTable("Pooja", 20,56);
        // obj.InsertIntoTable("Sayali", 30,78);
        // obj.InsertIntoTable("Tejas", 29,68);

        // obj.SelectFrom();
        // obj.SelectFrom(4);
        // obj.SelectFrom("Tejas");

        // System.out.println("\nMaximum marks are: "+ obj.Aggregate_Max());
        // System.out.println("\nMinimum marks are: "+ obj.Aggregate_Min());
        // System.out.println("\nAddition of marks is: "+ obj.Aggregate_Sum());
        // System.out.println("\nAverage of marks is: "+ obj.Aggregate_Avg());

        // obj.DeleteFrom(4);
        // obj.SelectFrom();
    }
}

class Student
{
    public int Rno;
    public String Name;
    public int Age;
    public int Marks;

    public static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int X, int Y)
    {
        this.Rno = ++Generator;
        this.Name = str;
        this.Age = X;
        this.Marks = Y;
    }

    public void Display()
    {
        System.out.println(this.Rno + " " + this.Name + " " + this.Age + " " + this.Marks);
    }
}

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList <Student>();
    }

    public void StartDBMS()
    {
        System.out.println("DBMS started successfully...");
        System.out.println("Table Schema created successfully...");
        
        String Query;
        String Tokens[];

        Scanner sobj = new Scanner(System.in);
        int TokensCount = 0;

        while(true)
        {
            System.out.print("DBMS:> ");
            Query = sobj.nextLine();

            Tokens = Query.split(" ");

            TokensCount = Tokens.length;

            if(TokensCount == 1)
            {
                if("exit".equals(Tokens[0]))
                {
                    System.out.println("Thank you for Using DBMS...");
                    break;
                }
            }
            else if(TokensCount == 2)
            {}
            else if(TokensCount == 3)
            {}
            else if(TokensCount == 4)
            {
                if(("select".equals(Tokens[0])) && ("*".equals(Tokens[1])))
                {
                    SelectFrom();
                }

                if(("select".equals(Tokens[0])) && ("MAX(marks)".equals(Tokens[1])))
                {
                    System.out.println("Maximum marks are: "+ Aggregate_Max());
                }

                if(("select".equals(Tokens[0])) && ("MIN(marks)".equals(Tokens[1])))
                {
                    System.out.println("Minimum marks are: "+ Aggregate_Min());
                }

                if(("select".equals(Tokens[0])) && ("SUM(marks)".equals(Tokens[1])))
                {
                    System.out.println("Addition of marks is: "+ Aggregate_Sum());
                }

                if(("select".equals(Tokens[0])) && ("AVG(marks)".equals(Tokens[1])))
                {
                    System.out.println("Average of marks is: "+ Aggregate_Avg());
                }
            }
            else if(TokensCount == 5)
            {}
            else if(TokensCount == 6)
            {}
            else if(TokensCount == 7)
            {
                if("insert".equals(Tokens[0]))
                {
                    InsertIntoTable(Tokens[4], Integer.parseInt(Tokens[5]), Integer.parseInt(Tokens[6]));
                }

                if("delete".equals(Tokens[0]))
                {
                    DeleteFrom(Integer.parseInt(Tokens[6]));
                }
            }
            else if(TokensCount == 8)
            {
                if(("select".equals(Tokens[0])) && "rno".equals(Tokens[5]))
                {
                    SelectFrom(Integer.parseInt(Tokens[7]));
                }
                
                if(("select".equals(Tokens[0])) && "name".equals(Tokens[5]))
                {
                    SelectFrom(Tokens[7]);
                }
            }
        }    
    }

    // Insert into table student values(____, ____, ____);
    public void InsertIntoTable(String name, int age, int marks)
    {
        Student sobj = new Student(name, age, marks);
        lobj.add(sobj);
    }

    // Select * from student
    public void SelectFrom()
    {
        System.out.println("Records from the students database are: ");

        for(Student sref : lobj)
        {
            sref.Display();
        }
    }

    // Select * from student where rno = 11
    public void SelectFrom(int  no)
    {
        System.out.println("Records from the students database are: ");

        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                sref.Display();
                break;
            }
        }
    }

    // Select * from student where name = Sayali
    public void SelectFrom(String str)
    {
        System.out.println("Records from the students database are: ");

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.Display();
                break;
            }
        }
    }

    // delete from student where Rno = 2;
    public void DeleteFrom(int no)
    {
        int i = 0;
        
        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                lobj.remove(i);
                break;
            }
            i++;
        }
    }

    // select MAX(marks) from student
    public int Aggregate_Max()
    {
        Student temp = lobj.get(0);
        int iMax = temp.Marks;

        for(Student sref : lobj)
        {
            if(sref.Marks > iMax)
            {
                iMax = sref.Marks;
            }
        }
        return iMax;
    }

    // select MIN(marks) from student
    public int Aggregate_Min()
    {
        Student temp = lobj.get(0);
        int iMin = temp.Marks;

        for(Student sref : lobj)
        {
            if(sref.Marks < iMin)
            {
                iMin = sref.Marks;
            }
        }
        return iMin;
    }

    // select SUM(marks) from student
    public int Aggregate_Sum()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Marks;
        }
        return iSum;
    }

    // select AVG(marks) from student
    public float Aggregate_Avg()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Marks;
        }
        return (iSum / lobj.size());
    }
}



// Insert Query
// Insert into student values Rahul 23 67
//   0     1      2      3     4    5  6
// No of tokens = 7

// Select query 
// select * from student
//   0    1   2     3
// No of tokens: 4

// select * from student where rno = 4
//   0    1   2    3       4    5  6 7
// No of tokens: 8

// select * from student where name = Rahul
//   0    1   2    3       4    5   6  7
// No of tokens: 8

// select MAX(marks) from student
//   0        1       2     3
// No of tokens: 4

// delete from student where Rno = 2
//   0      1     2     3     4  5 6