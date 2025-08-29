package service;

import entities.Catalog;

import javax.swing.*;

public class ListMedia {
    public static void listMedia(Catalog catalog) {
        JOptionPane.showMessageDialog(null, catalog.listingMedia());
    }

    public static void listMusic(Catalog catalog){
        JOptionPane.showMessageDialog(null, catalog.listMusic());
    }

    public static void listAudiobook(Catalog catalog){
        JOptionPane.showMessageDialog(null, catalog.listAudiobook());
    }

    public static void listPodcast(Catalog catalog){
        JOptionPane.showMessageDialog(null, catalog.listPodcast());
    }
}
