package it.itispaleocapa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
class AppTest {
    @Test
    void testGetMatricola() {
        Alunno alunno = new Alunno("Nome");
        assertEquals("Nome", alunno.getMatricola());
    }

    @Test
    void testGetVoti() {
        ArrayList<Voto> voti = new ArrayList<>();
        voti.add(new Voto("Matematica", 7));
        voti.add(new Voto("Italiano", 6));
        Alunno alunno = new Alunno("Nome", voti);
        assertEquals(voti, alunno.getVoti());
    }

    @Test
    void testVerifyName() {
        Alunno alunno = new Alunno("Nome");
        assertTrue(alunno.verifyName("Nome"));
        assertFalse(alunno.verifyName("AltroNome"));
    }

    @Test
    void testMediaGenerale() {
        ArrayList<Voto> voti = new ArrayList<>();
        voti.add(new Voto("Matematica", 7));
        voti.add(new Voto("Italiano", 6));
        Alunno alunno = new Alunno("Nome", voti);
        assertEquals(6.5, alunno.mediaGenerale());
    }

    @Test
    void testMediaMateria() {
        ArrayList<Voto> voti = new ArrayList<>();
        voti.add(new Voto("Matematica", 7));
        voti.add(new Voto("Italiano", 6));
        Alunno alunno = new Alunno("Nome", voti);
        assertEquals(7.0, alunno.mediaMateria("Matematica"));
        assertEquals(6.0, alunno.mediaMateria("Italiano"));
    }

    @Test
    void testHaVotiInsufficienti() {
        ArrayList<Voto> voti = new ArrayList<>();
        voti.add(new Voto("Matematica", 7));
        voti.add(new Voto("Italiano", 5));
        Alunno alunno1 = new Alunno("Nome1", voti);
        assertTrue(alunno1.haVotiInsufficienti());

        ArrayList<Voto> voti2 = new ArrayList<>();
        voti2.add(new Voto("Matematica", 6));
        voti2.add(new Voto("Italiano", 5));
        Alunno alunno2 = new Alunno("Nome2", voti2);
        assertTrue(alunno2.haVotiInsufficienti());
    }

    @Test
    void testHaVotiInsufficientiInMateria() {
        ArrayList<Voto> voti = new ArrayList<>();
        voti.add(new Voto("Matematica", 7));
        voti.add(new Voto("Italiano", 5));
        Alunno alunno1 = new Alunno("Nome1", voti);
        assertTrue(alunno1.haVotiInsufficientiInMateria());

        ArrayList<Voto> voti2 = new ArrayList<>();
        voti2.add(new Voto("Matematica", 6));
        voti2.add(new Voto("Italiano", 6));
        Alunno alunno2 = new Alunno("Nome2", voti2);
        assertFalse(alunno2.haVotiInsufficientiInMateria());
    }
    
    @Test
    void testAggiungiAlunno() {
        Registro registro = new Registro();
        Alunno alunno = new Alunno("Nome");
        registro.aggiungiAlunno(alunno);
        assertEquals(1, registro.alunni.size());
        assertEquals(alunno, registro.alunni.get(0));
    }

    @Test
    void testAggiungiAlunnoWithMatricola() {
        Registro registro = new Registro();
        registro.aggiungiAlunno("Nome");
        assertEquals(1, registro.alunni.size());
        assertEquals("Nome", registro.alunni.get(0).getMatricola());
    }

}
