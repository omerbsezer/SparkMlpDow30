# SparkMlpDow30 
**An Artificial Neural Network Based Stock Trading System Using Technical Analysis and Big Data Framework**

The model developed first converts the financial time series data into a series of **`buy-sell-hold`** trigger signals using the most commonly preferred technical analysis indicators ([TA4J](https://github.com/mdeverdelhan/ta4j-origins/) is used to calculate technical analysis indicators' values). Then, a multilayer perceptron (MLP) is trained in the learning stage on the daily stock prices between 1997 and 2007 for all of the [Dow 30](http://www.investopedia.com/terms/d/dow-30.asp) stocks. [Apache Spark](https://spark.apache.org/) big data framework is used in the training stage. The trained model is then tested with data from 2007 to 2017. The results indicate that by choosing the most appropriate technical indicators, the NN model can achieve comparable results against the **`buy`** and **`hold`** strategy in most of the cases. Furthermore, fine tuning the technical indicators and/or optimization strategy can enhance the overall trading performance.

We presented a new stock trading and prediction model based on an MLP model, utilizing technical analysis indicator values as features. Big data framework [Apache Spark](https://spark.apache.org/) is used in implementation. The model is trained and tested on [Dow 30](http://www.investopedia.com/terms/d/dow-30.asp) stocks in order to see the evaluate the model. The results indicate that comparable outcomes are obtained against the baseline **`buy`** and **`hold`** strategy even without fine tuning and/or optimizing the model parameters. Phases of proposed method is illustrated in below.


![sparkmlpphase](https://user-images.githubusercontent.com/10358317/37893083-a15a70a0-30e2-11e8-83bb-5a079a7ed179.png)


ResearchGate Link:
https://www.researchgate.net/publication/316848946_An_Artificial_Neural_Network-based_Stock_Trading_System_Using_Technical_Analysis_and_Big_Data_Framework

ACM Link:
http://dl.acm.org/citation.cfm?id=3077294

TA4J: https://github.com/mdeverdelhan/ta4j

_**Cite as:**_

**Bibtex:**

```
@inproceedings{sezer2017artificial,
  title={An Artificial Neural Network-based Stock Trading System Using Technical Analysis and Big Data Framework},
  author={Sezer, Omer Berat and Ozbayoglu, A Murat and Dogdu, Erdogan},
  booktitle={Proceedings of the SouthEast Conference},
  pages={223--226},
  year={2017},
  organization={ACM}
}
```

**MLA:**

Sezer, Omer Berat, A. Murat Ozbayoglu, and Erdogan Dogdu. "An Artificial Neural Network-based Stock Trading System Using Technical Analysis and Big Data Framework." Proceedings of the SouthEast Conference. ACM, 2017.


What is Multi Layer Perceptron (MLP)? (General Information): https://en.wikipedia.org/wiki/Multilayer_perceptron

What is Relative Strength Index?: https://en.wikipedia.org/wiki/Relative_strength_index

What is MACD?: https://en.wikipedia.org/wiki/MACD

What is William%R?: https://www.investopedia.com/terms/w/williamsr.asp

Apache Spark MLlib: https://spark.apache.org/mllib/
