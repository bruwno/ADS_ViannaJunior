/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.edu.vianna.sistemaclube.model.associados;

/**
 *
 * @author William
 */
public enum ETipoAssociado {
    ANUAL("Anual"),
    SEMESTRAL("Semestral");

    private String tipoAssociado;

    ETipoAssociado(String tipoAssociado) {
        this.tipoAssociado = tipoAssociado;
    }

    @Override
    public String toString() {
        return tipoAssociado;
    }
}
