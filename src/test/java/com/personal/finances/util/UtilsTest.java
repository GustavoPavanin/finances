package com.personal.finances.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @Test
    public void deve_retornar_true_quando_objeto_nulo() {
        assertTrue(Utils.isNull(null));
    }

    @Test
    public void deve_retornar_false_quando_objeto_nao_nulo() {
        assertFalse(Utils.isNull(new Object()));
    }

    @Test
    public void deve_retornar_true_quando_objeto_nao_nulo() {
        assertTrue(Utils.isNotNull(new Object()));
    }

    @Test
    public void deve_retornar_false_quando_objeto_nulo() {
        assertFalse(Utils.isNotNull(null));
    }

    @Test
    public void deve_retornar_true_quando_objeto_vazio() {
        assertTrue(Utils.isEmpty(""));
    }

    @Test
    public void deve_retornar_false_quando_objeto_nao_vazio() {
        assertFalse(Utils.isEmpty("teste"));
    }

    @Test
    public void deve_retornar_true_quando_lista_vazia() {
        assertTrue(Utils.isNullOrEmpty(new ArrayList<>()));
    }

    @Test
    public void deve_retornar_false_quando_lista_nao_vazia() {
        assertFalse(Utils.isNullOrEmpty(List.of("teste")));
    }
}
