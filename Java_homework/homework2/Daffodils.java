public class Daffodils {
    public static void main(String[] args) {
        int j=0;
        for(int i=100;i<=999;i++){
            if(new Checking().checking(i)){
                System.out.print(i+" ");
                if(j==1)System.out.print("\n");
                j+=1;
            }
        }
    }
}

class Checking{
    public boolean checking(int num){
        int a=num/100;
        int b=num/10%10;
        int c=num%10;
        if(Math.pow(a, 3)+Math.pow(b, 3)+Math.pow(c, 3)==num)return true;
        return false;
    }
}