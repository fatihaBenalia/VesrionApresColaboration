package controler;

import bean.Activite;
import bean.ActiviteItem;
import bean.Aide;
import bean.EtatPedagogiqueItem;
import bean.AideItem;
import bean.AssistanteSociale;
import bean.Dossier;
import bean.EtatEthique;

import bean.EtatSanteMere;
import bean.EtatSanteOrphelin;
import bean.Logement;
import bean.Materiel;
import bean.Membre;
import bean.Mere;
import bean.Orphelin;
import bean.Parrinage;
import bean.Pere;
import bean.Punition;
import bean.Region;
import bean.ResponsableFamille;
import bean.ResponsableRegion;
import bean.SousRegion;
import bean.SousResponsableRegion;
import controler.util.DateUtil;

import controler.util.JsfUtil;
import controler.util.JsfUtil.PersistAction;
import controler.util.MathUtil;
import java.io.IOException;
import service.DossierFacade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import service.ActiviteItemFacade;
import service.AideItemFacade;
import service.AssistanteSocialeFacade;

@ManagedBean(name = "dossierController")
@SessionScoped
public class DossierController implements Serializable {

    @EJB
    private ActiviteItemFacade activiteItemFacade;
    @EJB
    private AideItemFacade aideItemFacade;
    @EJB
    private AssistanteSocialeFacade assistanteSocialeFacade;
    @EJB
    private service.DossierFacade ejbFacade;
    private List<Dossier> items = null;
    private Dossier selected;
    private boolean skip;
    private Membre membre;

    private Membre selectedMembre;

    private List<String> orphelinValues;

    private EtatSanteOrphelin etatSanteOrphelin;
    private EtatSanteMere etatSanteMere;
    private Mere mere;
    private Pere pere;
    private ResponsableFamille responsableFamille;

    private AssistanteSociale assistanteSociale1;
    private AssistanteSociale assistanteSociale2;

    private List<Membre> membres;
    private Materiel materiel;
    private List<Materiel> Hasnaa;

    private List<EtatSanteOrphelin> etatSanteOrphelins;
    private List<EtatSanteMere> etatSanteMeres;
    private List<ActiviteItem> activiteItems;
    private ActiviteItem activiteItem;
    private Activite activite;
    private AideItem aideItem;
    private List<AideItem> aideItems;
    private Aide aide;
    private EtatPedagogiqueItem etatPedagogiqueItem;
    private List<EtatPedagogiqueItem> etatPedagogiqueItems;
    private List<AssistanteSociale> sociales;
    private Orphelin orphelin;
    private List<Orphelin> orphelins;
    private Orphelin orphelinF;
    private Orphelin orphelinNF;
    private List<Orphelin> orphelinsNF;
    private List<Orphelin> orphelinsF;

    private EtatSanteOrphelin etatSanteOrphelinF;
    private EtatSanteOrphelin etatSanteOrphelinNF;
    private List<EtatSanteOrphelin> etatSanteOrphelinsF;
    private List<EtatSanteOrphelin> etatSanteOrphelinsNF;
    private List<Orphelin> allOrphelins = new ArrayList();
    private Logement logement;
    private EtatEthique etatEthique;
    private ResponsableRegion responsableRegion;
    private Region region;
    private SousRegion sousRegion;
    private SousResponsableRegion sousResponsableRegion;
    private List<SousRegion> sousRegions;
    private List<SousResponsableRegion> sousResponsableRegions;
    private List<Dossier> dossierNonClasse;
    private List<Dossier> dossierParraines;
    private Date dateMin;
    private Date dateMax;

    private int nbrOrphelin;
    private int nbrDossier;
    private String regionn;
    private String sexe;
    private int ageMin;
    private int ageMax;
    private int nbrMin;
    private int nbrMax;
    private int type;
    private Parrinage parrainage;
    private int sswitch = 0;
    private Date datePriseDossier;
    private boolean possede;
    private boolean partage;
    private boolean location;
    private boolean prochainementPossede;
    private boolean gage;
    private boolean autreType;
    private int premiereAnnee;
    private int deuxiemeAnnee;
    private int premiereAnneee;
    private int deuxiemeAnneee;
    private LineChartModel chartModel;
    private BarChartModel barModel;

    private LineChartModel chartModelOrOrphelin;
    private BarChartModel barModelOrphelin;
    private int typeChart;
    private int typeChartOrphelin;
    private Long max;
    private List<String> images;
    private Punition punition;
    private int choix;

    public DossierController() {

    }

    ///////////////////// update Age ////////////////
    public void updateAgeDossier() {
    ejbFacade.updateAge(orphelin);
    }

    public void updateDossier(){
        ejbFacade.updateDossier(selected);
    }
            
