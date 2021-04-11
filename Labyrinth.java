

public class Labyrinth {
    
    int maxH, maxV;
    int numberOfTraps = 0;
    private boolean startSet, finishSet = false;
    
    // declare maze
    Field[][] maze;
    
    // constructor method
    public Labyrinth(int maxH, int maxV) {
        
        // initialize maze
        maze = new Field[maxV][maxH];
        
        this.maxH = maxH;
        this.maxV = maxV;
        
        for (int i = 0; i < maxV; i++) {
            for (int j = 0; j < maxH; j++) {
                maze[i][j] = new Field();
                if (i == 0) {
                    maze[i][j].setWall("N");
                } else if (i == maxV - 1) {
                    maze[i][j].setWall("S");
                } 
                if (j == 0) {
                    maze[i][j].setWall("W");
                } else if (j == maxH - 1) {
                    maze[i][j].setWall("E");
                }
            }
        }
    }

    // set wall method
    public void setWall(int i, int j, String direction) {
        if (direction == "N" || direction == "W") {
            maze[i][j].setWall(direction);
        } else {
            System.out.println("Only northerly and westerly walls are created.");
        }
    }

    // set trap method
    public void setTrap(int i, int j) {
        if (maze[i][j].setTrap()) {
            numberOfTraps++;
        } else {
            System.out.println("Field not available.");
        }
    }
    
    // count traps method
    public int countTraps() {
        return this.numberOfTraps;
    }
   
    // set start method
    public void setStart(int i, int j) {
        if (!this.startSet) {
            if (maze[i][j].setStart()) {
                this.startSet = true;
            } else {
                System.out.println("Field occupied by trap.");
            }
        } else {
            System.out.println("Start field already set.");
        }           
    }
    
    // set finish method
    public void setFinish(int i, int j) {
        if (!this.finishSet) {
            if (maze[i][j].setFinish()) {
                this.finishSet = true;
            } else {
                System.out.println("Field occupied by trap.");
            }
        } else {
            System.out.println("Finish field already set.");
        } 
    }
    
    // print method
    public void print() {
        for (int r = 0; r < maze.length; r++) {
            Field[] row = maze[r];
            printTop(row);
            printMiddle(row);
            if (r == maze.length - 1) {
                printBottom(row);
            }
        }
    }
    
    private void printTop(Field[] row) {
        for (Field field : row) {
            System.out.print(field.hasWall("N") ? "+-" : "+ ");
        }
        System.out.println("+");
    }
    
    private void printMiddle(Field[] row) {
        for (int c = 0; c < row.length; c++) {
            Field field = row[c]; 
            
            String fieldType;
            if (field.isTrap()) {
                fieldType = "x";
            } else if (field.isStart()) {
                fieldType = "s";
            } else if (field.isFinish()) {
                fieldType = "f";
            } else {
                // field empty
                fieldType = " ";
            }

            System.out.print(field.hasWall("W") ? "|" + fieldType : " " + fieldType);
            if (c == row.length - 1) {
                System.out.println(field.hasWall("E") ? "| " : "  ");
            }
        }
    }
    
    private void printBottom(Field[] row) {
        for (Field field : row) {
            System.out.print(field.hasWall("S") ? "+-" : "+ ");
        }
        System.out.println("+");
    }
    
    public static void main(String[] args) {
        {
            Labyrinth labyrinth = new Labyrinth(12, 6);
            
            labyrinth.setWall(3, 2, "N");
            labyrinth.setWall(3, 4, "W");
            labyrinth.setWall(3, 4, "N");
            labyrinth.setTrap(4, 4);
            labyrinth.setTrap(4, 5);
            labyrinth.setTrap(4, 3);
            labyrinth.setStart(0, 0);
            labyrinth.setFinish(5, 11);
            
            labyrinth.print();
            System.out.println("\n Number of traps is " + labyrinth.countTraps());
        }
    }

}
