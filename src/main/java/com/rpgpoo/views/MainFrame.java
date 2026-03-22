package com.rpgpoo.views;

import com.rpgpoo.controllers.ExemploController;
import com.rpgpoo.models.ExemploModel;

import javax.swing.*;

public class MainFrame {
    private JPanel pnlMain;
    private JPanel pnlConteudo;
    private JTextField txtNome;
    private JButton btnCadastrar;
    private JLabel lblNome;
    private JLabel lblExibir;

    public void iniciar() {
        final ExemploController controller = new ExemploController();
        ExemploModel model = new ExemploModel();

        JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setResizable(false);
        frmMain.setContentPane(pnlMain);

        btnCadastrar.addActionListener(e -> {
            model.setNome(txtNome.getText());

            String retorno = controller.salvarExemplo(model);

            lblExibir.setText(
                    retorno.equals(model.getNome())
                            ? "Olá, " + retorno + "!"
                            : retorno
            );
            frmMain.pack();
            frmMain.setLocationRelativeTo(null);
        });

        frmMain.pack();
        frmMain.setLocationRelativeTo(null);
        frmMain.setVisible(true);
    }
}
