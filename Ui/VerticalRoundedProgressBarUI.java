package Ui;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

class VerticalRoundedProgressBarUI extends BasicProgressBarUI {
    private final int arc = 20; // กำหนดความโค้งมน

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = progressBar.getWidth();
        int height = progressBar.getHeight();
        int progress = (int) (height * progressBar.getPercentComplete());

        // วาดพื้นหลัง (ขอบมน)
        g2.setColor(progressBar.getBackground());
        g2.fillRoundRect(0, 0, width, height, arc, arc);

        // วาดแถบโหลด (ขอบมน) **จากล่างขึ้นบน**
        g2.setColor(progressBar.getForeground());
        g2.fillRoundRect(0, height - progress, width, progress, arc, arc);
    }
}