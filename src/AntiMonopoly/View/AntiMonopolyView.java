package AntiMonopoly.View.MainScreen;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class AntiMonopolyView extends GridPane {

    //Menubar
    private MenuItem afsluitenMI;
    private MenuItem standMI;
    private MenuItem spelregelsMI;
    private Label spelInfo;
    //Spelbordtegels
    //Rue Grande
    private Label rg1, rg3, rg4;
    private Button rg2;
    private VBox rueGrande;

    //Diestsestraat, Leuven
    private Label ds1, ds3, ds4;
    private Button ds2;
    private VBox diestsesttraat;

    //Steenstraat Brugge
    private Label ss1, ss3, ss4;
    private Button ss2;
    private VBox steenstraat;

    //Place Du Monument Spa
    private Label pdm1, pdm3, pdm4;
    private Button pdm2;
    private VBox placeDuMonument;

    //Kapellestraat, Oostende
    private Label ks1, ks3, ks4;
    private Button ks2;
    private VBox kapellestraat;

    //Rue De Diekirch, Arlon
    private Label rdd1, rdd3, rdd4;
    private Button rdd2;
    private VBox rueDeDiekrich;

    //Bruul, Mechelen
    private Label b1, b3, b4;
    private Button b2;
    private VBox bruul;

    //Place Verte, Verviers
    private Label pv1, pv3, pv4;
    private Button pv2;
    private VBox placeVerte;

    //Lippenslaan, Knokke
    private Label ll1, ll3, ll4;
    private Button ll2;
    private VBox lippenslaan;

    //Rue Royale, Tournai
    private Label rr1, rr3, rr4;
    private Button rr2;
    private VBox rueRoyal;

    //Groenplaats, Antwerpen
    private Label gp1, gp3, gp4;
    private Button gp2;
    private VBox groenplaats;

    //Rue Saint Leonard, Liege
    private Label rsl1, rsl3, rsl4;
    private Button rsl2;
    private VBox rueSaintLeonard;

    //Lange Steenstraat, Kortrijk
    private Label ls1, ls3, ls4;
    private Button ls2;
    private VBox langeSteenstraat;

    //Grande Place, Mons
    private Label gpm1, gpm3, gpm4;
    private Button gpm2;
    private VBox grandePlace;

    //Grote Markt, Hasselt
    private Label gm1, gm3, gm4;
    private Button gm2;
    private VBox groteMarkt;

    //Place De l'Ange, Namur
    private Label pdl1, pdl3, pdl4;
    private Button pdl2;
    private VBox placeDeLAnge;

    //Hoogstraat, Brussel
    private Label h1, h3, h4;
    private Button h2;
    private VBox hoogstraat;

    //Veldstraat Gent
    private Label v1, v3, v4;
    private Button v2;
    private VBox veldstraat;

    //Boulevard Tirou, Charleroi
    private Label bv1, bv3, bv4;
    private Button bv2;
    private VBox boulevardTirou;

    //Boulevard d'Avroy, liege
    private Label bda1, bda3, bda4;
    private Button bda2;
    private VBox boulevardDAvroy;

    //Meir, Antwerpen
    private Label m1, m3, m4;
    private Button m2;
    private VBox meir;

    //Nieuwstraat, Brussel
    private Label n1, n3, n4;
    private Button n2;
    private VBox nieuwstraat;


    public AntiMonopolyView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        //Menubar
        this.afsluitenMI = new MenuItem("Afsluiten");
        this.standMI = new MenuItem("Stand");
        this.spelregelsMI = new MenuItem("Spelregels");
        this.spelInfo = new Label("Wachtend op actie");
        //Spelbord
        //Rue Grande, Dinant
        this.rg1 = new Label("Rue Grande");
        this.rg2 = new Button("Straat info");
        this.rg3 = new Label("Rue Grande");
        this.rg4 = new Label("€60");
        //Diestsestraat, Leuven
        this.ds1 = new Label("Leuven");
        this.ds2 = new Button("Straat info");
        this.ds3 = new Label("Diestsestraat");
        this.ds4 = new Label("€60");
        //Steenstraat Brugge
        this.ss1 = new Label("Brugge");
        this.ss2 = new Button("Straat info");
        this.ss3 = new Label("Steenstraat");
        this.ss4 = new Label("€100");
        //Place Du Monument Spa
        this.pdm1 = new Label("Spa");
        this.pdm2 = new Button("Straat info");
        this.pdm3 = new Label("Place Du Monument");
        this.pdm4 = new Label("€100");
        //Kapellestraat, Oostende
        this.ks1 = new Label("Oostende");
        this.ks2 = new Button("Straat info");
        this.ks3 = new Label("Kapellestraat");
        this.ks4 = new Label("€120");
        //Rue De Diekirch, Arlon
        this.rdd1 = new Label("Arlon");
        this.rdd2 = new Button("Straat info");
        this.rdd3 = new Label("Rue De Diekirch");
        this.rdd4 = new Label("€140");
        //Bruul, Mechelen
        this.b1 = new Label("Mechelen");
        this.b2 = new Button("Straat info");
        this.b3 = new Label("Bruul");
        this.b4 = new Label("€140");
        //Place Verte, Verviers
        this.pv1 = new Label("Verviers");
        this.pv2 = new Button("Straat info");
        this.pv3 = new Label("Place Verte");
        this.pv4 = new Label("€160");
        //Lippenslaan, Knokke
        this.ll1 = new Label("Knokke");
        this.ll2 = new Button("Straat info");
        this.ll3 = new Label("Lippenslaan");
        this.ll4 = new Label("€180");
        //Rue Royale, Tournai
        this.rr1 = new Label("Tournai");
        this.rr2 = new Button("Straat info");
        this.rr3 = new Label("Rue Royal");
        this.rr4 = new Label("€180");
        //Groenplaats, Antwerpen
        this.gp1 = new Label("Antwerpen");
        this.gp2 = new Button("Straat info");
        this.gp3 = new Label("Groenplaats");
        this.gp4 = new Label("€200");
        //Rue Saint Leonard, Liege
        this.rsl1 = new Label("Liege");
        this.rsl2 = new Button("Straat info");
        this.rsl3 = new Label("Rue Saint Leonard");
        this.rsl4 = new Label("€220");
        //Lange Steenstraat, Kortrijk
        this.ls1 = new Label("Kortrijk");
        this.ls2 = new Button("Straat info");
        this.ls3 = new Label("Lange Steenstraat");
        this.ls4 = new Label("€220");
        //Grande Place, Mons
        this.gpm1 = new Label("Mons");
        this.gpm2 = new Button("Straat info");
        this.gpm3 = new Label("Grande Place");
        this.gpm4 = new Label("€240");
        //Grote Markt, Hasselt
        this.gm1 = new Label("Hasselt");
        this.gm2 = new Button("Straat info");
        this.gm3 = new Label("Grote Markt");
        this.gm4 = new Label("€260");
        //Place De l'Ange, Namur
        this.pdl1 = new Label("Namur");
        this.pdl2 = new Button("Straat info");
        this.pdl3 = new Label("Place De L' Ange");
        this.pdl4 = new Label("€260");
        //Hoogstraat, Brussel
        this.h1 = new Label("Brussel");
        this.h2 = new Button("Straat info");
        this.h3 = new Label("Hoogstraat");
        this.h4 = new Label("€280");
        //Veldstraat Gent
        this.v1 = new Label("Gent");
        this.v2 = new Button("Straat info");
        this.v3 = new Label("Veldstraat");
        this.v4 = new Label("€300");
        //Boulevard Tirou, Charleroi
        this.bv1 = new Label("Charleroi");
        this.bv2 = new Button("Straat info");
        this.bv3 = new Label("Boulevard Tirou");
        this.bv4 = new Label("€300");
        //Boulevard d'Avroy, liege
        this.bda1 = new Label("Liege");
        this.bda2 = new Button("Straat info");
        this.bda3 = new Label("Boulevard d'Avroy");
        this.bda4 = new Label("€320");
        //Meir, Antwerpen
        this.m1 = new Label("Antwerpen");
        this.m2 = new Button("Straat info");
        this.m3 = new Label("Meir");
        this.m4 = new Label("€350");
        //Nieuwstraat, Brussel
        this.n1 = new Label("Brussel");
        this.n2 = new Button("Straat info");
        this.n3 = new Label("Nieuwstraat");
        this.n4 = new Label("€400");

        //this.dobbelen = new Button("Dice");
    }

    private void layoutNodes() {
        //Menubar
        Menu spelMenu = new Menu("Opties", null, afsluitenMI, standMI, spelregelsMI);
        MenuBar menuBar = new MenuBar(spelMenu);
        this.add(menuBar, 0, 0, 3, 1);


        //spelbord
        //Rue Grande, Dinant
        this.rueGrande = new VBox();
        rueGrande.getChildren().addAll(rg1, rg2, rg3, rg4);
        this.add(rueGrande, 1, 1);
        rueGrande.setId("rg");

        //Diestsestraat, Leuven
        this.diestsesttraat = new VBox();
        diestsesttraat.getChildren().addAll(ds1, ds2, ds3, ds4);
        this.add(diestsesttraat, 3, 1);
        diestsesttraat.setId("ds");


        // Steenstraat, Brugge
        this.steenstraat = new VBox();
        steenstraat.getChildren().addAll(ss1, ss2, ss3, ss4);
        this.add(steenstraat, 6, 1);
        steenstraat.setId("ss");

        //Place Du Monument Spa
        this.placeDuMonument = new VBox();
        placeDuMonument.getChildren().addAll(pdm1, pdm2, pdm3, pdm4);
        this.add(placeDuMonument, 8, 1);
        placeDuMonument.setId("pdm");

        //Kapellestraat, Oostende
        this.kapellestraat = new VBox();
        kapellestraat.getChildren().addAll(ks1, ks2, ks3, ks4);
        this.add(kapellestraat, 9, 1);
        kapellestraat.setId("ks");

        //Rue De Diekirch, Arlon
        this.rueDeDiekrich = new VBox();
        rueDeDiekrich.getChildren().addAll(rdd1, rdd2, rdd3, rdd4);
        this.add(rueDeDiekrich, 10, 2);
        rueDeDiekrich.setId("rdd");

        //Bruul, Mechelen
        this.bruul = new VBox();
        bruul.getChildren().addAll(b1, b2, b3, b4);
        this.add(bruul, 10, 4);
        bruul.setId("b");

        //Place Verte, Verviers
        this.placeVerte = new VBox();
        placeVerte.getChildren().addAll(pv1, pv2, pv3, pv4);
        this.add(placeVerte, 10, 5);
        placeVerte.setId("pv");

        //Lippenslaan, Knokke
        this.lippenslaan = new VBox();
        lippenslaan.getChildren().addAll(ll1, ll2, ll3, ll4);
        this.add(lippenslaan, 10, 7);
        lippenslaan.setId("ll");

        //Rue Royale, Tournai
        this.rueRoyal = new VBox();
        rueRoyal.getChildren().addAll(rr1, rr2, rr3, rr4);
        this.add(rueRoyal, 10, 9);
        rueRoyal.setId("rr");

        //Groenplaats, Antwerpen
        this.groenplaats = new VBox();
        groenplaats.getChildren().addAll(gp1, gp2, gp3, gp4);
        this.add(groenplaats, 10, 10);
        groenplaats.setId("gr");

        //Rue Saint Leonard, Liege
        this.rueSaintLeonard = new VBox();
        rueSaintLeonard.getChildren().addAll(rsl1, rsl2, rsl3, rsl4);
        this.add(rueSaintLeonard, 9, 11);
        rueSaintLeonard.setId("rsl");

        //Lange Steenstraat, Kortrijk
        this.langeSteenstraat = new VBox();
        langeSteenstraat.getChildren().addAll(ls1, ls2, ls3, ls4);
        this.add(langeSteenstraat, 7, 11);
        langeSteenstraat.setId("ls");

        //Grande Place, Mons
        this.grandePlace = new VBox();
        grandePlace.getChildren().addAll(gpm1, gpm2, gpm3, gpm4);
        this.add(grandePlace, 6, 11);
        grandePlace.setId("gpm");

        //Grote Markt, Hasselt
        this.groteMarkt = new VBox();
        groteMarkt.getChildren().addAll(gm1, gm2, gm3, gm4);
        this.add(groteMarkt, 4, 11);
        groteMarkt.setId("gm");

        //Place De l'Ange, Namur
        this.placeDeLAnge = new VBox();
        placeDeLAnge.getChildren().addAll(pdl1, pdl2, pdl3, pdl4);
        this.add(placeDeLAnge, 3, 11);
        placeDeLAnge.setId("pdl");

        //Hoogstraat, Brussel
        this.hoogstraat = new VBox();
        hoogstraat.getChildren().addAll(h1, h2, h3, h4);
        this.add(hoogstraat, 1, 11);
        hoogstraat.setId("h");

        //Veldstraat Gent
        this.veldstraat = new VBox();
        veldstraat.getChildren().addAll(v1, v2, v3, v4);
        this.add(veldstraat, 0, 10);
        veldstraat.setId("v");

        //Boulevard Tirou, Charleroi
        this.boulevardTirou = new VBox();
        boulevardTirou.getChildren().addAll(bv1, bv2, bv3, bv4);
        this.add(boulevardTirou, 0, 9);
        boulevardTirou.setId("bv");

        //Boulevard d'Avroy, liege
        this.boulevardDAvroy = new VBox();
        boulevardDAvroy.getChildren().addAll(bda1, bda2, bda3, bda4);
        this.add(boulevardDAvroy, 0, 7);
        boulevardDAvroy.setId("bda");

        //Meir, Antwerpen
        this.meir = new VBox();
        meir.getChildren().addAll(m1, m2, m3, m4);
        this.add(meir, 0, 4);
        meir.setId("m");

        //Nieuwstraat, Brussel
        this.nieuwstraat = new VBox();
        nieuwstraat.getChildren().addAll(n1, n2, n3, n4);
        this.add(nieuwstraat, 0, 2);
        nieuwstraat.setId("n");


//        this.setGridLinesVisible(true);





        // implementatie van de nodige
        // package-private Getters

    }
}
