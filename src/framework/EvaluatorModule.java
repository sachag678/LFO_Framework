package framework;

import java.io.FileWriter;
import java.io.IOException;

public class EvaluatorModule {

	public void evaluate(String learnerType, int [][] conMat, String location) throws IOException{
		//create output files
		FileWriter f1 = new FileWriter(location + learnerType + ".txt");

		//new arrays to hold Precision and Recall and F-Measure----------------
		Double [] precision = new Double [conMat.length];
		Double [] recall = new Double [conMat.length];
		Double [] fmeasure = new Double [conMat.length];
		//-------------------------------------------------------

		double avg_fmeasure =0;

		for(int i1=0;i1<conMat.length;i1++){
			//checking for divide by zero
			if(sumOfCol(conMat,i1)!=0){
				precision[i1] = (double) (conMat[i1][i1])/sumOfCol(conMat,i1);
			}else{
				precision[i1] = 0.0;
			}
			if(sumOfRow(conMat,i1)!=0){
				recall[i1] = (double) (conMat[i1][i1])/sumOfRow(conMat,i1);
			} else{
				recall[i1] = 0.0;
			}

			if(precision[i1]!=0 && recall[i1]!=0){
				fmeasure[i1] = (2*precision[i1]*recall[i1])/(precision[i1]+recall[i1]);
			}else{
				fmeasure[i1] = 0.0;
			}
			avg_fmeasure += fmeasure[i1];
		}

		//-----------------------------------------------------------------------

		avg_fmeasure = avg_fmeasure/conMat.length;

		//calculate accuracy
		double accuracy = getAccuracy(conMat);

		//output Accuracy
		f1.write("Accuracy:"+ accuracy);
		f1.append("\r\n");

		//output confusion matrix_____________________________
		f1.write("predicted");
		f1.append("\r\n");
		f1.write("_________");
		f1.append("\r\n");
		for(int count1 = 0;count1<conMat.length;count1++){
			f1.write("|");
			for(int count2 = 0;count2<conMat.length;count2++){	
				f1.write(String.valueOf(conMat[count1][count2]));
				f1.write(" ");
			}
			f1.write("|");
			f1.append("\r\n");
		}
		//_______________________________________________________

		//output Average F-Measure
		f1.write("fmeasure:"+ avg_fmeasure + ",");
		f1.append("\r\n");

		//output precision and recall
		f1.write("\r\n");

		for(int count = 0;count<precision.length;count++){
			f1.write("precision:" + precision[count] + ",recall:" + recall[count]);
			f1.append("\r\n");
		}
		//output F-measure
		for(int count = 0;count<precision.length;count++){
			f1.write("F-Measure:" + fmeasure[count]);
			f1.append("\r\n");
		}


		f1.close();

	}
	
	public double getF1Global(int[][] conMat){
		//new arrays to hold Precision and Recall and F-Measure----------------
				Double [] precision = new Double [conMat.length];
				Double [] recall = new Double [conMat.length];
				Double [] fmeasure = new Double [conMat.length];
				//-------------------------------------------------------

				double avg_fmeasure =0;

				for(int i1=0;i1<conMat.length;i1++){
					//checking for divide by zero
					if(sumOfCol(conMat,i1)!=0){
						precision[i1] = (double) (conMat[i1][i1])/sumOfCol(conMat,i1);
					}else{
						precision[i1] = 0.0;
					}
					if(sumOfRow(conMat,i1)!=0){
						recall[i1] = (double) (conMat[i1][i1])/sumOfRow(conMat,i1);
					} else{
						recall[i1] = 0.0;
					}

					if(precision[i1]!=0 && recall[i1]!=0){
						fmeasure[i1] = (2*precision[i1]*recall[i1])/(precision[i1]+recall[i1]);
					}else{
						fmeasure[i1] = 0.0;
					}
					avg_fmeasure += fmeasure[i1];
				}
				
				avg_fmeasure = avg_fmeasure/conMat.length;
				
				return avg_fmeasure;
	}
	
	public double getAccuracy(int[][] conMat){
		double total = 0;
		double tp = 0;

		//get total predictions
		for(int i = 0;i<conMat.length;i++){
			total = total+ sumOfRow(conMat,i);
		}
		//get true predictions
		for(int i =0;i<conMat.length;i++){
			tp = tp + conMat[i][i];			  		   
		}
		//return tp/(tp+tn)
		return tp/total; 
	}
	
	public double sumOfRow(int [][] matrix, int row){
		double sum = 0;
		for(int i = 0;i<matrix.length;i++){
			sum += matrix[row][i];
		}
		return sum;
	}

	public double sumOfCol(int [][] matrix, int col){
		double sum = 0;
		for(int i = 0;i<matrix.length;i++){
			sum += matrix[i][col];
		}
		return sum;
	}
	
	
}
