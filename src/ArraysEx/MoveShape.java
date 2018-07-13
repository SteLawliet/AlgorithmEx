package ArraysEx;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-22 10:54
 **/
public class MoveShape extends JPanel {
    private int shapeSize;
    private int wid, hei;


    public MoveShape(int shapeSize, int wid, int hei) {
        this.shapeSize = shapeSize;
        this.wid = wid;
        this.hei = hei;
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        MoveShape mvShape = new MoveShape(40, 7, 14);
        jFrame.setResizable(true);
        jFrame.getContentPane().add(mvShape);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(mvShape.wid * mvShape.shapeSize, mvShape.hei * mvShape.shapeSize + 28);
        jFrame.setVisible(true);
        mvShape.control( 0, 0);
    }


    public void control0( int b, int a) {

    }


        public void control( int b, int a) {
        Scanner scanner = new Scanner(System.in);
        do {
            String next = scanner.nextLine();
            switch (next) {
                case "W":
                    b--;
                    break;
                case "S":
                    b++;
                    break;
                case "A":
                    a--;
                    break;
                case "D":
                    a++;
                    break;
                default:
            }
            if (a >= this.wid) {
                a = this.wid - 1;
            }
            if (a < 0) {
                a = 0;
            }
            if (b >= this.hei) {
                b = this.hei - 1;
            }
            if (b < 0) {
                b = 0;
            }
            this.move0(a, b, this.getGraphics());

        } while (true);
    }

    @Override
    public void paint(Graphics g0) {
        super.paint(g0);
        g0.setColor(Color.BLACK);
        System.out.println("paint.....");
        for (int i = 0; i < wid; i++) {
            for (int j = 0; j < hei; j++) {
                g0.drawRect(shapeSize * i, shapeSize * j, shapeSize, shapeSize);
            }
        }
    }

    public void move0(int a, int b, Graphics g) {
        g.setColor(Color.black);
        this.paint(g);
        for (int i = 0; i < wid; i++) {
            for (int j = 0; j < hei; j++) {
                if (i == a && j == b) {
                    g.fillRect(shapeSize * i, shapeSize * j, shapeSize, shapeSize);
                }
                if (i == a && j == b+1) {
                    g.fillRect(shapeSize * i, shapeSize * j, shapeSize, shapeSize);
                }
                if (i == a && j == b+2) {
                    g.fillRect(shapeSize * i, shapeSize * j, shapeSize, shapeSize);
                }
                if (i == a+1 && j == b) {
                    g.fillRect(shapeSize * i, shapeSize * j, shapeSize, shapeSize);
                    continue;
                }
                g.drawRect(shapeSize * i, shapeSize * j, shapeSize, shapeSize);
            }
        }
        System.out.println( a +" - "+ b);
    }
}
