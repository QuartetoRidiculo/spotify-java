package service;

import entities.Catalog;

import javax.swing.*;

public class ListMedia {
    public static void listMedia(Catalog catalog) {
        JOptionPane.showMessageDialog(null, catalog.listingMedia());
    }
}
