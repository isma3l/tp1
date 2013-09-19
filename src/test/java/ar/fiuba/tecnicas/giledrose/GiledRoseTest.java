package ar.fiuba.tecnicas.giledrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GiledRoseTest {
    private int limiteCalidad;
    private Inventory inventario;
    private Item dexterity;
    private Item elixir;
    private Item ageBrie;
    private Item sulfura;
    private Item backStage;
    private Item conjured;

    @Before
    public void setUp() {
        limiteCalidad = 50;
        dexterity = new Item("+5 Dexterity Vest", 10, 20);
        elixir = new Item("Elixir of the Mongoose", 5, 7);
        ageBrie = new Item("Aged Brie", 2, 0);
        sulfura = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        backStage = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        conjured = new Item("Conjured Mana Cake", 3, 6);

        inventario = new Inventory(new Item[]{dexterity,elixir,ageBrie,sulfura,backStage, conjured});
    }


    /*
    Se prueba que un producto "Dexterity" con un sellIn mayor que cero disminuye su calidad
    en una unidad despues de actualizar el inventario.
    Se utiliza un sellIn con valor 10 para garantizar que es mayor que cero.
    */
    @Test
    public void calidadDexterityDisminuyeTest() {
        int calidad = dexterity.getQuality();
        dexterity.setSellIn(10);

        inventario.updateQuality();
        assertEquals("La calidad del producto Dextirity no disminuyo una unidad", dexterity.getQuality(), calidad - 1);
    }

    /*
    Se prueba que un producto "Dexterity" con un sellIn menor o igual a cero disminuye su calidad
    en dos unidades despues de actualizar el inventario.
    Se utiliza  un sellIn con valor 0.
    */
    @Test
    public void calidadDexterityDisminuyeAlDobleTest() {
        int calidad = dexterity.getQuality();
        dexterity.setSellIn(0);

        inventario.updateQuality();
        assertEquals("La calidad del producto Dextirity no disminuyo dos unidades", dexterity.getQuality(), calidad - 2);
    }


    /*
    Se prueba que la calidad del producto "Dexterity" no puede ser menor que 0.
    S  e utiliza un sellIn de -4 y una calidad de 1, cuando su sellIn  es negativo la calidad
    disminuye el doble, de modo que luego de actualizar el inventario su calidad deberia valer -1,
    pero como la calidad no puede ser negativa, valdra cero.
    */
    @Test
    public void calidadDexterityNoEsNegativaTest() {
        dexterity.setSellIn(-4);
        dexterity.setQuality(1);

        inventario.updateQuality();
        assertEquals("La calidad del producto Dexterity no puede ser negativa", dexterity.getQuality(), 0);
    }

    /*
    Se prueba que un producto  "Dexterity" decrementa su sellIn en 1 unidad
    despues de actualizar el inventario.
    */
    @Test
    public void sellInDexterityDisminuyeTest() {
        int sellIn = dexterity.getSellIn();

        inventario.updateQuality();
        assertEquals("El SellIn del producto Dextirity no disminuyo una unidad", dexterity.getSellIn(), sellIn - 1);
    }

    /*
    Se prueba que un producto "Elixir" con un sellIn mayor que cero disminuye su calidad
    en una unidad despues de actualizar el inventario.
    Se utiliza  un sellIn con valor 5 para garantizar que es mayor que cero.
    */
    @Test
    public void calidadDeElixirDisminuyeTest() {
        int calidad = elixir.getQuality();
        elixir.setSellIn(5);

        inventario.updateQuality();
        assertEquals("La calidad del producto Elixir no disminuyo en una unidad", elixir.getQuality(), calidad - 1);
    }


    /*
    Se prueba que un producto "Elixir" con un sellIn menor o igual a cero disminuye su calidad
    en dos unidades despues de actualizar el inventario.
    Se utiliza un sellIn con valor 0.
    */
    @Test
    public void calidadDeElixirDisminuyeAlDobleTest() {
        int calidad = elixir.getQuality();
        elixir.setSellIn(0);

        inventario.updateQuality();
        assertEquals("La calidad del producto Elixir no disminuyo dos unidades", elixir.getQuality(), calidad - 2);
    }

    /*
    Se prueba que la calidad del producto "Elixir" nunca puede tener una calidad negativa.
    Se utiliza un sellIN de -6 y una calidad de 1, cuando su sellIn  es negativo la calidad
    disminuye al doble, de modo que luego de actualizar el inventario su calidad deberia valer -1,
    pero como la calidad no puede ser negativa, valdra cero.
    */
    @Test
    public void calidadDeElixirNoEsNegativaTest() {
        elixir.setSellIn(-6);
        elixir.setQuality(1);

        inventario.updateQuality();
        assertEquals("La calidad del producto Elixir no puede ser negativa", elixir.getQuality(), 0);
    }

    /*
    Se prueba que un producto "Elixir" decrementa su sellIn en 1 unidad despues de actualizar el inventario.
    */
    @Test
    public void sellInDeElixirDisminuyeTest() {
        int sellIn = elixir.getSellIn();

        inventario.updateQuality();
        assertEquals("El sellIn del producto Elixir no disminuyo una unidad", elixir.getSellIn(), sellIn - 1);
    }



    /*
    Se prueba que un producto "AgeBrie" disminuye su sellIn en una unidad despues
    que se actualiza el inventario
    */
    @Test
    public void sellInDeAgeBriedDisminuyeTest() {
        int sellIn = ageBrie.getSellIn();

        inventario.updateQuality();
        assertEquals("El sellIn del producto AgeBried no disminuyo en una unidad", ageBrie.getSellIn(), sellIn - 1);
    }

    /*
    Se prueba que un producto "AgeBrie" con un sellIn mayor que cero aumenta su calidad
    en una unidad despues de actualizar el inventario.
    Se utiliza  un sellIn con valor 2 para garantizar que es mayor que cero.
    */
    @Test
    public void calidadDeAgeBriedAumentaTest() {
        int calidad = ageBrie.getQuality();
        ageBrie.setSellIn(2);

        inventario.updateQuality();
        assertEquals("la calidad del producto AgeBried no aumento en una unidad", ageBrie.getQuality(), calidad + 1);
    }

    /*
    Se prueba que un producto "AgeBrie" con un sellIn menor o igual a cero aumenta su calidad
    en dos unidades despues que se actualiza el inventario.
    Se utiliza como referencia una calidad con valor 5 y un sellIn con valor 0.
    */
    @Test
    public void calidadDeAgeBriedAumentaAlDobleTest() {
        int calidad = 5;
        ageBrie.setQuality(calidad);
        ageBrie.setSellIn(0);

        inventario.updateQuality();
        assertEquals("La calidad del producto AgeBried no aumenta en 2 unidades", ageBrie.getQuality(), calidad + 2);
    }


    /*
   Se prueba que la calidad del producto "AgeBried" jamas supera el limite de 50.
   Se utiliza una calidad con valor 50, de modo que no se podra superar en el valor maximo permitido.
   */
    @Test
    public void calidadDeAgeBrieNoSuperaElLimiteTest() {
        ageBrie.setQuality(limiteCalidad);

        inventario.updateQuality();
        assertEquals("La calidad del producto AgeBrie supero el limite de 50", ageBrie.getQuality(), limiteCalidad);
    }

    /*
    Se prueba que un producto "Sulfura" siempre mantiene su sellIn constante con valor 0.
    */
    @Test
    public void sellInDeSulfuraEsConstanteTest() {
        int sellIn = sulfura.getSellIn();

        inventario.updateQuality();
        assertEquals("El SellIn del producto Sulfura debe ser constante", sulfura.getSellIn(), sellIn);
        assertEquals("El SellIn del producto Sulfura debe valer siempre cero", sulfura.getSellIn(), 0);
    }

    /*
    Se prueba que un producto "Sulfura" siempre mantiene su calidad constante con valor 80.
   */
    @Test
    public void calidadDeSulfuraEsConstanteTest() {
        int calidad = sulfura.getQuality();

        inventario.updateQuality();
        assertEquals("La calidad del producto Sulfura debe ser constante", sulfura.getQuality(), calidad);
        assertEquals("La calidad del producto Sulfura siempre debe valer 80", sulfura.getQuality(), 80);
    }

    /*
     Se prueba que un producto "Backstage" con un sellIn mayor que 10 aumenta su calidad
     en 1 unidad despues que se actualiza el inventario.
     Se utiliza como referencia un sellIn de 15.
     */
    @Test
    public void calidadDeBackStageAumentaTest() {
        backStage.setSellIn(15);
        int calidad = backStage.getQuality();

        inventario.updateQuality();
        assertEquals("La calidad del producto BackStage no aumenta en 1 unidad", backStage.getQuality(), calidad + 1);
    }

    /*
    Se prueba que un producto "Backstage" con un sellIn cuyo valor se encuentra en el rango de [6; 10]
    aumenta su calidad en 2 unidades despues que se actualiza el inventario.
    Se utiliza como referencia un sellIn que se encuentre dentro del rango: 8.
    */
    @Test
    public void calidadDeBackStageAumentaAlDobleTest() {
        backStage.setSellIn(8);
        int calidad= backStage.getQuality();

        inventario.updateQuality();
        assertEquals("La calidad del producto BackStage no aumenta en 2 unidades", backStage.getQuality(), calidad + 2);
    }

    /*
    Se prueba que un producto "Backstage" con un sellIn menor o igual que 5 y mayor que 0
    aumenta su calidad en 3 unidades despues que se actualiza el inventario.
    Se utiliza como referencia un sellIn que se encuentre dentro del rango: 3.
    */
    @Test
    public void calidadDeBackStageAumentaElTripleTest() {
        int calidad = backStage.getQuality();
        backStage.setSellIn(3);

        inventario.updateQuality();
        assertEquals("La calidad del producto BackStage no aumenta en 3 unidadess", backStage.getQuality(), calidad + 3);
    }

    /*
    Se prueba que la calidad del producto "Backstage"  cae a cero si su sellIn es menor o igual que 0.
    Se utiliza como referencia una calidad de 12 y un sellIn de 0.
    */
    @Test
    public void calidadDeBackStageSeAnulaTest() {
        backStage.setQuality(12);
        backStage.setSellIn(0);

        inventario.updateQuality();
        assertEquals("La calidad del producto BackStage vale 0 si su sellIn es menor o igual a 0", backStage.getQuality(), 0);
    }

    /*
    Se prueba que la calidad del producto "Backstage" nunca supera el limite de calidad 50.
    Se utiliza como referencia un sellIn con valor 3, en caso que algun test anterior haya vuelto su sellIn 0.
   */
    @Test
    public void calidadDeBackStageNoSuperaLimiteTest() {
        backStage.setQuality(limiteCalidad);
        backStage.setSellIn(3);

        inventario.updateQuality();
        assertEquals("La calidad del producto BackStage no debe superar el limite de 50", backStage.getQuality(), limiteCalidad);
    }

    /*
   Se prueba que la calidad del producto "Conjured" disminuye en 2 unidades
   despues que se actualiza el inventario.
   Se utiliza como calidad inicial un valor de 6.
    */
    @Test
    public void calidadDeConjuredDisminuyeTest() {
        int calidad = 6;
        conjured.setQuality(calidad);

        inventario.updateQuality();
        assertEquals("La calidad del producto Conjured debe disminuir en 2 unidades", conjured.getQuality(), calidad - 2);
    }

    /*
    Se prueba que el valor de SellIn del producto "Conjured" disminuyen en 1 unidad
    despues que se actualiza el inventario.
    Se utiliza un sellIn de 3.
    */
    @Test
    public void sellInDeConjuredDisminuyeTest() {
        int sellIn = 3;
        conjured.setSellIn(sellIn);

        inventario.updateQuality();
        assertEquals("El sellIn del producto Conjured no disminuyo en 1 unidad", conjured.getSellIn(), sellIn - 1);

    }

    /*
    Se prueba que la calidad del producto "Conjured" nunca disminuye a un valor menor que cero.
    Se utiliza una calidad de referencia de 0.
     */
    @Test
    public void calidadDeConjuredNoEsNegativaTest() {
        conjured.setQuality(0);

        inventario.updateQuality();
        assertEquals("La calidad del producto Conjured nunca es negativa", conjured.getQuality(), 0);
    }

}