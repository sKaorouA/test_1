package ������;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class calculator extends JFrame implements ActionListener{
	/*����ؼ�*/
	private JPanel jp_north=new JPanel();
	private JTextField input_text=new JTextField();
	private JButton c_Btn=new JButton("c");
	
	/*�м�Ŀؼ�*/
	private JPanel jp_center= new JPanel();
	
	public calculator() throws HeadlessException {
		this.init();
		this.addNorthComponent();
		this.addCenterButton();
	}
	//��ʼ���ķ���
	public void init() {
		this.setTitle("������");//����
		this.setSize( 300,300);//���ڴ�С
		this.setLayout( new BorderLayout());//
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//��ӱ���ؼ�
	public void addNorthComponent() {
		this.input_text.setPreferredSize(new Dimension(230,30));//����������С
		jp_north.add(input_text);//��������
		jp_north.add(c_Btn);//��Ӱ�ťc
		
		c_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {//���
			    input_text.setText("");	
			}
		});
		this.add(jp_north,BorderLayout.NORTH);
	}
	
	//����м�İ�ť
	public void addCenterButton() {
		String btn_text="123+456-789*0.=/";
		this.jp_center.setLayout(new GridLayout(4,4));//����4*4�İ�ť
		for(int i=0;i<16;i++) {
			String temp =btn_text.substring(i,i+1);//��ȡһ���ַ�
			JButton btn =new JButton();
			btn.setText(temp);
			btn.addActionListener((ActionListener) this);//������
			jp_center.add(btn);
		}
		this.add(jp_center,BorderLayout.CENTER);//����ť����
	}
	
	public static void main(String[] args) {
		calculator calculator = new calculator();
		calculator.setVisible(true);
	}
	
	private String firstInput=null;
	private String operator= null;
	@Override
	public void actionPerformed(ActionEvent e) {
		String clickStr=e.getActionCommand();
		if(".0123456789".indexOf(clickStr)!=-1) {
			this.input_text.setText(input_text.getText()+clickStr);//��������������뵽text��
		}else if(clickStr.matches("[\\+\\-*/]{1}")) {
			    operator=clickStr;
				firstInput = this.input_text.getText();//��ȡ��һ������
				this.input_text.setText("");//��������������
		}else if(clickStr.equals("=")) {
			Double a= Double.valueOf(firstInput);
			Double b= Double.valueOf(this.input_text.getText());
			Double result=null;
			switch(operator){
				case"+":
					result=a+b;
					break;
				case"-":
					result =a-b;
					break;
				case"*":
					result =a*b;
					break;
				case"/":
					if(b!=0) {
					result =a/b;	
			}
			break;
		}
		    this.input_text.setText(result.toString());
		}
	}
}