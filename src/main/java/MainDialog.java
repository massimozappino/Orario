import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JEditorPane inputPane;
    private JEditorPane outputPane;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void onOK() throws ParseException {
        TimeTable t;
        String s;
        String day = "";
        String cartellino = inputPane.getText();
        outputPane.setText("");
        if(cartellino.indexOf("\t") > 0)
        {
            for(String riga : cartellino.split("\n"))
            {
                if(riga.startsWith("Timbrature:"))
                {
                    s = riga.substring(riga.indexOf("\t")+1);
                    if(!s.equals(" - "))
                    {
                        t = new TimeTable(s);
                        String text = day + "\n";

                        text += "\t\t\t" + t.getTimeWorked() + "\n";
                        text += "\t\t\t" + t.toString() + "\n";
                        outputPane.setText(outputPane.getText() + text + "\n");
                    }
                }
                else
                {
                    day = riga.substring(Math.max(0, riga.indexOf("Ì")+1), Math.max(0, riga.indexOf("\t")));
                }
            }
        }
        else
        {
            t = new TimeTable(cartellino);
            System.out.print(t.getTimeWorked());
            System.out.println("\t\t\t" + t.toString());
        }



    }

    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.setSize(800, 600);
        dialog.setVisible(true);
        System.exit(0);
    }
}
