package app.MultiRacing;

import java.awt.event.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

class DefPanel extends JPanel implements ActionListener, KeyListener {


    //Purple Car Variables
   int purpCarRot = 12, purpDisplaceX = 425, purpDisplaceY = 500, purpSpeed = 0, purpDir = 0;
   String purpImgLoc = "Car Images/Purple Car/PurpCar";
   ImageIcon Purp[] = new ImageIcon[16];
   JLabel purpCarSpeed = new JLabel("Purple Car Speed:");
   JLabel purpCarSpeedVal = new JLabel();

    //Orange Car Variables
   int oranCarRot = 12, oranDisplaceX = 425, oranDisplaceY = 550, oranSpeed = 0, oranDir = 0;
   String oranImgLoc = "Car Images/Orange Car/OranCar";
   ImageIcon Oran[] = new ImageIcon[16];
   JLabel oranCarSpeed = new JLabel("Orange Car Speed:");
   JLabel oranCarSpeedVal = new JLabel();

    //Timer Class
   public Timer t;

   public DefPanel() {
   
        //Load Purple Car Images to array
      for (int i = 0; i < Purp.length; i++) {
         try {
            Purp[i] = new ImageIcon(purpImgLoc + i + ".png");
         } catch (Exception e) { }
      }
   
        //Load Orange Car Images to array
      for (int i = 0; i < Oran.length; i++) {
         try {
            Oran[i] = new ImageIcon(oranImgLoc + i + ".png");
         } catch (Exception e) { }
      }

   
      JLabel name = new JLabel("PurpCar and OranCar");
      name.setHorizontalAlignment(JLabel.CENTER);

      JLabel label = new JLabel();

      this.add(label);
      this.add(name);
      this.add(purpCarSpeed);
      this.add(purpCarSpeedVal);
      this.add(oranCarSpeed);
      this.add(oranCarSpeedVal);

      //setBackground(Color.blue);


      validate();
      
        //Set and Start Timer
      t = new Timer(25, this);
      t.start();
   
        //Enable Key Listener
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
   }

   public void actionPerformed(ActionEvent e) {
   
    //Purple Car Rotation
      purpCarRot = purpCarRot + purpDir;
      if(purpCarRot == -1){
         purpCarRot = 15;
      }
      else if(purpCarRot == 16){
         purpCarRot = 0;
      }
      purpDir = 0;
   
    //Orange Car Rotation
      oranCarRot = oranCarRot + oranDir;
      if(oranCarRot == -1){
         oranCarRot = 15;
      }
      else if(oranCarRot == 16){
         oranCarRot = 0;
      }
      oranDir = 0;
   
      repaint();
   }

   public void keyPressed(KeyEvent e) {
   
    //Purple Car Key inputs
      int p = e.getKeyCode();
      if (p == KeyEvent.VK_LEFT) {
         purpDir = -1;
      }
      if (p == KeyEvent.VK_RIGHT) {
         purpDir = 1;
      }
      if (p == KeyEvent.VK_UP) {
         purpSpeed = purpSpeed - 1;
      }
      if (p == KeyEvent.VK_DOWN) {
         purpSpeed = purpSpeed + 1;
      }
   
    //Orange Car Key inputs
      int o = e.getKeyCode();
      if (o == KeyEvent.VK_A) {
         oranDir = -1;
      }
      if (o == KeyEvent.VK_D) {
         oranDir = 1;
      }
      if (o == KeyEvent.VK_W) {
         oranSpeed = oranSpeed - 1;
      }
      if (o == KeyEvent.VK_S) {
         oranSpeed = oranSpeed + 1;
      }
   
   }
   @Override
   public void keyTyped(KeyEvent e) {}

   @Override
   public void keyReleased(KeyEvent e) {}

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
   
        //Map draw
      Color c1 = Color.green;
      g.setColor( c1 );
      g.fillRect( 150, 200, 550, 300 ); //grass
      Color c2 = Color.black;
      g.setColor( c2 );
      g.drawRect(50, 100, 750, 500); // outer edge
      g.drawRect(150, 200, 550, 300); // inner edge
      Color c3 = Color.yellow;
      g.setColor( c3 );
      g.drawRect( 100, 150, 650, 400 ); // mid-lane marker
      Color c4 = Color.white;
      g.setColor( c4 );
      g.drawLine( 425, 500, 425, 600 ); // start line
   
   
        //Purple Speed Limiter
      if(purpSpeed > 0) {
         purpSpeed = 0;
      }
      if(purpSpeed < -10) {
         purpSpeed = -10;
      }
   
