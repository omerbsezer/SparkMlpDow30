# SparkMlpDow30 
An Artificial Neural Network-based Stock Trading System Using Technical Analysis and Big Data Framework

The model developed first converts the financial time series data into a series of buy-sell-hold trigger signals using the most commonly preferred technical analysis indicators (TA4J is used to calculate technical analysis indicators' values). Then, a Multilayer Perceptron (MLP) artificial neural network (ANN) model is trained in the learning stage on the daily stock prices between 1997 and 2007 for all of the Dow30 stocks. Apache Spark big data framework is used in the training stage. The trained model is then tested with data from 2007 to 2017. The results indicate that by choosing the most appropriate technical indicators, the neural net-work model can achieve comparable results against the Buy and Hold strategy in most of the cases. Furthermore, fine tuning the technical indicators and/or optimization strategy can enhance the overall trading performance.

We presented a new stock trading and prediction model based on a MLP neural network utilizing technical analysis indicator values as features. Big data framework Apache Spark is used in implementation. The model is trained and tested on Dow 30 stocks in order to see the
evaluate the model. The results indicate that comparable results are obtained against the baseline Buy and Hold strategy even without fine tuning and/or optimizing the model parameters. 


ResearchGate Link:
https://www.researchgate.net/publication/316848946_An_Artificial_Neural_Network-based_Stock_Trading_System_Using_Technical_Analysis_and_Big_Data_Framework

ACM Link:
http://dl.acm.org/citation.cfm?id=3077294

TA4J: https://github.com/mdeverdelhan/ta4j
