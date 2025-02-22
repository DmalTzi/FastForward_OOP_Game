package Main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ปิดแล้วโปรแกรมหยุดทำงาน
        window.setResizable(false); // ล๊อคจอ
        window.setTitle("NO time to see you because am work hard I sus");
        GamePanal gamepanal = new GamePanal();
        window.add(gamepanal);
        window.pack();
        window.setLocationRelativeTo(null); // กลางจอ
        window.setVisible(true); // ให้เห็น
        gamepanal.StartGameThread();
    }
}
