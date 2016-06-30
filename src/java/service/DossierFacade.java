
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Activite;
import bean.ActiviteItem;
import bean.Aide;
import bean.AideItem;
import bean.AssistanteSociale;

import bean.Dossier;
import bean.EtatEthique;

import bean.EtatPedagogiqueItem;

import bean.EtatSanteMere;
import bean.EtatSanteOrphelin;
import bean.Logement;
import bean.Materiel;
import bean.Membre;
import bean.Mere;
import bean.Orphelin;
import bean.Parrain;
import bean.Parrinage;
import bean.Pere;
import bean.Punition;
import bean.Region;
import bean.ResponsableFamille;
import bean.ResponsableRegion;
import bean.SousRegion;
import bean.SousResponsableRegion;
import bean.Utilisateur;
import controler.util.DateUtil;
import java.io.IOException;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.sf.jasperreports.engine.JRException;
import pdfUtil.PdfUtil;

/**
 *
 * @author Utilisateur
 */
@Stateless
public class DossierFacade extends AbstractFacade<Dossier> {

    @EJB
    private MaterielFacade materielFacade;
    @EJB
    private MembreFacade membreFacade;
    @EJB
    private OrphelinFacade orphelinFacade;
    @EJB
    private AideItemFacade aideItemFacade;
    @EJB
    private AideFacade aideFacade;
    @EJB
    private UtilisateurFacade utilisateurFacade;
    @EJB
    private MereFacade mereFacade;

    @EJB
    private ResponsableFamilleFacade responsableFamilleFacade;

    @EJB
    private PereFacade pereFacade;
    @EJB
    private LogementFacade logementFacade;
    @EJB
    private AssistanteSocialeFacade assistanteSocialeFacade;
    @EJB
    private EtatEthiqueFacade etatEthiqueFacade;
    @EJB
    private ActiviteItemFacade activiteItemFacade;
    @EJB
    private ActiviteFacade activiteFacade;
    @EJB
    private EtatSanteOrphelinFacade etatSanteOrphelinFacade;

    @EJB
    private EtatSanteMereFacade etatSanteMereFacade;

    @EJB
    private EtatPedagogiqueItemFacade etatPedagogiqueItemFacade;

    @EJB
    private ParrinageFacade parrinageFacade;
    @EJB
    private ParrainFacade parrainFacade;
    @EJB
    private RegionFacade regionFacade;
    @EJB
    private SousRegionFacade sousRegionFacade;
    @EJB
    private ResponsableRegionFacade responsableRegionFacade;
    @EJB
    private PunitionFacade punitionFacade;

    @PersistenceContext(unitName = "GestionSocialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DossierFacade() {
        super(Dossier.class);
    }

    public Membre clonnedMembre(Membre membre, int id) {
        Membre item = new Membre();
        item.setId(new Long(id + ""));
        item.setNom(membre.getNom());
        item.setPrenom(membre.getPrenom());
        item.setCommentaire(membre.getCommentaire());
        item.setDateNaissance(membre.getDateNaissance());
        item.setDepenses(membre.getDepenses());
        item.setEcole(membre.getEcole());
        item.setMoyenne(membre.getMoyenne());
        item.setNiveauScolaire(membre.getNiveauScolaire());
        item.setProfession(membre.getProfession());
        item.setRecruteur(membre.getRecruteur());
        item.setRelationOrphelin(membre.getRelationOrphelin());
        item.setSalaire(membre.getSalaire());
        item.setTypeMetier(membre.getTypeMetier());
        System.out.println("ha l'item ====>" + item);
        return item;
    }

    public Orphelin cloneeee(Orphelin orphelin, int id) {
        Orphelin item = new Orphelin();
        System.out.println("haa l element li bite n clonner ==> " + orphelin.getNom());
        item.setId(new Long(id + ""));
        item.setNom(orphelin.getNom());
        item.setDateNaissance(orphelin.getDateNaissance());
        item.setNiveauScolaire(orphelin.getNiveauScolaire());
        item.setEcole(orphelin.getEcole());
        item.setNbrAnneeRedouble(orphelin.getNbrAnneeRedouble());
        item.setRaisonRedoublement(orphelin.getRaisonRedoublement());
        item.setAideScolaire(orphelin.getAideScolaire());
        item.setBlemeScolaire(orphelin.getBlemeScolaire());
        item.setMatiere(orphelin.getMatiere());
        item.setFuturPerspective(orphelin.getFuturPerspective());
        item.setPrenom(orphelin.getPrenom());
        item.setDateDiscon(orphelin.getDateDiscon());
        item.setRaisondiscontinuite(orphelin.getRaisondiscontinuite());
        item.setCapacite(orphelin.getCapacite());
        item.setRaisonNonTravail(orphelin.getRaisonNonTravail());
        item.setDureeChomage(orphelin.getDureeChomage());
        item.setFuturPerspective(orphelin.getFuturPerspective());
        item.setRaisonDisconScolaire(orphelin.getRaisonDisconScolaire());
        item.setEtablissement(orphelin.getEtablissement());
        item.setDureeFormation(orphelin.getDureeFormation());
        item.setTypeFormation(orphelin.getTypeFormation());
        item.setBlemeFormation(orphelin.getBlemeFormation());
        item.setFuturPerspective(orphelin.getFuturPerspective());
        item.setDateDebutFormation(orphelin.getDateDebutFormation());
        item.setType(orphelin.getType());
        item.setSexe(orphelin.getSexe());

        return item;

    }

