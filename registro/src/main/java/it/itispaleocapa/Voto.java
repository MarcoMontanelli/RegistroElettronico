package it.itispaleocapa;

public class Voto {
    private String materia;
    private int voto;

    Voto(String materia, int voto) {
        this.materia = materia;
        this.voto = voto;
    }

    public int getVoto() {
        return this.voto;
    }

    public String getMateria() {
        return this.materia;
    }
}
