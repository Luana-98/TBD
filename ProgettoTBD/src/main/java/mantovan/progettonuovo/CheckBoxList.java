/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantovan.progettonuovo;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Simple checkbox list implementation.
 *
 * @from
 * http://stackoverflow.com/questions/19766/how-do-i-make-a-list-with-checkboxes-in-java-swing
 */
public class CheckBoxList extends JList {

    protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

    public CheckBoxList() {
        setCellRenderer(new CellRenderer());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if (index != -1) {
                    JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
                    checkbox.setSelected(!checkbox.isSelected());
                    repaint();
                }
            }
        });

        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addCheckbox(JCheckBox checkBox) {
        ListModel currentList = this.getModel();
        JCheckBox[] newList = new JCheckBox[currentList.getSize() + 1];
        for (int i = 0; i < currentList.getSize(); i++) {
            newList[i] = (JCheckBox) currentList.getElementAt(i);
        }
        newList[newList.length - 1] = checkBox;
        setListData(newList);
    }
    

    @SuppressWarnings("unchecked")
    public int[] getCheckedIdexes() {
      java.util.List list = new java.util.ArrayList();
      ListModel dlm = this.getModel();
      for (int i = 0; i < dlm.getSize(); ++i) {
        Object obj = getModel().getElementAt(i);
        if (obj instanceof JCheckBox) {
          JCheckBox checkbox = (JCheckBox) obj;
          if (checkbox.isSelected()) {
            list.add(new Integer(i));
          }
        }
      }

      int[] indexes = new int[list.size()];

      for (int i = 0; i < list.size(); ++i) {
        indexes[i] = ((Integer) list.get(i)).intValue();
      }

      return indexes;
    }

    @SuppressWarnings("unchecked")
    public java.util.List getCheckedItems() {
      java.util.List list = new java.util.ArrayList();
      ListModel dlm = this.getModel();
      for (int i = 0; i < dlm.getSize(); ++i) {
        Object obj = getModel().getElementAt(i);
        if (obj instanceof JCheckBox) {
          JCheckBox checkbox = (JCheckBox) obj;
          if (checkbox.isSelected()) {
            list.add(checkbox.getText());
          }
        }
      }
      return list;
    }


    protected class CellRenderer implements ListCellRenderer {

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JCheckBox checkbox = (JCheckBox) value;
            checkbox.setBackground(isSelected ? getSelectionBackground() : getBackground());
            checkbox.setForeground(isSelected ? getSelectionForeground() : getForeground());
            checkbox.setEnabled(isEnabled());
            checkbox.setFont(getFont());
            checkbox.setFocusPainted(false);
            checkbox.setBorderPainted(true);
            checkbox.setOpaque(false);
            checkbox.setBorder(isSelected ? UIManager.getBorder("List.focusCellHighlightBorder") : noFocusBorder);
            return checkbox;
        }
    }
}


 


 