    public Materiel cloneMateriel(Materiel materiel, int id) {
        Materiel item = new Materiel();
        item.setId(new Long(id + ""));
        item.setEtatMateriel(materiel.getEtatMateriel());
        item.setLibelleMateriel(materiel.getLibelleMateriel());
        return item;
    }

    public EtatSanteOrphelin cloneEtatSanteOrphelin(EtatSanteOrphelin etatSanteOrphelin, int id,
            int id2, Orphelin orphelin) {
        EtatSanteOrphelin item = new EtatSanteOrphelin();
        item.setId(new Long(id + ""));

        item.setOrphelin(cloneeee(orphelin, id2));
        item.setBesoin(etatSanteOrphelin.getBesoin());
        item.setDepense(etatSanteOrphelin.getDepense());
        item.setEtatHandicape(etatSanteOrphelin.getEtatHandicape());
        item.setMaladie(etatSanteOrphelin.getMaladie());
        item.setSuivieHandicape(etatSanteOrphelin.getSuivieHandicape());
        item.setSuivieMaladieChronique(etatSanteOrphelin.getSuivieMaladieChronique());
        item.setSuivieMaladieRepetitif(etatSanteOrphelin.getSuivieMaladieRepetitif());
        item.setTypeHandicape(etatSanteOrphelin.getTypeHandicape());
        return item;
    }

    public EtatSanteMere cloneEtatSanteMere(EtatSanteMere etatSanteMere, Mere mere) {
        EtatSanteMere item = new EtatSanteMere();
        item.setMere(cloneMere(mere));
        item.setBesoin(etatSanteMere.getBesoin());
        item.setDepense(etatSanteMere.getDepense());
        item.setEtatHandicape(etatSanteMere.getEtatHandicape());
        item.setMaladie(etatSanteMere.getMaladie());
        item.setSuivieHandicape(etatSanteMere.getSuivieHandicape());
        item.setSuivieMaladieChronique(etatSanteMere.getSuivieMaladieChronique());
        item.setSuivieMaladieRepetitif(etatSanteMere.getSuivieMaladieRepetitif());
        item.setTypeHandicape(etatSanteMere.getTypeHandicape());
        return item;
    }

    public Mere cloneMere(Mere mere) {
        Mere item = new Mere();
        item.setAdresse(mere.getAdresse());
        item.setDateDeces(mere.getDateDeces());
        item.setNom(mere.getNom());
        item.setPrenom(mere.getPrenom());
        item.setRaisonDeces(mere.getRaisonDeces());
        return item;
    }

    public ActiviteItem cloneActivItem(ActiviteItem activiteItem, Membre membre, int id, int id2) {
        ActiviteItem item = new ActiviteItem();
        item.setId(new Long(id2 + ""));
        item.setMontantMonsuel(activiteItem.getMontantMonsuel());
        item.setCapacite(activiteItem.getCapacite());
        item.setDureeTravail(activiteItem.getDureeTravail());
        item.setMembre(clonnedMembre(membre, id2));
        System.out.println("ha le membre =====>" + membre);
        item.setProfession(activiteItem.getProfession());
        item.setRecruteur(activiteItem.getRecruteur());
        item.setWeekend(activiteItem.getWeekend());

        return item;
    }

    public EtatEthique cloneEtatEthique(EtatEthique etatEthique) {
        EtatEthique item = new EtatEthique();
        item.setSoutienScolaire(etatEthique.getSoutienScolaire());
        item.setNourritureOrphelin(etatEthique.getNourritureOrphelin());
        item.setPropreteHabille(etatEthique.getPropreteHabille());
        item.setPropreteLogement(etatEthique.getPropreteLogement());
        item.setRelationFamille(etatEthique.getRelationFamille());
        item.setRelationVoision(etatEthique.getRelationVoision());
        item.setHabillement(etatEthique.getHabillement());
        item.setInteretScolaire(etatEthique.getInteretScolaire());
        item.setCommentaire(etatEthique.getCommentaire());

        return item;
    }

    public EtatPedagogiqueItem cloneEtatPedagogiqueItem(EtatPedagogiqueItem etatPedagogiqueItem,
            int id, int id2, Orphelin orphelin) {
        EtatPedagogiqueItem item = new EtatPedagogiqueItem();
        item.setId(new Long(id + ""));
        item.setOrphelin(cloneeee(orphelin, id2));
        item.setCommentaire(etatPedagogiqueItem.getCommentaire());
        item.setHabillement(etatPedagogiqueItem.getHabillement());
        item.setInteretScolaire(etatPedagogiqueItem.getInteretScolaire());
        item.setMoeur(etatPedagogiqueItem.getMoeur());
        item.setRelationFrere(etatPedagogiqueItem.getRelationFrere());
        item.setRelationMere(etatPedagogiqueItem.getRelationMere());
        item.setRelationVoision(etatPedagogiqueItem.getRelationVoision());
        return item;
    }

    public AideItem cloneAideItem(AideItem aideItem, int id) {
        AideItem item = new AideItem();
        item.setId(new Long(id + ""));
        item.setCommentaire(aideItem.getCommentaire());
        item.setDuree(aideItem.getDuree());
        item.setMontantMensuelle(aideItem.getMontantMensuelle());
        item.setQuantite(aideItem.getQuantite());
        item.setRaisonAide(aideItem.getRaisonAide());
        item.setRelation(aideItem.getRelation());
        item.setRessource(aideItem.getRessource());
        item.setType(aideItem.getType());
        return item;
    }

