/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author THAO LINH
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public int getIntLimit(String mess, int n, int m) {
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        int result;
        while (true) {
            System.out.println(mess + ": ");
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result < n || result > m) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please, enter a number between " + n + " and " + m);
            }
        }
    }

    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }

    public int getInt(String mes) {
        return Integer.parseInt(getString(mes));
    }

    public boolean checkInformationConfig(File f1, File f2) {
        boolean checkInformationConfig = f1.exists() && f1.isDirectory()
                && f2.exists() && f2.isDirectory();
        if (f1.exists() == false || f1.isDirectory() == false) {
            System.err.println("Can't find folder Sourse");
        }
        if (f2.exists() == false || f2.isDirectory() == false) {
            System.err.println("Can't make folder Destination");
        }
        return checkInformationConfig;
    }

    public boolean checkFileConfig(File pFile) {
        Properties p = new Properties();
        InputStream fInput = null;
        boolean isExisted = false;
        try {
            fInput = new FileInputStream(pFile);
            p.load(fInput);
            if (p.getProperty("COPY_FOLDER").length() == 0) {
                System.err.println("Folder Sourse is not input");
            }
            if (p.getProperty("DATA_TYPE").length() == 0) {
                System.err.println("Data type is not input");
            }
            if (p.getProperty("PATH").length() == 0) {
                System.err.println("Folder Destination is not input");
            }
            isExisted = p.getProperty("COPY_FOLDER") != null
                    && p.getProperty("DATA_TYPE") != null
                    && p.getProperty("PATH") != null;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Can't read file configure!");
        }

        if (fInput != null)
            try {
            fInput.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("File configure is not found!");
        }
        return isExisted;
    }
}
