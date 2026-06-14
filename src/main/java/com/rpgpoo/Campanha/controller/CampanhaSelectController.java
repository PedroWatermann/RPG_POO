package com.rpgpoo.Campanha.controller;

import com.rpgpoo.Campanha.view.CampanhaListView;
import com.rpgpoo.Campanha.view.CampanhaSelectView;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Gerenciador.TabbedView;
import com.rpgpoo.Item.view.ItemView;
import com.rpgpoo.Login.view.LoginView;
import com.rpgpoo.RpgLog.view.RpgLogView;
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
        tabbed.addAba("Campanha", FontIcon.of(FontAwesomeSolid.MAP, AppColors.ICON_SM, AppColors.GOLD), new CampanhaListView(gerenciador));
        tabbed.addAba("Itens", FontIcon.of(FontAwesomeSolid.SHOPPING_BAG, AppColors.ICON_SM, AppColors.GOLD), new ItemView(gerenciador));
        tabbed.addAba("Log", FontIcon.of(FontAwesomeSolid.TERMINAL, AppColors.ICON_SM, AppColors.GOLD), new RpgLogView(gerenciador));

        gerenciador.addPainel(tabbed, "tabbed");
        gerenciador.navegarPara("tabbed", false, "", true);
    }
}
