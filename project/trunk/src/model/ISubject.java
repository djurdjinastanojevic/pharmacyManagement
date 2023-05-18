package model;

import view.Observer;
import java.util.*;

public interface ISubject {
	   /** @param parameter1 */
	   void register(Observer parameter1);
	   /** @param observer */
	   void unregister(Observer observer);
	   void notifyObservers();
}
