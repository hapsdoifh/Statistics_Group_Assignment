//putting the mean median mode methods and code here bc idk if I should put it into the statistic.java file yet

// Tyson: mode (done), max (done), min (done), range (done)
//Jasmine = median(finished), mean(finished)
class medianMeanMode {
  //variables
  double mean;
  double median;
  double mode; 
  double[] classlist;

  public medianMeanMode(){
    mean = 0.0;
    median = 0.0;
    mode = 0.0; 
  }

  medianMeanMode(double[] students){
    classlist = students;
  }

  //getters

  // mean
  public double getMean(){
    for (int i= 0; i< classlist.length; i++){
       mean += classlist[i]; 
    }
    return mean/classlist.length;
  }
  
  //median
  public double getMedian(){
    Arrays.sort(classlist);
    if (classlist.length%2 != 0){ 
      
      median = classlist[classlist.length/2];
    } else {
      median =(classlist[(classlist.length-1)/2]+classlist[classlist.length/2])/2;
    }
    return median;
  }

  // mode (tyson)
  public double getMode(){ 
    double sorted = 0.0; 
    int highestCounter = 0;
    
    for (int i = 0; i < classlist.length + 1; i++){
      double sorter = classlist[i];
      int counter = 0;
      
      for (int n = i +1; n < classlist.length; n++){
        if (sorter == classlist[n]){
          counter++;
        }
      }

      if (counter > highestCounter){ 
        highestCounter = counter;
        sorted = sorter;
      }
      else if (counter == highestCounter){
        sorted = Math.min(sorter, sorted);
        }
    } // for loop bracket
    
  return highestCounter;
  }

  // max (tyson)
  public double getMax(){
    highest = 0; 
    
    for (int i = 0; i > classlist.length; i++){
      listOrder = classlist[i];
      
      if (listOrder > highest){
        highest = listOrder;
      }
      else if (listOrder <= highest){
        highest = Math.max(listOrder, highest);
      }
    } // loop bracket

    return highest; 
  } // getter end bracket

  // min (tyson)
  public double getMin(){
    lowest = 100;

    for (int i = 0; i > classlist.length; i++){
      listOrder = classlist[i];

      if (listOrder < lowest){
        lowest = listOrder;

      else if (listOrder >= lowest){
        lowest = Math.min(listOrder, lowest);
      }
    } // for loop bracket

    return lowest;
  } // getter end bracket

  // range (tyson)
  public double getRange(){
    // use new variables to make code less messy (less brackets)
    highest = getMax(); 
    lowest = getMin();

    return Math.round((highest - lowest) *100.0) / 100.0;
  } // getter end bracket


  
} // class ending bracket
