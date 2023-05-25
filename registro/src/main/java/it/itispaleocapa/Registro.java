package it.itispaleocapa;

import java.util.ArrayList;

public class Registro {
    public ArrayList<Alunno> alunni;

    public Registro() {
        this.alunni = new ArrayList<Alunno>();
    }

    public void aggiungiAlunno(Alunno a) {
        alunni.add(a);
    }
    public void aggiungiAlunno(String matricola) {
        alunni.add(new Alunno(matricola));
    }

    public void aggiungiVoto(String matricola, String materia, int voto) {
        alunni.stream().forEach(
                alunno -> {
                    if (alunno.verifyName(matricola)) alunno.aggiungiVoto(new Voto(materia, voto));
                }
        );
    }

    public void visualizzaVoti(String matricola) {
        alunni.stream().filter(alunno -> alunno.verifyName(matricola)).forEach(e -> e.getVoti().stream().forEach(voto -> System.out.println(voto.getVoto())));
    }

    public double mediaAlunno(String matricola) {
        return alunni.stream()
                .filter(alunno -> alunno.verifyName(matricola))
                .mapToDouble(Alunno::mediaGenerale)
                .average()
                .orElse(Double.NaN);
    }
    public double mediaMateriaAlunno(String matricola, String materia) {
        return alunni.stream()
                .filter(alunno -> alunno.verifyName(matricola))
                .mapToDouble(alunno -> alunno.mediaMateria(materia))
                .average()
                .orElse(Double.NaN);
    }

    public void alunniInsufficienti() {
        alunni.stream().filter(e -> e.mediaGenerale() < 6).forEach(alunno -> System.out.println(alunno.getMatricola()));
    }

    public void alunniInsufficientiInMateria() {
        alunni.stream().filter(e -> e.haVotiInsufficientiInMateria()).forEach(alunno -> System.out.println(alunno.getMatricola()));
    }

    public void alunniSoloSufficienti() {
        alunni.stream().filter(e -> !e.haVotiInsufficienti()).forEach(alunno -> System.out.println(alunno.getMatricola()));
    }

    public ArrayList<String> getAlunniInsufficienti() {
        ArrayList<String> alunniInsuff = new ArrayList<String>();
        alunni.stream().filter(e -> e.mediaGenerale() < 6).forEach(alunno -> alunniInsuff.add(alunno.getMatricola()));
        return alunniInsuff;
    }

    public static void main(String[] args) {
        Registro r = new Registro();
        r.aggiungiAlunno("Nome");
        r.aggiungiAlunno("Nome1");
        r.aggiungiAlunno("Nome2");

        r.aggiungiVoto("Nome", "Ita", 5);
        r.aggiungiVoto("Nome", "Ita", 6);
        r.aggiungiVoto("Nome2", "Storia", 7);

        //System.out.println(r.alunni.get(0).getVoti().get(0).getVoto());
        //r.visualizzaVoti("Nome");
        //System.out.println(r.mediaAlunno("Nome"));
        //System.out.println(r.mediaMateriaAlunno("Nome", "Ita"));
        //r.alunniInsufficienti();
        //r.alunniInsufficientiInMateria();
        //r.alunniSoloSufficienti();
    }
}
