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
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
  
/**
 * @version 1.0 11/09/98
 */
public class ButtonEditor extends DefaultCellEditor {
  protected JButton button;
  private String    label;
  private boolean   isPushed;
  
  String Bid;
  public gVar g;
    private final String type;
    private final profile pro;
    private final home hom;
  
    public ButtonEditor(gVar g,JCheckBox checkBox,String type,home hom,profile pro) {
    super(checkBox);
    this.g = g;
    this.pro = pro;
    this.hom = hom;
    this.type = type;
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }
  
  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
                   boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else{
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    //System.out.println(table.getSelectedRow());)

    Bid = table.getModel().getValueAt(row, 0).toString();
    button.setText( label );
    isPushed = true;
    return button;
  }
  
  @Override
  public Object getCellEditorValue() {
    if (isPushed)  {
        if(g.user_id<0)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Login to Issue","Error",JOptionPane.ERROR_MESSAGE);
            label = "Login required";
        }
        else
        {
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);
            LocalDate DueDate = LocalDate.now().plusDays(15);
            if(type == "book")
            { 
                try { 
                dbConn db = new dbConn();
                Statement stmt = db.conn.createStatement();
                ResultSet rs = stmt.executeQuery("select COUNT(*) from issued_books where B_id = '"+Bid+"'and S_id='"+g.user_id+"'");
                rs.next();
                int count = rs.getInt(1);
                if(count != 0 )
                {
                    label = "REIssued";
                    String sql = "UPDATE issued_books SET issue_date = '"+ date +"',due_date = '"+DueDate+"' where B_id = '"+Bid+"' and S_id ='"+g.user_id+"'";
                    PreparedStatement pStmt = db.conn.prepareStatement(sql);
                    pStmt.execute();
                }
                else
                {
                    label = "Issued";
                    String sql = "INSERT INTO issued_books (B_id,S_id,issue_date,due_date) values ('"+Bid+"','"+g.user_id+"','"+ date +"','"+DueDate+"')";
                    PreparedStatement pStmt = db.conn.prepareStatement(sql);
                    pStmt.execute();
                    sql = "UPDATE books SET NoCopies = books.NoCopies-1 where id = '"+Bid+"'";
                    pStmt = db.conn.prepareStatement(sql);
                    pStmt.execute();
                    hom.updateTable();
                }

                } catch (SQLException ex) {
                Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                try {
                    dbConn db = new dbConn();
                    String sql = "DELETE from issued_books where B_id = '"+Bid+"' and S_id ='"+g.user_id+"'";
                    PreparedStatement pStmt = db.conn.prepareStatement(sql);
                    pStmt.execute();
                    label = "Issue";
                    sql = "UPDATE books SET NoCopies = books.NoCopies+1 where id = '"+Bid+"'";
                    pStmt = db.conn.prepareStatement(sql);
                    pStmt.execute();
                    //pro.updateTable();
                    } catch (SQLException ex) {
                    Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
        }
       
    }
    isPushed = false;
    return new String( label ) ;
  }
    
  @Override
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }
  
    /**
     *
     */
    @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}