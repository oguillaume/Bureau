/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author adm
 */

public class AProposAction extends AbstractAction {
	private final VueAdministration fenetre;
 
	public AProposAction(VueAdministration fenetre, String texte){
		super(texte);
 
		this.fenetre = fenetre;
	}
 
        @Override
	public void actionPerformed(ActionEvent e) { 
		JOptionPane.showMessageDialog(fenetre, "Ce programme a été développé par Olivier Guillaume","A propos",JOptionPane.PLAIN_MESSAGE);
	} 
}
