package gov.ypaat.experimentsInZK.ui;

import gov.ypaat.experimentsInZK.entities.Player;
import gov.ypaat.experimentsInZK.other.Dao;
import java.util.Date;
import javax.persistence.EntityManager;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

public class PlayerFormUI extends SelectorComposer<Component> {

    @Wire
    Textbox firstNameTxt;
    @Wire
    Textbox lastNameTxt;
    @Wire
    Textbox emailTxt;
    @Wire
    Textbox nickNameTxt;
    @Wire
    Textbox updTimestampTxt;
    @Wire
    Button saveBtn;

    @Listen("onClick=#saveBtn")
    public void savePlayer() {
        EntityManager em = Dao.getEm();
        Player p = new Player();
        p.setFirstName(firstNameTxt.getValue());
        p.setLastName(lastNameTxt.getValue());
        p.setEmail(emailTxt.getValue());
        p.setNickName(nickNameTxt.getValue());
        em.persist(p);
    }

}
