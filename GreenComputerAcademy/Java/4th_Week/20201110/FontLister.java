import java.awt.GraphicsEnvironment;

public class FontLister {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] font_list;
		GraphicsEnvironment g;
		g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		font_list = g.getAvailableFontFamilyNames();
		for(int i=0;i<font_list.length;i++){
			System.out.println(font_list[i]);
		}
	}

}
