package ArraysEx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-20 11:30
 **/
public class Shape extends Panel {
    public static JFrame jFrame;

    static {
        jFrame = new JFrame();
    }

    public Graphics g;
    public Color c = Color.PINK;
    private int shapeSize;
    //paint
    //i,j
    private int wid, hei;

    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.initial(5, 8, 40);
        shape.c = Color.BLACK;
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while (true) {
            String nextLine = scanner.nextLine();
            System.out.println("nextLine = " + nextLine);
            shape.c = flag ? Color.PINK : Color.cyan;
            flag = !flag;
            System.out.println("flag = " + flag);
            Graphics graphics = shape.getGraphics();
            shape.update(graphics);
            for (int i = 0; i < shape.wid; i++) {
                for (int j = 0; j < shape.hei; j++) {
                    graphics.fillRect(shape.shapeSize * i, shape.shapeSize * j, shape.shapeSize, shape.shapeSize);
                }
            }

        }
    }

    public int getShapeSize() {
        return shapeSize;
    }

    public void setShapeSize(int shapeSize) {
        this.shapeSize = shapeSize;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public int getHei() {
        return hei;
    }

    public void setHei(int hei) {
        this.hei = hei;
    }

    public void initial(int wid, int hei, int shapeSize) {
        this.setWid(wid);
        this.setHei(hei);
        this.shapeSize = shapeSize;
        jFrame.getContentPane().add(this);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(wid * shapeSize, hei * shapeSize + 50);
        JButton button = new JButton("⬆️");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("⬆️");
            }
        });
//        jFrame.add(button);
        jFrame.setVisible(true);
    }

    public void paint(Graphics g) {
        System.out.println("paint.....");
        super.paint(g);
        this.g = g;
        g.setColor(c);
        for (int i = 0; i < wid; i++) {
            for (int j = 0; j < hei; j++) {
                g.drawRect(shapeSize * i, shapeSize * j, shapeSize, shapeSize);
            }
        }
        boolean f = true;
        try {
            Thread.sleep(500);
//            this.repaint();
            g.setColor(Color.PINK);
            for (int j = 0; j < hei; j++) {
                for (int i = 0; i < wid; i++) {
                    g.setColor(f ? Color.black : Color.white);
                    Thread.sleep(150);
                    g.drawRect(shapeSize * i, shapeSize * j, shapeSize, shapeSize);
                    f = !f;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    public void move0(int a, int b, Graphics g) {
//        g.setColor(Color.black);
//        this.paint(g);
//        for (int i = 0; i < wid; i++) {
//            for (int j = 0; j < hei; j++) {
//                if (i == a && j == b) {
//                    g.fillRect(shapeSize * i,
//                            shapeSize * j, shapeSize, shapeSize);
//                    continue;
//                }
//                g.drawRect(shapeSize * i,
//                        shapeSize * j, shapeSize, shapeSize);
//            }
//        }
//        System.out.println(a + " - " + b);
//    }



//        g.draw3DRect(25, 10, 50, 75, true);
//        g.draw3DRect(25, 110, 50, 75, false);
//        g.fill3DRect(100, 10, 50, 75, true);
}
