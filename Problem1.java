
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{   
    public int beeperNumber;
    public int[] numbersToSort = new int[8];
    
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers(int numberOfPiles) {
        
        startingPosition();
        for(int n = numberOfPiles; n > 0; n--){
            moveTillYouBeep();
            countSteeple(n);
        }
        
        System.out.println(numbersToSort.toString());
    }
    public void startingPosition(){
        turnLeft();
        turnLeft();
        move(7);
        turnRight();
        move(7);
        turnRight();
    }
    public void turnRight(){
        turnLeft();
        turnLeft();
        turnLeft();
    }
    public void move(int spaces){
        for(int n = 0; n < spaces; n++){
            move();
        }
    }
    public void moveTillYouBeep(){
        while(!nextToABeeper()){
            move();
        }
    }
    public void countSteeple(int index){
        turnRight();
        beeperNumber = 0;
        while(nextToABeeper()){
            pickBeeper();
            beeperNumber += 1;
            move();
        }
        goBack();
        numbersToSort[index] = beeperNumber;
    }
    public void goBack(){
        turnLeft();
        turnLeft();
        while(frontIsClear()){
            move();
        }
        turnRight();
    }
}

