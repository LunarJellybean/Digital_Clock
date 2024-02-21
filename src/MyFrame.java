import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.Thread.*;

public class MyFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeformat;
    JLabel timelabel;
    String time;
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);

        timeformat = new SimpleDateFormat("hh:mm:ss a");

        timelabel = new JLabel();
        timelabel.setFont(new Font("Verdana", Font.PLAIN,50));
        timelabel.setForeground(new Color(0x3d85c6));

        this.add(timelabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while(true) {
            time = timeformat.format(Calendar.getInstance().getTime());
            timelabel.setText(time);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
