package model;

import view.Observer;

public class Subject implements ISubject{
	public java.util.Collection<Observer> observer;


	@Override
	public void register(Observer parameter1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregister(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
	
	 /** @pdGenerated default getter */
	   public java.util.Collection<Observer> getObserver() {
	      if (observer == null)
	         observer = new java.util.HashSet<Observer>();
	      return observer;
	   }
	   
	   /** @pdGenerated default iterator getter */
	   public java.util.Iterator getIteratorObserver() {
	      if (observer == null)
	         observer = new java.util.HashSet<Observer>();
	      return observer.iterator();
	   }
	   
	   /** @pdGenerated default setter
	     * @param newObserver */
	   public void setObserver(java.util.Collection<Observer> newObserver) {
	      removeAllObserver();
	      for (java.util.Iterator iter = newObserver.iterator(); iter.hasNext();)
	         addObserver((Observer)iter.next());
	   }
	   
	   /** @pdGenerated default add
	     * @param newObserver */
	   public void addObserver(Observer newObserver) {
	      if (newObserver == null)
	         return;
	      if (this.observer == null)
	         this.observer = new java.util.HashSet<Observer>();
	      if (!this.observer.contains(newObserver))
	         this.observer.add(newObserver);
	   }
	   
	   /** @pdGenerated default remove
	     * @param oldObserver */
	   public void removeObserver(Observer oldObserver) {
	      if (oldObserver == null)
	         return;
	      if (this.observer != null)
	         if (this.observer.contains(oldObserver))
	            this.observer.remove(oldObserver);
	   }
	   
	   /** @pdGenerated default removeAll */
	   public void removeAllObserver() {
	      if (observer != null)
	         observer.clear();
	   }

}
