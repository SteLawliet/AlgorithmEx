package ArraysEx;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-19 22:22
 **/

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFanl extends JPanel {
    //size
    //paint
    //i,j
    //width height
    //
    public static final int size = 50;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new JFanl());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size * 8, 12 * size);
        frame.setVisible(false);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.PINK);

    }

    public void paint0(Graphics g) {
        g.setColor(Color.BLACK);
//        g.draw3DRect(25, 10, 50, 75, true);
//        g.draw3DRect(25, 110, 50, 75, false);
//        g.fill3DRect(100, 10, 50, 75, true);
//        for (int i = 0; i <  ; i++) {
//        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 12; j++) {
                g.drawRect(size * i, size * j, size, size);
            }
        }
    }
}

