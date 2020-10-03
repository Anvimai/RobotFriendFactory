package botOmat;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//cap number of attempts on wrong responses. Ask to continue or exit. 



public class RobotsAtPlay {
	
	
	public static void main(String[] args) {
		
		boolean play = true; 
		
		while(play) {
		
			int quantity = 0; 
			
			List<RobotFriend> robs = new ArrayList<RobotFriend>(); //a list to hold the robot objects once created
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("-------------------------------------------------------\n");
			
			System.out.println("         Welcome to the Robot Friend Factory");
			
			System.out.println("-------------------------------------------------------\n");
			
	
			
				System.out.println("How many robots will you be ordering today?");
				
				//only accept a valid number response (quantity > 0)
				//loop until valid response has been entered. 
				
				boolean cont = false;
				long esc = 0; 
				while(!cont) {//robot quantity loop begin
					
					if(esc == 3) {
						
						System.out.println("\n It looks like youve entered an invalid charachter 3 times. \n\n"
								+ "Enter 'e' if you would like to exit the game: \n\n Enter 'c' if you would like to continue: ");
						
						if(scan.nextLine().compareTo("e")==0){
							
							esc = 0; 
						
						}else {
							
							
							System.exit(0);
							
						}
					}
					
					esc++;
					
					if(scan.hasNextInt()) {
						
					    quantity = scan.nextInt();
						scan.nextLine();
						cont = true;
					
					}else {
						
						scan.nextLine();
						System.out.println("Please enter a valid number: "); continue;
						
						
					}
			
				}//robot quantity loop end
				
		
			//loop through collecting names and types for each robot being ordered and create their robot objects.
			//If robot type is invalid ask for a valid response and allow the user to input robot type again until a valid response is entered. 
			
			for(int i = 0; i< quantity; i++) {//begin collection loop
				
				System.out.println("Robot: " + (i+1));
				
				System.out.println("Please enter a name for your robot: ");
				
				String name = scan.nextLine();
				
				
				System.out.println();
				
				
				System.out.println("Currently, we only manufacture Unipedal, Bipedal, "
						+ "Quadrupedal, Arachnid, Radial, Aeronautical robots.\n");
				
				System.out.println("Please enter the robot type of your choice: ");
				
				// the user must enter a valid robot type (case does not matter). Loop until a valid response is recorded.
				
				boolean valid = false;
				long esc2 = 0;
				
				while(!valid) {//begin valid robot loop
					
					if(esc2 == 3) {
						
						System.out.println("\nIt looks like youve entered an invalid charachter 3 times. \n\n"
								+ "Enter 'e' if you would like to exit the game: \n\n Enter 'c' if you would like to continue: ");
						
						if(scan.nextLine().compareTo("c")==0){
							
							esc = 2;
						
						}else {
							
							System.exit(0); 
							
						}
					}
					
					esc2++;
					
					String type = scan.nextLine().toLowerCase();
		
					
					if(type.compareTo("bipedal") == 0) {
						
						 robs.add(new Bipedal(name, type));
						 valid = true;
						
					}else if(type.compareTo("unipedal") == 0){
						
						 robs.add(new Unipedal(name, type));
						 valid = true;
						
					}else if(type.compareTo("radial") == 0){
						
						 robs.add(new Radial(name, type));
						 valid = true;
						
					}else if(type.compareTo("arachnid") == 0){
						
						 robs.add(new Arachnid(name, type));
						 valid = true;
						
					}else if(type.compareTo("aeronautical") == 0){
						
						 robs.add(new Aeronautical(name, type));
						 valid = true;
						
					}else if(type.compareTo("quadrupedal") == 0){
						
						 robs.add(new Quadrupedal(name, type));
						 valid = true;
						
					}else {
						
						System.out.print("Sorry! We don't make " + type + " robots yet! Please enter a valid robot type: ");
						valid = false;//try again!!
						
					}
					
				}//end valid robot loop
	
			
			}//end collection loop
			
			System.out.println("---------------------------------------------------------------\n");
			
			
			System.out.println();
			System.out.println("              Initiating robot creation sequence...\n");
			
			//the programs first time delay(for aesthetic reasons).
			//all other time delays start here
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			
		    System.out.println("      [ ]       .O.         _         |       _(::)_        _\\./_");
			System.out.println("       |       /_|_\\      // \\\\      / \\      //||\\\\       \\ \\|/ /");
			System.out.println("      /_\\                                                  /_/|\\_\\");
			
			            }
			        }, 
			        
