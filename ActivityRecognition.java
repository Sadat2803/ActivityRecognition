package activityrecognition;
import java.io.*;
import java.util.*;
public class ActivityRecognition {
        //FUNTION USED TO RETURN THE NUMBER OF LIGNES IN THE CSV FILE
         public static int nbLignesInCsv(File file ) throws FileNotFoundException
        {
           Scanner scanner = new Scanner(file);
           int nblignes = 0;
           while(scanner.hasNext())
           {
               //System.out.println("counting"+(nblignes+1)+" lignes");
               scanner.next();
               nblignes++;
           }
           scanner.close();
           return nblignes;
        }
        //FUNTION USED TO COPY THE DATA FROM CSV TO ARRAYLIST MEMORY STRUCTURE
        public static void getDataFromFile(ArrayList<String>[] data, File file ) throws FileNotFoundException
        {
            Scanner scanner = new Scanner(file);
            int nblignes = 0;
            while(scanner.hasNext())
            {
                String line = scanner.next();
                String[] columns = line.split(";");
                System.out.println("Ligne number "+(nblignes+1)+": ");
                //System.out.println(Arrays.asList(columns));
                data[nblignes] = new ArrayList(Arrays.asList(columns));
                System.out.println(data[nblignes]);        
                nblignes++;
            }
        }
        //FUNCTION THAT CALCULATES THE EUCLIDIAN BETWEEN TWO VECTOR IN 3D SPACE
        public static Double euclidianDistance(Double xv1 , Double yv1 ,Double zv1 ,Double xv2 ,Double yv2 ,Double zv2)
        {
            return Math.sqrt( Math.pow(xv2-xv1,2)+Math.pow(yv2-yv1,2)+Math.pow(zv2-zv1,2) );
        }
        //FUNCTION THAT GENERATES THE 27 DIRECTION VECTORS USING THE COORDINATE GIVE AS INPUT
        public static Double[][] generateDirectionVectors(Double x, Double y, Double z)
        {
           /*Double table[][]= {
                            {10.5,10.0,10.9},{5.0,1.5,8.8},
                            {0.0,1.8,5.0},{0.4,1.5,0.0},{0.0,1.0,0.0}
                            ,{0.0,5.0,0.0},{2.0,1.6,0.0},{0.0,0.0,0.9},{4.0,1.0,9.0},{0.4,1.8,0.2},{6.0,1.0,0.9},{4.2,1.6,0.0},
                            {0.0,1.0,0.0},{0.0,1.0,0.8},{0.8,1.0,7.0},{0.0,1.0,6.0},
                            {2.0,1.0,5.0},{8.0,1.0,0.0},{1.0,2.0,1.0},{0.7,1.0,0.9},{0.2,1.0,0.0},{0.4,1.9,0.0},{0.2,1.0,0.4},
                            {5.0,1.5,0.0},{0.0,1.2,0.0},{6.7,1.0,6.0},{0.7,1.7,7.0}
                                       };*/
          Double directionVectors[][]=new Double[27][3]; 
          directionVectors[0][0] = 0.0;
directionVectors[0][1] = 0.0;
directionVectors[0][2] = 0.005;
directionVectors[1][0] = 0.0;
directionVectors[1][1] = 0.0;
directionVectors[1][2] = -0.005;
directionVectors[2][0] = 0.0;
directionVectors[2][1] = 0.005;
directionVectors[2][2] = 0.0;
directionVectors[3][0] = 0.0;
directionVectors[3][1] = -0.005;
directionVectors[3][2] = 0.0;
directionVectors[4][0] = 0.005;
directionVectors[4][1] = 0.0;
directionVectors[4][2] = 0.0;
directionVectors[5][0] = -0.005;
directionVectors[5][1] = 0.0;
directionVectors[5][2] = 0.0;
directionVectors[6][0] = 0.005;
directionVectors[6][1] = 0.0;
directionVectors[6][2] = 0.005;
directionVectors[7][0] = -0.005;
directionVectors[7][1] = 0.0;
directionVectors[7][2] = 0.005;
directionVectors[8][0] = -0.005;
directionVectors[8][1] = 0.0;
directionVectors[8][2] = -0.005;
directionVectors[9][0] = 0.005;
directionVectors[9][1] = 0.0;
directionVectors[9][2] = -0.005;
directionVectors[10][0] =0.005;
directionVectors[10][1] = -0.005;
directionVectors[10][2] = -0.005;
directionVectors[11][0] = 0.0;
directionVectors[11][1] = -0.005;
directionVectors[11][2] = -0.005;
directionVectors[12][0] = -0.005;
directionVectors[12][1] = -0.005;
directionVectors[12][2] = -0.005;
directionVectors[13][0] = -0.005;
directionVectors[13][1] = -0.005;
directionVectors[13][2] = 0.0;
directionVectors[14][0] = -0.005;
directionVectors[14][1] = -0.005;
directionVectors[14][2] = 0.005;
directionVectors[15][0] = 0.0;
directionVectors[15][1] = -0.005;
directionVectors[15][2] = 0.005;
directionVectors[16][0] = 0.005;
directionVectors[16][1] = -0.005;
directionVectors[16][2] = 0.005;
directionVectors[17][0] = 0.005;
directionVectors[17][1] = -0.005;
directionVectors[17][2] = 0.0;
directionVectors[18][0] = 0.005;
directionVectors[18][1] = 0.005;
directionVectors[18][2] = -0.005;
directionVectors[19][0] = 0.0;
directionVectors[19][1] = 0.005;
directionVectors[19][2] = -0.005;
directionVectors[20][0] = -0.005;
directionVectors[20][1] = 0.005;
directionVectors[20][2] = -0.005;
directionVectors[21][0] = -0.005;
directionVectors[21][1] = 0.005;
directionVectors[21][2] = 0.005;
directionVectors[22][0] = -0.005;
directionVectors[22][1] = 0.005;
directionVectors[22][2] = 0.0;
directionVectors[23][0] = 0.0;
directionVectors[23][1] = 0.005;
directionVectors[23][2] = 0.005;
directionVectors[24][0] = 0.005;
directionVectors[24][1] = 0.005;
directionVectors[24][2] = 0.005;
directionVectors[25][0] = 0.005;
directionVectors[25][1] = 0.005;
directionVectors[25][2] = 0.0;
directionVectors[26][0] = 0.0;
directionVectors[26][1] = 0.0;
directionVectors[26][2] = 0.0;
          return directionVectors;
        }
        //FUNCTION RETURNING THE INDEX OF THE CLOSEST PRIMARY VECTOR TO THE DIRECTION VECTOR
        public static int closestDirectionVectorIndex(Double X,Double Y, Double Z, Double[][] directionsVector)
        {
            int minq= 0 ;
            Double minDistance =  0.0;
            minDistance = euclidianDistance(X,Y,Z,directionsVector[0][0],directionsVector[0][1],directionsVector[0][2]);
            for(int i=1; i<directionsVector.length;i++)
            {
               if(euclidianDistance(X,Y,Z,directionsVector[i][0],directionsVector[i][1],directionsVector[i][2])<minDistance)
               {
                   minDistance = euclidianDistance(X,Y,Z,directionsVector[i][0],directionsVector[i][1],directionsVector[i][2]);
                   minq = i;
               }
            }
            return minq;
        }
        
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("/Users/mac/NetBeansProjects/ActivityRecognition/src/dataset.csv"); 

