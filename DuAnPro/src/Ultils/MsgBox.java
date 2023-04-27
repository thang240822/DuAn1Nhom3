/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MsgBox {

    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "HỆ THỐNG QUẢN LÝ SHOP", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component parent, String messeage) {
        int result = JOptionPane.showConfirmDialog(parent, messeage,
                "HỆ THÔNG QUẢN LÝ SHOP",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public static String promt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message,
                "HỆ THỐNG QUẢN LÝ SHOP", JOptionPane.INFORMATION_MESSAGE);

    }
}