    /////////////////// Pdf //////////////////
    public void generatePdf() throws JRException, IOException {
        ejbFacade.generatePdf(selected, responsableFamille,
                region, responsableRegion,
                assistanteSociale1,
                assistanteSociale2);
        FacesContext.getCurrentInstance().getResponseComplete();
    }

    //////////////////////////////^punition////////////////////////
    public void punition(Dossier dossier) {
    
    }

    //////////////////////////////// Creation Dossier  ////////////////////////
    public void completerDossier() {
        int res = ejbFacade.editerDossier(getSelected(), selected.getMere(),
                pere, selected.getResponsableFamille(),
                logement, Hasnaa, membres,
                aideItems, activiteItems, etatSanteOrphelins,
                orphelinsF,
                etatPedagogiqueItems, aide, activite,
                etatSanteMere,
                assistanteSociale1, assistanteSociale2,
                etatEthique, membre,
                responsableRegion, region, possede,
                partage, location, gage, prochainementPossede,
                autreType);
        System.out.println("haaa res ==> " + res);
        if (res > 0) {
            selected = new Dossier();
            JsfUtil.addSuccessMessage("Dossier Edite avec succces");
           
        } else {
            JsfUtil.addErrorMessage("Dossier Non Edite ");

        }

    }

    public void creationDossier() {
        int resultat = ejbFacade.creationDossier(selected,
                responsableFamille, assistanteSociale1,
                assistanteSociale2, responsableRegion,
                region);
        if (resultat > 0) {
            selected = new Dossier();
            JsfUtil.addSuccessMessage("Dossier Ajoute avec succces");
            viderLesChampsRemplis();
        } else {
            JsfUtil.addErrorMessage("Dossier Non ajoutée ");
            viderLesChampsRemplis();
        }

    }
    
    //////////////////////modifSelonPuni////////////////
    
    public void modifEtat(){
        
     ejbFacade.modifEtat();
    
    }
    
    
    /////////////////////////////////////////////////
    //////////////////////////////Details Dossier //////////////////////

    public void allMembres(Dossier dossier) {
        sswitch = 1;
        selected = dossier;
        getSelected().setMembres(ejbFacade.allMembre(dossier));
    }

    public void allOrphelins(Dossier dossier) {
        sswitch = 2;
        selected = dossier;
        getSelected().setOrphelins(ejbFacade.allOrphelins(dossier));
    }
    
    public void allPunitions(Dossier dossier) {
        choix=1;
        selected = dossier;
        getSelected().setPunitions(ejbFacade.allPunitions(dossier));
    }

    ///////////////La Recherche //////////////////////////////////////////
    public void rechercher() {
        items = ejbFacade.trouver1(regionn, sexe, type, ageMin, ageMax, nbrMin, nbrMax);
    }

    public void rechercher2() {
        dossierParraines = ejbFacade.trouver2(parrainage.getParrain().getId(), parrainage.getType(),
                parrainage.getMontant(), parrainage.getParrain().getMediataire().getId(), datePriseDossier);
    }

    ////////////////////////////////Editer Dossier{Les Recherches}/////////////////////////////
    public void dossierNonClasses() {
        dossierNonClasse = ejbFacade.dossierNonClasse(selected, dateMin, dateMax);

    }

    public void actualiser() {
        dossierNonClasse = ejbFacade.allDossiersNonClass();
    }

    ///////////////////////Calcul d'indice dedossier && etatDossier //////////////////////////////
    public void calculnbrMembre() {
        selected.setNbrMembre(ejbFacade.nbrMembre(membres));

    }

    public void calculIndice() {
        selected.setIndice(ejbFacade.calculIndice(orphelinsF, membres, activite, aide));
    }

    public String continuez() {
        return "/dossier/ListeDossierNonClasses.xhtml";
    }

    ////////////////////// Vider les Listes apres La creation////////////
    public void cleeear() {
        getMembres().clear();
        getHasnaa().clear();
        getOrphelinsF().clear();
        getEtatSanteOrphelins().clear();
        getActiviteItems().clear();
        getAideItems().clear();
    }

    public void viderLesChampsRemplis() {
        selected.setNumero(" ");
        selected.setDateDossier(null);
        selected.setNomFamille(null);
        responsableFamille.setId(null);
        responsableFamille.setNom(null);
        responsableFamille.setPrenom(null);
        responsableFamille.setTelephone(null);
        responsableFamille.setType(null);
        selected.setAdresseActuelle(null);

    }

    ///////////////// Les Methodes Clones Pr L'ajout dans Les Listes Dans l'interface/////////////////
    public void addMembreToDossier() {
        //System.out.println("haaa membre ==> " + getSelectedMembre());
        //System.out.println("membres" + getMembres());
        membres.add(ejbFacade.clonnedMembre(selectedMembre, membres.size() + 1));
        //System.out.println("ha size ==> " + membres.size());

    }