    public Long generatteId() {
        Long maxId = (Long) em.createQuery("SELECT MAX(d.id) FROM Dossier d").getSingleResult();
        return (maxId == null ? 1l : maxId + 1);
    }

    public Long generatteActiviteId() {
        Long maxId = (Long) em.createQuery("SELECT MAX(a.id) FROM Activite a").getSingleResult();
        return (maxId == null ? 1l : maxId);
    }

    public Long generatteEtatPedagigiqueId() {
        Long maxId = (Long) em.createQuery("SELECT MAX(a.id) FROM EtatPedagogiqueItem a").getSingleResult();
        return (maxId == null ? 1l : maxId + 1);
    }

    public Long generatteOrphelinId() {
        Long maxId = (Long) em.createQuery("SELECT MAX(o.id) FROM Orphelin o").getSingleResult();
        return (maxId == null ? 1l : maxId + 1);
    }

    public int createMateriel(List<Materiel> materiels, Dossier dossier) {
        for (Materiel materiel : materiels) {
            materiel.setDossier(dossier);
            materielFacade.create(materiel);
        }
        return 1;
    }

    public int createMembre(List<Membre> membres, Dossier dossier) {
        for (Membre membre : membres) {
            membre.setDossier(dossier);
            membreFacade.create(membre);
        }
        return 1;
    }

    public int createOrphelin(List<Orphelin> orphelins, Dossier dossier) {
        for (Orphelin orphelin : orphelins) {
            orphelin.setId(generatteOrphelinId());
            orphelin.setDossier(dossier);
            orphelin.setAge(calculAge(orphelin));
            System.out.println(" voila date naissance " + orphelin.getDateNaissance()
                    + "------- et l'age===>" + orphelin.getAge());

            orphelinFacade.create(orphelin);
        }

        return 1;
    }

    public int createAide(List<AideItem> AideItems, Aide aide, Dossier dossier) {

        aide.setDossier(dossier);
        aideFacade.create(aide);
        for (AideItem aideItem : AideItems) {
            aideItem.setAide(aide);
            aideItemFacade.create(aideItem);
        }

        return 1;
    }

    public int createActivite(List<ActiviteItem> ActiviteItems, Activite activite, Dossier dossier, Membre membre) {
        activite.setDossier(dossier);
        activite.setId(generatteActiviteId());
        activiteFacade.create(activite);

        for (ActiviteItem activiteItem : ActiviteItems) {
            activiteItem.setActivite(activite);
            activiteItem.setMembre(membre);
            activiteItemFacade.create(activiteItem);
        }

        return 1;
    }

    public int createEtatSanteOrphelin(List<EtatSanteOrphelin> EtatSanteOrphelins,
            Dossier dossier, List<Orphelin> orphelins) {
        for (EtatSanteOrphelin etatSanteOrphelin : EtatSanteOrphelins) {
            etatSanteOrphelin.setDossier(dossier);
            etatSanteOrphelin.setOrphelin(findSamePrenom(orphelins, etatSanteOrphelin.getOrphelin().getPrenom()));
            etatSanteOrphelinFacade.create(etatSanteOrphelin);
        }

        return 1;
    }

    public int createEtatPedagogique(List<EtatPedagogiqueItem> EtatPedagogiqueItems, Dossier dossier, List<Orphelin> orphelins) {
        for (EtatPedagogiqueItem etatPedagogiqueItem : EtatPedagogiqueItems) {
            System.out.println("haaa mon orphelin ==>  " + etatPedagogiqueItem.getOrphelin().getPrenom());
            etatPedagogiqueItem.setOrphelin(findSamePrenom(orphelins, etatPedagogiqueItem.getOrphelin().getPrenom()));
            etatPedagogiqueItem.setDossier(dossier);
            etatPedagogiqueItemFacade.create(etatPedagogiqueItem);
        }

        return 1;
    }

    public int createEtatEthique(EtatEthique etatEthique, Mere mere) {
        etatEthique.setMere(mere);
        etatEthiqueFacade.create(etatEthique);
        return 1;
    }

    public int createEtatSanteMere(EtatSanteMere etatSanteMere, Mere mere) {
        etatSanteMere.setMere(mere);
        etatSanteMereFacade.create(etatSanteMere);
        return 1;
    }

    public Orphelin findSamePrenom(List<Orphelin> orphelins, String prenom) {

        for (Orphelin orphelin : orphelins) {
            if (orphelin.getPrenom().equals(prenom)) {
                return orphelin;
            }
        }
        return null;
    }
////////////////////////////////////////////

    public void etatLogement(Logement logement, boolean possede,
            boolean partage, boolean location, boolean gage,
            boolean prochainementPossede, boolean autreType) {
        if (possede == true) {
            logement.setTypePossession(1);
        } else if (partage == true) {
            logement.setTypePossession(2);
        } else if (location == true) {
            logement.setTypePossession(3);
        } else if (gage == true) {
            logement.setTypePossession(4);
        } else if (prochainementPossede == true) {
            logement.setTypePossession(5);
        } else if (autreType == true) {
            logement.setTypePossession(6);
        }

    }
// ///////////////////////////////////////////////////////////////////////////////////  

