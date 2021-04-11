
public class Field {

    public enum FieldType {Empty, Trap, Start, Finish};
    
    public boolean northWall, westWall, eastWall, southWall = false;
    public FieldType fieldType = FieldType.Empty;
    
    public Field() {

    }
    
    public void setWall(String direction) {
        if (direction == "N") {
            northWall = true;
        } else if (direction == "W") {
            westWall = true;
        } else if (direction == "S") {
            southWall = true;
        } else if (direction == "E") {
            eastWall = true;
        }
    }
    
    public boolean setTrap() {
        if (this.fieldType != FieldType.Start && this.fieldType != FieldType.Finish) {
            this.fieldType = FieldType.Trap;
            return true;
        }
        return false;
    }
    
    public boolean setStart() {
        if (this.fieldType != FieldType.Trap) {
            this.fieldType = FieldType.Start;
            return true;
        }
        return false;
    }
    
    public boolean setFinish() {
        if (this.fieldType != FieldType.Trap) {
            this.fieldType = FieldType.Finish;
            return true;
        }
        return false;
    }
    
    public boolean hasWall(String direction) {
        if (direction == "N") {
            return northWall;
        } else if (direction == "W") {
            return westWall;
        } else if (direction == "S") {
            return southWall;
        } else {
            return eastWall;
        }
    }
    
    public boolean isTrap() {
        return this.fieldType == FieldType.Trap;
    }
    
    public boolean isStart() {
        return this.fieldType == FieldType.Start;
    }
    
    public boolean isFinish() {
        return this.fieldType == FieldType.Finish;
    }
    
    public static void main(String[] args) {

    }

}
