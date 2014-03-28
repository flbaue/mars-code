/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import entity.Message;
import facade.MessageFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author florian
 */
@ManagedBean
@RequestScoped
public class MessageView {
    
    @EJB
    MessageFacade messageFacade;
    
    private Message message;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new Message();
    }
    
    public Message getMessage(){
        return message;
    }
         
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }
    
    public String save() {
        messageFacade.create(message);
        return "theend";
    }
    
}
