import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.Thread.*;

public class MyFrame extends JFrame {

//    Calendar calendar;
    SimpleDateFormat timeformat;
    SimpleDateFormat dayformat;
    SimpleDateFormat dateformat;

    JLabel timelabel;
    JLabel daylabel;
    JLabel datelabel;

    String time;
    String day;
    String date;
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);

        timeformat = new SimpleDateFormat("hh:mm:ss a");
        dayformat = new SimpleDateFormat("EEEE");
        dateformat = new SimpleDateFormat("dd MMMMM, yyyy");


        timelabel = new JLabel();
        timelabel.setFont(new Font("Verdana", Font.PLAIN,50));
        timelabel.setForeground(new Color(0x3d85c6));
        timelabel.setBackground(Color.black);
        timelabel.setOpaque(true);

        daylabel = new JLabel();
        daylabel.setFont(new Font("Verdana", Font.PLAIN,35));

        datelabel = new JLabel();
        datelabel.setFont(new Font("Verdana", Font.PLAIN,25));



        this.add(timelabel);
        this.add(daylabel);
        this.add(datelabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while(true) {
            time = timeformat.format(Calendar.getInstance().getTime());
            timelabel.setText(time);
            day = dayformat.format(Calendar.getInstance().getTime());
            daylabel.setText(day);
            System.out.println();
            date = dateformat.format(Calendar.getInstance().getTime());
            datelabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
