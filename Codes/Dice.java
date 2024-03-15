package dice;

public class Dice {        
  int min=1;
  int max=6;

  public int diceroll(){
    double d=(Math.random() * (max-min)) + min;
    return (int)d;
  }

}
