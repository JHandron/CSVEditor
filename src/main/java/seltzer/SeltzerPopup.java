/*
 * Created by JFormDesigner on Fri Apr 11 19:26:30 EDT 2025
 */

package seltzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * @author Jason
 */
public class SeltzerPopup extends JDialog {
    public SeltzerPopup(Window owner) {
        super(owner);
        initComponents();
        init();
    }


    List<Seltzer> screenModel = new ArrayList<>();

    void init(){
        DefaultComboBoxModel<Seltzer.Series> cb = new DefaultComboBoxModel<>();

        for (Seltzer.Series s : Seltzer.Series.values()){
            cb.addElement(s);
        }
        SeriesInputComboBox.setModel(cb);

        for (Seltzer s : CSVDelegate.getFileContents()){
            screenModel.add(s);

        }
        list1.addListSelectionListener(o-> {
            if(list1.getSelectedValue() == null){
                return;
            }
            Seltzer sz = ((Seltzer)list1.getSelectedValue());
            NameInput.setText(sz.getName());
            RatingInput.setText(sz.getScore().toString());
            CommentInput.setText(sz.getComment());
            SeriesInputComboBox.setSelectedItem(sz.getSeries());
        });
        syncJList();
    }

    void syncJList(){
        DefaultListModel<Seltzer> sm = new DefaultListModel<>();
        for (Seltzer s : screenModel){
            sm.addElement(s);
        }
        list1.setModel(sm);
    }
    private void Apply(ActionEvent e) {
        Seltzer s = ((Seltzer) list1.getSelectedValue());
        s.setComment(CommentInput.getText());
        s.setName(NameInput.getText());
        s.setScore(new BigDecimal(RatingInput.getText()));
        s.setSeries((Seltzer.Series) SeriesInputComboBox.getSelectedItem());
        syncJList();

        File f = new File(CSVDelegate.TEST_FILE);
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.println(TestData.HEADER_ROW);
            for(Seltzer o : screenModel){
                pw.println(o.toCSVFormattedString());
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("U SUCK, PAL");
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        panel1 = new JPanel();
        NameInput = new JTextField();
        RatingInput = new JTextField();
        CommentInput = new JTextField();
        SeriesInputComboBox = new JComboBox();
        CancelButton = new JButton();
        ApplyButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 1));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(4, 1));
            panel1.add(NameInput);
            panel1.add(RatingInput);
            panel1.add(CommentInput);
            panel1.add(SeriesInputComboBox);
        }
        contentPane.add(panel1);

        //---- CancelButton ----
        CancelButton.setText("Cancel");
        contentPane.add(CancelButton);

        //---- ApplyButton ----
        ApplyButton.setText("Apply");
        ApplyButton.addActionListener(e -> Apply(e));
        contentPane.add(ApplyButton);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JScrollPane scrollPane1;
    private JList list1;
    private JPanel panel1;
    private JTextField NameInput;
    private JTextField RatingInput;
    private JTextField CommentInput;
    private JComboBox SeriesInputComboBox;
    private JButton CancelButton;
    private JButton ApplyButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
