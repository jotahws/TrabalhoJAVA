/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

import java.util.Calendar;

/**
 *
 * @author JotaWind
 */
public class Locacao {

    private String dias;
    private String valor;
    private Calendar data;
    private String cliente;

    public Locacao(String dias, String valor, Calendar calendar, String cliente) {
        this.dias = dias;
        this.valor = valor;
        this.data = calendar;
        this.cliente = cliente;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Calendar getCalendar() {
        return data;
    }

    public void setCalendar(Calendar calendar) {
        this.data = calendar;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
