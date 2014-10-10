package com.hackaday;

import org.apache.poi.poifs.filesystem.*;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    if (args.length==0 || args.length>2) {
      System.out.println("Please specify valid file");
      return;
    }

    List<String> argsList = Arrays.asList(args);
    if (!argsList.contains("-c")) {
      unpackFile(new File(args[0]));
    } else {
      ParametricFile parametricFile = new ParametricFile();
      POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(new File(args[args.length - 1])));
      if (parametricFile.load(new DocumentInputStream((DocumentEntry) fs.getRoot().getEntry("FileHeader")))) {
        System.out.println("Successful!");
        System.out.println(parametricFile.getJSON().toString(2));
      }
    }
  }
  
  private static void unpackFile(File file) throws IOException {
    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
    exportDirEntry(fs.getRoot(), new File(file.getParentFile(), file.getName() + ".export"));
  }

  private static void exportDirEntry(DirectoryEntry dirEntry, File dir) throws IOException {
    if (!dir.mkdirs()) throw new IOException("Can't create dir");

    for (Entry entry : dirEntry) {
      if (entry.isDirectoryEntry()) {
        exportDirEntry((DirectoryEntry) entry, new File(dir, entry.getName()));
      } else if (entry.isDocumentEntry()) {
        exportFileEntry(entry, dir);
      }
    }
  }

  private static void exportFileEntry(Entry entry, File dir) throws IOException {
    OutputStream output = new FileOutputStream(new File(dir, entry.getName()));
    InputStream input = new DocumentInputStream((DocumentEntry) entry);

    byte[] buffer = new byte[4096]; // Adjust if you want
    int bytesRead;
    while ((bytesRead = input.read(buffer)) != -1)
      output.write(buffer, 0, bytesRead);
  }

}