        ArrayList<String>[] data = new ArrayList[nbLignesInCsv(file)] ;

        getDataFromFile(data , file);
        /**************************************INDEX OF RH JOINT COORDINATES*************************************/
        int RH_X_1 = data[0].indexOf("T(1)_RH_X");
        int RH_Y_1 = data[0].indexOf("T(1)_RH_Y");
        int RH_Z_1 = data[0].indexOf("T(1)_RH_Z");

        System.out.println("index of T(1)_RH_X : "+RH_X_1);
        System.out.println("index of T(1)_RH_Y : "+RH_Y_1);
        System.out.println("index of T(1)_RH_Z : "+RH_Z_1);

        int RH_X_2 = data[0].indexOf("T(2)_RH_X");
        int RH_Y_2 = data[0].indexOf("T(2)_RH_Y");
        int RH_Z_2 = data[0].indexOf("T(2)_RH_Z");

        System.out.println("index of T(2)_RH_X : "+RH_X_2);
        System.out.println("index of T(2)_RH_Y : "+RH_Y_2);
        System.out.println("index of T(2)_RH_Z : "+RH_Z_2);

        int RH_X_3 = data[0].indexOf("T(3)_RH_X");
        int RH_Y_3 = data[0].indexOf("T(3)_RH_Y");
        int RH_Z_3 = data[0].indexOf("T(3)_RH_Z");

        System.out.println("index of T(3)_RH_X : "+RH_X_3);
        System.out.println("index of T(3)_RH_Y : "+RH_Y_3);
        System.out.println("index of T(3)_RH_Z : "+RH_Z_3);

        int RH_X_4 = data[0].indexOf("T(4)_RH_X");
        int RH_Y_4 = data[0].indexOf("T(4)_RH_Y");
        int RH_Z_4 = data[0].indexOf("T(4)_RH_Z");

        System.out.println("index of T(4)_RH_X : "+RH_X_4);
        System.out.println("index of T(4)_RH_Y : "+RH_Y_4);
        System.out.println("index of T(4)_RH_Z : "+RH_Z_4);

        /**************************************INDEX OF LH JOINT COORDINATES*************************************/
        int LH_X_1 = data[0].indexOf("T(1)_LH_X");
        int LH_Y_1 = data[0].indexOf("T(1)_LH_Y");
        int LH_Z_1 = data[0].indexOf("T(1)_LH_Z");

        System.out.println("index of T(1)_LH_X : "+LH_X_1);
        System.out.println("index of T(1)_LH_Y : "+LH_Y_1);
        System.out.println("index of T(1)_LH_Z : "+LH_Z_1);

        int LH_X_2 = data[0].indexOf("T(2)_LH_X");
        int LH_Y_2 = data[0].indexOf("T(2)_LH_Y");
        int LH_Z_2 = data[0].indexOf("T(2)_LH_Z");

        System.out.println("index of T(2)_LH_X : "+LH_X_2);
        System.out.println("index of T(2)_LH_Y : "+LH_Y_2);
        System.out.println("index of T(2)_LH_Z : "+LH_Z_2);

        int LH_X_3 = data[0].indexOf("T(3)_LH_X");
        int LH_Y_3 = data[0].indexOf("T(3)_LH_Y");
        int LH_Z_3 = data[0].indexOf("T(3)_LH_Z");

        System.out.println("index of T(3)_LH_X : "+LH_X_3);
        System.out.println("index of T(3)_LH_Y : "+LH_Y_3);
        System.out.println("index of T(3)_LH_Z : "+LH_Z_3);

        int LH_X_4 = data[0].indexOf("T(4)_LH_X");
        int LH_Y_4 = data[0].indexOf("T(4)_LH_Y");
        int LH_Z_4 = data[0].indexOf("T(4)_LH_Z");

        System.out.println("index of T(4)_LH_X : "+LH_X_4);
        System.out.println("index of T(4)_LH_Y : "+LH_Y_4);
        System.out.println("index of T(4)_LH_Z : "+LH_Z_4);
        /**************************************INDEX OF TS JOINT COORDINATES*************************************/

        int TS_X_1 = data[0].indexOf("T(1)_TS%cptr_X");
        int TS_Y_1 = data[0].indexOf("T(1)_TS%cptr_Y");
        int TS_Z_1 = data[0].indexOf("T(1)_TS%cptr_Z");

        System.out.println("index of T(1)_TS_X : "+TS_X_1);
        System.out.println("index of T(1)_TS_Y : "+TS_Y_1);
        System.out.println("index of T(1)_TS_Z : "+TS_Z_1);

        int TS_X_2 = data[0].indexOf("T(2)_TS%cptr_X");
        int TS_Y_2 = data[0].indexOf("T(2)_TS%cptr_Y");
        int TS_Z_2 = data[0].indexOf("T(2)_TS%cptr_Z");

        System.out.println("index of T(2)_TS_X : "+TS_X_2);
        System.out.println("index of T(2)_TS_Y : "+TS_Y_2);
        System.out.println("index of T(2)_TS_Z : "+TS_Z_2);

        int TS_X_3 = data[0].indexOf("T(3)_TS%cptr_X");
        int TS_Y_3 = data[0].indexOf("T(3)_TS%cptr_Y");
        int TS_Z_3 = data[0].indexOf("T(3)_TS%cptr_Z");

        System.out.println("index of T(3)_TS_X : "+TS_X_3);
        System.out.println("index of T(3)_TS_Y : "+TS_Y_3);
        System.out.println("index of T(3)_TS_Z : "+TS_Z_3);