    public void addMateriels() {
        // System.out.println("ha lcontroler =>" + getMateriel());
        Hasnaa.add(ejbFacade.cloneMateriel(materiel, Hasnaa.size() + 1));
    }

    public void addEtatSanteOrphelin() {
        etatSanteOrphelins.add(ejbFacade.cloneEtatSanteOrphelin(etatSanteOrphelin, etatSanteOrphelins.size() + 1,
                orphelinsF.size() + 1, orphelinF));
    }

    public void addActiviteToDossier() {

        activiteItems.add(ejbFacade.cloneActivItem(activiteItem, selectedMembre, membres.size() + 1, activiteItems.size() + 1));
    }

    public void addAideToDossier() {

        aideItems.add(ejbFacade.cloneAideItem(aideItem, aideItems.size() + 1));
    }

    public void addEtatToDossier() {
        System.out.println("haaa orphelin ==> etatSanteOrphelin.getOrphelin().getNom() !::: " + etatSanteOrphelin.getOrphelin().getNom());

        etatPedagogiqueItems.add(ejbFacade.cloneEtatPedagogiqueItem(etatPedagogiqueItem, etatPedagogiqueItems.size() + 1,
                orphelinsF.size() + 1, orphelinF));
    }

    public void calculMontantAide() {
        aide.setMontant(aideItemFacade.CalculMontantTotal(aideItems));
    }

    public void calcul() {
        activite.setMontantTotal(activiteItemFacade.CalculMontantTotal(activiteItems));
    }

//    public void add(Orphelin orphellin) {
//        orphelins.add(ejbFacade.cloneeee(orphellin, orphelins.size() + 1));
//        allOrphelins.add(ejbFacade.cloneeee(orphellin, orphelins.size() + 1));
//    }
    public void addF() {
        orphelinsF.add(ejbFacade.cloneeee(orphelinF, orphelinsF.size() + 1));
        // allOrphelins.add(ejbFacade.cloneeee(orphelinF, orphelinsF.size() + 1));
    }

//    public void addNF() {
//        orphelinsNF.add(ejbFacade.cloneeee(orphelinNF, orphelinsNF.size() + 1));
//        allOrphelins.add(ejbFacade.cloneeee(orphelinNF, orphelinsNF.size() + 1));
//    }
    ////////////////// Suppression///////////////////////
    public void deleteMembre(Membre membre) {
        membres.remove(membre);
        JsfUtil.addSuccessMessage(" Membre Supprimé avec succes");

    }

    public void deleteOrphelin(Orphelin orphelin) {
        orphelins.remove(orphelin);
        JsfUtil.addSuccessMessage(" orphelin Supprimé avec succes");
    }

    public void deleteOrphelinF(Orphelin orphelin) {
        orphelinsF.remove(orphelin);
        JsfUtil.addSuccessMessage(" orphelin Supprimé avec succes");
    }

    public void deleteOrphelinNF(Orphelin orphelin) {
        orphelinsNF.remove(orphelin);
        JsfUtil.addSuccessMessage(" orphelin Supprimé avec succes");
    }

    public void deleteActivite(ActiviteItem activiteItem) {
        activiteItems.remove(activiteItem);
        JsfUtil.addSuccessMessage(" activiteItem Supprimé avec succes");
    }

    public void deleteAide(AideItem aideItem) {
        aideItems.remove(aideItem);
        JsfUtil.addSuccessMessage(" aideItem Supprimé avec succes");
    }

    public void deleteMateriel(Materiel materiel) {
        Hasnaa.remove(materiel);
        JsfUtil.addSuccessMessage(" materiel Supprimé avec succes");
    }

    public void deleteEtatSante(EtatSanteOrphelin etatSanteOrphelin) {
        etatSanteOrphelins.remove(etatSanteOrphelin);
        JsfUtil.addSuccessMessage(" etatSanteOrphelin Supprimé avec succes");
    }

    public void deleteEtatSantePeda(EtatPedagogiqueItem etatPedagogiqueItem) {
        etatPedagogiqueItems.remove(etatPedagogiqueItem);
        JsfUtil.addSuccessMessage(" etatPedagogiqueItem Supprimé avec succes");
    }

///////////////////////////////////////////Changement des Combobox////////////////////////////////////////////////////////
    public void regionChange() {
        sousRegions = ejbFacade.allSousRegionsByRegion(region);
    }

    public void responsableChange() {
        sousResponsableRegions = ejbFacade.allSousResponsableByRespo(responsableRegion);
    }

    ////////////////////////////Statistique Orphelins////////////////////////////////////
    public void afficherChart() {
        System.out.println("voila type chart : " + typeChart);
        if (typeChart == 1) {
            createLineModels();
        }
        if (typeChart == 2) {
            createBarModel();
        }
    }

