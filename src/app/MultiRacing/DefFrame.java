package app.MultiRacing;

import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

class DefFrame extends JFrame
{
   DefFrame()
   {
      //New JPanel I defined
      JPanel pnl = new DefPanel();

      //Size of window
      setSize(850, 650);

      //Window in middle of screen
      setLocationRelativeTo(null);

      //Adds JPanel to JFrame
      add(pnl);



      //Closes program when you press X
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}