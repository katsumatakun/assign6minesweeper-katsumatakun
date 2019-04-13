import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MSLabel extends JLabel {

	MSCell cell;
	ArrayList<BombListener> listeners;
	ImageIcon[] msImages;


	public MSLabel() {
		listeners = new ArrayList<>();
		cell = new MSCell();
		setPreferredSize(new Dimension(30, 30));
		getImages();
		setIcon(msImages[10]);
		addMouseListener(new MSListener());

	}

	public void setAsBomb() {
		cell.setAsBomb();
	}

	public boolean isBomb() {
		return cell.isBomb();
	}

	public void setBombsNear(int num) {
		cell.setBombsNear(num);
	}

	public int getBombsNear() {
		return cell.getBombsNear();
	}

	public void addBombListener(BombListener b) {
		listeners.add(b);
	}

	public void removeBombListener(BombListener b) {
		listeners.remove(b);
	}

	public void notifyListeners(){
		BombEvent b = new BombEvent(this);
		for(BombListener bl: listeners){
			bl.update(b);
		}
	}

	private void reveal(){
		cell.reveal();
	}
	public class MSListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isMetaDown()){
				cell.toggleFlagged();
				if(cell.isFlagged())
					setIcon(msImages[11]);
				else
					setIcon(msImages[10]);
			} else {
				if (cell.isBomb()) {
					setIcon(msImages[9]);
				}
				else {
					setIcon(msImages[getBombsNear()]);
					reveal();
				}
				notifyListeners();
			}
		}
	}

	private void getImages() {
		msImages = new ImageIcon[12];
		for (int i = 0; i < 9; i++) {
			msImages[i] = new ImageIcon("MineSweeperIcons/" + i + ".png");
		}
		msImages[9] = new ImageIcon("MineSweeperIcons/Bomb.png");
		msImages[10] = new ImageIcon("MineSweeperIcons/Empty.png");
		msImages[11] = new ImageIcon("MineSweeperIcons/Flag.png");
	}
}
