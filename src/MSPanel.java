import javax.swing.*;
import java.awt.*;


public class MSPanel extends JPanel implements BombListener{

	MSLabel[][] squares;
	int rows;
	int cols;
	int numShowing;
	double difficulty;


	public MSPanel(int rows, int cols, double difficulty) {
		this.rows = rows;
		this.cols = cols;
		this.difficulty = difficulty;
		numShowing = 0;
		setLayout(new GridLayout(rows,cols));
		squares = new MSLabel[rows][cols];
		for(int j=0; j<rows; j++){
			for (int k=0; k<cols; k++){
				squares[j][k] = (new MSLabel());
				add(squares[j][k]);
			}
		}
		setBombs();
		for(int j=0; j<rows; j++){
			for (int k=0; k<cols; k++){
				squares[j][k].setBombsNear(getNumber(j,k));
			}
		}

	}

	public void setBombs(){
		int totalBombs = (int)(rows*cols*difficulty);
		while(totalBombs!=0){
			int r = (int)(Math.random()*(rows));
			int c = (int)(Math.random()*(cols));
			if(!squares[r][c].isBomb()){
				squares[r][c].setAsBomb();
				totalBombs--;
			}
		}
	}

	public int getNumber(int row, int col){
		int numAj = 0;
		try{
			if(squares[row-1][col-1].isBomb())
				numAj++;
		}
		catch (IndexOutOfBoundsException e){}
		try{
			if(squares[row-1][col].isBomb())
				numAj++;
		}
		catch (IndexOutOfBoundsException e){

		}
		try{
			if(squares[row-1][col+1].isBomb())
				numAj++;
		}
		catch (IndexOutOfBoundsException e){}
		try{
			if(squares[row][col-1].isBomb())
				numAj++;
		}
		catch (IndexOutOfBoundsException e){}
		try{
			if(squares[row][col+1].isBomb())
				numAj++;
		}
		catch (IndexOutOfBoundsException e){

		}
		try{
			if(squares[row+1][col-1].isBomb())
				numAj++;
		}
		catch (IndexOutOfBoundsException e){}
		try{
			if(squares[row+1][col].isBomb())
				numAj++;
		}
		catch (IndexOutOfBoundsException e){}
		try{
			if(squares[row+1][col+1].isBomb())
				numAj++;
		}
		catch (IndexOutOfBoundsException e){}

		return numAj;
	}

	public void setNumbers(){}

	//@Override
	//public void update(BombEvent e) {

	//}
}
