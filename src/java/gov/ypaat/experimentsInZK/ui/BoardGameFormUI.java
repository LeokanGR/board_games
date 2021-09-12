package gov.ypaat.experimentsInZK.ui;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Intbox;

public class BoardGameFormUI extends SelectorComposer<Component> {
    
    @Wire
    Textbox nameTxt;
    @Wire
    Textbox descriptionTxt;
    @Wire
    Intbox minPlayersIntTxt;
    @Wire
    Intbox maxPlayersIntTxt;
    @Wire
    Checkbox playingInRoundsChk;


 
}
