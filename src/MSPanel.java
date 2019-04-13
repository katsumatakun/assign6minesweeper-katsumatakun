import javax.swing.*;
import java.awt.*;


public class MSPanel extends JPanel implements BombListener{

	private MSLabel[][] squares;
	private int rows;
	private int cols;
	private int numShowing;
	private double difficulty;


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
				squares[j][k].addBombListener(this);
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

	private void setBombs(){
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

	private int getNumber(int row, int col){
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

	private void setNumbers(){
	}

	@Override
	public void update(BombEvent e) {

		MSLabel la = (MSLabel) e.getSource();
		if(la.isBomb()) {
			MessageDialog l = new MessageDialog("You lost orz.");
			JOptionPane.showMessageDialog(null, l.getMessage());
			System.exit(0);
		}
		else{
			System.out.println("no bomb");
			numShowing++;
			if(numShowing == rows*cols - ((int) (rows*cols*difficulty)))
			{
				MessageDialog l = new MessageDialog("You won!!!!");
				JOptionPane.showMessageDialog(null, l.getMessage());
				System.exit(0);
			}
		}
	}
}
