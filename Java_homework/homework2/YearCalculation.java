import java.util.Scanner;

public class YearCalculation{
    public static void main(String[] args) {
        int[] data=new Inputing_information().inputings();

        //int day1=new Calculation().calculating_switch(data[0],data[1]);
        int day2=new Calculation().calculating_datagroup(data[0],data[1]); 
        System.out.println(day2);
    }
}

class Inputing_information{

    int[] data=new int[3];
    public int [] inputings(){
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Input year is:");
            data[0]=scan.nextInt();
            System.out.println("Input month is:");
            data[1]=scan.nextInt();
        }
        return data;
    }
}

class Calculation{
    public int calculating_switch(int y,int m){
        int day=-1;

        switch (m) {
            case 1:
                day=31;
                break;
            case 2:
                if(y%4==0)day=29;
                else day=28;
                break;
            case 3:
                day=31;
                break;
            case 4:
                day=30;
                break;
            case 5:
                day=31;
                break;   
            case 6:
                day=30;
                break;
            case 7:
                day=31;
                break;
            case 8:
                day=31;
                break; 
            case 9:
                day=30;
                break; 
            case 10:
                day=31;
            case 11:
                day=30;
            case 12:
                day=31;           
            default:
                System.out.println("输入数据错误！");
                break;
        }
        return day;
    }

    public int calculating_datagroup(int y,int m){
        int[] data={31,28,31,30,31,30,31,31,30,31,30};
        if(y%4==0)data[1]=29;
        return data[m-1];
    }
}



    

