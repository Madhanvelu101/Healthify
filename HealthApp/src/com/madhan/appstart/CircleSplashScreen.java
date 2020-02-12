package com.madhan.appstart;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleSplashScreen {
	private static CircleSplashScreen singleton_instance=null;
	private static String task;
	static JFrame frame;
	private CircleSplashScreen() {
        frame = new JFrame();
        frame.getContentPane().add(new ImagePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.pack();
        setLocation();
        //frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setSize(new Dimension(200,200));
        frame.setVisible(true);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CircleSplashScreen.class.getResource("/healthIcon.png")));
        frame.addMouseListener(new MouseAdapter() {
        	 @Override
             public void mouseClicked(MouseEvent event) {
                 // @todo need all factories
                 // showPopupMenu(mouseEvent);
        		  frame.setState ( Frame.ICONIFIED );
      	        frame.setVisible(false);
      	      System.exit(0);
             }

		});
        killAfterSomeTime();
    }
	
	public void setLocation() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame.getWidth();
        int y = 0;
        frame.setLocation(x, y);
	}
	
	public void killAfterSomeTime() {
		try {
			Thread.sleep(8000);
			System.out.println("Killing the frame");
			frame.dispose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getInstance(String taskDetails) {
		task=taskDetails;
		
		if(singleton_instance==null)
		{
			singleton_instance=new CircleSplashScreen();
		}else if(singleton_instance!=null){
			frame.dispose();
			singleton_instance=new CircleSplashScreen();
		}
		//return singleton_instance;
		
	}

  

    @SuppressWarnings("serial")
    public class ImagePanel extends JPanel {

        Image img;

        public ImagePanel() {
            setOpaque(false);
            setLayout(new GridBagLayout());
           // img=Toolkit.getDefaultToolkit().createImage("res\\water.gif");
           
           System.out.println(CircleSplashScreen.class.getResourceAsStream("/water.gif"));
            //img=Toolkit.getDefaultToolkit().createImage("res\\water.gif");
            /*try {
            	//img=(BufferedImage) Toolkit.getDefaultToolkit().createImage("e:/java/spin.gif");
                //img = ImageIO.read(new File("C:\\Users\\madhanv\\Pictures\\Img.png"));
            } catch (IOException ex) {
                Logger.getLogger(CircleSplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            }*/

           switch (task) {
		case "Water":
			 img=Toolkit.getDefaultToolkit().getImage(CircleSplashScreen.class.getResource("/water3.gif"));
			break;
		case "Blink":
			img=Toolkit.getDefaultToolkit().getImage(CircleSplashScreen.class.getResource("/blinkEye1.gif"));
			break;

		default:
			break;
		}
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }
    }
}