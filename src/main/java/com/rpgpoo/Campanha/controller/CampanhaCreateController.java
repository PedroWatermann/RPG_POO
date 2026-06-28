package com.rpgpoo.Campanha.controller;

import com.rpgpoo.Campanha.model.CampanhaModel;
import com.rpgpoo.Campanha.view.CampanhaCreateView;
import com.rpgpoo.Dado.model.DadoModel;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Jogador.model.JogadorModel;
import com.rpgpoo.Login.sessao.SessaoUsuario;
import com.rpgpoo.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.List;

public class CampanhaCreateController {
    private final CampanhaCreateView view;
    private final Gerenciador gerenciador;
    private final Runnable sucesso;

    private JogadorModel mestre;

    public CampanhaCreateController(CampanhaCreateView view, Gerenciador gerenciador, Runnable sucesso) {
        this.view = view;
        this.gerenciador = gerenciador;
        this.sucesso = sucesso;
    }

    public void btnCriarCampanhaClick() {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            CampanhaModel campanha = new CampanhaModel(
                    view.getTxtNome().getText(),
                    view.getTxtDescricao().getText(),
                    null,
                    null,
                    (DadoModel) view.getCbxDadoPadrao().getSelectedItem(),
                    this.mestre
            );

            em.getTransaction().begin();
            em.persist(campanha);
            em.getTransaction().commit();

            if (sucesso != null) {
                sucesso.run();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Ocorreu um erro ao salvar a campanha.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void preencherComponentes() {
        this.mestre = this.listarMestre();
        view.getTxtMestre().setText(this.mestre.toString());
        this.listarDados().forEach(view.getCbxDadoPadrao()::addItem);
    }

    public JogadorModel listarMestre() {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            JogadorModel jogador = SessaoUsuario.getInstancia().getJogadorLogado();
            return em.createQuery("FROM JogadorModel j WHERE j.nome = :nome", JogadorModel.class)
                     .setParameter("nome", jogador.getNome())
                     .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<DadoModel> listarDados() {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            return em.createQuery("FROM DadoModel d ORDER BY d.lados", DadoModel.class).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of();
        }
    }
}
