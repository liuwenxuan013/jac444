
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class ChessBoard extends JFrame {

	private JLabel[][] chessArr;
	private JMenuItem manualPlay;
	private JMenuItem autoPlay;
	private Knight knight;
	private boolean isAuto= false;

	 public ChessBoard(int size) {
		 JPanel panel = new JPanel();
		 panel.setLayout(null);
		 chessArr = new JLabel[8][8];
		
		 for(int i=0; i<8; i++) 
			 for(int j=0; j<8; j++) {
				 final int x=i, y=j;
				 
				 Color color = Color.white;
				 chessArr[i][j] = new JLabel();
				 chessArr[i][j].setSize(size, size);
				 chessArr[i][j].setLocation(i*size, j*size);
				 chessArr[i][j].addMouseListener(new MouseAdapter() {
			            @Override
			            public void mouseClicked(MouseEvent e) {
			            	if(!isAuto) {
			            		if(knight.getCounter()==0) {
			            			knight = new Knight(x, y);
			            			chessArr[x][y].setBackground(Color.pink);
		            				chessArr[x][y].setText(knight.getCounter()+ "");
			            		}else {
			            			if(knight.isMove(x, y)) {
			            				chessArr[x][y].setBackground(Color.pink); ;
			            				chessArr[x][y].setText(knight.getCounter()+ "");
			            			}
			            		}
			            		
			            	}
			            }

			        });
				
				 if((i+j)%2 ==1)
					 color= Color.black;
				 chessArr[i][j].setOpaque(true);
				 chessArr[i][j].setBackground(color);
				 chessArr[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				 panel.add( chessArr[i][j]);

			 }
		 	add(panel, BorderLayout.CENTER);
		 	JMenuBar menuBar = new JMenuBar();
		 	JMenu menu = new JMenu("Menu");
		 	manualPlay = new JMenuItem("Manual Play");
		 	manualPlay.addActionListener(new menuEventHandler());
		 	autoPlay = new JMenuItem("Auto Play");
		 	autoPlay.addActionListener(new menuEventHandler());
		 	menu.add(manualPlay);
		 	menu.add(autoPlay);
		 	menuBar.add(menu);
		 	setJMenuBar(menuBar);
			setSize(1000, 1000);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);

	 }
	 
		private class menuEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
		//TODO:actionPerformed,
				clear();
				if(e.getSource() == autoPlay) {
					isAuto = true;
					int randomX = (int)(Math.random() * 8);
					int randomY = (int)(Math.random() * 8);

					knight = new Knight(randomX, randomY);

					chessArr[randomX][randomY].setBackground(Color.pink);
					chessArr[randomX][randomY].setText(knight.getCounter()+ "");

					while(knight.getCounter() < 64 )
					{	
						
						if( knight.getOptimalNext(knight.getRow(), knight.getCol()) != -1 ) {

							int bestNext = knight.getOptimalNext(knight.getRow(), knight.getCol());
							knight.move(bestNext);
							chessArr[knight.getRow()][knight.getCol()]
									.setText(""+ knight.getCounter());
							chessArr[knight.getRow()][knight.getCol()]
									.setBackground(Color.pink);
						}

					}

				}
				if(e.getSource() == manualPlay) {
					clear();
					isAuto = false;
					knight = new Knight();
				}
			}
		}
	 
	 public void clear() {		 
		 for(int i=0; i<8; i++) 
			 for(int j=0; j<8; j++) {
				 Color color = Color.white;	 
				 if((i+j)%2 ==1)
					 color= Color.black;
				 chessArr[i][j].setBackground(color);
			 }	 
	 }

}