    public int editerDossier(Dossier dossier, Mere mere,
            Pere pere, ResponsableFamille responsableFamille,
            Logement logement, List<Materiel> materiels,
            List<Membre> membres,
            List<AideItem> AideItems,
            List<ActiviteItem> ActiviteItems, List<EtatSanteOrphelin> EtatSanteOrphelins,
            List<Orphelin> orphelinsF,
            List<EtatPedagogiqueItem> EtatPedagogiqueItems, Aide aide,
            Activite activite, EtatSanteMere etatSanteMere,
            AssistanteSociale assistanteSociale1,
            AssistanteSociale assistanteSociale2, EtatEthique etatEthique,
            Membre membre, ResponsableRegion responsableRegion, Region region,
            boolean possede,
            boolean partage, boolean location, boolean gage,
            boolean prochainementPossede, boolean autreType) {

        createMembre(membres, dossier);
        createActivite(ActiviteItems, activite, dossier, membre);
        dossier.setActivite(activite);

        etatEthique.setDossier(dossier);
        createEtatEthique(etatEthique, mere);
        dossier.setEtatEthique(etatEthique);

        logement.setDossier(dossier);
        etatLogement(logement, possede, partage, location, gage, prochainementPossede, autreType);
        logementFacade.create(logement);
        dossier.setLogement(logement);

        createAide(AideItems, aide, dossier);
        dossier.setAide(aide);

        mere.setDossier(dossier);
        mereFacade.create(mere);
        dossier.setMere(mere);

        pere.setDossier(dossier);
        pereFacade.create(pere);
        dossier.setPere(pere);

        etatSanteMere.setDossier(dossier);
        createEtatSanteMere(etatSanteMere, mere);
        dossier.setEtatSanteMere(etatSanteMere);

        createOrphelin(orphelinsF, dossier);
        createEtatPedagogique(EtatPedagogiqueItems, dossier, orphelinsF);
        createEtatSanteOrphelin(EtatSanteOrphelins, dossier, orphelinsF);

        createMateriel(materiels, dossier);

        dossier.setIndice(calculIndice(orphelinsF, membres, activite, aide));
        System.out.println("haaa l indice ==> " + dossier.getIndice());
        etatDossier(dossier);

        dossier.setNbrOrphelin(nbrOrphelin(orphelinsF));
        dossier.setNbrMembre(nbrMembre(membres));
        edit(dossier);

        return 1;

    }

    public int creationDossier(Dossier dossier,
            ResponsableFamille responsableFamille,
            AssistanteSociale assistanteSociale1,
            AssistanteSociale assistanteSociale2,
            ResponsableRegion responsableRegion,
            Region region) {
        dossier.setMere(null);
        dossier.setActivite(null);
        dossier.setAide(null);
        dossier.setPere(null);
        dossier.setLogement(null);
        dossier.setRamed(null);
        dossier.setEtatEthique(null);
        dossier.setEtatSanteMere(null);
        responsableFamille.setDossier(dossier);
        responsableFamilleFacade.create(responsableFamille);
        dossier.setResponsableFamille(responsableFamille);
        dossier.setResponsableRegion(responsableRegion);
        dossier.setRegion(region);
        dossier.setAssistanteSociale1(assistanteSociale1);
        dossier.setAssistanteSociale2(assistanteSociale2);
        dossier.setEtat(-1);// Dossiers Non Classés
        dossier.setAnnee(convertDate(dossier));
        create(dossier);

        return 1;

    }

    public List<AssistanteSociale> allAssistante() {
        List<AssistanteSociale> sociales = assistanteSocialeFacade.findAll();
        return sociales;
    }
/////////////////////////////////////////////////////////

    public List<SousRegion> allSousRegionsByRegion(Region region) {
        String requette = "Select s From SousRegion s where s.region.nomRegion like '%" + region.getNomRegion() + "%'";
        System.out.println(" voila sous Region ======>" + em.createQuery(requette).getResultList());
        return em.createQuery(requette).getResultList();

    }

    public List<SousResponsableRegion> allSousResponsableByRespo(ResponsableRegion responsableRegion) {
        String requette = "Select r From SousResponsableRegion r where r.responsableRegion.nom like "
                + "'%" + responsableRegion.getNom() + "%'";
        return em.createQuery(requette).getResultList();
    }
//////////////////////////////////////////////////////////////

