public class FlourCount {
    public static void main(String[] args) {

        canPack(1, 0   , 4);

    }
    public static boolean canPack(int bigCount, int smallCount, int goal){

        int actualPack = 0;


        for(int i = 0; i < bigCount; i++){

            if((actualPack + 5) <= goal){

                actualPack += 5;
            }

        }




        for(int i = 0; i < smallCount; i++){

            if((actualPack + 1) <= goal){

                actualPack += 1;
            }

        }
        if(actualPack == 0) return  false;
        return (actualPack >= goal);

    }
}