        int TS_X_4 = data[0].indexOf("T(4)_TS%cptr_X");
        int TS_Y_4 = data[0].indexOf("T(4)_TS%cptr_Y");
        int TS_Z_4 = data[0].indexOf("T(4)_TS%cptr_Z");

        System.out.println("index of T(4)_TS_X : "+TS_X_4);
        System.out.println("index of T(4)_TS_Y : "+TS_Y_4);
        System.out.println("index of T(4)_TS_Z : "+TS_Z_4);

        /**************************************INDEX OF Relw JOINT COORDINATES*************************************/

        int Relw_X_1 = data[0].indexOf("T(1)_Relw_X");
        int Relw_Y_1 = data[0].indexOf("T(1)_Relw_Y");
        int Relw_Z_1 = data[0].indexOf("T(1)_Relw_Z");

        System.out.println("index of T(1)_Relw_X : "+Relw_X_1);
        System.out.println("index of T(1)_Relw_Y : "+Relw_Y_1);
        System.out.println("index of T(1)_Relw_Z : "+Relw_Z_1);

        int Relw_X_2 = data[0].indexOf("T(2)_Relw_X");
        int Relw_Y_2 = data[0].indexOf("T(2)_Relw_Y");
        int Relw_Z_2 = data[0].indexOf("T(2)_Relw_Z");

        System.out.println("index of T(2)_Relw_X : "+Relw_X_2);
        System.out.println("index of T(2)_Relw_Y : "+Relw_Y_2);
        System.out.println("index of T(2)_Relw_Z : "+Relw_Z_2);

        int Relw_X_3 = data[0].indexOf("T(3)_Relw_X");
        int Relw_Y_3 = data[0].indexOf("T(3)_Relw_Y");
        int Relw_Z_3 = data[0].indexOf("T(3)_Relw_Z");

        System.out.println("index of T(3)_Relw_X : "+Relw_X_3);
        System.out.println("index of T(3)_Relw_Y : "+Relw_Y_3);
        System.out.println("index of T(3)_Relw_Z : "+Relw_Z_3);

        int Relw_X_4 = data[0].indexOf("T(4)_Relw_X");
        int Relw_Y_4 = data[0].indexOf("T(4)_Relw_Y");
        int Relw_Z_4 = data[0].indexOf("T(4)_Relw_Z");

        System.out.println("index of T(4)_Relw_X : "+Relw_X_4);
        System.out.println("index of T(4)_Relw_Y : "+Relw_Y_4);
        System.out.println("index of T(4)_Relw_Z : "+Relw_Z_4);

        /**************************************INDEX OF Lelm JOINT COORDINATES*************************************/

        int Lelm_X_1 = data[0].indexOf("T(1)_Lelm_X");
        int Lelm_Y_1 = data[0].indexOf("T(1)_Lelm_Y");
        int Lelm_Z_1 = data[0].indexOf("T(1)_Lelm_Z");

        System.out.println("index of T(1)_Lelm_X : "+Lelm_X_1);
        System.out.println("index of T(1)_Lelm_Y : "+Lelm_Y_1);
        System.out.println("index of T(1)_Lelm_Z : "+Lelm_Z_1);

        int Lelm_X_2 = data[0].indexOf("T(2)_Lelm_X");
        int Lelm_Y_2 = data[0].indexOf("T(2)_Lelm_Y");
        int Lelm_Z_2 = data[0].indexOf("T(2)_Lelm_Z");

        System.out.println("index of T(2)_Lelm_X : "+Lelm_X_2);
        System.out.println("index of T(2)_Lelm_Y : "+Lelm_Y_2);
        System.out.println("index of T(2)_Lelm_Z : "+Lelm_Z_2);

        int Lelm_X_3 = data[0].indexOf("T(3)_Lelm_X");
        int Lelm_Y_3 = data[0].indexOf("T(3)_Lelm_Y");
        int Lelm_Z_3 = data[0].indexOf("T(3)_Lelm_Z");

        System.out.println("index of T(3)_Lelm_X : "+Lelm_X_3);
        System.out.println("index of T(3)_Lelm_Y : "+Lelm_Y_3);
        System.out.println("index of T(3)_Lelm_Z : "+Lelm_Z_3);

        int Lelm_X_4 = data[0].indexOf("T(4)_Lelm_X");
        int Lelm_Y_4 = data[0].indexOf("T(4)_Lelm_Y");
        int Lelm_Z_4 = data[0].indexOf("T(4)_Lelm_Z");

        System.out.println("index of T(4)_Lelm_X : "+Lelm_X_4);
        System.out.println("index of T(4)_Lelm_Y : "+Lelm_Y_4);
        System.out.println("index of T(4)_Lelm_Z : "+Lelm_Z_4);

        /**************************************INDEX OF head JOINT COORDINATES*************************************/
        int head_X_1 = data[0].indexOf("T(1)_head_X");
        int head_Y_1 = data[0].indexOf("T(1)_head_Y");
        int head_Z_1 = data[0].indexOf("T(1)_head_Z");

        System.out.println("index of T(1)_head_X : "+head_X_1);
        System.out.println("index of T(1)_head_Y : "+head_Y_1);
        System.out.println("index of T(1)_head_Z : "+head_Z_1);

        int head_X_2 = data[0].indexOf("T(2)_head_X");
        int head_Y_2 = data[0].indexOf("T(2)_head_Y");
        int head_Z_2 = data[0].indexOf("T(2)_head_Z");

        System.out.println("index of T(2)_head_X : "+head_X_2);
        System.out.println("index of T(2)_head_Y : "+head_Y_2);
        System.out.println("index of T(2)_head_Z : "+head_Z_2);

        int head_X_3 = data[0].indexOf("T(3)_head_X");
        int head_Y_3 = data[0].indexOf("T(3)_head_Y");
        int head_Z_3 = data[0].indexOf("T(3)_head_Z");

        System.out.println("index of T(3)_head_X : "+head_X_3);
        System.out.println("index of T(3)_head_Y : "+head_Y_3);
        System.out.println("index of T(3)_head_Z : "+head_Z_3);

        int head_X_4 = data[0].indexOf("T(4)_head_X");
        int head_Y_4 = data[0].indexOf("T(4)_head_Y");
        int head_Z_4 = data[0].indexOf("T(4)_head_Z");

        System.out.println("index of T(4)_head_X : "+head_X_4);
        System.out.println("index of T(4)_head_Y : "+head_Y_4);
        System.out.println("index of T(4)_head_Z : "+head_Z_4);

        /**************************************INDEX OF neck JOINT COORDINATES*************************************/

