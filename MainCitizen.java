import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class MainCitizen {
	
	public static void main(String [] args)
	{
		try {
			//create reader
			BufferedReader in = new BufferedReader(new FileReader("C:\\\\Users\\\\User\\\\eclipse-workspace\\\\PROJECT3\\\\src\\\\Citizen.txt"));
			//create LinkedList
			LinkedList<Citizen> citizenlist = new LinkedList<Citizen>();
			LinkedList <Citizen> Completelist = new LinkedList <Citizen>();
			LinkedList <Citizen> firstdose = new LinkedList <Citizen>();
			LinkedList <Citizen> secdose = new LinkedList <Citizen>();
			
			//create stack
			Stack <Citizen> stCenter1 = new Stack <Citizen>();
			Stack <Citizen> stCenter2 = new Stack <Citizen>();
			Stack <Citizen> stCenter3 = new Stack <Citizen>();
			Stack <Citizen> First = new Stack <Citizen>();
			Stack <Citizen> Second = new Stack <Citizen>();
			Stack <Citizen> certificate = new Stack <Citizen>();
			
			//create queue
			Queue <Citizen> qCenter1 = new LinkedList <Citizen>();
			Queue <Citizen> qCenter2 = new LinkedList <Citizen>();
			Queue <Citizen> qCenter3 = new LinkedList <Citizen>();
			Queue <Citizen> Complete1 = new LinkedList <Citizen>();
			Queue <Citizen> Complete2 = new LinkedList <Citizen>();
			Queue <Citizen> Complete3 = new LinkedList <Citizen>();
			Queue <Citizen> Complete4 = new LinkedList <Citizen>();
			
			Citizen ctzn;
			String indata = null;
			
			//read data from file and store into LinkedList
			while((indata = in.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer(indata, ";");
				String citizenName = st.nextToken();
				String ICNum = st.nextToken();
				String state = st.nextToken();
				int age = Integer.parseInt(st.nextToken());
				String category = st.nextToken();
				String FirstDose = st.nextToken();
				String SecondDose = st.nextToken();
				String Certificate = st.nextToken();
				
				ctzn = new Citizen(citizenName,ICNum,state,age,category,FirstDose,SecondDose,Certificate);
				ctzn.setcitizenlist(citizenName,ICNum,state,age,category,FirstDose,SecondDose,Certificate);
				//create object
				citizenlist.add(ctzn);
			}
		in.close();
			
		 for(int i=0; i<citizenlist.size(); i++) {
             ctzn = citizenlist.get(i);
             if(ctzn.getAge() >=18 && 30 >= ctzn.getAge()) {
                  stCenter1.push(ctzn);
                  
             }
         else if(ctzn.getAge() >=31 && 49 >= ctzn.getAge()) {
              stCenter2.push(ctzn);
                }
         else if(ctzn.getAge() >=50) {
              stCenter3.push(ctzn);
              }
         	}
			 citizenlist.clear();
		 
			int menu = 0;
			do {
				menu = Integer.parseInt(JOptionPane.showInputDialog("Choose : \n Menu 1 - ADD CITIZEN \n Menu 2 - REMOVE CITIZEN \n Menu 3 - FIRST DOSE STATUS \n Menu 4 - SECOND DOSE STATUS \nMenu 5 - EXIT"));
				
				if (menu == 1) //add new recipient 
					{
					String citizenName = JOptionPane.showInputDialog("Please enter citizen name");
					String ICNum = JOptionPane.showInputDialog("Please enter citizen IC number");
					String state = JOptionPane.showInputDialog("Please enter state");
					int age = Integer.parseInt(JOptionPane.showInputDialog("Please enter citizen age"));
					String category = JOptionPane.showInputDialog("Please enter category");
					String FirstDose1 = null;
					String SecondDose1 = null;
					String Certificate1 = null;
					
					ctzn = new Citizen(citizenName,ICNum,state,age,category,FirstDose1,SecondDose1,Certificate1);
					//create object
					citizenlist.add(ctzn);
					ctzn.setcitizenlist(citizenName, ICNum, state, age, category, FirstDose1, SecondDose1, Certificate1);
		            citizenlist.add(ctzn);
		             
		             System.out.println(citizenlist.toString());
		             
		             for(int i=0; i<citizenlist.size(); i++) {
		                 ctzn = citizenlist.get(i);
		                 if(ctzn.getAge() >=18 && 30 >= ctzn.getAge()) {
		                      stCenter1.push(ctzn);
		                 }
		             else if(ctzn.getAge() >=31 && 49 >= ctzn.getAge()) {
		                  stCenter2.push(ctzn);
		                    }
		             else if(ctzn.getAge() >=50) {
		                  stCenter3.push(ctzn);
		                  }
		             }
		             citizenlist.clear();
				}
				else if(menu == 2) //remove citizen
				{
					//ask user to enter IC number
					String ICNum = JOptionPane.showInputDialog("Enter citizen IC number");
					for(int i=0;i<citizenlist.size();i++)
					{
						ctzn = citizenlist.get(i);//retrieve object
						if(ctzn.getICNum(ICNum).equalsIgnoreCase(ICNum))
						{
							citizenlist.remove(ctzn);//remove object
						}
					}
			        System.out.println(citizenlist.toString());

				}
				else if(menu == 3) //update first dose
				{
					int user = JOptionPane.showConfirmDialog(null, "Are you sure to update first dose status for all citizens?", "", JOptionPane.YES_NO_OPTION);
					if(user == 0) {
						for(int i=0;i<stCenter1.size();i++) {
							ctzn = stCenter1.get(i);
							ctzn.setFirstDose("Done");
							stCenter1.set(i,ctzn);
							First.add(ctzn);
							qCenter1.add(ctzn);
							Complete1.add(ctzn);
							
							if(i<1)
							{
								firstdose.add(ctzn);
							}
						}
						for(int i=0;i<stCenter2.size();i++) {
							ctzn = stCenter2.get(i);
							ctzn.setFirstDose("Done");
							stCenter2.set(i,ctzn);
							Second.add(ctzn);
							qCenter2.add(ctzn);
							Complete2.add(ctzn);
						}
						for(int i=0;i<stCenter3.size();i++) {
							ctzn = stCenter3.get(i);
							ctzn.setFirstDose("Done");
						}
					System.out.println("s1" + stCenter1);
					System.out.println("s2" + stCenter2);
					System.out.println("s3" + stCenter3);
					}
					
					}
				
			else if (menu == 4)//update second dose
			{
				int user = JOptionPane.showConfirmDialog(null, "Are you sure to update second dose status for all citizens?", "", JOptionPane.YES_NO_OPTION);
				if(user == 0) {
					for(int i=0;i<qCenter1.size();i++) {
						ctzn = qCenter1.element();
						ctzn.setSecondDose("Done");
						ctzn.setCertificate("VACCINATED");
						ctzn = qCenter1.remove();
						Completelist.add(ctzn);
					}
					for(int i=0;i<qCenter2.size();i++) {
						ctzn = qCenter2.element();
						ctzn.setSecondDose("Done");
						ctzn.setCertificate("VACCINATED");
						ctzn = qCenter2.remove();
						Completelist.add(ctzn);
					}
					for(int i=0;i<qCenter3.size();i++) {
						ctzn = qCenter3.element();
						ctzn.setSecondDose("Done");
						ctzn.setCertificate("VACCINATED");
						ctzn = qCenter3.remove();
						Completelist.add(ctzn);
					}
				System.out.println("s11" + qCenter1);
				System.out.println("s22" + qCenter2);
				System.out.println("s33" + qCenter3);
				}				
						
					System.out.println(Completelist);
				}
	            
			}while ( menu != 5);
		
	        }  
			catch (Exception ex)
			{
				System.out.println (ex.getMessage());
			}
			}
}					