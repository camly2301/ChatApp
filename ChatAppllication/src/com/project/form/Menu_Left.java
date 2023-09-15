package com.project.form;

import com.project.component.Item_People;
import com.project.event.EventMenuLeft;
import com.project.event.PublicEvent;
import com.project.model.Model_User_Account;
import com.project.swing.ScrollBar;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;

public class Menu_Left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;

    public Menu_Left() {
        initComponents();
        init();
    }

    private void init() {
        sp.setVerticalScrollBar(new ScrollBar());
        menuListUser.setLayout(new MigLayout("fillx", "0[]0", "1[]1"));
        userAccount = new ArrayList<>(); // mang luu list user
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                //    System.out.println(users);
                for (Model_User_Account d : users) {
                    userAccount.add(d);
                    menuListUser.add(new Item_People(d), "wrap");
                }
            }

            @Override
            public void userConnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuListUser.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void userDisconnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuListUser.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

        });
        showMessage();
    }

    private void showMessage() {
        menuListUser.removeAll();
        for (Model_User_Account d : userAccount) {
            menuListUser.add(new Item_People(d), "wrap");
        }
        refreshMenuList();
    }

    private void showGroup() {
        menuListUser.removeAll();
        for (int i = 0; i < 5; i++) {
            menuListUser.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showBox() {
        menuListUser.removeAll();
        for (int i = 0; i < 15; i++) {
            menuListUser.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void refreshMenuList() {
        menuListUser.repaint();
        menuListUser.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new com.project.component.MenuButton();
        menuGroup = new com.project.component.MenuButton();
        menuBox = new com.project.component.MenuButton();
        sp = new javax.swing.JScrollPane();
        menuListUser = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(245, 238, 238));

        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMessage.setIconSelected(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-messages-64 (1).png")); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-messages-30.png")); // NOI18N
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        menuGroup.setIcon(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-group-task-30.png")); // NOI18N
        menuGroup.setIconSelected(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-group-task-64.png")); // NOI18N
        menuGroup.setIconSimple(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-group-task-30.png")); // NOI18N
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        menuBox.setIcon(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-open-envelope-30.png")); // NOI18N
        menuBox.setIconSelected(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-open-envelope-64.png")); // NOI18N
        menuBox.setIconSimple(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-open-envelope-30.png")); // NOI18N
        menuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBoxActionPerformed(evt);
            }
        });
        menu.add(menuBox);

        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuListUser.setBackground(new java.awt.Color(249, 246, 246));
        menuListUser.setOpaque(true);

        javax.swing.GroupLayout menuListUserLayout = new javax.swing.GroupLayout(menuListUser);
        menuListUser.setLayout(menuListUserLayout);
        menuListUserLayout.setHorizontalGroup(
            menuListUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListUserLayout.setVerticalGroup(
            menuListUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );

        sp.setViewportView(menuListUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        if (!menuMessage.isSelected()) {
            menuMessage.setSelected(true);
            menuGroup.setSelected(false);
            menuBox.setSelected(false);
            showMessage();
        }
    }//GEN-LAST:event_menuMessageActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        if (!menuGroup.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(true);
            menuBox.setSelected(false);
            showGroup();
        }

    }//GEN-LAST:event_menuGroupActionPerformed

    private void menuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBoxActionPerformed
        if (!menuBox.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(false);
            menuBox.setSelected(true);
            showBox();
        }

    }//GEN-LAST:event_menuBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private com.project.component.MenuButton menuBox;
    private com.project.component.MenuButton menuGroup;
    private javax.swing.JLayeredPane menuListUser;
    private com.project.component.MenuButton menuMessage;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables

}