        int neck_X_1 = data[0].indexOf("T(1)_neck_X");
        int neck_Y_1 = data[0].indexOf("T(1)_neck_Y");
        int neck_Z_1 = data[0].indexOf("T(1)_neck_Z");

        System.out.println("index of T(1)_neck_X : "+neck_X_1);
        System.out.println("index of T(1)_neck_Y : "+neck_Y_1);
        System.out.println("index of T(1)_neck_Z : "+neck_Z_1);

        int neck_X_2 = data[0].indexOf("T(2)_neck_X");
        int neck_Y_2 = data[0].indexOf("T(2)_neck_Y");
        int neck_Z_2 = data[0].indexOf("T(2)_neck_Z");

        System.out.println("index of T(2)_neck_X : "+neck_X_2);
        System.out.println("index of T(2)_neck_Y : "+neck_Y_2);
        System.out.println("index of T(2)_neck_Z : "+neck_Z_2);

        int neck_X_3 = data[0].indexOf("T(3)_neck_X");
        int neck_Y_3 = data[0].indexOf("T(3)_neck_Y");
        int neck_Z_3 = data[0].indexOf("T(3)_neck_Z");

        System.out.println("index of T(3)_neck_X : "+neck_X_3);
        System.out.println("index of T(3)_neck_Y : "+neck_Y_3);
        System.out.println("index of T(3)_neck_Z : "+neck_Z_3);

        int neck_X_4 = data[0].indexOf("T(4)_neck_X");
        int neck_Y_4 = data[0].indexOf("T(4)_neck_Y");
        int neck_Z_4 = data[0].indexOf("T(4)_neck_Z");

        System.out.println("index of T(4)_neck_X : "+neck_X_4);
        System.out.println("index of T(4)_neck_Y : "+neck_Y_4);
        System.out.println("index of T(4)_neck_Z : "+neck_Z_4);
        /**************************************INDEX OF Lshdr JOINT COORDINATES*************************************/
        int Lshdr_X_1 = data[0].indexOf("T(1)_Lshdr_X");
        int Lshdr_Y_1 = data[0].indexOf("T(1)_Lshdr_Y");
        int Lshdr_Z_1 = data[0].indexOf("T(1)_Lshdr_Z");

        System.out.println("index of T(1)_Lshdr_X : "+Lshdr_X_1);
        System.out.println("index of T(1)_Lshdr_Y : "+Lshdr_Y_1);
        System.out.println("index of T(1)_Lshdr_Z : "+Lshdr_Z_1);

        int Lshdr_X_2 = data[0].indexOf("T(2)_Lshdr_X");
        int Lshdr_Y_2 = data[0].indexOf("T(2)_Lshdr_Y");
        int Lshdr_Z_2 = data[0].indexOf("T(2)_Lshdr_Z");

        System.out.println("index of T(2)_Lshdr_X : "+Lshdr_X_2);
        System.out.println("index of T(2)_Lshdr_Y : "+Lshdr_Y_2);
        System.out.println("index of T(2)_Lshdr_Z : "+Lshdr_Z_2);

        int Lshdr_X_3 = data[0].indexOf("T(3)_Lshdr_X");
        int Lshdr_Y_3 = data[0].indexOf("T(3)_Lshdr_Y");
        int Lshdr_Z_3 = data[0].indexOf("T(3)_Lshdr_Z");

        System.out.println("index of T(3)_Lshdr_X : "+Lshdr_X_3);
        System.out.println("index of T(3)_Lshdr_Y : "+Lshdr_Y_3);
        System.out.println("index of T(3)_Lshdr_Z : "+Lshdr_Z_3);

        int Lshdr_X_4 = data[0].indexOf("T(4)_Lshdr_X");
        int Lshdr_Y_4 = data[0].indexOf("T(4)_Lshdr_Y");
        int Lshdr_Z_4 = data[0].indexOf("T(4)_Lshdr_Z");

        System.out.println("index of T(4)_Lshdr_X : "+Lshdr_X_4);
        System.out.println("index of T(4)_Lshdr_Y : "+Lshdr_Y_4);
        System.out.println("index of T(4)_Lshdr_Z : "+Lshdr_Z_4);
        /**************************************INDEX OF Rshdr JOINT COORDINATES*************************************/
        int Rshdr_X_1 = data[0].indexOf("T(1)_Rshdr_X");
        int Rshdr_Y_1 = data[0].indexOf("T(1)_Rshdr_Y");
        int Rshdr_Z_1 = data[0].indexOf("T(1)_Rshdr_Z");

        System.out.println("index of T(1)_Rshdr_X : "+Rshdr_X_1);
        System.out.println("index of T(1)_Rshdr_Y : "+Rshdr_Y_1);
        System.out.println("index of T(1)_Rshdr_Z : "+Rshdr_Z_1);

        int Rshdr_X_2 = data[0].indexOf("T(2)_Rshdr_X");
        int Rshdr_Y_2 = data[0].indexOf("T(2)_Rshdr_Y");
        int Rshdr_Z_2 = data[0].indexOf("T(2)_Rshdr_Z");

        System.out.println("index of T(2)_Rshdr_X : "+Rshdr_X_2);
        System.out.println("index of T(2)_Rshdr_Y : "+Rshdr_Y_2);
        System.out.println("index of T(2)_Rshdr_Z : "+Rshdr_Z_2);

        int Rshdr_X_3 = data[0].indexOf("T(3)_Rshdr_X");
        int Rshdr_Y_3 = data[0].indexOf("T(3)_Rshdr_Y");
        int Rshdr_Z_3 = data[0].indexOf("T(3)_Rshdr_Z");

        System.out.println("index of T(3)_Rshdr_X : "+Rshdr_X_3);
        System.out.println("index of T(3)_Rshdr_Y : "+Rshdr_Y_3);
        System.out.println("index of T(3)_Rshdr_Z : "+Rshdr_Z_3);

        int Rshdr_X_4 = data[0].indexOf("T(4)_Rshdr_X");
        int Rshdr_Y_4 = data[0].indexOf("T(4)_Rshdr_Y");
        int Rshdr_Z_4 = data[0].indexOf("T(4)_Rshdr_Z");

