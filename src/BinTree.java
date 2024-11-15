/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017.
 * </p>
 * <p>
 * Generische Klasse BinTree<ContentType>
 * </p>
 * <p>
 * Mithilfe der generischen Klasse BinTree koennen beliebig viele
 * Inhaltsobjekte vom Typ ContentType in einem Binaerbaum verwaltet werden. Ein
 * Objekt der Klasse stellt entweder einen leeren Baum dar oder verwaltet ein
 * Inhaltsobjekt sowie einen linken und einen rechten Teilbaum, die ebenfalls
 * Objekte der generischen Klasse BinTree sind.
 * </p>
 * 
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version Generisch_03 2014-03-01
 */
public class BinTree<ContentType> {

  /* --------- Anfang der privaten inneren Klasse -------------- */

  /**
   * Durch diese innere Klasse kann man dafuer sorgen, dass ein leerer Baum
   * null ist, ein nicht-leerer Baum jedoch immer eine nicht-null-Wurzel hat.
   * Leere Teilbaeume werden durch null dargestellt.
   */
  private class BTNode<CT> {
    
    private CT content;
    private BinTree<CT> left, right;

    public BTNode(CT pContent) {
      // Damit diese Implementation mit dem Abiturvorgaben 2020 �bereinstimmt,
      // werden nicht vorhandene bin�re B�ume als null dargestellt.
      // Somit haben Bl�tter einen Inhalt und beim linken und rechten Teilbaum ist null eingetragen.
      this.content = pContent;
      left = null;
      right = null;
      // left = new BinTree<CT>();
      // right = new BinTree<CT>();
    }
    
  }

  /* ----------- Ende der privaten inneren Klasse -------------- */

  private BTNode<ContentType> node;

  /**
   * Nach dem Aufruf des Konstruktors existiert ein leerer Binaerbaum.
   */
  public BinTree() {
    this.node = null;
  }

  /**
   * Der Konstruktor erzeugt einen Binaerbaum und hat pContent als Inhaltsobjekt und
   * zwei leere Teilbaeume (d. h., dass die Verweise auf null gesetzt sind).
   * 
   * @param pContent
   *            das Inhaltsobjekt des Wurzelknotens vom Typ ContentType
   */
  public BinTree(ContentType pContent) {
    this.node = new BTNode<ContentType>(pContent);
  }

  /*
   * Diese Anfrage liefert den Wahrheitswert true, wenn die Wurzel des Baums einen Inhaltswert besitzt,
   * sonst liefert sie den Wert false.
   * 
   * @return true, wenn die Wurzel einen Inhaltswert besitzt, sonst false
   */
  public boolean hasItem() {
    return (this.node != null) && (this.node.content != null);
  }

  /**
   * Die Wurzel des Baums erh�lt den �bergebenen Inhalt als Wert.
   * 
   * @param pContent
   *            neues Inhaltsobjekt vom Typ ContentType
   */
  public void setItem(ContentType inhalt) {
    if (this.node == null) {
      node = new BTNode<ContentType>(inhalt);
    }
    else
    {
      this.node.content = inhalt;
    }
  }

  /**
   * Die Operation gibt den Inhaltswert der Wurzel des Baums zur�ck.
   * 
   * @return das Inhaltsobjekt der Wurzel vom Typ ContentType bzw. null, wenn
   *         der Binaerbaum leer ist
   */
  public ContentType getItem() {
    if (this.node == null) {
      return null;
    } else {
      return this.node.content;
    }
  }

  /**
   * Der �bergebene Baum wird als linker Teilbaum gesetzt.
   * 
   * @param pTree
   *            neuer linker Teilbaum vom Typ BinTree<ContentType>
   */
  public void setLeft(BinTree<ContentType> pTree) {
    if (node == null)
    {
      node = new BTNode<ContentType>(null);      
    }
    this.node.left = pTree;
  }

  /**
   * Der �bergebene Baum wird als rechter Teilbaum gesetzt.
   * 
   * @param pTree
   *            neuer rechter Teilbaum vom Typ BinTree<ContentType>
   */
  public void setRight(BinTree<ContentType> pTree) {
    if (node == null)
    {
      node = new BTNode<ContentType>(null);      
    }
    this.node.right = pTree;
  }

  /**
   * Die Operation gibt den linken Teilbaum zur�ck.
   * 
   * @return linker Teilbaum vom Typ BinTree<ContentType> oder null, wenn
   * der aktuelle Binaerbaum leer ist
   */
  public BinTree<ContentType> getLeft() {
    if (node == null)
    {
      return null;
    }
    else
    {
      return this.node.left;
    }
  }

  /**
   * Die Operation gibt den rechten Teilbaum zur�ck.
   * 
   * @return rechter Teilbaum vom Typ BinTree<ContentType> oder null, wenn
   * der aktuelle Binaerbaum leer ist
   */
  public BinTree<ContentType> getRight() {
    if (node == null)
    {
      return null;
    }
    else
    {
      return this.node.right;
    }
  }

  /**
   * 
   * �berpr�ft, ob der Baum nur aus einem Blatt besteht.
   * 
   * @return Die Anfrage liefert den Wert wahr, wenn der Baum keinen linken
   * und keinen rechten Teilbaum besitzt, sonst liefert sie den Wert falsch.
   * 
   * Achtung: Ein leerer Baum ergibt ebenfalls true. (In diesem Fall sind die Vorgaben des Abiturs offen.)
   * 
   */
  public boolean isLeaf()
  {
    return (node == null || (getLeft() == null && getRight() == null));
  }

  /**
   * Wenn der Baum einen linken Teilbaum besitzt, wird der Wert wahr zur�ckgegeben, sonst der Wert falsch.
   */
  public boolean hasLeft()
  {
    return node != null && getLeft() != null;
  }

  /**
   * Wenn der Baum einen rechten Teilbaum besitzt, wird der Wert wahr zur�ckgegeben, sonst der Wert falsch.
   */
  public boolean hasRight()
  {
    return node != null && getRight() != null;
  }

  /**
   * Die Operation l�scht den linken Teilbaum.
   */
  public void deleteLeft()
  {
    if (this.node != null)
    {
      this.node.left = null;
    }
  }

  /**
   * Die Operation l�scht den rechten Teilbaum.
   */
  public void deleteRight()
  {
    if (this.node != null)
    {
      this.node.right = null;
    }
  }

  /**
   * Die Operation l�scht den Inhaltswert der Wurzel des Baums.
   */
  public void deleteItem()
  {
    if (this.node != null)
    {
      this.node.content = null;
    }
  }
}
