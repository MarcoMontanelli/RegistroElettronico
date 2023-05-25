package it.itispaleocapa;

import java.util.ArrayList;

public class Alunno {
    private String matricola;
    private ArrayList<Voto> voti;

    public Alunno(String nome) {
        this.matricola = nome;
        voti = new ArrayList<Voto>();
    }

    Alunno(String nome, ArrayList<Voto> voti) {
        this.matricola = nome;
        this.voti = voti;
    }

    public String getMatricola() {
        return this.matricola;
    }

    public ArrayList<Voto> getVoti() {
        return this.voti;
    }

    public void aggiungiVoto(Voto voto) {
        this.voti.add(voto);
    }

    public boolean verifyName(String nome) {
        if (nome.equals(this.matricola)) return true;
        else return false;
    }

    public double mediaGenerale() {
        double somma;
        somma = voti.stream().mapToDouble(Voto::getVoto).sum();
        return somma / voti.size();
    }

    public double mediaMateria(String materia) {
        double somma;
        somma = voti.stream().filter(e -> e.getMateria().equals(materia)).mapToDouble(Voto::getVoto).sum();
        return somma / voti.stream().filter(e -> e.getMateria().equals(materia)).count();
    }

    public boolean haVotiInsufficienti() {
        return voti.stream().anyMatch(e -> e.getVoto() < 6);
    }

    public boolean haVotiInsufficientiInMateria() {
        return voti.stream().anyMatch(e -> mediaMateria(e.getMateria()) < 6);
    }

}
