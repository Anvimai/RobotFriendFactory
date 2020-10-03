package botOmat;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RobotFriend implements Robot{
	
	private String name; 
	private String type;
	private int score; 
	private String[] randomTasks = new String[5]; 
	private String[] tasks = {"do the dishes", "sweep the house", "do the laundry", "take out the recycling",
			"make a sammich", "mow the lawn", "rake the leaves", "give the dog a bath", 
			"bake some cookies", "wash the car"};
	

	private final Map<String, Integer> map = Map.of("do the dishes", 1000,  "sweep the house", 3000,  
			"do the laundry", 10000, "take out the recycling", 4000, "make a sammich", 7000, 
			"mow the lawn", 20000, "rake the leaves", 18000, "give the dog a bath", 14500, 
			 "bake some cookies", 8000,  "wash the car" ,20000);
	
	public RobotFriend(String name, String type) {
		
		this.name = name; 
		this.type = type; 
		
		
		
		Set<Integer> mySet = new HashSet<Integer>();
		int i = 0; 
		
		while(i < 5) {
			Random rand = new Random(); 
			int index = rand.nextInt(9);
			
			if(!mySet.contains(index)) {
			
			randomTasks[i] = tasks[index];
			mySet.add(index);
			i++;
			
			}
		}
		
	}




	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	
	public String[] getTasks() {
		// TODO Auto-generated method stub
		return randomTasks;
	}
	
	public Map<String, Integer> getSchedual() {
		return map;
	}


	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}


	@Override
	public void setScore(int x) {
		// TODO Auto-generated method stub
		score = x; 
	}




	public void getFigure() {
	
	}






}
