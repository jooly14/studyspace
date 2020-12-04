import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

//������� ����� �ڵ�!!
class ThreadEx10Sub extends Thread{
   ThreadEx10 te;
   boolean isSt;// false
   public ThreadEx10Sub(ThreadEx10 te) {
      this.te=te;
   }   
   
   @Override
   public void run() {
      
      while(true){
         te.setLbl((new Date()).toString());
      }
   }
}

class ThreadEx10Sub2 extends Thread{
   ThreadEx10 te;
   public ThreadEx10Sub2(ThreadEx10 te) {
      this.te=te;
   }
   @Override
   public void run() {
      for(int i=0; i<=100;i++){
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         te.setProValue(i);
      }
   }
}


public class ThreadEx10 extends JFrame implements ActionListener{
   JProgressBar progress;    
    JButton btn;
    JLabel lbl;
    ThreadEx10Sub te;
    ThreadEx10Sub2 te2;
    public ThreadEx10() {
       te = new ThreadEx10Sub(this);
       te2 = new ThreadEx10Sub2(this);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 150);
        this.setLayout(new FlowLayout());
        progress = new JProgressBar();
        // �ּҰ��� 0,�ִ밪�� 100���� ǥ��
        // progress.setValue(0);//0���� ����.���� ��������
        // ǥ��
        progress.setStringPainted(true);
        // true�� �����ϸ� ���� �����Ȳ�� %�� ǥ����.
        this.add(progress);        
        
        btn = new JButton("����");
        btn.addActionListener(this);
        this.add(btn);
        
        lbl = new JLabel();
        this.add(lbl);
        
        te.start();        

        this.setVisible(true);
    } 
    
    void setProValue(int x){
       progress.setValue(x);
    }
    
    void setLbl(String d){
       lbl.setText(d);
    }
    public static void main(String[] args) {
      new ThreadEx10();
   }
   @Override
   public void actionPerformed(ActionEvent arg0) {
      //te.setSt();// true �ٲ�鼭 ���α׷��� ����
      te2.start();
   }
   
   
}