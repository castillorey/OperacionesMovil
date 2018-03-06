package com.kevinmcr.operacionesmovil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }
    @Test // Siempre debe preceder al metodo tester
    public void sumar_dos_numeros_correctamente(){
        double a = 4, b = 5;
        double res = Methods.sumar(a,b);
        assertEquals(9,res,0);
    }

    @Test
    public void restar_dos_numeros_correctamente(){
        double a = 4, b = 5;
        double res = Methods.restar(a,b);
        assertEquals(-1,res,0);
    }

    @Test
    public void multiplicar_dos_numeros_correctamente(){
        double a = 4, b = 5;
        double res = Methods.multiplicar(a,b);
        assertEquals(20,res,0);
    }

    @Test
    public void dividir_dos_numeros_correctamente(){
        double a = 4, b = 2;
        double res = Methods.dividir(a,b);
        assertEquals(2,res,0);
    }
}