/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dataAccess.CopyFileDao;

/**
 *
 * @author THAO LINH
 */
public class CopyFileRepository {

    public void readFileConfig() {
        CopyFileDao.Instance().readFileConfig();
    }
}
