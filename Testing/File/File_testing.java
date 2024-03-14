package Testing.File;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class File_addressing
{
    String fileName="/root/code/Lesson/a.txt";
    public void Reading()throws IOException
    {
        try (Scanner sc = new Scanner(new FileReader(fileName))) 
        {
            sc.useDelimiter(",");
            while (sc.hasNext()) 
            {  //按行读取字符串
               String line = sc.next();
               System.out.println(line);
            }
        }
    }
    public void Writing()throws IOException
    {
        try(BufferedWriter sc=new  BufferedWriter(new FileWriter(fileName,true)))
        {
            sc.write("\nabc");
            sc.close();
        }
    }
}

public class File_testing 
{
    public static void main(String[] args) throws IOException 
    {
        File_addressing t=new File_addressing();
        t.Reading();
    }
}