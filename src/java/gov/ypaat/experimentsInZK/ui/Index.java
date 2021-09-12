package gov.ypaat.experimentsInZK.ui;

import gov.ypaat.experimentsInZK.other.Dao;
import javax.persistence.EntityManager;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;
import org.zkoss.zul.Menuitem;

public class Index extends SelectorComposer<Component> {

    @Wire
    private Include inserted2center;

    @Wire
    private Menuitem insertNewPlayer;

    public Include getInserted2center() {
        return inserted2center;
    }

    public void setInserted2center(Include inserted2center) {
        this.inserted2center = inserted2center;
    }

    @Listen("onClick=#insertNewPlayer")
    public void insertNewPlayer() {
        inserted2center.setSrc("PlayerForm.zul");
    }

    @Listen("onClick=#insertNewBoardGame")
    public void insertNewBoardGame() {
        inserted2center.setSrc("BoardGameForm.zul");
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        EntityManager em = Dao.getEm();
        
    }

}
