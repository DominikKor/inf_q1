package DynArrays;

/**
 * Generische Klasse DynArray<Content Type> laut Abiturvorgaben, Informatik 2018, Niedersachsen
 * 
 * Objekte der generischen Klasse DynArray (dynamische Reihung) verwalten beliebige
 * Objekte vom Typ ContentType. Die Indizierung beginnt bei 0.
 * 
 * Die innere Klasse wurde aus der Klasse "List"
 * mit dem Autor "Qualitaets- und UnterstuetzungsAgentur -
 * Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII"
 * entnommen.
 * 
 * @author Lae
 *
 */
public class DynArray<ContentType> {
	// Die aktuelle Gr��e der dynmischen Reihung.
	private int size;
	
	// erstes Element der Liste
	Node first;

	// letztes Element der Liste
	Node last;

	// aktuelles Element der Liste
	Node current;

	/**
	 * Eine leere Liste wird erzeugt.
	 */
	public DynArray() {
	  first = null;
	  last = null;
	  current = null;
	  size = 0;
	}
	
	/* --------- Anfang der privaten inneren Klasse -------------- */
	private class Node {
		private ContentType contentObject;
	    private Node next;
	    /**
	     * Ein neues Objekt wird erschaffen. Der Verweis ist leer.
	     * 
	     * @param pContent das Inhaltsobjekt vom Typ ContentType
	     */
	    private Node(ContentType pContent) {
	      contentObject = pContent;
	      next = null;
	    }

	    /**
	     * Der Inhalt des Knotens wird zurueckgeliefert.
	     * 
	     * @return das Inhaltsobjekt des Knotens
	     */
	    public ContentType getContentObject() {
	      return contentObject;
	    }

	    /**
	     * Der Inhalt dieses Knotens wird gesetzt.
	     * 
	     * @param pContent das Inhaltsobjekt vom Typ ContentType
	     */
	    public void setContentObject(ContentType pContent) {
	      contentObject = pContent;
	    }

	    /**
	     * Der Nachfolgeknoten wird zurueckgeliefert.
	     * 
	     * @return das Objekt, auf das der aktuelle Verweis zeigt
	     */
	    public Node getNextNode() {
	      return this.next;
	    }

	    /**
	     * Der Verweis wird auf das Objekt, das als Parameter uebergeben
	     * wird, gesetzt.
	     * 
	     * @param pNext der Nachfolger des Knotens
	     */
	    public void setNextNode(Node pNext) {
	      this.next = pNext;
	    }

	  }

	  /* ----------- Ende der privaten inneren Klasse -------------- */
	
	
	/**
	 * Die Anfrage liefert den Wert true, wenn die dynamische Reihung keine Objekte enthaelt,
	 * sonst liefert sie den Wert false.
	 * 
	 * @return true, wenn die dynamische Reihung leer ist, sonst false
	 */
	public boolean isEmpty()
	{
		return (first == null);
	}
	
