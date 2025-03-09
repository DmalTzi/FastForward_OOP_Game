package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ปิดแล้วโปรแกรมหยุดทำงาน
        window.setResizable(false); // ล๊อคจอ
        window.setTitle("NO time to see you because I'm working hard I sus");
        GamePanel gamepanal = new GamePanel();
        
        window.add(gamepanal);
        window.pack();
        window.setLocationRelativeTo(null); // กลางจอ
        window.setVisible(true); // ให้เห็น
        gamepanal.StartGameThread();
    }
}