			        1000
			);
			

			System.out.println("\n");
			

			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	System.out.println("\n\n");
							System.out.println("                  Creation sequence complete.\n");
							
	
			            }
			        }, 
			        
			        2250
			);
			
			//if more than one robot has been created we begin "The Great Robot Race!" each robot will begin their time delayed tasks 
			//declaring their progress until all robots have been created and all assigned tasks have been completed 
			//in an attempt to win the affections of their new owner. Call race()! 
			
			race(quantity, robs);
			
			
			//once the race is complete we can end game or play again. 
			//This dialogue must be time delayed to occur once all other timed functions have executed. (70000ms)
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	
			            	System.out.println("\n");
			                System.out.println("Do you want to play? Enter 'yes' or 'no': ");
	
			            }
			        }, 
			        
			        82500 + 3500
			);
			
	
			
			//accept only a valid response. Loop until a valid response has been entered. 
			String playAgain = scan.nextLine();
			
			boolean validEnd = false;
			long esc3 = 0; 
	
	
		while(!validEnd) {//begin play again valid response loop
			
			if(esc3 == 3) {
				
				System.out.println("\n It looks like youve entered an invalid charachter 3 times. \n\n"
						+ "Enter 'e' if you would like to exit the game: \n\n Enter 'c' if you would like to continue: ");
				
				if(scan.nextLine().compareTo("c")==0){
					
					esc3 = 0; 
				
				}else {
					
					
					System.exit(0);
					
				}
			}
			
			esc3++;
		
			    if(playAgain.compareTo("no")==0) {
			    	
			    	play = false;
			    	validEnd = true;
			    	
			    	System.out.println("\n");
			    	System.out.println("Thanks for coming to the Robot Friend Factory! We hope you have a great day!");
			    	System.exit(0); 
			    	
			    	
			    }else if (playAgain.compareTo("yes")==0) {
			    	
			    	play = true;
			    	validEnd = true;
			    	
			    	}else {
			    		
			    		System.out.println("\n");
			    		System.out.println("Sorry! That's not a valid respons. Please enter 'yes' or 'no': ");
			    		
			    		playAgain = scan.nextLine();
			    		validEnd = false;//try again!
			    		
			    	}
			
			}//end play again valid response loop
		
		
		}//end play
		
		
	}//end main
	
	
	
	
	
	
	
	//if more than one robot has been created we begin "The Great Robot Race!" each robot will begin their time delayed tasks 
	//declaring their progress until all robots have been created and all assigned tasks have been completed 
	//in an attempt to win the affections of their new owner
	
	public static void race(int quantity, List<RobotFriend> robs) {//begin race method
		
		
		if(quantity > 1) {//begin "The Great Robot Race!" loop
			
			
			//This must be timed to account for robot creation sequence
			
			new java.util.Timer().schedule(
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	System.out.println("\n\n\n");
			            	
			            	System.out.println("---------------------------------------------------------------\n");
			
							System.out.println("         Your robots will now battle for your affections.\n\n"
									+          "                 Begin the Great Robot Race!\n\n");
		
			            }
			        }, 
			        
			       2750
			);//750ms timer end
			
			
			//let the race begin!!! It's technically an unfair race since each robot will have a different start time
			//but since task assignment is random, it works out right? 
			Iterator<RobotFriend> itr2 = robs.iterator();
		

			while(itr2.hasNext()) {
				
				
				RobotFriend rob = itr2.next();
				
				String[] task = rob.getTasks();
				
				Map<String, Integer> time = rob.getSchedual();
				
				
				//begin!!!
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	
				            	
				            	System.out.println("\n\n");
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() + " the " + rob.getType() + " will now begin to " + task[0] + "!\n\n\n" );
				            	
				            }
				        }, 
				        
				        time.get(task[0]) + 3000
				         
				);//end race start timer
				
				
				//robot begins next task
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	
				            	
				                System.out.println();
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() + " has completed " + task[0] + " in " + time.get(task[0]) + "ms!\n\n");
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() +" will now begin to " + task[1] + "!\n\n");

				            }
				        }, 
				        
				        time.get(task[0]) + 4000
				        
				);//end first task timer
				
				//completion of second task. Robot begins 3rd task. 
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				             
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() + " has completed " + task[1] + " in " + time.get(task[1]) + "ms!\n\n");
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() +" will now begin to " + task[2] + "!\n\n");

				            }
				        }, 
				        time.get(task[1]) + time.get(task[0]) +4000
				        
				);//end 2nd task timer
				
				//completion of third task timer. Robot begins 4th task. 
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() + " has completed " + task[2] + " in " + time.get(task[2]) + "ms!\n\n");
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() +" will now begin to " + task[3] + "!\n\n");

				            }
				        }, 
				       time.get(task[2]) + time.get(task[1]) + time.get(task[0]) + 4000
				       
				);//end 3rd task timer
				
				//completion of 4th task. Robot begins 5th and final task.
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() + " has completed " + task[3] + " in " + time.get(task[3]) + "ms!\n\n");;
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() +" will now begin to " + task[4] + "!\n\n");		

				            }
				        }, 
				        time.get(task[3]) + time.get(task[2]) + time.get(task[1]) + time.get(task[0]) + 4000
				        
				);//end 4th task timer
				
				//completion of final task.
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	
				            	rob.getFigure();
				            	System.out.println(" " + rob.getName() + " the " + rob.getType() + " has completed thier tasks!\n\n");

				             
				            }
				        },
				        
				        time.get(task[4]) + time.get(task[3]) + time.get(task[2]) + time.get(task[1]) + time.get(task[0]) + 4000
				        
				);//end of final task timer
				
				
				//each robot will be scored on how much time it took them to complete all tasks
				rob.setScore(time.get(task[4]) + time.get(task[3]) + time.get(task[2]) + time.get(task[1]) + time.get(task[0]));
				
				
			}//end "The Great Robot Race!" loop
			
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	
			            	System.out.println("              Calculating score...");
			            }
			        },
			        
			        82500 + 2000
			        
			);//end of final task timer
			
			//******************************leader board********************************
			
			//sort the dictionary by score and display leader board in order of winner to least winner (there are no losers at the Robot Friend Factory!)
			
			robs.sort(Comparator.comparing(RobotFriend::getScore));
			
			//the leader bored must be delayed long enough that all other tasks before it have executed
			//time is determined by max possible time that a robot can take to complete all 5 tasks assigned plus 
			//all other timed functions (1000ms)
			
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			
							Iterator<RobotFriend> score_itr = robs.iterator();
							
							System.out.println("\n\n");
							
							System.out.println("-------------------------------------------------------\n");
							
							System.out.println("                 Leader Board");
							
							System.out.println("-------------------------------------------------------\n");
							
							
							
							while(score_itr.hasNext()) {
								
								
								RobotFriend robotScore = score_itr.next();
								
								System.out.println();
				
								robotScore.getFigure();
								System.out.println(" " + robotScore.getName() + " ------------------------------------ " + robotScore.getScore() + "ms");
						
								System.out.println();
								
							}//end while
							
			            }
			        }, 
			        82500 + 3000
			        
			);//end leader board timer
			
			
			//******************************leader board********************************
			
			
		}else {//If only one robot was created allow the robot to introduce themselves and begin their tasks with fun dialog 
			
			Iterator<RobotFriend> itr3 = robs.iterator();
			
			RobotFriend rob = itr3.next();
			
			String[] task = rob.getTasks();
			
			Map<String, Integer> time = rob.getSchedual();
			
			//This must be timed to account for robot creation sequence 
			new java.util.Timer().schedule(
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	System.out.println("\n\n\n");
			            	
			            	System.out.println("---------------------------------------------------------------\n");
			
							System.out.println("              Watch how quickly your new robot can do your chores!\n\n\n\n");
		
			            }
			        }, 
			        
			        2750
			        
			);//timer end
			
			
			//the robot will begin 
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() + " the " + rob.getType() + " begins to " + task[0] + "!\n\n" );

			            }
			        }, 
			        
			         3000
			         
			);//end start timer
			
			
			//robot begins next task
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			                
			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() + " has completed " + task[0] + " in " + time.get(task[0]) + "ms!\n\n");
			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() +" will now begin to " + task[1] + "!\n\n");

			            }
			        }, 
			        
			        time.get(task[0]) + 3000
			        
			);//end first task timer
			
			//completion of second task. Robot begins 3rd task. 
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			                
			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() + " has completed " + task[1] + " in " + time.get(task[1]) + "ms!\n\n");

			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() +" will now begin to " + task[2] + "!\n\n");

			            	
			            }
			        }, 
			        time.get(task[1]) + time.get(task[0]) + 3000
			        
			);//end 2nd task timer
			
			//completion of third task timer. Robot begins 4th task. 
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	
			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() + " has completed " + task[2] + " in " + time.get(task[2]) + "ms!\n\n");

			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() +" will now begin to " + task[3] + "!\n\n");

			     
			            }
			        }, 
			       time.get(task[2]) + time.get(task[1]) + time.get(task[0]) + 3000
			       
			);//end 3rd task timer
			
			//completion of 4th task. Robot begins 5th and final task.
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	
			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() + " has completed " + task[3] + " in " + time.get(task[3]) + "ms!\n\n");
	
			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() +" will now begin to " + task[4] + "!\n\n");
			     
			            }
			        }, 
			        time.get(task[3]) + time.get(task[2]) + time.get(task[1]) + time.get(task[0]) + 3000
			        
			);//end 4th task timer
			
			//completion of final task.
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	rob.getFigure();
			            	System.out.println(" " + rob.getName() + " the " + rob.getType() + " has completed thier tasks!\n\n");

			             
			            }
			        }, 
			        time.get(task[4]) + time.get(task[3]) + time.get(task[2]) + time.get(task[1]) + time.get(task[0]) + 3000
			        
			);//end of final task timer
			
			rob.setScore(time.get(task[4]) + time.get(task[3]) + time.get(task[2]) + time.get(task[1]) + time.get(task[0]));
			
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	
			            	System.out.println("Your robot completed your chores in " + rob.getScore() + "ms!");
			            }
			        },
			        
			        82500 + 1000
			        
			);//end of final task timer
			
		}//end of single robots dialogue 
		
	}//end race function. Return to main. 
	

}//end
