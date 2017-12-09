package KursovaGameobject;

import KursovaGame.SnakeEvolution;

public class Apple {

	SnakeEvolution main; //������ ��������� �����
	
	public int posX; //������� �
	public int posY;//������� Y
	
	public Apple(int startX, int startY) {
		posX = startX;//������� ������ �
		posY = startY;//������� ������ Y
	}
	
	@SuppressWarnings("static-access")//����������� � �����
	public void setRandomPosition() {
		posX = (int) (Math.random()*main.SHIR);//(int) ������������ �� ������ ����� � �������
		posY = (int) (Math.random()*main.VIS);
	}
}
