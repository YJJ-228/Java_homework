public class MonkeyKing {
    public static void main(String[] args) {
        int [] monkey={1,2,3,4,5,6,7,8,9,10};
        int index=0; //当前猴子序号-1(从零开始)
        int num=1; //当前猴子报号
        int out=0; //出队猴子数量
        int king=0; 
        while(out!=monkey.length){
            if(num!=3&&monkey[index]!=0){  
                num++;
                index++;
            }
            else if(monkey[index]==0){
                index++;
            }
            else{                   //如果满3，出队，num归0，记录当前猴子
                System.out.printf("第%d只猴子出列\n",index+1);
                king=index+1;
                out++;
                monkey[index]=0;
                num=1;
                index++;
                }
            if(index==monkey.length){
                index=0;
            }
        }
        System.out.printf("猴子王是第%d只猴子",king);
    }
}
