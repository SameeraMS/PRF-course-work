import java.util.*;
class Main{
    static Scanner input = new Scanner(System.in);
    static Random r = new Random();
    static String[][] sup = new String[0][2];		//[][0]-id [][1]-name
    static String[] category = new String[0];
    static String[][] item = new String[0][6];		//[][0]-itemcode [][1]-supid [][2]-category [][3]-description [][4]-unitprice [][5]-qty		
	static double[] price = new double[0];

	static String[] user = {"sameera","1234"};
      
    public static void clearconsole() {
            final String os = System.getProperty("os.name");
            try {
                if (os.equals("Linux")) {
                    System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else { System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                } catch (final Exception e) {
                        //handle the exception
                        System.err.println(e.getMessage());
                    }
    }
    
													//login
    
    public static void login() {
		clearconsole();

        System.out.printf("+-------------------------------------+%n");
        System.out.printf("|             LOGIN PAGE              |%n");
        System.out.printf("+-------------------------------------+%n");

		username();
		
	}
	
    public static void username() {
		
        System.out.print("\nUser Name\t:");
        String un = input.next();
        
        if (un.equals(user[0])){
			password();
		} else {
			System.out.println("user name is invalid. please try again!");
			username();
			}
    }
    
    public static void password() {
		
		System.out.print("\nPassword\t:");
		String pw = input.next();
		
		if (pw.equals(user[1])){
			homepage();
		} else {
			System.out.println("password is incorrect. please try again!");
			password();
			}	
	}
	
													//homepage
	
	public static void homepage() {
		
		clearconsole();
		
		System.out.printf("+------------------------------------------------------------------+%n");
        System.out.printf("|             WELCOME TO IJSE STOCK MANAGEMENT SYSTEM              |%n");
        System.out.printf("+------------------------------------------------------------------+%n");
		
		System.out.println("\n[1] Change the Credentials\t\t[2] Supplier Manage");
		System.out.println("[3] Stock Manage\t\t\t[4] Log out");
		System.out.println("[5] Exit the system");
		
		option();
	}
	
	public static void option(){
		System.out.print("\nEnter an option to continue > ");
		char op = input.next().charAt(0);
		
		switch(op){
			case '1':
					credential();
					break;
			case '2':
					supplier();
					break;
			case '3':
					stock();
					break;
			case '4':
					login();
					break;
			case '5':
					return;
			default: 
					System.out.print("Invalin option.\n");
					option();
			}
	}

													//credential
	
    public static void credential(){
		
		clearconsole();
		
		System.out.printf("+--------------------------------------------+%n");
        System.out.printf("|             CREDENTIAL MANAGE              |%n");
        System.out.printf("+--------------------------------------------+%n");
        
        newname();
	}
	
	public static void newname(){
		
		System.out.print("Please enter the user name to verify it's you: ");
		String newun = input.next();
		
		if(newun.equals(user[0])){
			System.out.println("Hey "+user[0]);
			newpass();
		} else {
			System.out.println("invalid user name. try again!");
			newname();
			}
	}

	public static void newpass(){
		
		System.out.print("Enter your current password: ");
		String curpw = input.next();
		
		if(curpw.equals(user[1])){
			System.out.print("Enter your new password: ");
			String newpw = input.next();
			
			user[1] = newpw;
			
			System.out.print("Password changed successfully!");
			
			gohome();
		} else {
			System.out.println("incorrect pssword. try again!");
			System.out.println();
			newpass();
			}
		
	}
	
	public static void gohome(){
			
			System.out.print(" Do you want to go home page (Y/N):");
			char op = input.next().charAt(0);
			
			if(op=='Y' || op=='y'){
				homepage();
			} else if(op=='N' || op=='n'){
				return;
				} else {
					System.out.println("invalid input!");
					
					gohome();
					}
		
	}
	
													//suppliers
	
	public static void supplier(){
		
		clearconsole();
		
		System.out.printf("+------------------------------------------+%n");
        System.out.printf("|             SUPPLIER MANAGE              |%n");
        System.out.printf("+------------------------------------------+%n");
        
        System.out.println("\n[1] Add Supplier\t\t[2] Update Supplier");
		System.out.println("[3] Delete Supplier\t\t[4] View Suppliers");
		System.out.println("[5] Search Supplier\t\t[6] Home Page");
		
		suppmanage();
	}
	
	public static void suppmanage(){
		
		System.out.print("\nEnter an option to continue > ");
		char op = input.next().charAt(0);
		
		switch(op){
			case '1':
					addsup();
					break;
			case '2':
					upsupp();
					break;
			case '3':
					delsupp();
					break;
			case '4':
					viewsupp();
					break;
			case '5':
					searchsupp();
					break;
			case '6':
					homepage();
					break;
			default: 
					System.out.print("Invalid option.\n");
					suppmanage();
			}
		
	}
	
	//add supplier
	
	public static void addsup(){
		
		clearconsole();
		
		System.out.printf("+---------------------------------------+%n");
        System.out.printf("|             ADD SUPPLIER              |%n");
        System.out.printf("+---------------------------------------+%n");
	
		newsuppid();
		
		System.out.print("added successfully! ");
		
		addanothersupp();
		
	}
		
	public static void addanothersupp(){
		
		System.out.print("Do you want to add another supplier(Y/N)?");
		char op = input.next().charAt(0);
		
			if(op=='Y' || op=='y'){
				addsup();
			} else if (op=='N' || op=='n'){
				supplier();
				} else {
					System.out.println("invalid input. try again!");
					addanothersupp();
					}
		}
		
	public static void newsuppid(){
	
		boolean excist = false;
		
		l1:
		do{
			System.out.print("\nSupplier ID\t:");
			String nsupid = input.next();
			
			for(int i=0;i<sup.length;i++){
				if(nsupid.equals(sup[i][0])){
					System.out.println("already exists. try another supplier id!");
					excist=true;
					break;
					}
			}
				if(excist){
					excist=false;
					continue l1;
				} else {
					sup=grow(sup);
					sup[sup.length-1][0]=nsupid;
					
					System.out.print("Supplier Name\t:");
					String nsupname = input.next();
		
					sup[sup.length-1][1]=nsupname;
					System.out.print("added successfully! ");
		
					addanothersupp();
					
			}
		} while(true);
		
	}

	public static String[][] grow(String[][] sup){
		
		String[][] temp = new String[sup.length + 1][2];
		for (int i = 0; i < sup.length; i++){
			for (int j = 0; j < sup[i].length; j++){
			temp[i][j] = sup[i][j];
			}
		}
		return temp;
	}
	
	//update supplier
	
	public static void upsupp(){
		
		clearconsole();
		
		System.out.printf("+------------------------------------------+%n");
        System.out.printf("|             UPDATE SUPPLIER              |%n");
        System.out.printf("+------------------------------------------+%n");
        
        upsupname();
	}
	
	public static void upsupname(){
		
		boolean excist = false;
		
		l1:
		do{
			System.out.print("\nSupplier ID\t: ");
			String sid=input.next();
		
		for(int i=0;i<sup.length;i++){
			if(sid.equals(sup[i][0])){
				System.out.println("Supplier Name\t: "+sup[i][1]);
				
				System.out.print("\nEnter the new Supplier Name: ");
				String sname=input.next();
				
				sup[i][1]=sname;
				
				System.out.print("Updated Successfully! ");
				excist=true;
				upanothersupp();
				}
			}
			 if(excist){
					excist=false;
					continue l1;
				} else {
				System.out.println("can't find supplier id. try again!");
				upsupname();
				}
			
		} while(true);
	}
				
	public static void upanothersupp(){		
			
			System.out.print("Do you want to update another supplier?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				upsupp();
					} else if (op=='N' || op=='n'){
				supplier();
				} else {
					System.out.println("invalid input. try again!");
					upanothersupp();
					}		
	}
	
	//delete supplier
	
	public static void delsupp(){
		
		clearconsole();
		
		System.out.printf("+------------------------------------------+%n");
        System.out.printf("|             DELETE SUPPLIER              |%n");
        System.out.printf("+------------------------------------------+%n");
        
        delsupid();
        
	}
	
	public static void delsupid(){
		
		int delcount=0;
		
		boolean excist = false;
		
		l1:
		do{

		System.out.print("\nSupplier ID\t: ");
		String sid=input.next();
		
		for(int i=0;i<sup.length;i++){
			if(sid.equals(sup[i][0])){
				int x =i;
				sup=shrinksup(x);
				
				System.out.print("deleted Successfully! ");
				delcount++;
				excist=true;
				delanothersup();
			}
		} 
			if(excist){
					excist=false;
					continue l1;
				} else {
				System.out.println("can't find supplier id. try again!");
				if(delcount!=sup.length){
					delsupid();
				} else {
					System.out.println("All suppliers deleted! ");
					deltohome();
					}
				
				}
		
		} while(true);
	
	}
	
	public static void deltohome(){
		
		System.out.print("Do you want to go supplier menu?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				supplier();
					} else if (op=='N' || op=='n'){
				homepage();
				} else {
					System.out.println("invalid input. try again!");
					deltohome();
					}
	}
	
	public static String[][] shrinksup(int x){	
		
		String[][] temp2 = new String[sup.length - 1][2];
		
		int k=0;
		l1:
		for (int i = 0; i < sup.length; i++){
			for (int j = 0; j < sup[i].length; j++){
				if(i==x){
					continue l1;
					} else {
				temp2[k][j] = sup[i][j];
				}
			}
			k++;
		}
		return temp2;
	}
	
	public static void delanothersup(){	
		
		System.out.print("Do you want to update another supplier?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				delsupp();
					} else if (op=='N' || op=='n'){
				supplier();
				} else {
					System.out.println("invalid input. try again!");
					delanothersup();
					}	
	}
	
	//view supplier
	
	public static void viewsupp(){
		
		clearconsole();
		
		System.out.printf("+------------------------------------------+%n");
        System.out.printf("|             VIEW SUPPLIER                |%n");
        System.out.printf("+------------------------------------------+%n");
        
		System.out.println();
		
		System.out.printf("+-----------------+-----------------+%n");
		System.out.printf("| %-15s | %-15s |%n", "SUPPLIER ID", "SUPPLIER NAME");
		System.out.printf("+-----------------+-----------------+%n");
        
        for(int i=0;i<sup.length;i++){
			System.out.printf("| %-15s | %-15s |%n", sup[i][0], sup[i][1]);
		}
		
		System.out.printf("+-----------------+-----------------+%n");
		
		gosupmenu();
	}
	
	public static void gosupmenu(){

		System.out.print("\nDo you want to go supplier manage page(Y/N)? ");
		char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				supplier();
					} else if (op=='N' || op=='n'){
				homepage();
				} else {
					System.out.println("invalid input. try again!");
					gosupmenu();
					}
		
		
	}
	
	//search supplier
	
	public static void searchsupp(){
		
		clearconsole();
		
		System.out.printf("+------------------------------------------+%n");
        System.out.printf("|             SEARCH SUPPLIER              |%n");
        System.out.printf("+------------------------------------------+%n");
        
        searchsupid();
	}
	
	public static void searchsupid(){
		
		boolean excist = false;
		
		l1:
		do{
		System.out.print("\nSupplier ID\t: ");
		String sid=input.next();
		
		for(int i=0;i<sup.length;i++){
			if(sid.equals(sup[i][0])){
				System.out.println("Supplier Name\t: "+sup[i][1]);
				
				System.out.print("added Successfully! ");
				excist=true;
				searchanothersupp();
			}
		}
		if(excist){
					excist=false;
					continue l1;
				} else {
				System.out.println("can't find supplier id. try again!");
				}
			
		} while(true);
	}
	
	public static void searchanothersupp(){
		
		System.out.print("Do you want to search another supplier?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				searchsupp();
					} else if (op=='N' || op=='n'){
				supplier();
				} else {
					System.out.println("invalid input. try again!");
					searchanothersupp();
					}		
					
	}
	
	
															//stock
	
	public static void stock(){
		
		clearconsole();
		
		System.out.printf("+-------------------------------------------+%n");
        System.out.printf("|             STOCK MANAGEMENT              |%n");
        System.out.printf("+-------------------------------------------+%n");
        
        System.out.println("\n[1] Manage Item Categories \t\t[2] Add item");
		System.out.println("[3] Get Items Supplier Wise\t\t[4] View Items");
		System.out.println("[5] Rank Items Per Unit Price\t\t[6] Home Page");
		
		stockoption();
		
	}
	
	public static void stockoption(){
		
		System.out.print("\nEnter an option to continue > ");
		char op = input.next().charAt(0);
		
		switch(op){
			case '1':
					manageitem();
					break;
			case '2':
					additem();
					break;
			case '3':
					getitem();
					break;
			case '4':
					viewitem();
					break;
			case '5':
					rankitem();
					break;
			case '6':
					homepage();
					break;
			default: 
					System.out.print("Invalid option.\n");
					stockoption();
			}
		
	}
	
	//manege item
	
	public static void manageitem(){
		
		clearconsole();
		
		System.out.printf("+-----------------------------------------------+%n");
        System.out.printf("|             MANAGE ITEM CATEGORY              |%n");
        System.out.printf("+-----------------------------------------------+%n");
        
        System.out.println("\n[1] Add New Item Category\t\t[2] Delete Item Category");
		System.out.println("[3] Update Item Category\t\t[4] Stock Management");
		
		manageitemoption();
	}
	
	public static void manageitemoption(){
		
		System.out.print("\nEnter an option to continue > ");
		char op = input.next().charAt(0);
		
		switch(op){
			case '1':
					additemcategory();
					break;
			case '2':
					delitemcategory();
					break;
			case '3':
					upitemcategory();
					break;
			case '4':
					stock();
					break;
			default: 
					System.out.print("Invalid option.\n");
					manageitemoption();
			}
	}
	
	//add category
	
	public static void additemcategory(){
		
		clearconsole();
		
		System.out.printf("+--------------------------------------------+%n");
        System.out.printf("|             ADD ITEM CATEGORY              |%n");
        System.out.printf("+--------------------------------------------+%n");
        
        addcategory();
        
	}
	
	public static void addcategory(){
		
		boolean excist = false;
		
		l1:
		do{
			System.out.print("\nEnter the new item category: ");
			String cat = input.next();
			
			for(int i=0;i<sup.length;i++){
				if(cat.equals(category[i])){
					System.out.println("already exists. try another item category!");
					excist=true;
					break;
					}
			}
				if(excist){
					excist=false;
					continue l1;
				} else {
					category=growcat();
					category[category.length-1]=cat;
					
					System.out.print("added successfully! ");
		
					addanothercategory();
					
			}
		} while(true);
	}
	
	public static String[] growcat(){
		
		String[] ctemp = new String[category.length + 1];
		for (int i = 0; i < category.length; i++){
			ctemp[i] = category[i];
		}
		return ctemp;
	}
	
	public static void addanothercategory(){
		
		System.out.print("Do you want to add another category(Y/N)?");
		char op = input.next().charAt(0);
		
			if(op=='Y' || op=='y'){
				additemcategory();
			} else if (op=='N' || op=='n'){
				manageitem();
				} else {
					System.out.println("invalid input. try again!");
					addanothercategory();
					}
	}
	
	//delete category
	
	public static void delitemcategory(){
		
		clearconsole();
		
		System.out.printf("+-----------------------------------------------+%n");
        System.out.printf("|             DELETE ITEM CATEGORY              |%n");
        System.out.printf("+-----------------------------------------------+%n");
        
        delcat();
	}
	
	public static void delcat(){
		
		int delcount=0;
		
		boolean excist = false;
		
		l1:
		do{

		System.out.print("\nEnter category you want to delete: ");
		String dcat=input.next();
		
		for(int i=0;i<category.length;i++){
			if(dcat.equals(category[i])){
				int x =i;
				category=shrinkcat(x);
				
				System.out.print("deleted Successfully! ");
				delcount++;
				excist=true;
				delanothercat();
			}
		} 
			if(excist){
					excist=false;
					continue l1;
				} else {
				System.out.println("can't find category. try again!");
				if(delcount!=category.length){
					delcat();
				} else {
					System.out.println("All categories deleted! ");
					catdeltohome();
					}
				
				}
		
		} while(true);
	}
	
	public static void catdeltohome(){
		
		System.out.print("Do you want to go manage item menu?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				manageitem();
					} else if (op=='N' || op=='n'){
				homepage();
				} else {
					System.out.println("invalid input. try again!");
					catdeltohome();
					}
	}
	
	public static void delanothercat(){
		
		System.out.print("Do you want to delete another category?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				delitemcategory();
					} else if (op=='N' || op=='n'){
				manageitem();
				} else {
					System.out.println("invalid input. try again!");
					delanothercat();
					}	
	}
	
	public static String[] shrinkcat(int x){
		
		String[] ctemp2 = new String[category.length - 1];
		
		int k=0;
		for (int i = 0; i < category.length; i++){
				if(i==x){
					continue;
					} else {
				ctemp2[k] = category[i];
				k++;
				}
			}
		return ctemp2;
	}
	
	//update category
	
	public static void upitemcategory(){
		
		clearconsole();
		
		System.out.printf("+-----------------------------------------------+%n");
        System.out.printf("|             UPDATE ITEM CATEGORY              |%n");
        System.out.printf("+-----------------------------------------------+%n");
        
        upcat();
	}
	
	public static void upcat(){
		
		boolean excist = false;
		
		l1:
		do{
			System.out.print("\nEnter category to update: ");
			String ucat=input.next();
		
		for(int i=0;i<category.length;i++){
			if(ucat.equals(category[i])){
				
				System.out.print("\nEnter the new category Name: ");
				String nucat=input.next();
				
				category[i]=nucat;
				
				System.out.print("Updated Successfully! ");
				excist=true;
				upanothercat();
				}
			}
			 if(excist){
					excist=false;
					continue l1;
				} else {
				System.out.println("can't find the category. try again!");
				upcat();
				}
			
		} while(true);
	}
	
	public static void upanothercat(){
		
		System.out.print("Do you want to update another category?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				upitemcategory();
					} else if (op=='N' || op=='n'){
				manageitem();
				} else {
					System.out.println("invalid input. try again!");
					upanothercat();
					}
	}
	
	//add item
	
	public static void additem(){
		
		clearconsole();
		
		System.out.printf("+--------------------------------------------+%n");
        System.out.printf("|                 ADD ITEM                   |%n");
        System.out.printf("+--------------------------------------------+%n");
        
        checkcategory();
	}
	
	public static void additem2(){
		
		clearconsole();
		
		System.out.printf("+--------------------------------------------+%n");
        System.out.printf("|                 ADD ITEM                   |%n");
        System.out.printf("+--------------------------------------------+%n");
        
        System.out.println();
        
	}
	
	public static void checkcategory(){
		
		if(category.length>0){
			checksuplier();
			
		} else {
			System.out.println("OOPS! It seems that you don't have any item categories in the system.");
			
			addoncheckcat();
			}
			
	}
	
	public static void checksuplier(){
		
		additem2();
		
		if(sup.length>0){
			addtheitem();
			
			} else {
				System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
			
				addonchecksup();
				}
	}
	
	public static void addonchecksup(){
		
		System.out.print("Do you want to add a new supplier?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				addsup();
					} else if (op=='N' || op=='n'){
				stock();
				} else {
					System.out.println("invalid input. try again!");
					addonchecksup();
					}
	}
	
	public static void addoncheckcat(){
		
		System.out.print("Do you want to add a new item category?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				additemcategory();
					} else if (op=='N' || op=='n'){
				stock();
				} else {
					System.out.println("invalid input. try again!");
					addoncheckcat();
					}
	}
	
	public static String[][] growitem(){
		
		String[][] itemp = new String[item.length + 1][6];
		for (int i = 0; i < item.length; i++){
			for (int j = 0; j < item[i].length; j++){
			itemp[i][j] = item[i][j];
			}
		}
		return itemp;
	}
	
	public static void addtheitem(){
		
		boolean excist = false;
		
		l1:
		do{
			System.out.print("Item Code\t: ");
			String nitc = input.next();
			
			for(int i=0;i<item.length;i++){
				if(nitc.equals(item[i][0])){
					System.out.println("already exists. try another item code!");
					excist=true;
					break;
					}
			}
				if(excist){
					excist=false;
					continue l1;
				} else {
					item=growitem();
					item[item.length-1][0]=nitc;
					
					suplist();
					
					System.out.print("\nEnter the supplier number > ");
					int supnum = input.nextInt();
					
					item[item.length-1][1]=sup[supnum-1][0];
		
					catlist();
					
					System.out.print("\nEnter the category number > ");
					int catnum = input.nextInt();
					
					item[item.length-1][2]=category[catnum-1];
					
					System.out.print("\nDescription\t: ");
					String desc = input.next();
					item[item.length-1][3]=desc;
					
					System.out.print("Unit price\t: ");
					double unip = input.nextDouble();
					item[item.length-1][4]=String.valueOf(unip);
					price=itempriceargrow();
					price[price.length-1]=unip;
					
					System.out.print("Qty on hand\t: ");
					int qty = input.nextInt();
					item[item.length-1][5]=String.valueOf(qty);
					
					System.out.print("added successfully! ");
		
					addanotheritem();
					
			}
		} while(true);
	}
	
	public static void addanotheritem(){
		
		System.out.print("Do you want to add another Item(Y/N)?");
		char op = input.next().charAt(0);
		
			if(op=='Y' || op=='y'){
				additem2();
				addtheitem();
			} else if (op=='N' || op=='n'){
				stock();
				} else {
					System.out.println("invalid input. try again!");
					addanotheritem();
					}
	}
	
	public static void catlist(){
		
		System.out.println("\nItem Categories: ");
		
		System.out.printf("+------+-----------------+%n");
		System.out.printf("| %-4s | %-15s |%n", "#", "CATEGORY NAME");
		System.out.printf("+------+-----------------+%n");
        
        for(int i=0;i<category.length;i++){
			System.out.printf("| %-4s | %-15s |%n", (i+1), category[i]);
		}
		
		System.out.printf("+------+-----------------+%n");
		
	}
	
	public static void suplist(){
		
		System.out.println("\nSupplier list: ");
		
		System.out.printf("+------+-----------------+-----------------+%n");
		System.out.printf("| %-4s | %-15s | %-15s |%n", "#", "SUPPLIER ID", "SUPPLIER NAME");
		System.out.printf("+------+-----------------+-----------------+%n");
        
        for(int i=0;i<sup.length;i++){
			System.out.printf("| %-4s | %-15s | %-15s |%n", (i+1), sup[i][0], sup[i][1]);
		}
		
		System.out.printf("+------+-----------------+-----------------+%n");
		
	}
	
	//get item
	
	public static void getitem(){
		
		clearconsole();
		
		System.out.printf("+-------------------------------------------+%n");
        System.out.printf("|             SEARCH SUPPLIER               |%n");
        System.out.printf("+-------------------------------------------+%n");
        
        getitemsup();
	}
	
	public static void getitemsup(){
		
		boolean excist = false;
		
		l1:
		do{
		System.out.print("\nSupplier ID\t: ");
		String sid=input.next();
		
		for(int i=0;i<sup.length;i++){
			if(sid.equals(sup[i][0])){
				System.out.println("Supplier Name\t: "+sup[i][1]);
				
				System.out.println();
				supwisetable(sid);

				excist=true;
				System.out.print("search successfully! ");
				searchothersup();
				
			}
		}
		if(excist){
					excist=false;
					continue l1;
				} else {
				System.out.println("can't find supplier id. try again!");
				}
			
		} while(true);
		
	}
	
	public static void supwisetable(String sid){
		
		System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
		System.out.printf("| %15s | %15s | %15s | %15s | %15s |%n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
		System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        
        for(int i=0;i<item.length;i++){
			if(item[i][1].equals(sid)){
			System.out.printf("| %15s | %15s | %15s | %15s | %15s |%n", item[i][0], item[i][3], item[i][4], item[i][5], item[i][2]);
			}
		}
		
		System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
		
	}
	
	public static void searchothersup(){
		
		System.out.print("Do you want to search another supplier?(Y/N) ");
			char op = input.next().charAt(0);
				
			if(op=='Y' || op=='y'){
				getitem();
					} else if (op=='N' || op=='n'){
				stock();
				} else {
					System.out.println("invalid input. try again!");
					searchothersup();
					}	
	}
	
	//view item
	
	public static void viewitem(){
		
		clearconsole();
		
		System.out.printf("+-------------------------------------------+%n");
        System.out.printf("|                VIEW ITEMS                 |%n");
        System.out.printf("+-------------------------------------------+%n");
        
        for(int j=0;j<category.length;j++){
			
			System.out.println("\n"+category[j]+": ");
			String catname=category[j];
			
			System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
			System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n", "SID", "CODE", "DESC", "PRICE", "QTY");
			System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
		
			for(int i=0;i<item.length;i++){
				
				
				if(item[i][2].equals(catname)){
					System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n", item[i][1], item[i][0], item[i][3], item[i][4], item[i][5]);
				}
			}
	
			System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

		}
		
		
		
		System.out.println();
		gostockpage();
        
	}
	
	public static void gostockpage(){
		
		System.out.print(" Do you want to go stock manage page (Y/N):");
			char op = input.next().charAt(0);
			
			if(op=='Y' || op=='y'){
				stock();
			} else if(op=='N' || op=='n'){
				return;
				} else {
					System.out.println("invalid input!");
					gostockpage();
					}
	}
	
	
	//rank item
	
	public static void rankitem(){
		
		clearconsole();
		
		System.out.printf("+---------------------------------------------+%n");
        System.out.printf("|             RANKED UNIT PRICE               |%n");
        System.out.printf("+---------------------------------------------+%n");
        
        rankprice();
	}
	
	public static void rankprice(){
		
			rankar();
			
		
			System.out.println();
			
			System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
			System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", "SID", "CODE", "DESC", "PRICE", "QTY", "CAT");
			System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
			
			for(int i=0;i<price.length;i++){
				for(int j=0;j<price.length;j++){
					if(item[j][4].equals(String.valueOf(price[i]))){
						System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", item[j][1], item[j][0], item[j][3], item[j][4], item[j][5], item[j][2]);
						}
					}
				
				}
			System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

			gostockpage();
			
	}
	
	public static void rankar(){
		
		for(int j=0;j<price.length-1;j++){	
			for(int i=0;i<price.length-1;i++){
				if(price[i]>price[i+1]){
					double temp=price[i];
					price[i]=price[i+1];
					price[i+1]=temp;
				}
			}
		}
		
	}
	
	public static double[] itempriceargrow(){
		
		double[] ptemp = new double[price.length + 1];
		for (int i = 0; i < price.length; i++){
			ptemp[i] = price[i];
		}
		return ptemp;
		
	}
	
	
    public static void main(String args[]){
	
        login();
        

    }
}