    private void createLineModels() {

        chartModel = initCategoryModel();
        chartModel.setTitle("Les Statistiques des années " + premiereAnnee + " et " + deuxiemeAnnee
                + "  " + " Selon Le Nombre Des Dossiers Parrainés ");
        chartModel.setLegendPosition("f");

        chartModel.setShowPointLabels(true);
        chartModel.getAxes().put(AxisType.X, new CategoryAxis("Années"));
        Axis yAxis = chartModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre Dossier");
        yAxis.setMin(0);
        yAxis.setMax(max * 1.1);
        Axis xAxis = chartModel.getAxis(AxisType.X);
        xAxis.setMin(0);
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("Statistique des annees " + premiereAnnee + " et " + deuxiemeAnnee
                + "  " + " Selon Le Nombre Des Dossiers Parrainés ");
        barModel.setLegendPosition("f");
        barModel.setShowDatatip(false);
        barModel.setShowPointLabels(true);
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Les Années");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Le Nombre Des Dossier");
        yAxis.setMin(0);
        yAxis.setMax(max * 1.1);
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        Long[] resultas = ejbFacade.statistiqueDossier(premiereAnnee, deuxiemeAnnee, region, sousRegion);
        max = MathUtil.calculerMax(resultas);
        ChartSeries annee1 = new ChartSeries();
        annee1.setLabel("annee 1 " + premiereAnnee);
        annee1.set("" + premiereAnnee, resultas[0]);

        ChartSeries annee2 = new ChartSeries();
        annee2.setLabel("annee 2 " + deuxiemeAnnee);
        annee2.set("" + deuxiemeAnnee, resultas[1]);

        model.addSeries(annee1);
        model.addSeries(annee2);

