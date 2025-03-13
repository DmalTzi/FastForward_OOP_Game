package Ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

class RoundedProgressBarUI extends BasicProgressBarUI {
    private int arc = 20; // กำหนดความโค้งมน

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = progressBar.getWidth();
        int height = progressBar.getHeight();
        int progress = (int) (width * progressBar.getPercentComplete());

        // วาดพื้นหลัง (ขอบมน)
        g2.setColor(progressBar.getBackground());
        g2.fillRoundRect(0, 0, width, height, arc, arc);

        // วาดแถบโหลด (ขอบมน)

        g2.setColor(progressBar.getForeground());
        g2.fillRoundRect(0, 0, progress, height, arc, arc);

        // วาดเส้นขอบ
        g2.setColor(new Color(232,232,232));
        g2.drawRoundRect(0, 0, width - 1, height - 1, arc, arc);
    }
}
