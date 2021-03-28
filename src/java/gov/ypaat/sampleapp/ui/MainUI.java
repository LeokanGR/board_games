/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ypaat.sampleapp.ui;

import gov.ypaat.sampleapp.other.Dao;
import gov.ypaat.neklib.other.AbstractDao;
import gov.ypaat.neklib.ui.AbstractMainUI;
import static gov.ypaat.neklib.utils.GeneralUtils.lookupDaoBean;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;

/**
 *
 * @author nekta
 */
//extends AbstractMainUI
public class MainUI extends AbstractMainUI {

    private final Dao dao = (Dao) lookupDaoBean();

    @Wire
    Include mainContent;

    @Override
    public AbstractDao getDao() {
        return dao;
    }

    @Override
    public Component getMainContent() {
        return mainContent;
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp); //To change body of generated methods, choose Tools | Templates.
    }




}