    //Orange Speed Limiter
      if(oranSpeed > 0) {
         oranSpeed = 0;
      }
      if(oranSpeed < -10) {
         oranSpeed = -10;
      }
   
    //Purple Car Displacement
      if(purpCarRot == 0) {
         purpDisplaceX = purpDisplaceX + (0 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 1) {
         purpDisplaceX = purpDisplaceX + (1 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 2) {
         purpDisplaceX = purpDisplaceX + (2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 3) {
         purpDisplaceX = purpDisplaceX + (2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (1 * (purpSpeed*-1));
      }
      else if(purpCarRot == 4) {
         purpDisplaceX = purpDisplaceX + (2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (0 * (purpSpeed*-1));
      }
      else if(purpCarRot == 5) {
         purpDisplaceX = purpDisplaceX + (2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (-1 * (purpSpeed*-1));
      }
      else if(purpCarRot == 6) {
         purpDisplaceX = purpDisplaceX + (2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (-2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 7) {
         purpDisplaceX = purpDisplaceX + (1 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (-2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 8) {
         purpDisplaceX = purpDisplaceX + (0 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (-2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 9) {
         purpDisplaceX = purpDisplaceX + (-1 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (-2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 10) {
         purpDisplaceX = purpDisplaceX + (-2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (-2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 11) {
         purpDisplaceX = purpDisplaceX + (-2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (-1 * (purpSpeed*-1));
      }
      else if(purpCarRot == 12) {
         purpDisplaceX = purpDisplaceX + (-2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (0 * (purpSpeed*-1));
      }
      else if(purpCarRot == 13) {
         purpDisplaceX = purpDisplaceX + (-2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (1 * (purpSpeed*-1));
      }
      else if(purpCarRot == 14) {
         purpDisplaceX = purpDisplaceX + (-2 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (2 * (purpSpeed*-1));
      }
      else if(purpCarRot == 15) {
         purpDisplaceX = purpDisplaceX + (-1 * (purpSpeed*-1));
         purpDisplaceY = purpDisplaceY - (2 * (purpSpeed*-1));
      }
   
    //Orange Car Displacement
      if(oranCarRot == 0) {
         oranDisplaceX = oranDisplaceX + (0 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 1) {
         oranDisplaceX = oranDisplaceX + (1 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 2) {
         oranDisplaceX = oranDisplaceX + (2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 3) {
         oranDisplaceX = oranDisplaceX + (2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (1 * (oranSpeed*-1));
      }
      else if(oranCarRot == 4) {
         oranDisplaceX = oranDisplaceX + (2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (0 * (oranSpeed*-1));
      }
      else if(oranCarRot == 5) {
         oranDisplaceX = oranDisplaceX + (2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (-1 * (oranSpeed*-1));
      }
      else if(oranCarRot == 6) {
         oranDisplaceX = oranDisplaceX + (2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (-2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 7) {
         oranDisplaceX = oranDisplaceX + (1 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (-2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 8) {
         oranDisplaceX = oranDisplaceX + (0 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (-2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 9) {
         oranDisplaceX = oranDisplaceX + (-1 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (-2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 10) {
         oranDisplaceX = oranDisplaceX + (-2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (-2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 11) {
         oranDisplaceX = oranDisplaceX + (-2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (-1 * (oranSpeed*-1));
      }
      else if(oranCarRot == 12) {
         oranDisplaceX = oranDisplaceX + (-2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (0 * (oranSpeed*-1));
      }
      else if(oranCarRot == 13) {
         oranDisplaceX = oranDisplaceX + (-2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (1 * (oranSpeed*-1));
      }
      else if(oranCarRot == 14) {
         oranDisplaceX = oranDisplaceX + (-2 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (2 * (oranSpeed*-1));
      }
      else if(oranCarRot == 15) {
         oranDisplaceX = oranDisplaceX + (-1 * (oranSpeed*-1));
         oranDisplaceY = oranDisplaceY - (2 * (oranSpeed*-1));
      }
   
    //Purple Car Speed Indicator
      purpCarSpeedVal.setText(Integer.toString((purpSpeed*-1) * 10));
   
    //Orange Car Speed Indicator
      oranCarSpeedVal.setText(Integer.toString((oranSpeed*-1) * 10));
   
    //Paint cars in new location
      Purp[purpCarRot].paintIcon(this, g, (purpDisplaceX), (purpDisplaceY));
      Oran[oranCarRot].paintIcon(this, g, (oranDisplaceX), (oranDisplaceY));
   }

}