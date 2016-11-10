package framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lfo.experiments.LFOFramework;

public class SimulatorModule {

	public static void main(String[] args) throws IOException{
		double ttt = System.currentTimeMillis();

		TestingModule test = new TestingModule();
		EvaluatorModule eval = new EvaluatorModule();

		//run multiple times to go through all the datasets
		for(int j = 1;j<2;j++){

			//---------------Experiment Setup--------------------------------------------------------------------------------------
			//type of learner (BN,NN,NNk2,BNk2,IOHMM,DBN,TB)
			String learnerType = "TB";

			//gather trace data
			List <String> data = new ArrayList<String>();
			
			for(int i=1;i<3;i++){
				//data.add("C:/Users/sachagunaratne/workspace2/LFOSimulation/workspace/LFOsimulator/traces-fourraydistance/Traces-for-dataset" + j + "/trace-m" + i + "-FixedSequenceAgent.txt");
				// data.add("RoboCup/Dataset5/log_toggle"+ i +".csv");
				data.add("C:/Users/sachagunaratne/workspace2/LFOSimulation/workspace/LFOsimulator/RoboCup/Dataset" + j + "/C_" + i + ".csv");
			}

			// data.add("C:/Users/sachagunaratne/workspace2/LFOSimulation/workspace/LFOsimulator/RoboCup/Dataset" + j + "/Test_data.csv");
			// data.add("C:/Users/sachagunaratne/workspace2/LFOSimulation/workspace/LFOsimulator/RoboCup/Dataset" + j + "/Train_data.csv");

			//how to split the data (depending whether its comma delimited or space delimited)
			String splitBy = ","; 

			//number of Perceptions
			int numPerceptions = 3;

			//actions
			String[] actions = {"1","2","3"};

			//location to save output files
			String outputLocation = "C:/Users/sachagunaratne/workspace2/LFOSimulation/workspace/LFOsimulator/RoboCup_evaluation/";

			//Get confusionMatrix
			int[][] conMat = test.trainTest(learnerType, data, numPerceptions, actions, splitBy);

			//Evaluate Performance
			eval.evaluate(learnerType, conMat, outputLocation);

		}

		//output time taken to run experiment
		test.printTime(ttt);
	}
}
