package org.maxsys.mypwd;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.imageio.ImageIO;
import javax.swing.JWindow;

public class SImg extends JWindow {

    OpacityChanger tr;
    BufferedImage back = null;
    BufferedImage image = null;
    float[] scales = {1f, 1f, 1f, 0.0f};
    float[] offsets = new float[4];

    public SImg() {
        try {
            image = ImageIO.read(getClass().getResource("/org/maxsys/mypwd/database.png"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        setSize(image.getWidth(), image.getHeight());
        setLocationRelativeTo(null);
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        try {
            Robot r = new Robot();
            back = r.createScreenCapture(getBounds());
        } catch (AWTException ex) {
            System.out.println(ex.toString());
        }

        tr = new OpacityChanger();
    }

    private class OpacityChanger extends Thread {

        private Float fl = 0f;
        private Integer i = 0;
        private final Integer interval1 = 5;
        private final Integer interval2 = 10;
        private final Integer interval3 = 500;
        private Integer cycles = 5;
        Boolean Running = true;

        @Override
        public void run() {
            while (Running && cycles > 0) {
                while (i < 100) {
                    try {
                        sleep(interval1);
                    } catch (InterruptedException e) {
                    }
                    fl = Float.valueOf(i) / 100;
                    setOpacity(fl);
                    i = i + 1;
                }
                try {
                    sleep(interval3);
                } catch (InterruptedException e) {
                }
                while (i > 50) {
                    try {
                        sleep(interval2);
                    } catch (InterruptedException e) {
                    }
                    fl = Float.valueOf(i) / 100;
                    setOpacity(fl);
                    i = i - 1;
                }
                cycles--;
            }
            dispose();
        }

        public void Stop() {
            Running = false;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (g != null) {
            BufferedImage splash = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            Graphics2D sg = (Graphics2D) splash.getGraphics();
            RescaleOp op = new RescaleOp(scales, offsets, null);

            sg.drawImage(back, null, 0, 0);
            sg.drawImage(image, op, 0, 0);

            g.drawImage(splash, 0, 0, null);
        }
    }

    private void setOpacity(Float opacity) {
        scales[3] = opacity;
        paint(getGraphics());
    }

    void siShow() {
        setAlwaysOnTop(false);
        setAlwaysOnTop(true);
        setVisible(true);
        tr.start();
    }

    void siClose() {
        setAlwaysOnTop(false);
        tr.Stop();
    }
}
