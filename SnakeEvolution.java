package KursovaGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel; //��������� �� �������� �� ��������
import javax.swing.Timer;

import KursovaGameobject.Snake;//��������� ���� ����� � ����� snake

public class SnakeEvolution extends JPanel implements ActionListener {//������������� ������� ����

	public static final int PIX = 40; //������� ������ 1 ������ �������
	public static final int SHIR = 20; //������
	public static final int VIS = 15; //������
	public static final int SPEED =5; // ������ ���� 10 ���� �� �������

	Snake s = new Snake(1,1,0,1);//k��������� �����
	Timer t = new Timer(1000/SPEED, this);
	public SnakeEvolution() {//��������� ����������� ��� ����̲�����
	t.start();
	addKeyListener(new Key());
	setFocusable(true);
	}
	public void paint(Graphics q) {
		q.setColor(color(5, 200, 0));//���� ����
		q.fillRect(0, 0, SHIR*PIX, VIS*PIX);//����������� ���
		//q.setColor (color(250,0,0));//���� ���
		//������� ��
		
	for(int xx= 0; xx<=SHIR*PIX; xx+=PIX) {//������� ���������� ��
			q.drawLine(xx, 0, xx, VIS*PIX);			
		}
for(int yy= 0; yy<=VIS*PIX; yy+=PIX) {
			q.drawLine(0, yy, SHIR*PIX, yy);			
		}
		for(int h=0;h<s.dlina;h++) {
			q.setColor(color(250, 216,0));//���� �����
			q.fillRect(s.snakeX[h]*PIX+1, s.snakeY[h]*PIX+1, PIX-1, PIX-1);//�������� ����� ������� �������
			}
	}
	public Color color(int RED, int GREEN, int BLUE){//��� �������
		return new Color(RED, GREEN, BLUE);
	}
	public static void main(String[] args) {//������� �������
		JFrame f = new JFrame();//������ ������ 
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
if ((key==KeyEvent.VK_RIGHT)& s.d !=2)s.d =0;//�������� ���� �����
if ((key==KeyEvent.VK_DOWN)& s.d !=3)s.d =1;
if ((key==KeyEvent.VK_LEFT)& s.d !=0)s.d =2;
if ((key==KeyEvent.VK_UP)& s.d !=1)s.d =3;}}

	public void actionPerformed(ActionEvent e ) {//��� ���� ���������� ���� �����
		s.move();
		repaint();
		
	}}
