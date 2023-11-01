/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Repository.CopyFileRepository;
import dataAccess.CopyFileDao;
import view.Menu;

/**
 *
 * @author THAO LINH
 */
public class CopyFileController extends Menu<String>{
    
    static String[] mc = {"Copy File", "Exit"};
    public CopyFileController(){
        super("Copy Program", mc);
    }
    CopyFileRepository c = new CopyFileRepository();
    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                c.readFileConfig();
                break;
            case 2:
                System.exit(0);
            default:
        }
    }
    
}
