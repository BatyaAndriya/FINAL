package KursovaGameobject;

public class Snake {
	public int d = 0; //������ �����
	public int dlina = 10; //������� �����
	public int snakeX[]=new int[100]; //����������� ������� �������� ����� �� �
	public int snakeY[]=new int[100];//����������� ������� �������� ����� �� �
	public Snake(int x0, int y0, int x1, int y1) {//����������� �����
		snakeX[0] = x0;
		snakeY[0] = y0;
		snakeX[1] = x1;
		snakeY[1] = y1;
	}
	public void move() {
		for(int h = dlina; h > 0; h--) {//h-�������, ���� ��� ����������
			snakeX[h]=snakeX[h-1];
			snakeY[h]=snakeY[h-1];
			
		}
		if(d==0) snakeX[0]++;//����� ������
		if(d==1) snakeY[0]++;//����� ����
		if(d==2) snakeX[0]--;//����� ����
		if(d==3) snakeY[0]--;//����� �����
	
	for(int k=dlina-1; k>0; k--) {
		if(snakeX[0]==snakeX[k] & snakeY[0]==snakeY[k] )
			dlina=k-2;
	}
	if(dlina<2)
		dlina=2;}
}
