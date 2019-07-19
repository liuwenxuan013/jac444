import java.util.ArrayList;

public class Knight {
	private static final int[] horizontal = new int[] {2, 1, -1,-2,-2,-1, 1, 2};
	private static final int[] vertical = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
	private int row;
	private int col;
	private int counter = 0;
	int[][] chessArr;

	public Knight() {

		row = -1;
		col = -1;
		setCounter(0);
		chessArr = new int[8][8];
		for(int i=0; i<8; i++ )
			for(int j=0; j<8; j++)
				chessArr[i][j] = 1;
	
	}
	//TODO:FOR WHAT?
	public Knight(int x, int y) {
		super();
		this.row = x;
		this.col = y;
		this.setCounter(1);
		this.chessArr = new int[8][8];
		for(int i=0; i<8; i++ )
			for(int j=0; j<8; j++)
				chessArr[i][j] = 1;
		chessArr[x][y] = 0;
		
	}
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void move(int pos) {
		row += vertical[pos];
		col += horizontal[pos];
		chessArr[row][col] = 0;
		setCounter(getCounter() + 1);	
	}
	
	public int testNextMove(int x, int y, int pos) {
		x += vertical[pos];
		y += horizontal[pos];
		return getIntentMove(x, y);

	}
	
	public ArrayList<Integer> getIntent(int x, int y ){
		ArrayList<Integer> adviceNext = new ArrayList<Integer>();
		int accessMove = 8;
		for(int i: getIntentNextMove(x, y))
			if(testNextMove(x, y, i) < accessMove)
				accessMove = testNextMove(x, y, i);
		
		for(int i: getIntentNextMove(x, y))
			if(testNextMove(x, y, i) == accessMove)
				adviceNext.add(i);
		return adviceNext;
	}
	
	public ArrayList<Integer> getIntentNextMove(int x, int y ) {
	
		ArrayList<Integer> intentMove = new ArrayList<Integer>();
		for(int i=0; i<8; i++) {
			boolean isInBoard = x + vertical[i]>=0 &&  x + vertical[i] < 8
					 &&	y+ horizontal[i] >=0 && y+ horizontal[i]<8;

			if(isInBoard &&  chessArr[x + vertical[i]][y+ horizontal[i]] ==1)
				intentMove.add(i);
		}	
		return  intentMove;
		
	}
	public boolean isMove(int x, int y) {
		boolean valid = false;
		ArrayList<Integer> isNextMove = getIntentNextMove( getRow(), getCol() );
		for(int i : isNextMove) {
			if( getRow() + vertical[i] == x && getCol() + horizontal[i] == y ) {
				valid = true;			
				move(i);
			}
		}
		return valid;
	}
	
	public int getIntentMove(int x, int y) {
		return getIntentNextMove(x, y).size();
	}
	
	public int getOptimalNext(int x, int y) {
		int bestNext = -1;
		int accessNumber=8;
	//TODO:accessNumber
		ArrayList<Integer> intentNext = getIntent(x, y);
		if(intentNext.size() != 0)
			bestNext = intentNext.get(0);
		
		if(intentNext.size() > 1) {
				int nextX = x;
				int nextY = y;
				for(int i : intentNext) {
					nextX += vertical[i];
					nextY += horizontal[i];
					if(getIntentMove(nextX, nextY)< accessNumber)
						accessNumber = getIntentMove(nextX, nextY);
			
				}
			//TODO:getAccessNumber,accessNumber

				for(int i : intentNext) {
					nextX += vertical[i];
					nextY += horizontal[i];
					if(getIntentMove(nextX, nextY) == accessNumber)
						bestNext = i;
				}			
			}		

		return bestNext;

	}

}