    public int calculAge(Orphelin orphelin) {

        Date d = new Date();
        int age = 0;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String dateNaiss = format.format(orphelin.getDateNaissance());
        String datesys = format.format(d.getDate());

        try {
            java.util.Date date1 = format.parse(datesys);
            java.util.Date date2 = format.parse(dateNaiss);
            System.out.println(" la date de systeme ====>" + date1.getYear());
            System.out.println("la date d'orphelin =====>" + date2.getYear());
            age = (int) (((date1.getYear() + 1946) - (date2.getYear() + 1900)));

        } catch (ParseException ex) {
            Logger.getLogger(DossierFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return age;

    }

    public int convertDate(Dossier dossier) {
        int annee = 0;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String dateDossier = format.format(dossier.getDateDossier());

        try {
            java.util.Date date1 = format.parse(dateDossier);
            System.out.println(" la date de creation Dossier ====>" + date1.getYear());

            annee = (date1.getYear() + 1900);

        } catch (ParseException ex) {
            Logger.getLogger(DossierFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return annee;

    }

    public int nbrOrphelin(List<Orphelin> orphelins) {
        int i = 0;
        for (int j = 0; j < orphelins.size(); j++) {
            Orphelin get = orphelins.get(j);
        }
        i = orphelins.size();
        System.out.println(" ha le nombre des orphelins i =====>" + i);
        return i;
    }

    public int nbrMembre(List<Membre> membres) {
        int i = 0;
        double montantDepense = 0;
        for (int j = 0; j < membres.size(); j++) {
            Membre membre = membres.get(j);

        }
        i = membres.size();
        //System.out.println(" ha le nombre des Membres ====>" + i);
        return i;
    }

    public double MonDepenseMembre(List<Membre> membres) {
        double montantDepense = 0;
        for (int j = 0; j < membres.size(); j++) {
            Membre membre = membres.get(j);
            montantDepense += membre.getDepenses();
        }
        //System.out.println(" ha le montant Depense ==========>" + montantDepense);
        return montantDepense;
    }

    public float calculIndice(List<Orphelin> orphelins, List<Membre> membres, Activite activite, Aide aide) {
        int nbrMembre = 0, nbrOrphelin = 0;
        double montanDepense = 0;
        float indice = 0;
        nbrMembre = nbrMembre(membres);
        montanDepense = MonDepenseMembre(membres);
        nbrOrphelin = nbrOrphelin(orphelins);

        indice = (float) (((activite.getMontantTotal() + aide.getMontant()) - montanDepense) / (nbrMembre + nbrOrphelin));
        //System.out.println("ha l'indice de dossier======>" + indice);
        return indice;
    }

    public void etatDossier(Dossier dossier) {
        System.out.println(" voila l'indice inferieur  " + dossier.getIndice());

        float indice = dossier.getIndice();
        if (0 < indice && indice < 250) {
            dossier.setEtat(-2);// en attente

        } else if (indice < 600) {
            dossier.setEtat(-3);// saisonnier

        } else if (indice > 600) {
            dossier.setEtat(-4);// moral

        }
        System.out.println(" voila l'etat  " + dossier.getEtat());
    }
    ///////////////////////////////////les recherches/////////////

    public List<Dossier> dossierNonClasse(Dossier dossier, Date dateMin,
            Date dateMax
    ) {
        String requette = " select d from Dossier d where 1=1 ";

        if (dossier.getNumero() != null && !dossier.getNumero().equals(" ")) {
            requette += " and d.etat= -1 and d.numero Like '%" + dossier.getNumero() + "%'";
        }
        if (dossier.getResponsableFamille().getId() != null && !dossier.getResponsableFamille().getId().equals(" ")) {

            requette += " and d.etat= -1 and d.responsableFamille.id Like '%" + dossier.getResponsableFamille().getId() + "%'";
        }
        if (dossier.getNomFamille() != null && !dossier.getNomFamille().equals(" ")) {
            requette += " and d.etat= -1 and d.nomFamille Like '%" + dossier.getNomFamille() + "%'";
        }
        if (dateMax != null) {
            requette += " and d.etat= -1 and d.dateDossier <= '" + DateUtil.getSqlDate(dateMax) + "' ";
        }
        if (dateMin != null) {
            requette += " and d.etat= -1 and d.dateDossier >= '" + DateUtil.getSqlDate(dateMin) + "' ";
        }

        List<Dossier> dossiersNonClasse = em.createQuery(requette).getResultList();

        return dossiersNonClasse;

    }

    public List<Dossier> allDossiersNonClass() {
        String requette = "Select d From Dossier d where d.etat=-1 ";
        return em.createQuery(requette).getResultList();

    }

    public List<Dossier> allDossiersEnAttente() {
        String requette = "Select d From Dossier d where d.etat=-2 ";
        return em.createQuery(requette).getResultList();

    }

    //////////////////////////////////////////////////////////////
    /////RECHERCHE///////
    public List<Dossier> trouver1(String nomRegion, String sexe, Integer type, Integer ageMin, Integer ageMax, Integer nbrMin, Integer nbrMax) {

        String requette = ("Select dossier from Dossier dossier ,Orphelin o where  dossier.id =o.dossier.id");

        if (nomRegion != null && !nomRegion.equals(" ")) {

            requette += " And dossier.etat = -2 And dossier.region.nomRegion Like '%" + nomRegion + "%'";
        }
        if (nbrMin != null && nbrMin != 0) {
            requette += " And dossier.etat = -2 and dossier.nbrOrphelin >= " + nbrMin;
        }
        if (nbrMax != null && nbrMax != 0) {
            requette += " And dossier.etat = -2 and dossier.nbrOrphelin <= " + nbrMax;
        }

        if (ageMin != 0) {
            requette += (" and o.age >= " + ageMin);
        }
        if (ageMin != 0) {
            requette += (" and o.age <= " + ageMax);
        }

        if (sexe != null && !sexe.equals(" ")) {
            requette += " And o.sexe like '%" + sexe + "%'";

        }
        if (type > 0 && !type.equals(" ")) {
            requette += " And o.type= " + type;

        }
        System.out.println("requettttte ========>" + requette);
        System.out.println("em.createQuery(requette).getResultList()=======>" + em.createQuery(requette).getResultList());

        return em.createQuery(requette).getResultList();

    }

    //////////////////////RECHERCHE ////////////////////////////
    public List<Orphelin> recherche2(String nomRegion, String sexe, Integer type, Integer ageMin, Integer ageMax, Integer nbrMin, Integer nbrMax) {

        String requette = ("Select orph from Orphelin orph,Dossier d where orph.dossier.id=d.id");

        if (ageMin != 0) {
            requette += " And orph.age >= " + ageMin;
        }
        if (ageMax != 0) {
            requette += " And orph.age <= " + ageMax;
        }
        if (type != 0) {
            requette += " And orph.type =" + type;
        }
        if (sexe != null) {
            requette += " And orph.sexe = '" + sexe + "'";
        }

        if (nomRegion != null) {
            requette += " And orph.dossier.region.nomRegion= '" + nomRegion + "'";
        }
        if (nbrMin != 0) {
            requette += " And orph.dossier.nbrOrphelin >=" + nbrMin;
        }
        if (nbrMax != 0) {
            requette += " And orph.dossier.nbrOrphelin <=" + nbrMax;
        }

        return em.createQuery(requette).getResultList();

    }
    ///////////////////RECHERCHE3//////////////////////

    public List<Dossier> trouver2(String cin, String type, Double montant, String cinMed, Date datePriseDossier) {

        String requette = ("Select dossier from Dossier dossier ,Parrinage parr where  dossier.id =parr.dossier.id");

        if (cin != null && !cin.equals(" ")) {

            requette += " And parr.parrain.id Like '%" + cin + "%'";
        }
        if (type != null && !type.equals(" ")) {
            requette += " And parr.type Like '%" + type + "%'";
        }
        if (montant != 0) {
            requette += " And parr.Montant = " + montant;
        }

        if (cinMed != null && !cinMed.equals(" ")) {
            requette += " And parr.parrain.mediataire.id Like '%" + cinMed + "%'";
        }
        if (datePriseDossier != null) {
            requette += " And parr.priseDossier >= '" + DateUtil.getSqlDate(datePriseDossier) + "' ";
        }

        if (type != null && !type.equals(" ")) {
            requette += " And parr.type= " + type;

        }
        System.out.println("requettttte ========>" + requette);
        System.out.println("em.createQuery(requette).getResultList()=======>" + em.createQuery(requette).getResultList());

        return em.createQuery(requette).getResultList();

    }

    public List<Dossier> findByciteriat1(String region, int nbr) {
        List<Dossier> resultat = new ArrayList<>();
        int nombre;
        String requette = ("Select dossier from Dossier dossier where dossier.etat = -1");

        if (region != null) {
            requette += " AND dossier.region'= " + region + "'";
        }

        List<Dossier> dos = em.createQuery(requette).getResultList();
        for (int i = 0; i < dos.size(); i++) {
            Dossier dossier = dos.get(i);
            String req = " SELECT o FROM Orphelin o WHERE o.dossier.id  = " + dossier.getId();
            List<Dossier> liste = em.createQuery(req).getResultList();
            nombre = liste.size();
            if (nombre == nbr) {
                resultat.add(dossier);
            }

        }
        return resultat;

    }

    public List<Dossier> findByciteriat2(String sexe, int type) {

        String requette = ("Select dossier from Dossier dossier.etat = -1");

        List<Dossier> dossiers = em.createQuery(requette).getResultList();
        if (sexe != null) {
            for (int i = 0; i < dossiers.size(); i++) {
                Dossier get = dossiers.get(i);
                requette += "And o FROM Orphelin o WHERE o.dossier.id  = '" + get.getId() + "' and o.sexe like '%" + sexe + "'%";

            }
        }

        if (type != 0) {
            requette += "And o.type= " + type;
        }
        return em.createQuery(requette).getResultList();
    }

    public List<Dossier> classement(List<Dossier> dossiers) {

        String requette = "Select dos from Dossier dos where dos.etat= -1 order by dos.indice ASC";

        List<Dossier> d = em.createQuery(requette).getResultList();

        return d;
    }

    public List<Dossier> recherche(String sexe, int type, String region, int nbr, int age) {

        List<Dossier> dossiers = new ArrayList<>();

        if (sexe != null || type != 0) {
            dossiers = findByciteriat2(sexe, type);
        }
        if (region != null || nbr != 0) {
            dossiers = findByciteriat1(region, nbr);
        }
        if (age != 0) {
            dossiers = convertirAge(age);

        }

        return dossiers;

    }

    public List<Dossier> convertirAge(int age) {
        List<Dossier> dossiers = new ArrayList<>();
        List<Orphelin> orphelins;
        Date d = new Date();
        LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        String requette = ("Select dossier from Dossier dossier where dossier.etat = -1");
        List<Dossier> listt = em.createQuery(requette).getResultList();
        if (age != 0) {
            for (int i = 0; i < listt.size(); i++) {
                Dossier dossierr = listt.get(i);
                orphelins = dossierr.getOrphelins();
                for (int j = 0; j < orphelins.size(); j++) {
                    Orphelin orphelin = orphelins.get(j);
                    Date dateNaissance = orphelin.getDateNaissance();
                    LocalDate localDate1 = dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    int year1 = localDate1.getYear();
                    int res = year - age;
                    if (year1 == res) {
                        dossiers.add(dossierr);

                    }
                }

            }

        }
        return dossiers;
    }

    ////////////////////////////// Ajouter Parrainage/Parrain  /////////////////////////
//    public int ajouterParrain(Parrain parrain) {
//        Parrinage parrinage = parrinageFacade.find(parrain.getParrinage().getId());
//        if (parrinage != null) {
//            parrinage.setParrain(parrain);
//            parrinageFacade.create(parrinage);
//            
//            parrainFacade.create(parrain);
//
//            return 1;
//        } else {
//            return -1;
//        }
//    }
    public Long generatteIdParrinage() {
        Long maxId = (Long) em.createQuery("SELECT MAX(p.id) FROM Parrinage p").getSingleResult();
        return (maxId == null ? 1l : maxId + 1);
    }

    public Long generatteIdPunition() {
        Long maxId = (Long) em.createQuery("SELECT MAX(p.id) FROM Punition p").getSingleResult();
        return (maxId == null ? 1l : maxId + 1);
    }

    public int ajouterParrinage(Parrinage parrinage, Parrain parrain, String type) {
        Dossier dossier = find(parrinage.getDossier().getId());
        System.out.println("haa dossier " + dossier);
        // Parrinage parrinagee = parrinageFacade.find(parrain.getParrinage().getId());
        parrinage.setId(generatteIdParrinage());
        parrinage.setDossier(dossier);
        parrinage.setType(type);
        parrinage.setParrain(parrain);
        parrinageFacade.create(parrinage);
        parrain.setParrinage(parrinage);
        parrainFacade.create(parrain);
        System.out.println(" voila type pârrainage =======>" + parrinage.getType());

        dossier.getParrinages().add(parrinage);
        if (parrinage.getType().equalsIgnoreCase("Complet")) {
            dossier.setEtat(-5);///// Parrainé par 600DH
        } else if (parrinage.getType().equalsIgnoreCase("Partiel")) {
            dossier.setEtat(-6);/////////////// parrainé par 300DH
        }

        edit(dossier);

        return 1;
    }

    public int completerParrinage(Parrinage parrinage, Parrain parrain) {
        Dossier dossier = find(parrinage.getDossier().getId());
        System.out.println("haa dossier " + dossier);
        // Parrinage parrinagee = parrinageFacade.find(parrain.getParrinage().getId());
        parrinage.setId(generatteIdParrinage());
        parrinage.setDossier(dossier);
        parrinage.setParrain(parrain);
        parrinageFacade.create(parrinage);
        parrain.setParrinage(parrinage);
        parrainFacade.create(parrain);

        dossier.getParrinages().add(parrinage);
        dossier.setEtat(-5);
        edit(dossier);

        return 1;
    }

    public void modifEtat(Dossier dossier, Punition punition) {
        if (punition.getDateFin().equals(new Date())) {
            dossier.setEtat(-1);
        } else {
            dossier.setEtat(-7);
        }
        edit(dossier);

    }

    public void modifEtat() {
        List<Dossier> dossiers = em.createQuery("Select d From Dossier d, Punition p where d.id = p.dossier.id and d.etat = -7").getResultList();

        for (int i = 0; i < dossiers.size(); i++) {
            Dossier dossier = dossiers.get(i);
            String req = " SELECT p FROM Punition p  WHERE p.dossier.id  = " + dossier.getId() + " ORDER BY p.dateFin DESC";
            List<Punition> punitions = em.createQuery(req).setMaxResults(1).getResultList();
            if (punitions != null && !punitions.isEmpty() && punitions.get(0) != null) {

                modifEtat(dossier, punitions.get(0));
            }

        }
    }

    public int createPunition(Punition punition) {
        Dossier dossier = find(punition.getDossier().getId());
        punition.setId(generatteIdPunition());
        punition.setDuree(DateUtil.calculDifference(punition.getDateFin(), punition.getDateDebut()));
        punition.setDossier(dossier);
        punitionFacade.create(punition);
        dossier.getPunitions().add(punition);
        dossier.setEtat(-7);
        if (dossier.getDateDernierPunition() == null || dossier.getDateDernierPunition().before(punition.getDateFin())) {
            dossier.setDateDernierPunition(punition.getDateFin());
        }
        edit(dossier);

        return 1;
    }

    //////////////////////////////////les Détails Dossiers ////////////////
    public List<Membre> allMembre(Dossier dossier) {
        String requette = "Select m From Membre m where m.dossier.id= " + dossier.getId();
        List<Membre> membres = em.createQuery(requette).getResultList();
        return membres;
    }
    public List<Punition> allPunitions(Dossier dossier) {
        String requette = "Select m From Punition m where m.dossier.id= " + dossier.getId();
        List<Punition> punitions = em.createQuery(requette).getResultList();
        return punitions;
    }

    public List<Orphelin> allOrphelins(Dossier dossier) {
        String requette = "Select o From Orphelin o where o.dossier.id= " + dossier.getId();
        List<Orphelin> Orphelins = em.createQuery(requette).getResultList();
        return Orphelins;
    }

    public List<Parrinage> allParrinages(Dossier dossier) {
        String requette = "Select p From Parrinage p where p.dossier.id= " + dossier.getId();
        List<Parrinage> Parrinages = em.createQuery(requette).getResultList();
        return Parrinages;
    }

    public Object allEtatPedaParOrph(Orphelin orphelin) {
        String requette = "Select e From EtatPedagogiqueItem e where e.orphelin.id= " + orphelin.getId();
        return em.createQuery(requette).getSingleResult();

    }

    public Object allEtatSanteOrphelin(Orphelin orphelin) {
        String requette = "Select e From EtatSanteOrphelin e where e.orphelin.id= " + orphelin.getId();
        return em.createQuery(requette).getSingleResult();

    }

    /////////////////////// Statistique /////////////////////////////
    public Long statistiquee(int annee, Region region, SousRegion sousRegion) {
        String requette = "SELECT COUNT(d.id) FROM "
                + "Dossier d WHERE  d.annee =" + annee;

        if (region != null && region.getId() != null) {
            requette += " AND d.region.id='" + region.getId() + "'";
        } else if (sousRegion != null && sousRegion.getId() != null) {
            requette += " AND d.region.sousRegion.id='" + sousRegion.getId() + "'";
        }
        System.out.println("haaaaaaaa rek====>" + requette);
        List<Long> res = em.createQuery(requette).getResultList();
        System.out.println("res f service : " + res);
        if (res != null && !res.isEmpty() && res.get(0) != null) {
            return res.get(0);
        }
        return new Long(0);
    }

    public Long statistiqueOrphelin(int annee, String sexe, Integer age) {
        String requette = "SELECT COUNT(o.id) FROM "
                + "Dossier d,Orphelin o WHERE d.id =o.dossier.id and d.annee =" + annee;
        if (age != 0) {
            requette += (" and o.age <= " + age);
        }

        if (sexe != null && !sexe.equals(" ")) {
            requette += " And o.sexe like '%" + sexe + "%'";
        }

        System.out.println("haaaaaaaa rek====>" + requette);
        List<Long> res = em.createQuery(requette).getResultList();
        System.out.println("res f service : " + res);
        if (res != null && !res.isEmpty() && res.get(0) != null) {
            return res.get(0);
        }
        return new Long(0);
    }

    public Long[] statistiqueDossier(int premierAnnee, int deuxiemAnnee, Region region, SousRegion sousRegion) {
//        BigDecimal statistiquePremierAnnee = new BigDecimal(0);
//        BigDecimal statistiqueDeuxiemAnnee = new BigDecimal(0);
        Long[] resultat = new Long[2];
//        for (int i = 1; i <= 2; i++) {
//            statistiquePremierAnnee = statistiquee(premierAnnee, region, sousRegion);
//            statistiqueDeuxiemAnnee = statistiquee(deuxiemAnnee, region, sousRegion);
//        }
        resultat[0] = statistiquee(premierAnnee, region, sousRegion);
        resultat[1] = statistiquee(deuxiemAnnee, region, sousRegion);
        return resultat;

    }

    public Long[] statistiqueOrphelin(int premierAnnee, int deuxiemAnnee, String sexe, Integer age) {
//        BigDecimal statistiquePremierAnnee = new BigDecimal(0);
//        BigDecimal statistiqueDeuxiemAnnee = new BigDecimal(0);
        Long[] resultat = new Long[2];
//        for (int i = 1; i <= 2; i++) {
//            statistiquePremierAnnee = statistiquee(premierAnnee, region, sousRegion);
//            statistiqueDeuxiemAnnee = statistiquee(deuxiemAnnee, region, sousRegion);
//        }
        resultat[0] = statistiqueOrphelin(premierAnnee, sexe, age);
        resultat[1] = statistiqueOrphelin(deuxiemAnnee, sexe, age);
        return resultat;

    }

    ///////////////////////
    public void generatePdf(Dossier dossier, ResponsableFamille responsableFamille,
            Region region, ResponsableRegion responsableRegion,
            AssistanteSociale assistanteSociale1,
            AssistanteSociale assistanteSociale2) throws JRException, IOException {
//        int res = findAll().size();
//        Dossier dossier = find(res);
        Map<String, Object> params = new HashMap<>();
        params.put("parameter1", dossier.getDateDossier());
        params.put("parameter2", dossier.getNumDossier());
        params.put("parameter3", dossier.getNomFamille());
        System.out.println("ha resppp ==> " + dossier.getResponsableFamille().getId());
        params.put("parameter4", responsableFamille.getId());
        params.put("parameter5", responsableFamille.getNom());
        params.put("parameter6", responsableFamille.getPrenom());
        params.put("parameter7", responsableFamille.getType());
        params.put("parameter8", responsableFamille.getTelephone());
        System.out.println("haaa region ==>" + region);
        params.put("parameter9", region.getNomRegion());
        params.put("parameter11", responsableRegion.getNom());
        params.put("parameter15", dossier.getAdresseActuelle());
        params.put("parameter13", assistanteSociale1.getNom() + ";" + assistanteSociale1.getPrenom());
        params.put("parameter14", assistanteSociale2.getNom() + ";" + assistanteSociale2.getPrenom());

        PdfUtil.generatePdf(findAll(), params, "information Dossier" + dossier.getId(), "/report/Dossier.jasper");
    }
////////////////////////////////Connexion ///////////////////////

    public int seConnecter(Utilisateur user) {

        Utilisateur loadedUser = utilisateurFacade.find(user.getId());
        System.out.println("voila le user trouvé =========>" + user.getId());

        if (loadedUser.getId().equals(user.getId())) {

            if (loadedUser.getPassword().equals(user.getPassword())) {

                user.setType(loadedUser.getType());
                return 5;
            }
            return -2;
        }
        return -3;

    }

    //////////////////////////////////////////
    public Orphelin updateAge(Orphelin orphelin) {
        Date d = new Date();
        double nvAge = 0;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String dateNaiss = format.format(orphelin.getDateNaissance());
        String datesys = format.format(d.getDate());

        try {
            java.util.Date date1 = format.parse(datesys);
            java.util.Date date2 = format.parse(dateNaiss);
            nvAge = (int) (((date1.getYear() + 1946) - (date2.getYear() + 1900)));
            orphelin.setAge((int) nvAge);

        } catch (ParseException ex) {
            Logger.getLogger(DossierFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orphelin;
    }

    public Dossier updateDossier(Dossier dossier) {

        String requette = ("Select * from dossier Dossier where dossier.id = " + dossier.getId());

        List<Dossier> dossiers = em.createQuery(requette).getResultList();

        for (int i = 0; i < dossiers.size(); i++) {
            Dossier dos = dossiers.get(i);

            String requeta = "Select count(o) from Orphelin o where o.dossier.id = " + dos.getId();

            int nouveauNombre = (int) em.createQuery(requeta).getSingleResult();
            dos.setNbrOrphelin(nouveauNombre);

        }
        edit(dossier);

        return dossier;
    }
    ///////////////////// CreatePunition

    public void createPunition(Dossier dossier) {

    }
}
