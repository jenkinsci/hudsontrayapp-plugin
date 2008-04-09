package org.hudson.trayapp.gui;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.JTable;

public  class CellImageObserver implements ImageObserver {
    JTable table;

    int row;

    int col;

    CellImageObserver(JTable table, int row, int col) {
      this.table = table;
      this.row = row;
      this.col = col;
    }

    public boolean imageUpdate(Image img, int flags, int x, int y, int w, int h) {
      if ((flags & (FRAMEBITS | ALLBITS)) != 0) {
        Rectangle rect = table.getCellRect(row, col, false);
        table.repaint(rect);
      }
      return (flags & (ALLBITS | ABORT)) == 0;
    }
  }
