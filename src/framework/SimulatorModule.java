package framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimulatorModule {

    public static void main(String[] args) throws IOException{
        double ttt = System.currentTimeMillis();

        TestingModule test = new TestingModule();
        EvaluatorModule eval = new EvaluatorModule();

        //run multiple times to go through all the datasets
        for(int j = 4;j<5;j++){

            //---------------Experiment Setup--------------------------------------------------------------------------------------
            //type of learner (BN,NN,NNk2,BNk2,IOHMM,DBN,TB, CDBN, CBR)
            String learnerType = "BN";

            //gather trace data
            List <String> data = new ArrayList<String>();
            
            //for (int k = 1;k<2;k++){
                for(int i=0;i<7;i++){
                    data.add("Raw_data/Vaccuum_cleaner/NoStandAction"+ "/trace-m" + i + "-WallFollowerAgent.txt");
                     //data.add("Raw_data/ctsObstacleAvoidance/toggle"+ i +".txt");
                    //data.add("Raw_data/RoboCup/Dataset" + k + "/C_" + i + ".csv");
                }
            //}

            // data.add("C:/Users/sachagunaratne/workspace2/LFOSimulation/workspace/LFOsimulator/RoboCup/Dataset" + j + "/Test_data.csv");
            // data.add("C:/Users/sachagunaratne/workspace2/LFOSimulation/workspace/LFOsimulator/RoboCup/Dataset" + j + "/Train_data.csv");

            //how to split the data (depending whether its comma delimited or space delimited)
            String splitBy = " "; 

            //number of Perceptions
            int numPerceptions = 8;

            //actions
            String[] actions = {"1.0","2.0","3.0","4.0"};

            //location to save output files
            String outputLocation = "New_Results/WF/NEW/";

            //Get confusionMatrix
            int[][] conMat = test.trainTest(learnerType, data, numPerceptions, actions, splitBy, outputLocation);

            //Evaluate Performance
            //eval.evaluate(learnerType, conMat, outputLocation);

        }

        //output time taken to run experiment
        test.printTime(ttt, true);
    }
}
