package Strategy;

import Model.Country;
import Model.Player;

public interface IStrategy {
	 /**
	    * Returns the number of troops to be deployed. Primarily a function of brain to allow AI to
	    * cheat.
	    *
	    * @return the number of troops the be deployed.
	    */
	   int getToDeploy();

	   /**
	    * Determines where to deploy armies to.
	    *
	    * @param deployAmount number of armies possible to deploy.
	    * @return the Country to deploy armies to.
	    */
	   Country deployTo(int deployAmount);

	   /**
	    * Determines how many armies to deploy.
	    *
	    * @param deployAmount number of armies possible to deploy.
	    * @return the number of armies to deploy.
	    */
	   int deployAmount();


	   /**
	    * Determines where to attack from.
	    *
	    * @return the attacking Country.
	    */
	   Country attackFrom();

	   /**
	    * Determines which country to attack.
	    *
	    * @param origin the attacking country.
	    * @return the country to be attacked.
	    */
	   Country attack(Country origin);

	   /**
	    * Determines how many armies to attack with.
	    *
	    * @param origin the Country to attack from.
	    * @return the amount to attack with.
	    */
	   int attackAmount(Country origin);

	   /**
	    * Determines how many armies to move in event of conquering another country.
	    *
	    * @param origin    the attacking country.
	    * @param attacked  the conquered country.
	    * @param minAmount minimum amount of armies they can move.
	    * @return the number of armies to move.
	    */
	   int moveAmount(Country origin, Country attacked, int minAmount);

	   /**
	    * Determines where to move armies from when fortifying.
	    *
	    * @return Country to move armies from.
	    */
	   Country fortifyFrom();

	   /**
	    * Determines what country to move armies to.
	    *
	    * @param origin the Country moving its armies.
	    * @return the Country to move armies to.
	    */
	   Country fortify(Country origin);

	   /**
	    * Determines how many armies are to be moved.
	    * @param origin the country the armies are moving from.
	    * @param toFortify the country the armies are moving to.
	    * @return the amount of armies to move.
	    */
	   int fortifyAmount(Country origin, Country toFortify);

	   /**
	    * Code to be executed at the end of the turn.
	    */
	   void endTurn();
	
}
