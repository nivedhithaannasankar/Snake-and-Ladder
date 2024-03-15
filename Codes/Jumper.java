package jumper;

import coordinates.Coordinates;

public class Jumper {
    public Coordinates start;
    public Coordinates end;
    String name;

    public Jumper(Coordinates start,Coordinates end){
        this.start=start;
        this.end=end;

        if(start.getrow() >end.getrow()) 
        this.name="Ladder";
        else
        this.name="Snake";
    }

    public String getjumpername(){
        return this.name;
    }

}
