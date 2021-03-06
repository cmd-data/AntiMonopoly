package AntiMonopoly.View.MainScreen;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class MainView extends GridPane {

    //Achtergrond
    private VBox achtergrond;

    //Menubar
    private MenuItem spelregelsMI;
    private Label spelInfo;

    //Spelbordtegels
    //Straten
    //Rue Grande
    private Label rg1, rg3, rg4;
    private Button rg2;
    private static VBox rueGrande;

    //Diestsestraat, Leuven
    private Label ds1, ds3, ds4;
    private Button ds2;
    private static VBox diestsesttraat;

    //Steenstraat Brugge
    private Label ss1, ss3, ss4;
    private Button ss2;
    private static VBox steenstraat;

    //Place Du Monument Spa
    private Label pdm1, pdm3, pdm4;
    private Button pdm2;
    private static VBox placeDuMonument;

    //Kapellestraat, Oostende
    private Label ks1, ks3, ks4;
    private Button ks2;
    private static VBox kapellestraat;

    //Rue De Diekirch, Arlon
    private Label rdd1, rdd3, rdd4;
    private Button rdd2;
    private static VBox rueDeDiekrich;

    //Bruul, Mechelen
    private Label b1, b3, b4;
    private Button b2;
    private static VBox bruul;

    //Place Verte, Verviers
    private Label pv1, pv3, pv4;
    private Button pv2;
    private static VBox placeVerte;

    //Lippenslaan, Knokke
    private Label ll1, ll3, ll4;
    private Button ll2;
    private static VBox lippenslaan;

    //Rue Royale, Tournai
    private Label rr1, rr3, rr4;
    private Button rr2;
    private static VBox rueRoyal;

    //Groenplaats, Antwerpen
    private Label gp1, gp3, gp4;
    private Button gp2;
    private static VBox groenplaats;

    //Rue Saint Leonard, Liege
    private Label rsl1, rsl3, rsl4;
    private Button rsl2;
    private static VBox rueSaintLeonard;

    //Lange Steenstraat, Kortrijk
    private Label ls1, ls3, ls4;
    private Button ls2;
    private static VBox langeSteenstraat;

    //Grande Place, Mons
    private Label gpm1, gpm3, gpm4;
    private Button gpm2;
    private static VBox grandePlace;

    //Grote Markt, Hasselt
    private Label gm1, gm3, gm4;
    private Button gm2;
    private static VBox groteMarkt;

    //Place De l'Ange, Namur
    private Label pdl1, pdl3, pdl4;
    private Button pdl2;
    private static VBox placeDeLAnge;

    //Hoogstraat, Brussel
    private Label h1, h3, h4;
    private Button h2;
    private static VBox hoogstraat;

    //Veldstraat Gent
    private Label v1, v3, v4;
    private Button v2;
    private static VBox veldstraat;

    //Boulevard Tirou, Charleroi
    private Label bv1, bv3, bv4;
    private Button bv2;
    private static VBox boulevardTirou;

    //Boulevard d'Avroy, liege
    private Label bda1, bda3, bda4;
    private Button bda2;
    private static VBox boulevardDAvroy;

    //Meir, Antwerpen
    private Label m1, m3, m4;
    private Button m2;
    private static VBox meir;

    //Nieuwstraat, Brussel
    private Label n1, n3, n4;
    private Button n2;
    private static VBox nieuwstraat;

    //Transportberdijven
    //Noord Station
    private Label ns1;
    private Button ns2;
    private ImageView ns3;
    private static VBox noordStation;

    //Zuid Station
    private Label zs1;
    private Button zs2;
    private ImageView zs3;
    private static VBox zuidStation;

    //Oost Station
    private Label os1;
    private Button os2;
    private ImageView os3;
    private static VBox oostStation;

    //West Station
    private Label ws1;
    private Button ws2;
    private ImageView ws3;
    private static VBox westStation;

    //Kaart nemen
    //Neem monopoly- of concurentenkaart
    //#1
    private Label nk11, nk12;
    private ImageView nk13;
    private VBox neemKaart1;
    //#2
    private Label nk21, nk22;
    private ImageView nk23;
    private VBox neemKaart2;
    //#3
    private Label nk31, nk32;
    private ImageView nk33;
    private VBox neemKaart3;
    //#4
    private Label nk41, nk42;
    private ImageView nk43;
    private VBox neemKaart4;
    //#5
    private Label nk51, nk52;
    private ImageView nk53;
    private VBox neemKaart5;
    //#6
    private Label nk61, nk62;
    private ImageView nk63;
    private VBox neemKaart6;

    //Belastingen
    //Eigendomsbelasting
    private Label eb1, eb2;
    private ImageView eb3;
    private VBox eigendomsbelasting;

    //Inkomstenbelasting
    private Label ib1, ib2;
    private ImageView ib3;
    private VBox inkomstenbelasting;


    //Enegiebedrijven
    //elektriciteitsmaatschappij
    private Label em1, em2;
    private ImageView em3;
    private static VBox elektriciteitsbedrijf;


    //Gasmaatschappij
    private Label gas1, gas2;
    private ImageView gas3;
    private static VBox gasmaatschappij;

    //Hoektegels
    //Ga naar de gevangenis
    private Label gng1;
    private ImageView gng2;
    private VBox gaNaarDeGevangenis;

    //Start
    private Label start1, start2;
    private ImageView start3;
    private VBox start;

    //Gevangenis
    private Label gev1;
    private ImageView gev2;
    private VBox gevangenis;

    //Antimonopolystichting
    private Label ams1, ams2;
    private ImageView ams3;
    private VBox antiMonopolyStichting;

    //Trekstapels
    //Monopolistenstapel
    private Label ms1;
    private VBox monopolistenTrekstapel;

    //Concurrententrekstapel
    private Label cs1;
    private VBox concurrentenTrekstapel;

    //Spelersnamen invullen

    private static String aanZetlayout;

    //Eigendommen layout

    private static String speler1Eigendom, speler2Eigendom, speler3Eigendom, speler4Eigendom;

    //Speler 1
    private Label s11;
    private static Label s12, s14, s15;
    private static VBox speler1;
    private ImageView s13;

    //Speler 2
    private Label s21;
    private static Label s22, s24, s25;
    private static VBox speler2;
    private ImageView s23;

    //Speler 3
    private Label s31;
    private static Label s32, s34, s35;
    private static VBox speler3;
    private ImageView s33;

    //Speler 4
    private Label s41;
    private static Label s42, s44, s45;
    private static VBox speler4;
    private ImageView s43;

    //Spelopties
    private static Label so1;
    private static VBox spelopties;
    private Button hypotheekKnop, verkoopGebouwen, verkoopEigendom, bouwen;
    private ComboBox eigendommen, hypotheken, bebouwdeEigendommen, aantalHuizen;

    public MainView() {
        this.initialiseNodes();
        this.layoutNodes();
        this.animate();
    }


    private void initialiseNodes() {
        //pion
        //this.canvas = new Canvas(1650,990);
        //GraphicsContext gc = this.canvas.getGraphicsContext2D();
        //this.rectangle1 = new Rectangle(100,100,100,100);
        //this.rectangle1.setFill(Color.BLUEVIOLET);



        //Menubar
        this.spelregelsMI = new MenuItem("Spelregels");
        this.spelInfo = new Label("Wachtend op actie");

        //Spelbord
        //Rue Grande, Dinant
        this.rg1 = new Label("Rue Grande");
        this.rg2 = new Button("Straat info");
        this.rg3 = new Label("Rue Grande");
        this.rg4 = new Label("€60k");

        //Diestsestraat, Leuven
        this.ds1 = new Label("Leuven");
        this.ds2 = new Button("Straat info");
        this.ds3 = new Label("Diestsestraat");
        this.ds4 = new Label("€60k");

        //Steenstraat Brugge
        this.ss1 = new Label("Brugge");
        this.ss2 = new Button("Straat info");
        this.ss3 = new Label("Steenstraat");
        this.ss4 = new Label("€100k");

        //Place Du Monument Spa
        this.pdm1 = new Label("Spa");
        this.pdm2 = new Button("Straat info");
        this.pdm3 = new Label("Place Du Monument");
        this.pdm4 = new Label("€100k");

        //Kapellestraat, Oostende
        this.ks1 = new Label("Oostende");
        this.ks2 = new Button("Straat info");
        this.ks3 = new Label("Kapellestraat");
        this.ks4 = new Label("€120k");

        //Rue De Diekirch, Arlon
        this.rdd1 = new Label("Arlon");
        this.rdd2 = new Button("Straat info");
        this.rdd3 = new Label("Rue De Diekirch");
        this.rdd4 = new Label("€140k");

        //Bruul, Mechelen
        this.b1 = new Label("Mechelen");
        this.b2 = new Button("Straat info");
        this.b3 = new Label("Bruul");
        this.b4 = new Label("€140k");

        //Place Verte, Verviers
        this.pv1 = new Label("Verviers");
        this.pv2 = new Button("Straat info");
        this.pv3 = new Label("Place Verte");
        this.pv4 = new Label("€160k");

        //Lippenslaan, Knokke
        this.ll1 = new Label("Knokke");
        this.ll2 = new Button("Straat info");
        this.ll3 = new Label("Lippenslaan");
        this.ll4 = new Label("€180k");

        //Rue Royale, Tournai
        this.rr1 = new Label("Tournai");
        this.rr2 = new Button("Straat info");
        this.rr3 = new Label("Rue Royal");
        this.rr4 = new Label("€180k");

        //Groenplaats, Antwerpen
        this.gp1 = new Label("Antwerpen");
        this.gp2 = new Button("Straat info");
        this.gp3 = new Label("Groenplaats");
        this.gp4 = new Label("€200k");

        //Rue Saint Leonard, Liege
        this.rsl1 = new Label("Liege");
        this.rsl2 = new Button("Straat info");
        this.rsl3 = new Label("Rue Saint Leonard");
        this.rsl4 = new Label("€220k");

        //Lange Steenstraat, Kortrijk
        this.ls1 = new Label("Kortrijk");
        this.ls2 = new Button("Straat info");
        this.ls3 = new Label("Lange Steenstraat");
        this.ls4 = new Label("€220k");

        //Grande Place, Mons
        this.gpm1 = new Label("Mons");
        this.gpm2 = new Button("Straat info");
        this.gpm3 = new Label("Grande Place");
        this.gpm4 = new Label("€240k");

        //Grote Markt, Hasselt
        this.gm1 = new Label("Hasselt");
        this.gm2 = new Button("Straat info");
        this.gm3 = new Label("Grote Markt");
        this.gm4 = new Label("€260k");

        //Place De l'Ange, Namur
        this.pdl1 = new Label("Namur");
        this.pdl2 = new Button("Straat info");
        this.pdl3 = new Label("Place De L' Ange");
        this.pdl4 = new Label("€260k");

        //Hoogstraat, Brussel
        this.h1 = new Label("Brussel");
        this.h2 = new Button("Straat info");
        this.h3 = new Label("Hoogstraat");
        this.h4 = new Label("€280k");

        //Veldstraat Gent
        this.v1 = new Label("Gent");
        this.v2 = new Button("Straat info");
        this.v3 = new Label("Veldstraat");
        this.v4 = new Label("€300k");

        //Boulevard Tirou, Charleroi
        this.bv1 = new Label("Charleroi");
        this.bv2 = new Button("Straat info");
        this.bv3 = new Label("Boulevard Tirou");
        this.bv4 = new Label("€300k");

        //Boulevard d'Avroy, liege
        this.bda1 = new Label("Liege");
        this.bda2 = new Button("Straat info");
        this.bda3 = new Label("Boulevard d'Avroy");
        this.bda4 = new Label("€320k");

        //Meir, Antwerpen
        this.m1 = new Label("Antwerpen");
        this.m2 = new Button("Straat info");
        this.m3 = new Label("Meir");
        this.m4 = new Label("€350k");

        //Nieuwstraat, Brussel
        this.n1 = new Label("Brussel");
        this.n2 = new Button("Straat info");
        this.n3 = new Label("Nieuwstraat");
        this.n4 = new Label("€400k");

        //Noord Station
        this.ns1 = new Label("Noord station");
        this.ns2 = new Button("Stations Info");
        this.ns3 = new ImageView("/images/Main/station.png");

        //Zuid Station
        this.zs1 = new Label("Buurspoorwegen");
        this.zs2 = new Button("Stations Info");
        this.zs3 = new ImageView("/images/Main/station.png");

        //Oost Station
        this.os1 = new Label("Centraal station");
        this.os2 = new Button("Stations Info");
        this.os3 = new ImageView("/images/Main/station.png");

        //West Station
        this.ws1 = new Label("Zuid station");
        this.ws2 = new Button("Stations Info");
        this.ws3 = new ImageView("/images/Main/station.png");

        //Kaart nemen
        //Neem monopoly- of concurentenkaart
        //#1
        this.nk11 = new Label("Kaart");
        this.nk12 = new Label("Trek een kaart");
        this.nk13 = new ImageView("/images/Main/neemKaart.png");
        //#2
        this.nk21 = new Label("Kaart");
        this.nk22 = new Label("Trek een kaart");
        this.nk23 = new ImageView("/images/Main/neemKaart.png");
        //#3
        this.nk31 = new Label("Kaart");
        this.nk32 = new Label("Trek een kaart");
        this.nk33 = new ImageView("/images/Main/neemKaart.png");
        //#4
        this.nk41 = new Label("Kaart");
        this.nk42 = new Label("Trek een kaart");
        this.nk43 = new ImageView("/images/Main/neemKaart.png");
        //#5
        this.nk51 = new Label("Kaart");
        this.nk52 = new Label("Trek een kaart");
        this.nk53 = new ImageView("/images/Main/neemKaart.png");
        //#6
        this.nk61 = new Label("Kaart");
        this.nk62 = new Label("Trek een kaart");
        this.nk63 = new ImageView("/images/Main/neemKaart.png");

        //Belastingen
        //Eigendomsbelasting
        this.eb1 = new Label("Eigendomsbelasting");
        this.eb2 = new Label("€75k");
        this.eb3 = new ImageView("/images/Main/eigendomsbelasting.png");

        //Inkomstenbelasting
        this.ib1 = new Label("Inkomstenbelasting");
        this.ib2 = new Label("€200k*");
        this.ib3 = new ImageView("/images/Main/inkomstenbelasting.png");

        //Enegiebedrijven
        //elektriciteitsmaatschappij
        this.em1 = new Label("Elektriciteitsmaatschappij");
        this.em2 = new Label("Dobbel voor rekening");
        this.em3 = new ImageView("/images/Main/elektriciteit.jpg");


        //Gasmaatschappij
        this.gas1 = new Label("gasmaatschappij");
        this.gas2 = new Label("Dobbel voor rekening");
        this.gas3 = new ImageView("/images/Main/gas.png");


        //Hoektegels
        //Ga naar de gevangenis
        this.gng1 = new Label("Ga naar de gevangenis");
        this.gng2 = new ImageView("/images/Main/gaNaarDeGevangenis.jpg");

        //Start
        this.start1 = new Label("Start");
        this.start2 = new Label("Ontvang €200k");
        this.start3 = new ImageView("/images/Main/start.jpg");

        //Gevangenis
        this.gev1 = new Label("Gevangenis");
        this.gev2 = new ImageView("/images/Main/gevangenis.jpg");

        //Antimonopolystichting
        this.ams1 = new Label("Anti-monopoly stichting");
        this.ams2 = new Label("Dobbel voor ontvangst");
        this.ams3 = new ImageView("/images/Main/stichting.png");

        //Trekstapels
        //Monopolistentrekstapel
        this.ms1 = new Label("Monopolisten Kaarten");


        //Concurrententrekstapel
        this.cs1 = new Label("Concurrenten Kaarten");


        //Spelersnamen
        //Speler 1
        this.s11 = new Label();
        s12 = new Label();
        this.s13 = new ImageView();
        s14 = new Label();
        s15 = new Label();

        //Speler 2
        this.s21 = new Label();
        s22 = new Label();
        this.s23 = new ImageView();
        s24 = new Label();
        s25 = new Label();

        //Speler 3
        this.s31 = new Label();
        s32 = new Label();
        this.s33 = new ImageView();
        s34 = new Label();
        s35 = new Label();

        //Speler 4
        this.s41 = new Label();
        s42 = new Label();
        this.s43 = new ImageView();
        s44 = new Label();
        s45 = new Label();

        //Spelopties
        so1 = new Label();
        spelopties = new VBox();
        this.hypotheekKnop = new Button("Hypotheek");
        this.verkoopGebouwen = new Button("VerkoopGebouwen");
        this.verkoopEigendom = new Button("VerkoopEigendom");
        this.bouwen = new Button("Bouwen");
        this.eigendommen = new ComboBox<String>();
        this.hypotheken = new ComboBox<String>();
        this.bebouwdeEigendommen = new ComboBox<String>();
        this.aantalHuizen = new ComboBox<Integer>();

    }

    private void layoutNodes() {
        //pion



        //Menubar
        Menu spelMenu = new Menu("Opties", null, spelregelsMI);
        MenuBar menuBar = new MenuBar(spelMenu);
        this.add(menuBar, 0, 0, 1, 1);
        menuBar.setId("sm");


        //spelbord
        //achtergrond
        this.achtergrond = new VBox();
        this.add(achtergrond,1,2,9,9);
        achtergrond.setId("ag");

        //Rue Grande, Dinant
        rueGrande = new VBox();
        rueGrande.getChildren().addAll(rg1, rg2, rg3, rg4);
        this.add(rueGrande, 1, 1);
        rueGrande.setId("rg");

        //Diestsestraat, Leuven
        diestsesttraat = new VBox();
        diestsesttraat.getChildren().addAll(ds1, ds2, ds3, ds4);
        this.add(diestsesttraat, 3, 1);
        diestsesttraat.setId("ds1");


        // Steenstraat, Brugge
        steenstraat = new VBox();
        steenstraat.getChildren().addAll(ss1, ss2, ss3, ss4);
        this.add(steenstraat, 6, 1);
        steenstraat.setId("ss");

        //Place Du Monument Spa
        placeDuMonument = new VBox();
        placeDuMonument.getChildren().addAll(pdm1, pdm2, pdm3, pdm4);
        this.add(placeDuMonument, 8, 1);
        placeDuMonument.setId("pdm");

        //Kapellestraat, Oostende
        kapellestraat = new VBox();
        kapellestraat.getChildren().addAll(ks1, ks2, ks3, ks4);
        this.add(kapellestraat, 9, 1);
        kapellestraat.setId("ks");

        //Rue De Diekirch, Arlon
        rueDeDiekrich = new VBox();
        rueDeDiekrich.getChildren().addAll(rdd1, rdd2, rdd3, rdd4);
        this.add(rueDeDiekrich, 10, 2);
        rueDeDiekrich.setId("rdd");

        //Bruul, Mechelen
        bruul = new VBox();
        bruul.getChildren().addAll(b1, b2, b3, b4);
        this.add(bruul, 10, 4);
        bruul.setId("b");

        //Place Verte, Verviers
        placeVerte = new VBox();
        placeVerte.getChildren().addAll(pv1, pv2, pv3, pv4);
        this.add(placeVerte, 10, 5);
        placeVerte.setId("pv");

        //Lippenslaan, Knokke
        lippenslaan = new VBox();
        lippenslaan.getChildren().addAll(ll1, ll2, ll3, ll4);
        this.add(lippenslaan, 10, 7);
        lippenslaan.setId("ll");

        //Rue Royale, Tournai
        rueRoyal = new VBox();
        rueRoyal.getChildren().addAll(rr1, rr2, rr3, rr4);
        this.add(rueRoyal, 10, 9);
        rueRoyal.setId("rr");

        //Groenplaats, Antwerpen
        groenplaats = new VBox();
        groenplaats.getChildren().addAll(gp1, gp2, gp3, gp4);
        this.add(groenplaats, 10, 10);
        groenplaats.setId("gr");

        //Rue Saint Leonard, Liege
        rueSaintLeonard = new VBox();
        rueSaintLeonard.getChildren().addAll(rsl1, rsl2, rsl3, rsl4);
        this.add(rueSaintLeonard, 9, 11);
        rueSaintLeonard.setId("rsl");

        //Lange Steenstraat, Kortrijk
        langeSteenstraat = new VBox();
        langeSteenstraat.getChildren().addAll(ls1, ls2, ls3, ls4);
        this.add(langeSteenstraat, 7, 11);
        langeSteenstraat.setId("ls");

        //Grande Place, Mons
        grandePlace = new VBox();
        grandePlace.getChildren().addAll(gpm1, gpm2, gpm3, gpm4);
        this.add(grandePlace, 6, 11);
        grandePlace.setId("gpm");

        //Grote Markt, Hasselt
        groteMarkt = new VBox();
        groteMarkt.getChildren().addAll(gm1, gm2, gm3, gm4);
        this.add(groteMarkt, 4, 11);
        groteMarkt.setId("gm");

        //Place De l'Ange, Namur
        placeDeLAnge = new VBox();
        placeDeLAnge.getChildren().addAll(pdl1, pdl2, pdl3, pdl4);
        this.add(placeDeLAnge, 3, 11);
        placeDeLAnge.setId("pdl");

        //Hoogstraat, Brussel
        hoogstraat = new VBox();
        hoogstraat.getChildren().addAll(h1, h2, h3, h4);
        this.add(hoogstraat, 1, 11);
        hoogstraat.setId("h");

        //Veldstraat Gent
        veldstraat = new VBox();
        veldstraat.getChildren().addAll(v1, v2, v3, v4);
        this.add(veldstraat, 0, 10);
        veldstraat.setId("v");

        //Boulevard Tirou, Charleroi
        boulevardTirou = new VBox();
        boulevardTirou.getChildren().addAll(bv1, bv2, bv3, bv4);
        this.add(boulevardTirou, 0, 9);
        boulevardTirou.setId("bv");

        //Boulevard d'Avroy, liege
        boulevardDAvroy = new VBox();
        boulevardDAvroy.getChildren().addAll(bda1, bda2, bda3, bda4);
        this.add(boulevardDAvroy, 0, 7);
        boulevardDAvroy.setId("bda");

        //Meir, Antwerpen
        meir = new VBox();
        meir.getChildren().addAll(m1, m2, m3, m4);
        this.add(meir, 0, 4);
        meir.setId("m");

        //Nieuwstraat, Brussel
        nieuwstraat = new VBox();
        nieuwstraat.getChildren().addAll(n1, n2, n3, n4);
        this.add(nieuwstraat, 0, 2);
        nieuwstraat.setId("n");

        //Stations
        //Noord Station
        noordStation = new VBox();
        noordStation.getChildren().addAll(ns1, ns2, ns3);
        this.add(noordStation, 5, 1);
        noordStation.setId("ns");


        //Zuid Station
        zuidStation = new VBox();
        zuidStation.getChildren().addAll(zs1, zs2, zs3);
        this.add(zuidStation, 5, 11);
        zuidStation.setId("zs");

        //Oost Station
        oostStation = new VBox();
        oostStation.getChildren().addAll(os1, os2, os3);
        this.add(oostStation, 10, 6);
        oostStation.setId("os");


        //West Station
        westStation = new VBox();
        westStation.getChildren().addAll(ws1, ws2, ws3);
        this.add(westStation, 0, 6);
        westStation.setId("ws");

        //Kaart nemen
        //Neem monopoly- of concurentenkaart
        //#1
        this.neemKaart1 = new VBox();
        neemKaart1.getChildren().addAll(nk11, nk12, nk13);
        this.add(neemKaart1, 7, 1);
        neemKaart1.setId("nk1");

        //#2
        this.neemKaart2 = new VBox();
        neemKaart2.getChildren().addAll(nk21, nk22, nk23);
        this.add(neemKaart2, 2, 1);
        neemKaart2.setId("nk2");

        //#3
        this.neemKaart3 = new VBox();
        neemKaart3.getChildren().addAll(nk31, nk32, nk33);
        this.add(neemKaart3, 0, 5);
        neemKaart3.setId("nk3");

        //#4
        this.neemKaart4 = new VBox();
        neemKaart4.getChildren().addAll(nk41, nk42, nk43);
        this.add(neemKaart4, 0, 8);
        neemKaart4.setId("nk4");

        //#5
        this.neemKaart5 = new VBox();
        neemKaart5.getChildren().addAll(nk51, nk52, nk53);
        this.add(neemKaart5, 10, 8);
        neemKaart5.setId("nk5");

        //#6
        this.neemKaart6 = new VBox();
        neemKaart6.getChildren().addAll(nk61, nk62, nk63);
        this.add(neemKaart6, 8, 11);
        neemKaart6.setId("nk6");

        //Belastingen
        //Eigendomsbelasting
        this.eigendomsbelasting = new VBox();
        eigendomsbelasting.getChildren().addAll(eb1, eb2, eb3);
        this.add(eigendomsbelasting, 0, 3);
        eigendomsbelasting.setId("eb");

        //Inkomstenbelasting
        this.inkomstenbelasting = new VBox();
        inkomstenbelasting.getChildren().addAll(ib1, ib2, ib3);
        this.add(inkomstenbelasting, 4, 1);
        inkomstenbelasting.setId("ib");

        //Enegiebedrijven
        //elektriciteitsmaatschappij
        elektriciteitsbedrijf = new VBox();
        elektriciteitsbedrijf.getChildren().addAll(em1, em2, em3);
        this.add(elektriciteitsbedrijf, 10, 3);
        elektriciteitsbedrijf.setId("em");

        //Gasmaatschappij
        gasmaatschappij = new VBox();
        gasmaatschappij.getChildren().addAll(gas1, gas2, gas3);
        this.add(gasmaatschappij, 2, 11);
        gasmaatschappij.setId("gas");

        //Hoektegels
        //Ga naar de gevangenis
        this.gaNaarDeGevangenis = new VBox();
        gaNaarDeGevangenis.getChildren().addAll(gng1, gng2);
        this.add(gaNaarDeGevangenis, 0, 11);
        gaNaarDeGevangenis.setId("gng");

        //Start
        this.start = new VBox();
        start.getChildren().addAll(start1, start2, start3);
        this.add(start, 0, 1);
        start.setId("start");

        //Gevangenis
        this.gevangenis = new VBox();
        gevangenis.getChildren().addAll(gev1, gev2);
        this.add(gevangenis, 10, 1);
        gevangenis.setId("gev");


        //Antimonopolystichting
        this.antiMonopolyStichting = new VBox();
        antiMonopolyStichting.getChildren().addAll(ams1, ams2, ams3);
        this.add(antiMonopolyStichting, 10, 11);
        antiMonopolyStichting.setId("ams");

        //Trekkaarten
        //Monopolistenkaarten
        this.concurrentenTrekstapel = new VBox();
        concurrentenTrekstapel.getChildren().addAll(cs1);
        this.add(concurrentenTrekstapel, 7, 7, 2, 2);
        concurrentenTrekstapel.setId("cs");
        concurrentenTrekstapel.setRotate(-50);

        //Concurentenkaarten
        this.monopolistenTrekstapel = new VBox();
        monopolistenTrekstapel.getChildren().addAll(ms1);
        this.add(monopolistenTrekstapel, 2, 4, 2, 2);
        monopolistenTrekstapel.setId("ms");
        monopolistenTrekstapel.setRotate(-50);

        //Spelersnamen

        aanZetlayout = "-fx-border-color: blue;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 4;\n";

        //Speler1
        speler1 = new VBox();
        speler1.getChildren().addAll(s11,s15,s12,s13,s14);
        this.add(speler1,11,1,2,2);
        speler1.setId("s1");

        //Speler2
        speler2 = new VBox();
        speler2.getChildren().addAll(s21,s25,s22,s23,s24);
        this.add(speler2,11,3,2,2);
        speler2.setId("s2");

        speler3 = new VBox();
        speler3.getChildren().addAll(s31,s35,s32,s33,s34);
        this.add(speler3, 11, 5, 2, 2);
        speler3.setId("s3");


        speler4 = new VBox();
        speler4.getChildren().addAll(s41,s45,s42,s43,s44);
        this.add(speler4, 11, 7, 2, 2);
        speler4.setId("s4");

        //Spelopties
        so1 = new Label("Spelopties");
        spelopties.getChildren().addAll(so1,hypotheekKnop, verkoopGebouwen, verkoopEigendom, bouwen);
        this.add(spelopties, 11,9,2,3);
        spelopties.setId("spelopties");

        //SpelerEigendommen

        speler1Eigendom = "-fx-border-color: VIOLET;\n" +
                "-fx-border-width: 3;\n";
        speler2Eigendom = "-fx-border-color: GRAY;\n" +
                "-fx-border-width: 3;\n";
        speler3Eigendom = "-fx-border-color: ALICEBLUE;\n" +
                "-fx-border-width: 3;\n";
        speler4Eigendom = "-fx-border-color: DARKTURQUOISE;\n" +
                "-fx-border-width: 3;\n";


        // implementatie van de nodige
        // package-private Getters
    }

    private void animate() {

    }

    public MenuItem getSpelregelsMI() {
        return spelregelsMI;
    }

    public Button getRg2() {
        return rg2;
    }

    public Button getDs2() {
        return ds2;
    }

    public Button getSs2() {
        return ss2;
    }

    public Button getPdm2() {
        return pdm2;
    }

    public Button getKs2() {
        return ks2;
    }

    public Button getRdd2() {
        return rdd2;
    }

    public Button getB2() {
        return b2;
    }

    public Button getPv2() {
        return pv2;
    }

    public Button getLl2() {
        return ll2;
    }

    public Button getRr2() {
        return rr2;
    }

    public Button getGp2() {
        return gp2;
    }

    public Button getRsl2() {
        return rsl2;
    }

    public Button getLs2() {
        return ls2;
    }

    public Button getGpm2() {
        return gpm2;
    }

    public Button getGm2() {
        return gm2;
    }

    public Button getPdl2() {
        return pdl2;
    }

    public Button getH2() {
        return h2;
    }

    public Button getV2() {
        return v2;
    }

    public Button getBv2() {
        return bv2;
    }

    public Button getBda2() {
        return bda2;
    }

    public Button getM2() {
        return m2;
    }

    public Button getN2() {
        return n2;
    }

    public Button getNs2() {
        return ns2;
    }

    public Button getZs2() {
        return zs2;
    }

    public Button getOs2() {
        return os2;
    }

    public Button getWs2() {
        return ws2;
    }



    public Label getS11() {
        return s11;
    }

    public Label getS21() {
        return s21;
    }

    public Label getS31() {
        return s31;
    }

    public Label getS41() {
        return s41;
    }

    public static Label getS12() { return s12; }

    public static Label getS22() {
        return s22;
    }

    public static Label getS32() {
        return s32;
    }

    public static Label getS42() {
        return s42;
    }

    public ImageView getS13() { return s13; }

    public ImageView getS23() { return s23; }

    public ImageView getS33() { return s33; }

    public ImageView getS43() { return s43; }

    public static Label getS14() { return s14; }

    public static void setS14(Label s14) { MainView.s14 = s14; }

    public static Label getS24() { return s24; }

    public static void setS24(Label s24) { MainView.s24 = s24; }

    public static Label getS34() { return s34; }

    public static void setS34(Label s34) { MainView.s34 = s34; }

    public static Label getS44() { return s44; }

    public static void setS44(Label s44) { MainView.s44 = s44; }

    public static String getAanZetlayout() { return aanZetlayout; }

    public static VBox getSpeler1() { return speler1; }

    public static VBox getSpeler2() { return speler2; }

    public static VBox getSpeler3() { return speler3; }

    public static VBox getSpeler4() { return speler4; }

    public static String getSpeler1Eigendom() { return speler1Eigendom; }

    public static String getSpeler2Eigendom() { return speler2Eigendom; }

    public static String getSpeler3Eigendom() { return speler3Eigendom; }

    public static String getSpeler4Eigendom() { return speler4Eigendom; }

    public static Label getSo1() { return so1; }

    public static VBox getSpelopties() { return spelopties; }

    public Button getHypotheekKnop() { return hypotheekKnop; }

    public Button getVerkoopGebouwen() { return verkoopGebouwen; }

    public Button getVerkoopEigendom() { return verkoopEigendom; }

    public Button getBouwen() { return bouwen; }

    public ComboBox getEigendommen() {
        return eigendommen;
    }

    public ComboBox getHypotheken() { return hypotheken; }

    public ComboBox getBebouwdeEigendommen() { return bebouwdeEigendommen; }

    public ComboBox getAantalHuizen() { return aantalHuizen; }

    public static VBox getRueGrande() {
        return rueGrande;
    }

    public static VBox getDiestsesttraat() {
        return diestsesttraat;
    }

    public static VBox getSteenstraat() {
        return steenstraat;
    }

    public static VBox getPlaceDuMonument() {
        return placeDuMonument;
    }

    public static VBox getKapellestraat() {
        return kapellestraat;
    }

    public static VBox getRueDeDiekrich() {
        return rueDeDiekrich;
    }

    public static VBox getBruul() {
        return bruul;
    }

    public static VBox getPlaceVerte() {
        return placeVerte;
    }

    public static VBox getLippenslaan() {
        return lippenslaan;
    }

    public static VBox getRueRoyal() {
        return rueRoyal;
    }

    public static VBox getGroenplaats() {
        return groenplaats;
    }

    public static VBox getRueSaintLeonard() {
        return rueSaintLeonard;
    }

    public static VBox getLangeSteenstraat() {
        return langeSteenstraat;
    }

    public static VBox getGrandePlace() {
        return grandePlace;
    }

    public static VBox getGroteMarkt() {
        return groteMarkt;
    }

    public static VBox getPlaceDeLAnge() {
        return placeDeLAnge;
    }

    public static VBox getHoogstraat() {
        return hoogstraat;
    }

    public static VBox getVeldstraat() {
        return veldstraat;
    }

    public static VBox getBoulevardTirou() {
        return boulevardTirou;
    }

    public static VBox getBoulevardDAvroy() {
        return boulevardDAvroy;
    }

    public static VBox getMeir() {
        return meir;
    }

    public static VBox getNieuwstraat() {
        return nieuwstraat;
    }

    public static VBox getNoordStation() {
        return noordStation;
    }

    public static VBox getZuidStation() {
        return zuidStation;
    }

    public static VBox getOostStation() {
        return oostStation;
    }

    public static VBox getWestStation() {
        return westStation;
    }

    public static VBox getElektriciteitsbedrijf() {
        return elektriciteitsbedrijf;
    }

    public static VBox getGasmaatschappij() {
        return gasmaatschappij;
    }

    public static Label getS15() { return s15; }

    public static Label getS25() { return s25; }

    public static Label getS35() { return s35; }

    public static Label getS45() { return s45; }
}
