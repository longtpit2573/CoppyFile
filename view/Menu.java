/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import common.Validation;
import java.util.ArrayList;

/**
 *
 * @author THAO LINH
 */
public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> mList;
    Validation va  = new Validation();

    public Menu(String title, String[] ml) {
        this.title = title;
        mList = new ArrayList<>();
        for (String o : ml) {
            this.mList.add((T) o);
        }
    }

    public void display() {
        System.out.println("=========" + title + "=========");
        for (int i = 0; i < mList.size(); i++) {
            System.out.println(i + 1 + ". " + mList.get(i));
        }
    }

    public int getSelected() {
        display();
        return va.getIntLimit("Enter selection..", 1, mList.size() + 1);
    }

    public abstract void execute(int n);

    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > mList.size()) {
                break;
            }
        }
    }
}
