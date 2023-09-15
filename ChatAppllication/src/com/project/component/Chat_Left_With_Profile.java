package com.project.component;

import java.awt.Color;
import javax.swing.Icon;

public class Chat_Left_With_Profile extends javax.swing.JLayeredPane {
    
    public Chat_Left_With_Profile() {
        initComponents();
        txt.setBackground(new Color(245, 245, 240));
    }
    
    public void setUserProfile(String user) {
        txt.setUserProfile(user);
    }
    
    public void setImageProfile(Icon image) {
        imageAvatar.setImage(image);
    }
    
    public void setText(String text) {
        if (text.equals("")) {
            txt.hideText();
        } else {
            txt.setText(text);
        }
    }
    
    public void setImage(Icon... image) {
      //  txt.setImage(false, image);
    }
    
    public void setImage(String... image) {
      //  txt.setImage(false, image);
    }
    
    public void setTime() {
        txt.setTime("10:30 PM");
    }
    
    public void setFile(String fileName, String fileSize) {
        txt.setFile(fileName, fileSize);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        imageAvatar = new com.project.swing.ImageAvatar();
        txt = new com.project.component.Chat_Item();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        imageAvatar.setBorderSize(0);
        imageAvatar.setImage(new javax.swing.ImageIcon("F:\\hinh anh\\camly\\blazer\\N có chân mày-cắt.jpg")); // NOI18N
        imageAvatar.setMaximumSize(new java.awt.Dimension(31, 31));
        imageAvatar.setMinimumSize(new java.awt.Dimension(31, 31));
        imageAvatar.setPreferredSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(imageAvatar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jLayeredPane1);

        txt.setBackground(new java.awt.Color(255, 255, 255));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.project.swing.ImageAvatar imageAvatar;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.project.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
