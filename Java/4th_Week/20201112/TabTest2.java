import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

public class TabTest2 extends JFrame implements ActionListener{
	JTabbedPane tab;
	JLabel lblColor;
	JLabel lblFont;
	JLabel lblText;
	JButton btnColor;
	JSpinner spinner;
	JTextField text;
	JButton applyBtn;
	JPanel pnlLbl;
	JPanel pnlCenter;
	JPanel pnlInput;
	JPanel pnlColor;
	JPanel pnlContent;
	JTextArea ta;
	Color color;
	SpinnerListModel listmodel;
	Font[] fonts;
	String[] fontlist;
	public TabTest2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		pnlLbl = new JPanel();
		pnlCenter = new JPanel();
		pnlInput = new JPanel();
		pnlColor = new JPanel();
		pnlContent = new JPanel();
		
		tab = new JTabbedPane();
		lblColor = new JLabel("색상");
		lblFont = new JLabel("폰트");
		lblText = new JLabel("내용");
		
		pnlLbl.add(lblColor);
		pnlLbl.add(lblFont);
		pnlLbl.add(lblText);
		pnlLbl.setLayout(new GridLayout(0,1,10,20));
		
		btnColor = new JButton("색상 선택");
		btnColor.addActionListener(this);
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fonts = e.getAllFonts();
		fontlist = new String[fonts.length];
		for(int i =0;i<fonts.length;i++){
			fontlist[i] = fonts[i].getFontName();
		}
		listmodel = new SpinnerListModel(fontlist){
			@Override
			public Object getNextValue() {
				// TODO Auto-generated method stub
				String cur = (String)this.getValue();
				
					for(int i=0;i<fontlist.length;i++){
						
						if(cur.equals(fontlist[i])){
							if(i==50){
								i=65;
							}
							cur = fontlist[i+1];
							break;
						}
					}
				return cur;
			}
			@Override
			public Object getPreviousValue() {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String cur = (String)this.getValue();
				
					for(int i=0;i<fontlist.length;i++){
						if(cur.equals(fontlist[i])){
							
							if(i==66){
								i=51;
							}
							cur = fontlist[i-1];
							break;
						}
					}
				return cur;
			}
		};
		spinner = new JSpinner(listmodel);
		text = new JTextField(20);
		pnlCenter.add(btnColor);
		pnlCenter.add(spinner);
		pnlCenter.add(text);
		pnlCenter.setLayout(new GridLayout(0,1,10,20));
		
		applyBtn = new JButton("적용");
		applyBtn.addActionListener(this);
		pnlInput.setLayout(new BorderLayout());
		pnlInput.add(pnlLbl,"West");
		pnlInput.add(pnlCenter);
		pnlInput.add(applyBtn,"South");
		
		ta = new JTextArea(14,30);
		pnlContent.add(ta);
		
		tab.add(pnlInput,"입력");
		tab.add(pnlColor,"색상");
		tab.add(pnlContent,"내용");
		
		add(tab);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TabTest2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnColor){
			color = JColorChooser.showDialog(this, "컬러 선택", Color.BLACK);
		}else if(e.getSource()== applyBtn){
			pnlColor.setBackground(color);
			Font fontS = null;
			for(int i =0;i<fontlist.length;i++){
				if(fontlist[i].equals(listmodel.getValue().toString())){
					fontS = new Font(fontlist[i], Font.PLAIN,20 );
				}
				
			}
			ta.setFont(fontS);
			ta.append(text.getText()+"\n");
			text.selectAll();
		}
		
	}

}