	/**
	 * Der Inhaltswert des Elements an der Position index wird zur�ckgegeben.
	 * Liegt der Index au�erhalb des g�ltigen Bereichs, so wird null zur�ckgegeben.
	 * 
	 * @return der Inhalt des Elements an der Position index
	 */
	public ContentType getItem(int index)
	{
		// Der Index liegt im g�ltigen Bereich.
		if (index < size && index >= 0)
		{
			// Beginne vorn in der dynamischen Reihung.
			current = first;
			// Gehe nun index-1 Schritte bis zum gew�nschten Element.
			for (int i = 0; i < index; i++)
			{
				current = current.getNextNode();
			}
			return current.getContentObject();
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Die Anzahl der Elemente der dynamischen Reihung wird zur�ckgegeben.
	 * 
	 * @return die Laenge der dynamischen Reihung
	 */
	public int getLength()
	{
		return size;
	}
	
	/**
	 * Ein neues Element mit dem angegebenen Inhaltswert wird am Ende der dynamischen Reihung eingef�gt.
	 * Ist der uebergebene Inhalt null, so passiert nichts.
	 * 
	 * @param inhalt wird ans Ende der dynmischen Reihung gesetzt
	 */
	public void append(ContentType inhalt)
	{
		if (inhalt != null)
		{
			Node neuerKnoten = new Node(inhalt);
			if (isEmpty())
			{
				// in leere Listen einfuegen
				first = neuerKnoten;
				last = first;
				size = 1;
			}
			else
			{
				// an nicht-leere dynamische Reihung anfuegen
				last.setNextNode(neuerKnoten);
				last = neuerKnoten;
				size++;
			}
		}
	}
	
	/**
	 * Ein neues Element mit dem �bergebenen Inhalt wird an der Position index in die dynamische Reihung eingef�gt.
	 * Das Element, das sich vorher an dieser Position befunden hat, und alle nachfolgenden werden nach hinten verschoben.
	 * Entspricht der Wert von index der L�nge der dynamischen Reihung, so wird ein neues Element am Ende der
	 * dynamischen Reihung angef�gt.
	 * 
	 * @param index gibt die Position an, an der das neue Element eingefuegt wird
	 * @param inhalt gibt an, was in die dynamische Reihung eingefuegt wird
	 */
	public void insertAt(int index, ContentType inhalt)
	{
		if (inhalt != null)
		{
			// Ist der Index au�erhalb des g�ltigen Bereichs, passiert nichts.
			if ((index == 0 && isEmpty()) || index == size)
			{
				// F�ge in die leere dynamische Reihung ein bzw. h�nge hinten an die dynamische Reihung an.
				append(inhalt);
			}
			else if (index >= 0 && index < size)
			{
				// F�ge in die nicht-leere dynamische Reihung ein.
				
				// Suche den Knoten an der Position index.
				current = first;
				Node davor = null;
				for (int i = 0; i < index; i++)
				{
					davor = current;
					current = current.getNextNode();
				}
				
				// Erstelle den neuen Knoten und fuege ihn an der Position index ein.
				Node neuerKnoten = new Node(inhalt);
				
				if (davor != null)
				{
					davor.setNextNode(neuerKnoten);
					neuerKnoten.setNextNode(current);
				}
				else
				{
					neuerKnoten.setNextNode(first);
					first = neuerKnoten;
				}
				size++;
			}
		}
	}
	
	/**
	 * Der Inhaltswert des Elements an der Position index wird durch inhalt ersetzt.
	 * Falls die angegebene Position nicht existiert, hat die Operation keine Wirkung.
	 * @param index die Position, an der das Element ersetzt wird
	 * @param inhalt der neue Inhalt
	 */
	public void setItem(int index, ContentType inhalt)
	{
		// Ist der Index au�erhalb des g�ltigen Bereichs oder der Inhalt null, passiert nichts.
		if (index >= 0 && index < size && inhalt != null)
		{
			// Beginne vorn in der dynamischen Reihung.
			current = first;
			// Gehe nun index-1 Schritte bis zum gew�nschten Element.
			for (int i = 0; i < index; i++)
			{
				current = current.getNextNode();
			}
			current.setContentObject(inhalt);
		}
	}
	
	/**
	 * Das Element an der Position index wird entfernt.
	 * Alle folgenden Elemente werden um eine Position nach vorne geschoben.
	 * Falls die angegebene Position nicht existiert, hat die Operation keine Wirkung. 
	 * @param index
	 */
	public void delete(int index)
	{
		// Ist der Index au�erhalb des g�ltigen Bereichs, passiert nichts.
		
		// Entferne das einzige Element.
		if (size == 1 && index == 0)
		{
			first = null;
			last = null;
			current = null;
			size = 0;
		}
		// Die dynamische Reihung besteht aus mehr als einem Element.
		else if (index >= 0 && index < size)
		{
			// Suche den Knoten an der Position index.
			current = first;
			Node davor = null;
			for (int i = 0; i < index; i++)
			{
				davor = current;
				current = current.getNextNode();
			}
						
			// entferne den aktuellen Knoten
			if (davor != null)
			{
				// Falls das zu entfernende Element nicht vorn ist,
				// muss der Verweis davor auch angepasst werden.
				davor.setNextNode(current.getNextNode());
				current = current.getNextNode();
			}
			else // das zu entfernende Element ist vorn
			{
				first = first.getNextNode();
			}
			size--;
		}
	}
}