        return model;
    }

    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();

        Long[] resultas = ejbFacade.statistiqueDossier(premiereAnnee, deuxiemeAnnee, region, sousRegion);
        max = MathUtil.calculerMax(resultas);
        System.out.println("hahowa size ::: " + resultas.length);

        ChartSeries annee1 = new ChartSeries();
        annee1.setLabel("annee " + premiereAnnee);
        annee1.set("" + premiereAnnee, resultas[0]);

        ChartSeries anne2 = new ChartSeries();
        anne2.setLabel("annee " + deuxiemeAnnee);
        anne2.set("" + deuxiemeAnnee, resultas[1]);

        model.addSeries(annee1);
        model.addSeries(anne2);

        return model;

    }
    ///////////////////// Statistique Orphelin //////////////////////

    public void afficherChartOrphelin() {
        System.out.println("voila type chart : " + typeChartOrphelin);
        if (typeChartOrphelin == 3) {
            System.out.println("ana f type 3");
            createLineModelsOrphelin();
        }
        if (typeChartOrphelin == 4) {
            System.out.println("ana f type 4");
            createBarModelOrphelin();
        }

    }

    private LineChartModel initCategoryModelOrphelin() {
        LineChartModel model = new LineChartModel();
        System.out.println("annee 1 :" + premiereAnneee);
        System.out.println("annee 2 :" + deuxiemeAnneee);
        Long[] resultas = ejbFacade.statistiqueOrphelin(premiereAnneee, deuxiemeAnneee, sexe, ageMin);
        max = MathUtil.calculerMax(resultas);
        System.out.println("hahowa size ::: " + resultas.length);

        ChartSeries annee1 = new ChartSeries();
        annee1.setLabel("annee " + premiereAnneee);
        annee1.set("année 1" + premiereAnneee, resultas[0]);

        ChartSeries anne2 = new ChartSeries();
        anne2.setLabel("annee " + deuxiemeAnneee);
        anne2.set("année 2" + deuxiemeAnneee, resultas[1]);

        model.addSeries(annee1);
        model.addSeries(anne2);

        return model;

    }

    private void createLineModelsOrphelin() {

        chartModelOrOrphelin = initCategoryModelOrphelin();
        chartModelOrOrphelin.setTitle("Les Statistique des années " + premiereAnneee + " et " + deuxiemeAnneee
                + "Selon Le Nombre des Orphelins Parrainés");
        chartModelOrOrphelin.setLegendPosition("f");

        chartModelOrOrphelin.setShowPointLabels(true);
        chartModelOrOrphelin.getAxes().put(AxisType.X, new CategoryAxis("Années"));
        Axis yAxis = chartModelOrOrphelin.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre Orphelin");
        yAxis.setMin(0);
        yAxis.setMax(max * 1.1);
        Axis xAxis = chartModelOrOrphelin.getAxis(AxisType.X);
        xAxis.setMin(0);
    }

    private void createBarModelOrphelin() {
        barModelOrphelin = initBarModelOrphelin();

        barModelOrphelin.setTitle("Statistique des annees " + premiereAnneee + " et " + deuxiemeAnneee);
        barModelOrphelin.setLegendPosition("ne");
        barModelOrphelin.setShowDatatip(false);
        barModelOrphelin.setShowPointLabels(true);
        Axis xAxis = barModelOrphelin.getAxis(AxisType.X);
        xAxis.setLabel("Année");

        Axis yAxis = barModelOrphelin.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre d'Orphelin");
        yAxis.setMin(0);
        yAxis.setMax(max * 1.1);
    }

    private BarChartModel initBarModelOrphelin() {
        BarChartModel model = new BarChartModel();
        Long[] resultas = ejbFacade.statistiqueOrphelin(premiereAnneee, deuxiemeAnneee, sexe, ageMin);
        max = MathUtil.calculerMax(resultas);
        ChartSeries annee1 = new ChartSeries();
        annee1.setLabel("annee " + premiereAnneee);
        annee1.set(" "+ premiereAnneee, resultas[0]);

        ChartSeries annee2 = new ChartSeries();
        annee2.setLabel("annee " + deuxiemeAnneee);
        annee2.set(" " + deuxiemeAnneee, resultas[1]);

        model.addSeries(annee1);
        model.addSeries(annee2);

        return model;
    }

    //////////////////////// images /////////////////////////
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            images.add("image" + i + ".jpg");
        }
    }

   public boolean compareYearMonthDay(Date dateDerierePunition){
        return DateUtil.compareYearMonthDay(dateDerierePunition, new Date());
    }
    public List<String> getImages() {
        return images;
    }
    /////////////////////////////////////////////////////////

    public int getChoix() {
        return choix;
    }

    public void setChoix(int choix) {
        this.choix = choix;
    }

    
    public int getPremiereAnneee() {
        return premiereAnneee;
    }

    public void setPremiereAnneee(int premiereAnneee) {
        this.premiereAnneee = premiereAnneee;
    }

    public int getDeuxiemeAnneee() {
        return deuxiemeAnneee;
    }

    public void setDeuxiemeAnneee(int deuxiemeAnneee) {
        this.deuxiemeAnneee = deuxiemeAnneee;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public int getTypeChartOrphelin() {
        return typeChartOrphelin;
    }

    public void setTypeChartOrphelin(int typeChartOrphelin) {
        this.typeChartOrphelin = typeChartOrphelin;
    }

    public int getTypeChart() {
        return typeChart;
    }

    public void setTypeChart(int typeChart) {
        this.typeChart = typeChart;
    }

    public LineChartModel getChartModelOrOrphelin() {
        if (chartModelOrOrphelin == null) {
            chartModelOrOrphelin = new LineChartModel();
        }

        return chartModelOrOrphelin;
    }

    public void setChartModelOrOrphelin(LineChartModel chartModelOrOrphelin) {
        this.chartModelOrOrphelin = chartModelOrOrphelin;
    }

    public BarChartModel getBarModelOrphelin() {
        if (barModelOrphelin == null) {
            barModelOrphelin = new BarChartModel();
        }
        return barModelOrphelin;
    }

    public void setBarModelOrphelin(BarChartModel barModelOrphelin) {
        this.barModelOrphelin = barModelOrphelin;
    }

    public LineChartModel getChartModel() {
        if (chartModel == null) {
            chartModel = new LineChartModel();
        }
        return chartModel;
    }

    public void setChartModel(LineChartModel chartModel) {
        this.chartModel = chartModel;
    }

    public BarChartModel getBarModel() {
        if (barModel == null) {
            barModel = new BarChartModel();
        }
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public int getPremiereAnnee() {
        return premiereAnnee;
    }

    public void setPremiereAnnee(int premiereAnnee) {
        this.premiereAnnee = premiereAnnee;
    }

    public int getDeuxiemeAnnee() {
        return deuxiemeAnnee;
    }

    public void setDeuxiemeAnnee(int deuxiemeAnnee) {
        this.deuxiemeAnnee = deuxiemeAnnee;
    }

    public int getNbrOrphelin() {
        return nbrOrphelin;
    }

    public void setNbrOrphelin(int nbrOrphelin) {
        this.nbrOrphelin = nbrOrphelin;
    }

    public int getNbrDossier() {
        return nbrDossier;
    }

    public void setNbrDossier(int nbrDossier) {
        this.nbrDossier = nbrDossier;
    }

    public boolean isPossede() {
        return possede;
    }

    public void setPossede(boolean possede) {
        this.possede = possede;
    }

    public boolean isPartage() {
        return partage;
    }

    public void setPartage(boolean partage) {
        this.partage = partage;
    }

    public boolean isLocation() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }

    public boolean isProchainementPossede() {
        return prochainementPossede;
    }

    public void setProchainementPossede(boolean prochainementPossede) {
        this.prochainementPossede = prochainementPossede;
    }

    public boolean isGage() {
        return gage;
    }

    public void setGage(boolean gage) {
        this.gage = gage;
    }

    public boolean isAutreType() {
        return autreType;
    }

    public void setAutreType(boolean autreType) {
        this.autreType = autreType;
    }

    public Date getDatePriseDossier() {
        return datePriseDossier;
    }

    public void setDatePriseDossier(Date datePriseDossier) {
        this.datePriseDossier = datePriseDossier;
    }

    public int getSswitch() {
        return sswitch;
    }

    public void setSswitch(int sswitch) {
        this.sswitch = sswitch;
    }

    public List<Dossier> getDossierParraines() {
        return dossierParraines;
    }

    public void setDossierParraines(List<Dossier> dossierParraines) {
        this.dossierParraines = dossierParraines;
    }

    public Parrinage getParrainage() {
        if (parrainage == null) {
            parrainage = new Parrinage();
        }
        return parrainage;
    }

    public void setParrainage(Parrinage parrainage) {
        this.parrainage = parrainage;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public int getNbrMin() {
        return nbrMin;
    }

    public void setNbrMin(int nbrMin) {
        this.nbrMin = nbrMin;
    }

    public int getNbrMax() {
        return nbrMax;
    }

    public void setNbrMax(int nbrMax) {
        this.nbrMax = nbrMax;
    }

    public String getRegionn() {
        return regionn;
    }

    public void setRegionn(String regionn) {
        this.regionn = regionn;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDateMin() {
        return dateMin;
    }

    public void setDateMin(Date dateMin) {
        this.dateMin = dateMin;
    }

    public Date getDateMax() {
        return dateMax;
    }

    public void setDateMax(Date dateMax) {
        this.dateMax = dateMax;
    }

    public List<Dossier> getDossierNonClasse() {
        return dossierNonClasse;
    }

    public void setDossierNonClasse(List<Dossier> dossierNonClasse) {
        this.dossierNonClasse = dossierNonClasse;
    }

    public List<SousResponsableRegion> getSousResponsableRegions() {
        return sousResponsableRegions;
    }

    public void setSousResponsableRegions(List<SousResponsableRegion> sousResponsableRegions) {
        this.sousResponsableRegions = sousResponsableRegions;
    }

    public List<SousRegion> getSousRegions() {
        return sousRegions;
    }

    public void setSousRegions(List<SousRegion> sousRegions) {
        this.sousRegions = sousRegions;
    }

    public SousRegion getSousRegion() {
        if (sousRegion == null) {
            sousRegion = new SousRegion();
        }
        return sousRegion;
    }

    public void setSousRegion(SousRegion sousRegion) {
        this.sousRegion = sousRegion;
    }

    public SousResponsableRegion getSousResponsableRegion() {
        if (sousResponsableRegion == null) {
            sousResponsableRegion = new SousResponsableRegion();
        }
        return sousResponsableRegion;
    }

    public void setSousResponsableRegion(SousResponsableRegion sousResponsableRegion) {
        this.sousResponsableRegion = sousResponsableRegion;
    }

    public ResponsableRegion getResponsableRegion() {
        if (responsableRegion == null) {
            responsableRegion = new ResponsableRegion();
        }
        return responsableRegion;
    }

    public void setResponsableRegion(ResponsableRegion responsableRegion) {
        this.responsableRegion = responsableRegion;
    }

    public Region getRegion() {
        if (region == null) {
            region = new Region();
        }
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<AssistanteSociale> getSociales() {
        return assistanteSocialeFacade.findAll();
    }

    public void setSociales(List<AssistanteSociale> sociales) {
        this.sociales = sociales;
    }

    public Pere getPere() {
        if (pere == null) {
            pere = new Pere();
        }
        return pere;
    }

    public void setPere(Pere pere) {
        this.pere = pere;
    }

    public ResponsableFamille getResponsableFamille() {
        if (responsableFamille == null) {
            responsableFamille = new ResponsableFamille();
        }
        return responsableFamille;
    }

    public void setResponsableFamille(ResponsableFamille responsableFamille) {
        this.responsableFamille = responsableFamille;
    }

    public AssistanteSociale getAssistanteSociale1() {
        if (assistanteSociale1 == null) {
            assistanteSociale1 = new AssistanteSociale();
        }
        return assistanteSociale1;
    }

    public void setAssistanteSociale1(AssistanteSociale assistanteSociale1) {
        this.assistanteSociale1 = assistanteSociale1;
    }

    public AssistanteSociale getAssistanteSociale2() {
        if (assistanteSociale2 == null) {
            assistanteSociale2 = new AssistanteSociale();
        }
        return assistanteSociale2;
    }

    public void setAssistanteSociale2(AssistanteSociale assistanteSociale2) {
        this.assistanteSociale2 = assistanteSociale2;
    }

    public EtatEthique getEtatEthique() {
        if (etatEthique == null) {
            etatEthique = new EtatEthique();
        }
        return etatEthique;
    }

    public void setEtatEthique(EtatEthique etatEthique) {
        this.etatEthique = etatEthique;
    }

    public Logement getLogement() {
        if (logement == null) {
            logement = new Logement();
        }
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public List<Orphelin> getAllOrphelins() {

        if (allOrphelins == null) {
            allOrphelins = new ArrayList();
        }
        return allOrphelins;
    }

    public void setAllOrphelins(List<Orphelin> allOrphelins) {
        this.allOrphelins = allOrphelins;
    }

    public EtatSanteOrphelin getEtatSanteOrphelinF() {
        if (etatSanteOrphelinF == null) {
            etatSanteOrphelinF = new EtatSanteOrphelin();
        }
        return etatSanteOrphelinF;
    }

    public void setEtatSanteOrphelinF(EtatSanteOrphelin etatSanteOrphelinF) {
        this.etatSanteOrphelinF = etatSanteOrphelinF;
    }

    public EtatSanteOrphelin getEtatSanteOrphelinNF() {
        if (etatSanteOrphelinNF == null) {
            etatSanteOrphelinNF = new EtatSanteOrphelin();
        }
        return etatSanteOrphelinNF;
    }

    public void setEtatSanteOrphelinNF(EtatSanteOrphelin etatSanteOrphelinNF) {
        this.etatSanteOrphelinNF = etatSanteOrphelinNF;
    }

    public List<EtatSanteOrphelin> getEtatSanteOrphelinsF() {
        if (etatSanteOrphelinsF == null) {
            etatSanteOrphelinsF = new ArrayList();
        }
        return etatSanteOrphelinsF;
    }

    public void setEtatSanteOrphelinsF(List<EtatSanteOrphelin> etatSanteOrphelinsF) {
        this.etatSanteOrphelinsF = etatSanteOrphelinsF;
    }

    public List<EtatSanteOrphelin> getEtatSanteOrphelinsNF() {
        if (etatSanteOrphelinsNF == null) {
            etatSanteOrphelinsNF = new ArrayList();
        }
        return etatSanteOrphelinsNF;
    }

    public void setEtatSanteOrphelinsNF(List<EtatSanteOrphelin> etatSanteOrphelinsNF) {
        this.etatSanteOrphelinsNF = etatSanteOrphelinsNF;
    }

    public List<Orphelin> getOrphelinsNF() {
        if (orphelinsNF == null) {
            orphelinsNF = new ArrayList();
        }
        return orphelinsNF;
    }

    public void setOrphelinsNF(List<Orphelin> orphelinsNF) {
        this.orphelinsNF = orphelinsNF;
    }

    public List<Orphelin> getOrphelinsF() {
        if (orphelinsF == null) {
            orphelinsF = new ArrayList();
        }
        return orphelinsF;
    }

    public void setOrphelinsF(List<Orphelin> orphelinsF) {
        this.orphelinsF = orphelinsF;
    }

    public Orphelin getOrphelinF() {
        if (orphelinF == null) {
            orphelinF = new Orphelin();
        }
        return orphelinF;
    }

    public void setOrphelinF(Orphelin orphelinF) {
        this.orphelinF = orphelinF;
    }

    public Orphelin getOrphelinNF() {
        if (orphelinNF == null) {
            orphelinNF = new Orphelin();
        }
        return orphelinNF;
    }

    public void setOrphelinNF(Orphelin orphelinNF) {
        this.orphelinNF = orphelinNF;
    }

    public List<Orphelin> getOrphelins() {
        if (orphelins == null) {
            orphelins = new ArrayList();
        }
        return orphelins;
    }

    public void setOrphelins(List<Orphelin> orphelins) {
        this.orphelins = orphelins;
    }

    public Orphelin getOrphelin() {
        if (orphelin == null) {
            orphelin = new Orphelin();
        }
        return orphelin;
    }

    public void setOrphelin(Orphelin orphelin) {
        this.orphelin = orphelin;
    }

    public Aide getAide() {
        if (aide == null) {
            aide = new Aide();
        }
        return aide;
    }

    public void setAide(Aide aide) {
        this.aide = aide;
    }

    public EtatSanteMere getEtatSanteMere() {
        if (etatSanteMere == null) {
            etatSanteMere = new EtatSanteMere();
        }
        return etatSanteMere;
    }

    public void setEtatSanteMere(EtatSanteMere etatSanteMere) {
        this.etatSanteMere = etatSanteMere;
    }

    public Mere getMere() {
        if (mere == null) {
            mere = new Mere();
        }
        return mere;
    }

    public void setMere(Mere mere) {
        this.mere = mere;
    }

    public EtatSanteOrphelin getEtatSanteOrphelin() {
        if (etatSanteOrphelin == null) {
            etatSanteOrphelin = new EtatSanteOrphelin();
        }
        return etatSanteOrphelin;
    }

    public void setEtatSanteOrphelin(EtatSanteOrphelin etatSanteOrphelin) {
        this.etatSanteOrphelin = etatSanteOrphelin;
    }

    public EtatPedagogiqueItem getEtatPedagogiqueItem() {
        if (etatPedagogiqueItem == null) {
            etatPedagogiqueItem = new EtatPedagogiqueItem();
        }
        return etatPedagogiqueItem;
    }

    public void setEtatPedagogiqueItem(EtatPedagogiqueItem etatPedagogiqueItem) {
        this.etatPedagogiqueItem = etatPedagogiqueItem;
    }

    public List<EtatPedagogiqueItem> getEtatPedagogiqueItems() {
        if (etatPedagogiqueItems == null) {
            etatPedagogiqueItems = new ArrayList();
        }
        return etatPedagogiqueItems;
    }

    public void setEtatPedagogiqueItems(List<EtatPedagogiqueItem> etatPedagogiqueItems) {
        this.etatPedagogiqueItems = etatPedagogiqueItems;
    }

    public AideItem getAideItem() {
        if (aideItem == null) {
            aideItem = new AideItem();
        }
        return aideItem;
    }

    public void setAideItem(AideItem aideItem) {
        this.aideItem = aideItem;
    }

    public List<AideItem> getAideItems() {
        if (aideItems == null) {
            aideItems = new ArrayList();
        }
        return aideItems;
    }

    public void setAideItems(List<AideItem> aideItems) {
        this.aideItems = aideItems;
    }

    public Activite getActivite() {
        if (activite == null) {
            activite = new Activite();
        }
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public List<ActiviteItem> getActiviteItems() {
        if (activiteItems == null) {
            activiteItems = new ArrayList();
        }
        return activiteItems;
    }

    public void setActiviteItems(List<ActiviteItem> activiteItems) {
        this.activiteItems = activiteItems;
    }

    public ActiviteItem getActiviteItem() {
        if (activiteItem == null) {
            activiteItem = new ActiviteItem();
        }
        return activiteItem;
    }

    public void setActiviteItem(ActiviteItem activiteItem) {
        this.activiteItem = activiteItem;
    }

    public List<EtatSanteOrphelin> getEtatSanteOrphelins() {
        if (etatSanteOrphelins == null) {
            etatSanteOrphelins = new ArrayList();
        }
        return etatSanteOrphelins;
    }

    public void setEtatSanteOrphelins(List<EtatSanteOrphelin> etatSanteOrphelins) {
        this.etatSanteOrphelins = etatSanteOrphelins;
    }

    public List<EtatSanteMere> getEtatSanteMeres() {
        if (etatSanteMeres == null) {
            etatSanteMeres = new ArrayList();
        }
        return etatSanteMeres;
    }

    public void setEtatSanteMeres(List<EtatSanteMere> etatSanteMeres) {
        this.etatSanteMeres = etatSanteMeres;
    }

    public Materiel getMateriel() {
        if (materiel == null) {
            materiel = new Materiel();
        }
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public List<Materiel> getHasnaa() {
        if (Hasnaa == null) {
            Hasnaa = new ArrayList();
        }
        return Hasnaa;
    }

    public void setHasnaa(List<Materiel> Hasnaa) {
        this.Hasnaa = Hasnaa;
    }

    public List<Membre> getMembres() {
        //System.out.println("membres"+membres);
        if (membres == null) {
            //System.out.println("hana instanciate memebres");
            membres = new ArrayList<>();
        }
        return membres;
    }

    public Membre getMembre() {
        if (membre == null) {
            membre = new Membre();
        }
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();

    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Dossier getSelected() {
        if (selected == null) {
            selected = new Dossier();
        }
        return selected;
    }

    public void setSelected(Dossier selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DossierFacade getFacade() {
        return ejbFacade;
    }

    public Membre getSelectedMembre() {
        if (selectedMembre == null) {
            selectedMembre = new Membre();
        }
        return selectedMembre;
    }

    public void setSelectedMembre(Membre selectedMembre) {
        this.selectedMembre = selectedMembre;
    }

    public Dossier prepareCreate() {
        selected = new Dossier();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DossierCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DossierUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DossierDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Dossier> getItems() {
        if (items == null) {
            items = getFacade().allDossiersEnAttente();
        }
        return items;
    }

    public List<String> getOrphelinValues() {
        if (orphelinValues == null) {
            orphelinValues = new ArrayList();
        }
        return orphelinValues;
    }

    public void setOrphelinValues(List<String> orphelinValues) {
        this.orphelinValues = orphelinValues;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Dossier getDossier(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Dossier> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Dossier> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Dossier.class)
    public static class DossierControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DossierController controller = (DossierController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "dossierController");
            return controller.getDossier(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Dossier) {
                Dossier o = (Dossier) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Dossier.class.getName()});
                return null;
            }
        }

    }

}
