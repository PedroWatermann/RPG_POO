package com.rpgpoo.Campanha.controller;

import com.rpgpoo.Campanha.view.CampanhaListView;
import com.rpgpoo.Campanha.view.CampanhaSelectView;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Gerenciador.TabbedView;
import com.rpgpoo.utils.AppColors;
import org.kordamp.ikonli.fontawesome6.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;

public class CampanhaSelectController {
    private final CampanhaSelectView view;
    private final Gerenciador gerenciador;

    public CampanhaSelectController(CampanhaSelectView view, Gerenciador gerenciador) {
        this.view = view;
        this.gerenciador = gerenciador;
    }

    public void btnNovoClick() {
        JOptionPane.showMessageDialog(view, "Já já abre um modal aí.", "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public void btnEditarClick() {
        JOptionPane.showMessageDialog(view, "Já já abre um outro modal aí.", "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public void btnExcluirClick() {
        JOptionPane.showMessageDialog(view, "Ainda não pode...", "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public void btnSelecionarClick() {
//        gerenciador.addPainel(new CampanhaListView(gerenciador), "campanhaList");
        TabbedView tabbed = new TabbedView();
        tabbed.addAba("Campanha", FontIcon.of(FontAwesomeSolid.MAP, 12, AppColors.GOLD), new CampanhaListView(gerenciador));

        gerenciador.addPainel(tabbed, "tabbed");
        gerenciador.navegarPara("tabbed", false, "", true);
    }
}
