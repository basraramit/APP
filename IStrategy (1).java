package Strategy;

import Model.Risk_Model;

public interface IStrategy {
	
	int reinforce(String country, Risk_Model model);
	
	int attack(String country1, String country2, Risk_Model model);

    int fortify(String country1, String country2, Risk_Model model);
  
}
