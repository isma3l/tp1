package ar.fiuba.tecnicas.giledrose;

public class Inventory {
    private Articulo[] articulos;

    public Inventory(Item[] items) {
        FabricaArticulo fabrica = FabricaArticulo.obtenerFabrica();
        articulos = new Articulo[items.length];

        for(int i = 0; i < items.length; i++)
            articulos[i] = fabrica.obtenerArticulo(items[i]);
    }

    public Inventory() {
        FabricaArticulo fabrica = FabricaArticulo.obtenerFabrica();
        articulos = fabrica.obtenerArticulos();
    }

    public void updateQuality() {
        for(Articulo articulo: articulos)
            articulo.update();
    }
}
