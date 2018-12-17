/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

/**
 *
 * @author Sairam
 */
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
  
/**
 * @version 1.0 11/09/98
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    private final String type;
    private final gVar g;
  
  public ButtonRenderer(String type,gVar g) {
      this.type = type;
      this.g = g;
    setOpaque(true);
  }
   
    /**
     *
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return
     */
    @Override
  public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else{
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    if(type == "book")
    {
        if(g.user_id<0)
        {
            setText( (value ==null) ? "Issue Book" : value.toString() );
        }
        else
        {
        try {
            String Bid = table.getModel().getValueAt(row, 0).toString();
            dbConn db = new dbConn();
            Statement stmt = db.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(*) from issued_books where B_id = '"+Bid+"'and S_id='"+g.user_id+"'");
            rs.next();
            int count;
            count = rs.getInt(1);
            if(count != 0 )
                setText( (value ==null) ? "Issued" : value.toString() );
            else
                setText( (value ==null) ? "Issue Book" : value.toString() );
        } catch (SQLException ex) {
            Logger.getLogger(ButtonRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }   
    else
        setText( (value ==null) ? "Return" : value.toString() );
    return this;
  }
}