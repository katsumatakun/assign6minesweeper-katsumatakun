public class MSCell {

    private int bombsNear;
    private boolean isBomb;
    private boolean isFlagged;
    private boolean isHidden;

    public MSCell(){
        bombsNear = 0;
        isHidden = true;
        isFlagged = false;
        isBomb = false;
    }


    public void setBombsNear(int bombsNear) {
        this.bombsNear = bombsNear;
    }

    public void setAsBomb(){
        isBomb = true;
    }

    public void toggleFlagged(){
        isFlagged = true;
    }

    public void reveal(){
        isHidden = false;
    }

    public int getBombsNear(){
        return bombsNear;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public boolean isFlagged(){
        return isFlagged;
    }

    public boolean isHidden(){
        return isHidden;
    }
}


