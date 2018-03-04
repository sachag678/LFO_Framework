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
            String learnerType = "DBN";

            //gather trace data
            List <String> data = new ArrayList<String>();
            
            //for (int k = 1;k<2;k++){
                for(int i=0;i<7;i++){
                    data.add("C:/Users/me/Documents/GitHub/LFO_Framework/Raw_data/Vaccuum_cleaner/Traces-for-dataset" + j + "/trace-m" + i + "-ZigZagAgent.txt");
                     //data.add("Raw_data/ObstacleAvoidance/toggle"+ i +".csv");
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
            String[] actions = {"1","2","3","4","5"};

            //location to save output files
            String outputLocation = "New_Results/VC/ZZ/";

            //Get confusionMatrix
            int[][] conMat = test.trainTest(learnerType, data, numPerceptions, actions, splitBy, outputLocation);

            //Evaluate Performance
            //eval.evaluate(learnerType, conMat, outputLocation);

        }

        //output time taken to run experiment
        test.printTime(ttt, true);
    }
}
