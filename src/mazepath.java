import java.util.Iterator;
import java.util.Stack;


public class mazepath {
	public static Node[][] Maze;
	public static Stack MazeStack;
	enum dir{up,down,left,right};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Init();
		//System.out.println(Maze[0][0].status);
		MazeStack=new Stack<Node>();
		Node Start=Maze[1][1];
		//System.out.println(Maze[1][1].status);
		Node End=Maze[8][8];
		Node Position=Start;
		do{
			//System.out.println(Position.row+"  "+Position.col);
			if(!Position.status){
				MazeStack.push(Position);
				Position.status=true;
				if(Position.equals(End)){
					System.out.println("Get out��");
					break;
				}else{
					Position.next=dir.down;
					Position=Maze[Position.row][Position.col+1];
				}
			}else{
				if(!MazeStack.isEmpty()&&(Position=(Node)MazeStack.peek()).next!=dir.right){
					//System.out.println("��ʱ��ջ��Ԫ��"+Position.row+"  "+Position.col);
					//�ҵ�ջ��λ�õ���һ���ڿ�
					if(Position.next==dir.down){
						Position.next=dir.left;
						Position=Maze[Position.row+1][Position.col];
					}
					else if(Position.next==dir.left){
						Position.next=dir.up;Position=Maze[Position.row][Position.col-1];
						
					}
					else if(Position.next==dir.up){
						Position.next=dir.right;Position=Maze[Position.row+1][Position.col];
						
					}
					else if(Position.next==dir.right){
						Position.next=dir.down;Position=Maze[Position.row][Position.col+1];
					}
					
				}else if(!MazeStack.isEmpty()&&(Position=(Node)MazeStack.peek()).next==dir.right){
					MazeStack.pop();
					//System.out.println("��ջ����"+Position.row+"  "+Position.col);
					Position=(Node)MazeStack.peek();
				}
			}
		}while(!MazeStack.isEmpty());
		if(MazeStack.isEmpty())
			System.out.println("���Թ��޽�");
		else{
			System.out.println("ջ��Ԫ��"+MazeStack.size());
			for(int i=0;i<MazeStack.size();i++){
				System.out.println(((Node)MazeStack.get(i)).row+" "+((Node)MazeStack.get(i)).col);
			}
		}
	}
	
	public static void Init(){
		int i,j;
		Maze=new Node[10][10];//10*10���Թ�
		for(i=0;i<10;i++)
			for(j=0;j<10;j++){
				Maze[i][j]=new Node();
				Maze[i][j].row=i;
				Maze[i][j].col=j;
			}
		//��ʼ���Թ�
		for(i=0;i<Maze[0].length;i++){
			Maze[0][i].status=true;
			Maze[Maze[0].length-1][i].status=true;
		}
		for(j=1;j<Maze[0].length-1;j++){
			Maze[j][0].status=true;
			Maze[j][Maze[0].length-1].status=true;
		}
		Maze[1][3].status=true;
		Maze[1][7].status=true;
		Maze[2][3].status=true;
		Maze[2][7].status=true;
		Maze[3][5].status=true;
		Maze[3][6].status=true;
		Maze[4][2].status=true;
		Maze[4][3].status=true;
		Maze[4][4].status=true;
		Maze[5][4].status=true;
		Maze[6][2].status=true;
		Maze[6][6].status=true;
		Maze[7][2].status=true;
		Maze[7][3].status=true;
		Maze[7][4].status=true;
		Maze[7][6].status=true;
		Maze[7][7].status=true;
		Maze[8][1].status=true;
	}
	static class Node{
		public int ord;  //ͨ������·���е����
		public boolean status; //ͨ�����Ƿ��ͨ
		public dir next;//ͨ�������һ������
		public int row;//�к�
		public int col;//�к�
		
		public Node(){
			status=false;
			next=dir.right;
		}
	}

}