        System.out.println("index of T(4)_Rshdr_X : "+Rshdr_X_4);
        System.out.println("index of T(4)_Rshdr_Y : "+Rshdr_Y_4);
        System.out.println("index of T(4)_Rshdr_Z : "+Rshdr_Z_4);
 /*****************************************************************************************************************/
 /**************************************************************************************************************************************************************/
       for(int cpt =1 ; cpt <data.length ; cpt++)
       {
            //GENERATING THE HISTOGRAMME OF DIRECTIONS FOR EACH LINE
            int H[][] = new int[9][27];//Vector used to memorise directions taken by joints, it is used to create the histogramme of direction vectors
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            Double dv1[][] = generateDirectionVectors(Double.parseDouble(data[cpt].get(RH_X_1)),Double.parseDouble(data[cpt].get(RH_Y_1)),Double.parseDouble(data[cpt].get(RH_Z_1)));
            Double dv2[][] = generateDirectionVectors(Double.parseDouble(data[cpt].get(RH_X_2)),Double.parseDouble(data[cpt].get(RH_Y_2)),Double.parseDouble(data[cpt].get(RH_Z_2)));
            Double dv3[][] = generateDirectionVectors(Double.parseDouble(data[cpt].get(RH_X_3)),Double.parseDouble(data[cpt].get(RH_Y_3)),Double.parseDouble(data[cpt].get(RH_Z_3)));
            int h[] = new int[27] ;
            int q = 0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT RH 
            Double RH_V1_X = Double.parseDouble(data[cpt].get(RH_X_2))-Double.parseDouble(data[cpt].get(RH_X_1));
            Double RH_V1_Y = Double.parseDouble(data[cpt].get(RH_Y_2))-Double.parseDouble(data[cpt].get(RH_Y_1));
            Double RH_V1_Z = Double.parseDouble(data[cpt].get(RH_Z_2))-Double.parseDouble(data[cpt].get(RH_Z_1));
            q = closestDirectionVectorIndex(RH_V1_X,RH_V1_Y,RH_V1_Z,dv1);
            h[q]++;
            Double RH_V2_X = Double.parseDouble(data[cpt].get(RH_X_3))-Double.parseDouble(data[cpt].get(RH_X_2));
            Double RH_V2_Y = Double.parseDouble(data[cpt].get(RH_Y_3))-Double.parseDouble(data[cpt].get(RH_Y_2));
            Double RH_V2_Z = Double.parseDouble(data[cpt].get(RH_Z_3))-Double.parseDouble(data[cpt].get(RH_Z_2));
            q = closestDirectionVectorIndex(RH_V2_X,RH_V2_Y,RH_V2_Z,dv2);
            h[q]++;
            Double RH_V3_X = Double.parseDouble(data[cpt].get(RH_X_4))-Double.parseDouble(data[cpt].get(RH_X_3));
            Double RH_V3_Y = Double.parseDouble(data[cpt].get(RH_Y_4))-Double.parseDouble(data[cpt].get(RH_Y_3));
            Double RH_V3_Z = Double.parseDouble(data[cpt].get(RH_Z_4))-Double.parseDouble(data[cpt].get(RH_Z_3));
            q = closestDirectionVectorIndex(RH_V3_X,RH_V3_Y,RH_V3_Z,dv3);
            h[q]++;
            for(int j = 0;j<h.length;j++)
            {
               System.out.println("h["+j+"] == : "+h[j]);
            }
            H[0]=h;
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####      
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            dv1 = generateDirectionVectors(Double.parseDouble(data[cpt].get(LH_X_1)),Double.parseDouble(data[cpt].get(LH_Y_1)),Double.parseDouble(data[cpt].get(LH_Z_1)));
            dv2 = generateDirectionVectors(Double.parseDouble(data[cpt].get(LH_X_2)),Double.parseDouble(data[cpt].get(LH_Y_2)),Double.parseDouble(data[cpt].get(LH_Z_2)));
            dv3 = generateDirectionVectors(Double.parseDouble(data[cpt].get(LH_X_3)),Double.parseDouble(data[cpt].get(LH_Y_3)),Double.parseDouble(data[cpt].get(LH_Z_3)));      
            h= new int[27] ;
            q=0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT LH

            Double LH_V1_X = Double.parseDouble(data[cpt].get(LH_X_2))-Double.parseDouble(data[cpt].get(LH_X_1));
            Double LH_V1_Y = Double.parseDouble(data[cpt].get(LH_Y_2))-Double.parseDouble(data[cpt].get(LH_Y_1));
            Double LH_V1_Z = Double.parseDouble(data[cpt].get(LH_Z_2))-Double.parseDouble(data[cpt].get(LH_Z_1));
            q = closestDirectionVectorIndex(LH_V1_X,LH_V1_Y,LH_V1_Z,dv1);
            h[q]++;
            Double LH_V2_X = Double.parseDouble(data[cpt].get(LH_X_3))-Double.parseDouble(data[cpt].get(LH_X_2));
            Double LH_V2_Y = Double.parseDouble(data[cpt].get(LH_Y_3))-Double.parseDouble(data[cpt].get(LH_Y_2));
            Double LH_V2_Z = Double.parseDouble(data[cpt].get(LH_Z_3))-Double.parseDouble(data[cpt].get(LH_Z_2));
            q = closestDirectionVectorIndex(LH_V2_X,LH_V2_Y,LH_V2_Z,dv2);
            h[q]++;
            Double LH_V3_X = Double.parseDouble(data[cpt].get(LH_X_4))-Double.parseDouble(data[cpt].get(LH_X_3));
            Double LH_V3_Y = Double.parseDouble(data[cpt].get(LH_Y_4))-Double.parseDouble(data[cpt].get(LH_Y_3));
            Double LH_V3_Z = Double.parseDouble(data[cpt].get(LH_Z_4))-Double.parseDouble(data[cpt].get(LH_Z_3));
            q = closestDirectionVectorIndex(LH_V3_X,LH_V3_Y,LH_V3_Z,dv3);
            h[q]++;
            System.out.println("#########@");
            for(int j = 0;j<h.length;j++)
            {
               System.out.println("h["+j+"] == : "+h[j]);
            }
            H[1]=h;
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####     
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            dv1 = generateDirectionVectors(Double.parseDouble(data[cpt].get(TS_X_1)),Double.parseDouble(data[cpt].get(TS_Y_1)),Double.parseDouble(data[cpt].get(TS_Z_1)));
            dv2 = generateDirectionVectors(Double.parseDouble(data[cpt].get(TS_X_2)),Double.parseDouble(data[cpt].get(TS_Y_2)),Double.parseDouble(data[cpt].get(TS_Z_2)));
            dv3 = generateDirectionVectors(Double.parseDouble(data[cpt].get(TS_X_3)),Double.parseDouble(data[cpt].get(TS_Y_3)),Double.parseDouble(data[cpt].get(TS_Z_3)));      
            h= new int[27] ;
            q=0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT TS
            Double TS_V1_X = Double.parseDouble(data[cpt].get(TS_X_2))-Double.parseDouble(data[cpt].get(TS_X_1));
            Double TS_V1_Y = Double.parseDouble(data[cpt].get(TS_Y_2))-Double.parseDouble(data[cpt].get(TS_Y_1));
            Double TS_V1_Z = Double.parseDouble(data[cpt].get(TS_Z_2))-Double.parseDouble(data[cpt].get(TS_Z_1));
            q = closestDirectionVectorIndex(TS_V1_X,TS_V1_Y,TS_V1_Z,dv1);
            h[q]++;
            Double TS_V2_X = Double.parseDouble(data[cpt].get(TS_X_3))-Double.parseDouble(data[cpt].get(TS_X_2));
            Double TS_V2_Y = Double.parseDouble(data[cpt].get(TS_Y_3))-Double.parseDouble(data[cpt].get(TS_Y_2));
            Double TS_V2_Z = Double.parseDouble(data[cpt].get(TS_Z_3))-Double.parseDouble(data[cpt].get(TS_Z_2));
            q = closestDirectionVectorIndex(TS_V2_X,TS_V2_Y,TS_V2_Z,dv2);
            h[q]++;
            Double TS_V3_X = Double.parseDouble(data[cpt].get(TS_X_4))-Double.parseDouble(data[cpt].get(TS_X_3));
            Double TS_V3_Y = Double.parseDouble(data[cpt].get(TS_Y_4))-Double.parseDouble(data[cpt].get(TS_Y_3));
            Double TS_V3_Z = Double.parseDouble(data[cpt].get(TS_Z_4))-Double.parseDouble(data[cpt].get(TS_Z_3));
            q = closestDirectionVectorIndex(TS_V3_X,TS_V3_Y,TS_V3_Z,dv3);
            h[q]++;
            System.out.println("#########@");
            for(int j = 0;j<h.length;j++)
            {
                System.out.println("h["+j+"] == : "+h[j]);
            }
            H[2]=h;
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####     
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            dv1 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Relw_X_1)),Double.parseDouble(data[cpt].get(Relw_Y_1)),Double.parseDouble(data[cpt].get(Relw_Z_1)));
            dv2 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Relw_X_2)),Double.parseDouble(data[cpt].get(Relw_Y_2)),Double.parseDouble(data[cpt].get(Relw_Z_2)));
            dv3 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Relw_X_3)),Double.parseDouble(data[cpt].get(Relw_Y_3)),Double.parseDouble(data[cpt].get(Relw_Z_3)));      
            h= new int[27] ;
            q=0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT Relw
            Double Relw_V1_X = Double.parseDouble(data[cpt].get(Relw_X_2))-Double.parseDouble(data[cpt].get(Relw_X_1));
            Double Relw_V1_Y = Double.parseDouble(data[cpt].get(Relw_Y_2))-Double.parseDouble(data[cpt].get(Relw_Y_1));
            Double Relw_V1_Z = Double.parseDouble(data[cpt].get(Relw_Z_2))-Double.parseDouble(data[cpt].get(Relw_Z_1));
                System.out.println(""+Relw_V1_X+""+Relw_V1_Y+""+Relw_V1_Z);

            q = closestDirectionVectorIndex(Relw_V1_X,Relw_V1_Y,Relw_V1_Z,dv1);
            h[q]++;
            Double Relw_V2_X = Double.parseDouble(data[cpt].get(Relw_X_3))-Double.parseDouble(data[cpt].get(Relw_X_2));
            Double Relw_V2_Y = Double.parseDouble(data[cpt].get(Relw_Y_3))-Double.parseDouble(data[cpt].get(Relw_Y_2));
            Double Relw_V2_Z = Double.parseDouble(data[cpt].get(Relw_Z_3))-Double.parseDouble(data[cpt].get(Relw_Z_2));
                System.out.println(""+Relw_V2_X+""+Relw_V2_Y+""+Relw_V2_Z);

            q = closestDirectionVectorIndex(Relw_V2_X,Relw_V2_Y,Relw_V2_Z,dv2);
            h[q]++;
            Double Relw_V3_X = Double.parseDouble(data[cpt].get(Relw_X_4))-Double.parseDouble(data[cpt].get(Relw_X_3));
            Double Relw_V3_Y = Double.parseDouble(data[cpt].get(Relw_Y_4))-Double.parseDouble(data[cpt].get(Relw_Y_3));
            Double Relw_V3_Z = Double.parseDouble(data[cpt].get(Relw_Z_4))-Double.parseDouble(data[cpt].get(Relw_Z_3));
                        System.out.println(""+Relw_V3_X+""+Relw_V3_Y+""+Relw_V3_Z);

             q = closestDirectionVectorIndex(Relw_V3_X,Relw_V3_Y,Relw_V3_Z,dv3);
            h[q]++;
            System.out.println("#########@");
            for(int j = 0;j<h.length;j++)
            {
                System.out.println("h["+j+"] == : "+h[j]);
            }
            H[3]=h;
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####        
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            dv1 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Lelm_X_1)),Double.parseDouble(data[cpt].get(Lelm_Y_1)),Double.parseDouble(data[cpt].get(Lelm_Z_1)));
            dv2 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Lelm_X_2)),Double.parseDouble(data[cpt].get(Lelm_Y_2)),Double.parseDouble(data[cpt].get(Lelm_Z_2)));
            dv3 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Lelm_X_3)),Double.parseDouble(data[cpt].get(Lelm_Y_3)),Double.parseDouble(data[cpt].get(Lelm_Z_3)));      
            h= new int[27] ;
            q=0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT Lelm
            Double Lelm_V1_X = Double.parseDouble(data[cpt].get(Lelm_X_2))-Double.parseDouble(data[cpt].get(Lelm_X_1));
            Double Lelm_V1_Y = Double.parseDouble(data[cpt].get(Lelm_Y_2))-Double.parseDouble(data[cpt].get(Lelm_Y_1));
            Double Lelm_V1_Z = Double.parseDouble(data[cpt].get(Lelm_Z_2))-Double.parseDouble(data[cpt].get(Lelm_Z_1));
            q = closestDirectionVectorIndex(Lelm_V1_X,Lelm_V1_Y,Lelm_V1_Z,dv1);
            h[q]++;
            Double Lelm_V2_X = Double.parseDouble(data[cpt].get(Lelm_X_3))-Double.parseDouble(data[cpt].get(Lelm_X_2));
            Double Lelm_V2_Y = Double.parseDouble(data[cpt].get(Lelm_Y_3))-Double.parseDouble(data[cpt].get(Lelm_Y_2));
            Double Lelm_V2_Z = Double.parseDouble(data[cpt].get(Lelm_Z_3))-Double.parseDouble(data[cpt].get(Lelm_Z_2));
            q = closestDirectionVectorIndex(Lelm_V2_X,Lelm_V2_Y,Lelm_V2_Z,dv2);
            h[q]++;
            Double Lelm_V3_X = Double.parseDouble(data[cpt].get(Lelm_X_4))-Double.parseDouble(data[cpt].get(Lelm_X_3));
            Double Lelm_V3_Y = Double.parseDouble(data[cpt].get(Lelm_Y_4))-Double.parseDouble(data[cpt].get(Lelm_Y_3));
            Double Lelm_V3_Z = Double.parseDouble(data[cpt].get(Lelm_Z_4))-Double.parseDouble(data[cpt].get(Lelm_Z_3));
            q = closestDirectionVectorIndex(Lelm_V3_X,Lelm_V3_Y,Lelm_V3_Z,dv3);
            h[q]++;
            System.out.println("#########@");
            for(int j = 0;j<h.length;j++)
            {
                System.out.println("h["+j+"] == : "+h[j]);
            }
            H[4]=h;
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####       
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            dv1 = generateDirectionVectors(Double.parseDouble(data[cpt].get(head_X_1)),Double.parseDouble(data[cpt].get(head_Y_1)),Double.parseDouble(data[cpt].get(head_Z_1)));
            dv2 = generateDirectionVectors(Double.parseDouble(data[cpt].get(head_X_2)),Double.parseDouble(data[cpt].get(head_Y_2)),Double.parseDouble(data[cpt].get(head_Z_2)));
            dv3 = generateDirectionVectors(Double.parseDouble(data[cpt].get(head_X_3)),Double.parseDouble(data[cpt].get(head_Y_3)),Double.parseDouble(data[cpt].get(head_Z_3)));      
            h= new int[27] ;
            q=0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT head
            Double head_V1_X = Double.parseDouble(data[cpt].get(head_X_2))-Double.parseDouble(data[cpt].get(head_X_1));
            Double head_V1_Y = Double.parseDouble(data[cpt].get(head_Y_2))-Double.parseDouble(data[cpt].get(head_Y_1));
            Double head_V1_Z = Double.parseDouble(data[cpt].get(head_Z_2))-Double.parseDouble(data[cpt].get(head_Z_1));
            q = closestDirectionVectorIndex(head_V1_X,head_V1_Y,head_V1_Z,dv1);
            h[q]++;
            Double head_V2_X = Double.parseDouble(data[cpt].get(head_X_3))-Double.parseDouble(data[cpt].get(head_X_2));
            Double head_V2_Y = Double.parseDouble(data[cpt].get(head_Y_3))-Double.parseDouble(data[cpt].get(head_Y_2));
            Double head_V2_Z = Double.parseDouble(data[cpt].get(head_Z_3))-Double.parseDouble(data[cpt].get(head_Z_2));
            q = closestDirectionVectorIndex(head_V2_X,head_V2_Y,head_V2_Z,dv2);
            h[q]++;
            Double head_V3_X = Double.parseDouble(data[cpt].get(head_X_4))-Double.parseDouble(data[cpt].get(head_X_3));
            Double head_V3_Y = Double.parseDouble(data[cpt].get(head_Y_4))-Double.parseDouble(data[cpt].get(head_Y_3));
            Double head_V3_Z = Double.parseDouble(data[cpt].get(head_Z_4))-Double.parseDouble(data[cpt].get(head_Z_3));
            q = closestDirectionVectorIndex(head_V3_X,head_V3_Y,head_V3_Z,dv3);
            h[q]++;
            System.out.println("#########@");
            for(int j = 0;j<h.length;j++)
            {
               System.out.println("h["+j+"] == : "+h[j]);
            }
            H[5]=h;
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####      
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            dv1 = generateDirectionVectors(Double.parseDouble(data[cpt].get(neck_X_1)),Double.parseDouble(data[cpt].get(neck_Y_1)),Double.parseDouble(data[cpt].get(neck_Z_1)));
            dv2 = generateDirectionVectors(Double.parseDouble(data[cpt].get(neck_X_2)),Double.parseDouble(data[cpt].get(neck_Y_2)),Double.parseDouble(data[cpt].get(neck_Z_2)));
            dv3 = generateDirectionVectors(Double.parseDouble(data[cpt].get(neck_X_3)),Double.parseDouble(data[cpt].get(neck_Y_3)),Double.parseDouble(data[cpt].get(neck_Z_3)));      
            h= new int[27] ;
            q=0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT neck
            Double neck_V1_X = Double.parseDouble(data[cpt].get(neck_X_2))-Double.parseDouble(data[cpt].get(neck_X_1));
            Double neck_V1_Y = Double.parseDouble(data[cpt].get(neck_Y_2))-Double.parseDouble(data[cpt].get(neck_Y_1));
            Double neck_V1_Z = Double.parseDouble(data[cpt].get(neck_Z_2))-Double.parseDouble(data[cpt].get(neck_Z_1));
            q = closestDirectionVectorIndex(neck_V1_X,neck_V1_Y,neck_V1_Z,dv1);
            h[q]++;
            Double neck_V2_X = Double.parseDouble(data[cpt].get(neck_X_3))-Double.parseDouble(data[cpt].get(neck_X_2));
            Double neck_V2_Y = Double.parseDouble(data[cpt].get(neck_Y_3))-Double.parseDouble(data[cpt].get(neck_Y_2));
            Double neck_V2_Z = Double.parseDouble(data[cpt].get(neck_Z_3))-Double.parseDouble(data[cpt].get(neck_Z_2));
            q = closestDirectionVectorIndex(neck_V2_X,neck_V2_Y,neck_V2_Z,dv2);
            h[q]++;
            Double neck_V3_X = Double.parseDouble(data[cpt].get(neck_X_4))-Double.parseDouble(data[cpt].get(neck_X_3));
            Double neck_V3_Y = Double.parseDouble(data[cpt].get(neck_Y_4))-Double.parseDouble(data[cpt].get(neck_Y_3));
            Double neck_V3_Z = Double.parseDouble(data[cpt].get(neck_Z_4))-Double.parseDouble(data[cpt].get(neck_Z_3));
            q = closestDirectionVectorIndex(neck_V3_X,neck_V3_Y,neck_V3_Z,dv3);
            h[q]++;
            System.out.println("#########@");
            for(int j = 0;j<h.length;j++)
            {
               System.out.println("h["+j+"] == : "+h[j]);
            }
            H[6]=h;
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####       
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            dv1 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Lshdr_X_1)),Double.parseDouble(data[cpt].get(Lshdr_Y_1)),Double.parseDouble(data[cpt].get(Lshdr_Z_1)));
            dv2 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Lshdr_X_2)),Double.parseDouble(data[cpt].get(Lshdr_Y_2)),Double.parseDouble(data[cpt].get(Lshdr_Z_2)));
            dv3 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Lshdr_X_3)),Double.parseDouble(data[cpt].get(Lshdr_Y_3)),Double.parseDouble(data[cpt].get(Lshdr_Z_3)));      
            h= new int[27] ;
            q=0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT Lshdr
            Double Lshdr_V1_X = Double.parseDouble(data[cpt].get(Lshdr_X_2))-Double.parseDouble(data[cpt].get(Lshdr_X_1));
            Double Lshdr_V1_Y = Double.parseDouble(data[cpt].get(Lshdr_Y_2))-Double.parseDouble(data[cpt].get(Lshdr_Y_1));
            Double Lshdr_V1_Z = Double.parseDouble(data[cpt].get(Lshdr_Z_2))-Double.parseDouble(data[cpt].get(Lshdr_Z_1));
            q = closestDirectionVectorIndex(Lshdr_V1_X,Lshdr_V1_Y,Lshdr_V1_Z,dv1);
            h[q]++;
            Double Lshdr_V2_X = Double.parseDouble(data[cpt].get(Lshdr_X_3))-Double.parseDouble(data[cpt].get(Lshdr_X_2));
            Double Lshdr_V2_Y = Double.parseDouble(data[cpt].get(Lshdr_Y_3))-Double.parseDouble(data[cpt].get(Lshdr_Y_2));
            Double Lshdr_V2_Z = Double.parseDouble(data[cpt].get(Lshdr_Z_3))-Double.parseDouble(data[cpt].get(Lshdr_Z_2));
            q = closestDirectionVectorIndex(Lshdr_V2_X,Lshdr_V2_Y,Lshdr_V2_Z,dv2);
            h[q]++;
            Double Lshdr_V3_X = Double.parseDouble(data[cpt].get(Lshdr_X_4))-Double.parseDouble(data[cpt].get(Lshdr_X_3));
            Double Lshdr_V3_Y = Double.parseDouble(data[cpt].get(Lshdr_Y_4))-Double.parseDouble(data[cpt].get(Lshdr_Y_3));
            Double Lshdr_V3_Z = Double.parseDouble(data[cpt].get(Lshdr_Z_4))-Double.parseDouble(data[cpt].get(Lshdr_Z_3));
            q = closestDirectionVectorIndex(Lshdr_V3_X,Lshdr_V3_Y,Lshdr_V3_Z,dv3);
            h[q]++;
            System.out.println("#########@");
            for(int j = 0;j<h.length;j++)
            {
               System.out.println("h["+j+"] == : "+h[j]);
            }
            H[7]=h;
