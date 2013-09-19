package ar.fiuba.tecnicas.giledrose;


public class FabricaArticulo {
    private static FabricaArticulo fabrica;

    private FabricaArticulo() {
    }

    public static FabricaArticulo obtenerFabrica() {
        if(fabrica == null)
            fabrica = new FabricaArticulo();
        return fabrica;
    }

    public Articulo obtenerArticulo(Item item) {
        switch (item.getName()) {
            case "+5 Dexterity Vest":           return new Comun(item);
            case "Aged Brie":                   return new AgeBrie(item);
            case "Elixir of the Mongoose":      return new Comun(item);
            case "Sulfuras, Hand of Ragnaros":  return new Sulfura(item);
            case "Backstage passes to a TAFKAL80ETC concert": return new BackStage(item);
            default: return new Conjured(item);
        }
    }

    public Articulo[] obtenerArticulos() {
        return new Articulo[]{
                new Comun(new Item("+5 Dexterity Vest", 10, 20)),
                new AgeBrie(new Item("Aged Brie", 2, 0)),
                new Comun(new Item("Elixir of the Mongoose", 5, 7)),
                new Sulfura(new Item("Sulfuras, Hand of Ragnaros", 0, 80)),
                new BackStage(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)),
                new Conjured(new Item("Conjured Mana Cake", 3, 6))
        };
    }
}
