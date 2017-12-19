package KursovaGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel; //��������� �� �������� �� ��������
import javax.swing.Timer;

import KursovaGameobject.Apple;
import KursovaGameobject.Snake;//��������� ���� ����� � ����� snake
import KursovaGameobject.Snake2;
public class SnakeEvolution extends JPanel implements ActionListener {//������������� ������� ����

	public static final int PIX = 40; //������� ������, 1 ������ �������
	public static final int SHIR = 20; //������
	public static final int VIS = 15; //������
	public static final int SPEED =4; // ������ ���� 4 ���� �� �������;
	Apple a = new Apple( (int) (Math.random()*SHIR), (int) (Math.random()*VIS));//���������� ������
	Snake s = new Snake(1,1,0,1);//k��������� �����
	Snake2 s2 = new Snake2(1,13,0,13);
	Timer t = new Timer(1000/SPEED, this);
	public SnakeEvolution() {//��������� ����������� ��� ����̲�����
	t.start();
	addKeyListener(new Key());
	setFocusable(true);
	}
	public void paint(Graphics q) {
		q.setColor(color(50, 150, 50));//���� ����
		q.fillRect(0, 0, SHIR*PIX, VIS*PIX);//����������� ���
		//q.setColor (color(5,255,0));//���� ���
		//������� ��
		
	for(int xx= 0; xx<=SHIR*PIX; xx+=PIX) {//������� ���������� ��
			q.drawLine(xx, 0, xx, VIS*PIX);			
		}
for(int yy= 0; yy<=VIS*PIX; yy+=PIX) {
			q.drawLine(0, yy, SHIR*PIX, yy);			
		}
		for(int h=0;h<s.dlina;h++) {
			q.setColor(color(208, 104,0));//���� �����
			q.fillRect(s.snakeX[h]*PIX, s.snakeY[h]*PIX, PIX+1, PIX+1);//�������� ����� ������� �������
			q.setColor(color(0, 0,255));//���� �����
			q.fillRect(s.snakeX[h]*PIX+2, s.snakeY[h]*PIX+2, PIX-3, PIX-3);//�������� ����� ������� �������
			q.setColor(color(255, 255,255));//���� �����
			q.fillRect(s.snakeX[h]*PIX+10, s.snakeY[h]*PIX+10, PIX-32, PIX-32);//�������� ����� ������� �������
				}
		for(int h=0;h<s2.dlina2;h++) {q.setColor(color(208, 104,0));//���� �����
		q.fillRect(s2.snake2X[h]*PIX, s2.snake2Y[h]*PIX, PIX+1, PIX+1);//�������� ����� ������� �������
		q.setColor(color(250, 216,0));//���� �����
		q.fillRect(s2.snake2X[h]*PIX+2, s2.snake2Y[h]*PIX+2, PIX-3, PIX-3);//�������� ����� ������� �������
		q.setColor(color(255, 255,255));//���� �����
		q.fillRect(s2.snake2X[h]*PIX+10, s2.snake2Y[h]*PIX+10, PIX-32, PIX-32);//�������� ����� ������� �������
		}
		q.setColor(color(255,0,0));//���� ������
		 q.fillOval(a.posX*PIX+1, a.posY*PIX+1, PIX, PIX);
		 q.setColor(color(255,255,255));//���� ������
		 q.fillOval(a.posX*PIX+7, a.posY*PIX+10, PIX/6, PIX/2);
		//q.fillRect(a.posX*PIX+1, a.posY*PIX+1, PIX-1, PIX-1);
	}
	public Color color(int RED, int GREEN, int BLUE){//��� �������
		return new Color(RED, GREEN, BLUE);
	}
	public static void main(String[] args) {//������� �������
	

		
		JFrame f = new JFrame();//������ ������ 
		f.setTitle("SnakeEvolution: ����������� �����");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //��� ���������� ��������
		f.setResizable(false);
		f.setSize(SHIR*PIX+7, VIS*PIX+29);//������ ������ ������
		f.add(new SnakeEvolution());
		f.setLocationRelativeTo(null);//���� �� ������
		f.setVisible(true);
	
			}
	

	private class Key extends KeyAdapter{//���� ��� �����
public void keyPressed(KeyEvent kE) {//������ ������
int key = kE.getKeyCode();
if ((key==KeyEvent.VK_D & s.d !=2))s.d =0;//�������� ���� �����
if ((key==KeyEvent.VK_S & s.d !=3))s.d =1;
if ((key==KeyEvent.VK_A & s.d !=0))s.d =2;
if ((key==KeyEvent.VK_W & s.d !=1))s.d =3;
if (key==KeyEvent.VK_RIGHT & s2.d2 !=2)s2.d2 =0;//�������� ���� �����
if (key==KeyEvent.VK_DOWN & s2.d2 !=3)s2.d2 =1;
if (key==KeyEvent.VK_LEFT & s2.d2 !=0)s2.d2 =2;
if (key==KeyEvent.VK_UP & s2.d2 !=1)s2.d2 =3;}}

	public void actionPerformed(ActionEvent e ) {//��� ���� ���������� ���� �����
		s.move();
		s2.move();
		if((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {//������� �����
			a.setRandomPosition();//���� ������� ������ ���� �������
			s.dlina++;
		}
		if((s2.snake2X[0] == a.posX) & (s2.snake2Y[0] == a.posY)) {//������� �����
			a.setRandomPosition();//���� ������� ������ ���� �������
			s2.dlina2++;
		}
		for(int f=1; f < s.dlina; f++) {
			if((s.snakeX[f] == a.posX) & (s.snakeY[f] == a.posY)) {//���� ����� ������ �� �쳿
				a.setRandomPosition();}//���� ����� ������
		}
		for(int f=1; f < s2.dlina2; f++) {
			if((s2.snake2X[f] == a.posX) & (s2.snake2Y[f] == a.posY)) {//���� ����� ������ �� �쳿
				a.setRandomPosition();}//���� ����� ������
		
			
		}
		for(int k=s.dlina; k>0; k--) {
			if(s.snakeX[0]==s2.snake2X[k] & s.snakeY[0]==s2.snake2Y[k] )//������� ����� �쳿 �����
				s2.dlina2=k;
		}
		for(int k=s2.dlina2; k>0; k--) {
			if(s2.snake2X[0]==s.snakeX[k] & s2.snake2Y[0]==s.snakeY[k] )//������� ����� �쳿 �����
				s.dlina=k;
		}
		
		if((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {
			a.setRandomPosition();
			s.dlina++;
		}
		if((s2.snake2X[0] == a.posX) & (s2.snake2Y[0] == a.posY)) {
			a.setRandomPosition();
			s2.dlina2++;
		}
		repaint();		
	}}