//###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####       
            //GENERATING 27 PRIMARY DIRECTION VECTORS COORDINATES FOR EACH FRAME
            dv1 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Rshdr_X_1)),Double.parseDouble(data[cpt].get(Rshdr_Y_1)),Double.parseDouble(data[cpt].get(Rshdr_Z_1)));
            dv2 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Rshdr_X_2)),Double.parseDouble(data[cpt].get(Rshdr_Y_2)),Double.parseDouble(data[cpt].get(Rshdr_Z_2)));
            dv3 = generateDirectionVectors(Double.parseDouble(data[cpt].get(Rshdr_X_3)),Double.parseDouble(data[cpt].get(Rshdr_Y_3)),Double.parseDouble(data[cpt].get(Rshdr_Z_3)));      
            h= new int[27] ;
            q=0;
            //CALCULATING THE DIRECTION VECTORS OF JOINT Rshdr
            Double Rshdr_V1_X = Double.parseDouble(data[cpt].get(Rshdr_X_2))-Double.parseDouble(data[cpt].get(Rshdr_X_1));
            Double Rshdr_V1_Y = Double.parseDouble(data[cpt].get(Rshdr_Y_2))-Double.parseDouble(data[cpt].get(Rshdr_Y_1));
            Double Rshdr_V1_Z = Double.parseDouble(data[cpt].get(Rshdr_Z_2))-Double.parseDouble(data[cpt].get(Rshdr_Z_1));
            q = closestDirectionVectorIndex(Rshdr_V1_X,Rshdr_V1_Y,Rshdr_V1_Z,dv1);
            h[q]++;
            Double Rshdr_V2_X = Double.parseDouble(data[cpt].get(Rshdr_X_3))-Double.parseDouble(data[cpt].get(Rshdr_X_2));
            Double Rshdr_V2_Y = Double.parseDouble(data[cpt].get(Rshdr_Y_3))-Double.parseDouble(data[cpt].get(Rshdr_Y_2));
            Double Rshdr_V2_Z = Double.parseDouble(data[cpt].get(Rshdr_Z_3))-Double.parseDouble(data[cpt].get(Rshdr_Z_2));
            q = closestDirectionVectorIndex(Rshdr_V2_X,Rshdr_V2_Y,Rshdr_V2_Z,dv2);
            h[q]++;
            Double Rshdr_V3_X = Double.parseDouble(data[cpt].get(Rshdr_X_4))-Double.parseDouble(data[cpt].get(Rshdr_X_3));
            Double Rshdr_V3_Y = Double.parseDouble(data[cpt].get(Rshdr_Y_4))-Double.parseDouble(data[cpt].get(Rshdr_Y_3));
            Double Rshdr_V3_Z = Double.parseDouble(data[cpt].get(Rshdr_Z_4))-Double.parseDouble(data[cpt].get(Rshdr_Z_3));
            q = closestDirectionVectorIndex(Rshdr_V3_X,Rshdr_V3_Y,Rshdr_V3_Z,dv3);
            h[q]++;
            System.out.println("##########");
            for(int j = 0;j<h.length;j++)
            {
               System.out.println("h["+j+"] == : "+h[j]);
            }
            H[8]=h;
        }
 //###########@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@###############@####       
    }  
}
