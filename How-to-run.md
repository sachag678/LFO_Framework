# LFO_Framework
This is still a work in progress
To run a simulation:
Open LFO_Framework/src/SimulatorModule.java

-Edit the file to accept the specific trace files.

-Add whether the file is comma seperated or space delimited

-Add number of perceptions

-Add the actions as a String[]

-Add the output location

-Add type of Learner - If running DBN or IOHMM - GO to DiscreteDBNAgent.java and adjust state_length based on (# of perceptions + # of action nodes + 1 ) x 2 
for example if 3 perceptions and 1 action node, the state_length = (3 + 1 + 1)  x 2 = 10

-Edit how many dataset to look through by changing the initial For loops iterations

-Then run and the output will have an accuracy, F-measure, precision, recall and confusion matrix

The trace file format: the example file has three binary perceptions and one action that can take 3 values.
If the learner type is TB, BN, BNK2, DBN or IOHMM - the binary perceptions should be 1 is false and 2 if true.

1 1 1 3

1 2 1 2

If the learner type is NN, NNK2 - the binary peceptions should be 0 for false and 1 if true. The actions for the this learner
need to be written as follows: If there are three action, 1 -> 1 0 0, 2 -> 0 1 0, 3 -> 0 0 1
The above trace written in the required format for these learner Types.

0 0 0 0 0 1

0 1 0 0 1 0

Further examples can be found in LFO_Framework/raw_data/RoboCup/Dataset1/
